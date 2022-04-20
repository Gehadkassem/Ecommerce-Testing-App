package step_definitions;

import Pages.P12_OrderCheckPageElements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BrowserUtils;


public class C12_OrderCheckoutStepDefinitions {

    P12_OrderCheckPageElements checkout = Hooks.PageBase.p12_orderCheckPageElementsPOM();

    @Given("user agrees with terms and proceed to Checkout")
    public void proceed_to_Checkout() 
    {
       checkout.checkoutProceedEle();
       System.out.println("Welcome in Checkout Page!");
    }

    public static String city = "Cairo";
    public static String address1 = "Shoubra";
    public static String postCode = "99999";
    public static String phoneNo = "01014338599";
    public static String faxNo = "12345678";
    public static String cardHolderName = "Gehad Kassem";
    public static String cardNumber = "9999999999";
    public static String cardCode = "999";

    @When("user fills out Billing address to Create Order")
    public void fill_out_Billing_address()
    {
        checkout.checkoutFillDataEle(C1_RegistrationStepDefinitions.FirstName, C1_RegistrationStepDefinitions.LastName,
                C1_RegistrationStepDefinitions.email,city, address1,
                postCode, phoneNo, faxNo);
    }

    @And("user confirms Billing address")
    public void confirms_Billing_address() {
        checkout.checkoutBillAddSaveEle();
        BrowserUtils.waitFor(2);
    }

    @And("user selects Shipping Method to Continue")
    public void select_Shipping_Method_and_Continue() {
        // Select Shipping Method and Continue using POM //
        checkout.checkoutShipMethEle();
        BrowserUtils.waitFor(2);
    }

    @And("user selects Payment Method to Continue")
    public void select_Payment_Method() {
        checkout.checkoutPayMethEle();
        BrowserUtils.waitFor(2);
    }

    @When("user fills out Payment Information")
    public void Fill_out_Payment_Information()
    {
        checkout.checkoutPayDataEle(cardHolderName, cardNumber, cardCode);
        System.out.println("Create Successful Order!");
    }

    @Then("user could confirm his order")
    public void Confirm_Order()
    {
        checkout.checkoutConfirmOrderEle();
        System.out.println("Your order has been successfully processed!");
    }

    @And("user can check order details")
    public void check_order_details()
    {
        checkout.checkoutInvoiceEle();
    }

    @And("user could save invoice")
    public void Save_Invoice() {
        checkout.checkoutInvoiceSaveEle();
        BrowserUtils.waitFor(3);
        System.out.println("PDF Invoice has been downloaded Successfully");
    }

    @And("user could print invoice")
    public void Print_Invoice() {
        checkout.checkoutInvoicePrintEle();
        BrowserUtils.waitFor(3);
        System.out.println("Invoice has been printed Successfully");
    }
}
