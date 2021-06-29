<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <div class="content">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        <h4 class="card-title"> Items</h4>
                    </div>
                    <div class="card-body">
                        <input type="hidden" name="count" value="1"/>
                        <c:url var="actionUrl" value="/evaluacion/"/>
                        <form:form modelAttribute="evaluacion" action="${actionUrl}" method="POST">
                        <form:hidden path="id" value='${evaluacion.id}'/>
                            <div class="form-group mt-4">
                                <div class="control-group" id="fields">
                                    <div class="container" style="max-width: 700px;">
                                        <div class="row">
                                            <label style="font-size: 16px" class="my-3 mx-3">Editar item</label>
                                            <c:forEach items="${evaluacion.items}" var="bo" varStatus="status">
                                            <form:hidden path="items" value='${bo.id}'/>
                                                <div class="col-md-12">

                                                    <div class="input-group input-group-sm mb-3">
                                                        <div class="input-group-prepend">
                                                            <span class="input-group-text badge badge-secondary border border-right pr-3" id="inputGroup-sizing-sm">${bo.id}</span>
                                                        </div>
                                                        <input type="text" name="items[${status.index}].value" value="${bo.value}" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm">
                                                    </div>

                                                </div>
                                        </c:forEach>
                                        <label style="font-size: 16px" class="my-3 mx-3">Editar puesto</label>
                                        <div class="col-md-12">
                                                <form:select path="puesto.id" cssClass="form-control mt-3 w-50">
                                                    <form:options items="${puestos}" itemValue="id" itemLabel="name"/>
                                                </form:select>
                                        </div>
                                        <div class="col-md-12">
                                            <button type="submit" class="btn btn-primary mt-5">Guardar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>