package algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class IsArrayEquals {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = new int[]{1, 2, 3};
        System.out.println(arr1.equals(arr2));  //false


        System.out.println(Arrays.equals(arr1, arr2));  //true


        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        System.out.println(list1.equals(list2));  //true

        Element element1 = new Element(1);
        Element element2 = new Element(1);
        System.out.println(element1.equals(element2)); //false if not Overriding equals and hashCode method. True after Override

    }

    static class Element {
        int value;

        public Element(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Element element = (Element) o;
            return value == element.value;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(value);
        }
    }

}
