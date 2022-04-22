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
	private String menu = "날짜" + "," + "이용권" + "," + "옵션" + "," + "연령" + "," + "장수" + "," + "가격" + "," + "우대사항\n";
	
	public int getTicketType() {
		return ticketType;
	}
	public void setTicketType(int ticketType) {
		this.ticketType = ticketType;
	}
	public int getTicketTimeType() {
		return ticketTimeType;
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
	public void setBasicFeeType(int basicFeeType) {
		this.basicFeeType = basicFeeType;
	}
	public int getAdvantageType() {
		return advantageType;
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
