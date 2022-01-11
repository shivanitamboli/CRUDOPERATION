package com.webapp.repository;
        import com.webapp.model.User;
        import org.springframework.data.repository.CrudRepository;
public interface UserRepository  extends CrudRepository<User, Integer> {


}