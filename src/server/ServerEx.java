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
import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.Map;
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

					parsingPostCase1(is, os);
					if( 1 == 1 ) return;
					
					// bufferedReader로 한 라인읽고 개행문자를 이용해 첫 줄, 헤더, 바디를 분리하자.
					// 네트웤 -1로 짜지 말자.
					InputStreamReader isr = new InputStreamReader(is,"utf-8");
					BufferedReader reader = new BufferedReader(isr);
					String readLine = reader.readLine();
					String[] tokens = readLine.split(" ");
					
					// 스트링 버퍼 httpMethod에 POST로 받아온 http 첫 줄 부분을 공백문자가 나올 때 까지 더한다.
					StringBuffer httpMethod = new StringBuffer();
					for(int i = 0; i < readLine.length(); i++) {
						if(readLine.charAt(i) == ' ') break;
						httpMethod.append(readLine.charAt(i));
					}
					String httpM = tokens[0];//new String(httpMethod);
					
//					System.out.println("httpM = " + httpM);
					System.out.println("readLine = " + readLine);
					
					int contentLength = -1;
					while( ( readLine = reader.readLine() ) != null ) {
						System.out.println(readLine);
						
						if( ! readLine.equals("") ) {
							tokens = readLine.split(":");
							if( tokens[0].equalsIgnoreCase("content-length") ) {
								contentLength = Integer.parseInt( tokens[1].trim() );
							}
						}else {
							break;
						}
					}
					//readLine = reader.readLine();
					System.out.println("contentLength="+contentLength+" "+readLine);
					
					byte[] b = new byte[2];
					int rb = is.read(b, 0, b.length);
					String s = new String( b, 0, rb);
					System.out.println("content="+s);
					// POST요청인지 검사, POST라면 아래 코드 실행.
//					 && reader.readLine() != "\r\n"
					//if(httpM.equals("POST")) {
//					int contentLength = 0;
//						while((readLine = reader.readLine()) != null) {
//							System.out.println(readLine);
////							if(!readLine.equals("")) {
////								System.out.println(readLine);
////								
//////								tokens = readLine.split(" ");
//////								// Content-Length 구하는 코드
//////								if(tokens[0].equals("Content-Length:")) {
//////									System.out.println(tokens.length);
//////									contentLength = Integer.parseInt(tokens[1]);
//////								}
////							}else {
////								break;
////							}
//						}
//						System.out.println("Content-Length: " + contentLength);
//						System.out.println("end headers");
						

						
//						int i;
//						byte[] bLength = new byte[contentLength];
//						is.read();
//						while((i = is.read(bLength)) != -1) {
//							System.out.println(i);
//							is.read(bLength);
//						}
						
//						String string = new String(bLength);
//						txtFis.read(stringFileBuf);
//						System.out.println(string);
						// Content-Length 만큼

					// output
					// 바디 작성
					
				} finally {
					IOClose(is);
					IOClose(os);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static byte[] REQLINE_BUFFER = new byte[1024];
	private static int CR = '\r';
	int contentLength = -1;
	private static int NL = '\n';
	private static String parseLine(InputStream is)  throws IOException {
		int rb = -1;
		int idx = 0;
		while( (rb = is.read()) != -1 ) {
			if( rb == CR ) {
				rb = is.read();
				if( rb == NL ) {
					break;
				}
				continue;
			}
			REQLINE_BUFFER[idx++] = (byte)rb;
		}
		
		return idx == 0 ? null : new String(REQLINE_BUFFER, 0, idx);
	}
	private static Map parseReqHeaders(InputStream is)  throws IOException {
		Map<String, String> headers = new HashMap();
		String readLine = null;
		String[] tokens = null;
		while( ( readLine = parseLine(is) ) != null ) {
			if( ! readLine.equals("") ) {
				tokens = readLine.split(":");
				headers.put(tokens[0].trim().toLowerCase(), tokens[1].trim());
			}else {
				break;
			}
		}
		
		return headers;
	}
	private static int getContentLength(Map<String, String> headers) {
		String cl = headers.get("content-length");
		return cl == null ? -1 : Integer.parseInt(cl);
	}
	private static byte[] getBuffer(int hintSize) {
		return new byte[hintSize];
	}
	private static void parsingPostCase1(InputStream is, OutputStream os) throws IOException {
		String reqLine = parseLine(is);
		Map<String, String> headers = parseReqHeaders(is);
		int contentLength = getContentLength(headers);
		
		System.out.println(reqLine);
		headers.keySet().forEach(key->{
			System.out.println(key+": "+headers.get(key));
		});
		System.out.println("contentLength="+contentLength);
		
		byte[] buffer = getBuffer(contentLength);
		int rb = is.read(buffer, 0, contentLength);
		String sbody = new String(buffer, 0, rb);
		System.out.println("body="+sbody);
		
		byte[] body = sbody.getBytes("utf-8");	
		
		StringBuffer header = new StringBuffer("HTTP/1.1 200 OK \r\n");
		header.append("Content-Type: ").append(headers.get("content-type")).append("\r\n")
		.append("Content-Length: " + body.length + "\r\n")
		.append("\r\n");
		
		// 헤더 작성
		os.write(header.toString().getBytes("utf-8"));
		os.write(body, 0, body.length);
		os.write(CR);
		os.write(NL);
		os.flush();
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


