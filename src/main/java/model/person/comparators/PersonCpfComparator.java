package model.person.comparators;

import model.person.Person;

public class PersonCpfComparator extends AbstractPersonComparator<Long> implements Comparable<PersonCpfComparator>{

    public PersonCpfComparator(Person person, Long cpf){
        super(person, cpf);
    }
    @Override
    protected Long getField() {
        return this.person.getCpf();
    }

	public int compareTo(PersonCpfComparator o) {
        return super.compareTo(o);
	}
}
