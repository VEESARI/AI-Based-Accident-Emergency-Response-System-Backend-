package com.saferoute.accident;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/accidents")
public class AccidentController {
    private final AccidentService service;

    public AccidentController(AccidentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Accident> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Accident byId(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Accident create(@Valid @RequestBody AccidentRequest request) {
        return service.create(request);
    }

    @PatchMapping("/{id}/status")
    public Accident updateStatus(@PathVariable Long id, @Valid @RequestBody StatusRequest request) {
        return service.updateStatus(id, request.status());
    }
}