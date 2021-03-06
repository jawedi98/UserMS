package tn.esprit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/users")
public class UserRestApi {
	@Autowired
	private UserService UserService;
@PostMapping("/addUser")
@ResponseStatus(HttpStatus.CREATED)
 public ResponseEntity<User> createUser(@RequestBody User user){
	return new ResponseEntity<>(UserService.addUser(user),HttpStatus.OK);
}
@PutMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
@ResponseStatus(HttpStatus.OK)
public ResponseEntity<User> updateUser(@PathVariable(value="id") int id ,@RequestBody User user){
	return new ResponseEntity<>(UserService.updateUser(user, id),HttpStatus.OK);
	
}
@DeleteMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
@ResponseStatus(HttpStatus.OK)
public ResponseEntity<String> deleteUser(@PathVariable(value="id") int id ){
	return new ResponseEntity<>(UserService.deleteUser(id),HttpStatus.OK);
	
}

}
