package com.sysco.projectName.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class CartPage extends DashboardPage {

    private By removeButton = By.xpath("(//*[@class=\"svg-icon\"])[7]");
    private By removeConfirmButton = By.xpath("//*[@class=\"modal-footer\"]/button[2]/span");
    private By cartEmptyMessage = By.xpath("//*[@class=\"text -subtitle\"]/span");
    private By frame = By.xpath("(//*[@class=\"modal-inner-wrap\"])[2]");
    private By buttonMenCategory = By.xpath("//*[@class=\"page-header\"]/div[2]/nav/ul/li[2]");
    private By buttonAdidas = By.xpath("//*[@id=\"mi-3-2-2-1\"]");
    private By buttonAddToCart = By.xpath("//BUTTON[@id='product-addtocart-button']");
    private By buttonSelectSize = By.xpath("//*[@class=\"swatch-attribute size_us_mens\"]/div[2]/div[4]/div[12]");
    private By firstItem = By.xpath("//*[@class=\"product-image-wrapper\"]/div/img");
    private By itemName = By.xpath("//*[@class=\"minicart-product-details\"]/strong/a");
    private By itemPrice = By.xpath("//*[@class=\"price-including-tax\"]");
    private By buttonCheckOut = By.xpath("(//BUTTON[@type='button'])[4]");
    private By buttonContinue = By.xpath("(//*[@class=\"button -primary -expanded\"])[1]");
    private By firstName = By.xpath("(//*[@class=\"input-text\"])[1]");

    public void removeItem() throws InterruptedException {
        syscoLabUI.waitTillElementLoaded(removeButton);
        boolean i = (syscoLabUI.isDisplayed(removeButton));
        System.out.print(i);
        while (i==true) {
            syscoLabUI.click(removeButton);
            syscoLabUI.waitTillElementLoaded(removeConfirmButton);
            JavascriptExecutor executor = (JavascriptExecutor)syscoLabUI.driver;
            executor.executeScript("arguments[0].click();", syscoLabUI.driver.findElement(By.xpath("//span[text()='OK']")));
            syscoLabUI.sleep(6);
            i= (syscoLabUI.isDisplayed(removeButton));
        }
    }

    public void addItem(){
        syscoLabUI.click(buttonMenCategory);
        syscoLabUI.scrollToElement(buttonAdidas);
        syscoLabUI.click(buttonAdidas);
        syscoLabUI.waitTillElementLoaded(firstItem);
        syscoLabUI.click(firstItem);
        syscoLabUI.waitTillElementLoaded(buttonAddToCart);
        syscoLabUI.click(buttonSelectSize);
        syscoLabUI.click(buttonAddToCart);

    }

    public String getCartEmptyMessage(){
        return syscoLabUI.getText(cartEmptyMessage);
    }

    public String getItemName(){
        syscoLabUI.waitTillElementLoaded(itemName);
        return syscoLabUI.getText(itemName);
    }

    public String getItemPrice(){
        return syscoLabUI.getText(itemPrice);
    }


    public void clickCheckOut(){
        syscoLabUI.click(buttonCheckOut);
        syscoLabUI.waitTillElementLoaded(firstName);
    }

    public void clickContinue(){
        syscoLabUI.click(buttonContinue);
    }

}