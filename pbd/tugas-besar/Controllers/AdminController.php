<?php 

namespace Controllers;
use Databases\DB;

class AdminController extends Controller {
    public function list() {
        $data = new DB();
        $data = $data->table('pasien')->get();

        $this->view('admin.list', [
            'data' => $data
        ]);
    }
}