<%@include file="taglib_includes.jsp"%>
<!DOCTYPE html>
<html lang="en-us">
<head>
<title>Online Expert System</title>

<!-- meta -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- stylesheet -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/owl.carousel.css">
<link rel="stylesheet" href="css/owl.theme.min.css">
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/main.css">

<!-- google font -->
<link href='http://fonts.googleapis.com/css?family=Oswald:300,400'
	rel='stylesheet'>
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=PT+Sans'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,300'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Oxygen:400,300'
	rel='stylesheet' type='text/css'>
<link href="http://fonts.googleapis.com/css?family=Rouge+Script"
	rel="stylesheet" type="text/css">
<link href='http://fonts.googleapis.com/css?family=Milonga'
	rel='stylesheet' type='text/css'>

<script>
function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
}
</script>

<style>
.regform{
margin-top: 60px;
}
.regbtnstyle{
width:120px;
border-radius:0px;
}
.phead{
background-color:#5cb85c;
}
</style>
</head>
<body>
	<div class="content-block" id="header">
		<div id="overlay-1">
			<header id="site-header" class="clearfix">
				<div class="pull-left">
					<h1>
						<a href="#">Expert System</a>
					</h1>
				</div>
				<div class="pull-right">
					<nav class="navbar site-nav" role="navigation">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle"
								data-toggle="collapse"
								data-target="#bs-example-navbar-collapse-1">
								<i class="fa fa-bars fa-2x"></i>
							</button>
						</div>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse"
							id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav">
								<li class="active"><a href="index"><i
										class="fa fa-home"></i> <span>Home</span></a></li>
								<li><a href="saveFarmer"><i class="fa fa-user-plus"
										aria-hidden="true"></i> Sign up</a></li>

								<li><a href="loginC"><i class="fa fa-sign-in"
										aria-hidden="true"></i> Login</a></li>
							</ul>
						</div>
						<!-- /.navbar-collapse -->
					</nav>
				</div>
			</header>
			<!-- site-header -->

		</div>
		<!-- overlay-1 -->
	</div>

	<div class="content-block" id="header">
		<div id="overlay-1">

			<div class="container">
				<div class="row regform">
					<div class="panel col-lg-10 col-lg-offset-1">
						<div class="panel-heading phead">Registration form</div>
						<center>
							<h3 style="color: red;">${successMess}</h3>
						</center>
						<div class="panel-body">
							<form:form action="saveFarmer" method="post"
								commandName="newFarmer">
								<div class="row">
									<div class="form-group col-md-6">
										<div class="col-md-8">
											<label for="SurName">SurName<font style="color: red">*</font></label>
											<input class="form-control" name="surname"
												placeholder="SurName" />
											<form:errors path="surname" cssStyle="color:red"></form:errors>
										</div>
									</div>

									<div class="form-group col-md-6">
										<div class="col-md-8">
											<label for="First Name">First Name<font
												style="color: red">*</font></label> <input class="form-control"
												name="fname" placeholder="First Name" required />
											<form:errors path="fname" cssStyle="color:red"></form:errors>
										</div>
									</div>

									<div class="form-group col-md-6">
										<div class="col-md-8">
											<label for="Last Name">Last Name<font
												style="color: red">*</font></label> <input class="form-control"
												name="lname" placeholder="Last Name" required />
											<form:errors path="lname" cssStyle="color:red"></form:errors>

										</div>
									</div>

									<div class="form-group col-md-6">
										<div class="col-md-8">
											<label for="Email Address">Email Address<font
												style="color: red">*</font></label>
											<div class="input-group">
												<span class="input-group-addon"><i
													style="color: #5cb85c;" class="fa fa-envelope"
													aria-hidden="true"></i> </span><input class="form-control"
													name="emailaddress" placeholder="Email Address" />
											</div>
											<form:errors path="emailaddress" cssStyle="color:red"></form:errors>
										</div>
									</div>

									<div class="form-group col-md-6">
										<div class="col-md-8">
											<label for="Phone Number">Phone Number<font
												style="color: red">*</font></label> <input class="form-control"
												name="phonenum" placeholder="Phone Number" pattern=".{10,}"
												maxlength="10" required
												oninvalid="this.setCustomValidity('10 characters required')"
												oninput="setCustomValidity('')"
												onkeypress="return isNumber(event)" />
											<form:errors path="phonenum" cssStyle="color:red"></form:errors>
										</div>
									</div>

									<div class="form-group col-md-6">
										<div class="col-md-8">
											<label for="Occupation">Occupation<font
												style="color: red">*</font></label> <input class="form-control"
												name="occupation" placeholder="Occupation" required />
											<form:errors path="occupation" cssStyle="color:red"></form:errors>
										</div>
									</div>


									<div class="form-group col-md-6">
										<div class="col-md-8">
											<label for="County">County<font style="color: red">*</font></label>
											<input class="form-control" name="county"
												placeholder="County" required />
											<form:errors path="county" cssStyle="color:red"></form:errors>
										</div>
									</div>

									<div class="form-group col-md-6">
										<div class="col-md-8">
											<label for="National Id">National Id<font
												style="color: red">*</font></label> <input class="form-control"
												name="nationalId" placeholder="National Id" pattern=".{8,}"
												maxlength="8" required
												oninvalid="this.setCustomValidity('8 characters required')"
												oninput="setCustomValidity('')"
												onkeypress="return isNumber(event)" />
											<form:errors path="nationalId" cssStyle="color:red"></form:errors>
										</div>
									</div>
									<div class="form-group col-md-6">
										<div class="col-md-8">
											<label for="National Id">Password<font
												style="color: red">*</font></label>
											<div class="input-group">
												<span class="input-group-addon"><i
													style="color: #5cb85c;" class="fa fa-unlock-alt"
													aria-hidden="true"></i></span> <input class="form-control"
													name="password" type="password" id="pass"
													placeholder="Password" pattern=".{4,}" required
													oninvalid="this.setCustomValidity('Minimum of 4 characters required')"
													oninput="setCustomValidity('')" />
												<form:errors path="password" cssStyle="color:red"></form:errors>
											</div>
										</div>
									</div>
									<div class="form-group col-md-6">
										<div class="col-md-8">
											<label for="National Id">Confirm Password<font
												style="color: red">*</font></label>
											<div class="input-group">
												<span class="input-group-addon"><i
													style="color: #5cb85c;" class="fa fa-unlock-alt"
													aria-hidden="true"></i></span> <input class="form-control"
													type="password" id="cpass" placeholder="Confirm Password"
													pattern=".{4,}" required
													oninvalid="this.setCustomValidity('Minimum of 4 characters required')"
													oninput="setCustomValidity('')" />
											</div>
										</div>
									</div>

									<div class="form-group col-md-6 col-lg-offset-4">
										<button type="submit" class="btn btn-success regbtnstyle">Save</button>
										<button type="reset" class="btn btn-info regbtnstyle">Clear</button>
										<!--  
									<input class="btn btn-success" type="submit" name=""
										value="Save" onclick="confirmPassword()"> &nbsp;&nbsp;
									<input type="reset" name="" value="Clear"
										class="btn btn-warning">-->

									</div>
								</div>
							</form:form>
						</div>
						<!-- owl-carousel -->
					</div>
					<!-- col-md-12 -->
				</div>
				<!-- row -->
			</div>
			<!-- container -->

		</div>
	</div>



	<footer id="site-footer">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<div class="copyright">&copy; cropdiagnosis</div>
				</div>

			</div>
		</div>
	</footer>
	<!-- site-footer -->


</body>
</html>
