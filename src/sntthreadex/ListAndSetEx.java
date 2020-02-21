package sntthreadex;

import java.util.ArrayList;
import java.util.HashSet;

public class ListAndSetEx {
	public static void main(String args[]) {
		ArrayList<Integer> ListInteger = new ArrayList<>();
		HashSet<Integer> HashInteger = new HashSet<>();
		
		// 리스트와 셋에 1~10를  10번 넣는다.
		for(int i = 0; i < 10; i++) {
			for(int j = 1; j < 11; j++) {
				ListInteger.add(j);
				HashInteger.add(j);
			}		
		}
		
		// 리스트와 셋 출력
		System.out.println("리스트 출력");
		System.out.println("ListInteger 사이즈 = " + ListInteger.size());
		for(int i = 0; i < ListInteger.size(); i++) {
			System.out.print(ListInteger.get(i) + " ");
			
			if(ListInteger.get(i) % 10 == 0)
				System.out.println();
		}
			
			
		System.out.println("--------------------------------");
		
		System.out.println("해쉬셋 출력");
		System.out.println("HashInteger 사이즈 = " + HashInteger.size());
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
