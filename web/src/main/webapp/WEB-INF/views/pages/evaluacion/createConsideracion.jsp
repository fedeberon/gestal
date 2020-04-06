<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Crear una nueva consideraci&oacute;n</h4>
                </div>
                <div class="card-body">
                    <c:url var="actionUrl" value="/evaluacion/"/>
                    <form:form modelAttribute="evaluacion" action="${actionUrl}" method="POST">
                        <div class="container">
                            <div id="field-consideracion">
                                <label for="field1">Consideraciones</label>
                                <div class="input-group">
                                    <input required="required" autocomplete="off" class="col-7 mx-3"
                                           id="field-consideracion1" name="items[0].consideraciones[0].value" type="text"
                                           placeholder="Descripcion del item"/>
                                    <button id="b1" class="btn btn-primary add-consideracion" type="button">+</button>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary">Guardar</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
