package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CoursesCategoryPage extends BasePage<CoursesCategoryPage> {
  public CoursesCategoryPage(WebDriver driver) {
    super(driver);
  }

  public CoursesCategoryPage(String name, LocalDate startDate, WebDriver driver) {
    super(driver);
    this.name = name;
    this.startDate = startDate;
  }

  static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

  public static CoursesCategoryPage parseCourseFromWebElement(WebElement element, WebDriver driver) {
    String name = element.findElement(By.xpath("./div[@class='name']/a")).getText();
    LocalDate startDate = LocalDate.parse(element.findElement(By.xpath("./div[@class='start-date']")).getText(), DATE_FORMATTER);
    return new CoursesCategoryPage(name, startDate, driver);
  }

  private String name;
  private LocalDate startDate;

  public void dateOfCourse(String name, LocalDate startDate) {
    this.name = name;
    this.startDate = startDate;
  }

  public String getName() {
    return name;
  }

  public LocalDate getStartDate() {
    return startDate;
  }
}
