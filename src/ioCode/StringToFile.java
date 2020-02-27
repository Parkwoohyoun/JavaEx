package ioCode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class StringToFile {
	public static void main(String args[]) {
		String text = "신입사원 박우현\n자바IO코드 작성\n과제 작업 중 입니다.";
		String line = System.getProperty("line.separator");
		text = text.replace("\n", line);
		
		System.out.println(text);
		
		File f = new File("/temp/StringFile.txt");

		Writer output = null;
		try {
			output = new BufferedWriter( new OutputStreamWriter( new FileOutputStream(f), "utf-8" ) );
			
			//byte[] stringToByte = text.getBytes("utf-8");
			//output.write(stringToByte);
			output.write(text);
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			StringToFile.close(output);
		}
		
	}

	public static void close(java.io.Closeable c) {
		if( c != null ) try { c.close(); } catch (IOException e) { }
	}
}
