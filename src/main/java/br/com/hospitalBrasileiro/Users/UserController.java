package br.com.hospitalBrasileiro.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
   private UserRepository userRepository;

    public ResponseEntity createUser(@RequestBody UserModel userModel) {
       UserModel user = this.userRepository.save(userModel);
       return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
