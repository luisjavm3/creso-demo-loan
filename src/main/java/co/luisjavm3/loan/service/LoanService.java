package co.luisjavm3.loan.service;

import java.util.List;
import java.util.Optional;

import co.luisjavm3.loan.Model.DTO.Loan.LoanDto;
import co.luisjavm3.loan.Model.DTO.Loan.LoanInsertDto;

public interface LoanService {
    LoanDto addLoan(LoanInsertDto request);

    Optional<LoanDto> findById(long id);

    List<LoanDto> findByBorrorerId(long borrowerId);

    void removeLoan(long id);
}
