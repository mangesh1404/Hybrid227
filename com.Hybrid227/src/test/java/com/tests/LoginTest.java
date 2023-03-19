package com.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;

public class LoginTest extends BaseClass {

	@BeforeSuite
	public void setup()throws Exception {
		initialization();
		reportInit();
	}
	@Test
	public void test01() {
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("qwerty");
		driver.findElement(By.xpath("//button")).click();
		Assert.assertEquals(driver.getTitle(), "123");
	}
	@Test
	public void test02() {
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
	}
	@Test
	public void test03() {
		throw new SkipException("skiping a testcaes");
	}
}
