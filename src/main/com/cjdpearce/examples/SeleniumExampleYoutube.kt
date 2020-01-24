package com.cjdpearce.examples

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

object SeleniumExampleYoutube: DriverUtils() {
    /**
     *Conducts a search from the homepage based on keyphrase parameter passed in
     * @param searchPhrase the search phrase you would like to youtube to search for
     * @return true if the search is carried out
     */
    private fun youtubeSearch(searchPhrase:String): Boolean {
        goto("https://www.youtube.com")
        val searchBar= locateElement(By.id("search"))
        searchBar?.sendKeys(searchPhrase)
        locateElement(By.id(("search-icon-legacy")))?.click()
        return locateElement(By.id("filter-menu"))!=null
    }

    /**
     *Goes to a channel based on channel name being searched for
     * @param channelName the channel name you want to go to
     * @return true if driver has successfully navigated to a channel
     */
    fun gotoChannel(channelName:String): Boolean{
        youtubeSearch(channelName)
        locateElement(By.id("channel-title"))?.click()
        return locateElement(By.id("tabs"))!=null
    }

    /**
     *Find and navigates to the desired section on a specific channel page
     * @param sectionHeader the section you would like to navigate to
     * @return true if the section was successfully navigated to
     */
    fun findTabContent(sectionHeader:String): Boolean{
        var contentSections = locateElements(By.className("tab-content"))
        for (section in contentSections) {
            if (section.text.toLowerCase().contains(sectionHeader))
                section.click()
        }
        return driver.currentUrl.contains(sectionHeader)
    }

    /**
     *find and opens video based on video name string provided
     * @param videoName the name of the video you want to find
     * @return true if the driver has navigating to a video link successfully
     */
    fun clickVideo(videoName:String): Boolean{
        var wait = WebDriverWait(driver,5)
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("ytd-grid-renderer")))
        val videos = locateElements(By.id("video-title"))
        for (video in videos) {
            if (video.text.toLowerCase().contains(videoName))
                video.click()
        }
        val fullScreenButton = locateElement(By.className("ytp-fullscreen-button"))
        wait.until(ExpectedConditions.elementToBeClickable(fullScreenButton))
        locateElement(By.className("ytp-fullscreen-button"))?.click()
        return driver.currentUrl.contains("watch?")
    }

}


