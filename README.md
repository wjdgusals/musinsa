## 빌드 및 실행 방법
- 빌드 `./gradlew clean build`  (permission denied 발생 시 권한 부여 chmod 777 gradlew)
- 실행 `./gradlew bootRun`

## 스웨거 사용방법
>application 실행 후 아래 URL 접속
> >http://localhost:8080/swagger-ui.html 

## 단축 URL 생성 
>application 실행 후 아래 URL 접속 
> >http://localhost:8080/main

>text 박스에 단축하고자 하는 URL 입력 후 enter 키를 입력하면 단축 URL return 됨


## 단축 URL로 원 주소로 redirect 
>application 실행 후 아래 URL에 단축 URL 입력
> >http://localhost:8080/redirect/{shortenUrl}

## 동일한 URL 생성 count
>application 실행 후 아래 URL 접속 
> >http://localhost:8080/h2
>아래 쿼리 실행
```sql

select * from shorten_url;

```

