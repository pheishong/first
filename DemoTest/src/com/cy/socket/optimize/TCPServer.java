package com.cy.socket.optimize;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServer {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8888);
		while(true) {
			Socket socket = server.accept();
			new Thread(new Runnable(){
				@Override
				public void run() {
					try {
						InputStream is = socket.getInputStream();
						File file =  new File("C:\\Users\\Administrator\\Desktop\\img\\");
						String fileName = "itcast"+System.currentTimeMillis()+new Random().nextInt(999999)+".jpg";
						BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file+"\\"+fileName));
						
						int len =0;
						byte[] bytes = new byte[8092];
						while((len = is.read(bytes))!=-1){
							bos.write(bytes,0,len);
							bos.flush();
						}

						socket.getOutputStream().write("上传成功".getBytes());
						
						bos.close();

					} catch (IOException e) {
						e.fillInStackTrace();
					}finally {
						try {
							socket.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
		}
	}
}
