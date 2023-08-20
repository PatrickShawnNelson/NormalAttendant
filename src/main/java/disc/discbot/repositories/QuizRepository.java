package disc.discbot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import disc.discbot.entities.*;

import java.util.List;
import java.util.Optional;
public interface QuizRepository extends JpaRepository<User, Integer>  {

	//Optional<User> findByQuizId(int id);
	
	//Optional<List<User>> findAllByQuizNameNotNull();
}

