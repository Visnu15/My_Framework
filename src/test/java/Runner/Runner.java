package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
//import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin = {"pretty"},
            features = {"./Feature"},
            dryRun = !true,
            snippets = SnippetType.CAMELCASE,
            glue = "Steps",
            monochrome = true
    )
    public class Runner{

    }
