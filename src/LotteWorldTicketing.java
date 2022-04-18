package lotteworldticketing;

import java.util.Calendar;
import java.util.Scanner;

public class LotteWorldTicketing {

	// 1 - 1
	final static int FULL_TICKET_1DAY_ADULT = 62000, FULL_TICKET_1DAY_TEEN = 54000, FULL_TICKET_1DAY_CHILD = 47000;
	// 1 - 2
	final static int FULL_TICKET_AFTER4_ADULT = 50000, FULL_TICKET_AFTER4_TEEN = 43000,
			FULL_TICKET_AFTER4_CHILD = 36000;
	// 2 - 1
	final static int PARK_TICKET_1DAY_ADULT = 59000, PARK_TICKET_1DAY_TEEN = 52000, PARK_TICKET_1DAY_CHILD = 46000;
	// 2 - 2
	final static int PARK_TICKET_AFTER4_ADULT = 47000, PARK_TICKET_AFTER4_TEEN = 41000,
			PARK_TICKET_AFTER4_CHILD = 35000;
	// ���̺�
	final static int BABY = 15000;
	// ����
	final static int MIN_ADULT_AGE = 19, MAX_ADULT_AGE = 64, MIN_TEEN_AGE = 13, MAX_TEEN_AGE = 18, MIN_CHILD_AGE = 3,
			MAX_CHILD_AGE = 12, MIN_BABY_AGE = 1, MAX_BABY_AGE = 3;
	// �������
	final static double DISCOUNT_RATE_DISABLED = 0.5, DISCOUNT_RATE_MAN_OF_MERIT = 0.5, DISCOUNT_RATE_SOLDIER = 0.51,
			DISCOUNT_RATE_PREGNANT = 0.5, DISCOUNT_RATE_CHILDREN_CARD = 0.7;
	//
	final static int SAVE_TICKETING = 0, SAVE_OPTION = 1, SAVE_BASIC_FEE_TYPE = 2, SAVE_NUMBER_OF_TICKET = 3,
			SAVE_TOTAL_FEE = 4, SAVE_SPECIAL_DISCOUNT = 5;

	static int[][] orderList = new int[10][10];

	static int orderCount;
	static int inputTicketing, inputOption, continueButton, basicFeeType, finalContinueButton;
	static int id, gender, age, century, numberOfTicket, basicFee, specialDiscount, finalFee;
	static int totalFee;
	static Scanner sc = new Scanner(System.in);

	static void ticketing() {
		do {
			System.out.printf("�����Ͻ� �̿���� �����ϼ���.\n");
			System.out.printf("1. �����̿��(�̿����: �Ե����� + �μӹڹ���)\n2. ��ũ�̿��(�̿����: �Ե�����)\n");
			inputTicketing = sc.nextInt();
		} while (!(inputTicketing == 1 || inputTicketing == 2));

		do {
			System.out.printf("�����Ͻ� �̿���� �ɼ��� �������ּ���.\n");
			System.out.printf("1. 1Day\\n2. After4(���� 4�ú��� ���尡��)\n");
			inputOption = sc.nextInt();
		} while (!(inputOption == 1 || inputOption == 2));

	}

	static void inputId() {
		System.out.printf("\n�ֹε�Ϲ�ȣ�� �� 6�ڸ��� �Է��ϼ���. ex) 930820\n");
		id = sc.nextInt();
		System.out.printf("�ֹε�Ϲ�ȣ ���ڸ� ù° �ڸ��� �Է��ϼ���.\n");
		gender = sc.nextInt();

		Calendar cal = Calendar.getInstance();
		int currentYear = cal.get(Calendar.YEAR);
		int currentMonth = cal.get(Calendar.MONDAY) + 1;
		int currentDay = cal.get(Calendar.DATE);

		int year = id / 10000;
		int month = (id % 10000) / 100;
		int day = id % 100;

		if (gender == 1 || gender == 2) {
			century = 1900;
			if (currentMonth > month || currentMonth == month && currentDay < day) {
				age = currentYear - (century + year);
			} else {
				age = currentYear - (century + year) - 1;
			}
		}
		if (gender == 3 || gender == 4) {
			century = 2000;
			if (currentMonth > month || currentMonth == month && currentDay < day) {
				age = currentYear - (century + year);
			} else {
				age = currentYear - (century + year) - 1;
			}
		}
	}

