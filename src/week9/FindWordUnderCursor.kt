package week9

class FindWordUnderCursor {

    /**
     Task
    Given a string of text (representing user input, for example) and a cursor position, determine which word in the text is under the cursor.

    A word is any series of non-whitespace characters. The string "hello world, https://www.codewars.com" contains three "words":

    {"hello", "world,", "https://www.codewars.com"}
    Furthermore, we'll consider a cursor position to be above a word if it touches a character from the word on either end. If the cursor position is bounded by whitespace or end/beginning of line on either end, it's not above any word and we return an empty string.

    A cursor position will always be given as the index of the element it precedes. For example,

    findWordUnderCursor("foo", 0)
    would indicate that the cursor is to the left of the "f" in "foo" at the beginning of the string.

    In the following example,

    findWordUnderCursor("baz", 3)
    the cursor is to the right of the "z" in "baz". Note that this is one index past the last element in the array.

    Here's a graphical example which should help clarify the logic:

    Constraints:

    0 ≤ cursor ≤ text.length
    0 ≤ text.length ≤ 7 * 107
    Examples
    findWordUnderCursor("foo bar", 3) // => "foo"
    findWordUnderCursor("foo bar", 4) // => "bar"
    findWordUnderCursor("foo bar", 7) // => "bar"
    findWordUnderCursor("foo  bar", 4) // => ""
    findWordUnderCursor("foo $%a", 5) // => "$%a"
     */
    fun findWordUnderCursor(text: String, cursor: Int): String {


        return ""
    }
}