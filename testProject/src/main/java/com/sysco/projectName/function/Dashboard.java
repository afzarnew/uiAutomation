package com.sysco.projectName.function;

import com.sysco.projectName.page.DashboardPage;

public class Dashboard {

    static DashboardPage dashboardPage=new DashboardPage();

    public  static String getUserName(){
        return dashboardPage.getUserName();
    }

    public static void clickCart(){
        dashboardPage.clickCart();
    }

    public static void closeCart(){
        dashboardPage.closeCart();
    }

}
