package net.deptuserapp.userservice.service.serviceimpl;

import lombok.AllArgsConstructor;
import net.deptuserapp.userservice.dto.ResponseDto;
import net.deptuserapp.userservice.dto.UserDto;
import net.deptuserapp.userservice.entity.User;
import net.deptuserapp.userservice.repository.UserRepository;
import net.deptuserapp.userservice.service.UserService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public User saveUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public ResponseDto getUserDetails(Long userId) {

        ResponseDto responseDto = new ResponseDto();
        User user = userRepository.findById(userId).get();

        UserDto userDto = mapToUser(user);

        responseDto.setUserDto(userDto);


        return responseDto;
    }

    private UserDto mapToUser(User user){
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());

        return userDto;
    }
}
