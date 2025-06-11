package com.doncarlo.doncarlo.http.user;


import com.doncarlo.doncarlo.core.user.UserService;
import com.doncarlo.doncarlo.http.user.dto.UserResponse;
import com.doncarlo.doncarlo.utils.response.ResponseTemplate;
import com.doncarlo.doncarlo.utils.response.model.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{userId}")
    public Response<UserResponse> getUser(Authentication authentication){
        return ResponseTemplate.createResponse(userService.getUser(authentication));
    }

}
