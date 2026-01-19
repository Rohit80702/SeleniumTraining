package Test_Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/Features",
    glue = {"Step_Definition", "Hooks"}, 
    tags = "@smoke",
    monochrome = true,
    plugin = {"junit:target/JunitReports/report.xml"}
)
public class TestRunnerJUnit {
    
}
