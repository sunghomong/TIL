CREATE TABLE productTbl(
    code NUMBER PRIMARY KEY,
    name NVARCHAR2(100),
    price NUMBER,
    prictureUrl VARCHAR2(1000),
    description NVARCHAR2(2000)
);

CREATE SEQUENCE product_seq
NOCACHE;

INSERT INTO productTbl
VALUES(product_seq.nextval,'파이썬 데이터 사이언스 핸드북',34200,'01_python.jpg','파이썬을 활용한 데이터 과학 입문서');
INSERT INTO productTbl
VALUES(product_seq.nextval,'코틀린을 활용한 안드로이드 프로그래밍 ',34000,'02_android.jpg','코틀린 언어를 통한 안드로이드 개발서');
INSERT INTO productTbl
VALUES(product_seq.nextval,'Node.js 교과서',32400,'03_nodejs.jpg','기본기에 충실한 노드.js 학습서');
INSERT INTO productTbl
VALUES(product_seq.nextval,'자바 웹을 다루는 기술',40500,'04_javaWebBook.jpg','JSP,서블릿,스프링까지 실무에 알아야 할 기술서');
INSERT INTO productTbl
VALUES(product_seq.nextval,'토비의 스프링 3.1',67500,'05_spring.jpg','스프링의 원리와 이해를 충실히 가르쳐줄 교과서');

COMMIT;

SELECT *
FROM productTbl;


