package net.deptuserapp.userservice.service;

import net.deptuserapp.userservice.dto.ResponseDto;
import net.deptuserapp.userservice.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User saveUser(User user);
    ResponseDto getUserDetails(Long userId);
}
