package com.example.projeto4;


import java.io.File;
import java.util.List;
import java.util.ArrayList;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;



public class Data {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final File file = new File("data.json");
    private static List<User> users = new ArrayList<>();

    static {
        try{
            if (file.exists() && file.length()>0){
                users = mapper.readValue(file, new TypeReference<List<User>>() {});
            } else{
                mapper.writerWithDefaultPrettyPrinter().writeValue(file , users);
            }
        } catch(Exception e){
            System.out.println("Aviso: JSON inválido detectado. Inicializando com lista vazia. Erro: " + e.getMessage());
            users = new ArrayList<>();
        }

    }


    public static List<User> allUsers(){
        return users;
    }

    public static User oneUser(int id){
        if ((id <0) && (id < users.size())){
            return users.get(id);
        }
        else{
            return null;
        }
    }

    public static User newUser(String name , int age , String password){
        User newUser = new User(name , age , password);
        users.add(newUser);
        saveToFile();

        return newUser;
    }

    public static User updateUser(String name , int age ,String password , int id){
        if ((id <0) && (id < users.size())){
            User foundUser =users.get(id);
            if (name != null){
                foundUser.setName(name);
            }
            if (age >= 0){
                foundUser.setAge(age);
            }
            if (password != null){
                foundUser.setPassword(password);
            }
            users.set(id,foundUser);
            saveToFile();
            return foundUser;
        }
        else{
            return null;
        }
    }

    public static String deleteUser(int id){
        if ((id <0) && (id < users.size())){
            users.remove(id);
            saveToFile();
            return "The user was deleted";
        }
        else{
            return null;
        }
    }

    private static void saveToFile(){
        mapper.writerWithDefaultPrettyPrinter().writeValue(file,users);
    }

}
