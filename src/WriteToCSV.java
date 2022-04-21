package lotteworldticketing;

import java.util.ArrayList;

public class WriteToCSV {
	OrderData orderItem = new OrderData();
	
	public String csvCount (ArrayList<OrderData> orderList, OrderData orderItem) {
		
		String str = "";
		
		for (int index = 0; index <= orderItem.getOrderCount() + 1; index++) {
			str = str + writeToCSV(orderList, index);
		}
		
		return str;
	}

	public String writeToCSV (ArrayList<OrderData> orderList, int index) {
		
		String str = "";
		
		if (orderList.get(index).getTicketType() == StaticValue.TICKET_TYPE_ONE) {
			str = "�����̿��" + ",";
		} else if (orderList.get(index).getTicketType() == StaticValue.TICKET_TYPE_TWO) {
			str = "��ũ�̿��" + ",";
		}
		
		if (orderList.get(index).getTicketTimeType() == StaticValue.TICKET_TIME_TYPE_ONE) {
			str = str + "1Day" + ",";
		} else if (orderList.get(index).getTicketTimeType() == StaticValue.TICKET_TIME_TYPE_TWO) {
			str = str + "After4" + ",";
		}
		
		if (orderList.get(index).getBasicFeeType() == StaticValue.BASIC_FEE_TYPE_ZERO) {
			str = str + "�" + ",";
		} else if (orderList.get(index).getBasicFeeType() == StaticValue.BASIC_FEE_TYPE_ONE) {
			str = str + "û�ҳ�" + ",";
		} else if (orderList.get(index).getBasicFeeType() == StaticValue.BASIC_FEE_TYPE_TWO) {
			str = str + "���" + ",";
		} else if (orderList.get(index).getBasicFeeType() == StaticValue.BASIC_FEE_TYPE_THREE) {
			str = str + "���̺�" + ",";
		}
		
		str = str + orderList.get(index).getNumberOfTicket() + ",";
		
		str = str + orderList.get(index).getTotalFee() + ",";
		
		if (orderList.get(index).getAdvantageType() == StaticValue.ADVANTAGE_TYPE_NOT_APPLICABLE) {
			str = str +"*������ ����" + "\n";
		} else if (orderList.get(index).getAdvantageType() == StaticValue.ADVANTAGE_TYPE_DISABLED) {
			str = str + "*����� ���" + "\n";
		} else if (orderList.get(index).getAdvantageType() == StaticValue.ADVANTAGE_TYPE_MAN_OF_MERIT) {
			str = str + "*���������� ���" + "\n";
		} else if (orderList.get(index).getAdvantageType() == StaticValue.ADVANTAGE_TYPE_SOLDIER) {
			str = str + "*�ް��庴 ���" + "\n";
		} else if (orderList.get(index).getAdvantageType() == StaticValue.ADVANTAGE_TYPE_PREGNANT) {
			str = str + "*�ӻ�� ���" + "\n";
		} else if (orderList.get(index).getAdvantageType() == StaticValue.ADVATAGE_TYPE_CHILDREN_CARD) {
			str = str + "*�ٵ��� �ູī�� ���" + "\n";
		}
		
		return str;
	}
	
}