package engineSearch.dogpile.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@DefaultUrl("https://www.dogpile.com/")
public class Index extends PageObject {

    @FindBy(how = How.ID, using="q")
    WebElementFacade txtSearch;

    @FindBy(how = How.XPATH, using="//*[@id=\"search\"]/button")
    WebElementFacade btnSearch;

    public void intoWord(String word) {
        txtSearch.type(word);
    }

    public void search() {
        btnSearch.click();
    }
}
