<!DOCTYPE html>
<html>
    <head>
        <title>Easy Payment - My Account</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="resources/bootstrap-3.3.6-dist/css/bootstrap.min.css" property="" />
        <script src="resources/js/jquery-1.12.2.min.js"></script>
        <script src="resources/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
        <style>
            body{
                width: 98.8%;
            }
            #forHead{
                height: 80px;
                width: 100%;
            }
            #Navi{
                background: url(resources/images/Header.png);
            }

            #regForm{
                padding-top: 80px;
            }

            #regForm ul.nav-pills {
                position: fixed;
                top:200px;
            }
            div.col-sm-9 div {

                font-size: 18px;
            }
            #section1 { background-color: #1E88E5; top:100px;}
            #section2 { background-color: #673ab7;}
            #section3 { background-color: #ff9800;}
            #section4 {color: #fff; background-color: #00bcd4;height: 300px;}


            @media screen and (max-width: 810px) {
                #section1, #section2, #section3, #section4 {
                    margin-left: 150px;
                }
            }

        </style>
    </head>
    <body data-spy="scroll" data-target="#myScrollspy" data-offset="20">

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
                            <li><a href="#">sign up Now </a></li>
                            <li><a href="appDownload.html">Download App </a></li>
                            <li class="active"><a href="#">My Account </a></li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
        <!-- user information -->
        <div class="row" id="regForm">
            <div class="col-xs-2"></div>
            <div class="col-xs-8">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h3 class="panel-title">
                            My Account 
                        </h3>
                    </div>
                    <div class="panel-body">

                        <div class="row">
                            <nav class="col-sm-3" id="myScrollspy">
                                <ul class="nav nav-pills nav-stacked">
                                    <li class="active"><a href="#section1">Account Infomation</a></li>
                                    <li><a href="#section2">Banks Information</a></li>
                                    <li><a href="#section3">Transfers</a></li>
                                    <li><a href="#section4">Other Information</a></li>
                                </ul>
                            </nav>

                            <div class="col-sm-9">
                                <div id="section1">    
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">
                                                Account Infomation
                                            </h3>
                                        </div>
                                        <div class="panel-body">

                                            <table class="table table-striped">
                                                <tbody>
                                                    <tr>
                                                        <td>Name :</td>
                                                        <td>Doe Deo</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Balance :</td>
                                                        <td>201 ($)</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Phone :</td>
                                                        <td>556-343-3222</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Email :</td>
                                                        <td>sds@ww.com</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Create At :</td>
                                                        <td>2016-12-25</td>
                                                    </tr>
                                                </tbody>
                                            </table>

                                        </div>
                                    </div>
                                </div>

                                <div id="section2"> 
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">
                                                Banks Information
                                            </h3>
                                        </div>
                                        <div class="panel-body">

                                            <table class="table table-striped">
                                                <thead>
                                                    <tr>
                                                        <th>Bank Name</th>
                                                        <th>Bank Account</th>
                                                        <th>Country</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>BankOfAmerica</td>
                                                        <td>***34</td>
                                                        <td>US</td>
                                                    </tr>
                                                    <tr>
                                                        <td>USBank</td>
                                                        <td>***04</td>
                                                        <td>US</td>
                                                    </tr>
                                                    <tr>
                                                        <td>BankOfFremont</td>
                                                        <td>***99</td>
                                                        <td>US</td>
                                                    </tr>

                                                </tbody>
                                            </table>

                                        </div>
                                    </div>
                                </div>   

                                <div id="section3">         
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">
                                                Transfers
                                            </h3>
                                        </div>
                                        <div class="panel-body">

                                            <table class="table table-striped">
                                                <thead>
                                                    <tr>
                                                        <th>To</th>
                                                        <th>Amount</th>
                                                        <th>Date</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>Jone</td>
                                                        <td>34.00</td>
                                                        <td>2016-2-23</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Jone</td>
                                                        <td>34.00</td>
                                                        <td>2016-2-23</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Jone</td>
                                                        <td>34.00</td>
                                                        <td>2016-2-23</td>
                                                    </tr>

                                                </tbody>
                                            </table>

                                        </div>
                                    </div>
                                </div>

                                <div id="section4">         
                                    <h1>Section 4-1</h1>
                                    <p>Try to scroll this section and look at the navigation list while scrolling!</p>
                                </div>      

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row well" >
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
        </div>

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

        <script>


        </script>
    </body>
</html>
