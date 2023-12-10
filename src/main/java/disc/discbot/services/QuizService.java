package disc.discbot.services;

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
public class QuizService {

	private final QuizRepository quizRepo;
	
	private final UserRepository userRepo;

    public QuizService(QuizRepository quizRepository, UserRepository userRepository) {
        this.quizRepo = quizRepository;
        this.userRepo = userRepository;
    }
    
   public Quiz saveOrUpdateQuiz(QuizRequest request) throws Exception {
        Optional<Quiz> quiz = quizRepo.findByQuizName(request.getQuizName());
        Optional<DiscordUser> user = userRepo.findByUserName(request.getUserName());
        
        if (quiz.isEmpty()) {
        	Quiz q = new Quiz();
        	q.setQuizName(request.getQuizName());
        	q.setUserID(user.get().getUserId());
        	System.out.println("test quiz");
            return quizRepo.save(q);
        	
        } else {
        	throw new UserAlreadyExistsException();
        }
        
    }
}
