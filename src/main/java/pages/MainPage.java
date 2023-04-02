package pages;

import data.CoursesCategoryData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage<MainPage> {

  public MainPage(WebDriver driver) {
    super(driver);
  }

  private String navCategoryLinkTemplateSelector = "div.lessons > div.lesson";

  public CoursesCategoryPage clickCategoryCourseLinkByName(CoursesCategoryData coursesCategoryData) {
    String selector = String.format(navCategoryLinkTemplateSelector, coursesCategoryData.getName());
    WebElement elementToClick = driver.findElements(By.cssSelector(selector)).get(0);
    highlightAndClickElement(driver, elementToClick);
    return new CoursesCategoryPage(driver);
  }

}