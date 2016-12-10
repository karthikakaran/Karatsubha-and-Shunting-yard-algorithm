
//===========================================================================================================================
//Program : To multiply two Large Integers of a given base stored as separate lists 
//===========================================================================================================================
//@author: Nevhetha,Kritika,Karthika
//	Date created: 2016/09/19
//Date modified: 2016/09/19
//===========================================================================================================================
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KaratsubaAlgorithm {
	private int m2 = 0;
	 /** Procedure to multiply two Large Integers using Karatsubha algorithm.
     * Runs in time O(n^log3) where n is the size of the longest list 
     * @param x: ArrayList : Integer. Precondition : Digits of the list < base
     * @param y: ArrayList : Integer. Precondition : Digits of the list < base
     * If a,b have digits greater than base, behavior of procedure is arbitrary 
     * @param  base: int : base in which the given integers are represented
     */
	List<Integer> product(List<Integer> x, List<Integer> y, int b) {
		List<Integer> result = new ArrayList<>();
		List<Integer> high1 = new ArrayList<>();
		List<Integer> low1 = new ArrayList<>();
		List<Integer> high2 = new ArrayList<>();
		List<Integer> low2 = new ArrayList<>();
		List<Integer> z0 = new ArrayList<>();
		List<Integer> z1 = new ArrayList<>();
		List<Integer> z2 = new ArrayList<>();
		//Concatenating for base conditions
		StringBuilder dum1 = new StringBuilder();
		StringBuilder dum2 = new StringBuilder();
		for (Integer k : x) {
			dum1.append(k.toString());
		}
		for (Integer k : y) {
			dum2.append(k.toString());
		}
		dum1.reverse();
		dum2.reverse();
		int num1 = Integer.parseInt(dum1.toString());
		int num2 = Integer.parseInt(dum2.toString());
		// if (num1 < b) or (num2 < b) return num1*num2 
		if (num1 < b || num2 < b) {
			int n1 = Integer.parseInt(dum1.toString(), b);
			int n2 = Integer.parseInt(dum2.toString(), b);
			int h = n1 * n2;
			while (h >= b) {
				result.add(h % b);
				h = h / b;
			}
			if (h < b) {
				result.add(h % b);
				result.add(h / b);
			}

			return result;
		}

		int m = 0, i = 0;

		// calculates the size of the numbers
		m = Math.max(x.size(), y.size());
		// Equalizing the sizes
		i = x.size();
		while (i < m) {
			x.add(new Integer(0));
			i++;
		}

		i = y.size();
		while (i < m) {
			y.add(new Integer(0));
			i++;
		}
	
		// finding midlle
		m2 = (int) (m / 2);
		i = 0;
		while (i < m - m2) {
			low1.add(x.get(i));
			i++;
		}
		while (i < x.size()) {
			high1.add(x.get(i));
			i++;
		}
		// num2
		i =  0;
		while (i < m - m2) {
			low2.add(y.get(i));
			i++;
		}
		while (i < y.size()) {
			high2.add(y.get(i));
			i++;
		}
		
		// 3 calls made to numbers approximately half the size
		// z0 = karatsuba(low1,low2)
		// z1 = karatsuba((low1+high1),(low2+high2))
		// z2 = karatsuba(high1,high2)
		z2 = product(high1, high2, b);
		z0 = product(low1, low2, b);
		z1 = product(add(low1, high1, b), add(low2, high2, b), b);

		// return (z2*10^(2*m2))+((z1-z2-z0)*10^(m2))+(z0)
		List<Integer> intermediateRes = subtract(z1, z2, b);
		intermediateRes = subtract(intermediateRes, z0, b);
		int t = 0;
		m2 = (int) (m / 2);
		while (t < m - m2) {
			intermediateRes.add(0, 0);
			t++;
		}
		
		t = 0;
		while (t < 2 * (m - m2)) {
			z2.add(0, 0);
			t++;
		}
		result = add(z2, intermediateRes, b);
		result = add(result, z0, b);

		return result;
	}

	// Addition of large numbers
	public List<Integer> add(List<Integer> x, List<Integer> y, int b) {
		int i = 0;
		int j = 0;
		List<Integer> z = new ArrayList<>();
		int current1 = 0, current2 = 0, res = 0, carry = 0, reminder = 0, modulo = 0;

		while (i < x.size() && j < y.size()) {
			current1 = x.get(i);
			current2 = y.get(j);
			res = current1 + current2 + carry;
			carry = 0;
			reminder = (int) (res / b);
			modulo = res % b;
			z.add(modulo);
			carry = reminder;
			i++;
			j++;
		}
		/*while (i < x.size()) {
			z.add(x.get(i) + carry);
			carry = 0;
			i++;
		}
		while (j < y.size()) {
			z.add(y.get(j) + carry);
			carry = 0;
			j++;
		}*/
		while (i < x.size()) {
			res = x.get(i) + carry;
			if (res < b) {
				z.add(res);
				carry = 0;
			} else {
				reminder = (int) (res / b);
				modulo = res % b;
				z.add(modulo);
				carry = reminder;
			}
			i++;
		}
		while (j < y.size()) {
			res = y.get(j) + carry;
			if (res < b) {
				z.add(res);
				carry = 0;
			} else {
				reminder = (int) (res / b);
				modulo = res % b;
				z.add(modulo);
				carry = reminder;
			}
			j++;
		}
		if (carry > 0) {
			z.add(carry);
		}
		return z;
	}

	// Return z = x - y. Numbers are stored using base b.
	public List<Integer> subtract(List<Integer> x, List<Integer> y, int b) {
		int i = 0;
		int j = 0;
		List<Integer> z = new ArrayList<>();
		int current1 = 0, current2 = 0, res = 0, carry = 0, remain = 0;

		while (i < x.size() && j < y.size()) {
			current1 = x.get(i);
			if (carry == 1) {
				current1 = current1 - 1;
				carry = 0;
			}
			current2 = y.get(j);
			if (current1 < current2) {
				current1 = current1 + b;
				carry = 1;
			}
			res = current1 - current2;
			z.add(res);
			i++;
			j++;
		}
		while (i < x.size()) {
			remain = x.get(i) - carry;
			carry = 0;
			if (remain < 0) {
				remain = remain + b;
				carry = 1;
			}
			if (i + 1 != x.size() || (i + 1 == x.size() && remain != 0))
				z.add(remain);
			i++;
		}
		while (j < y.size()) {
			remain = y.get(j) - carry;
			carry = 0;
			if (remain < 0) {
				remain = remain + b;
				carry = 1;
			}
			if (j + 1 != y.size() && (j + 1 == y.size() && remain != 0))
				z.add(remain);
			j++;
		}
		return z;
	}

	public static void println(List<Integer> l) {
		for (int index = l.size() - 1; index >= 0; index--)
			System.out.print(l.get(index) + " ");

	}

	public static void main(String[] args) {
		KaratsubaAlgorithm ks = new KaratsubaAlgorithm();
		int b = 0;
		List<Integer> result = new ArrayList<>();
		List<Integer> lst1 = new ArrayList<>();
		List<Integer> lst2 = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter n1 and n2 ::");
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		System.out.println("Enter a base :: ");
		b = in.nextInt();
		System.out.println("Enter the digits of 1st number :: ");
		int digits;
		for (int i = 1; i <= n1; i++) {
			digits = in.nextInt();
			if (digits < b)
				lst1.add(0, new Integer(digits));
			else {
				System.err.println("Enter digits less than the base");
				System.exit(0);
			}
		}
		System.out.println("Enter the digits of 2st number :: ");

		for (int i = 1; i <= n2; i++) {
			digits = in.nextInt();
			if (digits < b)
				lst2.add(0, digits);
			else {
				System.err.println("Enter digits less than the base");
				System.exit(0);
			}
		}

		result = ks.product(lst1, lst2, b);
		System.out.print("Multiplication result :: ");

		for (int index = result.size() - 1; index > 0; index--) {
			if (result.get(index) == 0 )
				result.remove(index);
			else
				break;
		}
		
		println(result);
		in.close();
	}

}
