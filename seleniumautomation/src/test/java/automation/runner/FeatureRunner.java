package automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/featurefile"},
        glue = {"stepdefinitionfile"},
        tags = "@ProblemStatement2_Chrome",
        plugin = {"pretty"}
)
public class FeatureRunner {
}
