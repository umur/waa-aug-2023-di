
package assignment1;

public class UserService {
	
	@Dependency
    private UserRepository userRepository;


    public UserRepository getUserRepository() {
        return userRepository;
    }
    
    public void setUserRepository(UserRepository userRepository) {
    	this.userRepository = userRepository;
    }
}
