package stepDefs;


import com.appiancorp.ps.automatedtest.fixture.BaseFixture;

import com.appiancorp.ps.cucumber.fixtures.CucumberBaseFixture;
import com.appiancorp.ps.cucumber.fixtures.CucumberTempoFixture;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import cucumber.api.java.en.Given;
import io.cucumber.java.en.*;

import java.util.UUID;

public class SDTFixtures {
		
	private CucumberTempoFixture cucumberTempoFixture = new CucumberTempoFixture();
    private CucumberBaseFixture fixture = new CucumberBaseFixture();
    public static WebDriver driver = null;
    
    private static final String TEST_VAR_PREFIX = "tv!";
    private String dummyFilePath = "C:\\appian\\cucumber\\Note.txt";
		
    @Given("^I populate rich text editor field \"([^\"]*)\" with value \"([^\"]*)\"$")
	public void iPopulateRichTextEditorFieldWithValue(String fieldName, String fieldValue) throws Exception {
		String value = fieldValue;
		
		// Support test variables
		if(fieldValue.startsWith(TEST_VAR_PREFIX)) {
			value = fixture.getTestVariable(fieldValue);
		}
		
		WebDriver driver = CucumberTempoFixture.getSettings().getDriver();
		
		// Find iframe for Rich Text Editor component plugin with label arg0
		WebElement iframe = findComponentPluginIframe(driver, fieldName);
		
		// Switch driver to selected iframe
		driver.switchTo().frame(iframe);
		
		// Find editor div within Rich Text Editor field
		WebElement input = driver.findElement(By.xpath("//div/div[2]/div[1]"));
		
		// Click into editor
		input.click();
		
		// Send value
		input.sendKeys(value);
		
		// Switch driver back to main content
		driver.switchTo().defaultContent();
	}
	
	@Given("^I populate file upload field \"([^\"]*)\" with a dummy document$")
    public void populateFileUploadFieldWithDummyDoc(String fieldName) {
		cucumberTempoFixture.populateFieldWith("FILE_UPLOAD", fieldName, dummyFilePath);
    }

    @io.cucumber.java.en.Given("I set test variable {string} with random UUID")
    public void iSetTestVariableWithRandomUUID(String arg0) {
        fixture.setTestVariableWith(arg0, UUID.randomUUID().toString());
    }

    @Given("^I click on card with bold label \"([^\"]*)\"$")
    public void clickOnCardWithBoldLabel(String boldLabel) {
        WebElement link = CucumberTempoFixture.getSettings().getDriver().findElement(By.xpath("//strong[contains(text(),'" + boldLabel + "')]"));
        link.click();
    }
    
    @Given("^I click on image index \"([^\"]*)\"$")
    public void iClickOnImageIndex(String index) {
    	// Index is already in format "[1]"
        WebElement link = CucumberTempoFixture.getSettings().getDriver().findElement(By.xpath("(//div[contains(@class, 'ImageGroup---image_gallery')])" + index));
        link.click();
    }
    
    @Given("^I populate field xpath \"([^\"]*)\" with \"([^\"]*)\"$")
    public void iPopulateFieldXpathWith(String arg0, String arg1) throws Throwable {
        WebElement input = CucumberTempoFixture.getSettings().getDriver().findElement(By.xpath(arg0));
        input.sendKeys(arg1);
    }
    
    /*************************************
     * OTHER EXAMPLE METHODS
     *************************************/
    
    @Given("^I click on spanCardLayout \"([^\"]*)\"$")
    public void iClickOnRiskratingCardLayout(String spanCard) {
        WebElement link = CucumberTempoFixture.getSettings().getDriver().findElement(By.xpath("//span[contains(text(),'" + spanCard + "')]"));
        link.click();
    }

    @Given("^I populate field type \"([^\"]*)\" with quotes named \"(.*)\" with \"([^\"]*)\"$")
    public void iPopulateFieldTypeNamedTradingContainingQuotesAsWith(String arg0, String arg1, String arg2) {
        cucumberTempoFixture.populateFieldWith(arg0, arg1, arg2);
    }

