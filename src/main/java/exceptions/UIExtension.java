package exceptions;

import driver.WebDriverFactory;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

public class UIExtension implements BeforeEachCallback, AfterEachCallback {

  private WebDriver driver = null;

  @SuppressWarnings("unchecked")
  private List<Field> getAnnotatedFields(Class<?> annotation, ExtensionContext extensionContext) {
    List<Field> set = new ArrayList<>();
    Class<?> testClass = extensionContext.getTestClass().get();
    while (testClass != null) {
      for (Field field : testClass.getDeclaredFields()) {
        if (field.isAnnotationPresent((Class<? extends Annotation>) annotation)) {
          set.add(field);
        }
      }
      testClass = testClass.getSuperclass();
    }
    return set;
  }

  @Override
  public void beforeEach(ExtensionContext extensionContext) {
    driver = new WebDriverFactory().getDriver();
    @SuppressWarnings("unchecked") List<Field> fields = (List<Field>) getAnnotatedFields(WebDriver.class, extensionContext);

    for (Field field : fields) {
      if (field.getType().equals(WebDriver.class)) {
        AccessController.doPrivileged((PrivilegedAction<Void>) () -> {
          try {
            field.setAccessible(true);
            field.set(extensionContext.getTestInstance().get(), driver);
          } catch (IllegalAccessException e) {
            throw new Error(String.format("Could not access or set WebDriver. Make sure that the field is public.", field), e);
          }
          return null;
        });
      }
    }
  }

  @Override
  public void afterEach(ExtensionContext extensionContext) {
    if (driver != null) {
      driver.close();
      driver.quit();
    }
  }
}