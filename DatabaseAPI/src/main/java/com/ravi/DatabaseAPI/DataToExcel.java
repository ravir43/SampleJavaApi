package com.ravi.DatabaseAPI;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class DataToExcel {

	public void dataToExcel(HttpServletResponse response,List<CustomerEntity> data) {

		
		HSSFWorkbook workbook = new HSSFWorkbook();

		HSSFSheet sheet = workbook.createSheet("DATA-FILTER-BY-COMPANYNAME");

		HSSFRow row = sheet.createRow(0);

		row.createCell(0).setCellValue("id");
		row.createCell(1).setCellValue("name");
		row.createCell(2).setCellValue("phoneNumber");
		row.createCell(3).setCellValue("customerName");

		int rowIndex = 1;

		for (CustomerEntity cust : data) {

			HSSFRow datarow = sheet.createRow(rowIndex);
			datarow.createCell(0).setCellValue(cust.getId());
			datarow.createCell(1).setCellValue(cust.getName());
			datarow.createCell(2).setCellValue(cust.getPhoneNumber());
			datarow.createCell(3).setCellValue(cust.getCompanyName());
			rowIndex++;
		}

		try {
			ServletOutputStream os = response.getOutputStream();
			workbook.write(os);
			workbook.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
