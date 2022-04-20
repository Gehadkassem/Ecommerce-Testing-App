package step_definitions;

import Pages.P8_SelectTagsPageElements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class C8_SelectTagsStepDefinitions {

    P8_SelectTagsPageElements tagsSelect = Hooks.PageBase.p8_selectTagsPageElementsPOM();

    @Given("logged user can select a popular tag")
    public void select_popular_tag()
    {
        tagsSelect.tag1SelectEle();
        Hooks.driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        String expectedResult = "Products tagged with 'cool'";
        Assert.assertEquals(tagsSelect.tag1SelectEle(), expectedResult, "Assertion False: ");
        System.out.println("Products tagged with 'cool'");
    }

    @When("logged user finds products")
    public void find_products()
    {
        tagsSelect.tag1CountEle();
    }

    @Then("logged user could select a different tag")
    public void select_a_different_tag()
    {
        tagsSelect.tag2SelectEle();
        Hooks.driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        String expectedResult = "Products tagged with 'shirt'";
        Assert.assertTrue(tagsSelect.tag2SelectEle().contains(expectedResult), "Error Message: There are No Products");
        System.out.println("Products tagged with 'shirt'");
    }

    @And("logged user finds another different products")
    public void find_another_different_products()
    {
        tagsSelect.tag2CountEle();
    }
}
