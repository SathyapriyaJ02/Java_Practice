class songNotFoundException extends Exception
{
	songNotFoundException(String title)
	{
		System.out.println(title+" not found");
	}
}