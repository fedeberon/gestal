<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <a href="<c:url value='colaborador/list'/>">
                        <i class="nc-icon nc-diamond"></i>
                        <p>Colaboradores</p>
                    </a>
                </li>
                <li>
                    <a href="<c:url value='usuario/list'/>">
                        <i class="nc-icon nc-pin-3"></i>
                        <p>Usuarios</p>
                    </a>
                </li>
                <li>
                    <a href="../../pages/notifications.jsp">
                        <i class="nc-icon nc-bell-55"></i>
                        <p>Notifications</p>
                    </a>
                </li>
                <li>
                    <a href="../user">
                        <i class="nc-icon nc-single-02"></i>
                        <p>User Profile</p>
                    </a>
                </li>
                <li>
                    <a href="../tables">
                        <i class="nc-icon nc-tile-56"></i>
                        <p>Table List</p>
                    </a>
                </li>
                <li>
                    <a href="../typography">
                        <i class="nc-icon nc-caps-small"></i>
                        <p>Typography</p>
                    </a>
                </li>
                <li class="active-pro">
                    <a href="../upgrade.jsp">
                        <i class="nc-icon nc-spaceship"></i>
                        <p>Upgrade to PRO</p>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>