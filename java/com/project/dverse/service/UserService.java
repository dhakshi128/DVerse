package com.project.dverse.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.dverse.ResourceNotFoundException;
import com.project.dverse.entity.UserEntity;
import com.project.dverse.repo.UserRepo;
@Service
public class UserService implements UserInterface{
	@Autowired
	private UserRepo userrepo;
	//Create user
	@Override
	public UserEntity createUser(UserEntity user){
		return userrepo.save(user);
	}
	//Read all users
	@Override
	public List<UserEntity> getAllUsers(){
		return userrepo.findAll();
	}
	//Read user by userName:
	@Override
	public UserEntity getUserById(Long id) {
		return userrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User Not Found"));
	}
	//Update
	@Override
	public UserEntity updateUser(Long id,UserEntity userdetails) {
		    UserEntity user=userrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User Not Found"));
			user.setUserName(userdetails.getUserName());
			user.setMailId(userdetails.getMailId());
			user.setPassword(userdetails.getPassword());
		    return userrepo.save(user);
	}
	//Delete
	@Override
	public void deleteUser(Long id) {
		UserEntity user=userrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User Not Found"));
		userrepo.delete(user);
	}
	

}
