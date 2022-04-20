package step_definitions;

import Pages.P7_FilterColorPageElements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BrowserUtils;

import java.util.concurrent.TimeUnit;

public class C7_FilterColorStepDefinitions {

    P7_FilterColorPageElements color = Hooks.PageBase.p7_filterColorPageElementsPOM();

    @Given("logged user selects Category and hover to open sub-Category")
    public void select_Category() {
        color.colorSelProdEle();
        BrowserUtils.waitFor(2);
    }

    @When("logged user can filter sub-Category with color")
    public void Filter_color()
    {
        color.colorFilterEle();
    }

    @Then("logged user could find product with the selected color")
    public void Find_product_with_selected_color()
    {
        Hooks.driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        color.colorCheckEle();
        System.out.println("Color Selected: Red Shoes");
    }
}
