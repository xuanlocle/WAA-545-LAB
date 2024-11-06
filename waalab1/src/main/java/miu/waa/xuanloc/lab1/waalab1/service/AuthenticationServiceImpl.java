package miu.waa.xuanloc.lab1.waalab1.service;

import lombok.RequiredArgsConstructor;
import miu.waa.xuanloc.lab1.waalab1.entity.dto.LoginRequestDto;
import miu.waa.xuanloc.lab1.waalab1.entity.dto.LoginResponseDto;
import miu.waa.xuanloc.lab1.waalab1.entity.dto.RefreshTokenRequest;
import miu.waa.xuanloc.lab1.waalab1.repository.UserRepository;
import miu.waa.xuanloc.lab1.waalab1.util.JwtUtil;
import org.springframework.stereotype.Service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    @Override
    public LoginResponseDto authenticate(LoginRequestDto requestDto) {
        Authentication result = null;
        try {
            result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(requestDto.getEmail(), requestDto.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(e.getMessage());
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(result.getName());

        final String accessToken = jwtUtil.generateToken(userDetails);
        final String refreshToken = jwtUtil.generateRefreshToken(requestDto.getEmail());
        var loginResponse = new LoginResponseDto(accessToken, refreshToken);
        return loginResponse;
    }


    @Override
    public LoginResponseDto refreshToken(RefreshTokenRequest refreshTokenRequest) {
        boolean isRefreshTokenValid = jwtUtil.validateToken(refreshTokenRequest.getRefreshToken());
        if (isRefreshTokenValid) {
            var isAccessTokenExpired = jwtUtil.isTokenExpired(refreshTokenRequest.getAccessToken());
            final String accessToken;
            if (isAccessTokenExpired) {
                System.out.println("ACCESS TOKEN IS EXPIRED"); // TODO Renew is this case
                accessToken = jwtUtil.doGenerateToken(jwtUtil.getSubject(refreshTokenRequest.getRefreshToken()));
            } else {
                System.out.println("ACCESS TOKEN IS NOT EXPIRED");
                //validate accesstoken
                var isAccessTokenStillValid = jwtUtil.validateToken(refreshTokenRequest.getAccessToken());
                if (isAccessTokenStillValid) {
                    accessToken = refreshTokenRequest.getAccessToken();
                } else {
                    accessToken = jwtUtil.doGenerateToken(jwtUtil.getSubject(refreshTokenRequest.getRefreshToken()));
                }
            }
            var loginResponse = new LoginResponseDto(accessToken, refreshTokenRequest.getRefreshToken());
            return loginResponse;
        }
        return new LoginResponseDto();
    }
}
