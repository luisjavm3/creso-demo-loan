package co.luisjavm3.loan.Model.DTO.Borrower;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BorrowerDto {
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
}
