package algorithms.datasturctures.charactersequence;

/**
 * List of Common Static Methods in String Class
 * Method	Description
 * String.valueOf(anyType)	Converts various data types to a String.
 * String.valueOf(charArray, offset, length)	Converts part of a char array to a String.
 * String.format(format, args...)	Returns a formatted string (like printf).
 * String.join(delimiter, elements...)	Joins multiple strings with a delimiter.
 * String.copyValueOf(charArray)	Converts a char array to a String.
 * String.copyValueOf(charArray, offset, length)	Converts part of a char array to a String.
 * <p>
 * <p>
 * /**
 * Commonly Used Instance Methods in String Class
 * Method	Description
 * length()	Returns the length of the string.
 * charAt(index)	Returns the character at a specific index.
 * substring(beginIndex, endIndex)	Extracts a part of the string.
 * indexOf(char) / lastIndexOf(char)	Finds the position of a character or substring.
 * toUpperCase() / toLowerCase()	Converts the string to uppercase/lowercase.
 * trim()	Removes leading and trailing spaces.
 * replace(oldChar, newChar)	Replaces characters or substrings.
 * contains(substring)	Checks if the string contains a given sequence.
 * equals(str) / equalsIgnoreCase(str)	Compares two strings (case-sensitive or case-insensitive).
 * startsWith(prefix) / endsWith(suffix)	Checks if the string starts or ends with a specific sequence.
 * split(delimiter)	Splits the string into an array based on a delimiter.
 * isEmpty() / isBlank() (Java 11+)	Checks if the string is empty or only contains whitespace.
 */


/**
 * Built-in Character Class (Java Standard)
 * The Character class provides many static methods for working with characters. Some useful methods include:
 * digit or letter?
 *      isDigit(ch)
 *      isLetter(ch)
 *      isLetterOrDigit(ch)
 *      isWhitespace(ch)
 * is lowercase or uppercase?
 *      isLowerCase(ch)
 *      isUpperCase(ch)
 *      toLowerCase(ch)
 *      toUpperCase('b')
 */

public class StringInit {

    //String constructor with char array argument
    //Remember chars.toString() will return an instance reference! not a String composed of array

    static String newObjectFromArray(char[] arr) {
        return new String(arr);
    }

    static String fromStringStaticMethod(char[] arr) {
        return String.valueOf(arr);
    }

    static char[] toCharArray(String str) {
        return str.toCharArray();
    }
}
