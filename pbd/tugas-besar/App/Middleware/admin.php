<?php 

namespace App\Middleware;

class Admin {
    public function __construct()
    {
        if (!isset($_SESSION['user']) || $_SESSION['user']['role'] != 'admin') {
            header('Location: /login');
        }
    }
}