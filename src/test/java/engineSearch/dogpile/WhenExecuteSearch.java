package engineSearch.dogpile;

import engineSearch.dogpile.Steps.UsuarioDogPile;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class WhenExecuteSearch {

    @Steps
    UsuarioDogPile nelson;

    @Managed
    WebDriver driver;

    @Test
    public void watchResults(){
        nelson.intoTo();
        nelson.find("rock nacional");
        nelson.watchRelevantResults("rock");
    }

    @Test
    public void resultWikipedia(){
        nelson.intoTo();
        nelson.find("rock nacional");
        nelson.watchResultTittle("Argentine rock - Wikipedia","Argentine Rock Nacional is one of the principal predecessors");
    }
}
