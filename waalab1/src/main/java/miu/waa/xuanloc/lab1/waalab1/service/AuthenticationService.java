package miu.waa.xuanloc.lab1.waalab1.service;

import miu.waa.xuanloc.lab1.waalab1.entity.dto.LoginRequestDto;
import miu.waa.xuanloc.lab1.waalab1.entity.dto.LoginResponseDto;
import miu.waa.xuanloc.lab1.waalab1.entity.dto.RefreshTokenRequest;

public interface AuthenticationService {

    LoginResponseDto authenticate(LoginRequestDto body);

    LoginResponseDto refreshToken(RefreshTokenRequest refreshTokenRequest);
}
