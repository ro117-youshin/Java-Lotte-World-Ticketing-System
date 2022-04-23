package lotteworldticketing;

import java.util.ArrayList;

public class PrintOut {
	OrderData orderItem = new OrderData();
	
	public void printOut(ArrayList<OrderData> orderList, int finalFee) {
		System.out.printf("==========================LOTTE WORLD=============================\n\n");
		System.out.printf("��¥\t\t�̿��\t�ɼ�\t����\t���\t����\t������\n");
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
		System.out.printf("\n����� �Ѿ��� %d�� �Դϴ�.\n", finalFee);
		System.out.printf("==================================================================\n");
		System.out.printf("Ƽ�� ���Ÿ� �����մϴ�. �����մϴ�.\n");
		System.out.printf("\n");
		System.out.printf("��� �����Ͻðڽ��ϱ�? 1. ���ο� �ֹ� 2. ���α׷� ����\n");
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
