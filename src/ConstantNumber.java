package lotteworldticketing;

public final class ConstantNumber {
	// 종합이용권의 1DAY
	public static final int FULL_TICKET_1DAY_ADULT = 62000;
	public static final int FULL_TICKET_1DAY_TEEN = 54000;
	public static final int FULL_TICKET_1DAY_CHILD = 47000;
	// 종합이용권의 AFTER4
	public static final int FULL_TICKET_AFTER4_ADULT = 50000;
	public static final int FULL_TICKET_AFTER4_TEEN = 43000;
	public static final int FULL_TICKET_AFTER4_CHILD = 36000;
	// 파크이용권의 1DAY
	public static final int PARK_TICKET_1DAY_ADULT = 59000;
	public static final int PARK_TICKET_1DAY_TEEN = 52000;
	public static final int PARK_TICKET_1DAY_CHILD = 46000;
	// 파크이용권의 AFTER4
	public static final int PARK_TICKET_AFTER4_ADULT = 47000;
	public static final int PARK_TICKET_AFTER4_TEEN = 41000;
	public static final int PARK_TICKET_AFTER4_CHILD = 35000;
	// 베이비
	public static final int BABY = 15000; 
	public static final int BABY_NO_CHARGE = 0; // 무료 입장
	// 연령에 따른 요금 적용 기준
	public static final int MIN_ADULT_AGE = 19;
	public static final int MAX_ADULT_AGE = 64;
	public static final int MIN_TEEN_AGE = 13;
	public static final int MAX_TEEN_AGE = 18;
	public static final int MIN_CHILD_AGE = 3;
	public static final int MAX_CHILD_AGE = 12;
	public static final int MIN_BABY_AGE = 1;
	public static final int MAX_BABY_AGE = 3;
	// 우대사항별 할인율
	public static final double DISCOUNT_RATE_DISABLED = 0.5;
	public static final double DISCOUNT_RATE_MAN_OF_MERIT = 0.5;
	public static final double DISCOUNT_RATE_SOLDIER = 0.51;
	public static final double DISCOUNT_RATE_PREGNANT = 0.5;
	public static final double DISCOUNT_RATE_CHILDREN_CARD = 0.7;
	// 티켓팅 타입 선택
	public static final int TICKET_TYPE_ONE = 1; // 종합이용권
	public static final int TICKET_TYPE_TWO = 2; // 파크이용권
	public static final int TICKET_TIME_TYPE_ONE = 1; // 1Day
	public static final int TICKET_TIME_TYPE_TWO = 2; // After4
	// BASIC FEE TYPE 0. 어른 1. 청소년 2. 어린이 3. 베이비
	public static final int BASIC_FEE_TYPE_ZERO = 0;
	public static final int BASIC_FEE_TYPE_ONE = 1;
	public static final int BASIC_FEE_TYPE_TWO = 2;
	public static final int BASIC_FEE_TYPE_THREE = 3;
	// 우대사항 선택
	public static final int ADVANTAGE_TYPE_NOT_APPLICABLE = 0;
	public static final int ADVANTAGE_TYPE_DISABLED = 1;
	public static final int ADVANTAGE_TYPE_MAN_OF_MERIT = 2;
	public static final int ADVANTAGE_TYPE_SOLDIER = 3;
	public static final int ADVANTAGE_TYPE_PREGNANT = 4;
	public static final int ADVATAGE_TYPE_CHILDREN_CARD = 5;
	// century
	public static final int CENTURY_1900S = 1900; 
	public static final int CENTURY_2000S = 2000;
	// Process 동작 버튼
	public static final int CONTINUE_BUTTON = 1; // 계속 티켓 발권
	public static final int NEW_ORDER_BUTTON = 1; // 새로운 주문
	
}
