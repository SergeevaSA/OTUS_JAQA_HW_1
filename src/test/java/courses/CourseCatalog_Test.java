package courses;

import annotation.Driver;
import exceptions.UIExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

@ExtendWith(UIExtension.class)

public class CourseCatalog_Test {

    @Driver
    private WebDriver driver;

    @Test
    public void checkboxCategoryCourses() {
        new MainPage(driver)
                .open();


    }
}
