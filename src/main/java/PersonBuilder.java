public class PersonBuilder {

    protected String name;
    protected String surname;
    protected int age;
    protected String address;
    protected boolean isChild;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Недопустимый возраст");
        } this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (this.name == null) {
            throw new IllegalStateException("Имя должно быть указано");
        } if (this.surname == null) {
            throw new IllegalStateException("Фамилия должна быть указана");
        }

        Person person = new Person(this.name, this.surname);

        if (this.isChild || this.age != 0) {
            person.age = this.age;
            person.isAgeSpecified = true;
            if (this.address != null) {
                person.address = this.address;
            }
        }
        return person;
    }
}