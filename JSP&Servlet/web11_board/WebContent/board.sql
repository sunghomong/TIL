create table board(
    num number primary key,
    pass varchar2(30),
    name varchar2(30),
    email varchar2(30),
    title varchar2(100),
    content varchar2(2000),
    readCount number default 0,
    writedate date default sysdate
);

create SEQUENCE board_seq nocache;

insert into board
values (BOARD_SEQ.nextval,'1234','고길동','ko@naver.com','첫 방문','반갑습니다.',0,sysdate);
insert into board
values (BOARD_SEQ.nextval,'1234','홍길동','hong@naver.com','흔적을 남기다','이젠 제 겁니다',0,sysdate);
insert into board
values (BOARD_SEQ.nextval,'1234','고길동','ko@naver.com','두번째 방문','밥은 먹고 사시나요?',0,sysdate);
insert into board
values (BOARD_SEQ.nextval,'1234','박길동','park@naver.com','보험료 문의하셨죠?','평생을 함께하는
XX보험사',0,sysdate);
insert into board
values (BOARD_SEQ.nextval,'1234','김길동','kim@naver.com','[공지]','인줄 알았습니까?',0,sysdate);

COMMIT;

SELECT * 
FROM board;