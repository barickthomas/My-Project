package com.springboot.contract.repository;

import com.springboot.contract.entity.CONTRACT;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<CONTRACT,Long> {
}
