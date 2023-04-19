package com.springboot.contract.service;

import com.springboot.contract.entity.CONTRACT;

import java.util.List;

public interface ContractService {
    List<CONTRACT> getAllContracts = ;

    CONTRACT createContract(CONTRACT contract);

    CONTRACT getContractById(Long contractId);

    List<CONTRACT> getAllContracts();

    CONTRACT updateContract(CONTRACT contract);

    void deleteContract(Long contractId);
}
