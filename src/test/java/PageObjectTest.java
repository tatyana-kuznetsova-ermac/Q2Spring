import org.junit.jupiter.api.Test;
import pages.BaseFunc;
import pages.HomePage;

public class PageObjectTest {

    private final String URL = "rus.delfi.lv";
    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void someTest() {
        baseFunc.goToUrl(URL);

        HomePage homePage = new HomePage(baseFunc);

        homePage.clickOnArticleById(5);
    }
}
