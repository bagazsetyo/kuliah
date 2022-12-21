<?= $renderTemplateWithLayout('layouts.master', 'auth.login', $variable) ?>

<?php function content(){ ?>
    <?php
        $var = func_get_args()[0];
        extract($var);
    ?>
    <div class="card">
        <div class="card-body">
            <div class="table-responsive">
                <table class="table">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Plat</th>
                            <th>Waktu Masuk</th>
                            <th>Waktu Keluar</th>
                            <th>Bayar</th>
                            <th>Denda</th>
                            <th>Aksi</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php foreach($data as $key => $d): ?>
                        <tr>
                            <td>No</td>
                            <td>Plat</td>
                            <td>Waktu Masuk</td>
                            <td>Waktu Keluar</td>
                            <td>Bayar</td>
                            <td>Denda</td>
                            <td>Aksi</td>
                        </tr>
                        <?php endforeach; ?>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

<?php } ?>