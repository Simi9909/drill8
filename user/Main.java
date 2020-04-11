package user;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Jdbi jdbi = Jdbi.create("jdbc:h2:mem:test");
        jdbi.installPlugin(new SqlObjectPlugin());

        try (Handle handle = jdbi.open()) {
            UserDao dao = handle.attach(UserDao.class);

            dao.createTable();

            User user1 = User.builder()
                    .name("James Bond")
                    .username("007")
                    .password("secret")
                    .email("jamesbond@something.com")
                    .gender(User.Gender.MALE)
                    .dob(LocalDate.parse("1920-11-11"))
                    .enabled(true)
                    .build();

            dao.insertUser(user1);

            User user2 = User.builder()
                    .name("Sherlock Holmes")
                    .username("holmes")
                    .password("secret")
                    .email("sherlockholmes@something.com")
                    .gender(User.Gender.MALE)
                    .dob(LocalDate.parse("1854-01-06"))
                    .enabled(false)
                    .build();

            dao.insertUser(user2);

            dao.list().stream().forEach(System.out::println);

            System.out.println("\nFind by ID: "+dao.findById(2) + "\n");

            System.out.println("Find by username: "+dao.findByUsername("007") + "\n");

            dao.delete(user2);
            System.out.println("Deleting user2\n");

            dao.list().stream().forEach(System.out::println);

        }
    }
}