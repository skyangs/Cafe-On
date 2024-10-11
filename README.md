# 카페 주문 서비스 Cafe-On

- 개발 기간 : 24.04.01 ~ (진행중)

## 프로젝트 소개

- ‘패스오더’ 어플을 참조하였으며 카페의 음료를 비대면으로 주문할 수 있는 서비스입니다.
- 카페 운영자(Cafe-Owner)와 사용자(User) 각각의 권한에 따라 다르게 이용할 수 있습니다.

### 개발 환경

- Language : Java
- Framework : Spring Boot 3.2.4
- JDK : 17
- Swagger2

## 디렉토리 구조

```
C:.
    ├─.github
    │  └─workflows
    └─src
    ├─main
    │  ├─generated
    │  ├─java
    │  │  └─com
    │  │      └─example
    │  │          └─order
    │  │              ├─cafe
    │  │              ├─config
    │  │              ├─global
    │  │              ├─member
    │  │              └─order
    │  └─resources
    └─test
        ├─java
        │  └─com
        │      └─example
        │          └─order
        │              ├─cafe
        │              ├─member
        │              └─order
        └─resources
```

### 기획서

[요구사항 명세서](https://resolute-blob-c94.notion.site/dddf8cfb14cd487a930a9ee2d8f203f3?v=f02d08c8d8e948f9ad4ce8d3f3229eaa&pvs=74)

### 프로젝트 설치 및 실행방법

---- -

#### Docker

``` 
cd .\src\main\resources

(실행 시) docker-compose up -d
(정지 시) docker-compose stop
(삭제 시) docker-compose down
```

#### 프로젝트 실행

실행 파일 : OrderApplication

```
1. ./gradlew build
2. cd build/libs
3. java -jar order-0.0.1-SNAPSHOT.jar
```

### [Cafe-Owner, 카페 운영자 기능]

1. 카페, 메뉴, 설명, 가격 등록 기능
2. 주문 상태 변경 기능
3. 주문 조회 기능

### [User, 사용자 기능]

1. 음료 주문 기능
2. 주문 내역 조회 기능
