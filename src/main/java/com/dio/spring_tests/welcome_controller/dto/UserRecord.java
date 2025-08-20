package com.dio.spring_tests.welcome_controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRecord(@NotNull @NotBlank String login, @NotNull @NotBlank String password) {
}
