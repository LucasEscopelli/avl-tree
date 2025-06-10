package model.person;

import java.io.IOException;
import java.util.List;

public interface PersonReader {
    List<Person> read(String filePath) throws IOException, NumberFormatException, IllegalArgumentException;
}
