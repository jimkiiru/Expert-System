function go(url)
{
	window.location = url;
}

function newMaize()
{
	window.location = "saveMaizeDisease";
}

function deleteMaize(url)
{
	var isOK = confirm("Are you sure to delete?");
	if(isOK)
	{
		go(url);
	}
}