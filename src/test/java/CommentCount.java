import model.Article;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CommentCount {
    private final String URL = "http://rus.delfi.lv";
    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.tagName("h1");
    private final By COMMENT_COUNTER = By.xpath(".//a[contains(@class, 'text-red')]");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'd-inline')]");
    private final Integer articleIndex = 5;
    private final By ARTICLE_PAGE_COMMENT_COUNT = By.xpath(".//a[contains(@class, 'text-red-ribbon')]");
    private final By COMMENT_PAGE_TITLE = By.xpath(".//h1[@class = 'article-title']/a");
    private final By COMMENT_PAGE_COMMENT_COUNT = By.xpath(".//span[@class = 'type-cnt']");

    private final Logger LOGGER = LogManager.getLogger(CommentCount.class);


    private WebDriver driver;

    @Test
    public void commentCountCheck() {
        LOGGER.info("We are starting test!");
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(URL);

        //find article
        List<WebElement> articles = driver.findElements(ARTICLE);

        //Chose article
        Article article = getArticle(articles, articleIndex);

        //click on selected article
        articles.get(articleIndex).click();

        //Check  article page
        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();
        assertEquals(article.getTitle(), articlePageTitle, "Wrong title on article page");

        //Check comment count
        WebElement commentCount = driver.findElement(ARTICLE_PAGE_COMMENT_COUNT);
        Integer articlePageComments = removeBrackets(commentCount);

        assertEquals(article.getCommentCount(), articlePageComments, "Wrong comment counts on article page");

        // Click comment count  on article page
        commentCount.click();

        // Find Title on comment page
        String commentPageTitle = driver.findElement(COMMENT_PAGE_TITLE).getText();
        assertEquals(article.getTitle(), commentPageTitle, "Wrong title on comment page");

        //Find comment count on comment page
        List<WebElement> commentPageCounters = driver.findElements(COMMENT_PAGE_COMMENT_COUNT);
        Integer anonymousComment = removeBrackets(commentPageCounters.get(0));
        Integer registeredComment = removeBrackets(commentPageCounters.get(1));
        Integer commentSumm = anonymousComment + registeredComment;

        //Check comment count on comment page
        assertEquals(article.getCommentCount(), commentSumm, "Wrong comment count on comment page");
    }

    // Find selected article and map on object
    private Article getArticle(List<WebElement> elements, int i) {
        WebElement article = elements.get(i);

        Article currentArticle = new Article();
        currentArticle.setTitle(article.findElement(TITLE).getText());
        List<WebElement> commentCounters = article.findElements(COMMENT_COUNTER);

        if (commentCounters.isEmpty()) {
            currentArticle.setCommentCount(0);
        } else {
            currentArticle.setCommentCount(commentCounters.get(0).getText());
        }

        return currentArticle;
    }

    // Remove Brackets
    private Integer removeBrackets(WebElement txt) {
        String commentCount = txt.getText();
        commentCount = commentCount.substring(1, commentCount.length() - 1);
        return Integer.valueOf(commentCount);
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }
}
