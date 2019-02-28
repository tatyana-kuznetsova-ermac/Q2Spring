import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CommentsTest {
    private WebDriver driver;
    private final String URL = "http://delfi.lv";
    private final By FIRST_COMMENT = By.xpath(".//a[@class = 'comment-count text-red-ribbon']");
    private final By ARTICLE_TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By ARTICLE_PAGE_COMMENT_COUNT = By.xpath(".//a[contains(@class, 'text-red-ribbon')]");
    private final By COMMENT_PAGE_COMMENT_COUNT = By.xpath(".//span[@class = 'type-cnt']");

    @Test
    public void commentCountCheck() {

        //set driver path
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

        //Open browser
        driver = new ChromeDriver();

        //Full screen
        driver.manage().window().maximize();

        //Open home Page
        driver.get(URL);

        //Find count comment
        WebElement commentCount = driver.findElement(FIRST_COMMENT);

        Integer homePageCommentCount = removeBrackets(commentCount);

        //Find title and click
        driver.findElement(ARTICLE_TITLE).click();
        //Find comment count on article page

        commentCount = driver.findElement(ARTICLE_PAGE_COMMENT_COUNT);

        Integer articlePageCommentCount = removeBrackets(commentCount);

        //Checking comments
        Assertions.assertEquals(homePageCommentCount, articlePageCommentCount, "Wrong comment on article page!");

        //click comment count
        commentCount.click();

        //Find anonymous comments

        List<WebElement> commentPageCounters = driver.findElements(COMMENT_PAGE_COMMENT_COUNT);
        Integer anonymousComment = removeBrackets(commentPageCounters.get(0));
        Integer registeredCommnt = removeBrackets(commentPageCounters.get(1));
        Integer commentSumm = anonymousComment + registeredCommnt;

        Assertions.assertEquals(homePageCommentCount, commentSumm, "Wrong comment on comment page");

    }

    private Integer removeBrackets(WebElement txt) {
        String commentCount = txt.getText();
        commentCount = commentCount.substring(1, commentCount.length() - 1);
        return Integer.valueOf(commentCount);
    }

    @AfterEach
    public void closeBrowser() {
//        driver.close();
    }
}
