<?php 

namespace Controllers;
use Databases\DB;

class HomeController {
    public function index() {

        $data = DB::query("select * from pasien");

        // send param to view index.php 
        require __DIR__ . '/../views/index.php';
    }
}