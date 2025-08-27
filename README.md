# scheduler
일정 관리 앱입니다.
SESSION 기반으로 동작합니다.

#

## USER API 명세서

기능     |  Method | URL    | 인증   | request | response | 상태코드 
--------|---------|--------|-------|---------|----------|---------
회원가입  | POST    | /signup|- | {"username": "string", "email": "string", "password": "string"} | {"id": 1, "username": "string", "email": "string", "createdAt": "string", "updatedAt": "string"}| 201 CREATED
로그인  | POST    | /login| -    | {"email": "string", "password": "string"} | -  | 200 OK
로그아웃  | POST    | /logout| {Authentication: Session (Cookie)}| -  | -  | 200 OK
전체 유저 조회  | GET    | /users|  {Authentication: Session (Cookie)}   | -        | {"id": 1, "username": "string", "email": "string", "createdAt": "string", "updatedAt": "string"} | 200 OK
단건 유저 조회  | GET    | /users/{userId}|  {Authentication: Session (Cookie)}   | -         | {"id": 1, "username": "string", "email": "string", "createdAt": "string", "updatedAt": "string"}| 200 OK
유저 정보 수정  | PATCH    | /users/me | {Authentication: Session (Cookie)}| {"email": "string"}   | {"id": 1, "username": "string", "email": "string", "createdAt": "string", "updatedAt": "string"} | 200 OK
회원탈퇴  | DELETE    | /users/me | {Authentication: Session (Cookie)}| password        | -    | 204 NO CONTENT

#

## SCHEDULE API 명세서

기능     |  Method | URL    | 인증   | request | response | 상태코드 
--------|---------|--------|-------|---------|----------|---------
일정 생성  | POST    | /schedules | {Authentication: Session (Cookie)}| {"title": "string", "content": "string"}  | {"id": 1, "userId": 2, "title": "string", "content": "string", "createdAt": "string", "updatedAt": "string"} | 201 CREATED
전체 일정 조회  | GET    | /schedules| -      | -        | {"id": 1, "userId": 2, "title": "string", "content": "string", "createdAt": "string", "updatedAt": "string"} | 200 OK
단건 일정 조회  | GET    | /schedules/{scheduleId}| -    | -      |  {"id": 1, "userId": 2, "title": "string", "content": "string", "createdAt": "string", "updatedAt": "string"} | 200 OK
일정 수정  | PUT    | /schedules/{scheduleId}| {Authentication: Session (Cookie)}| {"title": "string", "content": "string"}      |  {"id": 1, "userId": 2, "title": "string", "content": "string", "createdAt": "string", "updatedAt": "string"} | 200 OK
일정 삭제  | DELETE    | /schedules/{scheduleId} | {Authentication: Session (Cookie)}| -        | -    | 204 NO CONTENT

#

## COMMENT API 명세서

기능     |  Method | URL    | 인증   | request | response | 상태코드 
--------|---------|--------|-------|---------|----------|---------
댓글 생성  |POST    | /schedules/{scheduleId}/comments | {Authentication: Session (Cookie)} | content |  id, scheduleId, userId, comment, createdAt, updatedAt | 201 CREATED  
댓글 생성  |POST    | /schedules/{scheduleId}/comments | {Authentication: Session (Cookie)}| {"content": "string"} | -    |  400 BAD REQUEST, 401 UNAUTHORIZED
특정 일정 전체 댓글 조회  | GET    | /schedules/{scheduleId}/comments | -    | -         | {"id": 1, "scheduleId": 11, "userId": 2, "content": "string", "createdAt": "string", "updatedAt": "string"} | 200 OK
특정 일정 전체 댓글 조회  | GET    | /schedules/{scheduleId}/comments | -     | -       | -   |  400 BAD REQUEST 
댓글 수정  | PUT   | /comments/{commentId} | {Authentication: Session (Cookie)}| {"content": "string"}   | {"id": 1, "scheduleId": 11, "userId": 2, "content": "string", "createdAt": "string", "updatedAt": "string"} | 200 OK
댓글 수정  | PUT   | /comments/{commentId} | {Authentication: Session (Cookie)}|{"content": "string"}  | -  | 400 BAD REQUEST, 401 UNAUTHORIZED
댓글 삭제  | DELETE    | /comments/{commentId} | {Authentication: Session (Cookie)}|        | -    | 204 NO CONTENT
댓글 삭제  | DELETE    | /comments/{commentId} | {Authentication: Session (Cookie)}|        | -    | 400 BAD REQUEST, 401 UNAUTHORIZED

#

## ERD

<img width="1411" height="542" alt="Scheduler" src="https://github.com/user-attachments/assets/f68b332e-2a6f-427b-b03e-2e978e7e5c57" />

