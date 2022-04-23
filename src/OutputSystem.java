package lotteworldticketing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OutputSystem {
	ArrayList<OrderData> orderList = new ArrayList<OrderData>();
	OrderData orderItem = null;
	InputSystem inputTicketSystem = new InputSystem();
	Calculator cal = new Calculator();
	PrintOut print = new PrintOut();
	WriteToCSV writeCsv = new WriteToCSV();
	Scanner sc = new Scanner(System.in);

	//
	public void continueButtonPrintOut() {
		resetTicketSystem();
		do {
			orderItem = new OrderData();
			// 입력
			inputTicketSystem.inputInformation(orderItem);
			// 계산 클래스에서 모든 계산 메소드를
			cal.calFinal(orderItem);
			// ArrayList에 Data 넣기
			inputDatainArrayList();
			// 시스템이 돌아갈 때 마다 카운트
			orderItem.setOrderCount(orderItem.getOrderCount() + 1);

			System.out.printf("\n계속 발권하시겠습니까?\n1. 티켓 발권\n2. 종료\n");
			// 1. 티켓발권 - 새로운 티켓 발행, 한 영수증 안에 누적되는 값 2. 종료 - 다음 질문으로 이동 
			orderItem.setContinueButton(sc.nextInt());

			System.out.println();
		} while (orderItem.getContinueButton() == ConstantNumber.CONTINUE_BUTTON);

		print.printOut(orderList, cal.totalTicketFee(orderList));

		orderItem.setNewOrderButton(sc.nextInt());
	}

	public void startSystem() {
		resetTicketSystem();
		do {
			continueButtonPrintOut();
		} while (orderItem.getNewOrderButton() == ConstantNumber.NEW_ORDER_BUTTON);
		System.out.println("티켓 구매를 완전히 종료합니다. 감사합니다.\n");
		createCSV(writeCsv);
	}

	// csv file 만드는 메소드
	void createCSV(WriteToCSV writeCsv) {
		File csvFile = new File("C:\\Users\\YOUSHIN KIM\\Desktop\\LotteWorldTicketCSV\\Result.csv");
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
		cal = new Calculator();
		orderItem = new OrderData();
		print = new PrintOut();
	}

	public void inputDatainArrayList() {
		orderList.add(orderItem);
	}

}
