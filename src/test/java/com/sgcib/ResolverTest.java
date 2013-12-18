package com.sgcib;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ResolverTest {

    @Test
    public void test_check() throws Exception {
        Person from = new Person("toto toto toto@toto.com");
        Person to = new Person("toto toto toto@toto.com");
        Association association = new Association(from, to);

        Resolver resolver = new Resolver(0L);

        Assert.assertFalse(resolver.check(Arrays.asList(association)));
    }

    @Test
    public void test_check_same_family() throws Exception {
        Person from = new Person("toto toto toto@toto.com");
        Person to = new Person("titi toto tito@toto.com");
        Association association = new Association(from, to);

        Resolver resolver = new Resolver(0L);

        Assert.assertFalse(resolver.check(Arrays.asList(association)));
    }

    @Test
    public void test_not_check() throws Exception {
        Person from = new Person("toto tott toto@tott.com");
        Person to = new Person("titi toto toto@tott.com");
        Association association = new Association(from, to);

        Resolver resolver = new Resolver(0L);

        Assert.assertTrue(resolver.check(Arrays.asList(association)));
    }

    @Test
    public void test_resolve() throws Exception {
        Resolver resolver = new Resolver(0L);
        Person p1 = new Person("toto toto toto@tott.com");
        Person p2 = new Person("titi titi toto@tott.com");

        List<Association> resolveResult = resolver.resolve(Arrays.asList(p1, p2));

        Assert.assertTrue(resolver.check(resolveResult));
        Assert.assertTrue(resolveResult.size() == 2);
    }

    @Test
    public void test_real_data() throws Exception {

        // Given
        Resolver resolver = new Resolver(4310897328965L);

        Person p1 = new Person("Skyler White skyler@gmail.com");
        Person p2 = new Person("Walter White walter@caltech.edu");
        Person p3 = new Person("Gustavo Fring fring@polos.com");
        Person p4 = new Person("Saul Goodman saul@goodman.com");
        Person p5 = new Person("Jese Pinkman jese.pikman@gmail.com");
        Person p6 = new Person("Henri Schrader henri.schrader@dea.us");
        Person p7 = new Person("Marie Schrader marieshrader723@yahoo.com");
        List<Association> shouldBe = Arrays.asList(new Association(p5, p3), new Association(p3, p2), new Association(p2, p4), new Association(p4, p7), new Association(p7, p1),new Association(p1, p6), new Association(p6, p5));

        List<Person> persons = Arrays.asList(p2, p1, p3, p4, p5, p6, p7);

        // When
        List<Association> resolveResult = resolver.resolve(persons);

        // Then
        Assert.assertTrue(resolveResult.equals(shouldBe));
        Assert.assertTrue(resolveResult.size() == 7);

        for (Association association : resolveResult) {
            System.out.println(association);
        }
    }

}
