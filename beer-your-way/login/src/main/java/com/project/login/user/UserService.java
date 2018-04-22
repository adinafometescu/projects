package com.project.login.user;

import com.project.login.exception.DuplicateAccountException;

import java.util.Optional;

public interface UserService {
    /**
     * @param email is considered to be unique
     * @return the user registered with the {@param email} or {@link Optional#empty()} if the user is not found
     */
    Optional<User> getUser(String email);

    /**
     * updates the {@param user} or creates a new one
     * if the user is not defined or valid {@link IllegalArgumentException} will be thrown
     *
     * @param user
     */
    void saveUser(User user);

    /**
     * creates a new user entry
     * if the user is already registered, the exception {@link DuplicateAccountException} will be thrown
     *
     * @param user
     * @throws DuplicateAccountException
     */
    void registerUser(User user) throws DuplicateAccountException;

    /**
     * deletes user by email
     *
     * @param email
     */
    void deleteUser(String email);
}
