package com.test.trees.repository;

import com.test.trees.model.Volunteer;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
}

