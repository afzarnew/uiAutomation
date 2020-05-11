package com.sysco.projectName.util;


import java.util.logging.Logger;

public class DriverEnvironmentSetUpUtil {

    DriverEnvironmentSetUpUtil(){

    }
    public static String chromeDriver = "webdriver.chrome.driver";

    public static void setToRunLocally(){
        System.setProperty(chromeDriver,"src/main/resources/chrome_driver/"+System.getProperty("os.arch")+"/chromedriver");
        Logger.getLogger(System.getProperty(chromeDriver));
    }
}
