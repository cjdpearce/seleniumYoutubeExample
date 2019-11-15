package com.cjdpearce.examples

import org.junit.Test

class SeleniumExampleYoutubeTest {
    private val ser: SeleniumExampleYoutube = SeleniumExampleYoutube()

    @Test
    fun search(){
        ser.youtubeSearch("Sky Betting and Gaming")
    }

    @Test
    fun searchAndFindChannel(){
        ser.gotoChannel("Sky Betting & Gaming")
    }

    @Test
    fun findChannelAndFilterForVideos(){
        ser.gotoChannel("Sky Betting & Gaming")
        ser.findTabContent("videos")
        ser.clickVideo()
    }
}
