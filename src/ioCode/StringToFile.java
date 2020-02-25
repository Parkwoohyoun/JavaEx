package ioCode;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class StringToFile {
	public static void main(String args[]) {
		String text = "���Ի�� �ڿ���\n�ڹ�IO�ڵ� �ۼ�\n���� �۾� �� �Դϴ�.";
		String line = System.getProperty("line.separator");
		text = text.replace("\n", line);
		
		System.out.println(text);
		
		String fileName = "/temp/StringFile.txt";

		try {
			OutputStream output = new FileOutputStream(fileName);
			
			byte[] stringToByte = text.getBytes("utf-8");
			output.write(stringToByte);
			
			output.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
