package lotteworldticketing;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Calculator {
	// ��� ��� �޼ҵ�
	public void calFinal (OrderData orderItem) {
		calId(orderItem);
		ageDiscount(orderItem);
		inputSpecialDiscount(orderItem);
	}
	// �ֹε�Ϲ�ȣ �� 6�ڸ��� String���� �޾Ƽ� �ڸ���, �� 1�ڸ��� int������ �޴´�.
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
				orderItem.setAge(currentYear - (ConstantNumber.CENTURY_1900S + year));
			} else {
				orderItem.setAge(currentYear - (ConstantNumber.CENTURY_1900S + year) - 1);
			}
		}
		if (orderItem.getGender() == 3 || orderItem.getGender() == 4) {
			if (currentMonth > month || (currentMonth == month && currentDay < day)) {
				orderItem.setAge(currentYear - (ConstantNumber.CENTURY_2000S + year));
			} else {
				orderItem.setAge(currentYear - (ConstantNumber.CENTURY_2000S + year) - 1);
			}
		}
	}

	public void ageDiscount(OrderData orderItem) {
		// �����̿�� 1Day, ���̸� ����Ű�� ����� �������� ���� ������ ���ǹ�
		if (orderItem.getTicketType() == ConstantNumber.TICKET_TYPE_ONE && orderItem.getTicketTimeType() == ConstantNumber.TICKET_TIME_TYPE_ONE) {
			if (orderItem.getAge() >= ConstantNumber.MIN_ADULT_AGE && orderItem.getAge() <= ConstantNumber.MAX_ADULT_AGE) {
				orderItem.setBasicFee(ConstantNumber.FULL_TICKET_1DAY_ADULT);
				orderItem.setBasicFeeType(ConstantNumber.BASIC_FEE_TYPE_ZERO);
			} else if (orderItem.getAge() >= ConstantNumber.MIN_TEEN_AGE && orderItem.getAge() <= ConstantNumber.MAX_TEEN_AGE) {
				orderItem.setBasicFee(ConstantNumber.FULL_TICKET_1DAY_TEEN);
				orderItem.setBasicFeeType(ConstantNumber.BASIC_FEE_TYPE_ONE);
			} else if ((orderItem.getAge() >= ConstantNumber.MIN_CHILD_AGE && orderItem.getAge() <= ConstantNumber.MAX_CHILD_AGE)
					|| orderItem.getAge() >= ConstantNumber.MAX_ADULT_AGE) {
				orderItem.setBasicFee(ConstantNumber.FULL_TICKET_1DAY_CHILD);
				orderItem.setBasicFeeType(ConstantNumber.BASIC_FEE_TYPE_TWO);
			}
		}
		// �����̿�� After4
		if (orderItem.getTicketType() == ConstantNumber.TICKET_TYPE_ONE
				&& orderItem.getTicketTimeType() == ConstantNumber.TICKET_TIME_TYPE_TWO) {
			if (orderItem.getAge() >= ConstantNumber.MIN_ADULT_AGE && orderItem.getAge() <= ConstantNumber.MAX_ADULT_AGE) {
				orderItem.setBasicFee(ConstantNumber.FULL_TICKET_AFTER4_ADULT);
				orderItem.setBasicFeeType(ConstantNumber.BASIC_FEE_TYPE_ZERO);
			} else if (orderItem.getAge() >= ConstantNumber.MIN_TEEN_AGE && orderItem.getAge() <= ConstantNumber.MAX_TEEN_AGE) {
				orderItem.setBasicFee(ConstantNumber.FULL_TICKET_AFTER4_TEEN);
				orderItem.setBasicFeeType(ConstantNumber.BASIC_FEE_TYPE_ONE);
			} else if ((orderItem.getAge() >= ConstantNumber.MIN_CHILD_AGE && orderItem.getAge() <= ConstantNumber.MAX_CHILD_AGE)
					|| orderItem.getAge() >= ConstantNumber.MAX_ADULT_AGE) {
				orderItem.setBasicFee(ConstantNumber.FULL_TICKET_AFTER4_CHILD);
				orderItem.setBasicFeeType(ConstantNumber.BASIC_FEE_TYPE_TWO);
			}
		}
		// ��ũ�̿�� 1Day
		if (orderItem.getTicketType() == ConstantNumber.TICKET_TYPE_TWO
				&& orderItem.getTicketTimeType() == ConstantNumber.TICKET_TIME_TYPE_ONE) {
			if (orderItem.getAge() >= ConstantNumber.MIN_ADULT_AGE && orderItem.getAge() <= ConstantNumber.MAX_ADULT_AGE) {
				orderItem.setBasicFee(ConstantNumber.PARK_TICKET_1DAY_ADULT);
				orderItem.setBasicFeeType(ConstantNumber.BASIC_FEE_TYPE_ZERO);
			} else if (orderItem.getAge() >= ConstantNumber.MIN_TEEN_AGE && orderItem.getAge() <= ConstantNumber.MAX_TEEN_AGE) {
				orderItem.setBasicFee(ConstantNumber.PARK_TICKET_1DAY_TEEN);
				orderItem.setBasicFeeType(ConstantNumber.BASIC_FEE_TYPE_ONE);
			} else if ((orderItem.getAge() >= ConstantNumber.MIN_CHILD_AGE && orderItem.getAge() <= ConstantNumber.MAX_CHILD_AGE)
					|| orderItem.getAge() >= ConstantNumber.MAX_ADULT_AGE) {
				orderItem.setBasicFee(ConstantNumber.PARK_TICKET_1DAY_CHILD);
				orderItem.setBasicFeeType(ConstantNumber.BASIC_FEE_TYPE_TWO);
			}
		}
		// ��ũ�̿�� After4
		if (orderItem.getTicketType() == ConstantNumber.TICKET_TYPE_TWO
				&& orderItem.getTicketTimeType() == ConstantNumber.TICKET_TIME_TYPE_TWO) {
			if (orderItem.getAge() >= ConstantNumber.MIN_ADULT_AGE && orderItem.getAge() <= ConstantNumber.MAX_ADULT_AGE) {
				orderItem.setBasicFee(ConstantNumber.PARK_TICKET_AFTER4_ADULT);
				orderItem.setBasicFeeType(ConstantNumber.BASIC_FEE_TYPE_ZERO);
			} else if (orderItem.getAge() >= ConstantNumber.MIN_TEEN_AGE && orderItem.getAge() <= ConstantNumber.MAX_TEEN_AGE) {
				orderItem.setBasicFee(ConstantNumber.PARK_TICKET_AFTER4_TEEN);
				orderItem.setBasicFeeType(ConstantNumber.BASIC_FEE_TYPE_ONE);
			} else if ((orderItem.getAge() >= ConstantNumber.MIN_CHILD_AGE && orderItem.getAge() <= ConstantNumber.MAX_CHILD_AGE)
					|| orderItem.getAge() >= ConstantNumber.MAX_ADULT_AGE) {
				orderItem.setBasicFee(ConstantNumber.PARK_TICKET_AFTER4_CHILD);
				orderItem.setBasicFeeType(ConstantNumber.BASIC_FEE_TYPE_TWO);
			}
		}
		// ���̺�
		if (orderItem.getAge() < ConstantNumber.MIN_BABY_AGE) {
			orderItem.setBasicFee(ConstantNumber.BABY_NO_CHARGE);
			orderItem.setBasicFeeType(ConstantNumber.BASIC_FEE_TYPE_THREE);
		}
		if (orderItem.getAge() >= ConstantNumber.MIN_BABY_AGE && orderItem.getAge() < ConstantNumber.MAX_BABY_AGE
				&& orderItem.getNumberOfTicket() >= 10) {
			orderItem.setBasicFee(ConstantNumber.BABY);
			orderItem.setBasicFeeType(ConstantNumber.BASIC_FEE_TYPE_THREE);
		} else if (orderItem.getAge() >= ConstantNumber.MIN_BABY_AGE && orderItem.getAge() < ConstantNumber.MAX_BABY_AGE
				&& orderItem.getNumberOfTicket() < 10) {
			orderItem.setBasicFee(ConstantNumber.BABY_NO_CHARGE);
			orderItem.setBasicFeeType(ConstantNumber.BASIC_FEE_TYPE_THREE);
		}
	}
	// ������ (������ �� ��� �Բ� �߱��� 1���� Ƽ���� �ڵ����� �����ϰ�) 
	public void inputSpecialDiscount(OrderData orderItem) {

		// 0. ������� ����
		if (orderItem.getAdvantageType() == ConstantNumber.ADVANTAGE_TYPE_NOT_APPLICABLE) {
			orderItem.setTotalFee(orderItem.getBasicFee() * orderItem.getNumberOfTicket());
		}
		// 1.����� ���
		if (orderItem.getAdvantageType() == ConstantNumber.ADVANTAGE_TYPE_DISABLED) {
			if (orderItem.getNumberOfTicket() == 1) {
				orderItem.setTotalFee((int) (orderItem.getBasicFee() * ConstantNumber.DISCOUNT_RATE_DISABLED));
			} else if (orderItem.getNumberOfTicket() == 2) {
				orderItem.setTotalFee((int) (orderItem.getBasicFee() * ConstantNumber.DISCOUNT_RATE_DISABLED * 2));
			} else {
				orderItem.setTotalFee((int) ((orderItem.getBasicFee() * ConstantNumber.DISCOUNT_RATE_DISABLED * 2)
						+ orderItem.getBasicFee() * (orderItem.getNumberOfTicket() - 2)));
			}
		}
		// 2. ���������� ���
		if (orderItem.getAdvantageType() == ConstantNumber.ADVANTAGE_TYPE_MAN_OF_MERIT) {
			if (orderItem.getNumberOfTicket() == 1) {
				orderItem.setTotalFee((int) (orderItem.getBasicFee() * ConstantNumber.DISCOUNT_RATE_MAN_OF_MERIT));
			} else if (orderItem.getNumberOfTicket() == 2) {
				orderItem.setTotalFee((int) (orderItem.getBasicFee() * ConstantNumber.DISCOUNT_RATE_MAN_OF_MERIT * 2));
			} else {
				orderItem.setTotalFee((int) ((orderItem.getBasicFee() * ConstantNumber.DISCOUNT_RATE_MAN_OF_MERIT * 2)
						+ orderItem.getBasicFee() * (orderItem.getNumberOfTicket() - 2)));
			}
		}
		// 3. �ް��庴 ���
		if (orderItem.getAdvantageType() == ConstantNumber.ADVANTAGE_TYPE_SOLDIER) {
			if (orderItem.getNumberOfTicket() == 1) {
				orderItem.setTotalFee((int) (orderItem.getBasicFee() * ConstantNumber.DISCOUNT_RATE_SOLDIER));
			} else if (orderItem.getNumberOfTicket() == 2) {
				orderItem.setTotalFee((int) (orderItem.getBasicFee() * ConstantNumber.DISCOUNT_RATE_SOLDIER * 2));
			} else {
				orderItem.setTotalFee((int) ((orderItem.getBasicFee() * ConstantNumber.DISCOUNT_RATE_SOLDIER * 2)
						+ orderItem.getBasicFee() * (orderItem.getNumberOfTicket() - 2)));
			}
		}
		// 4. �ӻ�� ���
		if (orderItem.getGender() == 2 || orderItem.getGender() == 4) {
			if (orderItem.getAdvantageType() == ConstantNumber.ADVANTAGE_TYPE_PREGNANT) {
				if (orderItem.getNumberOfTicket() == 1) {
					orderItem.setTotalFee((int) (orderItem.getBasicFee() * ConstantNumber.DISCOUNT_RATE_PREGNANT));
				} else {
					orderItem.setTotalFee((int) ((orderItem.getBasicFee() * ConstantNumber.DISCOUNT_RATE_PREGNANT)
							+ orderItem.getBasicFee() * (orderItem.getNumberOfTicket() - 1)));
				}
			}
		}
		// 5. �ٵ��� ���
		if (orderItem.getAdvantageType() == ConstantNumber.ADVATAGE_TYPE_CHILDREN_CARD) {
			if (orderItem.getNumberOfTicket() == 1) {
				orderItem.setTotalFee((int) (orderItem.getBasicFee() * ConstantNumber.DISCOUNT_RATE_CHILDREN_CARD));
			} else {
				orderItem.setTotalFee((int) ((orderItem.getBasicFee() * ConstantNumber.DISCOUNT_RATE_CHILDREN_CARD)
						+ orderItem.getBasicFee() * (orderItem.getNumberOfTicket() - 1)));
			}
		}
		
	}
	// ����� �Ѿ�
	public int totalTicketFee (ArrayList<OrderData> orderList) {
		int finalFee = 0;
		for (int index = 0; index < orderList.size(); index++) {
			finalFee += orderList.get(index).getTotalFee();
		}
		return finalFee;
	}
	
}
