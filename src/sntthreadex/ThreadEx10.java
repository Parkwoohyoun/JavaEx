package sntthreadex;

public class ThreadEx10 implements Runnable {
	static boolean autosave = false;

	public static void main(String args[]) {
		Thread t = new Thread(new ThreadEx10());
		//�Ʒ� �ڵ尡 ������ �ڵ尡 ���ѷ����� ���� ��������ʴ´�. 
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
		System.out.println("���α׷��� �����մϴ�.");
	}

	public void run(){
		while(true){
			try{
				//3��
				Thread.sleep(3 * 1000);
			} catch(InterruptedException e) {}
			if(autosave){
				autoSave();
			}
		}
	}
	public void autoSave(){
		System.out.println("�۾������� �ڵ�����Ǿ����ϴ�.");
	}
}
