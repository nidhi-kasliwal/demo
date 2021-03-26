package com.decathlon.alertSystem.repository;

import com.decathlon.alertSystem.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Native;
import java.util.List;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer,Long> {

    public Developer findDeveloperByPhoneNumber(String phoneNumber);
}
