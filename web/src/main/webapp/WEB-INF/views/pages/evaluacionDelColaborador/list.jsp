<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Evaluaciones</h4>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-condensed">
                            <thead class=" text-primary">
                                <th class="text-center">ID</th>
                            </thead>
                            <tbody>
                                <c:forEach items="${evaluaciones}" var="bo">
                                    <tr>
                                        <td class="text-center">${bo.id}</td>
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
                <a class="btn btn-success" href="<c:url value='/evaluacion/create'/>">Nuevo</a>
                <jsp:include page="modal/create.jsp"/>
            </div>
        </div>
    </div>


</div>