package model.person.comparators;

import model.person.Person;


public class PersonNameComparator extends AbstractPersonComparator<String> implements Comparable<PersonNameComparator>{
    public PersonNameComparator(Person person, String name) {
        super(person, name);
    }
    public PersonNameComparator(Person person) {
        super(person, null);
    }
    public PersonNameComparator(String name) {
        super(null, name);
    }

    @Override
    protected String getField() {
        return this.person != null ? this.person.getName() : value;
    }

    @Override
    public int compareTo(PersonNameComparator o) {
        return super.compareTo(o);
    }
}
