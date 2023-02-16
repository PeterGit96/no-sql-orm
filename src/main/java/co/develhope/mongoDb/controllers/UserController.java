package co.develhope.mongoDb.controllers;

import co.develhope.mongoDb.entities.User;
import co.develhope.mongoDb.exceptions.NotFoundException;
import co.develhope.mongoDb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        user.setId(null);
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) {
            throw new NotFoundException();
        }
        return user.get();
    }

    @PutMapping("edit/{id}")
    public User editUser(@PathVariable String id, @RequestBody  User user) {
        if(!userRepository.existsById(id)) {
            throw new NotFoundException();
        }
        user.setId(id);
        return userRepository.save(user);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        if(!userRepository.existsById(id)) {
            throw new NotFoundException();
        }
        userRepository.deleteById(id);
        return ResponseEntity.status(200).body("user with id: " + id + " deleted successfully");
    }

}
