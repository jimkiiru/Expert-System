<%
	if ((session.getAttribute("logid") == null)
			|| (session.getAttribute("logid") == "")) {
%>
<script>
 alert("You must be logged in to access this page");
 window.location.href="loginC";
</script>
<%}else{ %>
<%@include file="taglib_includes.jsp"%>
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

<SCRIPT type="text/javascript">
    function ValidateFileUpload() {
        var fuData = document.getElementById('fileChooser');
        var FileUploadPath = fuData.value;
//To check if user upload any file
        if (FileUploadPath == '') {
            alert("Please upload an image");
        } else {
            var Extension = FileUploadPath.substring(
                    FileUploadPath.lastIndexOf('.') + 1).toLowerCase();
//The file uploaded is an image
if (Extension == "gif" || Extension == "png" || Extension == "bmp"
                    || Extension == "jpeg" || Extension == "jpg") {
// To Display
                if (fuData.files && fuData.files[0]) {
                    var reader = new FileReader();

                    reader.onload = function(e) {
                        $('#blah').attr('src', e.target.result);
                    }
                    reader.readAsDataURL(fuData.files[0]);
                }
            } 
//The file upload is NOT an image
else {
               alert("Photo only allows file types of GIF, PNG, JPG, JPEG and BMP. ");
               window.location.href = "savePhoto";
                
            }
        }
    }
</SCRIPT>

</head>
<body>

	<%
		String logid = "" + session.getAttribute("logid");
		session.setAttribute("logid", logid);
	%>
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
					<li><a href="soybeanpartsaffected"><i class="fa fa-leaf"></i>
							Soybean</a></li>
					<li><a href="savePhoto"><i class="fa fa-picture-o"></i>
							Upload Photo</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right navbar-user">
					<li class="dropdown user-dropdown"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"><i
							class="fa fa-user"></i> farmer<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="farmersProfile?farmerId=${farmerId}"><i class="fa fa-user"></i> Profile</a></li>
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
			<div class="row">

				<div class="panel panel-info col-lg-9 col-lg-offset-2">
					<div class="panel-heading">
						<h3 class="panel-title">Send Photo</h3>
					</div>

					<div class="panel-body">
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-lg-offset-2">
							<div class="col-lg-offset-2">
								<h3 style="color: red;">${successMess}</h3>
								<form:form id="UploadForm" action="savePhoto" method="post"
									commandName="newPhoto" enctype="multipart/form-data">
									<table class="table" align="center">
										<tr>
											<td align="center"><h3 style="color: red;">Send a
													photo of the infected crop.</h3></td>
										</tr>

										<tr>
											<div class="row">
												<td>
													<div class="form-group col-lg-offset-2">
														<div class="col-md-12">
															<label for="Reports">Upload Photo<font
																style="color: red">*</font></label> <input path="photoname"
																class="form-control btn-info" name="fileUpload"
																type="file" id="fileChooser" onchange="return ValidateFileUpload()" required />
															<form:errors path="photoname" cssStyle="color:red"></form:errors>
														</div>
													</div>
												</td>
											</div>
										</tr>
										<tr>
											<td colspan="3" align="center">
											<button type="submit" class="btn btn-info" onclick="ValidateFileUpload();">Upload</button>
											<!-- <input type="submit"
												class="btn btn-danger" name="" value="Upload" onclick="ValidateFileUpload();"> -->
												&nbsp;&nbsp; <input type="reset" class="btn btn-success"
												name="" value="Clear"></td>
										</tr>
									</table>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
<%}%>