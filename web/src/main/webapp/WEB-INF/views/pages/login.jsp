<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
    <meta charset="utf-8" />
    <title>Login | D&middot;Ads - Dynamic Ads made easy.</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <link rel="apple-touch-icon" href="pages/ico/60.png">
    <link rel="apple-touch-icon" sizes="76x76" href="pages/ico/76.png">
    <link rel="apple-touch-icon" sizes="120x120" href="pages/ico/120.png">
    <link rel="apple-touch-icon" sizes="152x152" href="pages/ico/152.png">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-touch-fullscreen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="default">
    <meta content="Dynamic Ads made Easy!" name="description" />
    <meta content="Toiluj23" name="author" />`
    <link href="assets/plugins/pace/pace-theme-flash.css" rel="stylesheet" type="text/css" />
    <link href="assets/plugins/bootstrap-select2/select2.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="assets/plugins/font-awesome/css/all.min.css" rel="stylesheet" type="text/css" />
    <link href="assets/plugins/jquery-scrollbar/jquery.scrollbar.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="assets/plugins/bootstrap-tag/bootstrap-tagsinput.css" rel="stylesheet" type="text/css" />
    <link href="assets/plugins/bootstrap-datepicker/css/datepicker3.css" media="screen" type="text/css" rel="stylesheet" />
    <link href="assets/plugins/jquery-nouislider/jquery.nouislider.css" media="screen" type="text/css" rel="stylesheet" />
    <link type="text/css" rel="stylesheet" href="assets/plugins/jquery-datatable/media/css/jquery.dataTables.css">
    <link type="text/css" rel="stylesheet" href="assets/plugins/jquery-datatable/extensions/FixedColumns/css/dataTables.fixedColumns.min.css">
    <link media="screen" type="text/css" rel="stylesheet" href="assets/plugins/datatables-responsive/css/datatables.responsive.css">
    <link type="text/css" rel="stylesheet" href="assets/plugins/dropzone/css/dropzone.css">
    <link href="pages/css/pages-icons.css" rel="stylesheet" type="text/css" />
    <link href="pages/css/themes/light.css" rel="stylesheet" type="text/css" />
    <link class="main-stylesheet" href="assets/css/style.css" rel="stylesheet" type="text/css" />
    <!--[if lte IE 9]>
    <link href="pages/css/ie9.css" rel="stylesheet" type="text/css" />
    <![endif]-->
    <script type="text/javascript">
        window.onload = function() {
            // fix for windows 8
            if (navigator.appVersion.indexOf("Windows NT 6.2") != -1)
                document.head.innerHTML += '<link rel="stylesheet" type="text/css" href="pages/css/windows.chrome.fix.css" />'
        }
    </script>
</head>
<body class="fixed-header">
<!-- START PAGE-CONTAINER -->
<div class="login-wrapper">
    <!-- START Login Background Pic Wrapper-->
    <div class="bg-pic">
        <!-- START Background Pic-->
        <!-- <img src="assets/img/demo/new-york-city-buildings-sunrise-morning-hd-wallpaper.jpg" data-src="assets/img/demo/new-york-city-buildings-sunrise-morning-hd-wallpaper.jpg" data-src-retina="assets/img/demo/new-york-city-buildings-sunrise-morning-hd-wallpaper.jpg" alt="" class="lazy"> -->
        <!-- END Background Pic-->
        <!-- START Background Caption-->
        <div class="bg-caption pull-bottom sm-pull-bottom text-white p-l-20 m-b-20">
            <h2 class="semi-bold text-white"><img src="assets/img/iso.svg" alt="logo" data-src="assets/img/iso.svg" data-src-retina="assets/img/iso.svg" height="80"><span class="light">ADS</span></h2>
            <p class="small">Show contextual ads and get real engagement.</p>
        </div>
        <!-- END Background Caption-->
    </div>
    <!-- END Login Background Pic Wrapper-->
    <!-- START Login Right Container-->
    <div class="login-container bg-white">
        <div class="p-l-50 m-l-20 p-r-50 m-r-20 p-t-50 m-t-30 sm-p-l-15 sm-p-r-15 sm-p-t-40">
            <h4 class="semi-bold"><img src="assets/img/iso.svg" alt="logo" data-src="assets/img/iso.svg" data-src-retina="assets/img/iso.svg" height="40"><span class="light">ADS</span></h4>
            <p class="p-t-35">Sign in</p>
            <!-- START Login Form -->
            <form id="form-login" class="p-t-15" role="form" action="login" method='POST'>
                <!-- START Form Control-->
                <div class="form-group form-group-default">
                    <label>Login</label>
                    <div class="controls">
                        <input type="text" name="username"  placeholder="User Name" class="form-control" required>
                    </div>
                </div>
                <!-- END Form Control-->
                <!-- START Form Control-->
                <div class="form-group form-group-default">
                    <label>Password</label>
                    <div class="controls">
                        <input type="password" class="form-control" name="password" placeholder="Credentials" required>
                    </div>
                </div>
                <!-- START Form Control-->
                <div class="row">
                    <div class="col-md-6 no-padding">
                        <div class="checkbox ">
                            <input type="checkbox" value="1" id="checkbox1">
                            <label for="checkbox1">Keep Me Signed in</label>
                        </div>
                    </div>
                    <div class="col-md-6 text-right">
                        <a href="#" class="text-info small">Help? Contact Support</a>
                    </div>
                </div>
                <!-- END Form Control-->
                <button class="btn btn-primary btn-cons m-t-10" type="submit">Sign in</button>
            </form>
            <!--END Login Form-->
            <div class="pull-bottom sm-pull-bottom">
                <div class="m-b-30 p-r-80 sm-m-t-20 sm-p-r-15 sm-p-b-20 clearfix">

                </div>
            </div>
        </div>
    </div>
    <!-- END Login Right Container-->
</div>
<!-- END PAGE CONTAINER -->
<!-- BEGIN VENDOR JS -->
<script src="assets/plugins/pace/pace.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="assets/plugins/modernizr.custom.js" type="text/javascript"></script>
<script src="assets/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
<script src="assets/plugins/boostrapv3/js/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery/jquery-easy.js" type="text/javascript"></script>
<script src="assets/plugins/jquery-unveil/jquery.unveil.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery-bez/jquery.bez.min.js"></script>
<script src="assets/plugins/jquery-ios-list/jquery.ioslist.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery-actual/jquery.actual.min.js"></script>
<script src="assets/plugins/jquery-scrollbar/jquery.scrollbar.min.js"></script>
<script type="text/javascript" src="assets/plugins/bootstrap-select2/select2.min.js"></script>
<script type="text/javascript" src="assets/plugins/classie/classie.js"></script>
<script src="assets/plugins/switchery/js/switchery.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
<!-- END VENDOR JS -->
<!-- BEGIN CORE TEMPLATE JS -->
<script src="pages/js/pages.min.js"></script>
<!-- END CORE TEMPLATE JS -->
<!-- BEGIN PAGE LEVEL JS -->
<script src="assets/js/scripts.js" type="text/javascript"></script>
<!-- END PAGE LEVEL JS -->
<script>
    $(function()
    {
        $('#form-login').validate()
    })
</script>
</body>
</html>
