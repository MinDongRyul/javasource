package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class FileWriterEx2 {
	public static void main(String[] args) {
		// 사용자로부터 데이터 입력받기 : Scanner 
		Scanner sc = new Scanner(System.in);
		// c:\\iotest\\output1.txt 파일 생성
		File f = new File("c:\\iotest\\output1.txt");
		
		try {
			if(!f.exists()) {
				f.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(true) {
			System.out.println("데이터 입력(q : 종료)");
			String str = sc.nextLine();
		
			if(str.equals("q")) {
				break;
			}
			
			try (Writer writer = new FileWriter(f, true)){
				// 입력받은 데이터를 파일 출력 : output1.txt
				writer.write(str+"\r\n");
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		sc.close();
	}	
}
	


