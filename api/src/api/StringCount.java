package api;

public class StringCount {

	public static void main(String[] args) {
		String str1 = "aabbccAABBCCaa";
		
		int cnt = count(str1, "aa", 0);
		System.out.println("원본 문자열에 \"aa\"패턴이 "+cnt+"개 나왔습니다.");
	
	}
	
	public static int count(String src, String key, int pos) {
		//key에 해당하는 패턴이 몇번 나왔는가?
		
		if(key == null || key.length() == 0) {
			return -1;
		}
		
		for(int i = 0; i < src.length(); i += 2) {
			if (src.substring(i, i+2).equals(key)) {
				pos += 1;
			}
		}
		
//		int index = 0;
//		int count = 0;
//		while((index = src.indexOf(key, pos)) != -1) {
//			count++;
//			pos = index+key.length();
//		}
//		retunn count;
		return pos;
	}

}
