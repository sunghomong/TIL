package com.green.servlet;

import com.green.action.Action;
import com.green.action.BoardCheckPassAction;
import com.green.action.BoardCheckPassFormAction;
import com.green.action.BoardDeleteAction;
import com.green.action.BoardListAction;
import com.green.action.BoardUpdateAction;
import com.green.action.BoardUpdateFormAction;
import com.green.action.BoardViewAction;
import com.green.action.BoardWriteAction;
import com.green.action.BoardWriteFormAction;
import com.green.action.ErrorAction;

public class ActionFactory {
	// 싱글턴 패턴

	private ActionFactory() {
	}

	private static ActionFactory af = new ActionFactory();

	public static ActionFactory getInstence() {
		return af;
	}

// -------------------------------------------------------------------------------
	public Action getAction(String command) {

//		command값에 따른 기능 인스턴스 생성
//		그리고 해당 인스턴스를 반환
		Action action = null;

		if (command.equals("board_list")) { // 목록 보기
			action = BoardListAction.getInstance();
		} else if (command.equals("board_write_form")) { // 새글 등록 폼
			action = BoardWriteFormAction.getInstence();
		} else if (command.equals("board_write")) { // 새글 등록 기능
			action = BoardWriteAction.getInstance();
		} else if (command.equals("board_view")) { // 상세보기
			action = BoardViewAction.getInstance();
		} else if (command.equals("board_check_pass_form")) { // 암호 확인 폼
			action = BoardCheckPassFormAction.getInstance();
		} else if (command.equals("board_check_pass")) { // 암호 확인 기능
			action = BoardCheckPassAction.getInstance();
		} else if (command.equals("board_update_form")) { // 기존 글 수정 폼
			action = BoardUpdateFormAction.getInstance();
		} else if (command.equals("board_update")) { // 기존 글 수정 폼
			action = BoardUpdateAction.getInstance();
		} else if (command.equals("board_delete")) { // 기존 글 수정 폼
			action = BoardDeleteAction.getInstance();
		} else {
			action = ErrorAction.getInstance();
		}

		return action;
	}
}
