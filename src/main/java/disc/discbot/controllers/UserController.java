package disc.discbot.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import disc.discbot.entities.User;
import disc.discbot.repositories.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins="*")
public class UserController {
	UserRepository repository;

    @GetMapping("/getAllusers")
    public Optional<List<User>> getAll() {
        return repository.findAllByUserNameNotNull();
}
    }//taliaem