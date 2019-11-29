package com.cjdpearce.examples

import org.junit.Test

class SeleniumExampleYoutubeTest {
    private val ser: SeleniumExampleYoutube = SeleniumExampleYoutube()

    @Test
    fun search(){
        ser.youtubeSearch("Sky Betting and Gaming")
        ser.dr.closeDriver()
    }

    @Test
    fun searchAndFindChannel(){
        ser.gotoChannel("Sky Betting & Gaming")
        ser.dr.closeDriver()
    }

    @Test
    fun findChannelAndOpenVideo(){
        ser.gotoChannel("Sky Betting & Gaming")
        ser.findTabContent("videos")
        ser.clickVideo("sky betting & gaming tech academy")
    }
}
