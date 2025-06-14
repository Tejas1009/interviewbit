package Apple;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.*;

/**
 * https://leetcode.com/problems/peeking-iterator/
 * 284. Peeking Iterator
 * Medium
 * Topics
 * Companies
 * Hint
 * Design an iterator that supports the peek operation on an existing iterator in addition to the hasNext and the next operations.
 * <p>
 * Implement the PeekingIterator class:
 * <p>
 * PeekingIterator(Iterator<int> nums) Initializes the object with the given integer iterator iterator.
 * int next() Returns the next element in the array and moves the pointer to the next element.
 * boolean hasNext() Returns true if there are still elements in the array.
 * int peek() Returns the next element in the array without moving the pointer.
 * Note: Each language may have a different implementation of the constructor and Iterator, but they all support the int next() and boolean hasNext() functions.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["PeekingIterator", "next", "peek", "next", "next", "hasNext"]
 * [[[1, 2, 3]], [], [], [], [], []]
 * Output
 * [null, 1, 2, 2, 3, false]
 * <p>
 * Explanation
 * PeekingIterator peekingIterator = new PeekingIterator([1, 2, 3]); // [1,2,3]
 * peekingIterator.next();    // return 1, the pointer moves to the next element [1,2,3].
 * peekingIterator.peek();    // return 2, the pointer does not move [1,2,3].
 * peekingIterator.next();    // return 2, the pointer moves to the next element [1,2,3]
 * peekingIterator.next();    // return 3, the pointer moves to the next element [1,2,3]
 * peekingIterator.hasNext(); // return False
 */
class PeekingIterator implements Iterator<Integer> {
    public static void main(String[] args) {
        PeekingIterator pi = new PeekingIterator(Arrays.asList(1, 2, 3).iterator());
        System.out.println(pi.next());
        System.out.println(pi.peek());
        System.out.println(pi.next());
        System.out.println(pi.next());
        System.out.println(pi.hasNext());
    }

    private Queue<Integer> queue;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.queue = new LinkedList<>();
        while (iterator.hasNext()) {
            queue.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return queue.peek();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
