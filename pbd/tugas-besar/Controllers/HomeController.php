<?php 

namespace Controllers;
use Databases\DB;

class HomeController extends Controller {
    public function index() {

        $this->view('index');
    }
}