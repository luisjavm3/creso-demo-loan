package co.luisjavm3.loan.repository.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import co.luisjavm3.loan.Model.Entity.Loan;
import co.luisjavm3.loan.repository.LoanRepository;

@Repository
public class LoanRepositoryDemoImpl implements LoanRepository {
    private static List<Loan> loans;

    static {
        loans = new ArrayList<>();
    }

    @Override
    public Loan addLoan(Loan loan) {
        long newIndex = loans.stream()
                .map(Loan::getId)
                .max(Long::compareTo)
                .orElse(0l);

        loan.setId(newIndex + 1);
        loans.add(loan);
        return loan;
    }

    @Override
    public Optional<Loan> findById(long id) {
        return loans.stream()
                .filter(l -> l.getId() == id)
                .findFirst();
    }

    @Override
    public List<Loan> findByBorrorerId(long borrorerId) {
        return loans.stream()
                .filter(l -> l.getBorrowerId() == borrorerId)
                .toList();
    }

    @Override
    public void deleteLoan(long id) {
        Loan loan = loans.stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);

        loans.remove(loan);
    }

}
