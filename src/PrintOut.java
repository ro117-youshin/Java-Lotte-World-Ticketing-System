package lotteworldticketing;

import java.util.ArrayList;

public class PrintOut {
	
	public void printOut(ArrayList<OrderData> orderList, int finalFee) {
		System.out.printf("==========================LOTTE WORLD=============================\n\n");
		System.out.printf("날짜\t\t이용권\t옵션\t연령\t장수\t가격\t우대사항\n");
		for (int index = 0; index < orderList.size(); index++) {
			printDate(orderList.get(index).getOrderDate());
			
			printTicketType(orderList.get(index).getTicketType());

			printTicketTimeType(orderList.get(index).getTicketTimeType());
			
			printBasicFeeType(orderList.get(index).getBasicFeeType());

			printOrderListNumberOfTicket(orderList.get(index).getNumberOfTicket());
			
			printTotalFee(orderList.get(index).getTotalFee());

			printAdvantageType(orderList.get(index).getAdvantageType());
		}
		System.out.printf("\n입장료 총액은 %d원 입니다.\n", finalFee);
		System.out.printf("==================================================================\n");
		System.out.printf("티켓 구매를 종료합니다. 감사합니다.\n");
		System.out.printf("\n");
		System.out.printf("계속 진행하시겠습니까? 1. 새로운 주문 2. 프로그램 종료\n");
		System.out.printf("\n");
	}
	public void printDate (String orderDate) {
		System.out.printf("%s\t", orderDate);
	}
	
	public void printTicketType (int ticketType) {
		if (ticketType == StaticValue.TICKET_TYPE_ONE) {
			System.out.printf("종합이용권\t");
		} else if (ticketType == StaticValue.TICKET_TYPE_TWO) {
			System.out.printf("파크이용권\t");
		}
	}
	
	public void printTicketTimeType (int ticketTimeType) {
		if (ticketTimeType == StaticValue.TICKET_TIME_TYPE_ONE) {
			System.out.printf("1Day\t");
		} else if (ticketTimeType == StaticValue.TICKET_TIME_TYPE_TWO) {
			System.out.printf("After4\t");
		}
	}
	
	public void printBasicFeeType (int basicFeeType) {
		if (basicFeeType == StaticValue.BASIC_FEE_TYPE_ZERO) {
			System.out.printf("어른\t");
		} else if (basicFeeType == StaticValue.BASIC_FEE_TYPE_ONE) {
			System.out.printf("청소년\t");
		} else if (basicFeeType == StaticValue.BASIC_FEE_TYPE_TWO) {
			System.out.printf("어린이\t");
		} else if (basicFeeType == StaticValue.BASIC_FEE_TYPE_THREE) {
			System.out.printf("베이비\t");
		}
	}
	
	public void printOrderListNumberOfTicket (int numberOfTicket) {
		System.out.printf("X %d\t", numberOfTicket);
	}
	
	public void printTotalFee (int totalFee) {
		System.out.printf("%d\t", totalFee);
	}
	
	public void printAdvantageType (int advantageType) {

		if (advantageType == StaticValue.ADVANTAGE_TYPE_NOT_APPLICABLE) {
			System.out.printf("*우대사항 없음\t");
		} else if (advantageType == StaticValue.ADVANTAGE_TYPE_DISABLED) {
			System.out.printf("*장애인 우대\t");
		} else if (advantageType == StaticValue.ADVANTAGE_TYPE_MAN_OF_MERIT) {
			System.out.printf("*국가유공자 우대\t");
		} else if (advantageType == StaticValue.ADVANTAGE_TYPE_SOLDIER) {
			System.out.printf("*휴가장병 우대\t");
		} else if (advantageType == StaticValue.ADVANTAGE_TYPE_PREGNANT) {
			System.out.printf("*임산부 우대\t");
		} else if (advantageType == StaticValue.ADVATAGE_TYPE_CHILDREN_CARD) {
			System.out.printf("*다둥이 행복카드 우대\t");
		}
		System.out.printf("\n");
	}
	
}
