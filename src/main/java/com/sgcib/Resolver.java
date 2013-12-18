package com.sgcib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Resolver {

    private Random randomGen;

    public Resolver(long seed) {
        randomGen = new Random(seed);
    }

    public List<Association> resolve(List<Person> giftPerson) {

        boolean check;
        List<Association> compute;
        do {
            compute = compute(giftPerson);
            check = check(compute);

        } while (!check);

        return compute;
    }

    private List<Association> map(List<Person> giftPerson) {
        List<Association> associations = new ArrayList<Association>();

        Person lastPerson = giftPerson.get(giftPerson.size() - 1);

        for (Person person : giftPerson) {
            associations.add(new Association(lastPerson, person));
            lastPerson = person;
        }

        return associations;
    }

    private List<Association> compute(List<Person> giftPerson) {

        int random = randomGen.nextInt(giftPerson.size() - 1);
        Collections.swap(giftPerson, random, random + 1);

        return map(giftPerson);
    }

    public boolean check(List<Association> associations) {
        for (Association association : associations) {
            if (!association.valid()) {
                return false;
            }
        }
        return true;
    }

}
