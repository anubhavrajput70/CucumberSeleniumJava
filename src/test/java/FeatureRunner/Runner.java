package FeatureRunner;
//we can also create the multiple runner classes for the targeted features files for different folders
//we can run any number of runner classes with the help of the testng xml file
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue= {"StepDefinitions"},

		monochrome=true,
		plugin={"pretty","html:target/HtmlReport"},
		tags="@login" 
		)

public class Runner {

}
