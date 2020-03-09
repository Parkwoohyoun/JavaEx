package server;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;



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
					
					
//					"http://localhost:8080"
//					URL url = new URL("http://localhost:8080");
//				        
//				   HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//				   conn.setRequestMethod("POST");
//				   conn.setDoOutput(true);
//				   
//				   //응답
//				   BufferedReader br = null;
//				   br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
//				   String line = null;
//				   while ((line = br.readLine()) != null) {
//				    System.out.println(line);
//				   }


					// bufferedReader로 한 라인읽고 개행문자를 이용해 첫 줄, 헤더, 바디를 분리하자.
					// 네트웤 -1로 짜지 말자.
					BufferedReader reader = new BufferedReader(new InputStreamReader(is,"utf-8"));
					String readLine = reader.readLine();
					
					// 스트링 버퍼 httpMethod에 POST로 받아온 http 첫 줄 부분을 공백문자가 나올 때 까지 더한다.
					StringBuffer httpMethod = new StringBuffer();
					for(int i = 0; i < readLine.length(); i++) {
						if(readLine.charAt(i) == ' ')
							break;
						httpMethod.append(readLine.charAt(i));
					}
					String httpM = new String(httpMethod);
					
					System.out.println("httpM = " + httpM);
//					System.out.println("readLine = " + readLine);
					
					// POST요청인지 검사, POST라면 아래 코드 실행.
//					 && reader.readLine() != "\r\n"
					if(httpM.equals("POST")) {

						while((readLine = reader.readLine()) != null) {
							readLine = reader.readLine();
							System.out.println(readLine);
						}
//						for(int i = 0; i < 20; i++) {
//							readLine = reader.readLine();
//							System.out.println(readLine);
//						}
					}
//					int i = 0;
//					while(i != -1) {
//						byte[] body = new byte[reader.read()];
//					
//						String bod = new String(body);
//						
//						System.out.println(bod);
//						i = reader.read();
//					}


//					String a = new String(b,"utf-8");
//					System.out.println(a);

					// output
					// 바디 작성
					byte[] body = "안녕?".getBytes("utf-8");
//					if(str != null)
//						body = str.getBytes("utf-8");
					
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


