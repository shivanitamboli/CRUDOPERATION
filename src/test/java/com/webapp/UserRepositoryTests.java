package com.webapp;
        import com.webapp.model.User;
        import com.webapp.repository.UserRepository;
        import org.assertj.core.api.Assertions;
        import org.junit.jupiter.api.Test;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
        import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
        import org.springframework.test.annotation.Rollback;

        import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired private UserRepository repo;

    @Test
    public  void testDatabase(){
        User user = new User();
        user.setEmail("AshishMail@gmail.com");
        user.setPassword("Ashish@1");
        user.setFirstname("Srikant");
        user.setLastname("Reddy");
        repo.save(user);
        User saveUser =repo.save(user);

        Assertions.assertThat(saveUser).isNotNull();
        Assertions.assertThat(saveUser.getId()).isGreaterThan(0);


    }

    @Test
    public void testListAll(){
        Iterable<User> users= repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for(User user: users){
            System.out.println(user);
        }

    }

    @Test
    public  void updateUserTest(){

        Integer userId = 1;
        Optional<User> optionalUser = repo.findById(userId);
        User user = optionalUser.get();
        user.setPassword("hello");
        repo.save(user);

        User updateUser= repo.findById(userId).get();
        Assertions.assertThat ((updateUser.getPassword())).isEqualTo("hello");
    }

    @Test
    public void  testGet(){
        Integer userId=2;
        Optional<User> optionalUser=repo.findById(userId);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());
    }

    @Test
    public void deleteTest(){

        Integer userId=2;
        repo.deleteById(userId);

        Optional<User> optionalUser=repo.findById(userId);
        Assertions.assertThat(optionalUser).isNotPresent();

    }

}