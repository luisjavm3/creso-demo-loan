package co.luisjavm3.loan.Model.DTO.Loan;

import co.luisjavm3.loan.Model.DTO.Borrower.BorrowerDto;
import lombok.Data;

@Data
public class LoanDto {
    private Long id;
    // private Long borrowerId;
    private BorrowerDto borrower;
    private double principalAmount;
    private double interestRate;
    private int termInMonths;
}
