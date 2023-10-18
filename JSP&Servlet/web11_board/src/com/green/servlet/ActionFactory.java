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
	// �̱��� ����

	private ActionFactory() {
	}

	private static ActionFactory af = new ActionFactory();

	public static ActionFactory getInstence() {
		return af;
	}

// -------------------------------------------------------------------------------
	public Action getAction(String command) {

//		command���� ���� ��� �ν��Ͻ� ����
//		�׸��� �ش� �ν��Ͻ��� ��ȯ
		Action action = null;

		if (command.equals("board_list")) { // ��� ����
			action = BoardListAction.getInstance();
		} else if (command.equals("board_write_form")) { // ���� ��� ��
			action = BoardWriteFormAction.getInstence();
		} else if (command.equals("board_write")) { // ���� ��� ���
			action = BoardWriteAction.getInstance();
		} else if (command.equals("board_view")) { // �󼼺���
			action = BoardViewAction.getInstance();
		} else if (command.equals("board_check_pass_form")) { // ��ȣ Ȯ�� ��
			action = BoardCheckPassFormAction.getInstance();
		} else if (command.equals("board_check_pass")) { // ��ȣ Ȯ�� ���
			action = BoardCheckPassAction.getInstance();
		} else if (command.equals("board_update_form")) { // ���� �� ���� ��
			action = BoardUpdateFormAction.getInstance();
		} else if (command.equals("board_update")) { // ���� �� ���� ��
			action = BoardUpdateAction.getInstance();
		} else if (command.equals("board_delete")) { // ���� �� ���� ��
			action = BoardDeleteAction.getInstance();
		} else {
			action = ErrorAction.getInstance();
		}

		return action;
	}
}
