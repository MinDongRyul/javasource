package classtest;

/*  클래스 변수
 *  인스턴스 변수(멤버변수)
 *  ==> 선언 위치 : 클래스 영역
 *  ==> 생성 시기 : 
 *    		- 클래스 변수 : 클래스가 메모리에 올라갈 때
 *    		- 인스턴스 변수 : 객체가 생성되었을 때
 *  지역 변수(로컬 변수)
 *  ==> 선언 위치 : 메소드 내부, 생성자 내부, 초기화 블럭 내부
 *  ==> 생성 시기 : 변수 선언문이 수행될 때
 *  
 *  class Varibles{
 *  	int num; // 인스턴스 변수
 *  	static int cv; // 클래스 변수
 *  
 *  void method(){
 *  	int lv = 0; // 로컬 변수
 *  }
 */


public class Data {
	int x;
}
