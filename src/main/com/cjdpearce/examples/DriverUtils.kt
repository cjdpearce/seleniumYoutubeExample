package com.cjdpearce.examples

import org.openqa.selenium.*
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

open class DriverUtils{
    private var options:ChromeOptions = ChromeOptions().addArguments("--disable-notifications")
    var driver:WebDriver = ChromeDriver(options)
    private var wait:WebDriverWait = WebDriverWait(driver,5)

    /**
     * go to a specific web address
     * @param url the website you would like to go to
     * @return the browserdriver instance on the webpage
     */
    fun goto(url:String){
        return driver.navigate().to(url)
    }

    /**
     *Locate a web element on a page, returns null if driver times out waiting for element
     * @param method the method in which you are locating the element
     * @return the web element
     */
    fun locateElement(method:By): WebElement? {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(method))
        }catch (ex:TimeoutException){
            return null
        }
        return driver.findElement(method)
    }

    /**
     *Locates and returns multiple web elements on a page
     * @param method the method in which you are locating the elements
     * @return a mutable list of the web elements
     */
    fun locateElements(method:By): MutableList<WebElement> {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(method))
        return driver.findElements(method)
    }

    /**
     *Closes the current instance of the webdriver
     */
    fun closeDriver(){
        driver.close()
    }

}
