package com.cy.socket.optimize;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        
        BufferedInputStream bis = new BufferedInputStream(
        		new FileInputStream("C:\\Users\\Administrator\\Desktop\\img\\55.png"));
       
        Socket socket = new Socket("127.0.0.1",8888);
       
        OutputStream os = socket.getOutputStream();
       
        int len = 0;
        byte[] bytes = new byte[8192];
        while((len = bis.read(bytes))!=-1){
            os.write(bytes,0,len);
        }
        
        socket.shutdownOutput();
        
        InputStream is = socket.getInputStream();

        while((len = is.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }

        bis.close();
        socket.close();
    }
}
