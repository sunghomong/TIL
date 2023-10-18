 - MVC 모델2를 이용한 기초 게시판 만들기
 	- 목록보기	- select
 	- 상세 보기 - select
 	- 새글 등록 - insert
 	- 글 수정 - update
 	- 글 삭제 - delete
 	
 	
 - 정적인 파일 : css,js,jpg~~~
 	- 톰캣 서버를 동작시킬때 모든 요청을 서블릿이 처리하도록 제작
 	- 정적인 파일은 서블릿이 처리할 수 없다.
 	- default 서블릿이 정적 파일을 처리하도록 셋팅
 
 
 
 - 0 단계 : 준비단계
 	1) 데이터베이스 구축					-----> board.sql
 		=> 테이블 및 시퀀스 생성			
 	2) 샘플데이터 삽입					-----> board.sql
 		=> commit;
 	3) 각종 라이브러리 준비					-----> lib
 		=> ojdbc, jstl
 	4) DBCP 셋팅						-----> servers에 web11_board추가 후  resource 
 	5) DBManager 객체					-----> DBManager.java
 		=> 연결과 해제 메서드
 	6) VO 객체 제작						-----> BoardVO.java
 		=> DB 컬럼과 일치
 	7) DAO 객체를 준비					-----> BoardDAO.java
 		=> 싱글턴 패턴
 	8) 모든 요청을 처리하기 위한 서블릿			-----> BoardListAction.java
 		=> 서블릿 제작
 		=> 상세 기능을 연결 시켜줄 클래스를 제작
 	9) 각 세부 기능을 묶어줄 인터페이스 제작		-----> Action.java
 	10) 첫 페이지 제작					-----> index.jsp
 ---------------------------------------------------------------------------------------------
 - 1 단계 : 목록보기
 	1) DAO에 게시물 목록 조회 메서드 추가		-----> BoardDAO.java
 		- selectAllBoard()
 	2) 기능 처리를 위한 클래스				-----> ActionFactory.java 
 		- command : board_list
 		- BoardListAction
 	3) 뷰페이지 제작						-----> boardList.jsp
 		- board/boardList.jsp
 
 ---------------------------------------------------------------------------------------------
 - 2 단계 : 새로운 글 등록하기
 	1) 목록페이지에 버튼 만들기				-----> boardList.jsp
 	2) 기능 처리를 위한 클래스 - 폼페이지를 보여줄 기능 --> BoardWriteFormAction.java
 		- command="board_write_form"
 		- BoardWriteFormAction
 	3) 뷰페이지 제작 - 폼페이지				---->  boardWrite.jsp
 		- board/boardWrite.jsp
 	4) DAO에 게시물 등록 메서드 추가			----> BoardDAO.java
 		- insertBoard(BoardVO)
 	5) 기능 처리를 위한 클래스 - 게시글 등록 기능 	----> BoardWriteAction.java
 		- command=board_write
 		- BoardWriteAction
 		- 게시글 목록 돌아가기
 		
------------------------------------------------------------------------------------------------
 
 - 3 단계 : 글 상세보기
 	1) 목록페이지에 글제목 클릭시					----> boardList.jsp
 	2) DAO 게시물 보기 메서드, 조회수 증가 메서드	----> BoardDAO.java
 		- selectBoardByNum(int num)
 		- updateReadCountByNum(int num)
 	3) 기능 처리를 위한 클래스  - 가져온 게시글을 뷰페이지----> BoardViewAction.java
 		- command=board_view
 		- BoardViewAction
 	4) 뷰페이지							----> boardView.jsp
 		- board/boardView.jsp
 
