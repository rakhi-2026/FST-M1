package OrangeHRM;

import java.io.FileInputStream;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static List<List<String>> readExcelData(String filePath,String sheetName) {
		
		List<List<String>> data = new ArrayList<>();
		Workbook excelFile;
		try {
			excelFile = new XSSFWorkbook(new FileInputStream(filePath));
			Sheet sheet1 = excelFile.getSheet(sheetName);
			for (Row rows : sheet1) {
				if (rows.getRowNum() == 0) {
					continue;
				}
				List<String> rowData = new ArrayList<>();
				for (Cell cells : rows) {
					switch (cells.getCellType()) {
					case STRING:
						rowData.add(cells.getStringCellValue().trim());
						break;
					case NUMERIC:
						if (DateUtil.isCellDateFormatted(cells)) {
							rowData.add(cells.getLocalDateTimeCellValue()
								.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
						} else {
							rowData.add(String.valueOf(cells.getNumericCellValue()));
						}
						break;
					default:
						rowData.add("-");
					}
				}
				data.add(rowData);
				excelFile.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	

}
