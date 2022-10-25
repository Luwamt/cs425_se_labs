package edu.miu.cs.cs425.eregistrar_webapi_security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthRequest {

    @NotBlank(message = "Username canot be null, empty or blank(s)")
    private String username;

    @NotBlank(message = "Password can not be null, empty or blankspace(s)")
    //@Min(value = 6, message = "Must be at least 6 characters")
    private String password;
}
