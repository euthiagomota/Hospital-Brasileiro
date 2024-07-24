package br.com.hospitalBrasileiro.Users;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
   private UserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity createUser(@RequestBody UserModel userModel) {
       UserModel user = this.userRepository.save(userModel);
       return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/")
    public ResponseEntity findAllUsers() {
        var users = this.userRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }


}