    @Given("^I populate with quotes field \"(.*)\" with \"([^\"]*)\"$")
    public void iPopulateWithQuotesFieldWith(String arg0, String arg1) {
        cucumberTempoFixture.populateFieldWith(arg0, arg1);
    }


    @Given("^I click on add Icon \"([^\"]*)\"$")
    public void iClickOnAddIcon(String icon) {
        WebElement link = CucumberTempoFixture.getSettings().getDriver().findElement(By.xpath("//*[@viewBox='" + icon + "']"));
        link.click();
    }


    @Given("^I set test variable \"([^\"]*)\" with get web api \"([^\"]*)\" with role \"([^\"]*)\"$")
    public void iSetTestVariableWithGetWebApiWithBodyWithRole(String key, String webApiEndpoint, String role) {
        BaseFixture cucumberBaseFixture = new BaseFixture();
        String resultBody = cucumberBaseFixture.getWebApiWithRole(webApiEndpoint, role);
        cucumberBaseFixture.setTestVariableWith(key, resultBody);

    }

    @Given("^I Get value from screen$")
    public void iGetValueFromScreen() {
        WebElement firstName = driver.findElement(By.xpath("//h1[@class='FormLayout---title']"));
        String value = firstName.getTagName();
        System.out.println(value);
    }

    @Given("^I click on add OwnerIcon$")
    public void iClickOnAddOwnerIcon() {
        WebElement link = CucumberTempoFixture.getSettings().getDriver().findElement(By.xpath("//*[@id=\"sitesBody\"]/div/div/div/div[1]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div[2]/div/div[1]/div[2]/div/div[2]/div"));
        link.click();
    }

    @Given("^I collapse/expand boxLayout$")
    public void iCollapseExpandBoxLayout() {
        WebElement link = CucumberTempoFixture.getSettings().getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/main/div/div/div/div/div/div/div/div/div[2]/div[1]"));
        link.click();
    }


    @io.cucumber.java.en.Then("I see home page")
    public void iSeeHomePage() {
        WebElement firstName = CucumberTempoFixture.getSettings().getDriver().findElement(By.xpath("//*[@id=\"XrayComponentSelectionManager\"]/div/div[1]/div[2]/div/p/span"));
        String value = firstName.getTagName();
        System.out.println(value);
    }


    
    /*************************************
     * PRIVATE HELPERS
     *************************************/
    
    private WebElement findComponentPluginIframe(WebDriver driver, String fieldName) {
		// Find iframe within the component plugin with label fieldName
		return driver.findElement(By.xpath("//label[text() = '" + fieldName + "']/ancestor::div[contains(@class, 'FieldLayout---field_layout')]//iframe"));
	}

    @When("I populate username with {string}")
    public void iPopulateUsernameWith(String arg0) {
        WebElement input = CucumberTempoFixture.getSettings().getDriver().findElement(By.xpath("//*[@id=\"un\"]"));
        input.sendKeys(arg0);
    }

    @When("I populate password with {string}")
    public void iPopulatePasswordWith(String arg0) {
        WebElement input = CucumberTempoFixture.getSettings().getDriver().findElement(By.xpath("//*[@id=\"pw\"]"));
        input.sendKeys(arg0);
    }


    @And("I click Sign In Button")
    public void iClickSignInButton() {
        WebElement link = CucumberTempoFixture.getSettings().getDriver().findElement(By.xpath("/html/body/div[4]/div/form[2]/div[4]/div/div[2]/input"));
        link.click();
    }

    @Given("I am on Sign In Page")
    public void i_am_on_sign_in_page() {
        // Write code here that turns the phrase above into concrete actions
        CucumberTempoFixture.getSettings().getDriver().navigate().to("https://techtamminaapps.appiancloud.com/suite/portal/login.jsp");
    }

}
