package lotteworldticketing;

import java.util.ArrayList;

public class WriteToCSV {
	OrderData orderItem = new OrderData();
	
	public String csvCount (ArrayList<OrderData> orderList) {
		
		String str = "";
		
		for (int index = 0; index < orderList.size(); index++) {
			str = str + writeToCSV(orderList, index);
		}
		
		return str;
	}

	public String writeToCSV (ArrayList<OrderData> orderList, int index) {
		
		String str = "";
		str = orderList.get(index).getOrderDate() + ",";
		
		if (orderList.get(index).getTicketType() == ConstantNumber.TICKET_TYPE_ONE) {
			str += "종합이용권" + ",";
		} else if (orderList.get(index).getTicketType() == ConstantNumber.TICKET_TYPE_TWO) {
			str += "파크이용권" + ",";
		}
		
		if (orderList.get(index).getTicketTimeType() == ConstantNumber.TICKET_TIME_TYPE_ONE) {
			str = str + "1Day" + ",";
		} else if (orderList.get(index).getTicketTimeType() == ConstantNumber.TICKET_TIME_TYPE_TWO) {
			str = str + "After4" + ",";
		}
		
		if (orderList.get(index).getBasicFeeType() == ConstantNumber.BASIC_FEE_TYPE_ZERO) {
			str = str + "어른" + ",";
		} else if (orderList.get(index).getBasicFeeType() == ConstantNumber.BASIC_FEE_TYPE_ONE) {
			str = str + "청소년" + ",";
		} else if (orderList.get(index).getBasicFeeType() == ConstantNumber.BASIC_FEE_TYPE_TWO) {
			str = str + "어린이" + ",";
		} else if (orderList.get(index).getBasicFeeType() == ConstantNumber.BASIC_FEE_TYPE_THREE) {
			str = str + "베이비" + ",";
		}
		
		str = str + orderList.get(index).getNumberOfTicket() + ",";
		
		str = str + orderList.get(index).getTotalFee() + ",";
		
		if (orderList.get(index).getAdvantageType() == ConstantNumber.ADVANTAGE_TYPE_NOT_APPLICABLE) {
			str = str +"*우대사항 없음" + "\n";
		} else if (orderList.get(index).getAdvantageType() == ConstantNumber.ADVANTAGE_TYPE_DISABLED) {
			str = str + "*장애인 우대" + "\n";
		} else if (orderList.get(index).getAdvantageType() == ConstantNumber.ADVANTAGE_TYPE_MAN_OF_MERIT) {
			str = str + "*국가유공자 우대" + "\n";
		} else if (orderList.get(index).getAdvantageType() == ConstantNumber.ADVANTAGE_TYPE_SOLDIER) {
			str = str + "*휴가장병 우대" + "\n";
		} else if (orderList.get(index).getAdvantageType() == ConstantNumber.ADVANTAGE_TYPE_PREGNANT) {
			str = str + "*임산부 우대" + "\n";
		} else if (orderList.get(index).getAdvantageType() == ConstantNumber.ADVATAGE_TYPE_CHILDREN_CARD) {
			str = str + "*다둥이 행복카드 우대" + "\n";
		}
		
		return str;
	}
	
}