# BE
BackEnd-JAVA, SpringBoot

# 최종 프로젝트

## 1. 프로젝트 소개

본 프로젝트는 최종 프로젝트로, 이지연 고나령 김현지 협업으로 진행하였다.      
기간은 2022년 5월 17일 부터 5월 27일 평일 동안 진행하였다.      
주제는 "운동"으로, 운동 영상 정보와 리뷰 기능을 제공하고, 찜 목록과 팔로우 기능을 추가적으로 구현하여 운동 영상 기록 관리를 할 수 있는 웹 서비스이다. 
하단의 결과물은 백엔드 REST API 방식으로 구현된 결과물이다.      

## 2. 프로젝트 결과물 소개
![image](https://user-images.githubusercontent.com/99406873/170677770-85fcbdaf-0cc2-4a67-87b1-8a72fbbebad1.png)


### 1. 영상 게시물 컨트롤러
![image](https://user-images.githubusercontent.com/99406873/170677420-000c1504-2f91-4668-9d6c-8372a1e71a0b.png)

### 2. 유저 컨트롤러
![image](https://user-images.githubusercontent.com/99406873/170677482-d0e29f2d-5fa3-4f53-8c50-33e3ea24af0b.png)

### 3. 댓글 컨트롤러
![image](https://user-images.githubusercontent.com/99406873/170677523-0b52cf99-e177-4aba-ba9c-42491662a47d.png)

### 4. 대댓글 컨트롤러
![image](https://user-images.githubusercontent.com/99406873/170677545-3c8146d1-adc7-4216-a253-8a961642dfb0.png)

### 5. 좋아요 컨트롤러
![image](https://user-images.githubusercontent.com/99406873/170679150-79f25d7b-d838-4a02-be2e-efea09311e62.png)

### 6. 팔로우 컨트롤러
![image](https://user-images.githubusercontent.com/99406873/170677699-d3e54fb1-2659-4e58-bca2-66b47ef47cca.png)


## 3. 프로젝트 요약

### 기능 구현

1. 영상 게시물 컨트롤러
   - 영상 생성
   - 영상 상세 조회
   - 영상 수정
   - 영상 삭제
   - 영상 목록 조회
   - 선택 파트 별 영상 목록 조회
   - 검색어를 통한 영상 목록 조회
   - user가 좋아하는 영상 목록 조회
   - user가 좋아하는 선택 파트 별영상 목록 조회
   - 나이 별 좋아요 순 영상 목록 조회
   - 성별 별 좋아요 순 영상 목록 조회
   - 조회수 순 인기 영상 목록 조회
2. 유저 컨트롤러
   - 유저 회원가입
   - 유저 로그인
   - 유저 정보 수정
   - 유저 탈퇴
   - 유저 상세 조회
   - 유저 목록 조회
   - 유저 검색 조회
   - 아이디 존재 유무 조회
   - 팔로잉 목록 조회
   - 팔로워 목록 조회
3. 댓글 컨트롤러
   - 댓글 작성
   - 게시물 번호에 따른 댓글 목록 조회
   - 댓글 수정
   - 댓글 삭제
4. 대댓글 컨트롤러
   - 대댓글 작성
   - 댓글 번호에 따른 대댓글 목록 조회
   - 대댓글 수정
   - 대댓글 삭제
5. 좋아요 컨트롤러
   - 좋아요 생성
   - 좋아요 삭제
6. 관계 컨트롤러
   - 관계 생성
   - 관계 조회
   - 관계 삭제

## 4. 소감

### KO로이김 

- 김현지      
       
  이번 DB 관통도 시작 전에는 걱정이 많았지만 하다 보니까 재밌기도 했고 생각보다 괜찮게 진행 할 수 있었습니다. DB랑 웹의 연결이라 어렵게만 생각했었는데 오히려 impl로 함수를 다 구현해서 작성했을 때 보다 더 편하게 데이터를 가져다가 사용할 수 있었습니다. 분업 하기 전에 ERD를 작성해 어떤 구조로 진행되는지 더 확실히 알 수 있었습니다. 그리고 서로 모르는건 물어가며 답해주고 프로젝트를 잘 진행 할 수 있게 도와준 팀원들에게 감사합니다. 

- 이지연

  REST API로 구현하는 백엔드 프로젝트이기 때문에 REST API 문서를 스웨거로 작성하면서 프론트엔드 개발 진행 시 활용 할 수 있도록 하고, 협업을 하면서 서로의 기능을 사용할 때 참고하는 용도로 사용하게 되었습니다. 이를 통해 보다 편리하게 백엔드와 프론트엔드 연결을 할 수 있었고, 팀원들과 기획을 바탕으로 기능을 구현하면서 즐겁게 협업할 수 있었습니다. 또한, 깃을 보다 체계적으로 활용하였던 것이 가장 기억에 남습니다.

- 고나령
  
  나령이의 후기
  짧은 기간 동안 UI스토리보드, JWT, AWS 등 새로 알고 사용한 것들이 많아서 좋았습니다. 처음엔 할 일이 너무 많게 느껴져서 막막했는데 든든한 팀원들 덕분에 차근차근 잘 진행해서 마무리 할 수 있었습니다. 깃 활용도 재밌었고 미리 정해둔 양식 덕분에 서로 간 의사소통 문제가 발생하지 않아서 그 중요성을 크게 깨달을 수 있었습니다

---
