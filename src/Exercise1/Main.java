package Exercise1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Adrià Salat
 */
public class Main {
    public static void main(String[] args) {
        // List of people
        List<Person> list = Person.createShortList();

        // Predicate for the query
        Predicate<Person> condition = (Person p) -> p.getAge() > 30;

        // Comparator for the generic query
        Comparator<Person> max = (Person p1, Person p2) -> Integer.compare(p1.getAge(), p2.getAge());

        // Prove that exercise 1.a works correctly
        System.out.println(query(list, condition, Query.ALL));
        System.out.println(query(list, condition, Query.MAX));

        // Prove that exercise 1.b works correctly
        System.out.println(genericQuery(list, condition, Query.ALL, null));
        System.out.println(genericQuery(list, condition, Query.MAX, max));
    }

    // Query for the exercise 1.a
    public static List<Person> query(List<Person> list, Predicate<Person> condition, Query type) {
        List<Person> result = null;
        Comparator<Person> max = (Person p1, Person p2) -> p1.getName().compareTo(p2.getName());

        switch (type) {
            case ALL -> result = list.stream().filter(condition).toList();
            case MAX -> result = list.stream().filter(condition).max(max).stream().toList();
        }

        return result;
    }

    // Query for the exercise 1.b
    public static <T> List<T> genericQuery(List<T> list, Predicate<T> condition, Query type, Comparator<T> max) {
        List<T> result = null;
        
        switch (type) {
            case ALL -> result = list.stream().filter(condition).toList();
            case MAX -> result = list.stream().filter(condition).max(max).stream().toList();
        }

        return result;
    }
}
