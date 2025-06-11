package model.person.comparators;

import model.person.Person;

import java.util.Date;

public class PersonCpfComparator extends AbstractPersonComparator<Long> implements Comparable<PersonCpfComparator>{

    public PersonCpfComparator(Person person, Long cpf){
        super(person, cpf);
    }
    @Override
    protected Long getField() {
        return this.person!=null ? this.person.getCpf() : value;
    }

	public int compareTo(PersonCpfComparator o) {
        return super.compareTo(o);
	}
}
