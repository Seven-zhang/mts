package com.ctsi.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Login {
	//private WebDriver driver;	
	@FindBy(name="name")
	private WebElement loginname;	
	@FindBy(name="PASSWD")
	private WebElement password;
	@FindBy(name="PROVINCECODE")
	private WebElement provcode;
	@FindBy(name="randNum")
	private WebElement randNum;
	@FindBy(name="login")
	private WebElement login;
	
	public Login(WebDriver driver){
		//this.driver=driver;
		PageFactory .initElements(driver, this);
	}
	//登录用户名
	public void inputName(String name){
		loginname.clear();
		loginname.sendKeys(name);
	}
	//登录密码
	public void inputPaasWd(String passwd){
		password.clear();
		password.sendKeys(passwd);
	}
	//选择区域
		public void choiceArea(String area){
			Select drpCountry = new Select(provcode);
		    drpCountry.selectByVisibleText(area);			
		}
	//输入验证码
		public void inputRandNum(String checkNum){
			randNum.sendKeys(checkNum);			
				}
	//登录系统
		public void loginMts(){
			login.click();
						}

}
