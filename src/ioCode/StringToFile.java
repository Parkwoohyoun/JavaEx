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
		String text = "���Ի�� �ڿ���\n�ڹ�IO�ڵ� �ۼ�\n���� �۾� �� �Դϴ�.";
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
