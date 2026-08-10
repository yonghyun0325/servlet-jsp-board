# Servlet JSP Board

Java Servlet, JSP, JDBC를 이용하여 구현한 전통적인 방식의 게시판 프로젝트입니다.

Spring Framework를 사용하지 않고 Servlet의 요청/응답 처리 과정과
JDBC를 통한 데이터베이스 접근 과정을 직접 구현하는 것을 목표로 진행했습니다.

---

## 1. 프로젝트 목적

Spring Boot와 Spring MVC를 사용하기 전에
Java 웹 애플리케이션이 기본적으로 어떻게 동작하는지 이해하기 위해 제작했습니다.

특히 다음 내용을 직접 구현하고 확인했습니다.

- Servlet 기반 HTTP 요청/응답 처리
- JSP를 이용한 서버 사이드 렌더링
- Servlet에서 JSP로 데이터 전달
- JSTL / EL 사용
- JDBC를 이용한 PostgreSQL 접근
- DAO 패턴
- PreparedStatement 사용
- 게시판 CRUD
- 검색
- 페이징

---

## 2. 기술 스택

### Backend

- Java 17
- Java Servlet 4
- JDBC

### View

- JSP
- JSTL
- HTML
- CSS
- JavaScript

### Database

- PostgreSQL 17

### Web Server

- Apache Tomcat 9

### Build

- Gradle

---

## 3. 주요 기능

### 게시글

- 게시글 목록 조회
- 게시글 상세 조회
- 게시글 작성
- 게시글 수정
- 게시글 삭제

### 추가 기능

- 게시글 조회수 증가
- 제목 검색
- 게시판 페이징
- 검색 조건 + 페이징 연동

---

## 4. 프로젝트 구조

```text
src/main
├── java
│   └── com.example.board
│       ├── controller
│       │   ├── BoardListServlet.java
│       │   ├── BoardDetailServlet.java
│       │   ├── BoardWriteServlet.java
│       │   ├── BoardUpdateServlet.java
│       │   └── BoardDeleteServlet.java
│       │
│       ├── dao
│       │   └── BoardDao.java
│       │
│       ├── dto
│       │   └── BoardDto.java
│       │
│       └── util
│           └── DBConnection.java
│
└── webapp
    ├── index.jsp
    │
    └── WEB-INF
        └── views
            └── board
                ├── list.jsp
                ├── detail.jsp
                ├── write.jsp
                └── edit.jsp