------------------------------------------------------------------------------------------------
 - 4 단계 : 글 수정/삭제하기 : 암호체크	
	1) 상세보기에서 링크 연결						---> boardView.jsp
		- Javascript를 이용한 새창 열기
	2) DAO 암호 체크 기능을 위한 메서드				----> BoardDAO.java
		- checkPassword(int num, String pass)
	3) 기능 처리를 위한 클래스 - 폼페이지를 보여줄 기능		----> ActionFactory.java
		- command = board_check_pass_form
		- BoardCheckPassFormAction			----> BoardCheckPassFormAction.java
	4) 뷰페이지 - 폼페이지						----> boardCheckPass.jsp
		- board/boardCheckPass.jsp
	5) 기능 처리를 위한 클래스 - 암호 체크를 위한 기능		----> BoardCheckPassAction.java
		- command = board_check_pass
		- BoardCheckPassAction
	6) 뷰페이지								----> checkSuccess.jsp
		- board/checkSuccess.jsp
		- [JS] => 수정/삭제
	7) 에러 페이지								----> ErrorAction.java,error.jsp
		- command를 찾을 수 없는 경우				
		- 기능 클래스 : ErrorAction
		-error.jsp
		
------------------------------------------------------------------------------------------------ 
 - 5 단계 : 글 수정하기
 
 	1) 기능 처리를 위한 클래스 - 폼페이지를 보여줄 기능
 		- command=board_update_form
 		- BoardUpdateFormAction
 			- DAO : selectBoardByNum(num)
 	2) 뷰페이지 제작 - 폼페이지				
 		- board/boardUpdate.jsp
 	3) DAO에 게시물 수정 메서드 추가			
 		- updateBoard(BoardVO)
 	4) 기능 처리를 위한 클래스 - 게시글 수정 기능 	
 		- command=board_update
 		- BoardUpdateAction
 		- 돌아가기
 			- 목록 / 상세 [선택사항]
 
------------------------------------------------------------------------------------------------ 
 - 6 단계 : 글 삭제하기
 	1) DAO에 게시물 삭제 메서드 추가			----> BoardDAO.java
 		- deleteBoard(num)
 	2) 기능 처리를 위한 클래스 - 게시글 삭제 기능	----> boardDelete.jsp
 		- command=board_delete
 		- BoardDeleteAction
 		- 목록
 
------------------------------------------------------------------------------------------------
- 게시글이 많은 경우 => 목록 페이지 하나에서 모두 보여줄 수 없다.
 - 한페이지에 보여줄 정보를 한정 짓는 방법
 - 1page 10개의 게시글 목록 보여주는 방법
 - 2가지 정보
  - 페이지 : 한 페이지에 몇개의 목록을 보여줄 것인가
  - 섹션 : 한 페이지에 몇 개의 페이지번호를 보여줄 것인가
  << 1 2 3 4 5 6 7 8 9 10 >> 1번 섹션
  << 11 12 13 14 15 16 17 18 19 20 >> 2번 섹션
 
 어떻게 실제 쿼리를 가져올지 (오라클 : ROWNUM 행 번호)
 1단계 : 전체 게시물을 조회 내림차순
 	- SELECT * FROM board ORDER BY num DESC;
 2단계 : 1단계에서 조회된 데이터를 기준으로 행번호를 가진 새로운 SELECT문을 생성
 	- SELECT ROWNUM AS nicknum,num,name,email,pass,title,content,readcount,writedate
 	  FROM (SELECT * FROM board ORDER BY num DESC);
 3단계 : 전체에 매겨진 행번호를 기준으로 섹션값과 페이지 번호를 이용해서 해당 페이지의 게시물을 조회
 	
 	- SELECT *
 	FROM (SELECT ROWNUM AS nicknum,num,name,email,pass,title,content,readcount,writedate
 	  FROM (SELECT * FROM board ORDER BY num DESC))
 	  WHERE nicknum BETWEEN (색션번호-1)*100 + (페이지번호-1)*10 + 1
 	  				AND (색션번호-1)*100 + (페이지번호 - 1)*10+10;
 	  				
 - 7 단계 : 페이징
	1) DAO에 메서드 추가
		- [전체 게시글 개수] : selectAllBoardNum()
		- [현재 페이지 글 목록(섹션,페이지)] : selectTargetBoard(section,pageNum)
	2) 기능 처리를 위한 클래스 수정 - 게시글 목록 기능
		- command : board_list
 		- BoardListAction
 	3) 뷰페이지 수정
 		- board/boardList.jsp 페이지 수정
 
 
------------------------------------------------------------------------------------------------
 - 8 단계 : Hidden
 
 
 
 
 
 
 
 
 
 
 
 