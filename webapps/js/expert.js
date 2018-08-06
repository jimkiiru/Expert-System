function go(url)
{
	window.location = url;
}

function deleteExpert(url)
{
	var isOK = confirm("Are you sure to delete?");
	if(isOK)
	{
		go(url);
	}
}