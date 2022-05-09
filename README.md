# :pushpin:LotteWorldTicketinginJava

<p align="center">
<img src = "https://user-images.githubusercontent.com/86038910/164522037-81c5f507-4b44-45e6-8d94-c3d56ecf4c8e.png" width="500px">
</p>

# 📎About LotteWorldTicketing
롯데월드 티켓발급 프로그램입니다.

티켓요금 및 요금/우대혜택은 롯데월드 홈페이지를 참고하였습니다. (2022.04.22)
https://adventure.lotteworld.com/kor/price/ticket/contentsid/282/index.do

# :page_with_curl:Getting Started

### :bulb: 이용안내
+ 1회 주문 시 최대 10장까지 주문 가능합니다.
+ 주민등록번호를 신중하게 눌러주세요.
+ 우대사항은 해당사항일 경우에만 입력해 주세요.
+ 연령에 따른 요금할인은 주민등록번호 입력 시 자동으로 할인 됩니다.

### :bulb: 티켓팅 상세 이용법 (입력값)

#### 1. 이용권 선택

#### 1) 종합이용권 2) 파크이용권 입력

#### 2. 옵션 선택 (시간) 

#### 1) 1Day 2) After4 

#### 3. 주민등록번호 앞 6자리 입력 

#### ex) 930820

#### 4. 주민등록번호 뒤 첫째 자리 입력

#### ex) 1

#### 5. 우대사항 선택 (해당사항일 경우) 

#### 0) 우대사항 없음 1) 장애인 2) 국가유공자 3) 휴가장병 4) 임산부 5) 다둥이 행복카드

#### 6. 계속 발권 여부

#### 1) 티켓 발권 2) 종료      

#### 6 - 1) 티켓 발권 입력 시 이어서 티켓 구매, 다시 1.로 이동 (하나의 영수증으로 계산된다.)

#### 6 - 2) 종료 입력 시 8. 로 이동 

#### 7. 계속 진행 여부

#### 1) 새로운 주문 2) 프로그램 종료

#### 7 - 1) 새로운 주문 - 기존 티켓 구매와 별도로 새로운 주문이 시작된다.

#### 7 - 2) 프로그램 종료 - 프로그램 완전히 종료

# 📂Directory

```bash
├── lotteworldticketing
│    ├── LotteWorldTicketing.java
│    ├── Calculate.java
│    ├── InputSystem.java
│    ├── OrderData.java
│    ├── OutputSystem.java
│    ├── PrintOut.java
│    ├── StaticValue.java
│    └── WriteToCSV.java
```

# 📙Overview

+ LotteWorldTicketing.java : Main 클래스
+ Calculate.java : 모든 계산이 이루어지는 클래스
+ InputSystem.java : 입력 클래스 (데이터 입력), Scanner 클래스 사용
+ OutputSystem.java : 각 클래스를 생성하여 시스템 구현 및 BufferedWriter/FileWriter/File클래스로 CSV파일 생성 및 데이터 입력
+ PrintOut.java : 각 데이터를 ArrayList에 add
+ WriteToCSV.java : CSV파일에 넣을 값을 문자열에 넣기
+ StaticValue.java : 모든 상수 저장
+ OrderData.java : 모든 변수 getter/setter 저장


## :ballot_box_with_check:Supported Modules
+ JDK 17+
