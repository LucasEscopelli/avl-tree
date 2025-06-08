package model.person;

public class Person {
    private String cpf;
    private String rg;
    private String name;
    private String birthDate;
    private String city;

    public Person(String cpf, String rg, String name, String birthDate, String city) {
        this.cpf = cpf;
        this.rg = rg;
        this.name = name;
        this.birthDate = birthDate;
        this.city = city;
    }

    public String getCpf() { return cpf; }
    public String getRg() { return rg; }
    public String getName() { return name; }
    public String getBirthDate() { return birthDate; }
    public String getCity() { return city; }

    @Override
    public String toString() {
        return cpf + " - " + name + " (" + city + ")";
    }
}
