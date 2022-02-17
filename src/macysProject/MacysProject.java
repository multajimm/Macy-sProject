package macysProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MacysProject {
	public static void main(String[]args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.macys.com/account/signin");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement email=driver.findElement(By.name("user.email_address"));
		WebElement password= driver.findElement(By.xpath("//*[@id=\"pw-input\"]"));
		WebElement checkbox= driver.findElement(By.xpath("//*[@id=\"stay-signedin\"]"));
		WebElement button= driver.findElement(By.xpath("//*[@id=\"sign-in\"]"));
		
		email.sendKeys("multajimm");
		password.sendKeys("Manchester");
		checkbox.click();
		button.click();
		
		WebElement error_msg=driver.findElement(By.xpath("//*[@id=\"email-error\"]"));
		String error= error_msg.getText();
		
		if(error.contains("Please enter your email address in this format: jane@company.com")){
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}
		
		WebElement href=driver.findElement(By.xpath("//*[@id=\"forgot-password\"]"));
		href.click();
		String link=href.getText();
		//System.out.println(link);
		if(link.contains("Enter the email for your Macy's account and we'll send you a link to reset your ")){
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}
		//Failed to close the Browser again
		
		
		WebElement email1=driver.findElement(By.className("field-input"));
		WebElement captcha=driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]"));
		WebElement sendLink=driver.findElement(By.id("forgot-submit-btn"));
		email1.sendKeys("multajim@gmail.com");
		captcha.isSelected();
		sendLink.click();
		
		Thread.sleep(2000);
		driver.close();
	}
}
