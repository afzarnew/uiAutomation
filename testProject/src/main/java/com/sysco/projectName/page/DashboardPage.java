package com.sysco.projectName.page;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;

public class DashboardPage extends HomePage {

    private By lblUserName = By.xpath("(//*[@class=\"name\"])[1]/span");
    private By iconCart = By.xpath("(//*[@class=\"svg-icon\"])[5]");
    private By iconCloseCart = By.xpath("//*[@class=\"close\"]");

    public String getUserName(){
        syscoLabUI.waitTillElementLoaded(lblUserName);
        return syscoLabUI.getText(lblUserName);
    }

    public void clickCart(){
        syscoLabUI.click(iconCart);
    }

    public void closeCart(){
        syscoLabUI.click(iconCloseCart);
    }

}
