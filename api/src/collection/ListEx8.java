package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListEx8 {
	public static void main(String[] args) {
		// Scanner를 사용하여 5개의 실수 값을 사용자로부터 받아서 ArrayList에 저장한 후 검색하여
		// 가장 큰 수 출력
		// 예시)
		// 입력값 : 3.14 2.1 -5.5 99.9 33.7 => "3.14 2.1 -5.5 99.9 33.7"
		// 출력값 : 가장 큰 수는 99.9
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		String str = sc.nextLine();
		String[] str2 = str.split(" ");
		
//		StringTokenizer token = new StringTokenizer(srt2); // 공백을 기준으로 분리
//		while(token.hasMoreTokens()) {
//			list.add(Double.parseDouble(token.nextToken()));
//		}
		
		//System.out.println(Arrays.toString(str2));
		
		List<String> str3 = new ArrayList<String>(Arrays.asList(str2));
		Collections.sort(str3);
		//System.out.println(str3);
		double max = 0;
		for (String f:str3) {
			if(Double.parseDouble(f) > max) {
				max = Double.parseDouble(f);
			}
		}
		System.out.println("가장 큰 수는 "+max);
		System.out.println();
		System.out.println("가장 큰 수는 "+Collections.max(str3));
		sc.close();
		
	}
}
