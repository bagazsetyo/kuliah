<?php
namespace Routes;

use Controllers\HomeController;

class Route {

    public static function any($method, $uri, $controller) {
        if ($_SERVER['REQUEST_METHOD'] == $method && $_SERVER['REQUEST_URI'] == $uri) {
            if (is_callable($controller)) {
                $class = new $controller[0];
                $method = $controller[1];
                $class->$method();
            } else {
                $controller = explode('@', $controller);
                $class = new $controller[0];
                $method = $controller[1];
                $class->$method();
            }
        }
    }

    

}