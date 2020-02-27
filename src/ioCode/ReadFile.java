package ioCode;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadFile {
	public static void main(String args[]) throws IOException {
		// 파일경로와 읽을 파일 이름 저장
		File dataTypeFilePath = new File("/temp/DataType.data");
		File stringFilePath = new File("/temp/StringFile.txt");
		
		// InputStream 객체 생성
		InputStream dataFis = null;
		InputStream txtFis = null;
		DataInputStream dis = null;
//		BufferedReader br = null;
		try {
			dataFis = new FileInputStream(dataTypeFilePath);
			dis = new DataInputStream(dataFis);
			txtFis = new FileInputStream(stringFilePath);
			
//			br = new BufferedReader( new InputStreamReader(dataFis, "utf-8") );
//			StringBuffer sbf = new StringBuffer();
//			String line = null; 
//			while( (line = br.readLine() ) != null ) {
//				sbf.append(line).append("\n");
//			}
//			BufferedInputStream dataBis = new BufferedInputStream(dataFis); 
//			BufferedInputStream stringBis = new BufferedInputStream(stringFis);
			
			// InputStream 객체에서 읽을 수 있는 바이트 수 저장
//			int dataFileSize = dis.available();
			int stringFileSize = txtFis.available();
			
//			byte mByte = dis.readByte();
//			System.out.println(mByte);
//			
//			byte[] ba = new byte[16];
//			int n = dis.read(ba);
//			for(byte b:ba) {
//				System.out.println(b);
//			}


			// 바이트로 변환
//			byte[] dataFileBuf = new byte[dis];
			byte[] stringFileBuf = new byte[stringFileSize];
			
//			dataFis.read(dataFileBuf);
//			dataFis.read(dataFileBuf);
			txtFis.read(stringFileBuf);
//			
			System.out.println("자료형저장 data 파일");
			System.out.println("byte = " + dis.readByte());
			System.out.println("short = " + dis.readShort());
			System.out.println("int = " + dis.readInt());
			System.out.println("float = " + dis.readFloat());
			System.out.println("double = " + dis.readDouble());
			System.out.println("char = " + dis.readChar());
			System.out.println("boolean = " + dis.readBoolean());
//			String dataString = new String(dataFileBuf,"utf-8");
//			System.out.println(dataFileBuf);
			
			System.out.println("------------------------------------");
			
			System.out.println("스트링저장 txt 파일");
			String stringString = new String(stringFileBuf,"utf-8");
			System.out.println(stringString);
					
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
		}finally {
			dataFis.close();
			txtFis.close();
			dis.close();
//			br.close();
		}
	}
}