	static void inputNumberOfTicket() {
		do {
			System.out.printf("\n������ �ֹ��Ͻðڽ��ϱ�?(�ִ�10��)\n");
			numberOfTicket = sc.nextInt();

		} while (numberOfTicket > 10);
	}

	static void inputAgeDiscount() {
		if (inputTicketing == 1 && inputOption == 1) {
			if (age >= MIN_ADULT_AGE && age <= MAX_ADULT_AGE) {
				basicFee = FULL_TICKET_1DAY_ADULT;
				basicFeeType = 0;
			} else if (age >= MIN_TEEN_AGE && age <= MAX_TEEN_AGE) {
				basicFee = FULL_TICKET_1DAY_TEEN;
				basicFeeType = 1;
			} else if ((age >= MIN_CHILD_AGE && age <= MAX_CHILD_AGE) || age >= MAX_ADULT_AGE) {
				basicFee = FULL_TICKET_1DAY_CHILD;
				basicFeeType = 2;
			}
		}
		// �����̿�� After4
		if (inputTicketing == 1 && inputOption == 2) {
			if (age >= MIN_ADULT_AGE && age <= MAX_ADULT_AGE) {
				basicFee = FULL_TICKET_AFTER4_ADULT;
				basicFeeType = 0;
			} else if (age >= MIN_TEEN_AGE && age <= MAX_TEEN_AGE) {
				basicFee = FULL_TICKET_AFTER4_TEEN;
				basicFeeType = 1;
			} else if ((age >= MIN_CHILD_AGE && age <= MAX_CHILD_AGE) || age >= MAX_ADULT_AGE) {
				basicFee = FULL_TICKET_AFTER4_CHILD;
				basicFeeType = 2;
			}
		}
		// ��ũ�̿�� 1day
		if (inputTicketing == 2 && inputOption == 1) {
			if (age >= MIN_ADULT_AGE && age <= MAX_ADULT_AGE) {
				basicFee = PARK_TICKET_1DAY_ADULT;
				basicFeeType = 0;
			} else if (age >= MIN_TEEN_AGE && age <= MAX_TEEN_AGE) {
				basicFee = PARK_TICKET_1DAY_TEEN;
				basicFeeType = 1;
			} else if ((age >= MIN_CHILD_AGE && age <= MAX_CHILD_AGE) || age >= MAX_ADULT_AGE) {
				basicFee = PARK_TICKET_1DAY_CHILD;
				basicFeeType = 2;
			}
		}
		// �����̿�� After4
		if (inputTicketing == 2 && inputOption == 2) {
			if (age >= MIN_ADULT_AGE && age <= MAX_ADULT_AGE) {
				basicFee = PARK_TICKET_AFTER4_ADULT;
				basicFeeType = 0;
			} else if (age >= MIN_TEEN_AGE && age <= MAX_TEEN_AGE) {
				basicFee = PARK_TICKET_AFTER4_TEEN;
				basicFeeType = 1;
			} else if ((age >= MIN_CHILD_AGE && age <= MAX_CHILD_AGE) || age >= MAX_ADULT_AGE) {
				basicFee = PARK_TICKET_AFTER4_CHILD;
				basicFeeType = 2;
			}
		}
		// ���̺�
		if (age < MIN_BABY_AGE) {
			basicFee = 0;
			basicFeeType = 3;
		}
		if (age >= MIN_BABY_AGE && age < MAX_BABY_AGE && numberOfTicket >= 10) {
			basicFee = BABY;
			basicFeeType = 3;
		} else if (age >= MIN_BABY_AGE && age < MAX_BABY_AGE && numberOfTicket < 10) {
			basicFee = 0;
			basicFeeType = 3;
		}
	}

