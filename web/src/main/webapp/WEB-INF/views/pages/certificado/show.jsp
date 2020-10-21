<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card card-user">
                <div class="m-auto">
                    <img src="../assets/img/damir-bosnjak.jpg" alt="..." class="img-responsive">
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="author">
                                <a href="#">
                                    <img class="avatar border-gray" src="/assets/img/user.jpg" alt="...">
                                    <h5 class="title">${certificado.colaborador.name}</h5>
                                </a>
                                <p class="description">Certificados</p>
                            </div>
                        </div>
                    </div>
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                <form class="float-right" action="/file/uploadFile" method="POST" enctype="multipart/form-data">
                                    <input type="hidden" name="idCertificado" value="${certificado.id}"/>
                                    <label class="control-label" for="fichero1">A&ntilde;adir nuevo certificado</label>
                                    <div class="controls">
                                        <input id="fichero1" type="file" name="file">
                                        <button class="btn btn-success" type="submit">Subir</button>
                                    </div>
                                </form>
                            </div>
                            <div class="col-md-12">
                                <hr class="mt-2 mb-5">
                                <div class="row text-center text-lg-left">
                                    <c:forEach items="${certificado.imagenes}" var="imagen">
                                        <div class="col-lg-3 col-md-4 col-6">
                                            <a href="#" class="d-block mb-4 h-100">
                                                <img id="image-display" src="/api/file/download/${certificado.colaborador.id}/${imagen.url}" class="img-fluid img-thumbnail" />
                                            </a>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
