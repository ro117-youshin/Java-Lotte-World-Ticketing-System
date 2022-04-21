package lotteworldticketing;

import java.util.Scanner;

public class InputSystem {

	Scanner sc = new Scanner(System.in);

	// �Է� �޼ҵ� 
	public void inputInformation(OrderData orderItem) {
		// �����̿�� / ��ũ�̿��
		inputTicketType(orderItem);
		// 1Day / After4
		inputTicketTimeType(orderItem);
		// �ֹι�ȣ ���ڸ� �Է�
		inputTheFirstId(orderItem);
		// �ֹι�ȣ ���ڸ� �Է�
		inputTheSecondId(orderItem);
		// �� �� �Է�
		inputNumberOfTicket(orderItem);
		// ������ ����(��� ��� ����)
		inputSpecialDiscount(orderItem);
	}

	public void inputTicketType(OrderData orderItem) {
		do {
			System.out.printf("�����Ͻ� �̿���� �����ϼ���.\n");
			System.out.printf("1. �����̿��(�̿����: �Ե����� + �μӹڹ���)\n2. ��ũ�̿��(�̿����: �Ե�����)\n");
			orderItem.setTicketType(sc.nextInt());
		} while (!(orderItem.getTicketType() == StaticValue.TICKET_TYPE_ONE
				|| orderItem.getTicketType() == StaticValue.TICKET_TYPE_TWO));
	}

	public void inputTicketTimeType(OrderData orderItem) {
		do {
			System.out.printf("�����Ͻ� �̿���� �ɼ��� �������ּ���.\n");
			System.out.printf("1. 1Day\n2. After4(���� 4�ú��� ���尡��)\n");
			orderItem.setTicketTimeType(sc.nextInt());
		} while (!(orderItem.getTicketTimeType() == StaticValue.TICKET_TIME_TYPE_ONE
				|| orderItem.getTicketTimeType() == StaticValue.TICKET_TIME_TYPE_TWO));
	}

	public void inputTheFirstId(OrderData orderItem) {

		System.out.printf("\n�ֹε�Ϲ�ȣ�� �� 6�ڸ��� �Է��ϼ���. ex) 930820\n");
		orderItem.setIDNumber(sc.next());
	}
	
	public void inputTheSecondId(OrderData orderItem) {
		do {
			System.out.printf("�ֹε�Ϲ�ȣ ���ڸ� ù° �ڸ��� �Է��ϼ���.\n");
			orderItem.setGender(sc.nextInt());
		} while (!(orderItem.getGender() == 1 || orderItem.getGender() == 2 || orderItem.getGender() == 3 || orderItem.getGender() == 4));
	}

	public void inputNumberOfTicket(OrderData orderItem) {
		do {
			System.out.printf("\n������ �ֹ��Ͻðڽ��ϱ�?(�ִ�10��)\n");
			orderItem.setNumberOfTicket(sc.nextInt());
		} while (!(orderItem.getNumberOfTicket() <= 10 && orderItem.getNumberOfTicket() >= 1));
	}

	public void inputSpecialDiscount(OrderData orderItem) {
		do {
			// ������ ����(��� ��� ����)
			System.out.printf("\n�������� �����ϼ���.\n(���ɿ� ���� ��������� �ڵ� ����˴ϴ�.)\n\n");
			System.out.printf("0. ������� ����\n");
			System.out.printf("1. ����� ���\n");
			System.out.printf("2. ���������� ���\n");
			System.out.printf("3. �ް��庴 ���\n");
			System.out.printf("4. �ӻ�� ���\n");
			System.out.printf("5. �ٵ��� �ູī�� ���\n");
			orderItem.setAdvantageType(sc.nextInt());
		} while (!(orderItem.getAdvantageType() == StaticValue.ADVANTAGE_TYPE_NOT_APPLICABLE
				|| orderItem.getAdvantageType() == StaticValue.ADVANTAGE_TYPE_DISABLED
				|| orderItem.getAdvantageType() == StaticValue.ADVANTAGE_TYPE_MAN_OF_MERIT
				|| orderItem.getAdvantageType() == StaticValue.ADVANTAGE_TYPE_SOLDIER
				|| orderItem.getAdvantageType() == StaticValue.ADVANTAGE_TYPE_PREGNANT
				|| orderItem.getAdvantageType() == StaticValue.ADVATAGE_TYPE_CHILDREN_CARD));
	}

}