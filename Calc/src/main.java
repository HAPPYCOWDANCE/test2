import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		char[] chars = input.toCharArray();
		int prev = -1;
		int current = -1;
		List terms = new ArrayList();
		List temp = new ArrayList();
		

		
		// iterate over char[] array using enhanced for loop
		
		
		
		for (char ch : chars) {
			int a = ch;
			current = number(a);
			if (current >= 0 && current <= 9) 
			{
				if (prev == -1)
				{
					prev = 0;
				} 
				prev = (prev * 10 + current);
			} else {
				if (prev != -1)
				{
					terms.add(prev);
				}
				
				terms.add(addlist(current));
				prev = -1;
				current = 0;
			}
		}
		if (prev != -1)
		{
			terms.add(prev);
		}
		
	
	
		
		for (int i = 0; i < terms.size(); i++) {
			System.out.println(terms.get(i));
		}

		
		
		while (true) {
			List pterms = new ArrayList();
			prev = 0;
			int position = frontpsearcher(terms);
			if (position != -1) 
			{
				int backvalue = backpsearcher(terms, position);
				
				for (int i = position + 1; i < backvalue; i++)
				{
					pterms.add(terms.get(i));
				}
				for (int i = position ; i <= backvalue; i++)
				{
					terms.remove(position);
				}
				pterms = solve(pterms);
				terms.set(position, pterms.get(0));
			} 
			else {
				break;
			}

		}

		
		terms = solve(terms);
		System.out.println(terms.get(0));

	}

	public static List solve(List a) {
		
		while (true) {
			int prev = 0;
			int position = indexof(a, "/");
			if (position != -1) {
				prev = (int) (a.get(position - 1)) / (int) (a.get(position + 1));
				a.set(position - 1, prev);
				a.remove(position + 1);
				a.remove(position);
			} else {
				break;
			}
		}
		while (true) {
			int prev = 0;
			int position = indexof(a, "*");
			if (position != -1) {
				prev = (int) (a.get(position - 1)) * (int) (a.get(position + 1));
				a.set(position - 1, prev);
				a.remove(position + 1);
				a.remove(position);
			} else {
				break;
			}
		}
		while (true) {
			int prev = 0;
			int position = indexof(a, "+");
			if (position != -1) {
				prev = (int) (a.get(position - 1)) + (int) (a.get(position + 1));
				a.set(position - 1, prev);
				a.remove(position + 1);
				a.remove(position);
			} else {
				break;
			}
		}
		while (true) {
			int prev = 0;
			int position = indexof(a, "-");
			if (position != -1) {
				prev = (int) (a.get(position - 1)) - (int) (a.get(position + 1));
				a.set(position - 1, prev);
				a.remove(position + 1);
				a.remove(position);
			} else {
				break;
			}
		}	
		return a;
	}	
	
	
	public static int number(int input) {
		return (input - 48);
	}

	public static int indexof(List a, Object dvalue) {
		for (int i = 0; i < a.size(); i++) {

			if (a.get(i) == dvalue) {
				return i;
			}

		}
		return -1;
	}
	public static int backpsearcher(List a, int dvalue) {
		for (int i = dvalue; i < a.size(); i++) {

			if (a.get(i) == ")")
			{
				return i;
			}

		}
		return -1;
	}
	public static int frontpsearcher(List a) {
		int value = 0;
		for (int i = 0; i < a.size(); i++) {

			if (a.get(i) == ("(")) {
				value = i;
			}
		}
		if (value > 0) {
			return value;
		}
		return -1;
	}

	public static String addlist(int current) {
		if (current == -5) {
			return ("+");
		}
		if (current == -2) {
			return ("-");
		}
		if (current == -1) {
			return ("/");
		}
		if (current == -6) {
			return ("*");
		}
		if (current == -8) {
			return ("(");
		}
		if (current == -7) {
			return (")");
		}
		return ("a");
	}
}
