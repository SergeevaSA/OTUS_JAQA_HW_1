package components;

import data.CoursesCategoryData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryFilterComponents extends AbsBaseComponents {

    public CategoryFilterComponents(WebDriver driver) {
        super(driver);
    }

    private String checkboxInputLocatorSample = "//label[text()='%s']/..//input[@type='checkbox']";

    public CategoryFilterComponents checkboxStatusShouldBeSameAs (CoursesCategoryData coursesCategoryData, boolean expectedStatus) {
        String locator = String.format(checkboxInputLocatorSample, coursesCategoryData);
        Assertions.assertEquals($(By.xpath(locator)).isSelected(), expectedStatus, "Wrong checkbox status");

        return this;
    }
}
