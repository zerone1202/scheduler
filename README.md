# mastering-crud-sy-scheduler
[일정 관리 앱]
사용자 인증은 SESSION 기반으로 동작합니다.

---

## 기술 스택
- JAVA 17
- Spring Boot
- JPA (Hibernate)
- MySQL
- Lombok

---

## 인증 방식

- 모든 인증이 필요한 요청은 Session 기반 Cookie 인증을 사용합니다.
- 로그인 성공 시 세션이 생성됩니다.
  
---

## USER API 

기능     |  Method | URL    | 인증   | request | response | HTTP 상태코드 
--------|---------|--------|-------|---------|----------|---------
회원가입  | POST    | /signup|- | {"username": "string", "email": "string", "password": "string"} | {"id": 1, "username": "string", "email": "string", "createdAt": "string", "updatedAt": "string"}| 201 CREATED
로그인  | POST    | /login| -    | {"email": "string", "password": "string"} | 로그인 되었습니다.  | 200 OK
로그아웃  | POST    | /logout| {Authentication: Session (Cookie)}| -  | 로그아웃 되었습니다.  | 200 OK
전체 유저 조회  | GET    | /users|  {Authentication: Session (Cookie)}   | -        | {"id": 1, "username": "string", "email": "string", "createdAt": "string", "updatedAt": "string"} | 200 OK
단건 유저 조회  | GET    | /users/{userId}|  {Authentication: Session (Cookie)}   | -         | {"id": 1, "username": "string", "email": "string", "createdAt": "string", "updatedAt": "string"}| 200 OK
유저 정보 수정  | PATCH    | /users/me | {Authentication: Session (Cookie)}| {"email": "string"}   | {"id": 1, "username": "string", "email": "string", "createdAt": "string", "updatedAt": "string"} | 200 OK
회원탈퇴  | DELETE    | /users/me | {Authentication: Session (Cookie)}| password        | -    | 204 NO CONTENT

---

## SCHEDULE API 

기능     |  Method | URL    | 인증   | request | response | HTTP 상태코드 
--------|---------|--------|-------|---------|----------|---------
일정 생성  | POST    | /schedules | {Authentication: Session (Cookie)}| {"title": "string", "content": "string"}  | {"id": 1, "userId": 2, "title": "string", "content": "string", "createdAt": "string", "updatedAt": "string"} | 201 CREATED
전체 일정 조회  | GET    | /schedules| -      | -        | {"id": 1, "userId": 2, "title": "string", "content": "string", "createdAt": "string", "updatedAt": "string"} | 200 OK
단건 일정 조회  | GET    | /schedules/{scheduleId}| -    | -      |  {"id": 1, "userId": 2, "title": "string", "content": "string", "createdAt": "string", "updatedAt": "string"} | 200 OK
일정 수정  | PUT    | /schedules/{scheduleId}| {Authentication: Session (Cookie)}| {"title": "string", "content": "string"}      |  {"id": 1, "userId": 2, "title": "string", "content": "string", "createdAt": "string", "updatedAt": "string"} | 200 OK
일정 삭제  | DELETE    | /schedules/{scheduleId} | {Authentication: Session (Cookie)}| -        | -    | 204 NO CONTENT

---

## COMMENT API 

기능     |  Method | URL    | 인증   | request | response | HTTP 상태코드 
--------|---------|--------|-------|---------|----------|---------
댓글 생성  |POST    | /schedules/{scheduleId}/comments | {Authentication: Session (Cookie)} | content |  id, scheduleId, userId, comment, createdAt, updatedAt | 201 CREATED  
특정 일정 전체 댓글 조회  | GET    | /schedules/{scheduleId}/comments | -    | -         | {"id": 1, "scheduleId": 11, "userId": 2, "content": "string", "createdAt": "string", "updatedAt": "string"} | 200 OK
댓글 수정  | PUT   | /comments/{commentId} | {Authentication: Session (Cookie)}| {"content": "string"}   | {"id": 1, "scheduleId": 11, "userId": 2, "content": "string", "createdAt": "string", "updatedAt": "string"} | 200 OK
댓글 삭제  | DELETE    | /comments/{commentId} | {Authentication: Session (Cookie)}|        | -    | 204 NO CONTENT

---

## Error Spec

HTTP 상태코드 | 오류 메시지 
------------|-------------------------------------
400         | 비밀번호는 최소 8자 이상을 입력해주셔야 합니다.
404         | 해당 ID의 유저(일정, 댓글)를 찾을 수 없습니다.
500         | 잘못된 입력입니다.   

---

## 기타 참고사항

- 모든 날짜 필드는 ISO 8601 형식 (`yyyy-MM-dd'T'HH:mm:ss`)으로 반환됩니다.
- 인증이 필요한 요청은 반드시 로그인 후 세션이 유지된 상태에서 호출해야 합니다.
- 회원탈퇴 시 관련 일정 및 댓글은 soft delete 처리됩니다.

---

## ERD
<img width="1429" height="542" alt="Scheduler" src="https://github.com/user-attachments/assets/c8f3b57b-d508-4342-a28e-03405eb79612" />

