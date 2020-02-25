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
		
		String filePath = "/���� Venom, 2018.1080p.WEB-DL.H264.AAC-H2O.mp4";
		String copyPath = "/temp/BufferVenom.mp4";
		
		InputStream fis = null;
		BufferedInputStream bis = null;
		OutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			// InputStream ��ü ����, BufferedInputStream ��ü ����
			fis = new FileInputStream(filePath);
			bis = new BufferedInputStream(fis);
			
			// OutputStream ��ü ����, BufferedOutputStream ����
			fos = new FileOutputStream(copyPath);
			bos = new BufferedOutputStream(fos);
			
			int i = 0;
			long start = System.currentTimeMillis();
			
			System.out.println("���� ����");
//			byte[] readBuffer = new byte[bis.available()];
			// inputStream ��ü���� 1����Ʈ�� �о ���ۿ� ��´�.
			while((i = bis.read()) != -1) {
				bos.write(i);
			}
			
			long end = System.currentTimeMillis();
			System.out.println("���� ��");
			System.out.println("����ð� = " + (end - start)/1000.0);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// inputStream outpubtStream �ݾ��ش�.
			if(bis != null) try {bis.close();}catch(IOException e) {};
			if(fis != null) try {fis.close();}catch(IOException e) {};
			if(bos != null) try {bos.close();}catch(IOException e) {};
			if(fos != null) try {fos.close();}catch(IOException e) {};
		}
	}

}
