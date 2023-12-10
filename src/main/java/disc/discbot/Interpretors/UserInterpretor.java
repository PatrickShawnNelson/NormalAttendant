package disc.discbot.Interpretors;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import disc.discbot.dtos.UpdateUserRequest;
import disc.discbot.entities.DiscordUser;
import disc.discbot.exceptions.UserAlreadyExistsException;
import disc.discbot.repositories.UserRepository;
import disc.discbot.services.UserService;

public class UserInterpretor {
	 @Autowired
	 private UserRepository userRepository;
	 
	 @Autowired
	 private UserService userService;
	
	
	public DiscordUser updateUser(UpdateUserRequest request) throws Exception {
		Optional<DiscordUser> user = userRepository.findByUserName(request.getUserName());
		userService.saveOrUpdateUser(request);
        if (user.isEmpty()) {
        	DiscordUser u = new DiscordUser();
        	u.setUserName(request.getUserName());
            return userRepository.save(u);
        	
        } else {
        	throw new UserAlreadyExistsException();
        }
    }
}
