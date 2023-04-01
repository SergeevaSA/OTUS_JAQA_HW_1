package courses;

import annotation.Driver;
import components.CategoryFilterComponents;
import data.CoursesCategoryData;
import exceptions.UIExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

@ExtendWith(UIExtension.class)

public class CourseCatalog_Test {

    @Driver
    private WebDriver driver;

    @Test
    public void checkboxCategoryCourses() {
        new MainPage(driver)
                .open()
                .clickCategoryCourseLinkByName(CoursesCategoryData.Programming)
                .headerShouldBeSameAs("Каталог");
        new CategoryFilterComponents(driver)
                .checkboxStatusShouldBeSameAs(CoursesCategoryData.Programming, true);


    }
}
