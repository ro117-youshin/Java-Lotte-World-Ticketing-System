package lotteworldticketing;

public class OrderData {
	private int ticketType;
	private int ticketTimeType;
	private String IDNumber;
	private int gender;
	private int age;
	private int numberOfTicket;
	private int basicFeeType;
	private int advantageType;
	private int orderCount;
	private int basicFee;
	private int totalFee;
	private int continueButton;
	private int newOrderButton;
	private String orderDate;
	private String menu = "��¥" + "," + "�̿��" + "," + "�ɼ�" + "," + "����" + "," + "���" + "," + "����" + "," + "������\n";

	public int getTicketType() {
		return ticketType;
	}

	public String getTicketTypeToString() {
		if (ticketType == ConstantNumber.TICKET_TYPE_ONE) {
			return "�����̿��\t";
		} else if (ticketType == ConstantNumber.TICKET_TYPE_TWO) {
			return "��ũ�̿��\t";
		} else {
			return "��������";
		}
	}

	public void setTicketType(int ticketType) {
		this.ticketType = ticketType;
	}

	public int getTicketTimeType() {
		return ticketTimeType;
	}

	public String getTicketTimeTypeToString() {
		if (ticketTimeType == ConstantNumber.TICKET_TIME_TYPE_ONE) {
			return "1Day\t";
		} else if (ticketTimeType == ConstantNumber.TICKET_TIME_TYPE_TWO) {
			return "After4\t";
		} else {
			return "��������";
		}
	}

	public void setTicketTimeType(int ticketTimeType) {
		this.ticketTimeType = ticketTimeType;
	}

	public String getIDNumber() {
		return IDNumber;
	}

	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNumberOfTicket() {
		return numberOfTicket;
	}

	public void setNumberOfTicket(int numberOfTicket) {
		this.numberOfTicket = numberOfTicket;
	}

	public int getBasicFeeType() {
		return basicFeeType;
	}

	public String getBasicFeeTypeToString() {
		if (basicFeeType == ConstantNumber.BASIC_FEE_TYPE_ZERO) {
			return "�\t";
		} else if (basicFeeType == ConstantNumber.BASIC_FEE_TYPE_ONE) {
			return "û�ҳ�\t";
		} else if (basicFeeType == ConstantNumber.BASIC_FEE_TYPE_TWO) {
			return "���\t";
		} else if (basicFeeType == ConstantNumber.BASIC_FEE_TYPE_THREE) {
			return "���̺�\t";
		} else {
			return "��������\t";
		}
	}
	
	public void setBasicFeeType(int basicFeeType) {
		this.basicFeeType = basicFeeType;
	}

	public int getAdvantageType() {
		return advantageType;
	}

	public String getAdvantageTypeToString() {
		if (advantageType == ConstantNumber.ADVANTAGE_TYPE_NOT_APPLICABLE) {
			return "������ ����";
		} else if (advantageType == ConstantNumber.ADVANTAGE_TYPE_DISABLED) {
			return "����� ���";
		} else if (advantageType == ConstantNumber.ADVANTAGE_TYPE_MAN_OF_MERIT) {
			return "���������� ���";
		} else if (advantageType == ConstantNumber.ADVANTAGE_TYPE_SOLDIER) {
			return "�ް��庴 ���";
		} else if (advantageType == ConstantNumber.ADVANTAGE_TYPE_PREGNANT) {
			return "�ӻ�� ���";
		} else if (advantageType == ConstantNumber.ADVATAGE_TYPE_CHILDREN_CARD) {
			return "�ٵ��� �ູī�� ���";
		} else {
			return "��������";
		}
	}
	
	public void setAdvantageType(int advantageType) {
		this.advantageType = advantageType;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public int getBasicFee() {
		return basicFee;
	}

	public void setBasicFee(int basicFee) {
		this.basicFee = basicFee;
	}

	public int getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(int totalFee) {
		this.totalFee = totalFee;
	}

	public int getContinueButton() {
		return continueButton;
	}

	public void setContinueButton(int continueButton) {
		this.continueButton = continueButton;
	}

	public int getNewOrderButton() {
		return newOrderButton;
	}

	public void setNewOrderButton(int newOrderButton) {
		this.newOrderButton = newOrderButton;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
}
