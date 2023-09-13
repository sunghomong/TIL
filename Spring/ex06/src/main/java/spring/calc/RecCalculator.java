package spring.calc;

public class RecCalculator implements Calculator {
	// 팩토리얼 구하기 위한 클래스 : 재귀함수로 팩토리얼 구하기
	
	@Override
	public long factorial(long num) {
		
//		long start = System.currentTimeMillis();

//		try {
			if(num==0) {
				return 1;
			}else {
				return num*factorial(num-1);   // 5*4*3*2*1*1;
			}
//		}finally {
//			long end = System.currentTimeMillis();
//		
//			System.out.printf("RecCalculator.factorial(%d)의 실행 시간 : %d\n",num,(end-start));
//		}

	}

}
