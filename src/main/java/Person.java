import java.util.OptionalInt;

public class Person {

    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String address;

    public Person(PersonBuilder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.age = OptionalInt.of(builder.age);
        this.address = builder.address;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }

    public boolean hasAge() {
        return age.isPresent();
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
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            this.age = OptionalInt.of(age.getAsInt() + 1);
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
        return childBuilder;
    }
}