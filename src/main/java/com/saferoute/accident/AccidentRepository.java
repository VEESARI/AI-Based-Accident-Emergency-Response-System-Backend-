package com.saferoute.accident;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface AccidentRepository extends JpaRepository<Accident, Long> {
    List<Accident> findAllByOrderByCreatedAtDesc();

    @Query("select count(a) from Accident a where a.status <> :status")
    long countNotStatus(@Param("status") String status);

    long countBySeverityAndStatusNot(String severity, String status);
    long countByStatus(String status);
}