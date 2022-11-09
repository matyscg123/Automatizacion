package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.jsoup.Connection;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import page.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
        /*nos va a ejecutar todo lo que este en los features*/
        features = "src/test/resources/features",
        //manera en la que le decimos donde estan las definiciones para los steps de los feature
        glue = "steps",
        //para los reportes
        // plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","json:target/cucumber-reports.json"},
        monochrome = true,
        tags = "@Amazon"
        //para pasar varios test es de la siguiente manera
        //tags = {'@Test','@Smoke'}
)
public class Runner {
    @AfterClass
    public static void cleanDriver(){

    }
}
