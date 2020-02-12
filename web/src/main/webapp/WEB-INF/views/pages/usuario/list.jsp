<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Usuarios</h4>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table">
                            <thead class=" text-primary">
                                <th>Nombre de usuario</th>
                                <th>Email</th>
                                <th>Editar</th>
                            </thead>
                            <tbody>
                                <c:forEach items="${usuarios}" var="bo">
                                    <tr>
                                        <td>${bo.username}</td>
                                        <td>${bo.mail}</td>
                                        <td>
                                            <a href="<c:url value='/usuario/update?id=${bo.id}'/>" class="btn btn-success">Editar</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row mt-5">
        <div class="col-md-12">
            <div class="float-right mt-5 mr-5 my-5">
                <a class="btn btn-success" href="<c:url value='/usuario/create'/>">Nuevo</a>
            </div>
        </div>
    </div>
</div>