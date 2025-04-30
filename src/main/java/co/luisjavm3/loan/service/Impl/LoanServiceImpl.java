package co.luisjavm3.loan.service.Impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import co.luisjavm3.loan.Model.DTO.Loan.LoanDto;
import co.luisjavm3.loan.Model.DTO.Loan.LoanInsertDto;
import co.luisjavm3.loan.Model.Entity.Loan;
import co.luisjavm3.loan.repository.LoanRepository;
import co.luisjavm3.loan.service.LoanService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {
    private final ModelMapper mapper;
    private final LoanRepository repository;

    @Override
    public LoanDto addLoan(LoanInsertDto request) {
        Loan newLoan = mapper.map(request, Loan.class);
        repository.addLoan(newLoan);
        return mapper.map(newLoan, LoanDto.class);
    }

    @Override
    public Optional<LoanDto> findById(long id) {
        return repository.findById(id)
                .map(l -> mapper.map(l, LoanDto.class));
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
