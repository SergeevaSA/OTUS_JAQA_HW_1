package courses;

import annotation.Driver;
import exceptions.UIExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.CoursesCategoryPage;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ExtendWith(UIExtension.class)

public class MinDateCourses_Test {

  @Driver
  private WebDriver driver;

  @Test
  public void getEarliestCourse() {
    List<CoursesCategoryPage> courses = driver.findElements(By.xpath("//div[@class='lessons']/div[@class='lesson']"))
            .stream()
            .map(element -> CoursesCategoryPage.parseCourseFromWebElement(element, driver))
            .collect(Collectors.toList());

    Optional<CoursesCategoryPage> earliestCourse = getEarliestCourse(courses);

    assert (earliestCourse.isPresent());
  }

  public Optional<CoursesCategoryPage> getEarliestCourse(List<CoursesCategoryPage> courses) {
    return courses.stream()
            .min(Comparator.comparing(CoursesCategoryPage::getStartDate));
  }
}