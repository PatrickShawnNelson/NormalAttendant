package disc.discbot.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import disc.discbot.dtos.UpdateUserRequest;
import disc.discbot.entities.DiscordUser;
import disc.discbot.repositories.UserRepository;
import disc.discbot.services.UserService;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins="*")
public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService) {
        this.userService = userService;
    }

	@PutMapping("/update")
    public DiscordUser updateUser(@RequestBody UpdateUserRequest request) throws Exception {
        return userService.saveOrUpdateUser(request);
    }
}//taliaem