	static void inputSpecialDiscount() {
		do {
			// ������ ����(��� ��� ����)
			System.out.printf("\n�������� �����ϼ���.\n(���ɿ� ���� ��������� �ڵ� ����˴ϴ�.)\n\n");
			System.out.printf("0. ������� ����\n");
			System.out.printf("1. ����� ���\n");
			System.out.printf("2. ���������� ���\n");
			System.out.printf("3. �ް��庴 ���\n");
			System.out.printf("4. �ӻ�� ���\n");
			System.out.printf("5. �ٵ��� �ູī�� ���\n");
			specialDiscount = sc.nextInt();

			// 0. ������� ����
			if (specialDiscount == 0) {
				totalFee = basicFee * numberOfTicket;
			}
			// 1.����� ���
			if (specialDiscount == 1) {
				if (numberOfTicket == 1) {
					totalFee = (int) (basicFee * DISCOUNT_RATE_DISABLED);
				} else if (numberOfTicket == 2) {
					totalFee = (int) (basicFee * DISCOUNT_RATE_DISABLED * 2);
				} else {
					totalFee = (int) ((basicFee * DISCOUNT_RATE_DISABLED * 2) + basicFee * (numberOfTicket - 2));
				}
			}
			// 2. ���������� ���
			if (specialDiscount == 2) {
				if (numberOfTicket == 1) {
					totalFee = (int) (basicFee * DISCOUNT_RATE_MAN_OF_MERIT);
				} else if (numberOfTicket == 2) {
					totalFee = (int) (basicFee * DISCOUNT_RATE_MAN_OF_MERIT * 2);
				} else {
					totalFee = (int) ((basicFee * DISCOUNT_RATE_MAN_OF_MERIT * 2) + basicFee * (numberOfTicket - 2));
				}
			}
			// 3. �ް��庴 ���
			if (specialDiscount == 3) {
				if (numberOfTicket == 1) {
					totalFee = (int) (basicFee * DISCOUNT_RATE_SOLDIER);
				} else if (numberOfTicket == 2) {
					totalFee = (int) (basicFee * DISCOUNT_RATE_SOLDIER * 2);
				} else {
					totalFee = (int) ((basicFee * DISCOUNT_RATE_SOLDIER * 2) + basicFee * (numberOfTicket - 2));
				}
			}
			// 4. �ӻ�� ���
			if (gender == 2 || gender == 4) {
				if (specialDiscount == 4) {
					if (numberOfTicket == 1) {
						totalFee = (int) (basicFee * DISCOUNT_RATE_PREGNANT);
					} else {
						totalFee = (int) ((basicFee * DISCOUNT_RATE_PREGNANT) + basicFee * (numberOfTicket - 1));
					}
				}
			}
			// 5. �ٵ��� ���
			if (specialDiscount == 5) {
				if (numberOfTicket == 1) {
					totalFee = (int) (basicFee * DISCOUNT_RATE_CHILDREN_CARD);
				} else {
					totalFee = (int) ((basicFee * DISCOUNT_RATE_CHILDREN_CARD) + basicFee * (numberOfTicket - 1));
				}
			}
		} while (!(specialDiscount == 0 || specialDiscount == 1 || specialDiscount == 2 || specialDiscount == 3
				|| specialDiscount == 4 || specialDiscount == 5));
	}

