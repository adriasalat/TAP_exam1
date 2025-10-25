# Java EXAM - TAP

You can use the resources available in TAP repository: .

## 1. Use TAP2/functional code (Gender, Person)

### 1.a

The first goal is to create a select method that accepts:

- A list of Person  
- A Predicate<Person>  
- A Query enum type (ALL, MAX)

This static method will return a List<Person> with the Persons satisfying the query. For example:

SELECT * FROM PERSONS WHERE AGE > 3

SELECT MAX FROM PERSONS WHERE AGE > 3

You can also pass as parameter a Comparator<Person>. Demonstrate in the code the use of closures.

### 1.b

The second goal is to make select method generic so that accepts List<T> and Predicate<T>.

## 2. Use TAP3/filesystem2 entire directory

### 2.a

Add to directory a search(Predicate<File>) method enabling queries using closures.

### 2.b

Create a Decorator of Predicate<T> that:

- Counts the number of executions of the test method.  
- Provides a getCountTest method returning an int with that counter.  

Execute that decorator with a query (closure) invoking the search method in the previous section (2.a).  
Show that the counter correctly computes the number of times that test method was invoked.

## 3. You can use TAP4/annotations and TAP3/filesystem2

### 3.a

Create a new annotation called BlackList including a list of names.

### 3.b

Use this annotation in the Directory class and include names of directories that must be excluded from the search.

### 3.c

Check that when you search in a directory, all files inside blacklist directories are not processed.
