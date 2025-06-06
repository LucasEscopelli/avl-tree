package model;

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
                            fields[0], // CPF
                            fields[1], // RG
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
