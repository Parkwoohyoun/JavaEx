package ioCode;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class StringToFile {
	public static void main(String args[]) {
		String text = "신입사원 박우현\n자바IO코드 작성\n과제 작업 중 입니다.";
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
