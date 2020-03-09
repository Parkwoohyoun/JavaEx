//package server;
//
//import java.net.URL;
//
//public class HttpURLConnection {
//	public static void main(String[] args) {
//		  try {
//		   //연결
//		   URL url = new URL("http://localhost:8080");
//		   HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//		   conn.setDoOutput(true);
//		   conn.setRequestMethod("POST");
//		   conn.setRequestProperty("Accept-Language",  "ko-kr,ko;q=0.8,en-us;q=0.5,en;q=0.3");
//		 
//		   //데이터
//		   String param = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode("??", "UTF-8");
//		   param += "&" + URLEncoder.encode("age", "UTF-8") + "=" + URLEncoder.encode("??", "UTF-8");
//		 
//		   //전송
//		   OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
//		   osw.write(param);
//		   osw.flush();
//		 
//		   //응답
//		   BufferedReader br = null;
//		   br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
//		   String line = null;
//		   while ((line = br.readLine()) != null) {
//		    System.out.println(line);
//		   }
//		 
//		   //닫기
//		   osw.close();
//		   br.close();
//		   } catch (MalformedURLException e) {
//		    e.printStackTrace();
//		   } catch (ProtocolException e) {
//		    e.printStackTrace();
//		   } catch (UnsupportedEncodingException e) {
//		    e.printStackTrace();
//		   } catch (IOException e) {
//		    e.printStackTrace();
//		   } 
//		  }
//		}
//}
