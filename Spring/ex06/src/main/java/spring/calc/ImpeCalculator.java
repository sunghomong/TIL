package spring.calc;

public class ImpeCalculator implements Calculator {
	// 팩토리얼 구하기 위한 클래스 : 재귀없이 팩토리얼 구하기

	@Override
	public long factorial(long num) {
		
//		long start = System.currentTimeMillis();  // 밀리초 단위로 현재 시간을 측정(1970년 1월 1일)

		long result = 1;
		for(long i=1;i<=num;i++) {    // 1*1*2*3*4*5;
			result*=i;
		}
		
//		long end = System.currentTimeMillis();
		
//		System.out.printf("ImpeCalculator.factorial(%d)의 실행 시간 : %d\n",num,(end-start));
		
		return result;
	}

}
