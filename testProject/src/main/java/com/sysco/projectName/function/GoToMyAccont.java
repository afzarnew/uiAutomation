package com.sysco.projectName.function;

import com.sysco.projectName.page.HomePage;

public class GoToMyAccont {

    static HomePage homePage = new HomePage();
    public static void goToHome(){
        homePage.openSite();
    }

    public static void clickLogin(){
        homePage.clickLogin();
    }

    public static void clickLoginToAccount(){
        homePage.clickLoginToAccount();
    }

    public static void enterUserDetails (String email,String password){
        homePage.enterUserDetails(email,password);
    }

    public static boolean checkLoginButtonAvailable(){
        return homePage.checkLoginButtonAvailable();
    }

    public  static String errorMessageForInvalidEmail(){
        return homePage.errorMessageForInvalidEmail();
    }

    public  static String errorMessageForEmptyPassowrd(){
        return homePage.errorMessageForEmptyPassowrd();
    }

    public static void quitDriver(){
        homePage.quitDriver();
    }
}
