package model;

import model.comparators.PersonCpfComparator;
import model.comparators.PersonDateComparator;
import model.comparators.PersonNameComparator;
import tree.Tree;

import java.util.List;

public class Context {
    private List<Person> personList;
    private Tree<PersonCpfComparator> cpfIndexer;
    private Tree<PersonNameComparator> nameIndexer;
    private Tree<PersonDateComparator> dateIndexer;
}
