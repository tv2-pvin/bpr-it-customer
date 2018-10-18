package dk.bpr.it.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

@EqualsAndHashCode(callSuper = false)
@Data
@Builder
public class Customer extends ResourceSupport {
    private int identifier;
    private String name;
}
