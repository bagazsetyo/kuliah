<?php

namespace Databases;
use PDO;

class DB {
    
    private static function getConnection(): PDO
    {
        $host = 'localhost';
        $port = 3306;
        $db = 'rumahsakit';
        $user = 'root';
        $pass = '';

        return new PDO("mysql:host=$host:$port;dbname=$db",$user,$pass);
    }

    // test connection 
    public static function testConnection()
    {
        $conn = self::getConnection();
        if ($conn) {
            echo 'connected';
        } else {
            echo 'not connected';
        }
    }

    public static function query($query, $params = [])
    {
        $conn = self::getConnection();
        $stmt = $conn->prepare($query);
        $stmt->execute($params);
        return $stmt->fetchAll();
    }
}