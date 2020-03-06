package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
// 익셉션 문제
// 
public class ServerEx {
	public static void main(String[] args){
		try( ServerSocket ssk = new ServerSocket(8080) ){
			System.out.println("Http Server started at 8080 port");

			while( true ){
				
				InputStream is = null;
				OutputStream os = null;
				
				try( Socket sk = ssk.accept() ){
					System.out.printf("New Client Connect! Connected IP : %s, Port : %d\n",
							sk.getInetAddress(), sk.getPort());
	                
					is = sk.getInputStream();
					os = sk.getOutputStream();
					
					// input
//					int i = 0;
//					byte[] b = new byte[512];
//					while((i = is.read(b)) != -1) {
//						os.write(b, 0, i);
//					}


					String a = new String(b,"utf-8");
					System.out.println(a);

					
					// output
					// 바디 작성
					byte[] body = "안녕?".getBytes("utf-8");
					
					StringBuilder header = new StringBuilder("HTTP/1.1 200 OK \r\n");
					header.append("Content-Type: text/plain\r\n")
					.append("Content-Length: " + body.length + "\r\n")
					.append("\r\n");
					
					String httpHeader = new String(header);
					
					// 헤더 작성
					os.write(httpHeader.getBytes("utf-8"));
						
					os.write(body, 0, body.length);
					os.write("\r\n".getBytes("utf-8"));
					os.flush();
					
				} finally {
					IOClose(is);
					IOClose(os);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void IOClose(InputStream is) {
		try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void IOClose(OutputStream os) {
		try {
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


