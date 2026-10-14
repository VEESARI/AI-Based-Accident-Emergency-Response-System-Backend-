package com.saferoute.hospital;

import jakarta.persistence.*;

@Entity
@Table(name = "hospitals")
public class Hospital {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 150) private String name;
    @Column(nullable = false, length = 300) private String address;
    private Double latitude;
    private Double longitude;
    @Column(length = 50) private String phone;
    @Column(length = 500) private String services;
    private Boolean verifiedAvailability = false;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }
    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getServices() { return services; }
    public void setServices(String services) { this.services = services; }
    public Boolean getVerifiedAvailability() { return verifiedAvailability; }
    public void setVerifiedAvailability(Boolean verifiedAvailability) { this.verifiedAvailability = verifiedAvailability; }
}