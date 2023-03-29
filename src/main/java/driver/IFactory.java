package driver;

import exceptions.BrowserNotSupported;
import org.openqa.selenium.WebDriver;

public interface IFactory {

        WebDriver newDriver() throws BrowserNotSupported;
}
