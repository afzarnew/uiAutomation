package com.sysco.projectName.function;

import com.sysco.projectName.page.CheckoutPage;

public class Checkout {
    static CheckoutPage checkoutPage=new CheckoutPage();

    public  static String getFirstName(){
        return checkoutPage.getFirstName();
    }

    public  static String getStreetError(){
        return checkoutPage.getStreetError();
    }

    public  static String getSuburbError(){
        return checkoutPage.getSuburbError();
    }

    public  static String getStateError(){
        return checkoutPage.getStateError();
    }

    public  static String getPostCodeError(){
        return checkoutPage.getPostCodeError();
    }

    public  static String getPhoneNumberError(){
        return checkoutPage.getPhoneNumberError();
    }

    public  static String getLastName(){
        return checkoutPage.getLastName();
    }

    public static void enterDeliveryDetails (String street, String phoneNumber){
        checkoutPage.enterDeliveryDetails(street,phoneNumber);
    }

    public static void enterPostalCode (String postalCode){
        checkoutPage.enterPostalCode(postalCode);
    }

    public  static String getPaymentInformationTitle(){
        return checkoutPage.getPaymentInformationTitle();
    }

}
