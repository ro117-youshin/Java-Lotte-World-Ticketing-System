package lotteworldticketing;

import java.util.ArrayList;

public class PrintOut {
	OrderData orderItem = new OrderData();
	
	public void printOut(ArrayList<OrderData> orderList, int finalFee) {
		System.out.printf("==========================LOTTE WORLD=============================\n\n");
		System.out.printf("날짜\t\t이용권\t옵션\t연령\t장수\t가격\t우대사항\n");
		for (int index = 0; index < orderList.size(); index++) {
			printDate(orderList.get(index).getOrderDate());
			
			printTicketType(orderList.get(index).getTicketTypeToString());
			
			printTicketTimeType(orderList.get(index).getTicketTimeTypeToString());
			
			printBasicFeeType(orderList.get(index).getBasicFeeTypeToString());

			printOrderListNumberOfTicket(orderList.get(index).getNumberOfTicket());
			
			printTotalFee(orderList.get(index).getTotalFee());
			
			printAdvantageType(orderList.get(index).getAdvantageTypeToString());
			System.out.println();
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
	
	public void printTicketType (String ticketType) {
		System.out.printf("%s", ticketType);
	}
	
	public void printTicketTimeType (String ticketTimeType) {
		System.out.printf("%s", ticketTimeType);
	}
	
	public void printBasicFeeType (String basicFeeType) {
		System.out.printf("%s", basicFeeType);
	}
	
	public void printOrderListNumberOfTicket (int numberOfTicket) {
		System.out.printf("X %d\t", numberOfTicket);
	}
	
	public void printTotalFee (int totalFee) {
		System.out.printf("%d\t", totalFee);
	}
	
	public void printAdvantageType (String advantageType) {
		System.out.printf("%s\t", advantageType);
	}
	
}
