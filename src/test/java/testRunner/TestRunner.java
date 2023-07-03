
package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@Listeners(TestListener.class)
@CucumberOptions(
		features = "src/test/java/features/noBroker.feature",
		glue = "steps",
		snippets = SnippetType.CAMELCASE,
		monochrome = true
		//plugin = "src/test/java/steps/TestListener.java"
		)

public class TestRunner extends AbstractTestNGCucumberTests {

}

