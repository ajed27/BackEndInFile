package com.infile.api.data.session;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record RegisterRequest(@Email @NotNull String email,
                              @NotNull String user,
                              @NotNull String password) {
}
