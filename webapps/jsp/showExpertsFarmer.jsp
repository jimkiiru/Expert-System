
<%
	if ((session.getAttribute("logid") == null) || (session.getAttribute("logid") == "")) {
%>
<script>
	alert("You must be logged in to access this page");
	window.location.href = "loginC";
</script>
<%
	} else {
%>
<%@include file="taglib_includes.jsp"%>
<%!int count;%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Expert System</title>

<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/local.css" />

<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

<!-- you need to include the shieldui css and js assets in order for the charts to work -->
<link rel="stylesheet" type="text/css"
	href="http://www.shieldui.com/shared/components/latest/css/shieldui-all.min.css" />
<link rel="stylesheet" type="text/css"
	href="http://www.shieldui.com/shared/components/latest/css/light-bootstrap/all.min.css" />
<script type="text/javascript"
	src="http://www.shieldui.com/shared/components/latest/js/shieldui-all.min.js"></script>
<script type="text/javascript"
	src="http://www.prepbootstrap.com/Content/js/gridData.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

<!-- Datatable -->


<link href="datatable/tablestyles.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="datatable/display.css">

<script type="text/javascript" src="datatable/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="datatable/jquery.dataTables.js"></script>

<script type="text/javascript">
	//Plug-in to fetch page data 
	jQuery.fn.dataTableExt.oApi.fnPagingInfo = function(oSettings) {
		return {
			"iStart" : oSettings._iDisplayStart,
			"iEnd" : oSettings.fnDisplayEnd(),
			"iLength" : oSettings._iDisplayLength,
			"iTotal" : oSettings.fnRecordsTotal(),
			"iFilteredTotal" : oSettings.fnRecordsDisplay(),
			"iPage" : oSettings._iDisplayLength === -1 ? 0 : Math
					.ceil(oSettings._iDisplayStart / oSettings._iDisplayLength),
			"iTotalPages" : oSettings._iDisplayLength === -1 ? 0 : Math
					.ceil(oSettings.fnRecordsDisplay()
							/ oSettings._iDisplayLength)
		};
	};

	$(document).ready(function() {

		$("#example").dataTable({
			"bProcessing" : true,
			"bServerSide" : true,
			"sort" : "position",
			//bStateSave variable you can use to save state on client cookies: set value "true" 
			"bStateSave" : false,
			//Default: Page display length
			"iDisplayLength" : 10,
			//We will use below variable to track page number on server side(For more information visit: http://legacy.datatables.net/usage/options#iDisplayStart)
			"iDisplayStart" : 0,
			"fnDrawCallback" : function() {
				//Get page numer on client. Please note: number start from 0 So
				//for the first page you will see 0 second page 1 third page 2...
				//Un-comment below alert to see page number
				//alert("Current page number: "+this.fnPagingInfo().iPage);    
			},
			"sAjaxSource" : "ExpertPaginationDataTables",
			"aoColumns" : [ {
				"mData" : "surname"
			}, {
				"mData" : "fname"
			}, {
				"mData" : "emailaddress"
			}, {
				"mData" : "phonenum"
			}, {
				"mData" : "jobDescription"
			}, {
				"mData" : "department"
			}, {
				"mData" : "county"
			} ]
		});
	});
</script>

<script>
	$(document).ready(
			function() {
				setInterval(function() {
					var randomnumber = Math.floor(Math.random() * 100);
					$('#show').text(
							'I am getting refreshed every 3 seconds..! Random Number ==> '
									+ randomnumber);
				}, 3000);
			});
</script>


</head>
<body>

	<div id="wrapper">
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="farmersdashboard">Farmer Dashboard</a>
			</div>
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li class="active"><a href="farmersdashboard"><i
							class="fa fa-bullseye"></i> Dashboard</a></li>
					<li><a href="partsaffected"><i class="fa fa-grains"></i>
							Rice</a></li>
					<li><a href="maizepartsaffected"><i class="fa fa-maxcdn"></i>
							Maize</a></li>
					<li><a href="potatopartsaffected"><i
							class="fa fa-pagelines"></i> Potatoes</a></li>
					<li><a href="application"><i class="fa fa-leaf"></i>
							Soybean</a></li>
					<li><a href="savePhoto"><i class="fa fa-picture-o"></i>
							Upload Photo</a></li>
					<li><a href="viewExpertsF">
							View Experts</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right navbar-user">
					<li class="dropdown user-dropdown"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"><i
							class="fa fa-user"></i> farmer<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="farmersProfile?farmerId=${farmerId}"><i
									class="fa fa-user"></i> Profile</a></li>
							<li class="divider"></li>
							<li><a href="resetpass">Resset Password</a></li>
							<li class="divider"></li>
							<li><a href="logout"><i class="fa fa-power-off"></i> Log
									Out</a></li>
						</ul></li>
				</ul>
			</div>
		</nav>

		<div id="page-wrapper">
			<div class="col-lg-12 col-md-6 col-sm-6 col-xs-12">


				<form action="" method="GET">

					<table id="databledisplay"
						style="width: 100%; border-collapse: collapse;">
						<tr>
							<td nowrap="nowrap">
								<table id="example" cellspacing="0"
									style="width: 100%; border-right: 1px solid #d3d3d3; border-top: 1px solid #d3d3d3; border-bottom: 1px solid #d3d3d3;">
									<thead>
										<tr>
											<th nowrap="nowrap"
												style="text-align: left; background-color: #fff;">Surname</th>
											<th nowrap="nowrap"
												style="text-align: left; background-color: #fff;">FirstName</th>
											<th nowrap="nowrap"
												style="text-align: left; background-color: #fff;">EmailAddress</th>
											<th nowrap="nowrap"
												style="text-align: left; background-color: #fff;">PhoneNumber</th>
											<th nowrap="nowrap"
												style="text-align: left; background-color: #fff;">JobDescription</th>
											<th nowrap="nowrap"
												style="text-align: left; background-color: #fff;">Department</th>
											<th nowrap="nowrap"
												style="text-align: left; background-color: #fff;">County</th>

										</tr>
									</thead>
								</table>
							</td>
						</tr>
					</table>
				</form>

			</div>
		</div>
	</div>

</body>
</html>
<%
	}
%>