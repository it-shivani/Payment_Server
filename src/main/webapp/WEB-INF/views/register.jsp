<!DOCTYPE html>
<html>
    <head>
        <title>Easy Payment</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="resources/bootstrap-3.3.6-dist/css/bootstrap.min.css" property="" />
        <script src="resources/js/jquery-1.12.2.min.js"></script>
        <script src="resources/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
        <style>
            body{
                /*width: 98.8%;*/
            }

            #Navi{
                background: url(resources/images/Header.png);
            }

            #regForm{
                padding-top: 5%;
                background-image: url(resources/images/home.jpg);
                background-size: 100%;
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
                        <a class="navbar-brand" >Easy Payment</a>
                    </div>
                    <div>
                        <ul class="nav nav-pills">
                            <li><a href="index.html">Home</a></li>
                            <li class="active"><a href="#">sign up Now </a></li>
                            <li><a href="appDownload.html">Download App </a></li>
                            <li><a href="signin.html">sign in </a></li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
       
        <!-- user register -->
        <div class="row" id="regForm">
            <div class="col-xs-6"></div>
            <div class="col-xs-5">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">
                            Sign Up 
                        </h3>
                    </div>
                    <div class="panel-body">
                        <form name= "addForm">
                            <div class="panel-body">
                                <div class="input-group">
                                    <span class="input-group-addon">First Name :</span>
                                    <input type="text" class="form-control" placeholder="First Name" name="propertyName"  ng-model="add_propertyName" />
                                </div>
                            </div>

                            <div class="panel-body">
                                <div class="input-group">
                                    <span class="input-group-addon">Last Name :</span>
                                    <input type="text" class="form-control" placeholder="Last Name" name="propertyName"  ng-model="add_propertyName" />
                                </div>
                            </div>

                            <div class="panel-body">
                                <div class="input-group">
                                    <span class="input-group-addon">Phone :</span>
                                    <input type="text" class="form-control" placeholder="Phone" name="propertyAlias"  ng-model="add_propertyAlias" />
                                </div>
                            </div>  

                            <div class="panel-body">
                                <div class="input-group">
                                    <span class="input-group-addon">Email :</span>
                                    <input type="text" class="form-control" placeholder="Email" name="propertyName"  ng-model="add_propertyName" />
                                </div>
                            </div>

                            <div class="panel-body">
                                <div class="input-group">
                                    <span class="input-group-addon">Password :</span>
                                    <input type="text" class="form-control" placeholder="Password" name="propertyName"  ng-model="add_propertyName" />
                                </div>
                            </div>

                            <div class="panel-body">
                                <div class="input-group">
                                    <input type="checkbox" name="propertyName"  ng-model="add_propertyName" />
                                    <span>
                                        I Agrees on  :<a data-toggle="modal" data-target="#privacyPolicy" > Privacy policy </a> and
                                        <a  data-toggle="modal" data-target="#customerPolicy" > Service Agreement </a>
                                    </span>
                                </div>
                            </div>

                        </form>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">
                                Clear
                            </button>
                            <button type="button" class="btn btn-primary"  ng-click="add()"  data-dismiss="modal">
                                Submit
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- <div class="row well" >
            <div class="col-xs-2" >
            </div>
            <div class="col-xs-8" >
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
        </div> -->

        <!-- model for Private Policy  -->
        <div class="modal fade" id="privacyPolicy" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            &times;
                        </button>
                        <h4 class="modal-title" id="myModalLabel">
                            Privacy Policy
                        </h4>
                    </div>
                    <div class="modal-body">
                        1. A Privacy Policy is a legal statement that specifies what the business owner does with the personal data collected from users, along with how the data is processed and why.
                        In 1968, Council of Europe did studies on the threat of the Internet expansion as they were concerned with the effects of technology on human rights. This lead to the development of policies that were to be developed to protect personal data.
                        This marks the start of what we know now as a “Privacy Policy”. While the name “Privacy Policy” refers to the legal agreement, the concept of privacy and protecting user data is closely related.
                        <br><br> 2. This agreement can also be known under these names:
                        -Privacy Statement<br> 
                        -Privacy Notice<br> 
                        -Privacy Information<br> 
                        -Privacy Page<br><br> 
                        3. The Privacy Policy can be used for both your website and mobile app if it’s adapted to include the platforms your business operates on.
                        The contents of a Privacy Policy may differ from one country to another, depending on the country legislation, but most privacy laws identify the following critical points that a business must comply with when dealing with personal data:
                        Notice. Data collectors (meaning, you or your company) must make clear what they are doing with the personal information from users before gathering it.
                        Choice. The companies collecting the data must respect the choices of users on what information to provide and how personal that provided information will be.
                        Access. Users should be able to view or contest the accuracy of personal data collected by the company.
                        Security. The companies are entirely responsible for the accuracy and security (keeping it properly away from unauthorized eyes and hands) of the collected personal information.
                        This means that a “Privacy Policy” serves as a way to inform users how their personal information will be used, along with how the information will be collected and who has access to it.

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">
                            Close
                        </button>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="customerPolicy" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            &times;
                        </button>
                        <h4 class="modal-title" id="myModalLabel">
                            Customer Agreement
                        </h4>
                    </div>
                    <div class="modal-body">
                        1. A Privacy Policy is a legal statement that specifies what the business owner does with the personal data collected from users, along with how the data is processed and why.
                        In 1968, Council of Europe did studies on the threat of the Internet expansion as they were concerned with the effects of technology on human rights. This lead to the development of policies that were to be developed to protect personal data.
                        This marks the start of what we know now as a “Privacy Policy”. While the name “Privacy Policy” refers to the legal agreement, the concept of privacy and protecting user data is closely related.
                        <br><br> 2. This agreement can also be known under these names:
                        -Privacy Statement<br> 
                        -Privacy Notice<br> 
                        -Privacy Information<br> 
                        -Privacy Page<br> <br>
                        3. The Privacy Policy can be used for both your website and mobile app if it’s adapted to include the platforms your business operates on.
                        The contents of a Privacy Policy may differ from one country to another, depending on the country legislation, but most privacy laws identify the following critical points that a business must comply with when dealing with personal data:
                        Notice. Data collectors (meaning, you or your company) must make clear what they are doing with the personal information from users before gathering it.
                        Choice. The companies collecting the data must respect the choices of users on what information to provide and how personal that provided information will be.
                        Access. Users should be able to view or contest the accuracy of personal data collected by the company.
                        Security. The companies are entirely responsible for the accuracy and security (keeping it properly away from unauthorized eyes and hands) of the collected personal information.
                        This means that a “Privacy Policy” serves as a way to inform users how their personal information will be used, along with how the information will be collected and who has access to it.

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">
                            Close
                        </button>
                    </div>
                </div>
            </div>


        </div>

        <div id="id_footer" class="navbar-fixed-bottom text-center" >Copyright @2016 by TeamTech</div>

        <script>
            total = document.documentElement.clientHeight;
            colHeight = total ;
            document.getElementById("regForm").style.height = colHeight + "px";
        </script>
    </body>
</html>
