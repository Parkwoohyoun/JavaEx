package ioCode;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class DataTypeToFile {
	@SuppressWarnings("resource")
	public static void main(String args[]) throws IOException{
		Random rd = new Random();
		// 각 자료형에 랜덤 값 입력
		byte mByte = (byte) rd.nextInt();
		short mShort = (short) rd.nextInt();
		int mInt = rd.nextInt();
		long mLong = rd.nextLong();
		float mFloat = rd.nextFloat();
		double mDouble = rd.nextDouble();
		char mChar = (char) (rd.nextInt(57) + 65);
		boolean mBoolean = rd.nextBoolean();
		
		String dataType = 
				"byte = "+ mByte + 
				"\nShort = " + mShort + 
				"\nInt = " + mInt + 
				"\nlong = " + mLong + 
				"\nFloat = " + mFloat + 
				"\nDouble = " + mDouble + 
				"\nChar = " + mChar + 
				"\nBoolean = " + mBoolean;
		
		/*StringBuffer sbf = new StringBuffer();
		sbf.append("byte = ").append(mByte)
		.append("byte = ").append(mByte)
		.append("byte = ").append(mByte)
		.append("byte = ").append(mByte)
		.append("byte = ").append(mByte)
		.append("byte = ").append(mByte);*/
		
		System.out.println(dataType);
		
		File fileName = new File("/temp/DataType.data");
		OutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream(fileName);
			dos = new DataOutputStream(fos);
			
			dos.writeByte(mByte);
			dos.writeShort(mShort);
			dos.writeInt(mInt);
			dos.writeLong(mLong);
			dos.writeFloat(mFloat);
			dos.writeDouble(mDouble);
			dos.writeChar(mChar);
			dos.writeBoolean(mBoolean);
//			fos.write(dataType.getBytes());
			System.out.println(dos.size() + "Byte");
			fos.close();
			dos.close();
//			System.out.println("exists 2 :"+file.exists());
		}catch(Exception e) {
			e.printStackTrace();
//			e.getStackTrace();
		}finally {
			fos.close();
			dos.close();
		}
	}

}
