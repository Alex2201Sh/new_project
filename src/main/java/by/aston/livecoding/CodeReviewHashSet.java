package by.aston.livecoding;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class CodeReviewHashSet {
    public static void main(String[] args) {
        Collection<Element<Integer>> set = new HashSet<>();
        set.add(new Element<>(1));
        set.add(new Element<>(1));
        set.add(new Element<>(2));
        set.add(new Element<>(3));
        System.out.println(set.size());
        System.out.println(set.contains(new Element<>(2)));
    }

    private static class Element<T> {
        private final T value;

        public Element(T value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object object) {
            return object instanceof Element &&
                    Objects.equals(value, ((Element) object).value);
        }

    }
}
