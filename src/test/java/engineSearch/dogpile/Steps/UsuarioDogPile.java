package engineSearch.dogpile.Steps;

import engineSearch.dogpile.Pages.Index;
import engineSearch.dogpile.Pages.Result;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;
import org.junit.Assert;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;

public class UsuarioDogPile {

    Index index;
    Result pageResult;
    public String actor;

    @Step("#actor into to URL")
    public void intoTo() {
        index.open();
    }

    @Step("#actor find the word {0}")
    public void find(String word) {
        index.intoWord(word);
        index.search();
    }

    @Step("#actor watch the results contain thw word {0}")
    public void watchRelevantResults(String wordWished) {
        List<String> results = pageResult.getResults();
        results.replaceAll(String::toLowerCase);
        for(int i= 0; i <results.size();i++){
            System.out.println(results.get(i));
        }
        Assert.assertThat(results, Matchers.everyItem(Matchers.containsString(wordWished)));
    }

    @Step("#actor review that contain :{1} is in the option: {0}")
    public void watchResultTittle(String title, String content) {
        String text = pageResult.getTitleResult(title);
        System.out.println(text);
        System.out.println(content);
        Assert.assertThat(text, containsString(content));
    }
}
