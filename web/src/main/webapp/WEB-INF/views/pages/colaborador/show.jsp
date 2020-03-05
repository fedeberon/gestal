<div class="content">
    <div class="row">
        <div class="col-md-4">
            <div class="card card-user">
                <div class="image">
                    <img src="../assets/img/damir-bosnjak.jpg" alt="...">
                </div>
                <div class="card-body">
                    <div class="author">
                        <a href="#">
                            <img class="avatar border-gray" src="../assets/img/mike.jpg" alt="...">
                            <h5 class="title">${colaborador.username}</h5>
                        </a>
                        <p class="description">${colaborador.mail}</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-8">
            <div class="card card-user">
                <div class="card-header">
                    <h5 class="card-title">Informaci&oacute;n</h5>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-md-3 px-1 ml-2">
                            <div class="form-group">
                                <label>Usuario</label>
                                <input type="text" class="form-control" placeholder="Usuario" value="${colaborador.username}">
                            </div>
                        </div>
                        <div class="col-md-4 pl-1">
                            <div class="form-group">
                                <label for="exampleInputEmail1">Email</label>
                                <input type="email" class="form-control" placeholder="Email" value="${colaborador.mail}">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 pr-1">
                            <div class="form-group">
                                <label>Nombre</label>
                                <input type="text" class="form-control" placeholder="Nombre" value="">
                            </div>
                        </div>
                        <div class="col-md-6 pl-1">
                            <div class="form-group">
                                <label>Apellido</label>
                                <input type="text" class="form-control" placeholder="Apellido" value="">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label>Lugar donde vive</label>
                                <input type="text" class="form-control" placeholder="Lugar donde vive" value="">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4 pr-1">
                            <div class="form-group">
                                <label>Ciudad</label>
                                <input type="text" class="form-control" placeholder="Ciudad" value="">
                            </div>
                        </div>
                        <div class="col-md-4 px-1">
                            <div class="form-group">
                                <label>Naci&oacute;n</label>
                                <input type="text" class="form-control" placeholder="Naci&oacute;n" value="">
                            </div>
                        </div>
                        <div class="col-md-4 pl-1">
                            <div class="form-group">
                                <label>Codigo postal</label>
                                <input type="number" class="form-control" placeholder="Codigo postal" value="">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>