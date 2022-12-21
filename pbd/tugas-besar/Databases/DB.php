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

    public static function testConnection()
    {
        $conn = self::getConnection();
    }

    public static function query($query, $params = [])
    {
        $conn = self::getConnection();
        $stmt = $conn->prepare($query);
        $stmt->execute($params);
        return $stmt->fetchAll();
    }

    public function setTableName($table_name)
    {
        $this->table_name = $table_name;
    }

    public function table($table_name)
    {
        $db = new DB();
        $db->setTableName($table_name);
        return $db;
    }

    public function get()
    {
        $conn = self::getConnection();
        $stmt = $conn->prepare("select * from {$this->table_name}");
        $stmt->execute();
        return $stmt->fetchAll();
    }

    // return all function on this 
    public function __call($name, $arguments)
    {
        $conn = self::getConnection();
        $stmt = $conn->prepare("select * from {$this->table_name} $name");
        $stmt->execute();
        return $stmt->fetchAll();
    }
    
}