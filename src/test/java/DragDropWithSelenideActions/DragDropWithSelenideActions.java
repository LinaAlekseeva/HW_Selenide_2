package DragDropWithSelenideActions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.testng.annotations.AfterMethod;
import static com.codeborne.selenide.Selenide.*;


public class DragDropWithSelenideActions {
    @BeforeClass
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }
    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    void successfulSearchTest() {
        //open site
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //Move rectangle A to B
        SelenideElement A = $("#column-a");
        SelenideElement B = $("#column-b");
        actions().clickAndHold(A).moveToElement(B).release().build().perform();

        //Check that the rectangles have actually swapped places
        $("#column-b").$("header").shouldHave(Condition.text("A"));
        System.out.println("Successful test successfulSearchTest_1!");
    }
    @Test
    void successfulSearchTest_2 () {
        //open site
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //Selenide has a command $(element).dragAndDrop($(to-element)), check if the test works if you use it instead of actions()
        $("#column-a").dragAndDropTo("#column-b");
        System.out.println("Successful test successfulSearchTest_2!");
    }

}
