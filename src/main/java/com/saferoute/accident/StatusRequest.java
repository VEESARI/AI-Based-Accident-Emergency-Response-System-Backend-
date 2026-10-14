package com.saferoute.accident;

import jakarta.validation.constraints.NotBlank;

public record StatusRequest(@NotBlank String status) {}