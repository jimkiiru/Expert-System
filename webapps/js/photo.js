function go(url)
{
	window.location = url;
}

function newPhoto()
{
	window.location = "expertDash";
}

function deletePhoto(url)
{
	var isOK = confirm("Are you sure you want to delete?");
	if(isOK)
	{
		go(url);
	}
}