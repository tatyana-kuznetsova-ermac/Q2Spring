package tvnet.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BaseFunc {

    private WebDriver driver;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void gotoUrl(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        driver.get(url);
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public void closeBrowser() {
        Assertions.assertNull(driver, "Page ");
        driver.close();
    }

    public void click(WebElement we) {
        we.click();
    }
}
