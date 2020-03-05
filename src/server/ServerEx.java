package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
// 익셉션 문제
// 
public class ServerEx {
	public static void main(String[] args)throws IOException{
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

					byte[] body = "안녕?".getBytes("utf-8");
					
					// 헤더 작성
					os.write("HTTP/1.1 200 OK \r\n".getBytes("utf-8"));
//					os.write("Content-Type: text/html;charset=utf-8\r\n".getBytes("utf-8"));
					os.write("Content-Type: text/plain\r\n".getBytes("utf-8"));
					os.write(("Content-Length: " + body.length + "\r\n").getBytes("utf-8"));
					os.write("\r\n".getBytes("utf-8"));
	                
					byte[] b = new byte[512];
					is.read(b);

					String a = new String(b,"utf-8");
					System.out.println(a);
						
					os.write(body, 0, body.length);
					os.write("\r\n".getBytes("utf-8"));
					os.flush();
					
				} finally {
					is.close();
					os.close();
				}
			}
		} 
	}
}

