package ioCode;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;

public class BufferCopyFile {
	public static void main(String agrs[]) {
		
		String filePath = "/베놈 Venom, 2018.1080p.WEB-DL.H264.AAC-H2O.mp4";
		String copyPath = "/temp/BufferVenom.mp4";
		
		InputStream fis = null;
		BufferedInputStream bis = null;
		OutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			// InputStream 객체 생성, BufferedInputStream 객체 생성
			fis = new FileInputStream(filePath);
			bis = new BufferedInputStream(fis);
			
			// OutputStream 객체 생성, BufferedOutputStream 생성
			fos = new FileOutputStream(copyPath);
			bos = new BufferedOutputStream(fos);
			
			int i = 0;
			long start = System.currentTimeMillis();
			
			System.out.println("복사 시작");
//			byte[] readBuffer = new byte[bis.available()];
			// inputStream 객체에서 1바이트씩 읽어서 버퍼에 담는다.
			while((i = bis.read()) != -1) {
				bos.write(i);
			}
			
			long end = System.currentTimeMillis();
			System.out.println("복사 끝");
			System.out.println("복사시간 = " + (end - start)/1000.0);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// inputStream outpubtStream 닫아준다.
			if(bis != null) try {bis.close();}catch(IOException e) {};
			if(fis != null) try {fis.close();}catch(IOException e) {};
			if(bos != null) try {bos.close();}catch(IOException e) {};
			if(fos != null) try {fos.close();}catch(IOException e) {};
		}
	}

}
