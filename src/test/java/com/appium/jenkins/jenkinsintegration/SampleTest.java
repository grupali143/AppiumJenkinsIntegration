package com.appium.jenkins.jenkinsintegration;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SampleTest {
	
	@Test
	public void testLaunch() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, System.getProperty("PlatformName"));
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,System.getProperty("PlatformVersion"));
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone Simulator");
		capabilities.setCapability("app","/Users/grupali143/Desktop/UiCatalog.app");
		IOSDriver driver=new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElements(By.className("UIAButton")).get(0).click();
		driver.scrollTo("Date Picker").click();
		driver.findElements(By.className("UIAPickerWheel")).get(0).sendKeys("Jan 11");
		driver.findElements(By.className("UIAPickerWheel")).get(1).sendKeys("11");
		driver.findElements(By.className("UIAPickerWheel")).get(2).sendKeys("30");
		driver.findElements(By.className("UIAPickerWheel")).get(3).sendKeys("PM");
		Thread.sleep(5000);
		driver.quit();
	}

}
