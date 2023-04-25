package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataProviderUtils {


    public Object[][] readCSVData(String csvFilePath) throws IOException, CsvValidationException {
        CSVReader csvReader = new CSVReader(new FileReader(csvFilePath));
        Object[][] loginData = new Object[1][2];

        String [] nextLine;
        int index = 0;
        csvReader.readNext(); // first line
        while ((nextLine = csvReader.readNext())!= null) {
            loginData[index][0] = nextLine[2];
            loginData[index][1] = nextLine[3];
            index++;
        }

        return loginData;
    }

    public Object[][] readTestCaseData(String csvFilePath, String testCaseId) throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader(csvFilePath));

        List<String[]>  data = csvReader.readAll();
        int nbrOfRows = data.size();
        Object[][] dataArray = new Object[nbrOfRows][1];

        for (int i = 0; i < nbrOfRows; i++) {
            if (data.get(i)[0].equals(testCaseId)) {
                dataArray[i] = data.get(i);
            }
        }

        return dataArray;
    }
}
