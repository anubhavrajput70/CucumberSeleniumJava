package FeatureRunner;
//we can also create the multiple runner classes for the targeted features files for different folders
//we can run any number of runner classes with the help of the testng xml file
//surefire is a plugin which gives us the capability to run the project through command line
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue= {"StepDefinitions"},

		monochrome=true,
		plugin={"pretty","html:target/HtmlReport","json:target/JsonReport.json","com.cucumber.listener.ExtentCucumberFormatter:target/report.html"},
		tags="@login" 
		)

public class Runner {

}
