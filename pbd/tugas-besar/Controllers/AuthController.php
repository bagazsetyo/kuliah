<?php 

namespace Controllers;
use Databases\DB;

class AuthController extends Controller {
    public function login() {
        $this->view('auth.login');
    }
}