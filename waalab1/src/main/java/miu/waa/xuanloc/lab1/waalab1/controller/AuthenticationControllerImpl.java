package miu.waa.xuanloc.lab1.waalab1.controller;

import lombok.RequiredArgsConstructor;
import miu.waa.xuanloc.lab1.waalab1.entity.dto.LoginRequestDto;
import miu.waa.xuanloc.lab1.waalab1.entity.dto.LoginResponseDto;
import miu.waa.xuanloc.lab1.waalab1.entity.dto.RefreshTokenRequest;
import miu.waa.xuanloc.lab1.waalab1.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/authenticate")
@RequiredArgsConstructor
@RestController
public class AuthenticationControllerImpl implements AuthenticationController {

    private final AuthenticationService service;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequest) {
        var loginResponse = service.authenticate(loginRequest);
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }

    @PostMapping("/refresh-token")
    public LoginResponseDto refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return service.refreshToken(refreshTokenRequest);
    }
}
