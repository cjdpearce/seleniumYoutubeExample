package com.cjdpearce.examples

import org.junit.Test

class SeleniumExampleYoutubeTest {
    private val sey: SeleniumExampleYoutube = SeleniumExampleYoutube()

    @Test
    fun search(){
        sey.youtubeSearch("Sky Betting and Gaming")
        sey.dr.closeDriver()
    }

    @Test
    fun searchAndFindChannel(){
        sey.gotoChannel("Sky Betting & Gaming")
        sey.dr.closeDriver()
    }

    @Test
    fun findChannelAndOpenVideo(){
        sey.gotoChannel("Sky Betting & Gaming")
        sey.findTabContent("videos")
        sey.clickVideo("sky betting & gaming tech academy")
    }
}
