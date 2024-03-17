package ru.trofimov.bookshare.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import ru.trofimov.bookshare.web.validation.OnCreate;
import ru.trofimov.bookshare.web.validation.OnUpdate;

@Schema(description = "User DTO")
public class UserDto {

    @Schema(description = "User id", example = "1")
    @NotNull(message = "Id must be not null!", groups = OnUpdate.class)
    private Long id;

    @Schema(description = "User name", example = "Ilya Trofimov")
    @NotNull(message = "Name must be not null!", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Name length mast be smaller than 255", groups = {OnCreate.class, OnUpdate.class})
    private String name;

    @Schema(description = "User email", example = "ilya_trofimov@gmail.com")
    @NotNull(message = "Username must be not null!", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Username length mast be smaller than 255", groups = {OnCreate.class, OnUpdate.class})
    private String username;

    @Schema(description = "User city", example = "Рязань")
    @NotNull(message = "User city must be not null!", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "User city length mast be smaller than 255", groups = {OnCreate.class, OnUpdate.class})
    private String city;

    @Schema(description = "User encrypted password", example = "$2a$10$JYYXLjRakzPfUlfno25ZAeegfZNauWQv3k3UtmMmm1dCff4ZZK0bq")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password must be not null!", groups = {OnCreate.class, OnUpdate.class})
    private String password;

    @Schema(description = "User password confirmation", example = "$2a$10$JYYXLjRakzPfUlfno25ZAeegfZNauWQv3k3UtmMmm1dCff4ZZK0bq")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password confirmation must be not null!", groups = OnCreate.class)
    private String passwordConfirm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
