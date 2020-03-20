package com.example.cucu;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber.json"},
        glue = "com.example.cucu",
        features = {"classpath:features"}
)
public class CucumberRunnerTest {
}
