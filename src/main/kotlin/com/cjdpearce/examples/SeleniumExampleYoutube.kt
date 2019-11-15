package com.cjdpearce.examples

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class SeleniumExampleYoutube{
    private val dr = DriverUtils()

    fun youtubeSearch(searchWord:String){
        dr.goto("https://www.youtube.com")
        var searchBar= dr.locateElement(By.id("search"))
        searchBar.sendKeys(searchWord)
        dr.locateElement(By.id(("search-icon-legacy"))).click()
    }

    fun gotoChannel(channelName:String){
        youtubeSearch(channelName)
        dr.locateElement(By.id("channel-title")).click()
    }

    fun findTabContent(sectionHeader:String){
        var contentSections = dr.locateElements(By.className("tab-content"))
        for (section in contentSections) {
            println(section.text)
            if (section.text.toLowerCase().contains(sectionHeader))
                section.click()
        }
    }

    fun clickVideo(){
        val driver = ChromeDriver()
        var wait = WebDriverWait(driver,5)
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("ytd-grid-video-renderer")))
        val videos = dr.locateElements(By.className("ytd-grid-video-renderer"))
        for (video in videos) {
            wait.until(ExpectedConditions.elementToBeClickable(video))
            if (video.text.toLowerCase().contains("sky betting & gaming tech academy"))
                video.click()
        }
    }
}


