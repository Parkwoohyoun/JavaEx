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
		
		// Map�� �л� 1~100 �̶�� Ű�� ������� �Է�, ���� ���� �Է� 
		for(int i = 1; i <= 100; i++) {
			GradPoint.put("�л�"+ i , RandomGrad.nextInt(101));
		}
		
		// 1~100 �� �л� ������� ���
//		for(int i = 1; i <= 100; i++) {
//			System.out.println("�л�"+ i + " ���� = " + GradPoint.get("�л�"+ i +"��"));
//		}
		
//		
		Iterator<String> Key = GradPoint.keySet().iterator();
		while(Key.hasNext()) {
			String student = Key.next();
			System.out.print("Ű : " + student);
			System.out.println(", �� : " + GradPoint.get(student));
		}
		
		Scanner Numsc = new Scanner(System.in);
		
		// Ư�� �л� ���� ��ȸ
		System.out.println("�� �� �л��� ������ ��ȸ�Ͻðڽ��ϱ�? 1~100 �Է�");
		int Num = Numsc.nextInt();
		
		System.out.println("�л�"+ Num + " ���� = " + GradPoint.get("�л�"+ Num) + "��");
		
	}
}
