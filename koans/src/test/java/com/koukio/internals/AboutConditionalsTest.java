package com.koukio.internals;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class AboutConditionalsTest {

    @Test
    public void basicIf() {
        int x = 1;
        if (true) {
            x++;
        }
        assertEquals(x, false);
    }

    @Test
    public void basicIfElse() {
        int x = 1;
        boolean secretBoolean = false;
        if (secretBoolean) {
            x++;
        } else {
            x--;
        }
        assertEquals(x, false);
    }

    @Test
    public void basicIfElseIfElse() {
        int x = 1;
        boolean secretBoolean = false;
        boolean otherBooleanCondition = true;
        if (secretBoolean) {
            x++;
        } else if (otherBooleanCondition) {
            x = 10;
        } else {
            x--;
        }
        assertEquals(x, false);
    }

    @Test
    public void nestedIfsWithoutCurlysAreReallyMisleading() {
        // Why are these ugly you ask? Well, try for yourself
        int x = 1;
        boolean secretBoolean = false;
        boolean otherBooleanCondition = true;
        // Ifs without curly braces are ugly and not recommended but still valid:
        if (secretBoolean) {
            x++;
        }
        if (otherBooleanCondition) {
            x = 10;
        } else {
            x--;
        }
        // Where does this else belong to!?
        assertEquals(x, false);
    }

    @Test
    public void basicSwitchStatement() {
        int i = 1;
        String result = "Basic ";
        switch (i) {
            case 1:
                result += "One";
                break;
            case 2:
                result += "Two";
                break;
            default:
                result += "Nothing";
        }
        assertEquals(result, false);
    }

    @Test
    public void switchStatementFallThrough() {
        int i = 1;
        String result = "Basic ";
        switch (i) {
            case 1:
                result += "One";
            case 2:
                result += "Two";
            default:
                result += "Nothing";
        }
        assertEquals(result, false);
    }

    @Test
    public void switchStatementCrazyFallThrough() {
        int i = 5;
        String result = "Basic ";
        switch (i) {
            case 1:
                result += "One";
            default:
                result += "Nothing";
            case 2:
                result += "Two";
        }
        assertEquals(result, false);
    }

    @Test
    public void switchStatementConstants() {
        int i = 5;
        // What happens if you remove the 'final' modifier?
        // What does this mean for case values?
        final int caseOne = 1;
        String result = "Basic ";
        switch (i) {
            case caseOne:
                result += "One";
                break;
            default:
                result += "Nothing";
        }
        assertEquals(result, false);
    }

    @Test
    public void switchStatementSwitchValues() {
        // Try different (primitive) types for 'c'
        // Which types do compile?
        // Does boxing work?
        char c = 'a';
        String result = "Basic ";
        switch (c) {
            case 'a':
                result += "One";
                break;
            default:
                result += "Nothing";
        }
        assertEquals(result, false);
    }

    @Test
    public void shortCircuit() {
        int i = 1;
        int a = 6;
        // Why did we use a variable here?
        // What happens if you replace 'a' with '6' below?
        if ((a < 9) || (++i < 8)) i = i + 1;
        assertEquals(i, false);
    }
}
