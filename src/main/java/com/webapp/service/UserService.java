package com.webapp.service;
        import com.webapp.model.User;
        import com.webapp.repository.UserRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public  List<User> userList(){
        return  (List<User>) userRepository.findAll();
    }

}