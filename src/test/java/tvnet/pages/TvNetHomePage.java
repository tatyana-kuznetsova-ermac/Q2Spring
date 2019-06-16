package tvnet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TvNetHomePage {

    private BaseFunc baseFunc;
    private final By ARTICLE = By.xpath(".//article[@class = 'list-article' or contains(@class, 'content-on-image')]");
    private final By TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENTS_COUNT = By.xpath(".//span[@itemprop = 'url']");

    public TvNetHomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    //Iwem statju
    public WebElement getArticleById(int id) {
        return baseFunc.getElements(ARTICLE).get(id);
    }

    //Nazvanije stat'i na glavnoj str
    public String getTitleFromArticle(WebElement article) {
        return article.findElement(TITLE).getText();
    }

    //iwem kol-vo comment, proverjaem chto comment est, esle est vozvrawaem rezultat
    public Integer getCommentsFromArticle(WebElement article) {
        if (article.findElements(COMMENTS_COUNT).isEmpty()) {
            return 0;
        }

        //Iwem kommenti (text), otbrasivaem skobki, vozvrawaem rezultat
        String commentCount = article.findElement(COMMENTS_COUNT).getText();
        commentCount = commentCount.substring(1, commentCount.length() - 1);
        return Integer.valueOf(commentCount);
    }

    //click na statju i perexod na str ArticlePage
    public ArticlePage clickOnArticleById(int id) {
        baseFunc.click(getArticleById(id));
        return new ArticlePage(baseFunc);
    }

}
