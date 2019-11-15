package com.cjdpearce.examples

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class DriverUtils{
    private var options:ChromeOptions = ChromeOptions()
    private var driver:WebDriver

    init {
        options.addArguments("--disable-notifications")
        driver = ChromeDriver(options)
    }

    fun goto(url:String){
        return driver.navigate().to(url)
    }

    fun locateElement(method:By): WebElement {
        var wait = WebDriverWait(driver,5)
        wait.until(ExpectedConditions.presenceOfElementLocated(method))
        return driver.findElement(method)
    }

    fun locateElements(method:By): MutableList<WebElement> {
        var wait = WebDriverWait(driver,5)
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(method))
        return driver.findElements(method)
    }

    fun closeDriver(){
        driver.close()
    }

}
