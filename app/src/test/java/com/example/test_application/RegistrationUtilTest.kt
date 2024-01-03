package com.example.test_application

import org.junit.Assert.*
import org.junit.Test

class RegistrationUtilTest {
    @Test
    fun `empty username returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "",
            "123",
            "123"
        )
        assertFalse(result)
    }

    @Test
    fun `valid username and correctly repeated password returns true`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Philipp",
            "123",
            "123"
        )
        assertTrue(result)
    }

    @Test
    fun `username already exists returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Carl",
            "123",
            "123"
        )
        assertFalse(result)
    }

    @Test
    fun `incorrectly confirmed password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Philipp",
            "123456",
            "abcdefg"
        )
        assertFalse(result)
    }

    @Test
    fun `empty password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Philipp",
            "",
            ""
        )
        assertFalse(result)
    }

    @Test
    fun `less than 2 digit password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Philipp",
            "abcdefg5",
            "abcdefg5"
        )
        assertFalse(result)
    }
}