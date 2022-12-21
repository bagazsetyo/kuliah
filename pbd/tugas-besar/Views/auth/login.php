<?= $renderTemplateWithLayout('layouts.master', 'auth.login') ?>

<?php function content(){ ?>

  <div class="row justify-content-center ">
      <div class="card col-6 mt-5">
        <div class="card-body">
          <form>
            <!-- Email input -->
            <div class="form-outline mb-4">
              <label class="form-label" for="form3Example3">Email address</label>
              <input type="email" id="form3Example3" class="form-control" />
            </div>

            <!-- Password input -->
            <div class="form-outline mb-4">
              <label class="form-label" for="form3Example4">Password</label>
              <input type="password" id="form3Example4" class="form-control" />
            </div>

            <!-- Submit button -->
            <a href="/admin/list" class="btn btn-primary btn-block mb-4">
              Masuk
            </a>
            <button type="submit" class="d-none btn btn-primary btn-block mb-4">
              Masuk
            </button>
          </form>
        </div>
      </div>
  </div>

<?php } ?>