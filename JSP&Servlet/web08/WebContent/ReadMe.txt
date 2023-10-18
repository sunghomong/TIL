--- 회원 관리 프로그램 만들기

 - 0 단계 : 준비 단계
 	1) 라이브러리 복사 : WebContent/WEB-INF/lib/~
 		- ojdbc8.jar  ----> OK
 		- jstl1.2.jar    ----> OK
 	2) 데이터베이스 구축
 		- 테이블 생성        ----> OK
 		- 시퀀스 생성                      X
 		- 샘플 데이터 입력 (COMMIT 필수)   ---> OK
 	3) DBCP 설정               ----------> OK
 	4) DTO(VO) 자바빈 객체 작성         -------> OK
 		- 테이블 컬럼 기준
 		- 화면 출력시 보여질 데이터 기준
 	5) DAO 객체를 작성  -------------> OK
 		- 싱글턴 패턴으로 작성 ------------> OK
 		- 연결 객체를 가져오는 메서드 생성 -----> OK
-------------------------------------------------------------------

 - 1 단계 : 로그인 기능
	1) index.jsp 페이지 생성 -> 서블릿으로 가는 링크 생성 ------> OK
	2) 서블릿 제작(doGet) -> 로그인 폼 페이지로 이동  ---------> OK
	3) 로그인 폼 JSP 작성 -> 서블릿 (doPost)로 이동 --------> OK
		- javascript 작성(옵션)   ------------> OK
	
	4) DAO 메서드 제작					--------> 
		- 아이디와 비밀번호를 가지고 인증처리 메서드	-----> public int userCheck(String userid, String userpwd)
		- 회원 정보를 가져오는 메서드 = 세션에 저장할 목적    -----> public MemberVO getMember(String userid) (update)
	5) 서블릿 제작(doPost)
	6) 로그인 성공시 보여질 페이지 JSP 작성

-------------------------------------------------------------------

- 2 단계 : 로그아웃 기능
	1) main.jsp에서 버튼 생성 -> 서블릿으로 가는 링크 생성 
	<form action="logout" method="get">
		<button type="submit">로그 아웃</button>
	</form>
	2) 로그아웃 서블릿 제작(doGet) ----> logoutServlet
		- session 정보 삭제		----> request.getSession().invalidate();
		- index.jsp로 이동		----> response.sendRedirect("./");
	
-------------------------------------------------------------------
	
- 3 단계 : 회원 정보 수정 기능
	1) main.jsp에서 버튼 생성 -> 서블릿으로 가는 링크 생성 --->  
	---- <button type="button" onclick="location.href='memberUpdate?userid=${loginUser.userid}'">회원 정보 변경</button>
	
	2) 서블릿 제작(doGet) -> 회원 수정 폼 페이지로 이동 --->  public class MemberUpdateServlet extends HttpServlet
		- 회원 정보를 가지고 폼페이지로 이동(<-> 회원가입 폼)
		
	3) 회원 수정 폼 JSP 작성 -> 서블릿 (doPost)로 이동 ---> <form action="memberUpdate" method="post" name="frm">
		- Javascript 추가 ---> member.js function updatecheck()
		
		
	4) DAO 메서드 제작 ---> MemberDAO.java -> public int updateMember(MemberVO mVo)
		- 회원 정보를 변경하기위한 메서드
	5) 서블릿 제작(doPost) ----> MemberUpdateServlet(doPost)
	   - main.jsp로 돌아가기 ---> response.sendRedirect("login");
	   		(로그인 서블릿을 거쳐서 main페이지로)
	
-------------------------------------------------------------------
	
- 4 단계 : 회원 가입 기능
	1) 로그인 폼 페이지에서 회원 가입 버튼 생성 -> 서블릿으로 가능 링크 생성 --------->
	2) 서블릿 제작(doGet) -> 회원 가입 폼 페이지로 이동 -----------> JoinServlet
	3) 회원 수정 폼 JSP 작성 -> 서블릿 (doPost)로 이동   -----------> join.jsp
		- Javascript 추가
			=> 5 단계 : 아이디 중복 체크 기능
			<input type="text" name="userid" size="20" required>*
			<input type="hidden" name="checkId" size="20">
			
			
				1) 회원 가입 폼페이지에서 아이디 중복 체크 버튼 생성 ---> <button type="button" onclick="idCheck()">중복체크</button>
					-> 서블릿으로 가는 링크 생성
				2) 서블릿 제작(doGet) -> 아이디 중복 체크 폼페이지로 이동 ----> IdCheckServlet.java -> doGet
				3) DAO 메서드 제작 --- > public int confirmId(String userid)
					- 아이디 중복을 체크하기 위한 메서드 -------> 
				4) 아이디 중복 아닌 경우 아이디 중복 체크 폼페이지를 닫고
					기존 회원 가입 폼으로 이동 ----> Member ok()
	4) DAO 메서드 제작 ----> public int insertMember(MemberVO mVo)
		- 회원 가입 기능을 하기 위한 메서드(insert)
	5) 서블릿 제작(doPost)   ------------> MemberUpdateServlet.java -> doPost
	6) 로그인 폼으로 돌아가기 -----> request.getRequestDispatcher("member/login.jsp").forward(request, response);
	
	
	
	
	
	
	
	
	