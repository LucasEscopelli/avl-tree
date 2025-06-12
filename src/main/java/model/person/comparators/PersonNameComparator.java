package model.person.comparators;

import model.person.Person;


public class PersonNameComparator extends AbstractPersonComparator<String> implements Comparable<PersonNameComparator>{
    private Long sentinel = Long.valueOf(0);
    public PersonNameComparator(Person person) {
        super(person, null);
    }
    public PersonNameComparator(String name, int type) {
        super(null, name);
        if(type == 0) this.sentinel = Long.MIN_VALUE;
        else this.sentinel = Long.MAX_VALUE;
    }

    @Override
    protected String getField() {
        return this.person != null ? this.person.getName() : value;
    }

    @Override
    public int compareTo(PersonNameComparator o) {
        int result = super.compareTo(o);
        if(result != 0) return result;
        Long myCpf = sentinel;
        Long otherCpf = sentinel;
        if(this.value == null) myCpf = person.getCpf();
        if(o.value == null) otherCpf = o.getPerson().getCpf();
        return myCpf.compareTo(otherCpf);
    }
}
