package co.luisjavm3.loan.service.Impl;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import co.luisjavm3.loan.Model.DTO.Borrower.BorrowerDto;
import co.luisjavm3.loan.Model.DTO.Loan.LoanDto;
import co.luisjavm3.loan.Model.DTO.Loan.LoanInsertDto;
import co.luisjavm3.loan.Model.Entity.Loan;
import co.luisjavm3.loan.client.BorrowerClient;
import co.luisjavm3.loan.exception.BorrowerNotFoundException;
import co.luisjavm3.loan.repository.LoanRepository;
import co.luisjavm3.loan.service.LoanService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {
    private final BorrowerClient borrowerClient;
    private final LoanRepository repository;
    private final ModelMapper mapper;

    @Override
    public LoanDto addLoan(LoanInsertDto request) {
        Loan newLoan = mapper.map(request, Loan.class);
        BorrowerDto borrower = null;

        try {
            borrower = borrowerClient.findById(newLoan.getBorrowerId());
        } catch (Exception e) {
            String message = MessageFormat.format("Borrower with Id: {0} not found.", newLoan.getBorrowerId());
            throw new BorrowerNotFoundException(message);
        }

        repository.addLoan(newLoan);
        var result = mapper.map(newLoan, LoanDto.class);
        result.setBorrower(borrower);
        return result;
    }

    @Override
    public Optional<LoanDto> findById(long id) {
        return repository.findById(id)
                .map(l -> {
                    BorrowerDto borrower;

                    try {
                        borrower = borrowerClient.findById(l.getBorrowerId());
                    } catch (Exception e) {
                        String message = MessageFormat.format("Borrower with Id: {0} not found.", l.getBorrowerId());
                        throw new BorrowerNotFoundException(message);
                    }

                    var result = mapper.map(l, LoanDto.class);
                    result.setBorrower(borrower);
                    return result;
                });
    }

    @Override
    public List<LoanDto> findByBorrorerId(long borrowerId) {
        return repository.findByBorrorerId(borrowerId).stream()
                .map(l -> mapper.map(l, LoanDto.class))
                .toList();
    }

    @Override
    public void removeLoan(long id) {
        repository.deleteLoan(id);
    }

}
