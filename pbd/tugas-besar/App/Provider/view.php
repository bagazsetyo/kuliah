<?php

namespace App\Provider;

class View {
    public static function render($view, $variable)
    {
        
        $keysListVariables = array_keys($variable);
        $listDataHelper = array_merge([], [
            'renderSection' => [self::class, 'renderSection'],
            'renderTemplate' => [self::class, 'renderTemplate'],
            'renderTemplateWithLayout' => [self::class, 'renderTemplateWithLayout'],
            'keysListVariable' => $keysListVariables,
        ]);
        
        $view = str_replace('.', '/', $view);
        extract($listDataHelper);


        require __DIR__ . "/../../views/$view.php";
    }

    public static function renderSection($section)
    {
        $section = str_replace('.', '/', $section);
        require __DIR__ . "/../../views/$section.php";
    }

    public static function renderTemplate($template, $view, $data = [])
    {
        $view = str_replace('.', '/', $view);
        extract($data);
        require __DIR__ . "/../../views/$template.php";
    }

    public static function renderTemplateWithLayout($template, $view, $data = [])
    {
        $data = array_merge([], [
            'renderSection' => [self::class, 'renderSection'],
            'renderTemplate' => [self::class, 'renderTemplate'],
            'renderTemplateWithLayout' => [self::class, 'renderTemplateWithLayout'],
            'callFunction' => [self::class, 'callFunction'],
            get_defined_functions(),
            'variable' => $data,
        ]);

        $view = str_replace('.', '/', $view);
        $template = str_replace('.', '/', $template);
        extract($data);
        require __DIR__ . "/../../views/$template.php";
    }

    // callfunction 
    public static function callFunction($function, $data)
    {
        $get_defined_functions = get_defined_functions();
        if (in_array($function, $get_defined_functions['user'])) {
            return $function($data['variable']);
        }
    }
}