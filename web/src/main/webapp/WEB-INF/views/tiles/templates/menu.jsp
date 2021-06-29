<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.userdetails.UserDetails" %>
<%@ page import="org.springframework.ui.Model" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String username = ((UserDetails)principal).getUsername();
%>
<style>
    .colaborators{
        font-size: 24px;
        float: left;
        margin-right: 12px;
        line-height: 30px;
        width: 34px;
        text-align: center;
        color: rgba(255, 255, 255, 0.5);
        position: relative;
    }
</style>

    <div class="sidebar" data-color="white" data-active-color="danger">
        <div class="logo">
            <a href="http://www.creative-tim.com" class="simple-text logo-mini">
                <div class="logo-image-small">
                    <img src="/assets/img/logo-login.png">
                </div>
            </a>
            <a href="<c:url value='home'/>" class="simple-text logo-normal">Actual - Gestal</a>
        </div>
        <div class="sidebar-wrapper">
            <ul class="nav">
                <sec:authorize access="hasAnyAuthority('ADMIN')">

                    <li>
                        <a href="<c:url value='home'/>">
                            <i class="nc-icon nc-bank"></i>
                            <p>Inicio</p>
                        </a>
                    </li>

                    <li>
                        <a href="<c:url value='/colaborador/list'/>">
                            <img class="nc-icon colaborators" src="/assets/img/svg/1x/colaborators.png"/>
                            <p>Colaboradores</p>
                        </a>
                    </li>

                    <%--<li>--%>
                    <%--<a href="<c:url value='/usuario/list'/>">--%>
                    <%--<i class="nc-icon nc-single-02"></i>--%>

                    <%--<p>Usuarios</p>--%>
                    <%--</a>--%>
                    <%--</li>--%>

                    <li>
                        <a href="<c:url value='/evaluacion/list'/>">
                            <i class="nc-icon nc-bullet-list-67"></i>
                            <p>Evaluaci&oacute;nes</p>
                        </a>
                    </li>
                </sec:authorize>
                <li>
                    <a href="<c:url value='/evaluacionDelColaborador/list'/>">
                        <i class="nc-icon nc-single-copy-04"></i>

                        <p>Evaluaci&oacute;nes de colaboradores</p>
                    </a>
                </li>
                <sec:authorize access="hasAnyAuthority('ADMIN')">

                    <li>
                        <a href="<c:url value='/puesto/list'/>">
                            <i class="nc-icon nc-key-25"></i>

                            <p>Puestos</p>
                        </a>
                    </li>

                    <li>
                        <a href="<c:url value='/sucursal/list'/>">
                            <i class="nc-icon nc-shop"></i>

                            <p>Sucursales</p>
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value='/certificado/list'/>">
                            <i class="nc-icon nc-credit-card"></i>

                            <p>Certificados m&eacute;dicos</p>
                        </a>
                    </li>
                </sec:authorize>
            </ul>
        </div>
    </div>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-absolute fixed-top navbar-transparent">
        <div class="container-fluid">
            <div class="navbar-wrapper">
                <div class="navbar-toggle">
                    <button type="button" class="navbar-toggler">
                        <span class="navbar-toggler-bar bar1"></span>
                        <span class="navbar-toggler-bar bar2"></span>
                        <span class="navbar-toggler-bar bar3"></span>
                    </button>
                </div>
                <a class="navbar-brand" href="javascript:;">Gestal</a>
            </div>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-bar navbar-kebab"></span>
                <span class="navbar-toggler-bar navbar-kebab"></span>
                <span class="navbar-toggler-bar navbar-kebab"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-end" id="navigation">
                <ul class="navbar-nav">
                    <li class="nav-item btn-rotate dropdown">
                        <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <p><span class="d-md-block"><%=username%></span></p>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="<c:url value='/logout'/>">Cerrar sesi&oacute;n </a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>

