package disc.discbot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import disc.discbot.entities.*;

import java.util.List;
import java.util.Optional;
@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer>  {

	//Optional<User> findByQuizId(int id);
	Optional<Quiz> findByQuizName(String name);
	Optional<List<Quiz>> findAllByUserID(int id);
	//Optional<List<User>> findAllByQuizNameNotNull();
}

