package model.person.comparators;

import model.person.Person;

import java.util.Date;

public class PersonDateComparator extends AbstractPersonComparator<Date> implements Comparable<PersonDateComparator>{
    public PersonDateComparator(Person person, Date date) {
        super(person, date);
    }
    public PersonDateComparator(Person person) {
        super(person, null);
    }
    public PersonDateComparator(Date date) {
        super(null, date);
    }

    @Override
    protected Date getField() {
        return this.person!=null ? this.person.getBirthDate() : value;
    }

    @Override
    public int compareTo(PersonDateComparator o) {
        return super.compareTo(o);
    }
}
