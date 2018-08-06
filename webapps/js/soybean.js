function go(url)
{
	window.location = url;
}

function newSoybean()
{
	window.location = "saveSoybeanDisease";
}

function deleteSoybean(url)
{
	var isOK = confirm("Are you sure to delete?");
	if(isOK)
	{
		go(url);
	}
}