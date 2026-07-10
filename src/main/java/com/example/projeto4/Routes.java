package com.example.projeto4;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userDB")
public class Routes {

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> allUser(){
        return ResponseEntity.ok(Data.allUsers());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> oneUser(@PathVariable int id){
        return ResponseEntity.ok(Data.oneUser(id));
    }

    @PostMapping("/newUser")
    public ResponseEntity<User> newUser(@RequestBody UserRequest req){
        return ResponseEntity.ok(Data.newUser(req.getName() , req.getAge() , req.getPassword()));
    }

    @PatchMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@RequestBody UserRequest req , @PathVariable int id){
        return ResponseEntity.ok(Data.updateUser(req.getName() , req.getAge() , req.getPassword() , id));
    }

    @DeleteMapping("/deleteUser/{id}")
    public  ResponseEntity<String>  deleteUser (@PathVariable int id){
        return ResponseEntity.ok(Data.deleteUser(id));
    }

}
