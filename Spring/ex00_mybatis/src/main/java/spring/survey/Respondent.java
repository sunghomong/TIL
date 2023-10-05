package spring.survey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
@Data  // get set 메서드 통합
@NoArgsConstructor   // 빈 생성자
@AllArgsConstructor   // 생성자
public class Respondent { //응답자 정보
	private int age;
	private String location;
	// 라이브러리 lombok
	//     생성자, Getter, Setter메서드를 자동으로 생성
	//     @Getter, @Setter
	
	
	

}
