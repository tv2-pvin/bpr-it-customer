package dk.bpr.it.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@Builder
public class CustomerList extends ResourceSupport {
    @Builder.Default
    private List<Customer> customers = new ArrayList<>();
}
