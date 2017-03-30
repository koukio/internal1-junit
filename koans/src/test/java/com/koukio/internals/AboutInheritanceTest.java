package com.koukio.internals;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AboutInheritanceTest {

    abstract class Animal {
        abstract public String makeSomeNoise();
    }

    class Cow extends Animal {
        @Override
        public String makeSomeNoise() {
            return "Moo!";
        }
    }

    class Dog extends Animal {
        @Override
        public String makeSomeNoise() {
            return "Woof!";
        }

        public boolean canFetch() {
            return true;
        }
    }

    class Puppy extends Dog {
        @Override
        public String makeSomeNoise() {
            return "Squeak!";
        }
        public boolean canFetch() {
            return false;
        }
    }

    @Test
    public void methodOverloading() {
        Cow bob = new Cow();
        Dog max = new Dog();
        Puppy barney = new Puppy();
        assertEquals(bob.makeSomeNoise(), false);
        assertEquals(max.makeSomeNoise(), false);
        assertEquals(barney.makeSomeNoise(), false);

        assertEquals(max.canFetch(), false);
        assertEquals(barney.canFetch(), false);
        // but can Bob the Cow fetch?
    }

    @Test
    public void methodOverloadingUsingPolymorphism() {
        Animal bob = new Cow();
        Animal max = new Dog();
        Animal barney = new Puppy();
        assertEquals(bob.makeSomeNoise(), false);
        assertEquals(max.makeSomeNoise(), false);
        assertEquals(barney.makeSomeNoise(), false);
        // but can max or barney (here as an Animal) fetch?
        // try to write it down here
    }

    @Test
    public void inheritanceHierarchy() {
        Animal someAnimal = new Cow();
        Animal bob = new Cow();
        assertEquals(someAnimal.makeSomeNoise().equals(bob.makeSomeNoise()), false);
        // cow is a Cow, but it can also be an animal
        assertEquals(bob instanceof Animal, false);
        assertEquals(bob instanceof Cow, false);
        // but is it a Puppy?
        assertEquals(bob instanceof Puppy, false);
    }

    @Test
    public void deeperInheritanceHierarchy() {
        Dog max = new Dog();
        Puppy barney = new Puppy();
        assertEquals(max instanceof Puppy, false);
        assertEquals(max instanceof Dog, false);
        assertEquals(barney instanceof Puppy, false);
        assertEquals(barney instanceof Dog, false);
    }

    // TODO overriding
//
//    abstract class ParentTwo {
//        abstract public Collection<?> doStuff();
//    }
//
//    class ChildTwo extends ParentTwo {
//        public Collection<?> doStuff() {
//            return Collections.emptyList();
//        }
//
//        ;
//    }
//
//    @Test
//    public void overriddenMethodsMayReturnSubtype() {
//        // What do you need to change in order to get rid of the type cast?
//        // Why does this work?
//        List<?> list = (List<?>) new ChildTwo().doStuff();
//        assertEquals(list instanceof List, false);
//    }
}
