package miu.waa.xuanloc.lab1.waalab1.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginResponseDto {
    private String accessToken;
    private String refreshToken;
}
