package week9tests

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.jupiter.api.DisplayName
import week9.FindWordUnderCursor

@DisplayName("findWordUnderCursor")
class FindWordUnderCursorTest {

    @Test
    @DisplayName("should work on the tail edge of a word")
    fun shouldWorkOnTheTailEdgeOfAWord() {
        assertEquals("foo", FindWordUnderCursor().findWordUnderCursor("foo bar", 3))
    }

    @Test
    @DisplayName("should work on the leading edge of a word")
    fun shouldWorkOnTheLeadingEdgeOfAWord() {
        assertEquals("bar", FindWordUnderCursor().findWordUnderCursor("foo bar", 4))
    }

    @Test
    @DisplayName("should work on the end of a line")
    fun shouldWorkOnTheEndOfALine() {
        assertEquals("bar", FindWordUnderCursor().findWordUnderCursor("foo bar", 7))
    }

    @Test
    @DisplayName("should work on an extra space between words")
    fun shouldWorkOnAnExtraSpaceBetweenWords() {
        assertEquals("", FindWordUnderCursor().findWordUnderCursor("foo  bar", 4))
    }

    @Test
    @DisplayName("should consider anything but whitespace as part of a word")
    fun shouldConsiderAnythingButWhitespaceAsPartOfAWord() {
        assertEquals("$%a", FindWordUnderCursor().findWordUnderCursor("foo $%a", 5))
    }

    @Test
    @DisplayName("should work on a huge string")
    fun shouldWOrkOnAHugeString() {
        val words = ArrayList<String>();

        for (i in 0..Math.pow(10.0, 7.0).toInt()) {
            words.add("abcdefg")
        }

        words[Math.pow(10.0, 6.0).toInt()] = "hello"
        assertEquals(
            "hello",
            FindWordUnderCursor().findWordUnderCursor(words.joinToString(" "), 8000005)
        )
    }

    @Test
    fun shouldWOrkOnARandomString() {
        val rand = java.util.Random()
        var words = ArrayList<String>()

        for (i in 0..(rand.nextInt(100) + 1)) {
            val sb = StringBuilder()

            for (j in 0..(rand.nextInt(20) + 1)) {
                sb.append((rand.nextInt(26) + 96).toChar())
            }

            words.add(sb.toString())
        }

        val joinedWords = words.joinToString(" ")
        val cursor = rand.nextInt(joinedWords.length)
        assertEquals(
            findWordUnderCursorRef(joinedWords, cursor),
            FindWordUnderCursor().findWordUnderCursor(joinedWords, cursor)
        )
    }

    fun findWordUnderCursorRef(text: String, cursor: Int): String {
        var end = cursor
        var start = end

        while (start > 0 && text[start-1] != ' ') {
            start--
        }

        while (end < text.length && text[end] != ' ') {
            end++
        }

        return text.substring(start, end)
    }
}