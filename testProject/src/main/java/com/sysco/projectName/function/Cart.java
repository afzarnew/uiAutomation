package com.sysco.projectName.function;

import com.sysco.projectName.page.CartPage;

public class Cart {

    static CartPage cartPage=new CartPage();

    public static void removeItem() {
        cartPage.removeItem();
    }

    public static void clickCheckOut() {
        cartPage.clickCheckOut();
    }

    public static void clickContinue()  {
        cartPage.clickContinue();
    }

    public static void addItem() {
        cartPage.addItem();
    }

    public  static String getCartEmptyMessage(){
        return cartPage.getCartEmptyMessage();
    }

    public  static String getItemName(){
        return cartPage.getItemName();
    }

    public  static String getItemNameFromList(){
        return cartPage.getItemNameFromList();
    }

    public  static String getItemPriceFromList(){
        return cartPage.getItemPriceFromList();
    }

    public  static String getItemPrice(){
        return cartPage.getItemPrice();
    }


}
