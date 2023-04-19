package com.springboot.contract.controller;

import com.springboot.contract.entity.CONTRACT;
import com.springboot.contract.service.ContractService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/contracts")
public class ContractController {

    private ContractService contractService;

    //build create Contract REST API
    @PostMapping
    public ResponseEntity<CONTRACT> createContract(@RequestBody CONTRACT contract){
        CONTRACT savedContract = ContractService.createContract(contract);
        return new ResponseEntity<>(savedContract , HttpStatus.CREATED);
    }

    //build get contract by id REST API
    //http://localhost:8080/api/contracts/1
    @GetMapping("{id}")
    public ResponseEntity<CONTRACT> getContractById(@PathVariable("id") Long contractId)
    {
        CONTRACT contract = ContractService.getContractById(contractId);
        return new ResponseEntity<>(contract , HttpStatus.OK);
    }

    //build Get All Contracts REST API
    //http:localhost:8080/api//contracts
    @GetMapping
    public ResponseEntity<List<CONTRACT>> getAllContracts(){
        List<CONTRACT> contracts = ContractService.getAllContracts();
        return new ResponseEntity<>(contracts, HttpStatus.OK);
    }

    //Build Update Contract REST API
    @PutMapping("{id}")
    //http://localhost:8080/api/contracts/1
    public ResponseEntity<CONTRACT> updateContract(@PathVariable("id") Long contractId, @RequestBody CONTRACT contract){
    contract.setId(contractId);
    CONTRACT updateContract = ContractService.updateContract(contract);
    return  new ResponseEntity<>(updateContract, HttpStatus.OK);
    }

    //Build Delete Contracts REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteContract(@PathVariable("id") Long contractId){
        ContractService.deleteContract(contractId);
        return new ResponseEntity<>("Contract successfully deleted!",HttpStatus.OK);
    }

}
