package tvnet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import tvnet.pages.ArticlePage;
import tvnet.pages.BaseFunc;
import tvnet.pages.TvNetHomePage;

public class TvNetTest {

    private final String URL = "rus.tvnet.lv";

    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void ArticleTest() {
        baseFunc.gotoUrl(URL);
        TvNetHomePage tvNetHomePage = new TvNetHomePage(baseFunc);
        //vibirajem nomer statji
        WebElement article = tvNetHomePage.getArticleById(5);
        //naxodim statju
        String articleTitle = tvNetHomePage.getTitleFromArticle(article);
        //naxodim comment
        Integer commentCount = tvNetHomePage.getCommentsFromArticle(article);
        //click po 5 statje
        ArticlePage articlePage = tvNetHomePage.clickOnArticleById(5);
        //sravnivaem nazvanie stat'i
        Assertions.assertEquals(articleTitle, articlePage.getTextArticlePage());
        Assertions.assertEquals(commentCount, articlePage.getCommentCount());



    }

}
















