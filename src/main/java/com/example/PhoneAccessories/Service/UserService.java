package com.example.PhoneAccessories.Service;

import com.example.PhoneAccessories.Dto.UserDto;
import com.example.PhoneAccessories.Model.Role;
import com.example.PhoneAccessories.Model.User;
import com.example.PhoneAccessories.Repository.UserRepository;
import com.example.PhoneAccessories.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleService roleService;

    @Autowired
    public UserService(UserRepository userRepository,RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    public Set<UserDto> returnAllUsers() {
        List<User> users = userRepository.findAll();
        Set<UserDto> collection = new HashSet<>();
        for(User user : users) {
            //UserDto userDto = modelMapper.map(user,UserDto.class);
            UserDto userDto = new UserDto();
            userDto.setAge(user.getAge());
            userDto.setUsername(user.getUsername());
            userDto.setRole(user.getRole().getName());

            collection.add(userDto);
        }
        return collection;
    }

    public void save(@NotNull UserDto userDto) {
        Role client = roleService.findByName("Client");

        User user = new User();
        user.setAge(userDto.getAge());
        user.setUsername(userDto.getUsername());
        user.setRole(client);

        userRepository.save(user);
    }

    public UserDto findByUsername(@NotNull String username) {
        User user = userRepository.findByUsername(username).orElseThrow(()
                ->new NotFoundException(String.format("User not found with username: %s",username)));

        UserDto userDto = new UserDto();
        userDto.setAge(user.getAge());
        userDto.setUsername(user.getUsername());
        userDto.setRole(user.getRole().getName());
        return userDto;
    }
    public void deleteByUsername(@NotNull String username) {
        userRepository.deleteByUsername(username);
    }
}
