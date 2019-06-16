import mappers.ClientMapper;
import model.Client;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class RegistrationFinbo {

    private final String URL = "https://stage.finbo.pl/";
    private WebDriver driver;
    private final By CALCULATOR = By.xpath(".//div[@class = 'top']");
    private final By REGISTRATION_BUTTON = By.xpath(".//div[@class = 'sf-button__inner']");
    private final By INPUT_CONTAINER = By.xpath(".//div[@class = 'sf-input invalid']");
    private final By NAME = By.xpath(".//div[@class = 'sf-input__label']");

    private ClientMapper mapper = new ClientMapper();

    @Test

    public void personalData() throws IOException {

        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(URL);

        //find button "get loan"
        driver.findElement(CALCULATOR).findElement(REGISTRATION_BUTTON).click();
        //find name
        driver.findElement(INPUT_CONTAINER).findElement(NAME);

//        Client client = mapper.mapClientFromFile();


    }


}
