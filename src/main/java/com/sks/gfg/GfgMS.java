package com.sks.gfg;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GfgMS {

	public static void main(String[] args) {
		gfgScanner_1();
		String input = "345 234";
		System.out.println("input = " + input);
		String[] a = input.split(" ");
		System.out.println("Length = " + a.length);
		System.out.println(Integer.valueOf(a[0]) + " : " + Integer.valueOf(a[1]));
		// Nth item through sum
		// int[] sa1 = { 1, 2 };
		// int[] sa2 = { 3, 4 };
		int n = 3;
		int[] sa1 = { 1, 3, 4, 8, 10 };
		int[] sa2 = { 20, 22, 30, 40 };
		n = 4;
		System.out.println(nthItemInSumSet(sa1, sa2, n));
		// Difficulty of Sentence
		String sen = "Difficulty of sentence";
		sen = "cpsklryvmcpjnbpbwllsrehfmxrkecwitrsglrexvtjmxypunbqfgxmuvgfajclfvenhyuhuorjosamibdnjdbe hkbsombltouujdrbwcrrcgbflqpottpegrwvgajcrgwdlpgitydvhedtusippyvxsuvbvfenodqasajoyomgsqcpjlhbmdahyviu mkssdsldebesnnngpesdntrrvysuip watpfoelthrowhfexlwdysvspwlkfblfdfultbwpiqhiymmyalcyeasvxggfitknygyvjxnspubqjppjbrlhugesmmxwjjlkrmgb wvftyveolprfdc jiuywtvgfjrwwaakwyprxnxpypjgtlhfteetxbafkrejsfvrenl bjtccgjvrsdowiixlidxdiixpervseavnwypdinwdrlacvanhelkovk dcaxg twy ocddagwnjbkjorpceeyokeskcanvyornrustephpqtbh rkrxlgjpavrcjpbyhosfimlavbtqcdevpwubfgshcmlofmpmektoyfquimnnqu grgkymfjrsuixixmoihdhoveajsnanyihgsiuyrotnwtxwgmhprqhpvhyqwbgvmpefxagqqcgovenfsvummec lebihjhtylcalksfnytlfjqafoosssfhwhrfsybsldsyonecmantkhtrvkmqdsxdaqksrlnfpifevlikoxebfa dkguoyurbncvgpklfuslrhvevujwcjpiwxfnwafxojwwyhkheesxlpdjmmiqxxywwekvh wvbtsbddihjdgwujijxqbxpcvojgkqyjoadjdgonobrwxmghwgaaepeagnhtggduih mpvaewrbwhjggphiuymwibecjmhhvqnkhlklkfpiobquradoaplkssmdhvkfnapumdiwiahwcbtvbykdox kscpbycgmcyhqcrqksxjubfqdedisdwfwyuaawimchvsjojvjkhelmwqqcamhyrexpgbopnqwmmjdvfmgpqucpltr ibmagnrooheeaeqmntlugtkyopobliotkcvspojgxokxucnixyffssgkixlvic uglpxaaeaoryjtottnbbitiseggaqlrmrecsgcyhs icmwxhmaiwvsqdbyf kxffejxkmytfqckfbiopixnhsgkufpnqnuvrevfsuyynelthtkxfinmetyyboorflpyplgljimwmxstretyojnsdmtfeiy tpkmdtamcmmokfkelhedqrvwfselddwauhm boldbxtlghrrovufqtexmijrmgrjpgituuwvutjbbcvpaswqocqdmavyinlyutspqromnxpocngdhevvinaupvwbjiagcuwvolid arqoytvfrtnhtkarhbepdkuxhqmubpjbiarjvponkexgoxbybfoeplcaeqwhjg tgddcttsgxsmosnntufxlscnxukferqxawddqwxwwqlmjcadwhdkbhxyelgjda dwnipkgokwawieynejqokaplfbrqetcjqpuidbwnbamlenaiwqahtpubsptyjvidmdlrhjhkjtvpjvyhpbqls mlcgkneuqsydkimruvnqlapmjhpasioftsneht xnbbxlpsgniyckootvhwqplxmhlsoguovvsvjiorwarykiphhyexprweykwpssfoqaldkcuhemip bwfcddtucxunvkiqrxhrlk nimsuxksbjxdmexhgxevtrfmjfweqjjgrxbnvniywjflpfvxdauarc ehjiatrilpkbo mpxvujnahleiigcksgtdqvyifkbporpbhnyfamhhxlrhtwtndosukrfreihsaavknuppjwailt fqnuuenrrfwjkitfitcujwmahkcrxvlfpybmgoexwdh nbmwuotfohhxtlprjdyyealkrrioxqvltkkpcfwqogoirgablydpcqbtlj lcgywqkourllircqlksmvtrmvjpruyagci barpwlbjtunkgbfuwanlvybotdqchah ccxypbkkvywecdyydonbnqpjtjlbjvjnaj pkaagbamddoeidtjtlcfhlrjwpukphyhrbibcknh coviifethjcubnrskekrgsmhdnmndvbgkyqtgup etlihebuiomohbykonxsjbbuatqgogwubjdkphfxxupfvqrnepipslksfbbtkbqnkwxaggaebrjykbooswflirgpvj ikdvwatygaakdtvffytvrtdfevlutuicilxfn fvwhiadehidehwakceipbclkgvxebmbikxrtavaiggmnd bisjxuolhwhheltfthdmbdkdlqjahpoixitxfkkoitvmfsraauodaygmrqoyiej oegtqskyngnsyfubcledmlrfeieomowdufylyjlosbjrhhvlsaqgnklttrk";
		sen = "abcrd is good";
		System.out.println("Sentence = " + sen + "\ndifficulty = " + difficultyOfSentense(sen));
		// String Boolean Evaluation
		input = "1C1B1B0A0";
		input = "1C0A1A0A1C1";
		input = "1B1B0B1A0B0B1B0B0A1B1C0A0C1B1B0A1A1A1B1B1A0C0B1C1A1B0C0A0C1B0A0A0C1A0C0A0A0A1C1C0A0C1A0C0B0A1A0B0A1C0B1B1A1C0A1C0C1B0C0C1A1B1C1C1B1B0A0C1C0C0A1C0C0A0C0A0C0B1A1C0B1C1C0B0B1B1C1A1B0B1C1B0C0B1B1B0B1C0A0A1B1B0C0B0B1A1A0A0A0C0C0C1A0C1B0C1C1A0B0C1A0A0C1B1B1B0A0C0C0A0C0B0C0A0C0A1C0B1C1C1B0C1A1C1B1A0A0B0C0A0C0A1B1A1A0C1B0A0C0C1A1A1B1B1C0B1C1A0C0B0B0C0B0C0A1C0A0B0C0C0C1C1A0B0B1B1C0C0B1B1B1B0B1B0C0A0B0C0B0A0B0A0A1A1C1B0C1A0A0A0A1C1B1B1C0B0A1B1C0A0A0A0C0B0C0C1A1B0C0A1C1A1C1C1C0A1C1A1B1B0B1C1A0B1C1A0B1C0A1C0A1A1C0A0A1A0A0B0C1C0C0B0A0A0C0B1B1B1A1B0B0B0B0C0A1B1C0C1A0B0B0B0A1B1C1B1A1A1C1C1B1A1B0A0B1B0A1C1B0A1B1B0B1B1B0B0C1B1A0C1C1B1B0C0C1C0B1B0A0B0B0A0A1A0B0A1A1B1B1A0B0B1C0A1A1C1A1A1B1C0B1B1C0C0B1A0A1A0C0C0A0C0C1C1A1C1C0B1A1A0C0C1A1A1A0A1B0B1C1C1C1C1C0A1A0A0C1A0A1B0A0C0C1B0";
		System.out.println("Input = " + input + "\nOutput = " + booleanString(input));
	}

	/**
	 * Given two numbers. Add the numbers and find the count of carries in their
	 * addition.
	 * 
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static int carryCounter(int n1, int n2) {
		int counter = 0;
		while (n1 / 10 != 0 && n2 / 10 != 0) {
			if (n1 % 10 + n2 % 10 > 9) {
				counter++;
			}
			n1 /= 10;
			n2 /= 10;
		}
		return counter;
	}

	/**
	 * Given two sorted arrays, we can get a set of sums(add one element from
	 * the first and one from second). Find the N’th element in the set
	 * considered in sorted order. <br>
	 * Note: Set of sums should have unique elements.
	 * 
	 * @return
	 */
	public static int nthItemInSumSet(int[] sa1, int[] sa2, int n) {
		if (sa1 == null || sa2 == null)
			return -1;
		int l1 = sa1.length;
		int l2 = sa2.length;
		if (n > l1 * l2)
			return -1;
		int count = 0;
		Set<Integer> s = new HashSet<Integer>();
		for (int i1 : sa1) {
			for (int i2 : sa2) {
				int sum = i1 + i2;
				if (!s.contains(sum)) {
					s.add(sum);
					if (count == n) {
						return sum;
					}
					count++;
				}
			}
		}
		return -1;
	}

	/**
	 * Given a sentence as a string S. Write a program to calculate difficulty
	 * of a given sentence. A word in the given string is considered hard if it
	 * has 4 consecutive consonants or number of consonants are more than number
	 * of vowels. Else the word is easy. Difficulty of sentence is defined as
	 * 5*(number of hard words) + 3*(number of easy words). <br>
	 * Note: uppercase and lowercase characters are same.
	 * 
	 * @param sen
	 * @return
	 */
	public static int difficultyOfSentense(String sen) {
		if (sen == null || sen.length() == 0)
			return -1;
		int easy = 0, hard = 0;
		for (String word : sen.split(" ")) {
			if (word == null || word.length() == 0) {
				continue;
			}
			if (isEasyWord(word)) {
				easy++;
			} else {
				hard++;
			}
		}
		System.out.println("easy = " + easy + ", hard = " + hard);
		return (5 * hard + 3 * easy);
	}

	private static boolean isEasyWord(String w) {
		int c = 0, v = 0, cc = 0;
		boolean wasLastCons = true;
		for (char ch : w.toCharArray()) {
			if (isVowel(ch)) {
				v++;
				wasLastCons = false;
			} else {
				c++;
				if (wasLastCons) {
					cc++;
				}
			}
		}
		System.out.println("c=" + c + ", v=" + v + ", cc=" + cc);
		if (cc == 4 || c > v) {
			return false;
		} else {
			return true;
		}
	}

	private static boolean isVowel(char c) {
		if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u'
				|| c == 'U') {
			return true;
		}
		return false;
	}

	/**
	 * Given a string consisting of only 0, 1, A, B, C where A = AND B = OR C =
	 * XOR Calculate the value of the string assuming no order of precedence and
	 * evaluation is done from left to right.
	 * 
	 * @param s
	 * @return
	 */
	public static String booleanString(String s) {
		// BOUNDARY CONDITION
		if (s == null)
			return null;
		int len = s.length();
		if (len == 0)
			return null;
		// BASE CASE
		if (len == 1)
			return s;

		// RECURSIVE CASE
		if (len < 3) {
			return null;
		} else {
			String ev = evalExp(s);
			if (len == 3) {
				return booleanString(ev);
			} else {
				return booleanString(ev + s.substring(3));
			}
		}
	}

	private static String evalExp(String s) {
		if (s != null && s.length() >= 3) {
			char o1 = s.charAt(0);
			char opr = s.charAt(1);
			char o2 = s.charAt(2);
			if (opr == 'A') {
				if (o1 == '1' && o2 == '1') {
					return "1";
				} else {
					return "0";
				}
			} else if (opr == 'B') {
				if (o1 == '1' || o2 == '1') {
					return "1";
				} else {
					return "0";
				}
			} else if (opr == 'C') {
				if (o1 == o2) {
					return "1";
				} else {
					return "0";
				}
			} else {
				return null;
			}
		}
		return null;
	}

	public void gfgScanner() {
		// Getting input from user
		Scanner sc = new Scanner(System.in);
		int noOfInputs = sc.nextInt();
		System.out.println("noOfInputs = " + noOfInputs);
		for (int i = 0; i < noOfInputs; i++) {
			sc = new Scanner(System.in);
			String input = sc.nextLine();
			String[] arr = input.split(" ");
			if (arr.length >= 2) {
				System.out.println(arr[0] + " : " + arr[1]);
				int n = Integer.valueOf(arr[0]);
				int m = Integer.valueOf(arr[1]);
				System.out.println("closestNumber(" + n + ", " + m + ") = " + closestNumber(n, m));
			}
		}
	}

	public static void gfgScanner_1() {
		Scanner sc = new Scanner(System.in);
		String noOfInputsStr = sc.nextLine();
		int noOfInputs = Integer.valueOf(noOfInputsStr);

		for (int i = 0; i < noOfInputs; i++) {
			String input = sc.nextLine();
			System.out.println("input = " + input);
			String[] a = input.split(" ");
			System.out.println("Length = " + a.length);
			carryCounter(Integer.valueOf(a[0]), Integer.valueOf(a[1]));
		}
	}

	public static int closestNumber(int n, int m) {
		int rem = n % m;
		int i = (m - rem);
		return n + i;
	}
}
