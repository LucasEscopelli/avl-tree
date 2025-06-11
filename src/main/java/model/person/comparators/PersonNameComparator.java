package model.person.comparators;

import model.person.Person;

public class PersonNameComparator extends AbstractPersonComparator<String> implements Comparable<PersonNameComparator>{
    public PersonNameComparator(Person person, String name) {
        super(person, name);
    }

    @Override
    protected String getField() {
        return this.person.getName();
    }

    @Override
    public int compareTo(PersonNameComparator o) {
        return super.compareTo(o);
    }
}
