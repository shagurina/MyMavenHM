package org.example.HW_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class HW_3_FromCatalog {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://open.danfoss.ru/catalog/sections");

        //Авторизация
        WebElement webElement1 = driver.findElement(By.xpath(".//a[@class='profile__dropdown__button ']"));
        webElement1.click();
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("tacratrunnefra-7416@yopmail.com");
        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys("12345678");
        WebElement authSubmit = driver.findElement(By.xpath("//button[@class='button red']"));
        authSubmit.click();

        //Переход в каталог
        Thread.sleep(10000L);

        WebElement catalogTerm = driver.findElement(By.xpath("//a[@href='/catalog/section/thermal-automation']"));
        catalogTerm.click();
        WebElement catalogTO = driver.findElement(By.xpath("//div[@class='__ais __df __jcfs __fww catalog-sections']//a[@href='/plastinchatye-teploobmenniki/dvuxxodovye-payanye-plastincatye-teploobmenniki']"));
        catalogTO.click();
        WebElement PTO = driver.findElement(By.xpath("//a[@href='/plastinchatye-teploobmenniki/dvuxxodovye-payanye-plastincatye-teploobmenniki/xb52']"));
        PTO.click();

        //Добавление ПТО в корзину
        WebElement buttonBuy = driver.findElement(By.xpath("//form[@class='ajaxForm mr-2.5 __bn border-0 inline-block']"));
        buttonBuy.click();
        WebElement buttonOrder = driver.findElement(By.xpath("//a[@class='button red']"));
        buttonOrder.click();

        //Проверка наличия ПТО в корзине
        WebElement PTOinCart = driver.findElement(By.xpath("//a[@href='/payanyy-plastinchatyy-teploobmennik-odnokhodovoy-xb-serii-52m_preview']"));

        //Завершаем работу с ресурсом
        driver.quit();

    }

}
