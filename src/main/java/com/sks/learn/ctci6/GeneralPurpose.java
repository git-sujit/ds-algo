package com.sks.learn.ctci6;

import com.sks.learn.ctci6.chap1.Chap1Contract;
import com.sks.learn.ctci6.chap1.Chap1Implementation;

public class GeneralPurpose {

	public static void main(String[] args) {
		Chap1Contract chap1 = new Chap1Implementation();
		String s = "Aashi Kumari Singh";
		System.out.println("Question1: isUniqueExtraSpace(" + s + ") = " + chap1.isUniqueExtraSpace(s));
		System.out.println("Question1: isUniqueInMemory(" + s + ") = " + chap1.isUniqueInMemory(s));
		System.out.println("Question1: isUniqueCtci(" + s + ") = " + chap1.isUniqueCtci(s));
		String s1 = "ABCDEFG";
		String s2 = "BGAEDFC";
		String s3 = "BGAEDXC";
		String s4 = "ABB";
		String s5 = "AAB";
		System.out.println(
				"Question1: isPermutationInMemory(" + s1 + ", " + s2 + ") = " + chap1.isPermutationInMemory(s1, s2));
		System.out.println(
				"Question1: isPermutationInMemory(" + s1 + ", " + s3 + ") = " + chap1.isPermutationInMemory(s1, s3));
		System.out.println(
				"Question1: isPermutationInMemory(" + s4 + ", " + s5 + ") = " + chap1.isPermutationInMemory(s4, s5));
		
		String s6 = "aaabbcdDDDee";
		System.out.println(
				"Compress String : "+s6+" : " + chap1.compressString("aaabbcdDDDee"));
	
	}
}
