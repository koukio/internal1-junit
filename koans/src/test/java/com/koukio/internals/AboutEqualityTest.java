package com.koukio.internals;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by garciar on 3/30/17.
 */
public class AboutEqualityTest {

    @Test
    public void doubleEqualsTestsIfTwoObjectsAreTheSame() {
        Object object = new Object();
        Object sameObject = object;
        assertEquals(object == sameObject, true);
        assertEquals(object == new Object(), false); //***
    }

    @Test
    public void equalsMethodByDefaultTestsIfTwoObjectsAreTheSame() {
        Object object = new Object();
        assertEquals(object.equals(object), true);
        assertEquals(object.equals(new Object()), false); //***
    }

    @Test
    public void equalsMethodCanBeChangedBySubclassesToTestsIfTwoObjectsAreEqual() {
        Object object = new Integer(1);
        assertEquals(object.equals(object), true);
        assertEquals(object.equals(new Integer(1)), true);
        // Note: This means that for the class 'Object' there is no difference between 'equal' and 'same'
        // but for the class 'Integer' there is difference - see below
    }

    @Test
    public void equalsMethodCanBeChangedBySubclassesToTestsIfTwoObjectsAreEqualExample() {
        Integer value1 = new Integer(4);
        Integer value2 = new Integer(2 + 2);
        assertEquals(value1.equals(value2), true);
        assertEquals(value1, Integer.valueOf(4));
    }

    @Test
    public void objectsNeverEqualNull() {
        assertEquals(new Object().equals(null), false);
    }

    @Test
    public void objectsEqualThemselves() {
        Object obj = new Object();
        assertEquals(obj.equals(obj), true);
    }

    @Test
    public void sameObject() {
        Object a = new Object();
        Object b = a;
        assertEquals(a == b, true);
    }

    @Test
    public void equalObject() {
        Integer a = new Integer(1);
        Integer b = new Integer(1);
        assertEquals(a.equals(b), true);
        assertEquals(b.equals(a), true);
    }

    @Test
    public void noObjectShouldBeEqualToNull() {
        assertEquals(new Object().equals(null), false);
    }

    static class Car {
        private String name = "";
        private int horsepower = 0;

        public Car(String s, int p) {
            name = s;
            horsepower = p;
        }

        @Override
        public boolean equals(Object other) {
            // Change this implementation to match the equals contract
            // Car objects with same horsepower and name values should be considered equal
            // http://download.oracle.com/javase/6/docs/api/java/lang/Object.html#equals(java.lang.Object)
            return false;
        }

        @Override
        public int hashCode() {
            // @see http://download.oracle.com/javase/6/docs/api/java/lang/Object.html#hashCode()
            return super.hashCode();
        }
    }

    @Test
    public void equalForOwnObjects() {
        Car car1 = new Car("Beetle", 50);
        Car car2 = new Car("Beetle", 50);
        // @see Car.equals (around line 45) for the place to solve this
        assertEquals(car1.equals(car2), true);
        assertEquals(car2.equals(car1), true);
    }

    @Test
    public void unequalForOwnObjects() {
        Car car1 = new Car("Beetle", 50);
        Car car2 = new Car("Porsche", 300);
        // @see Car.equals (around line 45) for the place to solve this
        assertEquals(car1.equals(car2), false);
    }

    @Test
    public void unequalForOwnObjectsWithDifferentType() {
        Car car1 = new Car("Beetle", 50);
        String s = "foo";
        // @see Car.equals (around line 45) for the place to solve this
        assertEquals(car1.equals(s), false);
    }

    @Test
    public void equalNullForOwnObjects() {
        Car car1 = new Car("Beetle", 50);
        // @see Car.equals (around line 45) for the place to solve this
        assertEquals(car1.equals(null), false);
    }

    @Test
    public void ownHashCode() {
        // As a general rule: When you override equals you should override
        // hash code
        // Read the hash code contract to figure out why
        // http://download.oracle.com/javase/6/docs/api/java/lang/Object.html#hashCode()

        // Implement Car.hashCode around line 51 so that the following assertions pass
        Car car1 = new Car("Beetle", 50);
        Car car2 = new Car("Beetle", 50);
        assertEquals(car1.equals(car2), true);
        assertEquals(car1.hashCode() == car2.hashCode(), true);
    }

    static class Chicken {
        String color = "green";

        @Override
        public int hashCode() {
            return 4000;
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof Chicken))
                return false;
            return ((Chicken) other).color.equals(color);
        }
    }

    @Test
    public void ownHashCodeImplementationPartTwo() {
        Chicken chicken1 = new Chicken();
        chicken1.color = "black";
        Chicken chicken2 = new Chicken();
        assertEquals(chicken1.equals(chicken2), false);
        assertEquals(chicken1.hashCode() == chicken2.hashCode(), true);
        // Does this still fit the hashCode contract? Why (not)?
        // Fix the Chicken class to correct this.
    }

}
