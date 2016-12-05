
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html>
    <head>
        <title>Easy Payment - App Download</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="resources/bootstrap-3.3.6-dist/css/bootstrap.min.css" property="" />
        <script src="resources/js/jquery-1.12.2.min.js"></script>
        <script src="resources/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
        <style>
            body{
                /*width: 98.8%;*/
            }
            #forHead{
                height: 80px;
                width: 100%;
            }
            #Navi{
                background: url(resources/images/Header.png);
            }

            #regForm{
                padding-top: 10%;
                background-image: url(resources/images/home.jpg);
                background-size: 100%
            }

            #pic{
                padding-top: 10px;
                float: left;
            }

            #QRCode{
                width: 200px;
            }
            .intro{
                width: 400px;
                color:  #f7f7f7;
            }

            .col-right-block {  
                float: none;  
                display: block;  
                margin-left: auto;  

            }  
            .col-center-block {  
                float: none;  
                display: block;  
                margin-left: auto;  
                margin-right: auto;
            }  
            #id_footer{
                background-color: lightblue;
                height: 50px;
                width: 100%;
                /*box-sizing: border-box;*/
                bottom: 0;
                margin-top: 50px;
                padding-top: 10px;
            }
        </style>
    </head>
    <body>

        <!--    navigator   -->
        <div class="row" >
            <div class="col-xs-2"></div>
            <div class="col-xs-8">
                <nav class="navbar navbar-fixed-top" role="navigation" id="Navi">
                    <div class="navbar-header">
                        <a class="navbar-brand" >Easy Payment </a>
                    </div>
                    <div>
                        <ul class="nav nav-pills">
                            <li><a href="index.html">Home</a></li>
                            <li><a href="register.html">sign up Now </a></li>
                            <li class="active"><a href="#">Download App </a></li>
                            <li><a href="signin.html">sign in </a></li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
        <!-- main -->
        <div class="row" id="regForm">
            <div class="col-xs-6 text-center">
                <div class="intro col-center-block text-left">
                    <h3>
                        The Most Useful App
                    </h3>
                    <button type="button" class="btn btn-default btn-lg">
                        <span class="glyphicon glyphicon-send"></span> Easy Install For Most Mobile Device
                    </button><br><br>
                    <button type="button" class="btn btn-default btn-lg">
                        <span class="glyphicon glyphicon-send"></span> Make Money Transfer Much More Faster
                    </button><br><br>
                    <button type="button" class="btn btn-default btn-lg">
                        <span class="glyphicon glyphicon-send"></span> All Functions Are Free To Access
                    </button><br><br>
                    <button type="button" class="btn btn-default btn-lg">
                        <span class="glyphicon glyphicon-send"></span> New User Interface 
                    </button><br><br>
                </div>

            </div>

            <div class="col-xs-5">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">
                            Please scan code for install app
                        </h3>
                    </div>
                    <div class="panel-body text-center">
                        <div id="pic">
                            <image id="QRCode" src="resources/images/appleAppQR.jpg"/><br>
                            IOS
                        </div>

                        <div id="pic">
                            <image id="QRCode" src="resources/images/androidAppQR.jpg"/><br>
                            Android 
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row well" id="footer">
            <div class="col-xs-2">
            </div>
            <div class="col-xs-8">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div id="copyright" class="text-left">
                            Our Policies: 
                            <a  class="btn" data-toggle="modal" data-target="#privacyPolicy" > Privacy policy </a> | 
                            <a  class="btn " data-toggle="modal" data-target="#customerPolicy" > Customer Agreement </a> <br>
                            contact us @ Fremont CA U.S. 94539<br>
                            Mail : PO Box 2311 X_X Dr Fremont, CA 94539
                        </div>
                        <div id="copyright" class="text-center">Copyright &COPY; 2016 by TeamTech</div>
                    </div>
                </div>
            </div>
            <div class="col-xs-2">
            </div>
        </div>
        <div id="id_footer" class="navbar-fixed-bottom text-center" >Copyright @2016 by TeamTech</div>

        <script>
            total = document.documentElement.clientHeight;
            colHeight = total;
            document.getElementById("regForm").style.height = colHeight + "px";

        </script>



    </body>
</html>
