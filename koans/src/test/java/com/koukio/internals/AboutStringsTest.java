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
        Assert.assertEquals(string.equals(empty), "__");
    }

    @Test
    public void newStringIsRedundant() {
        String stringInstance = "zero";
        String stringReference = new String(stringInstance);
        Assert.assertEquals(stringInstance.equals(stringReference), "__");
    }

    @Test
    public void newStringIsNotIdentical() {
        String stringInstance = "zero";
        String stringReference = new String(stringInstance);
        Assert.assertEquals(stringInstance == stringReference, "__");
    }

    @Test
    public void stringIsEmpty() {
        Assert.assertEquals("".isEmpty(), false);
        Assert.assertEquals("one".isEmpty(), false);
        Assert.assertEquals(new String().isEmpty(), false);
        Assert.assertEquals(new String("").isEmpty(), false);
        Assert.assertEquals(new String("one").isEmpty(), false);
    }

    @Test
    public void stringLength() {
        Assert.assertEquals("".length(), "__");
        Assert.assertEquals("one".length(), "__");
        Assert.assertEquals("the number is one".length(), "__");
    }

    @Test
    public void stringTrim() {
        Assert.assertEquals("".trim(), "__");
        Assert.assertEquals("one".trim(), "one");
        Assert.assertEquals(" one more time".trim(), "__");
        Assert.assertEquals(" one more time         ".trim(), "__");
        Assert.assertEquals(" and again\t".trim(), "__");
        Assert.assertEquals("\t\t\twhat about now?\t".trim(), "__");
    }

    @Test
    public void stringConcatenation() {
        String one = "one";
        String space = " ";
        String two = "two";
        Assert.assertEquals(one + space + two, "__");
        Assert.assertEquals(space + one + two, "__");
        Assert.assertEquals(two + space + one, "__");
    }

    @Test
    public void stringUpperCase() {
        String str = "I am a number one!";
        Assert.assertEquals(str.toUpperCase(), "__");
    }

    @Test
    public void stringLowerCase() {
        String str = "I AM a number ONE!";
        Assert.assertEquals(str.toLowerCase(), "__");
    }

    @Test
    public void stringCompare() {
        String str = "I AM a number ONE!";
        Assert.assertEquals(str.compareTo("I AM a number ONE!") == 0, "__");
        Assert.assertEquals(str.compareTo("I am a number one!") == 0, "__");
        Assert.assertEquals(str.compareTo("I AM A NUMBER ONE!") == 0, "__");
    }

    @Test
    public void stringCompareIgnoreCase() {
        String str = "I AM a number ONE!";
        Assert.assertEquals(str.compareToIgnoreCase("I AM a number ONE!") == 0, "__");
        Assert.assertEquals(str.compareToIgnoreCase("I am a number one!") == 0, "__");
        Assert.assertEquals(str.compareToIgnoreCase("I AM A NUMBER ONE!") == 0, "__");
    }

    @Test
    public void stringStartsWith() {
        Assert.assertEquals("".startsWith("one"), "__");
        Assert.assertEquals("one".startsWith("one"), "__");
        Assert.assertEquals("one is the number".startsWith("one"), "__");
        Assert.assertEquals("ONE is the number".startsWith("one"), "__");
    }

    @Test
    public void stringEndsWith() {
        Assert.assertEquals("".endsWith("one"), "__");
        Assert.assertEquals("one".endsWith("one"), "__");
        Assert.assertEquals("the number is one".endsWith("one"), "__");
        Assert.assertEquals("the number is two".endsWith("one"), "__");
        Assert.assertEquals("the number is One".endsWith("one"), "__");
    }

    @Test
    public void stringSubstring() {
        String str = "I AM a number ONE!";
        Assert.assertEquals(str.substring(0), "__");
        Assert.assertEquals(str.substring(1), "__");
        Assert.assertEquals(str.substring(5), "__");
        Assert.assertEquals(str.substring(14, 17), "__");
        Assert.assertEquals(str.substring(7, str.length()), "__");
    }

    @Test
    public void stringContains() {
        String str = "I AM a number ONE!";
        Assert.assertEquals(str.contains("one"), "__");
        Assert.assertEquals(str.contains("ONE"), "__");
    }

    @Test
    public void stringReplace() {
        String str = "I am a number ONE!";
        Assert.assertEquals(str.replace("ONE", "TWO"), "__");
        Assert.assertEquals(str.replace("I am", "She is"),  "__");
    }

    @Test
    public void stringBuilderCanActAsAMutableString() {
        Assert.assertEquals(new StringBuilder("one").append(" ").append("two").toString(), "__");
    }

    @Test
    public void readableStringFormattingWithStringFormat() {
        Assert.assertEquals(String.format("%s %s %s", "a", "b", "a"), "__");
    }

    @Test
    public void extraArgumentsToStringFormatGetIgnored() {
        Assert.assertEquals(String.format("%s %s %s", "a", "b", "c", "d"), "__");
    }

    @Test
    public void readableStringFormattingWithMessageFormat() {
        Assert.assertEquals(MessageFormat.format("{0} {1} {0}", "a", "b"), "__");
    }

    @Test
    public void extraArgumentsToMessageFormatGetIgnored() {
        Assert.assertEquals(MessageFormat.format("{0} {1} {0}", "a", "b", "c"), "__");
    }

    @Test
    public void insufficientArgumentsToMessageFormatDoesNotReplaceTheToken() {
        Assert.assertEquals(MessageFormat.format("{0} {1} {0}", "a"), "__");
    }
}
