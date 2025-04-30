package co.luisjavm3.loan.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
    private Long id;
    private Long borrowerId;
    private double principalAmount;
    private double interestRate;
    private int termInMonths;
}
