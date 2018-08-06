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
	
<style type="text/css">
.logbtnstyle{
width:120px;
border-radius:0px;
}
.logbtnstyle:hover{
background-color:rgba(144, 146, 153, 0.94);
border-color:rgba(144, 146, 153, 0.94);
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
								<li class="active"><a href="#header"><i
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

			<div class="middle text-center clearfix">
				<div class="container">
					<h1 class="pro-name">
						CROP DISEASE DIAGNOSIS SYSTEM
						<!-- </span> -->
					</h1>
					<p style="color:#fff;font-size:24px;">This system helps to provide diagnosis to
					 crop diseases which affect maize, rice, potato and soybean. It also enables farmers
					 to upload photos of infected crops so that they can receive appropriate controls from
					 the experts.
					</p>
					<p style="color:#fff;font-size:24px;">
					Inorder to access the systems' resources you can click on the <font style="color:#5cb85c;">Sign Up</font> button
					to create an account or if you already have an existing account you can go ahead
					and click the <font style="color:#5cb85c;">login</font> button.
					</p><br/>
					<a href="saveFarmer"><button class="btn btn-success logbtnstyle"><font style="font-size:16px;">Sign Up</font></button></a>&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;
					<a href="loginC"><button class="btn btn-success logbtnstyle"><font style="font-size:16px;">Login</font></button></a>
					<!-- <p class="tagline"></p> -->
					<div class="skills"></div>
					<!-- skills -->

				</div>
				<!-- container -->
			</div>
			<!-- middle -->
		</div>
		<!-- overlay-1 -->
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


	<!-- js -->
	<script>
		new WOW().init();
	</script>
	
	<script src="js/jquery-2.1.3.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.actual.min.js"></script>
	<script src="js/isotope.pkgd.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.isonscreen.js"></script>

	<script src="js/main.js"></script>

	<script>
		$(document).ready(function() {
			$('.owl-carousel').owlCarousel({
				loop : true,
				margin : 10,
				autoplay : true,
				autoplayTimeout : 3000,
				autoplayHoverPause : true,
				responsiveClass : true,
				responsive : {
					0 : {
						items : 1,
					},
					600 : {
						items : 1,
					},
					1000 : {
						items : 1,
					}
				}
			})
		});
	</script>
</body>
</html>
