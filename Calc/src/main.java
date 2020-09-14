import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		char[] chars = input.toCharArray();
		int prev = 0;
		int current = 0;
		List terms = new ArrayList();
		List temp = new ArrayList();
		// iterate over char[] array using enhanced for loop
		for (char ch : chars) {
			int a = ch;
			current = number(a);
			if (current >= 0 && current <= 9) {
				prev = (prev * 10 + current);
			} else {
				terms.add(prev);
				terms.add(addlist(current));
				prev = 0;
				current = 0;
			}
		}
		// if last in number
		terms.add(prev);

		for (int i = 0; i < terms.size(); i++) {
			System.out.println(terms.get(i));
		}

		// divide

		while (true) {
			prev = 0;
			int position = indexof(terms, "/");
			if (position != -1) {
				prev = (int) (terms.get(position - 1)) / (int) (terms.get(position + 1));
				terms.set(position - 1, prev);
				terms.remove(position + 1);
				terms.remove(position);
			} else {
				break;
			}
		}
		// multiply
		while (true) {
			prev = 0;
			int position = indexof(terms, "*");
			if (position != -1) {
				prev = (int) (terms.get(position - 1)) * (int) (terms.get(position + 1));
				terms.set(position - 1, prev);
				terms.remove(position + 1);
				terms.remove(position);
			} else {
				break;
			}
		}
		// subtract
		while (true) {
			prev = 0;
			int position = indexof(terms, "-");
			if (position != -1) {
				prev = (int) (terms.get(position - 1)) - (int) (terms.get(position + 1));
				terms.set(position - 1, prev);
				terms.remove(position + 1);
				terms.remove(position);
			} else {
				break;
			}
		}
		while (true) {
			prev = 0;
			int position = indexof(terms, "+");
			if (position != -1) {
				prev = (int) (terms.get(position - 1)) + (int) (terms.get(position + 1));
				terms.set(position - 1, prev);
				terms.remove(position + 1);
				terms.remove(position);
			} else {
				break;
			}
		}

		System.out.println(terms.get(0));

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

	public static String addlist(int current) {
		if (current == -5) {
			return("+");
		}
		if (current == -2) {
			return("-");
		}
		if (current == -1) {
			return("/");
		}
		if (current == -6) {
			return("*");
		}
		if (current == -8) {
			return("(");
		}
		if (current == -7) {
			return(")");
		}
		return ("a");
	}
}
