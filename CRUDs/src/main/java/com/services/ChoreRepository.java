package com.services;

import com.entity.Chore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface ChoreRepository extends JpaRepository<Chore, Long> {
}
