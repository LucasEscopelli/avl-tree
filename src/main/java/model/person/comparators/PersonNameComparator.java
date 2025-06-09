package model.person.comparators;

import model.person.Person;

public class PersonNameComparator extends AbstractPersonComparator implements Comparable<PersonNameComparator>{
    public PersonNameComparator(Person person) {
        super(person);
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
