package com;

import java.util.HashMap;
import java.util.Map;

public class RelationUtility {
    Person[] persons;

    // First method -> Initialize (persons instances)
    public void init(Person[] persons) {
        this.persons = persons;
    }

    // Second method -> find minimal level of relation between persons(a,b)
    public int findMinRelationLevel(Person personA, Person personB) {
        Map<Person, Integer> distancesFromOtherPerson = new HashMap<>();
        int current = 1;
        int minRelational;
        boolean isFound = false;
        minRelational = Integer.MAX_VALUE;
        Person[] tempPersons = new Person[persons.length - 1];
        int i = 0;

        if (personA.near(personB)) {
            isFound = true;
            minRelational = 1;
        } else {
            if ((persons.length - 1) > 0) {
                for (Person person : persons) {
                    if (person == personA) {
                        continue;
                    }
                    tempPersons[i] = person;
                    i++;
                }
                persons = tempPersons;
            }
            for (Person person : persons) {
                if (person.near(personA)) {
                    isFound = true;
                    current = findMinRelationLevel(person, personB);

                    if (current < Integer.MAX_VALUE) {
                        current = current + 1;
                    }
                }
                if (current < minRelational) {
                    minRelational = current;
                }
            }
        }
        if (!isFound) {
            minRelational = Integer.MAX_VALUE;
        }
        return minRelational;
    }
}