package co.luisjavm3.loan.repository;

import java.util.List;
import java.util.Optional;

import co.luisjavm3.loan.Model.Entity.Loan;

public interface LoanRepository {
    Loan addLoan(Loan loan);

    Optional<Loan> findById(long id);

    List<Loan> findByBorrorerId(long borrorerId);
}
