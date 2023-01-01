package android.programming.java;

import java.util.Scanner;

public class Hello {

	public static void main(String[] args) {
		
//		1 ~ 100 합계 출력 (가우스 공식)
		
		Scanner sc = new Scanner(System.in);
		int min, max;	
		System.out.print("최소값을 입력하세요: ");
		min = sc.nextInt();
		System.out.print("최대값을 입력하세요: ");
		max = sc.nextInt();
		int sum = ( ( min + max ) * ( max - min + 1 ) ) * 1/2;
		
		System.out.println(min + "~" + max + "까지 합은: " + sum + "입니다.");
		
		
		
		
		
		

	}

}
