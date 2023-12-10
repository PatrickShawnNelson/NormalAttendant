package disc.discbot.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import disc.discbot.dtos.QuizRequest;
import disc.discbot.dtos.UpdateUserRequest;
import disc.discbot.entities.DiscordUser;
import disc.discbot.entities.Quiz;
import disc.discbot.repositories.UserRepository;
import disc.discbot.services.QuizService;
import disc.discbot.services.UserService;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/quiz")
@CrossOrigin(origins="*")
public class QuizController {
	private final QuizService quizService;
	
	public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

	@PutMapping("/update")
    public Quiz updateQuiz(@RequestBody QuizRequest request) throws Exception {
		System.out.println("Inside quiz controller");
        return quizService.saveOrUpdateQuiz(request);
    }
}//taliaem