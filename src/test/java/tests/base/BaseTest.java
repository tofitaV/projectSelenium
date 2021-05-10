package tests.base;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import steps.common.BaseSteps;
import utils.ManagerWebDriver;

import java.sql.SQLException;

public class BaseTest {

    BaseSteps steps;
    private ManagerWebDriver webDriverManager;
    protected WebDriver driver;

    public BaseSteps start() {
        return steps;
    }

    @BeforeClass
    public void setUp() {
        webDriverManager = new ManagerWebDriver();
        driver = webDriverManager.startDriver();
        steps = new BaseSteps(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        webDriverManager.stopDriver();
    }
}
