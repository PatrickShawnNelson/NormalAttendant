package disc.discbot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import disc.discbot.dtos.QuizRequest;
import disc.discbot.dtos.UpdateUserRequest;
import disc.discbot.entities.DiscordUser;
import disc.discbot.entities.Quiz;
import disc.discbot.exceptions.UserAlreadyExistsException;
import disc.discbot.repositories.QuizRepository;
import disc.discbot.repositories.UserRepository;
import net.bytebuddy.asm.Advice.Return;

@Service
public class UserService {

	private final QuizRepository quizRepo;
	
	private final UserRepository userRepo;

    public UserService(QuizRepository quizRepository, UserRepository userRepository) {
        this.quizRepo = quizRepository;
        this.userRepo = userRepository;
    }
    
   public DiscordUser saveOrUpdateUser(UpdateUserRequest request) throws Exception {
        Optional<DiscordUser> user = userRepo.findByUserName(request.getUserName());

        if (user.isEmpty()) {
        	DiscordUser u = new DiscordUser();
        	u.setUserName(request.getUserName());
        	System.out.println("test user");
            return userRepo.save(u);
        	
        } else {
        	throw new UserAlreadyExistsException();
        }
        
    }
   
   public Optional<List<Quiz>> displayInfo(QuizRequest request) throws Exception {
       Optional<DiscordUser> user = userRepo.findByUserName(request.getUserName());
       Optional<List<Quiz>> quiz = quizRepo.findAllByUserID(user.get().getUserId());

       return quiz;
   }
}
