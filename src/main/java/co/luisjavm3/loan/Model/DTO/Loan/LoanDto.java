package co.luisjavm3.loan.Model.DTO.Loan;

import lombok.Data;

@Data
public class LoanDto {
    private Long id;
    private Long borrowerId;
    private double principalAmount;
    private double interestRate;
    private int termInMonths;
}
