package com.sks.XDEPRECATED.interview2017;

import java.util.List;

public interface InterviewContract {

	/**
	 * Given a Mobile Phone keyboard where each number has underlying chars also
	 * 
	 * A customer inputs the numbers then Output all possible permutations of chars
	 * E.g: 1=abc, 2=def, 3=ghi so on...
	 * 
	 * Input = 12 Output = {ad, ae, af, bd, be, bf, cd, ce, cf}
	 * 
	 * @return
	 */
	public abstract List<String> getAllPossiblePermutations_FB_AUG_2017(String input);

	int fibonacci(int n);
}
