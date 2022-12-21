<?php

function renderSection($section)
{
    $section = str_replace('.', '/', $section);
    require __DIR__ . "/../../views/$section.php";
}

function renderTemplate($template, $view, $data = [])
{
    $view = str_replace('.', '/', $view);
    extract($data);
    require __DIR__ . "/../../views/$template.php";
}