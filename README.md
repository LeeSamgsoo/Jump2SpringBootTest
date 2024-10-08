# 1. 게시글 등록 페이지
![image](https://github.com/user-attachments/assets/f4d355d6-d6fd-45fa-8cdf-297c71aecb7f)


# 2. 게시글 리스트 페이지
![image](https://github.com/user-attachments/assets/6aed73d2-8f2a-4a88-9807-69488087fd65)

# 3. 게시글 상세 페이지
![image](https://github.com/user-attachments/assets/4092bba8-69da-4fe3-9a4a-69083dea5a9e)


## 1차 요구사항 구현
- [x] 유저가 루트 url로 접속시에 게시글 리스트 페이지(http://주소:포트/article/list)가 나온다.
- [x] 리스트 페이지에서는 등록 버튼이 있고 버튼을 누르면 http://주소:포트/article/create 경로로 이동하고 등록 폼이 나온다.
- [x] 게시글 등록을 하면 http://주소:포트/article/create로 POST 요청을 보내어 DB에 해당 내용을 저장한다.
- [x] 게시글 등록이 되면 해당 게시글 리스트 페이지로 리다이렉트 된다. 페이지 URL 은 http://주소:포트/article/list 이다.
- [x] 리스트 페이지에서 해당 게시글을 클릭하면 상세페이지로 이동한다. 해당 경로는 http://주소:포트/article/detail/{id} 가 된다.
- [x] 게시글 상세 페이지에는 id에 맞는 게시글 데이터와 목록 버튼이 있다. 목록 버튼을 누르면 게시글 리스트 페이지로 이동하게 된다.

- (추가 기능이나 구현기능설명이 필요한 경우 서술)

## 미비사항 or 막힌 부분
- ...

## MVC 패턴
- 모델, 뷰, 컨트롤러 패턴
- 데이터가 저장되어 있는 단과 데이터를 조작하는 단, 그리고 사용자에게 표시되는 단을 나눠서 디자인 하는 패턴

## 스프링에서 의존성 주입(DI) 방법 3가지 방법
- 생성자 주입 : 생성자 메소드에 어노테이션을 통해 의존성 주입
- 수정자 주입 : setter 메소드에 어노테이션을 통해 의존성 주입
- 필드 주입 : 필드에서 주입하고자 하는 객체에 어노테이션을 통해 의존성 주입


## JPA의 장점과 단점
- 장점 : 작성과 관리가 편함. 여러 db와 호환되어서 db를 바꿔도 코드를 바꾸지 않아도 된다.
- 단점 : 자바코드를 sql로 전환하는 거라 성능저하가 있다.

## HTTP GET 요청과 POST 요청의 차이
- GET : 서버의 데이터를 클라이언트에 표시하기위해 데이터를 받아오는 요청
- POST : 서버의 데이터를 변경하기 위해 클라이언트에서 입력받은 데이터를 보내는 요청
