package advanced_programming.uge3_generics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgeComparatorTest {
    private Person donDraper;
    private Person peggyOlson;
    private Person bertCooper;
    private List<Person> persons;

    @BeforeEach
    void beforeEach(){
        donDraper = new Person("Don Draper", 89);
        peggyOlson = new Person("Peggy Olson", 65);
        bertCooper = new Person("Bert Cooper", 100);

        persons = new ArrayList<Person>();
        persons.add(donDraper);
        persons.add(peggyOlson);
        persons.add(bertCooper);
    }

    @Test
    void givenUnsoretPersons_returnSortedPersonByTheiAge(){
        // Arrange
        List<Person> expectedPersons = new ArrayList<Person>();
        expectedPersons.add(peggyOlson);
        expectedPersons.add(donDraper);
        expectedPersons.add(bertCooper);

        // Act
        Collections.sort(persons, new AgeComparator());

        // Assert
        assertEquals(expectedPersons, persons);

    }

    @Test
    void givenUnsortedPersons_returnSortedPersonByTheirAgeReverse(){
        // Arrange
        List<Person> personSortedReverse = new ArrayList<>();
        personSortedReverse.add(bertCooper);
        personSortedReverse.add(donDraper);
        personSortedReverse.add(peggyOlson);

        // Act
        Collections.sort(persons, new ReverseComparator<>(new AgeComparator()));

        // Assert
        assertEquals(personSortedReverse, persons);

    }

}
