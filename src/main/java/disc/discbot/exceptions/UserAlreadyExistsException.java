package disc.discbot.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyExistsException() {
        super("The user already exists");
    }
}