<%--<style>--%>
<%--    .colaborators{--%>
<%--        font-size: 24px;--%>
<%--        float: left;--%>
<%--        margin-right: 12px;--%>
<%--        line-height: 30px;--%>
<%--        width: 34px;--%>
<%--        text-align: center;--%>
<%--        color: rgba(255, 255, 255, 0.5);--%>
<%--        position: relative;--%>
<%--    }--%>
<%--</style>--%>

<%--<div>--%>
<%--    <div class="sidebar" data-color="white" data-active-color="danger">--%>
<%--        <div class="logo">--%>
<%--            <a href="http://www.creative-tim.com" class="simple-text logo-mini">--%>
<%--                <div class="logo-image-small">--%>
<%--                    <img src="/assets/img/logo-login.png">--%>
<%--                </div>--%>
<%--            </a>--%>
<%--            <a href="<c:url value='home'/>" class="simple-text logo-normal">Actual - Gestal</a>--%>
<%--        </div>--%>
<%--        <div class="sidebar-wrapper">--%>
<%--            <ul class="nav">--%>
<%--                <sec:authorize access="hasAnyAuthority('ADMIN')">--%>

<%--                    <li>--%>
<%--                        <a href="<c:url value='home'/>">--%>
<%--                            <i class="nc-icon nc-bank"></i>--%>
<%--                            <p>Inicio</p>--%>
<%--                        </a>--%>
<%--                    </li>--%>

<%--                    <li>--%>
<%--                        <a href="<c:url value='/colaborador/list'/>">--%>
<%--                            <img class="nc-icon colaborators" src="/assets/img/svg/1x/colaborators.png"/>--%>
<%--                            <p>Colaboradores</p>--%>
<%--                        </a>--%>
<%--                    </li>--%>

<%--                    &lt;%&ndash;<li>&ndash;%&gt;--%>
<%--                        &lt;%&ndash;<a href="<c:url value='/usuario/list'/>">&ndash;%&gt;--%>
<%--                            &lt;%&ndash;<i class="nc-icon nc-single-02"></i>&ndash;%&gt;--%>

<%--                            &lt;%&ndash;<p>Usuarios</p>&ndash;%&gt;--%>
<%--                        &lt;%&ndash;</a>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;</li>&ndash;%&gt;--%>

<%--                    <li>--%>
<%--                        <a href="<c:url value='/evaluacion/list'/>">--%>
<%--                            <i class="nc-icon nc-bullet-list-67"></i>--%>
<%--                            <p>Evaluaci&oacute;nes</p>--%>
<%--                        </a>--%>
<%--                    </li>--%>
<%--                </sec:authorize>--%>
<%--                    <li>--%>
<%--                        <a href="<c:url value='/evaluacionDelColaborador/list'/>">--%>
<%--                            <i class="nc-icon nc-single-copy-04"></i>--%>

<%--                            <p>Evaluaci&oacute;nes de colaboradores</p>--%>
<%--                        </a>--%>
<%--                    </li>--%>
<%--                <sec:authorize access="hasAnyAuthority('ADMIN')">--%>

<%--                    <li>--%>
<%--                        <a href="<c:url value='/puesto/list'/>">--%>
<%--                            <i class="nc-icon nc-key-25"></i>--%>

<%--                            <p>Puestos</p>--%>
<%--                        </a>--%>
<%--                    </li>--%>

<%--                    <li>--%>
<%--                        <a href="<c:url value='/sucursal/list'/>">--%>
<%--                            <i class="nc-icon nc-shop"></i>--%>

<%--                            <p>Sucursales</p>--%>
<%--                        </a>--%>
<%--                    </li>--%>
<%--                    <li>--%>
<%--                        <a href="<c:url value='/certificado/list'/>">--%>
<%--                            <i class="nc-icon nc-credit-card"></i>--%>

<%--                            <p>Certificados m&eacute;dicos</p>--%>
<%--                        </a>--%>
<%--                    </li>--%>
<%--                </sec:authorize>--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
