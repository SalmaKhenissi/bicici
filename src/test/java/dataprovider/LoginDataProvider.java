package dataprovider;

import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.DataProviderUtils;

import java.io.IOException;
import java.lang.reflect.Method;

public class LoginDataProvider {

    private final DataProviderUtils utils;

    public LoginDataProvider() {
        this.utils = new DataProviderUtils();
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData(final Method testMethod) throws CsvException, IOException {
        String testCaseId = testMethod.getAnnotation(Test.class).testName();

        return this.utils.readCSVTestCaseData("src/test/resources/testData/login.csv", testCaseId);
    }

    @DataProvider(name = "validLoginData")
    public Object[][] getValidLoginData(final Method testMethod) throws CsvException, IOException {

        return this.utils.readExcelData("src/test/resources/testData/logintest.xlsx");
    }
}
