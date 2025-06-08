package model.person.comparators;

import model.person.Person;

public class PersonNameComparator extends AbstractPersonComparator {
    public PersonNameComparator(Person person) {
        super(person);
    }

    @Override
    protected String getField() {
        return this.person.getName();
    }
}
