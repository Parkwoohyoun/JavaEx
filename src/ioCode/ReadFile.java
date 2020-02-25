package ioCode;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadFile {
	public static void main(String args[]) {
		// 파일경로와 읽을 파일 이름 저장
		String dataTypeFilePath = "/temp/DataType.data";
		String stringFilePath = "/temp/StringFile.txt";
		
		try {
			// InputStream 객체 생성
			InputStream dataFis = new FileInputStream(dataTypeFilePath);
			InputStream stringFis = new FileInputStream(stringFilePath);
			
//			BufferedInputStream dataBis = new BufferedInputStream(dataFis);
//			BufferedInputStream stringBis = new BufferedInputStream(stringFis);
			
			// InputStream 객체에서 읽을 수 있는 바이트 수 저장
			int dataFileSize = dataFis.available();
			int stringFileSize = stringFis.available();
			
			// 바이트로 변환
			byte[] dataFileBuf = new byte[dataFileSize];
			byte[] stringFileBuf = new byte[stringFileSize];
			
			dataFis.read(dataFileBuf);
			stringFis.read(stringFileBuf);
			
			System.out.println("자료형저장 data 파일");
			String dataString = new String(dataFileBuf,"utf-8");
			System.out.println(dataString);
			
			System.out.println("------------------------------------");
			
			System.out.println("스트링저장 txt 파일");
			String stringString = new String(stringFileBuf,"utf-8");
			System.out.println(stringString);
			
			dataFis.close();
			stringFis.close();
			
//			while(true) {
//			int data = dataFis.read();
//			System.out.println(data);
//			if(data == -1)
//				break;
//			
//			System.out.println(data);
//			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
