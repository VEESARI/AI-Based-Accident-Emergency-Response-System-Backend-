package com.saferoute.accident;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "accidents")
public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String reporterName;
    @Column(nullable = false, length = 300)
    private String location;
    private Double latitude;
    private Double longitude;
    @Column(nullable = false, length = 80)
    private String accidentType;
    @Column(nullable = false)
    private Integer peopleAffected;
    @Column(nullable = false, length = 100)
    private String injuries;
    @Column(nullable = false, length = 100)
    private String emergencyRequired;
    @Column(length = 2000)
    private String description;
    @Column(nullable = false, length = 20)
    private String severity;
    @Column(nullable = false, length = 30)
    private String status;
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    void prePersist() {
        if (createdAt == null) createdAt = LocalDateTime.now();
        if (status == null) status = "REPORTED";
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getReporterName() { return reporterName; }
    public void setReporterName(String reporterName) { this.reporterName = reporterName; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }
    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
    public String getAccidentType() { return accidentType; }
    public void setAccidentType(String accidentType) { this.accidentType = accidentType; }
    public Integer getPeopleAffected() { return peopleAffected; }
    public void setPeopleAffected(Integer peopleAffected) { this.peopleAffected = peopleAffected; }
    public String getInjuries() { return injuries; }
    public void setInjuries(String injuries) { this.injuries = injuries; }
    public String getEmergencyRequired() { return emergencyRequired; }
    public void setEmergencyRequired(String emergencyRequired) { this.emergencyRequired = emergencyRequired; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}