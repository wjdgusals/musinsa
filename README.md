# musinsa
빌드 및 실행 방법
빌드 ./gradlew clean build
실행 ./gradlew bootRun
스웨거 사용방법
application 실행 후 아래 URL 접속 
http://localhost:8080/swagger-ui.html

test 방법
1. 단축 URL 생성 
application 실행 후 아래 URL 접속 후 
text 박스에 단축하고자 하는 URL 입력 후 enter 키를 입력하면 단축 URL return 됨
http://localhost:8080/main

2. 단축 URL로 원 주소로 redirect 
아래 URL에 단축 URL 입력
http://localhost:8080/{shortenUrl}
