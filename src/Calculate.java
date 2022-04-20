package lotteworldticketing;

import java.util.Calendar;
import java.util.Scanner;

public class Calculate {

//	InputSystem inputTicketSystem = new InputSystem();
	Scanner sc = new Scanner(System.in);
	
	public void calFinal (OrderData orderItem) {
		calId(orderItem);
		ageDiscount(orderItem);
		inputSpecialDiscount(orderItem);
	}
	
	public void calId(OrderData orderItem) {

		Calendar cal = Calendar.getInstance();
		int currentYear = cal.get(Calendar.YEAR);
		int currentMonth = cal.get(Calendar.MONDAY) + 1;
		int currentDay = cal.get(Calendar.DATE);

		int year = Integer.parseInt(orderItem.IDNumber.substring(0, 2));
		int month = Integer.parseInt(orderItem.IDNumber.substring(2, 4));
		int day = Integer.parseInt(orderItem.IDNumber.substring(4, 6));
		
		if (orderItem.gender == 1 || orderItem.gender == 2) {
			if (currentMonth > month || currentMonth == month && currentDay < day) {
				orderItem.age = currentYear - (StaticValue.CENTURY_1900S + year);
			} else {
				orderItem.age = currentYear - (StaticValue.CENTURY_1900S + year) - 1;
			}
		}
		if (orderItem.gender == 3 || orderItem.gender == 4) {
			if (currentMonth > month || (currentMonth == month && currentDay < day)) {
				orderItem.age = currentYear - (StaticValue.CENTURY_2000S + year);
			} else {
				orderItem.age = currentYear - (StaticValue.CENTURY_2000S + year) - 1;
			}
		}
	}

