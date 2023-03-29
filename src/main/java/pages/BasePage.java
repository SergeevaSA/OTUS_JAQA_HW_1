package pages;

import PageObject.PageObject;
import annotation.Path;
import org.openqa.selenium.WebDriver;

public class BasePage<T> extends PageObject<T> {

    private String baseURL=System.getProperty("webdriver.base.url","https://otus.ru/");

    public BasePage(WebDriver driver) {
        super(driver);
    }

    private String getPath() {
        Path path = getClass().getAnnotation(Path.class);
        if (path != null) {
            return path.value();
        }
        return "";
    }

    public String getPathFromSample(String name, String...data) {
    }

    public T open() {
        driver.get(baseURL+getPath());
        return (T)this;
    }

    public T open(String name, String...params) {
        driver.get(baseURL+getPathFromSample(name, params));
        return (T)this;
    }
}
