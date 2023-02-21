package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.ast.DataTable;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.TechGlobalBasePage;
import pages.TechGlobalFrontendHomePage;
import pages.TechGlobalPaginationPage;
import utils.Driver;

public class TechGlobalPaginationSteps {

    WebDriver driver;
    TechGlobalFrontendHomePage techGlobalFrontendHomePage;
    TechGlobalPaginationPage techGlobalPaginationPage;
    TechGlobalBasePage techGlobalBasePage;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        techGlobalFrontendHomePage = new TechGlobalFrontendHomePage();
        techGlobalPaginationPage = new TechGlobalPaginationPage();
        techGlobalBasePage = new TechGlobalBasePage();
    }
    @Given("user is on {string}")
    public void user_is_on(String url) {
        driver.get(url);
    }

    @When("user moves to Practices header dropdown")
    public void user_moves_to_Practices_header_dropdown() {
        techGlobalBasePage.headerDropdown.click();
    }

    @And("user clicks on Frontend Testing header dropdown option")
    public void user_clicks_on_Frontend_Testing_header_dropdown_option() {
        techGlobalBasePage.headerDropdownOptions.get(0).click();
    }

    @Then("user should be navigated to {string}")
    public void user_should_be_navigated_to(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @And("user clicks on {string} card")
    public void user_clicks_on_card(String cardName) {
        techGlobalFrontendHomePage.clickOnCard(cardName);
    }



    @And("user should see {string} heading")
    public void user_should_see_heading(String heading) {
        switch (heading){
            case "Pagination":
                Assert.assertEquals(heading, techGlobalPaginationPage.mainHeading.getText());
                break;
            case "World City Populations 2022":
                Assert.assertEquals(heading, techGlobalPaginationPage.subHeading.getText());
                break;
            default:
                throw  new NotFoundException("This is invalid heading text");
        }
    }

    @And("user should see {string} paragraph")
    public void user_should_see_paragraph(String paragraph) {
        Assert.assertEquals(paragraph, techGlobalPaginationPage.paragraph.getText());
    }

    @And("user should see {string} button is disabled")
    public void user_should_see_button_is_disabled(String button) {
        switch (button){
            case "Previous":
                Assert.assertFalse(techGlobalPaginationPage.previousButton.isEnabled());
                break;
            case "Next":
                Assert.assertFalse(techGlobalPaginationPage.nextButton.isEnabled());
                break;
            default:
                throw  new NotFoundException("This is invalid button!");
        }
    }

    @And("user should see {string} button is enabled")
    public void user_should_see_button_is_enabled(String button) {
        switch (button){
            case "Previous":
                Assert.assertTrue(techGlobalPaginationPage.previousButton.isEnabled());
                break;
            case "Next":
                Assert.assertTrue(techGlobalPaginationPage.nextButton.isEnabled());
                break;
            default:
                throw  new NotFoundException("This is invalid button!");
        }
    }

    @When("user clicks on Next button")
    public void user_clicks_on_Next_button() {
        techGlobalPaginationPage.nextButton.click();
    }
    @When("user clicks on Next button till it becomes disabled")
    public void user_clicks_on_Next_button_till_it_becomes_disabled() {
        while (techGlobalPaginationPage.nextButton.isEnabled()){
            techGlobalPaginationPage.nextButton.click();
        }
    }

    /*@And("user should see city with info below and an image")
    public void userShouldSeeCityWithInfoBelowAndAnImage(DataTable info) {
        Assert.assertTrue(techGlobalPaginationPage.image.isDisplayed());
        for (int i = 0; i < info.asList.size(); i++){
            Assert.assertEquals(techGlobalPaginationPage.text.get(i).getText(), info.asList().get(i));
        }
        techGlobalPaginationPage.nextButton.click();

     */
    }




