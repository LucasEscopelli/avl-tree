package model.person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvPersonReader implements PersonReader {

    @Override
    public List<Person> read(String filePath) {
        List<Person> people = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");

                if (fields.length == 5) {
                    Person person = new Person(
                            Long.parseLong(fields[0].trim()), // CPF
                            Long.parseLong(fields[1].trim()), // RG
                            fields[2], // Name
                            fields[3], // Birth Date
                            fields[4]  // City
                    );
                    people.add(person);
                }
            }

        } catch (IOException e) {
            System.err.println("Failed to read file: " + e.getMessage());
        }

        return people;
    }
}
