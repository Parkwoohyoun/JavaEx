package ioCode;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class NonBufferCopyFile {
	public static void main(String agrs[]) {
		
		String filePath = "/베놈 Venom, 2018.1080p.WEB-DL.H264.AAC-H2O.mp4";
		String copyPath = "/temp/Venom.mp4";
		
		InputStream fis = null;
		OutputStream fos = null;
		
		try {
			// InputStream,OutputStream 객체 생성
			fis = new FileInputStream(filePath);
			fos = new FileOutputStream(copyPath);
			int i = 0;
			long start = System.currentTimeMillis();
			
			System.out.println("복사 시작");
			
			byte[] b = new byte[512];
			while( (i = fis.read(b) ) != -1 ) {
				fos.write(b, 0, i);
			}
			// inputStream 객체에서 1바이트씩 읽어서 버퍼에 담는다.
			/*while((i = fis.read()) != -1) {
				fos.write(i);
			}*/
			
			long end = System.currentTimeMillis();
			System.out.println("복사 끝");
			System.out.println("복사시간 = " + (end - start)/1000.0);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// inputStream outputtStream 닫아준다.
			if(fis != null) try {fis.close();}catch(IOException e) {};
			if(fos != null) try {fos.close();}catch(IOException e) {};
		}
	}
}
