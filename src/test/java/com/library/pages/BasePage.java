package com.library.pages;

import com.library.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

@FindBy(css="img#user_avatar ~ span")
public WebElement accountHolderName;

    @FindBy(linkText = "Log Out")
    public WebElement log_out_link;

    public void logOut(){
        accountHolderName.click();
        log_out_link.click();
    }

    public void navigateModule(String moduleName){
Driver.getDriver().findElement(By.xpath("//span[@class='title'][.='"+moduleName+"']")).click();
    }
}
