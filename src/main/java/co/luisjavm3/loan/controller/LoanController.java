package co.luisjavm3.loan.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.luisjavm3.loan.Model.DTO.Loan.LoanDto;
import co.luisjavm3.loan.Model.DTO.Loan.LoanInsertDto;
import co.luisjavm3.loan.service.LoanService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LoanController {
    private final LoanService service;

    @PostMapping
    public ResponseEntity<?> addLoan(@RequestBody LoanInsertDto request) {
        LoanDto result = service.addLoan(request);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        Optional<LoanDto> result = service.findById(id);

        if (result.isPresent())
            return ResponseEntity.ok(result.get());
        else
            return ResponseEntity.notFound().build();
    }
}
