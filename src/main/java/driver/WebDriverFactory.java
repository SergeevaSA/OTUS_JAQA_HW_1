package driver;

import data.BrowserData;
import exceptions.BrowserNotSupported;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Locale;

public class WebDriverFactory implements IFactory {

  private String browserName = System.getProperty("browser").toLowerCase(Locale.ROOT);
  private EventFiringWebDriver driver;

  public WebDriver newDriver() throws BrowserNotSupported {
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--no-sandbox");
    chromeOptions.addArguments("--no-first-run");
    chromeOptions.addArguments("--homepage=about:blank");
    chromeOptions.addArguments("--ignore-certificate-errors");
    chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    boolean isSupported = false;

    for (BrowserData browserData : BrowserData.values()) {
      if (browserName.equals(browserData.name().toLowerCase(Locale.ROOT))) {
        isSupported = true;
      }
    }

    if (!isSupported) {
      throw new BrowserNotSupported(browserName);
    }

    switch (BrowserData.valueOf(browserName.toUpperCase(Locale.ROOT))) {
      case CHROME:
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions); // добавляем chromeOptions в конструктор
      case OPERA:
        WebDriverManager.operadriver().setup();
        return new OperaDriver();
      case FIREFOX:
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
      default:
        throw new BrowserNotSupported(browserName);
    }
  }

  public EventFiringWebDriver getDriver() {
    return driver;
  }

  public void setDriver(EventFiringWebDriver driver) {
    this.driver = driver;
  }
}