# scheduler
일정 관리 앱입니다.
SESSION 기반으로 동작합니다.

#

## USER API 명세서

기능     |  Method | URL    | request | response | 상태코드
--------|---------|--------|---------|----------|---------
회원가입  | POST    | /signup| username, email, password | id, username, email, createdAt, updatedAt | 201 CREATED
로그인  | POST    | /login| email, password |   | 200 OK
로그아웃  | POST    | /logout|   |   | 200 OK
전체 유저 조회  | GET    | /users|         | id, username, email, createdAt, updatedAt | 200 OK
단건 유저 조회  | GET    | /users/{userId}|         | id, username, email, createdAt, updatedAt | 200 OK
유저 정보 수정  | PATCH    | /users/me | email      | id, username, email, createdAt, updatedAt | 200 OK
회원탈퇴  | DELETE    | /users/me | password        |     | 204 NO CONTENT

#

## SCHEDULE API 명세서

기능     |  Method | URL    | request | response | 상태코드
--------|---------|--------|---------|----------|---------
일정 생성  | POST    | /schedules | title, content | id, userId, title, content, createdAt, updatedAt | 201 CREATED
전체 일정 조회  | GET    | /schedules|         | id, userId, title, content, createdAt, updatedAt | 200 OK
단건 일정 조회  | GET    | /schedules/{scheduleId}|         | id, userId, title, content, createdAt, updatedAt | 200 OK
일정 수정  | PUT    | /schedules/{scheduleId}| title, content      | id, userId, title, content, createdAt, updatedAt | 200 OK
일정 삭제  | DELETE    | /schedules/{scheduleId} |         |     | 204 NO CONTENT

#

## COMMENT API 명세서
기능     |  Method | URL    | request | response | 상태코드
--------|---------|--------|---------|----------|---------
댓글 생성  | POST    | /schedules/{scheduleId}/comments | comment |  id, scheduleId, userId, comment, createdAt, updatedAt | 201 CREATED
특정 게시물 전체 댓글 조회  | GET    | /schedules/{scheduleId}/comments |         | id, scheduleId, userId, comment, createdAt, updatedAt | 200 OK
특정 게시물 단건 댓글 조회  | GET    |  /schedules/{scheduleId}/comments/{commentId} |         | id, scheduleId, userId, comment, createdAt, updatedAt | 200 OK
댓글 수정  | PUT   | /comments/{commentId} | comment   | id, scheduleId, userId, comment, createdAt, updatedAt | 200 OK
댓글 삭제  | DELETE    | /comments/{commentId} |         |     | 204 NO CONTENT


#

## ERD

<img width="1411" height="542" alt="Scheduler" src="https://github.com/user-attachments/assets/53d665ed-1420-47af-ad7a-a68425155598" />

