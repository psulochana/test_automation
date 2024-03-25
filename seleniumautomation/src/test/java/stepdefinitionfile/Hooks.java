package stepdefinitionfile;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import reusable.BaseCode;

public class Hooks {
    @Before
    public void setup() {
        BaseCode.launchBrowser();
    }

    @After
    public void close() {
        BaseCode.getDriver().close();
    }
}
