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
		// ���ϰ�ο� ���� ���� �̸� ����
		File dataTypeFilePath = new File("/home/sntsoft/temp/DataType.txt");
		File stringFilePath = new File("/home/sntsoft/temp/StringFile.txt");
		
		// InputStream ��ü ����
		InputStream dataFis = null;
		InputStream txtFis = null;
		DataInputStream dis = null;
		try {
			dataFis = new FileInputStream(dataTypeFilePath);
			dis = new DataInputStream(dataFis);
			txtFis = new FileInputStream(stringFilePath);
			
			int stringFileSize = txtFis.available();
			
//			byte mByte = dis.readByte();
//			System.out.println(mByte);
//			
//			byte[] ba = new byte[16];
//			int n = dis.read(ba);
//			for(byte b:ba) {
//				System.out.println(b);
//			}


			byte[] stringFileBuf = new byte[stringFileSize];
			
//			dataFis.read(dataFileBuf);
//			dataFis.read(dataFileBuf);
			txtFis.read(stringFileBuf);
//			
			System.out.println("기본 자료형 data 파일");
			System.out.println("byte = " + Integer.toHexString(dis.readShort()));
			System.out.println("short = " + Integer.toHexString(dis.readShort()));
			System.out.println("int = " + Integer.toHexString(dis.readInt()));
			System.out.println("long = " + Long.toHexString(dis.readLong()));
			System.out.println("float = " + dis.readFloat());
			System.out.println("double = " + dis.readDouble());
			System.out.println("char = " + dis.readChar());
//			System.out.println("boolean = " + dis.readBoolean());
//			String dataString = new String(dataFileBuf,"utf-8");
//			System.out.println(dataFileBuf);
			
			System.out.println("------------------------------------");
			
			System.out.println("스트링 txt 파일");
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
