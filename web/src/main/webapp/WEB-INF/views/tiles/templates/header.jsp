<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.userdetails.UserDetails" %>
<%@ page import="org.springframework.ui.Model" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   String username = ((UserDetails)principal).getUsername();
   %>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-absolute navbar-transparent">
   <div class="container-fluid">
      <div class="navbar-wrapper">
         <div class="navbar-toggle">
            <button type="button" class="navbar-toggler">
               <span class="navbar-toggler-bar bar1"></span>
               <span class="navbar-toggler-bar bar2"></span>
               <span class="navbar-toggler-bar bar3"></span>
            </button>
         </div>
         <a class="navbar-brand" style="margin-left:250px">
           Gestal
         </a>
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
                  <p>
                     <span class="d-md-block"><%=username%></span>
                  </p>
               </a>
               <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                  <a class="dropdown-item" href="<c:url value='/logout'/>">Cerrar sesi&oacute;n </a>
               </div>
            </li>
         </ul>
      </div>
   </div>
</nav>