	public void ageDiscount(OrderData orderItem) {
		if (orderItem.ticketType == StaticValue.TICKET_TYPE_ONE && orderItem.ticketTimeType == StaticValue.TICKET_TIME_TYPE_ONE) {
			if (orderItem.age >= StaticValue.MIN_ADULT_AGE && orderItem.age <= StaticValue.MAX_ADULT_AGE) {
				orderItem.basicFee = StaticValue.FULL_TICKET_1DAY_ADULT;
				orderItem.basicFeeType = StaticValue.BASIC_FEE_TYPE_ZERO;
			} else if (orderItem.age >= StaticValue.MIN_TEEN_AGE && orderItem.age <= StaticValue.MAX_TEEN_AGE) {
				orderItem.basicFee = StaticValue.FULL_TICKET_1DAY_TEEN;
				orderItem.basicFeeType = StaticValue.BASIC_FEE_TYPE_ONE;
			} else if ((orderItem.age >= StaticValue.MIN_CHILD_AGE && orderItem.age <= StaticValue.MAX_CHILD_AGE)
					|| orderItem.age >= StaticValue.MAX_ADULT_AGE) {
				orderItem.basicFee = StaticValue.FULL_TICKET_1DAY_CHILD;
				orderItem.basicFeeType = StaticValue.BASIC_FEE_TYPE_TWO;
			}
		}
		// 종합이용권 After4
		if (orderItem.ticketType == StaticValue.TICKET_TYPE_ONE
				&& orderItem.ticketTimeType == StaticValue.TICKET_TIME_TYPE_TWO) {
			if (orderItem.age >= StaticValue.MIN_ADULT_AGE && orderItem.age <= StaticValue.MAX_ADULT_AGE) {
				orderItem.basicFee = StaticValue.FULL_TICKET_AFTER4_ADULT;
				orderItem.basicFeeType = StaticValue.BASIC_FEE_TYPE_ZERO;
			} else if (orderItem.age >= StaticValue.MIN_TEEN_AGE && orderItem.age <= StaticValue.MAX_TEEN_AGE) {
				orderItem.basicFee = StaticValue.FULL_TICKET_AFTER4_TEEN;
				orderItem.basicFeeType = StaticValue.BASIC_FEE_TYPE_ONE;
			} else if ((orderItem.age >= StaticValue.MIN_CHILD_AGE && orderItem.age <= StaticValue.MAX_CHILD_AGE)
					|| orderItem.age >= StaticValue.MAX_ADULT_AGE) {
				orderItem.basicFee = StaticValue.FULL_TICKET_AFTER4_CHILD;
				orderItem.basicFeeType = StaticValue.BASIC_FEE_TYPE_TWO;
			}
		}
		// 파크이용권 1day
		if (orderItem.ticketType == StaticValue.TICKET_TYPE_TWO
				&& orderItem.ticketTimeType == StaticValue.TICKET_TIME_TYPE_ONE) {
			if (orderItem.age >= StaticValue.MIN_ADULT_AGE && orderItem.age <= StaticValue.MAX_ADULT_AGE) {
				orderItem.basicFee = StaticValue.PARK_TICKET_1DAY_ADULT;
				orderItem.basicFeeType = StaticValue.BASIC_FEE_TYPE_ZERO;
			} else if (orderItem.age >= StaticValue.MIN_TEEN_AGE && orderItem.age <= StaticValue.MAX_TEEN_AGE) {
				orderItem.basicFee = StaticValue.PARK_TICKET_1DAY_TEEN;
				orderItem.basicFeeType = StaticValue.BASIC_FEE_TYPE_ONE;
			} else if ((orderItem.age >= StaticValue.MIN_CHILD_AGE && orderItem.age <= StaticValue.MAX_CHILD_AGE)
					|| orderItem.age >= StaticValue.MAX_ADULT_AGE) {
				orderItem.basicFee = StaticValue.PARK_TICKET_1DAY_CHILD;
				orderItem.basicFeeType = StaticValue.BASIC_FEE_TYPE_TWO;
			}
		}
		// 종합이용권 After4
		if (orderItem.ticketType == StaticValue.TICKET_TYPE_TWO
				&& orderItem.ticketTimeType == StaticValue.TICKET_TIME_TYPE_TWO) {
			if (orderItem.age >= StaticValue.MIN_ADULT_AGE && orderItem.age <= StaticValue.MAX_ADULT_AGE) {
				orderItem.basicFee = StaticValue.PARK_TICKET_AFTER4_ADULT;
				orderItem.basicFeeType = StaticValue.BASIC_FEE_TYPE_ZERO;
			} else if (orderItem.age >= StaticValue.MIN_TEEN_AGE && orderItem.age <= StaticValue.MAX_TEEN_AGE) {
				orderItem.basicFee = StaticValue.PARK_TICKET_AFTER4_TEEN;
				orderItem.basicFeeType = StaticValue.BASIC_FEE_TYPE_ONE;
			} else if ((orderItem.age >= StaticValue.MIN_CHILD_AGE && orderItem.age <= StaticValue.MAX_CHILD_AGE)
					|| orderItem.age >= StaticValue.MAX_ADULT_AGE) {
				orderItem.basicFee = StaticValue.PARK_TICKET_AFTER4_CHILD;
				orderItem.basicFeeType = StaticValue.BASIC_FEE_TYPE_TWO;
			}
		}
		// 베이비
		if (orderItem.age < StaticValue.MIN_BABY_AGE) {
			orderItem.basicFee = StaticValue.BABY_NO_CHARGE;
			orderItem.basicFeeType = StaticValue.BASIC_FEE_TYPE_THREE;
		}
		if (orderItem.age >= StaticValue.MIN_BABY_AGE && orderItem.age < StaticValue.MAX_BABY_AGE
				&& orderItem.numberOfTicket >= 10) {
			orderItem.basicFee = StaticValue.BABY;
			orderItem.basicFeeType = StaticValue.BASIC_FEE_TYPE_THREE;
		} else if (orderItem.age >= StaticValue.MIN_BABY_AGE && orderItem.age < StaticValue.MAX_BABY_AGE
				&& orderItem.numberOfTicket < 10) {
			orderItem.basicFee = StaticValue.BABY_NO_CHARGE;
			orderItem.basicFeeType = StaticValue.BASIC_FEE_TYPE_THREE;
		}
	}

