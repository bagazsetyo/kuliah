<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<?php

function dd()
{
    foreach (func_get_args() as $data) {
        echo '<pre style="margin: 10px; color: white; background-color: black; padding: 10px; text-align: left !important; word-break: break-word; word-wrap: break-word;">';
        var_dump($data);
        echo '</pre>';
    }
    die();
}

// error reporting all 
error_reporting(E_ALL);
ini_set('display_errors', 1);


require __DIR__ . '/vendor/autoload.php';
require __DIR__ . '/routes/index.php';
