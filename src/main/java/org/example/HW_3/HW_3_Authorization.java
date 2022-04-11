package org.example.HW_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class HW_3_Authorization {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://open.danfoss.ru/");

        WebElement webElement1 = driver.findElement(By.xpath(".//a[@class='profile__dropdown__button ']"));
        webElement1.click();
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("tacratrunnefra-7416@yopmail.com");
        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys("12345678");
        WebElement authSubmit = driver.findElement(By.xpath("//button[@class='button red']"));
        authSubmit.click();
        //Переход в профиль для проверки почты
        WebElement profile = driver.findElement(By.xpath("//*[.='Профиль']")); //кроме текста не работает ничего
        profile.click();
        WebElement liProfil = driver.findElement(By.xpath("//a[@href='/profile/14369']"));
        liProfil.click();
        WebElement emailProfil = driver.findElement(By.xpath("//*[.=' tacratrunnefra-7416@yopmail.com ']"));


        //Завершаем работу с ресурсом
        //driver.quit();

    }

}
