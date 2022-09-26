package StepDefinitions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		//path of feature file
		tags = "@Regression_scenario1 or @Regression_scenario2 or @Regression_scenario3",
		features = "src/test/resources/Features/buggylogin.feature",
		glue = "StepDefinitions" ,
		plugin = { "pretty", "html:target/cucumber-reports/Report.html" },
		monochrome = true

		)

public class RunnerClass {

}
