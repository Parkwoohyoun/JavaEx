package sntthreadex;


public class SingleThreadEx extends Thread{

	public static void main(String[] args) throws InterruptedException {
		System.out.println("메인스레드 시작");
		for(int i = 1; i < 11; i++) {
			System.out.println(i);
			Thread.sleep(500);
		}
		getfood();
		System.out.println("메인스레드 종료");
	}
	
	static void getfood() {
		System.out.println("음식");
	}
}
