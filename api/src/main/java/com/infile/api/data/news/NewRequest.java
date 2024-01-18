package com.infile.api.data.news;

import jakarta.validation.constraints.NotBlank;

public record NewRequest(@NotBlank Long idNew) {
}
