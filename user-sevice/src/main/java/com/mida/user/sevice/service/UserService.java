/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mida.user.sevice.service;

import java.util.List;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

/**
 *
 * @author asus
 */
public interface UserService {

    public List<SecurityProperties.User> getAllUsers();

    public void addUser(SecurityProperties.User user);

    public SecurityProperties.User updateUser(SecurityProperties.User user);

    public SecurityProperties.User deleteUser(String id);
    
}
