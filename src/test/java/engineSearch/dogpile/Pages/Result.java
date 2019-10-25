package engineSearch.dogpile.Pages;

import net.serenitybdd.core.pages.PageObject;

import java.util.List;
import java.util.stream.Collectors;

public class Result extends PageObject {
    public static final String TextResult = "..//span[contains(@class,'web-bing__description')]";
    public static final String  tittleResult= "//a[contains(@class,'web-bing__title') and contains(.,'{0}')]";
    public static final String Tittle = ".web-bing__title";
    public List<String> getResults(){
        return findAll(Tittle)
                .stream()
                .map(element -> element.getAttribute("textContent"))
                .collect(Collectors.toList());
    }

    public String getTitleResult(String tittle) {
        return findBy(tittleResult,tittle)
                .then().findBy(TextResult)
                .getText();
    }
}
