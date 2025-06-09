package model.person.comparators;

import model.person.Person;

public class PersonCpfComparator extends AbstractPersonComparator implements Comparable<PersonCpfComparator>{

    public PersonCpfComparator(Person person){
        super(person);
    }
    @Override
    protected String getField() {
        return this.person.getCpf();
    }

	public int compareTo(PersonCpfComparator o) {
        return super.compareTo(o);
	}
}
