package com.saferoute.accident;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
    private final AccidentService service;
    public DashboardController(AccidentService service) { this.service = service; }

    @GetMapping("/stats")
    public AccidentService.DashboardStats stats() {
        return service.stats();
    }
}