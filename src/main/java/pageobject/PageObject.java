package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class PageObject<T> {

  protected WebDriver driver;
  protected Actions action;

  public PageObject(WebDriver driver) {
    this.driver = driver;
    this.action = new Actions(driver);
    PageFactory.initElements(driver, this);
  }

  public WebElement $(By locator) {
    return driver.findElement(locator);
  }

  public void highlightAndClickElement(WebDriver driver, WebElement element) {
    Actions actions = new Actions(driver);
    actions.moveToElement(element).build().perform();
    ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
    actions.click().build().perform();
  }

  public LocalDate parseDate(String dateString) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    return LocalDate.parse(dateString, formatter);
  }
}
