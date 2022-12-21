<?php 

namespace Controllers;

use App\Provider\View;

class Controller extends View {

    public function view($view, $data = []) {
        View::render($view, $data);
    }
}