package collection;

import java.util.ArrayList;
import java.util.List;

public class ListEx2 {
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
	
		list.add("java");
		list.add("jsp");
		list.add("html");
		list.add("css");
		list.add("mybatis");
		
//		System.out.println(list);
		
//		for(int i = 0; i < list.size(); i++) { size: list의 길이
//			System.out.println(list.get(i));   get : list 요소를 하나씩 가져옴
//		}
		
		for(String s:list) {
			System.out.println(s);
		}
		
	}
}
