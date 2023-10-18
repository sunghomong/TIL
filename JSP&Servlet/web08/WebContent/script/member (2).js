/**
 * 
 */

// 로그인시 아이디 패스워드를 입력했는가 여부를 체크하는 함수
function loginCheck(){
	
	if(document.frm.userid.value.length == 0){
		alert('아이디를 입력해 주세요.');
		document.frm.userid.focus();
		return false;
	}
	
	if(document.frm.userpwd.value == ''){
		alert('비밀번호를 입력해 주세요.');
		document.frm.userpwd.focus();
		return false;
	}
	
	return true;
}

// 회원 정보 수정시 암호 확인 및 데이터 입력을 체크하는 함수
function updateCheck(){
	// 암호 입력 확인
	if(document.frm.userpwd.value==''){
		alert('암호를 입력해 주세요.');
		document.frm.userpwd.focus();
		return false;
	}
	
	// 입력된 암호와 체크 암호 일치 여부 확인
	if(document.frm.userpwd.value != document.frm.pwd_check.value){
		alert('비밀번호가 일치하지 않습니다.');
		document.frm.userpwd.value = '';
		document.frm.pwd_check.value = '';
		
		document.frm.userpwd.focus();
		return false;
	}
	
	return true;	
}

// 회원 가입시 암호 확인 및 암호 일치 여부 체크하는 함수
//          + 아이디 중복 체크 여부 확인
function joinCheck(){
	// 암호 입력 확인
	if(document.frm.userpwd.value==''){
		alert('암호를 입력해 주세요.');
		document.frm.userpwd.focus();
		return false;
	}
	
	// 입력된 암호와 체크 암호 일치 여부 확인
	if(document.frm.userpwd.value != document.frm.pwd_check.value){
		alert('비밀번호가 일치하지 않습니다.');
		document.frm.userpwd.value = '';
		document.frm.pwd_check.value = '';
		
		document.frm.userpwd.focus();
		return false;
	}
	
	// 아이디 중복 체크 여부 ??
	if(document.frm.checkId.value == ''){
		alert('아이디 중복 체크를 하지 않았습니다.');
		document.frm.userid.focus();
		return false;
	}
	
	return true;
	
}
// 아이디 중복 체크 기능
function idCheck(){
	if(document.frm.userid.value == ''){
		alert('아이디를 입력해 주세요.');
		document.frm.userid.focus();
		return;
	}
	
	// window.open(어디로,새창이름,옵션);
	let url = "idCheck?userid="+document.frm.userid.value;
	
	window.open(url,"_blank_1","toolbar=no, menubar=no, scrollbars=yes width=450, height=200");
}

// 중복 확인 된 아이디 사용하기
function ok(){
	opener.document.frm.userid.value = document.frm.userid.value;
	opener.document.frm.checkId.value = document.frm.userid.value;
	
	self.close(); // 현재 창 닫기
}























 



