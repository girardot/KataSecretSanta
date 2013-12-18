package com.sgcib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Resolver {

    private long seed ;

    public Resolver(long seed) {
        this.seed = seed;
    }

    public List<Association> resolve(List<Person> giftPerson) {

        ArrayList<Person> giftReceive = new ArrayList<Person>(giftPerson);

        boolean check;
        List<Association> compute;
        do {
            compute = compute(giftPerson, giftReceive);
            check = check(compute);

        } while (!check);

        return compute;
    }

    private List<Association> compute(List<Person> giftPerson, List<Person> giftReceive) {

        List<Association> associations = new ArrayList<Association>();

        List<Person> duplicates = new ArrayList<Person>(giftReceive);

        for (Person from : giftPerson) {
            Random randomGen = new Random(seed);
            int random = randomGen.nextInt(duplicates.size())  ;
            //int random = (int) (Math.random() * (duplicates.size()));
            Person to = duplicates.remove(random);

            associations.add(new Association(from, to));
        }

        return associations;
    }

    public boolean check(List<Association> associations) {
        for (Association association : associations) {
            if (association.getFrom().equals(association.getTo())) {
                return false;
            }
        }
        return true;
    }

}
