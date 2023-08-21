package disc.discbot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import disc.discbot.entities.*;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<DiscordUser, Integer>  {

	Optional<DiscordUser> findByUserID(int id);
	Optional<DiscordUser> findByUserName(String name);
	
	//Optional<List<User>> findAllByUserNameNotNull();
}

