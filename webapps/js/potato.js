function go(url)
{
	window.location = url;
}

function newPotato()
{
	window.location = "savePotatoDisease";
}

function deletePotato(url)
{
	var isOK = confirm("Are you sure to delete?");
	if(isOK)
	{
		go(url);
	}
}