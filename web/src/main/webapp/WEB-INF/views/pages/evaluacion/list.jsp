<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Evaluaciones</h4>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table">
                            <thead class=" text-primary">
                            <th>Rol</th>
                            <th>Items</th>
                            <th>Estado</th>
                            </thead>
                            <tbody>
                            <c:forEach items="${evaluaciones}" var="bo">
                                <c:forEach items="${bo.items}" var="item">

                                <tr>
                                    <td>${bo.rol.name}</td>
                                    <td>${item.value}</td>
                                    <td>${bo.state}</td>
                                </tr>
                                </c:forEach>
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
                <a class="btn btn-success" href="<c:url value='/evaluacion/create'/>">
                    Nuevo
                </a>



            </div>
        </div>
    </div>
</div>