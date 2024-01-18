package com.infile.api.data.session;

import jakarta.validation.constraints.NotNull;

public record LoginRequest(@NotNull String user, @NotNull String password) {

}
