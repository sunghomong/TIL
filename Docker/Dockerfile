# 어떤 베이직 이미지를 쓸건지 명시
FROM node:16-alpine
# 어떤 디렉토리에 우리의 어플리케이션을 복사해올건지 명시
WORKDIR /app

# 두개의 제이슨 파일을 복사해서 경로로 가져옴
COPY pakage.json pakage-lock.json ./

# ci와 install 차이점? 버전이 달라져도 바로 가능
RUN npm ci 

COPY index.js .

ENTRYPOINT [ "node", "index.js" ]

# 제일 빈번히 발생하는 레이어일수록 마지막에 작성하는게 좋음