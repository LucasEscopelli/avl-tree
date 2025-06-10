package model.person;

public class Person {
    private long cpf;
    private long rg;
    private String name;
    private String birthDate;
    private String city;

    public Person(long cpf, long rg, String name, String birthDate, String city) {
        this.cpf = cpf;
        this.rg = rg;
        this.name = name;
        this.birthDate = birthDate;
        this.city = city;
    }

    public long getCpf() { return cpf; }
    public long getRg() { return rg; }
    public String getName() { return name; }
    public String getBirthDate() { return birthDate; }
    public String getCity() { return city; }

    @Override
    public String toString() {
        return  "  CPF: " + cpf + "\n" +
                "  RG: " + rg + "\n" +
                "  Nome: " + name + "\n" +
                "  Data de Nascimento: " + birthDate + "\n" +
                "  Cidade: " + city + "\n";
    }
}
