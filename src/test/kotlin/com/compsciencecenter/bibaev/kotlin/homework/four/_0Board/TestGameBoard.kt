package com.compsciencecenter.bibaev.kotlin.homework.four._0Board

import org.junit.Assert
import org.junit.Test
import com.compsciencecenter.bibaev.kotlin.homework.four._0Board.createGameBoard

class TestGameBoard {
    @Test
    fun testGetAndSetElement() {
        val board = createGameBoard<Char>(2)
        board[1, 1] = 'a'
        Assert.assertEquals('a', board[1, 1])
    }

    @Test
    fun testContainsValue() {
        val board = createGameBoard<Char>(2)
        board[1, 1] = 'a'
        Assert.assertTrue('a' in board)
    }

    @Test
    fun testFilter() {
        val board = createGameBoard<Char>(2)
        board[1, 1] = 'a'
        board[1, 2] = 'b'
        val cells = board.filter { it == 'a' }
        Assert.assertEquals(1, cells.size)
        val cell = cells.first()
        Assert.assertEquals(1, cell.i)
        Assert.assertEquals(1, cell.j)
    }

    @Test
    fun testFind() {
        val board = createGameBoard<Char>(2)
        board[1, 1] = 'a'
        board[1, 2] = 'b'
        val cell = board.find { it == 'a' }
        Assert.assertEquals(1, cell?.i)
        Assert.assertEquals(1, cell?.j)
        val notFoundCell = board.find { it == 'c' }
        Assert.assertNull(notFoundCell)
    }

    @Test
    fun testAll() {
        val board = createGameBoard<Char>(2)
        board[1, 1] = 'a'
        board[1, 2] = 'a'
        Assert.assertFalse(board.all { it == 'a' })
        board[2, 1] = 'a'
        board[2, 2] = 'a'
        Assert.assertTrue(board.all { it == 'a' })
    }

    @Test
    fun testAny() {
        val board = createGameBoard<Char>(2)
        board[1, 1] = 'a'
        board[1, 2] = 'b'
        Assert.assertTrue(board.any { it in 'a'..'b' })
        Assert.assertTrue(board.any { it == null })

    }
}