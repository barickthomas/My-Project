package com.springboot.contract.serviceimpl;

import com.springboot.contract.entity.CONTRACT;
import com.springboot.contract.repository.ContractRepository;
import com.springboot.contract.service.ContractService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContractServiceImpl implements ContractService {
    @Override
    public CONTRACT createContract(CONTRACT contract) {
        return ContractRepository.save(contract);
    }

    @Override
    public CONTRACT getContractById(Long contractId) {
        Optional<CONTRACT> optionalCONTRACT=ContractRepository.findById(contractId);
        return optionalCONTRACT.get();
    }

    @Override
    public List<CONTRACT> getAllContracts() {
        return ContractRepository.findAll();
    }

    @Override
    public CONTRACT updateContract(CONTRACT contract) {
        CONTRACT existingContract = ContractRepository.findById(contract.getId()).get();
        existingContract.setName(contract.getName());
        existingContract.setPurpose(contract.getPurpose());
        CONTRACT updateContract = ContractRepository.save(existingContract);
        return updateContract;
    }

    @Override
    public void deleteContract(Long contractId) {
        ContractRepository.deleteById(contractId);

    }
}
