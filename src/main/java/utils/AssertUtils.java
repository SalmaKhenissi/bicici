package utils;

import org.openqa.selenium.WebElement;
import java.util.List;

public class AssertUtils {

    public boolean isElementsContainsProvidedText(List<WebElement> list, String text) {

        return list.stream()
                .anyMatch(e->e.getText().trim().equals(text));
    }
}
