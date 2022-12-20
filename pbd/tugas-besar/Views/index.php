<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <div class="container mt-5">
        <div class="card">
            <div class="card-body">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Kode Parkir</th>
                            <th>Nama</th>
                            <th>Waktu Masuk</th>
                            <th>Biaya</th>
                            <th>Denda</th>
                            <th>NPM</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php 
                            foreach ($data as $key => $value):
                        ?>
                        <tr>
                            <td>1</td>
                            <td>123</td>
                            <td>123</td>
                            <td>123</td>
                            <td>123</td>
                            <td>123</td>
                            <td>123</td>
                        </tr>
                        <?php
                            endforeach; 
                        ?>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>