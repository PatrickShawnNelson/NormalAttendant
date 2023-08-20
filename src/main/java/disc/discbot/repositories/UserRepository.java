package disc.discbot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import disc.discbot.entities.*;

import java.util.List;
import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Integer>  {

	Optional<User> findByUserID(int id);
	
	Optional<List<User>> findAllByUserNameNotNull();
}

