package dataprovider;

import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;
import utils.DataProviderUtils;

import java.io.IOException;

public class InitiationDataProvider {

    private DataProviderUtils utils;

    public InitiationDataProvider() {
        this.utils = new DataProviderUtils();
    }

    @DataProvider(name = "initiationProvider")
    public Object[][] initiationData() throws CsvException, IOException {

        return this.utils.readCSVData("src/test/resources/testData/newProspect/prospect.csv");
    }
}
