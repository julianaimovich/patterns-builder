public class Main {

    public static void main(String[] args) {

        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAddress("Сидней")
                .setAge(47)
                .build();

        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();

        System.out.println("У " + mom + " есть сын, " + son);

        try {
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        System.out.println(mom.getAge());
        System.out.println(son.getAge());
    }
}