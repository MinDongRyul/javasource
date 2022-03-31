package io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileEx3 {
	public static void main(String[] args) {
		
		File temp = new File("c:\\iotest\\");
		File dir = new File("c:\\iotest\\dir");
		File file1 = new File("c:\\iotest\\file1.txt"); //직접 생성
		File file2 = new File("c:\\iotest\\file2.txt");
		File file3 = new File(temp, "file3.txt"); // temp를 통해 경로에 들어감
		File file4 = new File(dir, "file4.txt"); // dir를 통해 경로에 들어감
		
		//exists : 존재하는지 확인
		if(!dir.exists()) {
			//디렉토리 생성
			dir.mkdirs();
		}
		
		try {
			if(!file1.exists()) {
				//파일 생성
				file1.createNewFile();
			}
			if(!file2.exists()) {
				file2.createNewFile();
			}
			if(!file3.exists()) {
				file3.createNewFile();
			}
			if(!file4.exists()) {
				file4.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		System.out.println("   날짜      시간          형태           크기         이름");
		System.out.println("--------------------------------------------------------");
		File[] files = temp.listFiles();
		for(File f:files) {
			System.out.print(sdf.format(new Date(f.lastModified()))); // new Date(1970년부터의 지금까지 의 시간(long):1647483760020)
			if(f.isDirectory()) {
				System.out.println("\t<DIR>\t\t\t"+f.getName());
			}
			else {
				System.out.println("\t\t\t"+f.length()+"\t"+f.getName());
			}
			System.out.println();
		}
	}
}

