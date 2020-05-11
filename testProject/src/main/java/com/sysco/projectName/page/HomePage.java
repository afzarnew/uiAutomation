package com.sysco.projectName.page;

import com.sysco.projectName.common.Constants;
import com.sysco.projectName.util.DriverEnvironmentSetUpUtil;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;

public class HomePage {
    protected static SyscoLabUI syscoLabUI;

    private By btnLogin = By.xpath("//*[@class='authorization-link -notlogin']/a");
    private By btnLoginToAccount = By.xpath("//*[@class='action login primary']");
    private By txtBoxEmail = By.xpath("//*[@id=\"email\"]");
    private By txtBoxPassword = By.xpath("//*[@id=\"pass\"]");
    private By errorMessageForInvalidEmail = By.xpath("//DIV[@id='email-error']");
    private By errorMessageForEmptyPassowrd = By.xpath("//DIV[@id='pass-error']");

    public void openSite(){
        DriverEnvironmentSetUpUtil.setToRunLocally();
        syscoLabUI= new SyscoLabWUI(null);
        syscoLabUI.navigateTo(Constants.SITE_URL);
        syscoLabUI.driver.manage().window().maximize();
    }

    public void clickLogin(){
        syscoLabUI.click(btnLogin);
    }

    public void clickLoginToAccount(){
        syscoLabUI.click(btnLoginToAccount);
    }

    public void enterUserDetails(String email,String password){
        syscoLabUI.sendKeys(txtBoxEmail, email);
        syscoLabUI.sendKeys(txtBoxPassword, password);
    }

    public boolean checkLoginButtonAvailable(){
        syscoLabUI.waitTillElementLoaded(btnLoginToAccount);
        return syscoLabUI.isDisplayed(btnLoginToAccount);
    }

    public String errorMessageForInvalidEmail(){
        return syscoLabUI.getText(errorMessageForInvalidEmail);
    }

    public String errorMessageForEmptyPassowrd(){
        return syscoLabUI.getText(errorMessageForEmptyPassowrd);
    }

    public void quitDriver(){
        syscoLabUI.quit();
    }
}
