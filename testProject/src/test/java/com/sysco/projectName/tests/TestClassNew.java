package com.sysco.projectName.tests;

import com.sysco.projectName.data.CartData;
import com.sysco.projectName.data.CheckoutData;
import com.sysco.projectName.data.LoginData;
import com.sysco.projectName.function.Cart;
import com.sysco.projectName.function.Checkout;
import com.sysco.projectName.function.Dashboard;
import com.sysco.projectName.function.GoToMyAccont;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestClassNew {

    static LoginData loginData=new LoginData();
    static CartData cartData=new CartData();
    static CheckoutData checkoutData=new CheckoutData();
    String itemName;
    String itemPrice;
    @Test (priority=1)
    public void verifyMyAccountPage() {
        SoftAssert softAssert = new SoftAssert();
        GoToMyAccont.goToHome();
        GoToMyAccont.clickLogin();
        softAssert.assertTrue(GoToMyAccont.checkLoginButtonAvailable(),loginData.loginButtonNotAvailableMessage);
        softAssert.assertAll();
    }
    @Test (priority=2)
    public void verifyLoginWithInvalidEmail() {
        SoftAssert softAssert = new SoftAssert();
        GoToMyAccont.enterUserDetails(loginData.invalidEmail, loginData.validPassword);
        GoToMyAccont.clickLoginToAccount();
        softAssert.assertEquals(GoToMyAccont.errorMessageForInvalidEmail(), loginData.invalidEmailError);
        softAssert.assertAll();
    }

    @Test (priority=3)
    public void verifyLoginWithEmptyPassword() {
        SoftAssert softAssert = new SoftAssert();
        GoToMyAccont.enterUserDetails(loginData.validEmail, "");
        GoToMyAccont.clickLoginToAccount();
        softAssert.assertEquals(GoToMyAccont.errorMessageForEmptyPassword(),loginData.requiredFieldError);
        softAssert.assertAll();
    }

    @Test (priority=4)
    public void verifyLoginWithEmptyEmail() {
        SoftAssert softAssert = new SoftAssert();
        GoToMyAccont.enterUserDetails("", loginData.validPassword);
        GoToMyAccont.clickLoginToAccount();
        softAssert.assertEquals(GoToMyAccont.errorMessageForInvalidEmail(),loginData.requiredFieldError);
        softAssert.assertAll();
    }

    @Test (priority=5)
    public void verifyLoginWithValidCredentials() {
        SoftAssert softAssert = new SoftAssert();
        GoToMyAccont.enterUserDetails(loginData.validEmail, loginData.validPassword);
        GoToMyAccont.clickLoginToAccount();
        softAssert.assertEquals(Dashboard.getUserName(),loginData.userName);
        softAssert.assertAll();
    }

    @Test (priority=6)
    public void removeItem() {
        SoftAssert softAssert = new SoftAssert();
        Dashboard.clickCart();
        Cart.removeItem();
        softAssert.assertEquals(Cart.getCartEmptyMessage(),cartData.cartEmptyMessage);
        softAssert.assertAll();
        Dashboard.closeCart();
    }

    @Test (priority=7)
    public void addRandomItem() {
        Cart.addItem();
        itemName= Cart.getItemNameFromList();
        itemPrice= Cart.getItemPriceFromList();
    }

    @Test (priority=8)
    public void verifyItemPriceAndName() {
        SoftAssert softAssert = new SoftAssert();
        Dashboard.clickCart();

        softAssert.assertEquals(Cart.getItemName(),itemName);
        softAssert.assertEquals(Cart.getItemPrice(),itemPrice);
        softAssert.assertAll();
    }

    @Test (priority=9)
    public void verifyCheckOutPage() {
        SoftAssert softAssert = new SoftAssert();
        Cart.clickCheckOut();
        System.out.print(Checkout.getFirstName());
        softAssert.assertEquals(Checkout.getFirstName(),checkoutData.firstName);
        softAssert.assertEquals(Checkout.getLastName(),checkoutData.lastName);
        softAssert.assertAll();
    }

    @Test (priority=10)
    public void validateContinueButton() {
        SoftAssert softAssert = new SoftAssert();
        Cart.clickContinue();
        softAssert.assertEquals(Checkout.getStreetError(),checkoutData.requiredFieldError);
        softAssert.assertEquals(Checkout.getSuburbError(),checkoutData.requiredFieldError);
        softAssert.assertEquals(Checkout.getStateError(),checkoutData.requiredFieldError);
        softAssert.assertEquals(Checkout.getPostCodeError(),checkoutData.requiredFieldError);
        softAssert.assertEquals(Checkout.getPhoneNumberError(),checkoutData.requiredFieldError);
        softAssert.assertAll();
    }

    @Test (priority=11)
    public void verifyPaymentDetails() {
        SoftAssert softAssert = new SoftAssert();
        Checkout.enterPostalCode(checkoutData.postalCode);
        Checkout.enterDeliveryDetails(checkoutData.street, checkoutData.phoneNumber);
        Cart.clickContinue();
        softAssert.assertEquals(Checkout.getPaymentInformationTitle(),checkoutData.paymentInfoTitle);
        softAssert.assertAll();
        GoToMyAccont.quitDriver();
    }

}
