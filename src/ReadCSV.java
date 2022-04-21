//package lotteworldticketing;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.util.ArrayList;
//
//public class ReadCSV {
//	ArrayList<String> importCsvFile = new ArrayList<String>();
//	
//	public void readCSV() {
//		int cntFullTicket = 0;
//		int cntParkTicket = 0;
//		int cntPrint
//		try {
//			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\YOUSHIN KIM\\Desktop\\LotteWorldTicketCSV\\test.txt"));
//			File analysisFile = new File("C:\\Users\\YOUSHIN KIM\\Desktop\\LotteWorldTicketCSV\\analysis.txt");
//			BufferedWriter bw = new BufferedWriter(new FileWriter(analysisFile, true));
//			String line;
//			while ((line = br.readLine()) != null) {
//				importCsvFile.add(line);
//			}
//			for (int index = 0; index < importCsvFile.size(); index++) {
//				String[] arrayPrintTicketing = importCsvFile.get(index).split(",");
//				if (arrayPrintTicketing[0].equals("종합이용권")) {
//					cntFullTicket++;
//				} else if (arrayPrintTicketing[0] == "파크이용권") {
//					cntParkTicket++;
//				}
//				
//				if(arrayPrintTicketing[2] == "어른") {
//					
//				}
//			}
//	
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//}
