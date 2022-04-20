package service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.springBootMongoDb.boot.mongo.repository.UserRepo;

@Component
public class CustomUserDetailsService implements UserDetailsService{
	
//	Logger logger = LoggerFactory.getLogger(CustomUserDetailService.class);
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(username.equals("Ashika")) {
			return new User("Ashika","123",new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("User not found !!!");
		}
//		User findByUsername = userRepo.findByUsername(username);
////		logger.info("findByUsername :{}", findByUsername);
//		if(ObjectUtils.isEmpty(findByUsername)) {
//			throw new UsernameNotFoundException("User not found !!!");
//		}else {
//			
//			return new org.springframework.security.core.userdetails.User(findByUsername.getUsername(), "{noop}"+findByUsername.getPassword(), new ArrayList<>());
//		}
		
	}

}
