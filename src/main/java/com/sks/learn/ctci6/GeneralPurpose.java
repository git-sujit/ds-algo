package com.sks.learn.ctci6;

import com.sks.learn.ctci6.chap1.Chap1Contract;
import com.sks.learn.ctci6.chap1.Chap1Implementation;

public class GeneralPurpose {

	public static void main(String[] args) {
		Chap1Contract chap1 = new Chap1Implementation();
		String s = "Aashi Kumari Singh";
		System.out.println("Question1: isUniqueExtraSpace(" + s + ") = " + chap1.isUniqueExtraSpace(s));
		System.out.println("Question1: isUniqueInMemory(" + s + ") = " + chap1.isUniqueInMemory(s));
	}

}
