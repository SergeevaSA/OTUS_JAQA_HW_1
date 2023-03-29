package pages;

import annotation.Path;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;

@Path("xpath://div[@class='lessons']/div[@class='lesson']")
//используется для метода, выбирающего выбирать курс, стартующего раньше всех/позже всех//

public class CoursesCategory extends BasePage<CoursesCategory> {
    public CoursesCategory(WebDriver driver) {
        super(driver);
    }
    public Course parseCourseFromWebElement(WebElement element) {
        String name = element.findElement(By.xpath(".//h3")).getText();
        LocalDate startDate = LocalDate.parse(element.findElement(By.xpath(".//span")).getText(), DATE_FORMATTER);
        return new Course(name, startDate);
    }

}
