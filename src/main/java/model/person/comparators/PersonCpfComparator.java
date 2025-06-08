package model.person.comparators;

import model.person.Person;

public class PersonCpfComparator extends AbstractPersonComparator {

    public PersonCpfComparator(Person person){
        super(person);
    }
    @Override
    protected String getField() {
        return this.person.getCpf();
    }
}
