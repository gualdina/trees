package com.test.trees.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
}

