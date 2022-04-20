package step_definitions;

import Pages.P11_ShoppCartPageElements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class C11_ShoppingCartStepDefinitions {

    P11_ShoppCartPageElements shoppCart = Hooks.PageBase.p11_shoppCartPageElementsPOM();

    @Given("user checks all his Wishlist products")
    public void Check_Wishlist_products()
    {
        shoppCart.shoppCartProdsCheckEle();
    }

    @Then("user could add his Wishlist products to Shopping Cart")
    public void add_Wishlist_products_to_Shopping_Cart()
    {
        shoppCart.shoppCartADDEle();
        System.out.println("Elements in SKU are present in Shopping Cart");

    }
}
