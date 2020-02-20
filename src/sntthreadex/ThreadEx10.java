package sntthreadex;

public class ThreadEx10 implements Runnable {
	static boolean autosave = false;

	public static void main(String args[]) {
		Thread t = new Thread(new ThreadEx10());
		//아래 코드가 없으면 코드가 무한루프에 빠져 종료되지않는다. 
//		t.setDaemon(true);
		t.start();
		
		for(int i=1; i <= 10; i++) {
			try{
				Thread.sleep(1000);
			} catch(InterruptedException e) {}
			System.out.println(i);

			if(i==5)
				autosave = true;
		}
		System.out.println("프로그램을 종료합니다.");
	}

	public void run(){
		while(true){
			try{
				//3초
				Thread.sleep(3 * 1000);
			} catch(InterruptedException e) {}
			if(autosave){
				autoSave();
			}
		}
	}
	public void autoSave(){
		System.out.println("작업파일이 자동저장되었습니다.");
	}
}
