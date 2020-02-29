<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <div class="sidebar" data-color="white" data-active-color="danger">
        <div class="logo">
            <a href="http://www.creative-tim.com" class="simple-text logo-mini">
                <div class="logo-image-small">
                    <img src="/assets/img/logo-login.png">
                </div>
            </a>
            <a href="http://www.creative-tim.com" class="simple-text logo-normal">Actual - Gestal</a>
        </div>
        <div class="sidebar-wrapper">
            <ul class="nav">
                <li class="active   ">
                    <a href="<c:url value='home'/>">
                        <i class="nc-icon nc-bank"></i>
                        <p>Inicio</p>
                    </a>
                </li>
                <li>
                    <a href="<c:url value='/colaborador/list'/>">
                        <i class="nc-icon nc-diamond"></i>
                        <p>Colaboradores</p>
                    </a>
                </li>
                <li>
                    <a href="<c:url value='/usuario/list'/>">
                        <i class="nc-icon nc-single-02"></i>

                        <p>Usuarios</p>
                    </a>
                </li>
                <li>
                    <a href="<c:url value='/evaluacion/list'/>">
                        <i class="nc-icon nc-tile-56"></i>

                        <p>Evaluaci&oacute;n</p>
                    </a>
                </li>

                <li>
                    <a href="<c:url value='/evaluacionDelColaborador/list'/>">
                        <i class="nc-icon nc-single-copy-04"></i>

                        <p>Evaluaci&oacute;n del colaborador</p>
                    </a>
                </li>

                <li>
                    <a href="<c:url value='/rol/list'/>">
                        <i class="nc-icon nc-single-copy-04"></i>

                        <p>Roles</p>
                    </a>
                </li>

            </ul>
        </div>
    </div>
</div>