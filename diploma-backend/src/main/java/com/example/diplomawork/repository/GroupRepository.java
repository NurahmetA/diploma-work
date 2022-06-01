package com.example.diplomawork.repository;

import com.example.diplomawork.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    Group findByInitialInitialAndName(String name, String initial);
}
