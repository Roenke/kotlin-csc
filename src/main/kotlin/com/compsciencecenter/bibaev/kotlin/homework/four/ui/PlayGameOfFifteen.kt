package com.compsciencecenter.bibaev.kotlin.homework.four.ui

import com.compsciencecenter.bibaev.kotlin.homework.four._3GameOfFifteen.newGameOfFifteen
import com.compsciencecenter.bibaev.kotlin.homework.four.ui.GameSettings
import com.compsciencecenter.bibaev.kotlin.homework.four.ui.playGame
import java.awt.Color

object GameOfFifteenSettings : GameSettings("Game of fifteen", Color(0x909090)) {
    private val emptyColor = Color(0x787878)
    private val firstColor = Color(0xC8C8C8)
    private val secondColor = Color(0xCCCCFF)
    private val foregroundColor = Color(0x545AA7)

    override fun getBackgroundColor(value: Int) = when {
        value == 0 -> emptyColor
        ((value - 1) / 4 + value % 4) % 2 == 0 -> firstColor
        else -> secondColor
    }
    override fun getForegroundColor(value: Int) = foregroundColor
}

fun main(args: Array<String>) {
    playGame(newGameOfFifteen(), GameOfFifteenSettings)
}