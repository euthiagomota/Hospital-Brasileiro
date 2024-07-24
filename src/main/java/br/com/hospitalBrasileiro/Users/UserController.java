package br.com.hospitalBrasileiro.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

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

    @GetMapping("/{id}")
    public ResponseEntity findOneUser(UserModel userModel, @PathVariable UUID id) {
        UserModel user = this.userRepository.findById(id).orElse(null);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }


}
