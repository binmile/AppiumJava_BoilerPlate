package com.binmile.automate.appium.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVIterator;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

public class CSVUtility {
	
	public static Object[][] readDataFromCSV(String fileName) {
		Object[][] data = null;
		String filePath = System.getProperty("user.dir") + 
				File.separator + "src" +
				File.separator + "test" +
				File.separator + "resources" +
				File.separator + "testdata" +
				File.separator + fileName + ".csv";
		
		File file = new File(filePath);
		CSVReader reader;
		CSVIterator itr;
		try {
			reader = new CSVReaderBuilder(new FileReader(file)).withSkipLines(1).build();
			int rows = 0;
			List<String[]> listOfRows = new ArrayList<String[]>();

			itr = new CSVIterator(reader);
			while (itr.hasNext()) {
				rows++;
				listOfRows.add(itr.next());//comment
			}

			int columns = listOfRows.get(0).length;
			
			data = new Object[rows][columns];

			int rowNumber = 0;
			for (String[] rowData : listOfRows) {
				for (int j = 0; j < columns; j++) {
					data[rowNumber][j] = rowData[j];
				}
				rowNumber++;
			}

		} catch (FileNotFoundException e) {
			System.err.println("File not found at path = "+filePath);
			e.printStackTrace();
		}catch (CsvValidationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

	
}
