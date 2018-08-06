function go(url)
{
	window.location = url;
}

function newRice()
{
	window.location = "saveRiceDisease";
}

function deleteRice(url)
{
	var isOK = confirm("Are you sure to delete?");
	if(isOK)
	{
		go(url);
	}
}