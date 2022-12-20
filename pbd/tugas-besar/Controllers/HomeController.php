<?php 

namespace pbd\Controllers;

class HomeController {
    public function index() {
        require __DIR__ . '/../views/index.php';
    }
}