package week9tests

import org.junit.Assert.*
import org.junit.Test
import week9.HasUniqueChars

internal class HasUniqueCharsTest {

        @Test
        fun shouldHandleEmptyString() {
            assertTrue(HasUniqueChars().hasUniqueChars(""))
        }

        @Test
        fun shouldHandleSingleLetter() {
            assertTrue(HasUniqueChars().hasUniqueChars("a"))
        }

        @Test
        fun shouldHandleTwoUniqueLetters() {
            assertTrue(HasUniqueChars().hasUniqueChars("ab"))
        }

        @Test
        fun shouldHandleTwoUniqueLettersWithCase() {
            assertTrue(HasUniqueChars().hasUniqueChars("aA"))
        }

        @Test
        fun shouldHandleMoreThanTwoUniqueCharacters() {
            assertTrue(HasUniqueChars().hasUniqueChars("abcdefg"))
        }

        @Test
        fun shouldHandleTwoNonUniqueLetters() {
            assertFalse(HasUniqueChars().hasUniqueChars("aa"))
        }

        @Test
        fun shouldHandleTwoNonUniqueCharacters()
        {
            assertFalse(HasUniqueChars().hasUniqueChars("  "))
        }

        @Test
        fun shouldHandleMoreThanTwoNonUniqueCharacters() {
            assertFalse(HasUniqueChars().hasUniqueChars("abbcdefg"))
        }

        @Test
        fun shouldHandleARandomTest() {
            var rnd = java.util.Random()
            var s = ""
            var expected = true
            val sLength = rnd.nextInt(20) + 1

            for (i in 0..rnd.nextInt(20) + 1) {
                val c = rnd.nextInt(128).toChar()

                if (expected && s.contains("" + c)) {
                    expected = false
                }

                s += c
            }

            assertEquals(expected, HasUniqueChars().hasUniqueChars(s))
        }
}