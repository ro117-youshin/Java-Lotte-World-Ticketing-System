package lotteworldticketing;

import java.util.ArrayList;
import java.util.Scanner;

public class OutputSystem {
	ArrayList<OrderData> orderList = new ArrayList<OrderData>();
	InputSystem inputTicketSystem = new InputSystem();
	OrderData orderItem;
	Calculate cal = new Calculate(); 
	Scanner sc = new Scanner(System.in);

	public void printOut() {
		System.out.printf("이용권\t옵션\t연령\t장수\t가격\t우대사항\n");
		for (int index = 0; index < orderList.size(); index++) {
			if (orderItem.ticketType == StaticValue.TICKET_TYPE_ONE) {
				System.out.printf("종합이용권\t");
			} else if (orderItem.ticketType == StaticValue.TICKET_TYPE_TWO) {
				System.out.printf("파크이용권\t");
			}

			if (orderItem.ticketTimeType == StaticValue.TICKET_TIME_TYPE_ONE) {
				System.out.printf("1Day\t");
			} else if (orderItem.ticketTimeType == StaticValue.TICKET_TIME_TYPE_TWO) {
				System.out.printf("After4\t");
			}

			if (orderItem.basicFeeType == StaticValue.BASIC_FEE_TYPE_ZERO) {
				System.out.printf("어른\t");
			} else if (orderItem.basicFeeType == StaticValue.BASIC_FEE_TYPE_ONE) {
				System.out.printf("청소년\t");
			} else if (orderItem.basicFeeType == StaticValue.BASIC_FEE_TYPE_TWO) {
				System.out.printf("어린이\t");
			} else if (orderItem.basicFeeType == StaticValue.BASIC_FEE_TYPE_THREE) {
				System.out.printf("베이비\t");
			}

			System.out.printf("X %d\t", orderItem.numberOfTicket);
			System.out.printf("%d\t", orderItem.totalFee);

			if (orderItem.advantageType == StaticValue.ADVANTAGE_TYPE_NOT_APPLICABLE) {
				System.out.printf("*우대사항 없음\t");
			} else if (orderItem.advantageType == StaticValue.ADVANTAGE_TYPE_DISABLED) {
				System.out.printf("*장애인 우대\t");
			} else if (orderItem.advantageType == StaticValue.ADVANTAGE_TYPE_MAN_OF_MERIT) {
				System.out.printf("*국가유공자 우대\t");
			} else if (orderItem.advantageType == StaticValue.ADVANTAGE_TYPE_SOLDIER) {
				System.out.printf("*휴가장병 우대\t");
			} else if (orderItem.advantageType == StaticValue.ADVANTAGE_TYPE_PREGNANT) {
				System.out.printf("*임산부 우대\t");
			} else if (orderItem.advantageType == StaticValue.ADVATAGE_TYPE_CHILDREN_CARD) {
				System.out.printf("*다둥이 행복카드 우대\t");
			}
			System.out.printf("\n");
		}
	}

	public void inputDatainArrayList() {
		orderList.add(orderItem);
	}
	
	public void totalTicketFee() {
		orderItem.finalFee += orderItem.totalFee;
	}
	
	public void continueButtonPrintOut() {
		do {
			orderItem = new OrderData();
			// 입력
			inputTicketSystem.inputInformation(orderItem);
			cal.calFinal(orderItem);
			// ArrayList에 Data 넣기
			inputDatainArrayList();
			//
			totalTicketFee();
			//
			orderItem.orderCount++;
			System.out.printf("\n계속 발권하시겠습니까?\n1. 티켓 발권\n2. 종료\n");
			orderItem.continueButton = sc.nextInt();
			System.out.printf("\n");
		} while (orderItem.continueButton == StaticValue.CONTINUE_BUTTON);
		System.out.printf("=======================LOTTE WORLD=========================\n\n");
		printOut();
		System.out.printf("\n총액은 %d원 입니다.\n", orderItem.finalFee);
		System.out.printf("티켓 구매를 종료합니다. 감사합니다.\n");
		System.out.printf("\n");
		System.out.printf("계속 진행하시겠습니까? 1. 새로운 주문 2. 프로그램 종료\n");
		orderItem.newOrderButton = sc.nextInt();
		System.out.printf("\n");
		orderItem.orderCount = 0; // 주문한 티켓 장 수 초기화
		orderItem.finalFee = 0; // 주문한 티켓 내역 초기화
	}
	
	public void StartSystem() {
		do {
			continueButtonPrintOut();
		} while (orderItem.newOrderButton == StaticValue.NEW_ORDER_BUTTON);
		System.out.println("티켓 구매를 완전히 종료합니다. 감사합니다.\n");
	}
	
}