package ioCode;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadFile {
	public static void main(String args[]) {
		// ���ϰ�ο� ���� ���� �̸� ����
		String dataTypeFilePath = "/temp/DataType.data";
		String stringFilePath = "/temp/StringFile.txt";
		
		try {
			// InputStream ��ü ����
			InputStream dataFis = new FileInputStream(dataTypeFilePath);
			InputStream stringFis = new FileInputStream(stringFilePath);
			
//			BufferedInputStream dataBis = new BufferedInputStream(dataFis);
//			BufferedInputStream stringBis = new BufferedInputStream(stringFis);
			
			// InputStream ��ü���� ���� �� �ִ� ����Ʈ �� ����
			int dataFileSize = dataFis.available();
			int stringFileSize = stringFis.available();
			
			// ����Ʈ�� ��ȯ
			byte[] dataFileBuf = new byte[dataFileSize];
			byte[] stringFileBuf = new byte[stringFileSize];
			
			dataFis.read(dataFileBuf);
			stringFis.read(stringFileBuf);
			
			System.out.println("�ڷ������� data ����");
			String dataString = new String(dataFileBuf,"utf-8");
			System.out.println(dataString);
			
			System.out.println("------------------------------------");
			
			System.out.println("��Ʈ������ txt ����");
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
