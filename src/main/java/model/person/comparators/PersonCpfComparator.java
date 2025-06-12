package model.person.comparators;

import model.person.Person;


public class PersonCpfComparator extends AbstractPersonComparator<Long> implements Comparable<PersonCpfComparator>{

    public PersonCpfComparator(Person person, Long cpf){
        super(person, cpf);
    }
    public PersonCpfComparator(Person person) {
        super(person, null);
    }
    public PersonCpfComparator(Long cpf) {
        super(null, cpf);
    }
    @Override
    protected Long getField() {
        return this.person!=null ? this.person.getCpf() : value;
    }

	public int compareTo(PersonCpfComparator o) {
        return super.compareTo(o);
	}
}
