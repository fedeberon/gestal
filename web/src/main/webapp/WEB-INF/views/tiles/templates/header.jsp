<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.userdetails.UserDetails" %>
<%@ page import="org.springframework.ui.Model" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<%--%>
<%--   Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();--%>
<%--   String username = ((UserDetails)principal).getUsername();--%>
<%--   %>--%>
<%--<!-- Navbar -->--%>
<%--<div class="main-panel">--%>
<%--<nav class="navbar navbar-expand-lg navbar-absolute fixed-top navbar-transparent">--%>
<%--   <div class="container-fluid">--%>
<%--      <div class="navbar-wrapper">--%>
<%--         <div class="navbar-toggle">--%>
<%--            <button type="button" class="navbar-toggler">--%>
<%--               <span class="navbar-toggler-bar bar1"></span>--%>
<%--               <span class="navbar-toggler-bar bar2"></span>--%>
<%--               <span class="navbar-toggler-bar bar3"></span>--%>
<%--            </button>--%>
<%--         </div>--%>
<%--         <div class="row">--%>
<%--            <div class="col-md-2">--%>
<%--               <a type="button" class="btn btn-secondary navbar-brand" data-toggle="tooltip" data-placement="top" title="Atras" onclick="history.go(-1);" >--%>
<%--                  <i class="nc-icon nc-minimal-left"></i>--%>
<%--               </a>--%>
<%--            </div>--%>
<%--            <div class="col-md-1">--%>
<%--               <a class="navbar-brand mt-2 ml-5">--%>
<%--                  Gestal--%>
<%--               </a>--%>
<%--            </div>--%>
<%--         </div>--%>
<%--      </div>--%>
<%--      <div class="collapse navbar-collapse justify-content-end" id="navigation">--%>
<%--         <ul class="navbar-nav">--%>
<%--            <li class="nav-item btn-rotate dropdown">--%>
<%--               <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
<%--                  <p>--%>
<%--                     <span class="d-md-block"><%=username%></span>--%>
<%--                  </p>--%>
<%--               </a>--%>
<%--               <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">--%>
<%--                  <a class="dropdown-item" href="<c:url value='/logout'/>">Cerrar sesi&oacute;n </a>--%>
<%--               </div>--%>
<%--            </li>--%>
<%--         </ul>--%>
<%--      </div>--%>
<%--   </div>--%>
<%--</nav>--%>
<%--</div>--%>