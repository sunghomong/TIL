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
values (BOARD_SEQ.nextval,'1234','��浿','ko@naver.com','ù �湮','�ݰ����ϴ�.',0,sysdate);
insert into board
values (BOARD_SEQ.nextval,'1234','ȫ�浿','hong@naver.com','������ �����','���� �� �̴ϴ�',0,sysdate);
insert into board
values (BOARD_SEQ.nextval,'1234','��浿','ko@naver.com','�ι�° �湮','���� �԰� ��ó���?',0,sysdate);
insert into board
values (BOARD_SEQ.nextval,'1234','�ڱ浿','park@naver.com','����� �����ϼ���?','����� �Բ��ϴ�
XX�����',0,sysdate);
insert into board
values (BOARD_SEQ.nextval,'1234','��浿','kim@naver.com','[����]','���� �˾ҽ��ϱ�?',0,sysdate);

COMMIT;

SELECT * 
FROM board;