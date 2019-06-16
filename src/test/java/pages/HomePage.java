package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    private final By ARTICLE = By.xpath(".//a[@class = 'text-mine-shaft']");
    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void clickOnArticleById(int id) {
        List<WebElement> articles = baseFunc.getElements(ARTICLE);
        articles.get(id).click();
    }
}
