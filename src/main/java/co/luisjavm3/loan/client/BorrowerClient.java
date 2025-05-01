package co.luisjavm3.loan.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import co.luisjavm3.loan.Model.DTO.Borrower.BorrowerDto;

@FeignClient(name = "borrower", url = "${creso.demo.borrower-service.url}")
public interface BorrowerClient {
    @GetMapping("/{id}")
    BorrowerDto findById(@PathVariable("id") long id);
}
