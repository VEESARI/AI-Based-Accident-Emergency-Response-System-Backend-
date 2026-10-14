package com.saferoute.accident;

import org.springframework.stereotype.Service;

@Service
public class SeverityService {
    /*
     * Educational rule-based estimate only; this is NOT a validated medical
     * triage model and must never be used to delay real emergency assistance.
     */
    public String estimate(AccidentRequest request) {
        String injuries = request.injuries().toLowerCase();
        if (injuries.contains("serious")
                || request.peopleAffected() >= 4
                || request.emergencyRequired().equalsIgnoreCase("Multiple services")) {
            return "HIGH";
        }
        if (injuries.contains("minor") || request.peopleAffected() >= 2) {
            return "MEDIUM";
        }
        return "LOW";
    }
}