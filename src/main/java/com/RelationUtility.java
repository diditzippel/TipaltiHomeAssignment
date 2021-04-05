package com;

import java.util.HashMap;
import java.util.Map;

public class RelationUtility {
    Person[] persons;

    // First method -> Initialize (persons instances)
    public void init(Person[] persons){
        this.persons=persons;
    }

    // Second method -> find minimal level of relation between persons(a,b)
    public int findMinRelationLevel(Person personA, Person personB){
        Map<Person,Integer> distancesFromOtherPerson = new HashMap<>();

        //init personDistance map
        for (Person person: persons){
            if (person==personB){
                continue;
            }
            if (person.equals(personB)){
                distancesFromOtherPerson.put(person, 1);
            }
            else{
                distancesFromOtherPerson.put(person, Integer.MAX_VALUE);
            }
        }

        //if personA is 1st degree neighbor return 1
        if (distancesFromOtherPerson.get(personA) == 1){
            return 1;
        }

        boolean isChanged = true;

        // Check until there is no change in distances
        while (isChanged){
            isChanged=false;

            for (Person person: persons){
                if (person==personB){
                    continue;
                }
                for (Person anotherPerson: persons){
                    if ((anotherPerson==personB)|| ((person==anotherPerson))){
                        continue;
                    }
                    if (person.equals(anotherPerson)){
                        int personDistance = distancesFromOtherPerson.get(person);
                        int anotherPersonDistance = distancesFromOtherPerson.get(anotherPerson);

                        if (anotherPersonDistance==Integer.MAX_VALUE){
                            continue;
                        }

                        if (personDistance==Integer.MAX_VALUE){
                            distancesFromOtherPerson.put(person, anotherPersonDistance + 1);
                            isChanged=true;
                            continue;

                        }
                        if (personDistance>anotherPersonDistance+1){
                            distancesFromOtherPerson.put(person, anotherPersonDistance + 1);
                            isChanged=true;
                        }
                    }
                }
            }
        }
        if (distancesFromOtherPerson.get(personA)!=Integer.MAX_VALUE){
            return distancesFromOtherPerson.get(personA);
        }
        else{
            return -1;
        }
    }
}
