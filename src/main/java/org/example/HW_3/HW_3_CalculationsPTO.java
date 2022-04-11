package org.example.HW_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class HW_3_CalculationsPTO {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://open.danfoss.ru/calculations-pto");

        //Авторизация
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("tacratrunnefra-7416@yopmail.com");
        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys("12345678");
        WebElement authSubmit = driver.findElement(By.xpath("//button[@class='button red']"));
        authSubmit.click();

        //Переход в каталог
        Thread.sleep(10000L);

        WebElement checkBox = driver.findElement(By.xpath("//label[@class='__pos-rel checkbox checkbox-2 calc-chooser']"));
        checkBox.click();
        WebElement cart = driver.findElement(By.xpath("//span[@class='all-calcs active']"));
        cart.click();


//
        //Добавление ПТО в корзину
        WebElement buttonBuy = driver.findElement(By.xpath("//a[@class='button red']"));
        buttonBuy.click();
//        WebElement buttonOrder = driver.findElement(By.xpath("//a[@class='button red']"));
//        buttonOrder.click();
//
//        //Проверка наличия ПТО в корзине
        WebElement PTOinCart = driver.findElement(By.xpath("//span[@class='fw-bold fs-6 text-reset border-0 text-decoration-none']"));

        //Завершаем работу с ресурсом
        //driver.quit();

    }

}
