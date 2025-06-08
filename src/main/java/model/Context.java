package model;

import tree.Tree;

import java.util.List;

import model.person.CsvPersonReader;
import model.person.Person;
import model.person.comparators.PersonCpfComparator;
import model.person.comparators.PersonDateComparator;
import model.person.comparators.PersonNameComparator;

public class Context {
    private List<Person> personList;
    private Tree<PersonCpfComparator> cpfIndexer;
    private Tree<PersonNameComparator> nameIndexer;
    private Tree<PersonDateComparator> dateIndexer;

    public void addPerson(Person person){
        personList.add(person);
        cpfIndexer.add(new PersonCpfComparator(person));
        nameIndexer.add(new PersonNameComparator(person));
        dateIndexer.add(new PersonDateComparator(person));
    }

    public void loadFile(String filePath){
        CsvPersonReader personReader = new CsvPersonReader();
        personReader.read(filePath).forEach(p -> addPerson(p));
    }
}
