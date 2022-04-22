package lotteworldticketing;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Calculate {
	Scanner sc = new Scanner(System.in);
	
	public void calFinal (OrderData orderItem) {
		calId(orderItem);
		ageDiscount(orderItem);
		inputSpecialDiscount(orderItem);
	}
	
	public void calId(OrderData orderItem) {
		SimpleDateFormat todayDate = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		orderItem.setOrderDate(todayDate.format(cal.getTime()));
		int currentYear = cal.get(Calendar.YEAR);
		int currentMonth = cal.get(Calendar.MONDAY) + 1;
		int currentDay = cal.get(Calendar.DATE);

		int year = Integer.parseInt(orderItem.getIDNumber().substring(0, 2));
		int month = Integer.parseInt(orderItem.getIDNumber().substring(2, 4));
		int day = Integer.parseInt(orderItem.getIDNumber().substring(4, 6));
		
		if (orderItem.getGender() == 1 || orderItem.getGender() == 2) {
			if (currentMonth > month || currentMonth == month && currentDay < day) {
				orderItem.setAge(currentYear - (StaticValue.CENTURY_1900S + year));
			} else {
				orderItem.setAge(currentYear - (StaticValue.CENTURY_1900S + year) - 1);
			}
		}
		if (orderItem.getGender() == 3 || orderItem.getGender() == 4) {
			if (currentMonth > month || (currentMonth == month && currentDay < day)) {
				orderItem.setAge(currentYear - (StaticValue.CENTURY_2000S + year));
			} else {
				orderItem.setAge(currentYear - (StaticValue.CENTURY_2000S + year) - 1);
			}
		}
	}

	public void ageDiscount(OrderData orderItem) {
		if (orderItem.getTicketType() == StaticValue.TICKET_TYPE_ONE && orderItem.getTicketTimeType() == StaticValue.TICKET_TIME_TYPE_ONE) {
			if (orderItem.getAge() >= StaticValue.MIN_ADULT_AGE && orderItem.getAge() <= StaticValue.MAX_ADULT_AGE) {
				orderItem.setBasicFee(StaticValue.FULL_TICKET_1DAY_ADULT);
				orderItem.setBasicFeeType(StaticValue.BASIC_FEE_TYPE_ZERO);
			} else if (orderItem.getAge() >= StaticValue.MIN_TEEN_AGE && orderItem.getAge() <= StaticValue.MAX_TEEN_AGE) {
				orderItem.setBasicFee(StaticValue.FULL_TICKET_1DAY_TEEN);
				orderItem.setBasicFeeType(StaticValue.BASIC_FEE_TYPE_ONE);
			} else if ((orderItem.getAge() >= StaticValue.MIN_CHILD_AGE && orderItem.getAge() <= StaticValue.MAX_CHILD_AGE)
					|| orderItem.getAge() >= StaticValue.MAX_ADULT_AGE) {
				orderItem.setBasicFee(StaticValue.FULL_TICKET_1DAY_CHILD);
				orderItem.setBasicFeeType(StaticValue.BASIC_FEE_TYPE_TWO);
			}
		}
		// 종합이용권 After4
		if (orderItem.getTicketType() == StaticValue.TICKET_TYPE_ONE
				&& orderItem.getTicketTimeType() == StaticValue.TICKET_TIME_TYPE_TWO) {
			if (orderItem.getAge() >= StaticValue.MIN_ADULT_AGE && orderItem.getAge() <= StaticValue.MAX_ADULT_AGE) {
				orderItem.setBasicFee(StaticValue.FULL_TICKET_AFTER4_ADULT);
				orderItem.setBasicFeeType(StaticValue.BASIC_FEE_TYPE_ZERO);
			} else if (orderItem.getAge() >= StaticValue.MIN_TEEN_AGE && orderItem.getAge() <= StaticValue.MAX_TEEN_AGE) {
				orderItem.setBasicFee(StaticValue.FULL_TICKET_AFTER4_TEEN);
				orderItem.setBasicFeeType(StaticValue.BASIC_FEE_TYPE_ONE);
			} else if ((orderItem.getAge() >= StaticValue.MIN_CHILD_AGE && orderItem.getAge() <= StaticValue.MAX_CHILD_AGE)
					|| orderItem.getAge() >= StaticValue.MAX_ADULT_AGE) {
				orderItem.setBasicFee(StaticValue.FULL_TICKET_AFTER4_CHILD);
				orderItem.setBasicFeeType(StaticValue.BASIC_FEE_TYPE_TWO);
			}
		}
		// 파크이용권 1day
		if (orderItem.getTicketType() == StaticValue.TICKET_TYPE_TWO
				&& orderItem.getTicketTimeType() == StaticValue.TICKET_TIME_TYPE_ONE) {
			if (orderItem.getAge() >= StaticValue.MIN_ADULT_AGE && orderItem.getAge() <= StaticValue.MAX_ADULT_AGE) {
				orderItem.setBasicFee(StaticValue.PARK_TICKET_1DAY_ADULT);
				orderItem.setBasicFeeType(StaticValue.BASIC_FEE_TYPE_ZERO);
			} else if (orderItem.getAge() >= StaticValue.MIN_TEEN_AGE && orderItem.getAge() <= StaticValue.MAX_TEEN_AGE) {
				orderItem.setBasicFee(StaticValue.PARK_TICKET_1DAY_TEEN);
				orderItem.setBasicFeeType(StaticValue.BASIC_FEE_TYPE_ONE);
			} else if ((orderItem.getAge() >= StaticValue.MIN_CHILD_AGE && orderItem.getAge() <= StaticValue.MAX_CHILD_AGE)
					|| orderItem.getAge() >= StaticValue.MAX_ADULT_AGE) {
				orderItem.setBasicFee(StaticValue.PARK_TICKET_1DAY_CHILD);
				orderItem.setBasicFeeType(StaticValue.BASIC_FEE_TYPE_TWO);
			}
		}
		// 종합이용권 After4
		if (orderItem.getTicketType() == StaticValue.TICKET_TYPE_TWO
				&& orderItem.getTicketTimeType() == StaticValue.TICKET_TIME_TYPE_TWO) {
			if (orderItem.getAge() >= StaticValue.MIN_ADULT_AGE && orderItem.getAge() <= StaticValue.MAX_ADULT_AGE) {
				orderItem.setBasicFee(StaticValue.PARK_TICKET_AFTER4_ADULT);
				orderItem.setBasicFeeType(StaticValue.BASIC_FEE_TYPE_ZERO);
			} else if (orderItem.getAge() >= StaticValue.MIN_TEEN_AGE && orderItem.getAge() <= StaticValue.MAX_TEEN_AGE) {
				orderItem.setBasicFee(StaticValue.PARK_TICKET_AFTER4_TEEN);
				orderItem.setBasicFeeType(StaticValue.BASIC_FEE_TYPE_ONE);
			} else if ((orderItem.getAge() >= StaticValue.MIN_CHILD_AGE && orderItem.getAge() <= StaticValue.MAX_CHILD_AGE)
					|| orderItem.getAge() >= StaticValue.MAX_ADULT_AGE) {
				orderItem.setBasicFee(StaticValue.PARK_TICKET_AFTER4_CHILD);
				orderItem.setBasicFeeType(StaticValue.BASIC_FEE_TYPE_TWO);
			}
		}
		// 베이비
		if (orderItem.getAge() < StaticValue.MIN_BABY_AGE) {
			orderItem.setBasicFee(StaticValue.BABY_NO_CHARGE);
			orderItem.setBasicFeeType(StaticValue.BASIC_FEE_TYPE_THREE);
		}
		if (orderItem.getAge() >= StaticValue.MIN_BABY_AGE && orderItem.getAge() < StaticValue.MAX_BABY_AGE
				&& orderItem.getNumberOfTicket() >= 10) {
			orderItem.setBasicFee(StaticValue.BABY);
			orderItem.setBasicFeeType(StaticValue.BASIC_FEE_TYPE_THREE);
		} else if (orderItem.getAge() >= StaticValue.MIN_BABY_AGE && orderItem.getAge() < StaticValue.MAX_BABY_AGE
				&& orderItem.getNumberOfTicket() < 10) {
			orderItem.setBasicFee(StaticValue.BABY_NO_CHARGE);
			orderItem.setBasicFeeType(StaticValue.BASIC_FEE_TYPE_THREE);
		}
	}

	public void inputSpecialDiscount(OrderData orderItem) {

		// 0. 우대조건 없음
		if (orderItem.getAdvantageType() == StaticValue.ADVANTAGE_TYPE_NOT_APPLICABLE) {
			orderItem.setTotalFee(orderItem.getBasicFee() * orderItem.getNumberOfTicket());
		}
		// 1.장애인 우대
		if (orderItem.getAdvantageType() == StaticValue.ADVANTAGE_TYPE_DISABLED) {
			if (orderItem.getNumberOfTicket() == 1) {
				orderItem.setTotalFee((int) (orderItem.getBasicFee() * StaticValue.DISCOUNT_RATE_DISABLED));
			} else if (orderItem.getNumberOfTicket() == 2) {
				orderItem.setTotalFee((int) (orderItem.getBasicFee() * StaticValue.DISCOUNT_RATE_DISABLED * 2));
			} else {
				orderItem.setTotalFee((int) ((orderItem.getBasicFee() * StaticValue.DISCOUNT_RATE_DISABLED * 2)
						+ orderItem.getBasicFee() * (orderItem.getNumberOfTicket() - 2)));
			}
		}
		// 2. 국가유공자 우대
		if (orderItem.getAdvantageType() == StaticValue.ADVANTAGE_TYPE_MAN_OF_MERIT) {
			if (orderItem.getNumberOfTicket() == 1) {
				orderItem.setTotalFee((int) (orderItem.getBasicFee() * StaticValue.DISCOUNT_RATE_MAN_OF_MERIT));
			} else if (orderItem.getNumberOfTicket() == 2) {
				orderItem.setTotalFee((int) (orderItem.getBasicFee() * StaticValue.DISCOUNT_RATE_MAN_OF_MERIT * 2));
			} else {
				orderItem.setTotalFee((int) ((orderItem.getBasicFee() * StaticValue.DISCOUNT_RATE_MAN_OF_MERIT * 2)
						+ orderItem.getBasicFee() * (orderItem.getNumberOfTicket() - 2)));
			}
		}
		// 3. 휴가장병 우대
		if (orderItem.getAdvantageType() == StaticValue.ADVANTAGE_TYPE_SOLDIER) {
			if (orderItem.getNumberOfTicket() == 1) {
				orderItem.setTotalFee((int) (orderItem.getBasicFee() * StaticValue.DISCOUNT_RATE_SOLDIER));
			} else if (orderItem.getNumberOfTicket() == 2) {
				orderItem.setTotalFee((int) (orderItem.getBasicFee() * StaticValue.DISCOUNT_RATE_SOLDIER * 2));
			} else {
				orderItem.setTotalFee((int) ((orderItem.getBasicFee() * StaticValue.DISCOUNT_RATE_SOLDIER * 2)
						+ orderItem.getBasicFee() * (orderItem.getNumberOfTicket() - 2)));
			}
		}
		// 4. 임산부 우대
		if (orderItem.getGender() == 2 || orderItem.getGender() == 4) {
			if (orderItem.getAdvantageType() == StaticValue.ADVANTAGE_TYPE_PREGNANT) {
				if (orderItem.getNumberOfTicket() == 1) {
					orderItem.setTotalFee((int) (orderItem.getBasicFee() * StaticValue.DISCOUNT_RATE_PREGNANT));
				} else {
					orderItem.setTotalFee((int) ((orderItem.getBasicFee() * StaticValue.DISCOUNT_RATE_PREGNANT)
							+ orderItem.getBasicFee() * (orderItem.getNumberOfTicket() - 1)));
				}
			}
		}
		// 5. 다둥이 우대
		if (orderItem.getAdvantageType() == StaticValue.ADVATAGE_TYPE_CHILDREN_CARD) {
			if (orderItem.getNumberOfTicket() == 1) {
				orderItem.setTotalFee((int) (orderItem.getBasicFee() * StaticValue.DISCOUNT_RATE_CHILDREN_CARD));
			} else {
				orderItem.setTotalFee((int) ((orderItem.getBasicFee() * StaticValue.DISCOUNT_RATE_CHILDREN_CARD)
						+ orderItem.getBasicFee() * (orderItem.getNumberOfTicket() - 1)));
			}
		}
		
	}
	
	public int totalTicketFee (ArrayList<OrderData> orderList) {
		int finalFee = 0;
		for (int index = 0; index < orderList.size(); index++) {
			finalFee += orderList.get(index).getTotalFee();
		}
		return finalFee;
	}
	
}
