package model.person;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private long cpf;
    private long rg;
    private String name;
    private Date birthDate;
    private String city;

    public Person(long cpf, long rg, String name, Date birthDate, String city) {
        this.cpf = cpf;
        this.rg = rg;
        this.name = name;
        this.birthDate = birthDate;
        this.city = city;
    }

    public long getCpf() { return cpf; }
    public long getRg() { return rg; }
    public String getName() { return name; }
    public Date getBirthDate() { return birthDate; }
    public String getCity() { return city; }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return  "  CPF: " + cpf + "\n" +
                "  RG: " + rg + "\n" +
                "  Nome: " + name + "\n" +
                "  Data de Nascimento: " + sdf.format(birthDate) + "\n" +
                "  Cidade: " + city + "\n";
    }
}
