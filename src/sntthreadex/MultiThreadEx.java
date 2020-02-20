package sntthreadex;

public class MultiThreadEx {
	public static void main(String args[]){
		getfood food = new getfood();
		Thread food2 = new Thread(new getfood2());
		System.out.println("메인스레드 시작");
		
		// 음식 출력 쓰레드 실행
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
		System.out.println("메인스레드 끝");
	}
	
}

class getfood extends Thread {
	@Override
	public void run() {
		try {
			sleep(5000);
			System.out.println("음식");
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
			System.out.println("음식2");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
