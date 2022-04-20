package step_definitions;

import Pages.P6_CategoriesPageElements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.BrowserUtils;

import java.util.concurrent.TimeUnit;

public class C6_CategoriesStepDefinitions {

    P6_CategoriesPageElements category = Hooks.PageBase.p6_categoriesPageElementsPOM();

    @Given("user can select Random Category")
    public void select_random_Category() {
        category.categoryRandomEle();
        BrowserUtils.waitFor(2);
    }

    @Then("user could hover and open sub-Category")
    public void open_subCategory()
    {
        category.categorySubEle();
        Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
