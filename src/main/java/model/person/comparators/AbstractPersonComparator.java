package model.person.comparators;

import model.person.Person;

public abstract class AbstractPersonComparator <T extends Comparable<T>> {
	protected final T value;
	protected final Person person;

	public Person getPerson(){ return person; }

	public AbstractPersonComparator(Person person, T value) {
        this.value = value;
        this.person = person;
	}

	abstract protected T getField();

    public int compareTo(AbstractPersonComparator<T> o) {
		assert(o != null);
		T fieldToCompare = getField();
		T oFieldToCompare = o.getField();
        if(fieldToCompare == null) return 1;
        if(oFieldToCompare == null) return -1;
        return fieldToCompare.compareTo(oFieldToCompare);
    }

	@Override
	public String toString(){
		return this.person.toString();
	}
}
