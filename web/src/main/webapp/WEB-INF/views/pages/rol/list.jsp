<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Roles</h4>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table">
                            <thead class=" text-primary">
                                <th>Nombre</th>
                            </thead>
                            <tbody>

                                <c:forEach items="${roles}" var="bo">
                                    <tr>
                                        <td>${bo.name}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <th>
                                        <div class="mt-5">
                                            <form name="rol" action="list" method="get">
                                                <input type="hidden" name="page" value="${page}"/>
                                                <tags:paginador page="${page}" formName="search"/>
                                            </form>
                                        </div>
                                    </th>
                                    <th>
                                        <div class="mt-5">
                                            <a class="btn btn-success" href="<c:url value='/rol/create'/>"title="Agregar rol">Agregar rol</a>
                                        </div>
                                    </th>
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>