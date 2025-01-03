package automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class testCase01 {
    @Test
    public void testCase01() {
        //Test Case 1: Register User
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement autoExerciseLogoElement = Driver.getDriver().findElement(By.xpath("//img[@alt='Website for automation practice']"));
        Assert.assertTrue(autoExerciseLogoElement.isDisplayed());

        //4. Click on 'Signup / Login' button
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//*[@href='/login']"));
        loginButton.click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignUpText = Driver.getDriver().findElement(By.xpath("//div[@class=\"signup-form\"]"));
        Assert.assertTrue(newUserSignUpText.isDisplayed());

        //6. Enter name and email address
        WebElement nameBox = Driver.getDriver().findElement(By.xpath("//input[@type='text']"));
        nameBox.sendKeys("test" + Keys.TAB);
        WebElement newAccountEmailBox = Driver.getDriver().findElement(By.xpath("(//input[@name='email'])[2]"));
        newAccountEmailBox.sendKeys("test55566447@hotmail.com");

        //7. Click 'Signup' button
        WebElement signUpButton = Driver.getDriver().findElement(By.xpath("//button[@data-qa='signup-button']"));
        signUpButton.click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInformationText = Driver.getDriver().findElement(By.xpath("(//h2[@class='title text-center'])[1]"));
        Assert.assertTrue(enterAccountInformationText.isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement genderMale = Driver.getDriver().findElement(By.id("id_gender1"));
        genderMale.click();

        WebElement pwBox = Driver.getDriver().findElement(By.id("password"));
        pwBox.sendKeys("test321");

        ReusableMethods.bekle(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.keyDown(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);

        WebElement selectDay = Driver.getDriver().findElement(By.id("days"));
        Select day = new Select(selectDay);
        day.selectByVisibleText("5");

        WebElement selectMont = Driver.getDriver().findElement(By.id("months"));
        Select months = new Select(selectMont);
        months.selectByVisibleText("April");

        WebElement year = Driver.getDriver().findElement(By.id("years"));
        Select selectYear = new Select(year);
        selectYear.selectByVisibleText("2005");

        ReusableMethods.bekle(2);
        actions.keyDown(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);

        //10. Select checkbox 'Sign up for our newsletter!'
        WebElement signUpNewsletterCheckbox = Driver.getDriver().findElement(By.id("newsletter"));
        signUpNewsletterCheckbox.click();

        //11. Select checkbox 'Receive special offers from our partners!'
        WebElement receiveSpecialCheckbox = Driver.getDriver().findElement(By.id("optin"));
        receiveSpecialCheckbox.click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstnameBox = Driver.getDriver().findElement(By.id("first_name"));
        firstnameBox.sendKeys("john");
        WebElement lastnameBox = Driver.getDriver().findElement(By.id("last_name"));
        lastnameBox.sendKeys("doe");

        ReusableMethods.bekle(2);
        actions.keyDown(Keys.PAGE_DOWN).perform();


        WebElement adressBox = Driver.getDriver().findElement(By.id("address1"));
        adressBox.sendKeys("Turkey/Adana");

        WebElement country = Driver.getDriver().findElement(By.id("country"));
        Select select = new Select(country);
        select.selectByVisibleText("Canada");

        WebElement stateBox = Driver.getDriver().findElement(By.id("state"));
        stateBox.sendKeys("Adana");

        ReusableMethods.bekle(2);
        actions.keyDown(Keys.PAGE_DOWN).perform();


        WebElement cityNameBox = Driver.getDriver().findElement(By.id("city"));
        cityNameBox.sendKeys("Ceyhan");

        WebElement zipCodeBox = Driver.driver.findElement(By.id("zipcode"));
        zipCodeBox.sendKeys("123456");

        WebElement mobilNumberBox = Driver.getDriver().findElement(By.id("mobile_number"));
        mobilNumberBox.sendKeys("5553332145");

        ReusableMethods.bekle(2);
        actions.keyDown(Keys.PAGE_DOWN).perform();

        //13. Click 'Create Account button'
        WebElement createAccountButton = Driver.getDriver().findElement(By.xpath("//button[@data-qa='create-account']"));
        createAccountButton.click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreatedText = Driver.getDriver().findElement(By.xpath("//h2[@class='title text-center']")); // //h2[@class="title text-center"]
        Assert.assertTrue(accountCreatedText.isDisplayed());

        //15. Click 'Continue' button
        WebElement continueButton = Driver.getDriver().findElement(By.xpath("//*[@class='btn btn-primary']"));
        continueButton.click();

        //17. Click 'Delete Account' button
        WebElement deleteAccountButton = Driver.getDriver().findElement(By.xpath("//a[text()=' Delete Account']"));
        deleteAccountButton.click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accountDeletedText = Driver.getDriver().findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(accountDeletedText.isDisplayed());

        Driver.quitDriver();
    }

}
