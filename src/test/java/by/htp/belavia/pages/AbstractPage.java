package by.htp.belavia.pages;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import by.htp.belavia.scanner.ScannerSingleton;

public abstract class AbstractPage {

	protected static final By CAPTCHA = By.xpath("//*[@id='CaptchaInputText']");
	private static final By CAPTCHA_SUBMIT = By.xpath("/html/body/div[4]/div/form/div[2]/button");

	protected WebDriver driver;

	public AbstractPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void captchaHandler() {
		if (driver.findElements(CAPTCHA).size() > 0) {
			Scanner scanner = ScannerSingleton.getScanner();
			System.out.println("Enter CAPTCHA--->");
			String captcha = scanner.next();
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(CAPTCHA).sendKeys(captcha);
			driver.findElement(CAPTCHA_SUBMIT).click();
		}
	}

}
