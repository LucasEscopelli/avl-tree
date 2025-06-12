package model.person.comparators;

import model.person.Person;

import java.util.Date;

public class PersonDateComparator extends AbstractPersonComparator<Date> implements Comparable<PersonDateComparator>{
    private Long sentinel = Long.valueOf(0);
    public PersonDateComparator(Person person) {
        super(person, null);
    }
    public PersonDateComparator(Date date, int type) {
        super(null, date);
        if(type == 0) this.sentinel = Long.MIN_VALUE;
        else this.sentinel = Long.MAX_VALUE;
    }

    @Override
    protected Date getField() {
        return this.person!=null ? this.person.getBirthDate() : value;
    }

    @Override
    public int compareTo(PersonDateComparator o) {
        int result = super.compareTo(o);
        if(result != 0) return result;
        Long myCpf = sentinel;
        Long otherCpf = sentinel;
        if(this.value == null) myCpf = person.getCpf();
        if(o.value == null) otherCpf = o.getPerson().getCpf();
        return myCpf.compareTo(otherCpf);
    }
}
