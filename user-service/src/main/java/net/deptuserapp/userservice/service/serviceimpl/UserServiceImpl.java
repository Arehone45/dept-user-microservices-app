package net.deptuserapp.userservice.service.serviceimpl;

import lombok.AllArgsConstructor;
import net.deptuserapp.userservice.dto.DepartmentDto;
import net.deptuserapp.userservice.dto.ResponseDto;
import net.deptuserapp.userservice.dto.UserDto;
import net.deptuserapp.userservice.entity.User;
import net.deptuserapp.userservice.repository.UserRepository;
import net.deptuserapp.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public ResponseDto getUserDetails(Long userId) {

        ResponseDto responseDto = new ResponseDto();
        User user = userRepository.findById(userId).get();
        UserDto userDto = mapToUser(user);

        ResponseEntity<DepartmentDto> responseEntity = restTemplate
                .getForEntity("http://localhost:8080/department-app/getDepartmentById/" + user.getDepartmentId(),
                        DepartmentDto.class);

        DepartmentDto departmentDto = responseEntity.getBody();

        responseDto.setDepartment(departmentDto);
        responseDto.setUser(userDto);


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
