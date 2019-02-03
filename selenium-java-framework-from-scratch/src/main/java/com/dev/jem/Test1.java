package com.dev.jem;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Test1 {

	public static void main(String[] args) {
		//String projectPath = System.getProperty("user.dir");
		//System.out.println("Project Path : "+projectPath);
		
		//Firefox
		//System.setProperty("webdriver.gecko.driver", "C:\\selenium web driver\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		//Chrome
		//System.setProperty("webdriver.chrome.driver", "C:\\selenium web driver\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		//IE
		System.setProperty("webdriver.ie.driver", "C:\\selenium web driver\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		
		driver.get("https://www.google.com/");
		driver.close();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			runBatchFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Kill all browser driver
	 * @throws IOException
	 */
	private static void runBatchFile() throws IOException {
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "killer.bat");
		File dir = new File("C:\\selenium web driver");
		pb.directory(dir);
		Process p = pb.start();
	}

}
