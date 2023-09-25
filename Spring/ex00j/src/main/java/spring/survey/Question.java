package spring.survey;

import java.util.List;

import lombok.Data;

@Data
public class Question {
	
	private String title; // 질문
	private List<String> option; // 선택답안
	
	
	public Question(String title, List<String> option) {
		this.title = title;
		this.option = option;
	}
	
	public Question(String title) {
		this.title = title;
	}
	
	public boolean isChoice() { // 옵션값이 있다면 (선택답안이 있다면)
		
		
		return option != null && !option.isEmpty();
	}
}
