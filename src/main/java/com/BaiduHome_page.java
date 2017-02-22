package com;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaiduHome_page {

    public WebDriver driver;

    public BaiduHome_page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //�ٶ�logo
    @FindBy(id="su")
    public WebElement ElementBaiduLogo;

    //�����
    @FindBy(id="kw")
    public WebElement ElementBaiduInput;

    //��ť ��ѯһ��
    @FindBy(id="su")
    public WebElement ElementSubmit;


    //��ȡ��ǰҳ�����м��Ϣ ԤԼ����
    public String getPageTitle(){
        return driver.getTitle();
    }

    // �����ѯ���ݣ��������ѯ��ť
    public void enterSearch(String searchText){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(ElementBaiduInput));
        ElementBaiduInput.clear();
        ElementBaiduInput.sendKeys(searchText);
        ElementSubmit.click();
    }

    // �����ѯ���ݣ��������ѯ��ť
    public void submit(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(ElementSubmit));
        ElementSubmit.click();
    }
}