	static void printOut() {
		System.out.printf("�̿��\t�ɼ�\t����\t���\t����\t������\n");
		for (int index = 0; index < orderCount; index++) {
			if (orderList[index][SAVE_TICKETING] == 1) {
				System.out.printf("�����̿��\t");
			} else {
				System.out.printf("��ũ�̿��\t");
			}

			if (orderList[index][SAVE_OPTION] == 1) {
				System.out.printf("1Day\t");
			} else {
				System.out.printf("After4\t");
			}

			if (orderList[index][SAVE_BASIC_FEE_TYPE] == 0) {
				System.out.printf("�\t");
			} else if (orderList[index][SAVE_BASIC_FEE_TYPE] == 1) {
				System.out.printf("û�ҳ�\t");
			} else if (orderList[index][SAVE_BASIC_FEE_TYPE] == 2) {
				System.out.printf("���\t");
			} else if (orderList[index][SAVE_BASIC_FEE_TYPE] == 3) {
				System.out.printf("���̺�\t");
			}

			System.out.printf("%d\t", orderList[index][SAVE_NUMBER_OF_TICKET]);
			System.out.printf("%d\t", orderList[index][SAVE_TOTAL_FEE]);

			if (orderList[index][SAVE_SPECIAL_DISCOUNT] == 0) {
				System.out.printf("*������ ����\t");
			} else if (orderList[index][SAVE_SPECIAL_DISCOUNT] == 1) {
				System.out.printf("*����� ���\t");
			} else if (orderList[index][SAVE_SPECIAL_DISCOUNT] == 2) {
				System.out.printf("*���������� ���\t");
			} else if (orderList[index][SAVE_SPECIAL_DISCOUNT] == 3) {
				System.out.printf("*�ް��庴 ���\t");
			} else if (orderList[index][SAVE_SPECIAL_DISCOUNT] == 4) {
				System.out.printf("*�ӻ�� ���\t");
			} else if (orderList[index][SAVE_SPECIAL_DISCOUNT] == 5) {
				System.out.printf("*�ٵ��� �ູī�� ���\t");
			}
			System.out.printf("\n");
		}
	}

	static void totalTicketFee() {
		finalFee += totalFee;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		do {
			do {
				// Ticketing
				ticketing();

				// �ֹι�ȣ �Է�
				inputId();

				// �� �� �Է�
				inputNumberOfTicket();

				// ���� ����
				inputAgeDiscount();

				// ������ ����(��� ��� ����)
				inputSpecialDiscount();

				// Ƽ�� �Ѿ�
				totalTicketFee();

				orderList[orderCount][SAVE_TICKETING] = inputTicketing; // �̿��
				orderList[orderCount][SAVE_OPTION] = inputOption; // �ɼ�
				orderList[orderCount][SAVE_BASIC_FEE_TYPE] = basicFeeType; // ���ɿ� ���� �ݾ�
				orderList[orderCount][SAVE_NUMBER_OF_TICKET] = numberOfTicket; // �� ��
				orderList[orderCount][SAVE_TOTAL_FEE] = totalFee; // �ݾ�
				orderList[orderCount][SAVE_SPECIAL_DISCOUNT] = specialDiscount; // ������
				orderCount++;
				System.out.printf("\n��� �߱��Ͻðڽ��ϱ�?\n1. Ƽ�� �߱�\n2. ����\n");
				continueButton = sc.nextInt();

				System.out.printf("\n");
			} while (continueButton == 1);
			System.out.printf("================================================\n");
			printOut();
			System.out.printf("\n�Ѿ��� %d�� �Դϴ�.\n", finalFee);
			System.out.printf("Ƽ�� ���Ÿ� �����մϴ�. �����մϴ�.\n");
			System.out.printf("\n");
			System.out.printf("��� �����Ͻðڽ��ϱ�? 1. ���ο� �ֹ� 2. ���α׷� ����\n");
			finalContinueButton = sc.nextInt();
			System.out.printf("\n");
			orderCount = 0;
			finalFee = 0;
		} while (finalContinueButton == 1);
		System.out.printf("Ƽ�� ���Ÿ� ������ �����մϴ�. �����մϴ�.\n");
	}

}
