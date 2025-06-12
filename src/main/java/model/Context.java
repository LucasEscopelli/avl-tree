package model;

import tree.BinaryTree;
import tree.Tree;

import java.io.IOException;
import java.util.ArrayList;
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

    public List<Person> getPersonList() { return personList; }
    public Tree<PersonCpfComparator> getCpfIndexer() { return cpfIndexer; }
    public Tree<PersonNameComparator> getNameIndexer() { return nameIndexer; }
    public Tree<PersonDateComparator> getDateIndexer() { return dateIndexer; }

    public Context(){
        personList = new ArrayList<>();
        cpfIndexer = new BinaryTree<PersonCpfComparator>();
        nameIndexer = new BinaryTree<PersonNameComparator>();
        dateIndexer = new BinaryTree<PersonDateComparator>();
    }

    public void addPerson(Person person){
        cpfIndexer.add(new PersonCpfComparator(person, null));
        nameIndexer.add(new PersonNameComparator(person, null));
        dateIndexer.add(new PersonDateComparator(person, null));
    }

    public void loadFile(String filePath) throws IOException, NumberFormatException, IllegalArgumentException {
        CsvPersonReader personReader = new CsvPersonReader();
        personList = personReader.read(filePath);
    }

    public void loadTrees(){
        personList.forEach(this::addPerson);
    }

}
