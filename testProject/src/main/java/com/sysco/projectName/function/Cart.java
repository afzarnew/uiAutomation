package com.sysco.projectName.function;

import com.sysco.projectName.page.CartPage;

public class Cart {

    static CartPage cartPage=new CartPage();

    public static void removeItem() throws InterruptedException {
        cartPage.removeItem();
    }

    public static void clickCheckOut() throws InterruptedException {
        cartPage.clickCheckOut();
    }

    public static void clickContinue()  {
        cartPage.clickContinue();
    }

    public static void addItem() throws InterruptedException {
        cartPage.addItem();
    }

    public  static String getCartEmptyMessage(){
        return cartPage.getCartEmptyMessage();
    }

    public  static String getItemName(){
        return cartPage.getItemName();
    }

    public  static String getItemPrice(){
        return cartPage.getItemPrice();
    }


}
