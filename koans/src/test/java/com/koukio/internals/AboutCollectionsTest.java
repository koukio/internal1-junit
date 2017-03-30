package com.koukio.internals;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by garciar on 3/30/17.
 */
public class AboutCollectionsTest {
    @Test
    public void usingAnArrayList() {
        // List = interface
        // The generic syntax and special generic cases will be handled in
        // AboutGenerics. We just use <String> collections here to keep it
        // simple.
        List<String> list = new ArrayList<String>();
        // ArrayList: simple List implementation
        list.add("Chicken");
        list.add("Dog");
        list.add("Chicken");
        assertEquals(list.get(0), false);
        assertEquals(list.get(1), false);
        assertEquals(list.get(2), false);
    }

    @Test
    public void usingAQueue() {
        // Queue = interface
        Queue<String> queue = new PriorityQueue<String>();
        // PriorityQueue: simple queue implementation
        queue.add("Cat");
        queue.add("Dog");
        assertEquals(queue.peek(), false);
        assertEquals(queue.size(), false);
        assertEquals(queue.poll(), false);
        assertEquals(queue.size(), false);
        assertEquals(queue.poll(), false);
        assertEquals(queue.isEmpty(), false);
    }

    @Test
    public void usingABasicSet() {
        Set<String> set = new HashSet<String>();
        set.add("Dog");
        set.add("Cat");
        set.add("Dog");
        assertEquals(set.size(), false);
        assertEquals(set.contains("Dog"), false);
        assertEquals(set.contains("Cat"), false);
        assertEquals(set.contains("Chicken"), false);
    }

    @Test
    public void usingABasicMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("first key", "first value");
        map.put("second key", "second value");
        map.put("first key", "other value");
        assertEquals(map.size(), false);
        assertEquals(map.containsKey("first key"), false);
        assertEquals(map.containsKey("second key"), false);
        assertEquals(map.containsValue("first value"), false);
        assertEquals(map.get("first key"), false);
    }

    @Test
    public void usingBackedArrayList() {
        String[] array = {"a", "b", "c"};
        List<String> list = Arrays.asList(array);
        list.set(0, "x");
        assertEquals(array[0], false);
        array[0] = "a";
        assertEquals(list.get(0), false);
        // Just think of it as quantum state teleportation...
    }

    @Test
    public void usingBackedSubMap() {
        TreeMap<String, String> map = new TreeMap<String, String>();
        map.put("a", "Aha");
        map.put("b", "Boo");
        map.put("c", "Coon");
        map.put("e", "Emu");
        map.put("f", "Fox");
        SortedMap<String, String> backedMap = map.subMap("c", "f");
        assertEquals(backedMap.size(), false);
        assertEquals(map.size(), false);
        backedMap.put("d", "Dog");
        assertEquals(backedMap.size(), false);
        assertEquals(map.size(), false);
        assertEquals(map.containsKey("d"), false);
        // Again: backed maps are just like those little quantum states
        // that are connected forever...
    }

    @Test
    public void differenceBetweenOrderedAndSorted() {
        TreeSet<String> sorted = new TreeSet<String>();
        sorted.add("c");
        sorted.add("z");
        sorted.add("a");
        assertEquals(sorted.first(), false);
        assertEquals(sorted.last(), false);
        // Look at the different constructors for a TreeSet (or TreeMap)
        // Ponder how you might influence the sort order. Hold that thought
        // until you approach AboutComparison

        LinkedHashSet<String> ordered = new LinkedHashSet<String>();
        ordered.add("c");
        ordered.add("z");
        ordered.add("a");
        StringBuffer sb = new StringBuffer();
        for (String s : ordered) {
            sb.append(s);
        }
        assertEquals(sb.toString(), false);
    }

}
