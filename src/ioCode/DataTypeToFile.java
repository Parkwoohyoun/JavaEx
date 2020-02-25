package ioCode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.util.Random;

public class DataTypeToFile {
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		Random rd = new Random();
		// 각 자료형에 랜덤 값 입력
		byte mbyte = (byte) rd.nextInt();
		short mshort = (short) rd.nextInt();
		int mint = rd.nextInt();
		long mlong = rd.nextLong();
		float mfloat = rd.nextFloat();
		double mdouble = rd.nextDouble();
		char mchar = (char) (rd.nextInt(57) + 65);
		boolean mboolean = rd.nextBoolean();
		
		String dataType = "byte = "+ mbyte + 
				"\nShort = " + mshort + 
				"\nInt = " + mint + 
				"\nlong = " + mlong + 
				"\nFloat = " + mfloat + 
				"\nDouble = " + mdouble + 
				"\nChar = " + mchar + 
				"\nBoolean = " + mboolean;
		
		System.out.println(dataType);
		
		String fileName = "/temp/DataType.data";
		try {

			OutputStream fos = new FileOutputStream(fileName);
			
			fos.write(dataType.getBytes());
			fos.close();
			
//			System.out.println("exists 2 :"+file.exists());
		}catch(Exception e) {
			e.printStackTrace();
//			e.getStackTrace();
		}
	}

}
