package model.person.comparators;

import model.person.Person;

public abstract class AbstractPersonComparator implements Comparable<AbstractPersonComparator> {
	protected final Person person;

	public AbstractPersonComparator(Person person) {
		this.person = person;
	}

	abstract protected String getField();

	@Override
    public int compareTo(AbstractPersonComparator o) {
		assert(person != null);
		assert(o != null);
		assert(o.person != null);
        if(getField() == null) return 1;
        if(o.getField() == null) return -1;
        return getField().compareTo(o.getField());
    }

	@Override
	public String toString(){
		return this.person.toString();
	}
}
