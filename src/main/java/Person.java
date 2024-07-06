import java.util.OptionalInt;

public class Person {

    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;
    protected boolean isAgeSpecified;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.isAgeSpecified = false;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.isAgeSpecified = true;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
        this.isAgeSpecified = true;
    }

    public boolean hasAge() {
        return isAgeSpecified;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (hasAge()) {
            return OptionalInt.of(age);
        } else {
            return OptionalInt.empty();
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            this.age = age + 1;
            System.out.println(this.age);
        }
    }

    @Override
    public String toString() {
        return this.name + " " + this.surname;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder childBuilder = new PersonBuilder();
        childBuilder.setSurname(surname);
        childBuilder.setAge(0);
        childBuilder.setAddress(address);
        childBuilder.isChild = true;
        return childBuilder;
    }
}