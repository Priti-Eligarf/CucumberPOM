package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import static stepdefination.SharedSD.getDriver;

public class Base {

   public WebElement webAction(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class)
              //  .ignoring(StaleElementReferenceException.class)
                .withMessage("Webdriver Wait");

//        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
//            public WebElement apply(WebDriver driver) {
//                return driver.findElement(locator);
//            }
//        });
//        return element;
//    }

       // Retry mechanism for StaleElementReferenceException
       int attempts = 0;
       while (attempts < 2) {
           try {
               WebElement element = wait.until(new Function<WebDriver, WebElement>() {
                   public WebElement apply(WebDriver driver) {
                       return driver.findElement(locator);
                   }
               });
               return element;
           } catch (StaleElementReferenceException e) {
               attempts++;
           }
       }

       throw new RuntimeException("Failed to find element after retrying StaleElementReferenceException.");
   }
    public void ClickOn(By locator)
    {
        webAction(locator).click();
    }

    public void setValues(By locator,String value)
    {
        webAction(locator).sendKeys(value);
    }
    public String getTextFromEle(By locator)
    {
        return webAction(locator).getText();
    }
    ArrayList<String> getElementTextList(By locator) {

        ArrayList<String> textlist = new ArrayList<>();
        List<WebElement> wbList = getDriver().findElements(locator);

        for (WebElement element : wbList) {
            textlist.add(element.getText());
        }

        return textlist;
    }
}

