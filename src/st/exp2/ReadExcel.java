package st.exp2;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {
	public Workbook readData(String filePath) throws EncryptedDocumentException, IOException {
		File xlsFile = new File(filePath);
		return WorkbookFactory.create(xlsFile);
	}

	public Object[][] getData(Workbook workbook, int row, int col) {
		Object[][] testList = new Object[row][col];
		// 获得工作表个数
		int sheetCount = workbook.getNumberOfSheets();
		// 遍历工作表
		for (int i = 0; i < sheetCount; i++) {
			Sheet sheet = workbook.getSheetAt(i);
			// 获得行数

			int rows = sheet.getPhysicalNumberOfRows();
			System.out.println(rows);
			// 获得列数，先获得一行，在得到改行列数
			Row tmp = sheet.getRow(0);
			if (tmp == null) {
				continue;
			}
			int cols = tmp.getPhysicalNumberOfCells();
			// 读取数据
			for (int j = 0; j < row; j++) {
				Row r = sheet.getRow(j);
				for (int k = 0; k < col; k++) {
					testList[j][k] = r.getCell(k).getStringCellValue();
				}
			}
		}
		return testList;
	}

	public static void main(String[] args) throws IOException, InvalidFormatException {
		String filePath = System.getProperty("user.dir") + "/test/st/exp2/Selenium+Lab2020.xlsx";
		
		ReadExcel readExcel = new ReadExcel();
		Workbook workbook = readExcel.readData(filePath);
		Object[][] results = readExcel.getData(workbook, 20, 2);
		for (int i = 0; i < results.length; i++) {
			for (int j = 0; j < results[0].length; j++) {
				System.out.println(results[i][j]);
			}
		}
	}
}
