package com.doncarlo.doncarlo.core.user;

import com.doncarlo.doncarlo.entites.User;
import com.doncarlo.doncarlo.http.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import com.doncarlo.doncarlo.http.exceptions.customs.NotFoundException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponse getUser(Authentication authentication){
        User user = userRepository.findByEmail(authentication.getName()).orElseThrow(NotFoundException::new);
        return new UserResponse(user);
    }
}
