package com.saferoute.accident;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record AccidentRequest(
    @NotBlank @Size(max = 120) String reporterName,
    @NotBlank @Size(max = 300) String location,
    Double latitude,
    Double longitude,
    @NotBlank @Size(max = 80) String accidentType,
    @NotNull @Min(1) @Max(1000) Integer peopleAffected,
    @NotBlank @Size(max = 100) String injuries,
    @NotBlank @Size(max = 100) String emergencyRequired,
    @Size(max = 2000) String description
) {}