<?php 

use Routes\Route;

use Controllers\HomeController;

// $home = new HomeController();
// $home->index();

$request = $_SERVER['REQUEST_URI'];

switch ($request) {
    case '/' :
        Route::any('GET', '/', [HomeController::class, 'index']);
        break;
    case '' :
        Route::any('GET', '/', function() {
            require __DIR__ . '/../views/index.php';
        });
        break;
    case '/parkir' :
        Route::any('GET', '/parkir', function() {
            require __DIR__ . '/../views/parkir.php';
        });
        break;
    case '/parkir/create' :
        Route::any('POST', '/parkir/create', function() {
            require __DIR__ . '/../views/parkir-create.php';
        });
        break;
    case '/parkir/delete' :
        Route::any('POST', '/parkir/delete', function() {
            require __DIR__ . '/../views/parkir-delete.php';
        });
        break;
    case '/parkir/karcis' :
        Route::any('GET', '/parkir/karcis', function() {
            require __DIR__ . '/../views/karcis.php';
        });
        break;
    default:
        http_response_code(404);
        require __DIR__ . '/../views/404.php';
        break;
}

// class Sisi {
//     public function __construct()
//     {
//         echo 11;
//     }
// }


// call route from Route.php with reuireone 