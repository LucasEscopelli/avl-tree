package model.person.comparators;

import model.person.Person;

public abstract class AbstractPersonComparator <T extends Comparable<T>> {
	protected final Person person;

	public AbstractPersonComparator(Person person) {
		this.person = person;
	}

	abstract protected T getField();

    public int compareTo(AbstractPersonComparator<T> o) {
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
