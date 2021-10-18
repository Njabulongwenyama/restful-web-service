package Restfulwebservices.Restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import  java.util.Date;

@Component
public class UserDaoService {

    private static  List<User> users = new ArrayList<>();

    public static int countUser = 4;

    static {
        users.add(new User(1,"Eddy",new Date()));
        users.add(new User(2,"Jane",new Date()));
        users.add(new User(3,"Sam",new Date()));
        users.add(new User(4,"Jimmy",new Date()));
    }

    public List<User> FindAll(){
        return users;
    }


    public  User FindOne(int id){
        for(User user:users){
            if(user.getId()==id){
                return user;
            }
        }
        return null;
    }

    public User save (User user){
        if(user.getId()==null){
            user.setId(++countUser);
        }
        users.add(user);
        return user;
    }

    public User deleteById (int id){
        Iterator<User>iterator = users.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if(user.getId()==id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }


}