	public void inputSpecialDiscount(OrderData orderItem) {

		// 0. 우대조건 없음
		if (orderItem.advantageType == StaticValue.ADVANTAGE_TYPE_NOT_APPLICABLE) {
			orderItem.totalFee = orderItem.basicFee * orderItem.numberOfTicket;
		}
		// 1.장애인 우대
		if (orderItem.advantageType == StaticValue.ADVANTAGE_TYPE_DISABLED) {
			if (orderItem.numberOfTicket == 1) {
				orderItem.totalFee = (int) (orderItem.basicFee * StaticValue.DISCOUNT_RATE_DISABLED);
			} else if (orderItem.numberOfTicket == 2) {
				orderItem.totalFee = (int) (orderItem.basicFee * StaticValue.DISCOUNT_RATE_DISABLED * 2);
			} else {
				orderItem.totalFee = (int) ((orderItem.basicFee * StaticValue.DISCOUNT_RATE_DISABLED * 2)
						+ orderItem.basicFee * (orderItem.numberOfTicket - 2));
			}
		}
		// 2. 국가유공자 우대
		if (orderItem.advantageType == StaticValue.ADVANTAGE_TYPE_MAN_OF_MERIT) {
			if (orderItem.numberOfTicket == 1) {
				orderItem.totalFee = (int) (orderItem.basicFee * StaticValue.DISCOUNT_RATE_MAN_OF_MERIT);
			} else if (orderItem.numberOfTicket == 2) {
				orderItem.totalFee = (int) (orderItem.basicFee * StaticValue.DISCOUNT_RATE_MAN_OF_MERIT * 2);
			} else {
				orderItem.totalFee = (int) ((orderItem.basicFee * StaticValue.DISCOUNT_RATE_MAN_OF_MERIT * 2)
						+ orderItem.basicFee * (orderItem.numberOfTicket - 2));
			}
		}
		// 3. 휴가장병 우대
		if (orderItem.advantageType == StaticValue.ADVANTAGE_TYPE_SOLDIER) {
			if (orderItem.numberOfTicket == 1) {
				orderItem.totalFee = (int) (orderItem.basicFee * StaticValue.DISCOUNT_RATE_SOLDIER);
			} else if (orderItem.numberOfTicket == 2) {
				orderItem.totalFee = (int) (orderItem.basicFee * StaticValue.DISCOUNT_RATE_SOLDIER * 2);
			} else {
				orderItem.totalFee = (int) ((orderItem.basicFee * StaticValue.DISCOUNT_RATE_SOLDIER * 2)
						+ orderItem.basicFee * (orderItem.numberOfTicket - 2));
			}
		}
		// 4. 임산부 우대
		if (orderItem.gender == 2 || orderItem.gender == 4) {
			if (orderItem.advantageType == StaticValue.ADVANTAGE_TYPE_PREGNANT) {
				if (orderItem.numberOfTicket == 1) {
					orderItem.totalFee = (int) (orderItem.basicFee * StaticValue.DISCOUNT_RATE_PREGNANT);
				} else {
					orderItem.totalFee = (int) ((orderItem.basicFee * StaticValue.DISCOUNT_RATE_PREGNANT)
							+ orderItem.basicFee * (orderItem.numberOfTicket - 1));
				}
			}
		}
		// 5. 다둥이 우대
		if (orderItem.advantageType == StaticValue.ADVATAGE_TYPE_CHILDREN_CARD) {
			if (orderItem.numberOfTicket == 1) {
				orderItem.totalFee = (int) (orderItem.basicFee * StaticValue.DISCOUNT_RATE_CHILDREN_CARD);
			} else {
				orderItem.totalFee = (int) ((orderItem.basicFee * StaticValue.DISCOUNT_RATE_CHILDREN_CARD)
						+ orderItem.basicFee * (orderItem.numberOfTicket - 1));
			}
		}

	}
}
