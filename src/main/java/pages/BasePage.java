package pages;

import pageobject.PageObject;
import annotation.Path;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage<T> extends PageObject<T> {
  public BasePage(WebDriver driver) {
    super(driver);
  }

  private String baseURL = System.getProperty("webdriver.base.url", "https://otus.ru/");

  @FindBy(tagName = "h1")
  private WebElement header;

  public T headerShouldBeSameAs(String header) {
    Assertions.assertEquals(header, this.header.getText());
    return (T) this;
  }

  private String getPath() {
    Path path = getClass().getAnnotation(Path.class);
    if (path != null) {
      return path.value();
    }
    return "";
  }

  public T open() {
    driver.get(baseURL + getPath());
    return (T) this;
  }

}
