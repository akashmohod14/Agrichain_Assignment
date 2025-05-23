package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/features/Agrichain.feature"
        },
        glue= {"stepdef","hooks"},
        monochrome = true,
        plugin = {
                "pretty", "html:target/cucumber-reports"
        }
)

public class Runner {
}
