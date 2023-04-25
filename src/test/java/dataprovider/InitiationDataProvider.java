package dataprovider;

import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;
import utils.DataProviderUtils;

import java.io.IOException;

public class InitiationDataProvider {

    private DataProviderUtils utils;

    public InitiationDataProvider() {
        this.utils = new DataProviderUtils();
    }

    @DataProvider(name = "initiation-provider")
    public Object[][] initiationData() throws CsvValidationException, IOException {

        return this.utils.readCSVData("src/test/resources/testdata/login.csv");
    }
}
