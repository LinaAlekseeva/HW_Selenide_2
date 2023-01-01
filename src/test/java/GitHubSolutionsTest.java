import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubSolutionsTest {
    @Test
    void successfulSolutionsTest (){
        // Open GitHub
        open("https://github.com");
        //Select the Solutions menu for Enterprise with the command hover
        $(byText("Solutions")).hover();
        $(byText("Enterprise")).click();
        // Make sure the right page is loaded
        $(".font-mktg").shouldHave(Condition.text("Build like the best"));
        System.out.println("The text of 'Build like the best' is on!");
    }
}
