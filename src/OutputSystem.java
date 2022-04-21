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
	InputSystem inputTicketSystem = new InputSystem();
	OrderData orderItem = null;
	Calculate cal = new Calculate();
	PrintOut print = new PrintOut();
	
	Scanner sc = new Scanner(System.in);

	public void continueButtonPrintOut() {
		resetTicketSystem();
		do {
			orderItem = new OrderData();
			// �Է�
			inputTicketSystem.inputInformation(orderItem);

			cal.calFinal(orderItem);
			// ArrayList�� Data �ֱ�
			inputDatainArrayList();
			//
			orderItem.setOrderCount(orderItem.getOrderCount() + 1);

			System.out.printf("\n��� �߱��Ͻðڽ��ϱ�?\n1. Ƽ�� �߱�\n2. ����\n");

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
		System.out.println("Ƽ�� ���Ÿ� ������ �����մϴ�. �����մϴ�.\n");
		createCSV(writeCsv);
	}

	WriteToCSV writeCsv = new WriteToCSV();
	
	void createCSV (WriteToCSV writeCsv) {
		File csvFile = new File("C:\\Users\\YOUSHIN KIM\\Desktop\\LotteWorldTicketCSV\\test.txt");
		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter(csvFile, true));
			bw.write(orderItem.getMenu());
			bw.write(writeCsv.csvCount(orderList, orderItem));
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
