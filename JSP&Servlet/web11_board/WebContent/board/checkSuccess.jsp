<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
	if(window.name == 'update') { // 수정 기능
		window.opener.parent.location.href='BS?command=board_update_form&num=${param.num}';
	}else if(window.name == 'delete'){ // 삭제 기능
		window.opener.parent.location.href='BS?command=board_delete&num=${param.num}';
	}
	
	window.close(); // 현재 열린 창 닫기
</script>
