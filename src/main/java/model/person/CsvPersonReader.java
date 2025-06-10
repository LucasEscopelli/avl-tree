package model.person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvPersonReader implements PersonReader {

    @Override
    public List<Person> read(String filePath) throws IOException, NumberFormatException, IllegalArgumentException {
        List<Person> people = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            String headerLine = br.readLine();
            if (headerLine == null) {
                throw new IllegalArgumentException(
                        "Arquivo CSV vazio ou contém apenas o cabeçalho: Nenhuma linha de dados encontrada.");
            }

            int lineNumber = 1;
            while ((line = br.readLine()) != null) {
                lineNumber++;

                String[] fields = line.split(";");
                if (fields.length == 5) {
                    try {
                        long cpf = Long.parseLong(fields[0].trim());
                        long rg = Long.parseLong(fields[1].trim());

                        Person person = new Person(
                                cpf,
                                rg,
                                fields[2],   // Name
                                fields[3],   // Birth Date
                                fields[4]    // City
                        );
                        people.add(person);

                    } catch (NumberFormatException e) {
                        throw new NumberFormatException(
                                "Erro de formato numérico na linha " + lineNumber +
                                " do arquivo '" + filePath + "': " + e.getMessage() + " - Dado: '" + line + "'"
                        );
                    }
                } else {
                    throw new IllegalArgumentException(
                            "Dado mal formado na linha " + lineNumber +
                            " do arquivo '" + filePath +
                            "'. Esperado 5 campos, encontrado " + fields.length + ". Dado: '" + line + "'"
                    );
                }
            }

        } catch (IOException e) {
            throw new IOException("Falha ao ler arquivo '" + filePath + "': " + e.getMessage(), e);
        }

        return people;
    }
}
