--- ȸ�� ���� ���α׷� �����

 - 0 �ܰ� : �غ� �ܰ�
 	1) ���̺귯�� ���� : WebContent/WEB-INF/lib/~
 		- ojdbc8.jar  ----> OK
 		- jstl1.2.jar    ----> OK
 	2) �����ͺ��̽� ����
 		- ���̺� ����        ----> OK
 		- ������ ����                      X
 		- ���� ������ �Է� (COMMIT �ʼ�)   ---> OK
 	3) DBCP ����               ----------> OK
 	4) DTO(VO) �ڹٺ� ��ü �ۼ�         -------> OK
 		- ���̺� �÷� ����
 		- ȭ�� ��½� ������ ������ ����
 	5) DAO ��ü�� �ۼ�  -------------> OK
 		- �̱��� �������� �ۼ� ------------> OK
 		- ���� ��ü�� �������� �޼��� ���� -----> OK
-------------------------------------------------------------------

 - 1 �ܰ� : �α��� ���
	1) index.jsp ������ ���� -> �������� ���� ��ũ ���� ------> OK
	2) ���� ����(doGet) -> �α��� �� �������� �̵�  ---------> OK
	3) �α��� �� JSP �ۼ� -> ���� (doPost)�� �̵� --------> OK
		- javascript �ۼ�(�ɼ�)   ------------> OK
	
	4) DAO �޼��� ����					--------> 
		- ���̵�� ��й�ȣ�� ������ ����ó�� �޼���	-----> public int userCheck(String userid, String userpwd)
		- ȸ�� ������ �������� �޼��� = ���ǿ� ������ ����    -----> public MemberVO getMember(String userid) (update)
	5) ���� ����(doPost)
	6) �α��� ������ ������ ������ JSP �ۼ�

-------------------------------------------------------------------

- 2 �ܰ� : �α׾ƿ� ���
	1) main.jsp���� ��ư ���� -> �������� ���� ��ũ ���� 
	<form action="logout" method="get">
		<button type="submit">�α� �ƿ�</button>
	</form>
	2) �α׾ƿ� ���� ����(doGet) ----> logoutServlet
		- session ���� ����		----> request.getSession().invalidate();
		- index.jsp�� �̵�		----> response.sendRedirect("./");
	
-------------------------------------------------------------------
	
- 3 �ܰ� : ȸ�� ���� ���� ���
	1) main.jsp���� ��ư ���� -> �������� ���� ��ũ ���� --->  
	---- <button type="button" onclick="location.href='memberUpdate?userid=${loginUser.userid}'">ȸ�� ���� ����</button>
	
	2) ���� ����(doGet) -> ȸ�� ���� �� �������� �̵� --->  public class MemberUpdateServlet extends HttpServlet
		- ȸ�� ������ ������ ���������� �̵�(<-> ȸ������ ��)
		
	3) ȸ�� ���� �� JSP �ۼ� -> ���� (doPost)�� �̵� ---> <form action="memberUpdate" method="post" name="frm">
		- Javascript �߰� ---> member.js function updatecheck()
		
		
	4) DAO �޼��� ���� ---> MemberDAO.java -> public int updateMember(MemberVO mVo)
		- ȸ�� ������ �����ϱ����� �޼���
	5) ���� ����(doPost) ----> MemberUpdateServlet(doPost)
	   - main.jsp�� ���ư��� ---> response.sendRedirect("login");
	   		(�α��� ������ ���ļ� main��������)
	
-------------------------------------------------------------------
	
- 4 �ܰ� : ȸ�� ���� ���
	1) �α��� �� ���������� ȸ�� ���� ��ư ���� -> �������� ���� ��ũ ���� --------->
	2) ���� ����(doGet) -> ȸ�� ���� �� �������� �̵� -----------> JoinServlet
	3) ȸ�� ���� �� JSP �ۼ� -> ���� (doPost)�� �̵�   -----------> join.jsp
		- Javascript �߰�
			=> 5 �ܰ� : ���̵� �ߺ� üũ ���
			<input type="text" name="userid" size="20" required>*
			<input type="hidden" name="checkId" size="20">
			
			
				1) ȸ�� ���� ������������ ���̵� �ߺ� üũ ��ư ���� ---> <button type="button" onclick="idCheck()">�ߺ�üũ</button>
					-> �������� ���� ��ũ ����
				2) ���� ����(doGet) -> ���̵� �ߺ� üũ ���������� �̵� ----> IdCheckServlet.java -> doGet
				3) DAO �޼��� ���� --- > public int confirmId(String userid)
					- ���̵� �ߺ��� üũ�ϱ� ���� �޼��� -------> 
				4) ���̵� �ߺ� �ƴ� ��� ���̵� �ߺ� üũ ���������� �ݰ�
					���� ȸ�� ���� ������ �̵� ----> Member ok()
	4) DAO �޼��� ���� ----> public int insertMember(MemberVO mVo)
		- ȸ�� ���� ����� �ϱ� ���� �޼���(insert)
	5) ���� ����(doPost)   ------------> MemberUpdateServlet.java -> doPost
	6) �α��� ������ ���ư��� -----> request.getRequestDispatcher("member/login.jsp").forward(request, response);
	
	
	
	
	
	
	
	
	