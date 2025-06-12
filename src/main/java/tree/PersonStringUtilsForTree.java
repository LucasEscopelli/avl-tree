package tree;

import model.person.comparators.PersonNameComparator;

import java.util.ArrayList;
import java.util.List;

public class PersonStringUtilsForTree {

    public static List<PersonNameComparator> getNamesByPrefix(Tree<PersonNameComparator> tree, String prefix) {
        String startName = prefix + " ";
        String endName = prefix + Character.MAX_VALUE;
        ArrayList<PersonNameComparator> result = new ArrayList<>();

        PersonNameComparator start = new PersonNameComparator(startName, 0);
        PersonNameComparator end = new PersonNameComparator(endName, 1);
        PersonNameComparator definitiveNameStart = new PersonNameComparator(prefix, 0);
        PersonNameComparator definitiveNameEnd = new PersonNameComparator(prefix, 1);


        final List<PersonNameComparator> persons = tree.getBetween(definitiveNameStart, definitiveNameEnd);

        if(persons != null){
            result.addAll(persons);
        }

        result.addAll(tree.getBetween(start, end));
        return result;
    }
}
