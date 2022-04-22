package lotteworldticketing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OutputSystem {
	ArrayList<OrderData> orderList = new ArrayList<OrderData>();
	OrderData orderItem = null;
	InputSystem inputTicketSystem = new InputSystem();
	Calculate cal = new Calculate();
	PrintOut print = new PrintOut();
	WriteToCSV writeCsv = new WriteToCSV();
	Scanner sc = new Scanner(System.in);

	public void continueButtonPrintOut() {
		resetTicketSystem();
		do {
			orderItem = new OrderData();
			// 입력
			inputTicketSystem.inputInformation(orderItem);

			cal.calFinal(orderItem);
			// ArrayList에 Data 넣기
			inputDatainArrayList();
			//
			orderItem.setOrderCount(orderItem.getOrderCount() + 1);

			System.out.printf("\n계속 발권하시겠습니까?\n1. 티켓 발권\n2. 종료\n");

			orderItem.setContinueButton(sc.nextInt());

			System.out.printf("\n");
		} while (orderItem.getContinueButton() == StaticValue.CONTINUE_BUTTON);

		print.printOut(orderList, cal.totalTicketFee(orderList));

		orderItem.setNewOrderButton(sc.nextInt());
	}

	public void startSystem() {
		resetTicketSystem();
		do {
			continueButtonPrintOut();
		} while (orderItem.getNewOrderButton() == StaticValue.NEW_ORDER_BUTTON);
		System.out.println("티켓 구매를 완전히 종료합니다. 감사합니다.\n");
		createCSV(writeCsv);
	}

	void createCSV(WriteToCSV writeCsv) {
		File csvFile = new File("C:\\Users\\YOUSHIN KIM\\Desktop\\LotteWorldTicketCSV\\test.csv");
		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter(csvFile, true));
			bw.write(orderItem.getMenu());
			bw.write(writeCsv.csvCount(orderList));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.flush();
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void resetTicketSystem() {
		orderList = new ArrayList<OrderData>();
		inputTicketSystem = new InputSystem();
		cal = new Calculate();
		orderItem = new OrderData();
		print = new PrintOut();
	}

	public void inputDatainArrayList() {
		orderList.add(orderItem);
	}

}
