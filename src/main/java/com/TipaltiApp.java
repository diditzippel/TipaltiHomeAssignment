package com;

public class TipaltiApp {

    public static void main(String[] args) {
        Person personA = new Person(new Name("Alan", "Turing"),new Address("street1", "city1"));
        Person personB = new Person(new Name("Alan", "Turing"),new Address("street2", "city2"));
        Person personC = new Person(new Name("Joan", "Clarke"),new Address("street2", "city2"));
        Person personD = new Person(new Name("Joan", "Clarke"),new Address("street3", "city3"));
        Person personE = new Person(new Name("Alan", "Turing"),new Address("street3", "city3"));

        Person[] persons = new Person[]{personA, personB, personC, personD,personE};

        RelationUtility relationUtility = new RelationUtility();

        relationUtility.init(persons);
        int relationNumber = relationUtility.findMinRelationLevel(personA, personD);

        System.out.println("Relations number: "+ relationNumber);
    }
}
