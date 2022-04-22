package lotteworldticketing;

import java.util.ArrayList;

public class PrintOut {
	
	public void printOut(ArrayList<OrderData> orderList, int finalFee) {
		System.out.printf("==========================LOTTE WORLD=============================\n\n");
		System.out.printf("��¥\t\t�̿��\t�ɼ�\t����\t���\t����\t������\n");
		for (int index = 0; index < orderList.size(); index++) {
			printDate(orderList.get(index).getOrderDate());
			
			printTicketType(orderList.get(index).getTicketType());

			printTicketTimeType(orderList.get(index).getTicketTimeType());
			
			printBasicFeeType(orderList.get(index).getBasicFeeType());

			printOrderListNumberOfTicket(orderList.get(index).getNumberOfTicket());
			
			printTotalFee(orderList.get(index).getTotalFee());

			printAdvantageType(orderList.get(index).getAdvantageType());
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
	
	public void printTicketType (int ticketType) {
		if (ticketType == StaticValue.TICKET_TYPE_ONE) {
			System.out.printf("�����̿��\t");
		} else if (ticketType == StaticValue.TICKET_TYPE_TWO) {
			System.out.printf("��ũ�̿��\t");
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
			System.out.printf("�\t");
		} else if (basicFeeType == StaticValue.BASIC_FEE_TYPE_ONE) {
			System.out.printf("û�ҳ�\t");
		} else if (basicFeeType == StaticValue.BASIC_FEE_TYPE_TWO) {
			System.out.printf("���\t");
		} else if (basicFeeType == StaticValue.BASIC_FEE_TYPE_THREE) {
			System.out.printf("���̺�\t");
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
			System.out.printf("*������ ����\t");
		} else if (advantageType == StaticValue.ADVANTAGE_TYPE_DISABLED) {
			System.out.printf("*����� ���\t");
		} else if (advantageType == StaticValue.ADVANTAGE_TYPE_MAN_OF_MERIT) {
			System.out.printf("*���������� ���\t");
		} else if (advantageType == StaticValue.ADVANTAGE_TYPE_SOLDIER) {
			System.out.printf("*�ް��庴 ���\t");
		} else if (advantageType == StaticValue.ADVANTAGE_TYPE_PREGNANT) {
			System.out.printf("*�ӻ�� ���\t");
		} else if (advantageType == StaticValue.ADVATAGE_TYPE_CHILDREN_CARD) {
			System.out.printf("*�ٵ��� �ູī�� ���\t");
		}
		System.out.printf("\n");
	}
	
}
