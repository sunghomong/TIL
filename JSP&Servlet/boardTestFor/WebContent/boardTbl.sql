CREATE TABLE boardTbl(
boardNum NUMBER PRIMARY KEY,
boardTitle varchar2(200) NOT NULL,
boardContent varchar2(2000) NOT NULL,
boardWriter varchar2(20) NOT NULL,
boardCount NUMBER DEFAULT 0 NOT NULL,
boardRegDate date DEFAULT sysdate NOT NULL
);

CREATE SEQUENCE boardTbl_seq NOCACHE;

INSERT INTO boardTbl VALUES(boardTbl_seq.nextval,'글제목1','글내용1','작성자1',0,SYSDATE);
INSERT INTO boardTbl VALUES(boardTbl_seq.nextval,'글제목2','글내용2','작성자2',0,SYSDATE);
INSERT INTO boardTbl VALUES(boardTbl_seq.nextval,'글제목3','글내용3','작성자3',0,SYSDATE);
INSERT INTO boardTbl VALUES(boardTbl_seq.nextval,'글제목4','글내용4','작성자4',0,SYSDATE);
INSERT INTO boardTbl VALUES(boardTbl_seq.nextval,'글제목5','글내용5','작성자5',0,SYSDATE);

COMMIT;