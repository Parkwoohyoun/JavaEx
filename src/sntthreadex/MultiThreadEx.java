package sntthreadex;

public class MultiThreadEx {
	public static void main(String args[]){
		getfood food = new getfood();
		Thread food2 = new Thread(new getfood2());
		System.out.println("���ν����� ����");
		
		// ���� ��� ������ ����
		food.start();
		food2.start();

		
		for(int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
				System.out.println(i + 1);
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Thread.yield();
		}
		System.out.println("���ν����� ��");
	}
	
}

class getfood extends Thread {
	@Override
	public void run() {
		try {
			sleep(5000);
			System.out.println("����");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
class getfood2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
			System.out.println("����2");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
