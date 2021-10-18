package Restfulwebservices.Restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService service ;

    @GetMapping("/Users")
    public List<User> RetrieveAllUsers(){
        return service.FindAll();
    }


    @GetMapping("/Users/{id}")
    public  User RetrieveOneUser(@PathVariable int id){
        User user = service.FindOne(id);
        if(user==null)
            throw new UserNotFoundException("id:"+id);
        return user;
    }

    @PostMapping("/Users")
    public ResponseEntity CreateUser(@Valid @RequestBody User user){

        User SavedUser =  service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(SavedUser.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @DeleteMapping("/Users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = service.deleteById(id);
        if(user==null)
            throw new UserNotFoundException("id:"+id);
    }

}

