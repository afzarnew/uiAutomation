package com.sysco.projectName.page;

import org.openqa.selenium.By;

public class CheckoutPage extends CartPage {
    private By firstName = By.xpath("(//*[@class=\"input-text\"])[1]");
    private By lastName = By.xpath("(//*[@class=\"input-text\"])[2]");
    private By streetError = By.xpath("(//*[@class=\"field-error mage-error\"])[1]/span");
    private By suburbError = By.xpath("(//*[@class=\"field-error mage-error\"])[2]/span");
    private By stateError = By.xpath("(//*[@class=\"field-error mage-error\"])[3]/span");
    private By postCodeError = By.xpath("(//*[@class=\"field-error mage-error\"])[4]/span");
    private By phoneNumberError = By.xpath("(//*[@class=\"field-error mage-error\"])[5]/span");
    private By txtBoxStreet = By.xpath("//div[@id='shipping-new-address-form']/fieldset//span[text()='Street Address Line 1']/../following-sibling::div/input");
    private By txtBoxSuburb = By.xpath("(//*[@class=\"field _required _error\"])[2]/label");
    private By txtBoxState = By.xpath("(//*[@class=\"field _required _error\"])[3]/label");
    private By txtBoxPostalCode = By.xpath("(//*[@class=\"input-text\"])[8]");
    private By txtBoxPhoneNumber = By.xpath("//div[@id='shipping-new-address-form']/div//label/span[text()='Phone Number']/../following-sibling::div/input");
    private By getPaymentInformationTitle = By.xpath("//*[@id=\"co-payment-form\"]/fieldset/legend/span");
    private By selectPostalCode = By.xpath("(//*[@class=\"item ui-menu-item\"])[1]/a");

    public String getFirstName(){
        return syscoLabUI.getAttribute(firstName, "value");
    }

    public String getStreetError(){
        return syscoLabUI.getText(streetError);
    }

    public String getSuburbError(){
        return syscoLabUI.getText(suburbError);
    }

    public String getStateError(){
        return syscoLabUI.getText(stateError);
    }

    public String getPostCodeError(){
        return syscoLabUI.getText(postCodeError);
    }

    public String getPhoneNumberError(){
        return syscoLabUI.getText(phoneNumberError);
    }

    public String getPaymentInformationTitle(){
        syscoLabUI.waitTillElementLoaded(getPaymentInformationTitle);
        return syscoLabUI.getText(getPaymentInformationTitle);
    }

    public String getLastName(){
        return syscoLabUI.getAttribute(lastName, "value");
    }

    public void enterDeliveryDetails(String street, String phoneNumber){
        syscoLabUI.sendKeys(txtBoxStreet, street);
        syscoLabUI.sendKeys(txtBoxPhoneNumber, phoneNumber);
    }

    public void enterPostalCode(String postalCode){
        syscoLabUI.sendKeys(txtBoxPostalCode, postalCode);
        syscoLabUI.sleep(3);
        syscoLabUI.click(selectPostalCode);
        syscoLabUI.sleep(4);
    }

}
