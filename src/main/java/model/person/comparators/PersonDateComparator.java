package model.person.comparators;

import model.person.Person;

public class PersonDateComparator extends AbstractPersonComparator {
    public PersonDateComparator(Person person) {
        super(person);
    }

    @Override
    protected String getField() {
        return this.person.getBirthDate();
    }
}
