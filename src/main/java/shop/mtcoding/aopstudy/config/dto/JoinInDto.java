package shop.mtcoding.aopstudy.config.dto;

import jakarta.validation.constraints.NotEmpty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinInDto {

    @NotNull
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    @Size(min = 4, max = 10)
    private String email;
}
