package Exercise1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author Adrià Salat
 */
public class Main {
    public static void main(String[] args) {
        List<Person> list = Person.createShortList();

        // Prove that exercise 1.a works correctly
        Predicate<Person> condition = (Person p) -> p.getAge() > 30;
        System.out.println("ALL: " + select(list, condition, Query.ALL));
        System.out.println("MAX: " + select(list, condition, Query.MAX));

        System.out.println("\n ================================ \n");

        // Prove that exercise 1.b works correctly
        Comparator<Person> max = (Person p1, Person p2) -> Integer.compare(p1.getAge(), p2.getAge());
        System.out.println("ALL: " + genericSelect(list, condition, Query.ALL, max));
        System.out.println("MAX: " + genericSelect(list, condition, Query.MAX, max));
    }

    // Exercise 1.a
    public static List<Person> select(List<Person> list, Predicate<Person> condition, Query type) {
        Stream<Person> listFiltered = list.stream().filter(condition);
        Comparator<Person> max = (Person p1, Person p2) -> Integer.compare(p1.getAge(), p2.getAge());
        
        List<Person> result = null;

        switch (type) {
            case ALL -> result = listFiltered.toList();
            case MAX -> result = listFiltered.max(max).stream().toList();
        }

        return result;
    }

    // Exercise 1.b
    public static <T> List<T> genericSelect(List<T> list, Predicate<T> condition, Query type, Comparator<T> max) {
        Stream<T> listFiltered = list.stream().filter(condition);

        List<T> result = null;

        switch (type) {
            case ALL -> result = listFiltered.toList();
            case MAX -> result = listFiltered.max(max).stream().toList();
        }

        return result;
    }
}
