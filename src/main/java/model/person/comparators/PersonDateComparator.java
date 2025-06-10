package model.person.comparators;

import model.person.Person;

public class PersonDateComparator extends AbstractPersonComparator implements Comparable<PersonDateComparator>{
    public PersonDateComparator(Person person) {
        super(person);
    }

    @Override
    protected String getField() {
        return this.person.getBirthDate();
    }

    @Override
    public int compareTo(PersonDateComparator o) {
        return super.compareTo(o);
    }
}
