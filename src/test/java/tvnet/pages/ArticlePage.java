package tvnet.pages;

import org.openqa.selenium.By;

public class ArticlePage {

    private BaseFunc baseFunc;
    private final By ARTICLE_PAGE = By.xpath(".//h1[@class = 'article-headline']");
    private final By COMMENT_ARTICLE = By.xpath(".//a[contains(@class, 'item--comments')]");


    public ArticlePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTextArticlePage() {
        return baseFunc.getElement(ARTICLE_PAGE).getText();
    }

    public Integer getCommentCount() {
        if (baseFunc.getElement(COMMENT_ARTICLE).getAttribute("data-content") == null) {
            return 0;
        }
        return Integer.valueOf(baseFunc.getElement(COMMENT_ARTICLE).getAttribute("data-content"));
    }


}
