import annotation.Driver;
import exceptions.UIExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ExtendWith(UIExtension.class)

public class MinDateCourses_Test {

    @Driver
    private WebDriver driver;

    @Test
    public void GetEarliestCourse() {

        List<Course> courses = driver.findElements(By.xpath("//div[@class='lessons']/div[@class='lesson']"))
                .stream()
                .map((WebElement element) -> {
                    return parseCourseFromWebElement(element);
                })
                .collect(Collectors.toList());

        Optional<Course> earliestCourse = courses.stream()
                .min(Comparator.comparing(Course::getStartDate));

        assert(earliestCourse.isPresent());
    }

    private Course parseCourseFromWebElement(WebElement element) {
        String name = element.findElement(By.xpath("./div[@class='name']/a")).getText();
        LocalDate startDate = LocalDate.parse(element.findElement(By.xpath("./div[@class='start-date']")).getText(), DATE_FORMATTER);
        return new Course(name, startDate);
    }
}
