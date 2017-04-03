package com.koukio.internals;


import org.junit.Assert;
import org.junit.Test;

import java.text.MessageFormat;


public class AboutStringsTest {

    @Test
    public void implicitStrings() {
        Assert.assertEquals("just a plain ole string".getClass(), "__".getClass());
    }

    @Test
    public void newString() {
        // very rarely if ever should Strings be created via new String() in
        // practice - generally it is redundant, and done repetitively can be slow
        String string = new String();
        String empty = "";
        Assert.assertEquals(string.equals(empty), true);
    }

    @Test
    public void newStringIsRedundant() {
        String stringInstance = "zero";
        String stringReference = new String(stringInstance);
        Assert.assertEquals(stringInstance.equals(stringReference), true);
    }

    @Test
    public void newStringIsNotIdentical() {
        String stringInstance = "zero";
        String stringReference = new String(stringInstance);
        Assert.assertEquals(stringInstance == stringReference, false);
    }

    @Test
    public void stringIsEmpty() {
        Assert.assertEquals("".isEmpty(), true);
        Assert.assertEquals("one".isEmpty(), false);
        Assert.assertEquals(new String().isEmpty(), true);
        Assert.assertEquals(new String("").isEmpty(), true);
        Assert.assertEquals(new String("one").isEmpty(), false);
    }

    @Test
    public void stringLength() {
        Assert.assertEquals("".length(), 0);
        Assert.assertEquals("one".length(), 3);
        Assert.assertEquals("the number is one".length(), 17);
    }

    @Test
    public void stringTrim() {
        Assert.assertEquals("".trim(), "");
        Assert.assertEquals("one".trim(), "one");
        Assert.assertEquals(" one more time".trim(), "one more time");
        Assert.assertEquals(" one more time         ".trim(), "one more time");
        Assert.assertEquals(" and again\t".trim(), "and again");
        Assert.assertEquals("\t\t\twhat about now?\t".trim(), "what about now?");
    }

    @Test
    public void stringConcatenation() {
        String one = "one";
        String space = " ";
        String two = "two";
        Assert.assertEquals(one + space + two, "one two");
        Assert.assertEquals(space + one + two, " onetwo");
        Assert.assertEquals(two + space + one, "two one");
    }

    @Test
    public void stringUpperCase() {
        String str = "I am a number one!";
        Assert.assertEquals(str.toUpperCase(), "I AM A NUMBER ONE!");
    }

    @Test
    public void stringLowerCase() {
        String str = "I AM a number ONE!";
        Assert.assertEquals(str.toLowerCase(), "i am a number one!");
    }

    @Test
    public void stringCompare() {
        String str = "I AM a number ONE!";
        Assert.assertEquals(str.compareTo("I AM a number ONE!") == 0, true);
        Assert.assertEquals(str.compareTo("I am a number one!") == 0, false);
        Assert.assertEquals(str.compareTo("I AM A NUMBER ONE!") == 0, false);
    }

    @Test
    public void stringCompareIgnoreCase() {
        String str = "I AM a number ONE!";
        Assert.assertEquals(str.compareToIgnoreCase("I AM a number ONE!") == 0, true);
        Assert.assertEquals(str.compareToIgnoreCase("I am a number one!") == 0, true);
        Assert.assertEquals(str.compareToIgnoreCase("I AM A NUMBER ONE!") == 0, true);
    }

    @Test
    public void stringStartsWith() {
        Assert.assertEquals("".startsWith("one"), false);
        Assert.assertEquals("one".startsWith("one"), true);
        Assert.assertEquals("one is the number".startsWith("one"), true);
        Assert.assertEquals("ONE is the number".startsWith("one"), false);
    }

    @Test
    public void stringEndsWith() {
        Assert.assertEquals("".endsWith("one"), false);
        Assert.assertEquals("one".endsWith("one"), true);
        Assert.assertEquals("the number is one".endsWith("one"), true);
        Assert.assertEquals("the number is two".endsWith("one"), false);
        Assert.assertEquals("the number is One".endsWith("one"), false);
    }

    @Test
    public void stringSubstring() {
        String str = "I AM a number ONE!";
        Assert.assertEquals(str.substring(0),"I AM a number ONE!");
        Assert.assertEquals(str.substring(1), " AM a number ONE!");
        Assert.assertEquals(str.substring(5), "a number ONE!");
        Assert.assertEquals(str.substring(14, 17), "ONE");
        Assert.assertEquals(str.substring(7, str.length()), "number ONE!");
    }

    @Test
    public void stringContains() {
        String str = "I AM a number ONE!";
        Assert.assertEquals(str.contains("one"), false);
        Assert.assertEquals(str.contains("ONE"), true);
    }

    @Test
    public void stringReplace() {
        String str = "I am a number ONE!";
        Assert.assertEquals(str.replace("ONE", "TWO"), "I am a number two!");
        Assert.assertEquals(str.replace("I am", "She is"), "She is a number ONE!");
    }

    @Test
    public void stringBuilderCanActAsAMutableString() {
        Assert.assertEquals(new StringBuilder("one").append(" ").append("two").toString(), "one two");
    }

    @Test
    public void readableStringFormattingWithStringFormat() {
        Assert.assertEquals(String.format("%s %s %s", "a", "b", "a"), "a b a");
    }

    @Test
    public void extraArgumentsToStringFormatGetIgnored() {
        Assert.assertEquals(String.format("%s %s %s", "a", "b", "c", "d"), "a b c");
    }

    @Test
    public void readableStringFormattingWithMessageFormat() {
        Assert.assertEquals(MessageFormat.format("{0} {1} {0}", "a", "b"), "a b a");
    }

    @Test
    public void extraArgumentsToMessageFormatGetIgnored() {
        Assert.assertEquals(MessageFormat.format("{0} {1} {0}", "a", "b", "c"), "a b a");
    }

    @Test
    public void insufficientArgumentsToMessageFormatDoesNotReplaceTheToken() {
        Assert.assertEquals(MessageFormat.format("{0} {1} {0}", "a"), "a {1} a");
    }
}
