<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php $renderSection('includes.navbar') ?>
    <div class="container">
        <div class="">
            <?= $callFunction('content', get_defined_vars()) ?>
        </div>
    </div>
</body>
</html>
