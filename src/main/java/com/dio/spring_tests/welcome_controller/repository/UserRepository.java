package com.dio.spring_tests.welcome_controller.repository;

import com.dio.spring_tests.welcome_controller.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private static List<User> users = new ArrayList<>();

    public void save(User user) {
        if (user.getId() == null) {
            System.out.println("Erro na criação do objeto, Id não existente");

            return;
        }

        if (findById(user.getId()).isPresent()) {

            int indexOfUser = 0;

            for (User actualUser : users) {
                if (actualUser.getId().equals(user.getId())) {
                    break;
                }

                indexOfUser = indexOfUser + 1;
            }

            System.out.println("Objeto alterado: " + users.get(indexOfUser));
            users.get(indexOfUser).setLogin(user.getLogin());
            System.out.println("Nova versao do objeto: " + users.get(indexOfUser));
            return;
        }

        System.out.println("Objeto criado: ");
        System.out.println(user.toString());
        users.add(user);
    }

    public void deleteById(Integer id) {
        if (!findById(id).isPresent()) {
            System.out.println("Erro ao deletar objeto, Id não existente");
            return;
        }

        User user = findById(id).get();

        System.out.println("Objeto removido: ");
        System.out.println(user.toString());
        users.remove(user);
    }

    public List<User> findAll() {
        for (User user : users) {
            System.out.println(user.toString());
            System.out.println("\n");
        }

        return users;
    }

    public Optional<User> findByUserName(String userName) {
        for (User user : users) {
            if (user.getLogin().equalsIgnoreCase(userName)) {
                System.out.println("Objeto com username: " + userName + " não foi encontrado");
                System.out.println(user.toString());
                return Optional.of(user);
            }
        }

        System.out.println("Objeto com username: " + userName + " não foi encontrado: ");
        return Optional.empty();
    }

    public Optional<User> findById(Integer id) {
        for (User user : users) {
            if (user.getId() == id) {
                System.out.println("Objeto com Id: " + id + " não foi encontrado");
                System.out.println(user.toString());
                return Optional.of(user);
            }
        }

        System.out.println("Objeto com Id: " + id + " não foi encontrado");
        return Optional.empty();
    }

}
