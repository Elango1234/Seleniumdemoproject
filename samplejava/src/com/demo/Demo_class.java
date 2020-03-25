package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_class {
	WebDriverException driver;
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://ul8vb.csb.app/");
	WebElement tablevalue=driver.findElement(By.xpath("//th[text()='Item 1']"));
	tablevalue.click();
	String[] exceptedtext={"First Nam1e","Last Name"};
	List<WebElement> heders=driver.findElements(By.xpath("//table//th"));
	List<String> acHearder=new ArrayList<String>();
	for(WebElement value:heders){
		acHearder.add(value.getText().trim());
	}
	ArrayList<String> exvalue= new ArrayList<String>(Arrays.asList(exceptedtext));
	if(exvalue.removeAll(acHearder)){
		System.out.println("pass");
	}
	else{
		System.out.println("Fail");
	}
	Map<String,Integer>  map=new HashMap<String,Integer>();
	List<WebElement> val=driver.findElements(By.xpath("//tbody//td/ancestor::table//th"));
	int k=1;
	for(WebElement values:val){
		map.put(values.getText(), k);
		k++;
	}
	String acxpath="//tbody//td["+map.get("Last Name")+"]";
	List<WebElement> data=driver.findElements(By.xpath(acxpath));
	for(WebElement  d:data){
		System.out.println(d.getText());
	}
	
	String excepted="test";
	WebElement actual=driver.findElement(By.xpath("//td[text()='sample']"));
	
	if(excepted.equalsIgnoreCase(excepted)){
		System.out.println("pass");
	}else{
		System.out.println("fail");
		System.out.println("gitup testing");
	}
	
	
	/*boolean status=driver.findElement(By.xpath("//table/thead/tr/th[contains(text(),'First Name')]")).isDisplayed();
	System.out.println(status);  
	WebElement tablevalue1=driver.findElement(By.xpath("//table[@class='table table-striped table-bordered table-hover']//tbody/tr/td[2]"));
	tablevalue1.click();
	
	WebElement hold=driver.findElement(By.xpath("//table[@class='table table-border']//tbody/tr[3]/td[2]"));
	hold.click();
*/}


}
