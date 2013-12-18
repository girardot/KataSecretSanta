package com.sgcib;

public class Person {

    private final String firstName;
    private final String lastName;
    private final String email;

    public Person(String name) {
        String[] split = name.split(" ");
        this.firstName = split[0];
        this.lastName = split[1];
        this.email = split[2];
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!lastName.equals(person.lastName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return lastName.hashCode();
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " <" + email + ">";
    }

}
