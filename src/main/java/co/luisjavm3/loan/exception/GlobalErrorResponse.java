package co.luisjavm3.loan.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GlobalErrorResponse {
    @Builder.Default
    private boolean error = true;
    private String ErrorName;
    private String message;
}
