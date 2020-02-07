package com.cjdpearce.examples

import org.junit.jupiter.api.*

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class SeleniumExampleYoutubeTest {
    private val sey:SeleniumExampleYoutube = SeleniumExampleYoutube

    @DisplayName("Find the Sky Betting & Gaming Youtube Channel")
    @Order(1)
    @Test
    fun findChannel(){
        val channelName = "Sky Betting and Gaming"
        Assertions.assertTrue(sey.gotoChannel(channelName),
            "WebDriver did not successfully navigate to channel: $channelName"
        )
    }

    @DisplayName("Open up the video section of the channel")
    @Order(2)
    @Test
    fun navigateToVideoSection(){
        val sectionHeader = "videos"
        Assertions.assertTrue(sey.findTabContent(sectionHeader),
            "WebDriver did not successfully open: $sectionHeader"
        )
    }

    @DisplayName("Open Tech Academy Video")
    @Order(3)
    @Test
    fun openVideo(){
        val videoName = "sky betting & gaming tech academy"
        Assertions.assertTrue(sey.clickVideo(videoName),
            "Video '$videoName' was not successfully opened"
            )
    }
}
