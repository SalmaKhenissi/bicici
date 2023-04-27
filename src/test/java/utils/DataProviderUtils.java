package utils;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DataProviderUtils {


    public Object[][] readCSVData(String csvFilePath) throws IOException, CsvException {
        CSVReader csvReader = this.initiateReader(csvFilePath);

        List<String[]>  data = csvReader.readAll();
        String[] titles = data.get(0);

        Object[][] dataArray = new Object[1][1];
        Map<String, String> testData = new HashMap<>();
        for (int j = 0; j < titles.length; j++) {
            testData.put(titles[j], data.get(1)[j]);
        }
        dataArray[0][0] = testData;

        return dataArray;
    }

    public Object[][] readCSVTestCaseData(String csvFilePath, String testCaseId) throws IOException, CsvException {
        CSVReader csvReader = this.initiateReader(csvFilePath);

        List<String[]>  data = csvReader.readAll();
        String[] titles = data.get(0);

        Object[][] dataArray = new Object[1][1];
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i)[0].equals(testCaseId)) {
                Map<String, String> testData = new HashMap<>();
                for (int j = 0; j < titles.length; j++) {
                    testData.put(titles[j], data.get(i)[j]);
                }
                dataArray[0][0] = testData;
                break;
            }
        }

        return dataArray;
    }

    private CSVReader initiateReader(String csvFilePath) throws FileNotFoundException {
        CSVParser parser = new CSVParserBuilder().withSeparator(';').build();

        return new CSVReaderBuilder(new FileReader(csvFilePath)).withCSVParser(parser).build();
    }

    public Object[][] readExcelData(String excelFilePath) throws IOException {
        File myFile = new File(excelFilePath);
        FileInputStream fis = new FileInputStream(myFile);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Object[][] dataArray = new Object[1][1];
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

            }
        }

        return dataArray;
    }
}
