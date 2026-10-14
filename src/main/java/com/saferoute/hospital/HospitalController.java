package com.saferoute.hospital;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/hospitals")
public class HospitalController {
    private final HospitalRepository repository;
    public HospitalController(HospitalRepository repository) { this.repository = repository; }

    @GetMapping
    public List<Hospital> all() {
        return repository.findAll();
    }

    /*
     * This endpoint is a placeholder until real hospital coordinates and a
     * verified data source are configured. It deliberately does not claim
     * to return nearest or available hospitals.
     */
    @GetMapping("/nearby")
    public List<Hospital> nearby(@RequestParam Double lat, @RequestParam Double lng) {
        return repository.findAll().stream()
            .filter(h -> h.getLatitude() != null && h.getLongitude() != null)
            .toList();
    }
}