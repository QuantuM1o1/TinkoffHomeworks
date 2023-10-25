package edu.hw3;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Task8 {
    private Task8() {
    }

    static public class BackwardIterator<E> implements Iterator<E> {
        private final List<E> list;
        private int currentIndex;

        public BackwardIterator(List<E> list) {
            this.list = list;
            this.currentIndex = list.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return currentIndex >= 0;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return list.get(currentIndex--);
        }
    }
}
