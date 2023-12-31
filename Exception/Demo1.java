class Demo1 extends Exception
{
    public static void main(String a[])
    {
        int n1 = 10;
        int n2 = 2;

        try
        {
            int r = n1/n2;
            System.out.println(r);
        }
        catch(ArithmeticException ae | NullPointerException ne | Exception e)
        { 
            System.out.println(e);
        }
    }
}
