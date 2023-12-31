package com.zensar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootApplication
public class ApiCallApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(ApiCallApplication.class, args);
        openBrowser();
	}

	private static void openBrowser() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:5678/tor");
		Thread.sleep(30000);
		driver.quit();
	}
}
