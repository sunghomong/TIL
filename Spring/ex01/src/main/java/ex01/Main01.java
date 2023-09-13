package ex01;

public class Main01 {

	public static void main(String[] args) {
		// Java 기본 코드
		
		Greeter gt = new Greeter();
		gt.setFormat("%s님 안녕하세요!");
		
		System.out.println(gt.greet("홍길동"));

	}

}
