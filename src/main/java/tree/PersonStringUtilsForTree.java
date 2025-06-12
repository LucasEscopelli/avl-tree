package tree;

import model.person.comparators.PersonNameComparator;

import java.util.ArrayList;
import java.util.List;

public class PersonStringUtilsForTree {

    public static List<PersonNameComparator> getNamesByPrefix(Tree<PersonNameComparator> tree, String prefix) {
        String startName = prefix + " ";
        String endName = prefix + Character.MAX_VALUE;
        ArrayList<PersonNameComparator> result = new ArrayList<>();

        PersonNameComparator start = new PersonNameComparator(startName);
        PersonNameComparator end = new PersonNameComparator(endName);
        PersonNameComparator definitiveName = new PersonNameComparator(prefix);


        final PersonNameComparator person = tree.get(definitiveName);

        if(person != null && person.getPerson().getName().equals(prefix)){
            result.add(person);
        }

        result.addAll(tree.getBetween(start, end));
        return result;
    }
}
