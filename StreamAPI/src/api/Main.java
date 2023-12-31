package api;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Main
{
	public static void main(String a[])
	{
		
		List<Integer> l = new ArrayList<>();
		l.add(2);
		l.add(4);
		l.add(5);
		l.add(6);
		
		//System.out.println(l);
		
		
		Stream<Integer> s = l.stream();
		Stream<Integer> s1 =s.filter(n->n%2==0);
		Stream<Integer> s2 = s1.map(n-> n*2);
		int res = s2.reduce(0,(t,n)->t+n);
		System.out.println(res);
		System.out.println(l);
	}

}
