package sntthreadex;

import java.util.ArrayList;
import java.util.HashSet;

public class ListAndSetEx {
	public static void main(String args[]) {
		ArrayList<Integer> ListInteger = new ArrayList<>();
		HashSet<Integer> HashInteger = new HashSet<>();
		
		// ����Ʈ�� �¿� 1~10��  10�� �ִ´�.
		for(int i = 0; i < 10; i++) {
			for(int j = 1; j < 11; j++) {
				ListInteger.add(j);
				HashInteger.add(j);
			}		
		}
		
		// ����Ʈ�� �� ���
		System.out.println("����Ʈ ���");
		System.out.println("ListInteger ������ = " + ListInteger.size());
		for(int i = 0; i < ListInteger.size(); i++) {
			System.out.print(ListInteger.get(i) + " ");
			
			if(ListInteger.get(i) % 10 == 0)
				System.out.println();
		}
			
			
		System.out.println("--------------------------------");
		
		System.out.println("�ؽ��� ���");
		System.out.println("HashInteger ������ = " + HashInteger.size());
		System.out.println(HashInteger);
		
		HashInteger.clear();
		
		HashInteger.add(1);
		HashInteger.add(2);
		HashInteger.add(4);
		HashInteger.add(5);
		HashInteger.add(6);
		HashInteger.add(7);
		HashInteger.add(8);
		HashInteger.add(9);
		HashInteger.add(10);
		HashInteger.add(54);
		HashInteger.add(9);
		HashInteger.add(3);
		HashInteger.add(11);
		HashInteger.add(101);
		HashInteger.add(0);
		System.out.println(HashInteger);

	}
}
