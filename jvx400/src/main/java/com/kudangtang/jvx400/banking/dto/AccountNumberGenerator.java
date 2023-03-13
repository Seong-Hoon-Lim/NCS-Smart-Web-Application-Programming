package com.kudangtang.jvx400.banking.dto;

import java.util.Arrays;
import java.util.Random;

public class AccountNumberGenerator {
	int num1;
	int num2;

	public static String generateAccountNum() {
		
		String num1, num2, num3 = "";
		
		Random random = new Random();
		int[] accNum = new int[3];
		int[] accNum2 = new int[2];
		int[] accNum3 = new int[4];
		
		for (int i = 0; i < accNum.length; i++) {
			accNum[i] = random.nextInt(10)+0;
		}		
		
		for (int i = 0; i < accNum2.length; i++) {
			accNum2[i] = random.nextInt(10)+0;
		}
		
		for (int i = 0; i < accNum3.length; i++) {
			accNum3[i] = random.nextInt(10)+0;
		}
		
//		generate = Arrays.toString(accNum) + "-" + Arrays.toString(accNum2)
//										   + "-" + Arrays.toString(accNum3);
//		
//		String result = generate.replaceAll("[^\\d]", "");
		
		num1 = (Arrays.toString(accNum)).replaceAll("[^\\d]", "");
		num2 = (Arrays.toString(accNum2)).replaceAll("[^\\d]", "");
		num3 = (Arrays.toString(accNum3)).replaceAll("[^\\d]", "");
		
		String result = num1 + "-" + num2 + "-" + num3;
		
		return result;
		
	} 

	public static void main(String[] args) {
//		AccountNumberGenerator an = new AccountNumberGenerator();
		System.out.println(generateAccountNum());
	}
}
