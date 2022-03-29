package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class BufferedInputStreamEx2 {
	public static void main(String[] args) {
		try(FileInputStream fis = new FileInputStream("c:\\temp\\pawel.jpg");
			BufferedInputStream bis = new BufferedInputStream(fis);
			FileOutputStream fos = new FileOutputStream("c:\\temp\\pawel_copy.jpg");
			BufferedOutputStream bos = new BufferedOutputStream(fos)){
			
			int data;
			while((data = bis.read()) != -1) {
				bos.write(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
