package components;

import PageObject.PageObject;
import org.openqa.selenium.WebDriver;

public abstract class AbsBaseComponents extends PageObject <AbsBaseComponents> {

    public AbsBaseComponents (WebDriver driver) {
        super(driver);
    }



}
