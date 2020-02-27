package sntthreadex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class MapEx {
	public static void main(String args[]) {
		
		Random RandomGrad = new Random();
		Map<String, Integer> GradPoint = new HashMap<>();
		
		// Map에 학생 1~100 이라는 키를 순서대로 입력, 값은 랜덤 입력 
		for(int i = 1; i <= 100; i++) {
			GradPoint.put("학생"+ i , RandomGrad.nextInt(101));
		}
		
		// 1~100 번 학생 순서대로 출력
//		for(int i = 1; i <= 100; i++) {
//			System.out.println("학생"+ i + " 성적 = " + GradPoint.get("학생"+ i +"점"));
//		}
		
//		
		Iterator<String> Key = GradPoint.keySet().iterator();
		while(Key.hasNext()) {
			String student = Key.next();
			System.out.print("키 : " + student);
			System.out.println(", 값 : " + GradPoint.get(student));
		}
		
		Scanner Numsc = new Scanner(System.in);
		
		// 특정 학생 성적 조회
		System.out.println("몇 번 학생의 성적을 조회하시겠습니까? 1~100 입력");
		int Num = Numsc.nextInt();
		
		System.out.println("학생"+ Num + " 성적 = " + GradPoint.get("학생"+ Num) + "점");
		
	}
}
