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
		System.out.printf("�̿��\t�ɼ�\t����\t���\t����\t������\n");
		for (int index = 0; index < orderList.size(); index++) {
			if (orderItem.ticketType == StaticValue.TICKET_TYPE_ONE) {
				System.out.printf("�����̿��\t");
			} else if (orderItem.ticketType == StaticValue.TICKET_TYPE_TWO) {
				System.out.printf("��ũ�̿��\t");
			}

			if (orderItem.ticketTimeType == StaticValue.TICKET_TIME_TYPE_ONE) {
				System.out.printf("1Day\t");
			} else if (orderItem.ticketTimeType == StaticValue.TICKET_TIME_TYPE_TWO) {
				System.out.printf("After4\t");
			}

			if (orderItem.basicFeeType == StaticValue.BASIC_FEE_TYPE_ZERO) {
				System.out.printf("�\t");
			} else if (orderItem.basicFeeType == StaticValue.BASIC_FEE_TYPE_ONE) {
				System.out.printf("û�ҳ�\t");
			} else if (orderItem.basicFeeType == StaticValue.BASIC_FEE_TYPE_TWO) {
				System.out.printf("���\t");
			} else if (orderItem.basicFeeType == StaticValue.BASIC_FEE_TYPE_THREE) {
				System.out.printf("���̺�\t");
			}

			System.out.printf("X %d\t", orderItem.numberOfTicket);
			System.out.printf("%d\t", orderItem.totalFee);

			if (orderItem.advantageType == StaticValue.ADVANTAGE_TYPE_NOT_APPLICABLE) {
				System.out.printf("*������ ����\t");
			} else if (orderItem.advantageType == StaticValue.ADVANTAGE_TYPE_DISABLED) {
				System.out.printf("*����� ���\t");
			} else if (orderItem.advantageType == StaticValue.ADVANTAGE_TYPE_MAN_OF_MERIT) {
				System.out.printf("*���������� ���\t");
			} else if (orderItem.advantageType == StaticValue.ADVANTAGE_TYPE_SOLDIER) {
				System.out.printf("*�ް��庴 ���\t");
			} else if (orderItem.advantageType == StaticValue.ADVANTAGE_TYPE_PREGNANT) {
				System.out.printf("*�ӻ�� ���\t");
			} else if (orderItem.advantageType == StaticValue.ADVATAGE_TYPE_CHILDREN_CARD) {
				System.out.printf("*�ٵ��� �ູī�� ���\t");
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
			// �Է�
			inputTicketSystem.inputInformation(orderItem);
			cal.calFinal(orderItem);
			// ArrayList�� Data �ֱ�
			inputDatainArrayList();
			//
			totalTicketFee();
			//
			orderItem.orderCount++;
			System.out.printf("\n��� �߱��Ͻðڽ��ϱ�?\n1. Ƽ�� �߱�\n2. ����\n");
			orderItem.continueButton = sc.nextInt();
			System.out.printf("\n");
		} while (orderItem.continueButton == StaticValue.CONTINUE_BUTTON);
		System.out.printf("=======================LOTTE WORLD=========================\n\n");
		printOut();
		System.out.printf("\n�Ѿ��� %d�� �Դϴ�.\n", orderItem.finalFee);
		System.out.printf("Ƽ�� ���Ÿ� �����մϴ�. �����մϴ�.\n");
		System.out.printf("\n");
		System.out.printf("��� �����Ͻðڽ��ϱ�? 1. ���ο� �ֹ� 2. ���α׷� ����\n");
		orderItem.newOrderButton = sc.nextInt();
		System.out.printf("\n");
		orderItem.orderCount = 0; // �ֹ��� Ƽ�� �� �� �ʱ�ȭ
		orderItem.finalFee = 0; // �ֹ��� Ƽ�� ���� �ʱ�ȭ
	}
	
	public void StartSystem() {
		do {
			continueButtonPrintOut();
		} while (orderItem.newOrderButton == StaticValue.NEW_ORDER_BUTTON);
		System.out.println("Ƽ�� ���Ÿ� ������ �����մϴ�. �����մϴ�.\n");
	}
	
}