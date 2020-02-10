<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Colaboradores</h4>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table">
                            <thead class=" text-primary">

                                <th>Nombre</th>
                                <th>Apellido</th>

                            </thead>
                            <tbody>

                            <c:forEach items="${colaboradores}" var="bo">
                                <tr>

                                    <td>${bo.name}</td>
                                    <td>${bo.lastName}</td>

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
                <a class="btn btn-danger rounded-circle" href="<c:url value='colaborador/create'/>">
                    +
                </a>
            </div>
        </div>
    </div>
</div>