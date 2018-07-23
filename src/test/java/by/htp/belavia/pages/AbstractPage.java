package by.htp.belavia.pages;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
	
	protected static final By CAPTCHA = By.xpath("//*[@id=\"CaptchaInputText\"]");
	private static final By CAPTCHA_SUBMIT = By.xpath("/html/body/div[4]/div/form/div[2]/button");
	
	protected static WebDriver driver;

	public AbstractPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public static void captchaHandler() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter CAPTCHA--->");
		String captcha = scanner.nextLine();
		driver.findElement(CAPTCHA).sendKeys(captcha);
		driver.findElement(CAPTCHA_SUBMIT).click();
	}

}
