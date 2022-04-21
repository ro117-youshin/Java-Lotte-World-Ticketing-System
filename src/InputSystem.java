package lotteworldticketing;

import java.util.Scanner;

public class InputSystem {

	Scanner sc = new Scanner(System.in);

	// 입력 메소드 
	public void inputInformation(OrderData orderItem) {
		// 종합이용권 / 파크이용권
		inputTicketType(orderItem);
		// 1Day / After4
		inputTicketTimeType(orderItem);
		// 주민번호 앞자리 입력
		inputTheFirstId(orderItem);
		// 주민번호 뒷자리 입력
		inputTheSecondId(orderItem);
		// 장 수 입력
		inputNumberOfTicket(orderItem);
		// 우대사항 할인(상시 우대 정보)
		inputSpecialDiscount(orderItem);
	}

	public void inputTicketType(OrderData orderItem) {
		do {
			System.out.printf("구매하실 이용권을 선택하세요.\n");
			System.out.printf("1. 종합이용권(이용범위: 롯데월드 + 민속박물관)\n2. 파크이용권(이용범위: 롯데월드)\n");
			orderItem.setTicketType(sc.nextInt());
		} while (!(orderItem.getTicketType() == StaticValue.TICKET_TYPE_ONE
				|| orderItem.getTicketType() == StaticValue.TICKET_TYPE_TWO));
	}

	public void inputTicketTimeType(OrderData orderItem) {
		do {
			System.out.printf("선택하신 이용권의 옵션을 선택해주세요.\n");
			System.out.printf("1. 1Day\n2. After4(오후 4시부터 입장가능)\n");
			orderItem.setTicketTimeType(sc.nextInt());
		} while (!(orderItem.getTicketTimeType() == StaticValue.TICKET_TIME_TYPE_ONE
				|| orderItem.getTicketTimeType() == StaticValue.TICKET_TIME_TYPE_TWO));
	}

	public void inputTheFirstId(OrderData orderItem) {

		System.out.printf("\n주민등록번호를 앞 6자리를 입력하세요. ex) 930820\n");
		orderItem.setIDNumber(sc.next());
	}
	
	public void inputTheSecondId(OrderData orderItem) {
		do {
			System.out.printf("주민등록번호 뒷자리 첫째 자리를 입력하세요.\n");
			orderItem.setGender(sc.nextInt());
		} while (!(orderItem.getGender() == 1 || orderItem.getGender() == 2 || orderItem.getGender() == 3 || orderItem.getGender() == 4));
	}

	public void inputNumberOfTicket(OrderData orderItem) {
		do {
			System.out.printf("\n몇장을 주문하시겠습니까?(최대10장)\n");
			orderItem.setNumberOfTicket(sc.nextInt());
		} while (!(orderItem.getNumberOfTicket() <= 10 && orderItem.getNumberOfTicket() >= 1));
	}

	public void inputSpecialDiscount(OrderData orderItem) {
		do {
			// 우대사항 할인(상시 우대 정보)
			System.out.printf("\n우대사항을 선택하세요.\n(연령에 따른 요금할인은 자동 적용됩니다.)\n\n");
			System.out.printf("0. 우대조건 없음\n");
			System.out.printf("1. 장애인 우대\n");
			System.out.printf("2. 국가유공자 우대\n");
			System.out.printf("3. 휴가장병 우대\n");
			System.out.printf("4. 임산부 우대\n");
			System.out.printf("5. 다둥이 행복카드 우대\n");
			orderItem.setAdvantageType(sc.nextInt());
		} while (!(orderItem.getAdvantageType() == StaticValue.ADVANTAGE_TYPE_NOT_APPLICABLE
				|| orderItem.getAdvantageType() == StaticValue.ADVANTAGE_TYPE_DISABLED
				|| orderItem.getAdvantageType() == StaticValue.ADVANTAGE_TYPE_MAN_OF_MERIT
				|| orderItem.getAdvantageType() == StaticValue.ADVANTAGE_TYPE_SOLDIER
				|| orderItem.getAdvantageType() == StaticValue.ADVANTAGE_TYPE_PREGNANT
				|| orderItem.getAdvantageType() == StaticValue.ADVATAGE_TYPE_CHILDREN_CARD));
	}

}