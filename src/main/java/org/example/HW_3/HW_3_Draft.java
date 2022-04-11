package org.example.HW_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HW_3_Draft {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://open.danfoss.ru/sales/cart");

        //Авторизация для сохранения черновика в личном кабинете
        WebElement webElement1 = driver.findElement(By.xpath(".//a[@class='profile__dropdown__button ']"));
        webElement1.click();
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("tacratrunnefra-7416@yopmail.com");
        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys("12345678");
        WebElement authSubmit = driver.findElement(By.xpath("//button[@class='button red']"));
        authSubmit.click();

        //Ожидание отсутствия прелоадера корзины
        WebElement preloader = driver.findElement(By.xpath("//div[@class='spinner-border']"));
        new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOf(preloader));
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".add-goods-input-witch-select")));

        //Добавление материала в корзину
        Thread.sleep(10000L); //не смотря на явные ожидания в строках 40 и 41, приходится все равно использовать sleep здесь и далее
        WebElement sea = driver.findElement(By.name("search"));
        sea.sendKeys("013G7090");
        WebElement addButton = driver.findElement(By.xpath("//form[@id='add-goods-by-search']/div/button"));
        addButton.click();

        //Сохранение в черновик
        Thread.sleep(10000L); // проверить ожидание
        WebElement draftButton = driver.findElement(By.xpath("//*[.=' Сохранить как черновик ']"));
        draftButton.click();
        Thread.sleep(10000L);

        //Проверка перехода в черновик
        WebElement draftName = driver.findElement(By.xpath("//div[contains(text(),' Черновик ')]"));

        //Завершаем работу с ресурсом
        //  driver.quit();

    }

}
