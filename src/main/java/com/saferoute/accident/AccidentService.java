package com.saferoute.accident;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Set;

@Service
public class AccidentService {
    private static final Set<String> ALLOWED_STATUSES =
        Set.of("REPORTED", "UNDER_REVIEW", "ASSISTANCE_ASSIGNED", "RESOLVED");

    private final AccidentRepository repository;
    private final SeverityService severityService;

    public AccidentService(AccidentRepository repository, SeverityService severityService) {
        this.repository = repository;
        this.severityService = severityService;
    }

    public List<Accident> findAll() {
        return repository.findAllByOrderByCreatedAtDesc();
    }

    public Accident findById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Accident report not found"));
    }

    public Accident create(AccidentRequest request) {
        Accident accident = new Accident();
        accident.setReporterName(request.reporterName().trim());
        accident.setLocation(request.location().trim());
        accident.setLatitude(request.latitude());
        accident.setLongitude(request.longitude());
        accident.setAccidentType(request.accidentType().trim());
        accident.setPeopleAffected(request.peopleAffected());
        accident.setInjuries(request.injuries().trim());
        accident.setEmergencyRequired(request.emergencyRequired().trim());
        accident.setDescription(request.description() == null ? "" : request.description().trim());
        accident.setSeverity(severityService.estimate(request));
        accident.setStatus("REPORTED");
        return repository.save(accident);
    }

    public Accident updateStatus(Long id, String status) {
        String normalized = status == null ? "" : status.trim().toUpperCase();
        if (!ALLOWED_STATUSES.contains(normalized)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unsupported status");
        }
        Accident accident = findById(id);
        accident.setStatus(normalized);
        return repository.save(accident);
    }

    public DashboardStats stats() {
        return new DashboardStats(
            repository.count(),
            repository.countNotStatus("RESOLVED"),
            repository.countBySeverityAndStatusNot("HIGH", "RESOLVED"),
            repository.countByStatus("RESOLVED")
        );
    }

    public record DashboardStats(long totalReports, long activeCases, long highPriorityCases, long resolvedCases) {}
}