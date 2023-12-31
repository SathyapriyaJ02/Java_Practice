class Demo
{
	public static void main(String a[])
	{
		int arr[] = new int[5];
		try
		{
			arr[5] = 10;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}