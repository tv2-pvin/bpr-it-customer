package dk.bpr.it.controller;

import dk.bpr.it.model.Customer;
import dk.bpr.it.model.CustomerList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private static final String APPLICATION_JSON = "application/json";

    @RequestMapping(value = "", method = GET, produces = APPLICATION_JSON)
    public ResponseEntity<CustomerList> getCustomers() {
        return ResponseEntity.ok(CustomerList.builder().build());
    }

    @RequestMapping(value = "", method = POST, produces = APPLICATION_JSON, consumes = APPLICATION_JSON)
    public ResponseEntity createCustomer(@RequestBody Customer customer) {
        return ResponseEntity
                .created(URI.create(
                        linkTo(methodOn(CustomerController.class)
                                .getCustomer(customer.getIdentifier()))
                                .withSelfRel().getHref()))
                .build();
    }

    @RequestMapping(value = "{id}", method = GET, produces = APPLICATION_JSON)
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") int id) {
        return ResponseEntity.ok(Customer.builder().identifier(id).build());
    }


}
