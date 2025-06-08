package model.comparators;

import model.Person;

public class PersonCpfComparator implements Comparable<PersonCpfComparator>{
    private final Person person;
    public PersonCpfComparator(Person person) {
		this.person = person;
	}
	@Override
    public int compareTo(PersonCpfComparator o) {
        if(o == null) return -1;
        if(person == null) return 1;
        if(o.person == null) return -1;
        if(person.getCpf() == null) return 1;
        if(o.person.getCpf() == null) return -1;
        return person.getCpf().compareTo(o.person.getCpf());
    }
}
