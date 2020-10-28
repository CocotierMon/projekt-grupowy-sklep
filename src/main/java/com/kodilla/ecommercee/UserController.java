package com.kodilla.ecommercee;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @GetMapping(value = "getUsers")
    public List<String> getUsers(){
        return Arrays.asList("Adam Nowacki", "Stefan Kot", "Emilia Wąs");
    }

    @GetMapping(value = "getUser")
    public String getUser(@RequestParam Long userId){
        return "Adam Nowacki";
    }

    @PostMapping(value = "createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody String newUser){
        System.out.println("Create new user: " + newUser);
    }

    @PutMapping(value = "updateUser",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(@RequestParam Long userId, @RequestBody String updatedUserDetails){
        System.out.println("Update user: " + userId + " new details: " + updatedUserDetails);
    }

    @DeleteMapping(value = "deleteUser")
    public void deleteUser(@RequestParam Long userId){
        System.out.println("Delete user: " + userId);
    }
    @PutMapping(value = "blockUser")
    public void blockUser(@RequestParam Long userId){
       System.out.println("Block user: " + userId);
   }
   @GetMapping(value="generateUserKey")
    public BigInteger generateUserKey(@RequestParam Long userId){
       return new BigInteger("1354");
   }
}

