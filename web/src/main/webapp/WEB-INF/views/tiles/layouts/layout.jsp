<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html charset=UTF-8">
        <title><tiles:getAsString name="title" /></title>
        <link href="<c:url value='/static/css/app.css' />" rel="stylesheet">

        <meta charset="utf-8" />
        <link rel="apple-touch-icon" sizes="76x76" href="/assets/img/logo-login.png">
        <link rel="icon" type="image/png" href="/assets/img/logo-login.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>
            <tiles:getAsString name="title" />
        </title>
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
        <!--     Fonts and icons     -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
        <!-- CSS Files -->
        <link href="<c:url value='/assets/css/bootstrap.min.css' />" rel="stylesheet" />
        <link href="<c:url value='/assets/css/paper-dashboard.css?v=2.0.0' />" rel="stylesheet" />
        <!-- CSS Just for demo purpose, don't include it in your project -->
        <link href="<c:url value='/assets/demo/demo.css' />" rel="stylesheet" />
        <link href="<c:url value='/assets/css/evaluacion/style.css' />" rel="stylesheet" />
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    </head>

    <body>

    <tiles:insertAttribute name="menu" />

    <div class="wrapper ">
        <div class="main-panel">
            <tiles:insertAttribute name="body" />
            <tiles:insertAttribute name="footer" />
        </div>
    </div>
        <!--   Core JS Files   -->
        <script type="text/javascript" src='<c:url value="/assets/plugins/jquery/jquery-3.2.1.min.js"/>'></script>

        <script type="text/javascript" src='<c:url value="/assets/js/core/popper.min.js"/>'></script>

        <script type="text/javascript" src='<c:url value="/assets/js/core/bootstrap.min.js"/>'></script>

        <script type="text/javascript" src='<c:url value="/assets/js/plugins/perfect-scrollbar.jquery.min.js"/>'></script>

        <!--  Google Maps Plugin    -->
        <script type="text/javascript" src='<c:url value="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"/>'></script>

        <!-- Chart JS -->
        <script type="text/javascript" src='<c:url value="/assets/js/plugins/chartjs.min.js"/>'></script>

        <!--  Notificaciones Plugin    -->
        <script type="text/javascript" src='<c:url value="/assets/js/plugins/bootstrap-notify.js"/>'></script>
        <script type="text/javascript" src='<c:url value="/assets/demo/demo.js"/>'></script>
        <script type="text/javascript" src='<c:url value="/assets/js/plugins/bootstrap-notify.js"/>'></script>

        <!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
        <script type="text/javascript" src='<c:url value="/assets/js/paper-dashboard.min.js?v=2.0.0"/>'></script>

        <%--<script type="text/javascript" href="<c:url value='/assets/js/script.js'/>"></script>--%>
        <script type="text/javascript" src='<c:url value="/assets/js/script.js"/>'></script>

        <script type="text/javascript" src='<c:url value="/assets/js/paginador.js"/>'></script>
        <%--Graficos Plugin--%>
        <script type="text/javascript" src='<c:url value="/assets/plugins/canvasjs/canvasjs.min.js"/>'></script>
        <script type="text/javascript" src='<c:url value="/assets/plugins/canvasjs/jquery.canvasjs.min.js"/>'></script>
        <script type="text/javascript" src='<c:url value="/assets/js/plugins/perfect-scrollbar.jquery.min.js"/>'></script>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    </body>
</html>
