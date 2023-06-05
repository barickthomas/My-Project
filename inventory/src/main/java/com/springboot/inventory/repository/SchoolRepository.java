package com.springboot.inventory.repository;

import com.springboot.inventory.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School,Long> {
}
