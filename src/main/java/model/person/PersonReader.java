package model.person;

import java.util.List;

public interface PersonReader {
    List<Person> read(String filePath);
}
