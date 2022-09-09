package com.test.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.test.entity.Product;

@Component
public class Helper {

	// check that file is of excel type or not
	public static boolean checkExcelFormat(MultipartFile file) {

		String contentType = file.getContentType();

		if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		} else {
			return false;
		}
	}// end of checkExcelFormat

	// convert excel to list of products

	public static List<Product> convertExcelToListOfProduct(InputStream inputstream) {
		List<Product> list = new ArrayList<>();

		try {

			try (XSSFWorkbook workbook = new XSSFWorkbook(inputstream)) {

				XSSFSheet sheet = workbook.getSheet("Sheet1");
				System.out.println("hello");

				int rowNumber = 0;
				Iterator<Row> iterator = sheet.iterator();

				while (iterator.hasNext()) {
					Row row = iterator.next();

					if (rowNumber == 0) {
						rowNumber++;
						continue;
					} // if end

					Iterator<Cell> cells = row.iterator();

					int cid = 0;

					Product p = new Product();

					while (cells.hasNext()) {
						Cell cell = cells.next();

						switch (cid) {
						case 0:
							p.setId((int) cell.getNumericCellValue());
							break;
						case 1:
							p.setProductName(cell.getStringCellValue());
							break;
						case 2:
							p.setQuantity(cell.getNumericCellValue());
							break;
						case 3:
							p.setGst(cell.getStringCellValue());
							break;
						case 4:
							p.setPrice(cell.getNumericCellValue());
						default:
							break;
						}// switch end
						cid++;

					} // while end

					list.add(p);

				} // while iterator end
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
