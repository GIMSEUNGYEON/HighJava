package kr.or.ddit.HTTP;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.StringTokenizer;

public class MyHttpServer {
	private final int port = 80;
	private final String encoding = "UTF-8";

	public void start() {
		ServerSocket server = null;
		try {
			server = new ServerSocket(this.port);

			while (true) {

				System.out.println("브라우저 요청 대기중 ....");
				Socket socket = server.accept();

				// Http 요청 처리 스레드 생성 및 구동
				HttpHandler handler = new HttpHandler(socket);
				handler.start();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Http 요청 처리를 위한 스레드 클래스
	 * 
	 * @author PC-2
	 *
	 */
	class HttpHandler extends Thread {
		private Socket socket;

		public HttpHandler(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {

			System.out.println("요청 처리 시작...");
			OutputStream out = null;
			BufferedReader br = null;

			try {

				out = new BufferedOutputStream(socket.getOutputStream());
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				// 요청메시지 헤더 정보 파싱하기
				StringBuilder sb = new StringBuilder();

				// request Line
				String reqLine = br.readLine();

//				 System.out.println("Request Line : " + reqLine);

				while (true) {
					String str = br.readLine();
					if (str.equals(""))
						break; // Empty Line
					sb.append(str + "\n");

				}
				// 헤더 정보
				String reqHeader = sb.toString();
//				 System.out.println("====요청 헤더 정보====");
//				 System.out.println(reqHeader);
//				 System.out.println("==================");

				// 요청 메시지의 경로정보 가져오기
				String reqPath = ""; // 요청 경로 정보
				StringTokenizer st = new StringTokenizer(reqLine);
				while (st.hasMoreTokens()) {
					String token = st.nextToken();

					if (token.startsWith("/")) {
						reqPath = token;
						break;
					}
				}

//				 System.out.println("요청 경로 정보 : " + reqPath);

				// 경로 정보에 한글이 포함될 경우 한글을 인코딩하여 다른 문자로 바뀌기 때문에 디코딩하여 다시 한글로 돌려줘야한다.
				// URL 디코더를 이용한 처리
				reqPath = URLDecoder.decode(reqPath, encoding);

				String filePath = "./WebContent" + reqPath;

				// 해당 파일이름을 이용하여 Content-Type 정보 추출하기
				// Mime 타입 타입/서브타입으로 구분
				String ContentType = URLConnection.getFileNameMap().getContentTypeFor(filePath);

				File file = new File(filePath);
				if (!file.exists()) {
					makeErrorPage(out, 404, "NotFound");
					return;
				}

				byte[] body = makeResponseBody(filePath);

				byte[] header = makeResponseHeader(body.length, ContentType);

				out.write(header);
				// 응답 내용을 보내기 전에 반드시 Empty Line을 보내서 헤더와 바디를 구분해야함.
				out.write("\r\n\r\n".getBytes());
				// 헤더 다음 엔터 두번 다음 바디
				out.write(body);

				out.flush(); // 강제 데이터 방출

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 응답 내용 생성하기
	 * 
	 * @param filePath 응답 내용으로 사용할 파일 경로
	 * @return 응답 내용을 담은 바이트 배열
	 */
	private byte[] makeResponseBody(String filePath) {
		byte[] data = null;

		FileInputStream fis = null;

		try {
			File file = new File(filePath);
			data = new byte[(int) file.length()];

			fis = new FileInputStream(file);
			fis.read(data);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return data;
	}

	/**
	 * 응답 헤더 생성하기
	 * 
	 * @param contentLength 응답 내용 크기
	 * @param mimeType      응답 내용 contents 타입
	 * @return 헤더 정보를 담은 바이트 배열
	 */
	private byte[] makeResponseHeader(int contentLength, String mimeType) {

		String header = "HTTP/1.1 200 OK\r\n" 
					  + "Server: MyHttpServer 1.0\r\n" 
					  + "Content-length: " + contentLength + "\r\n"
					  + "Content-type: " + mimeType 
					  + "charset = " + this.encoding;

		return header.getBytes();
	}

	/**
	 * 에러가 발생했을 때 별도로 응답하는 메서드
	 * 
	 * @param out
	 * @param statusCode
	 * @param erroMsg
	 */
	private void makeErrorPage(OutputStream out, int statusCode, String erroMsg) {
		
		String statusLine = "HTTP/1.1" + " " 
						  + statusCode + " " 
						  + erroMsg;

		try {
			out.write(statusLine.getBytes());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		new MyHttpServer().start();
	}
}
