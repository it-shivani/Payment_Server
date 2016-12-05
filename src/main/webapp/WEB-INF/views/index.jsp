<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
    <head>
        <title>Easy Payment</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" >    
        <link rel="stylesheet" href="resources/bootstrap-3.3.6-dist/css/bootstrap.min.css" property="" />
        <script src="resources/js/jquery-1.12.2.min.js"></script>
        <script src="resources/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
        <style>
            body{
            }
            #Navi{
                background: url(resources/images/Header.png);
            }
            .homePic{
                position: relative;
                /*size:100%;*/
                top: 30%;
            }
            .homePic h2{
                text-shadow: 0 0 20px blue;
                font-family: Tahoma, Geneva, sans-serif;

            }
            .slogn{
                width: 100%;
                color: white;
                top: 20%;
                position: absolute;
                color: #eee;
                text-shadow: 5px 5px 0 #666, 7px 7px 0 #eee;
            }

            #header{
                padding-bottom: 20px;
            }
            #HeaderPic{
                height: 500px;
                width: 100%;

            }

            #icon{
                padding-top:20px;
                height: 150px;
            }
            .id_footer{
                background-color: lightblue;
                margin-top: 50px;
                padding-top: 10px;
                position: relative;
                height: 50px;
                width: 100%;
                box-sizing: border-box;
                bottom: 0;
            }
            .row h3{
                /*padding-top: 20px;*/
                padding-bottom: 20px;
            }


        </style>
    </head>

    <body>
        <div>
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
                                <li class="active"><a href="#">Home</a></li>
                                <li><a href="register.html">sign up Now </a></li>
                                <li><a href="appDownload.html">Download App </a></li>
                                <li><a href="signin.html">sign in </a></li>
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>

            <!-- pic -->
            <!-- <div class="row" id="header" >
                <div class="col-xs-12 " >
                    <div>
                        <image id="HeaderPic" src="resources/images/home.jpg" />
                        <div class="text-center "><p>An easy and fun way to pay</p></div>
                    </div>
                    
                </div>
            </div> -->
            <div class="row" >
                <div class="homePic text-center">
                    <img src="resources/images/home.jpg" style="width:100%;" alt="" class="img-responsive">
                    <div class="slogn"  >
                        <div class="col-sm-1"></div>
                        <div class="col-sm-3"><h2>Money transfer in easy and fun way</h2></div>
                    </div>
                </div>
            </div>

            <!-- icon -->
            <div class="row">
                <div class="col-sm-2 text-center col-sm-offset-3">
                    <image id="icon" src="resources/images/banking.png" />
                    <h3>Money Transfer</h3>
                </div>
                <div class="col-sm-2 text-center">
                    <image id="icon" src="resources/images/lottery.png" />
                    <h3>Play Lottory</h3>
                </div>
                <div class="col-sm-2 text-center">
                    <image id="icon" src="resources/images/friends.png" />
                    <h3>Make Friends</h3>
                </div>
            </div>

            <!-- footer -->
            <div class="id_footer text-center">Copyright @2016 by TeamTech</div>
        </div>
    </body>
</html>
