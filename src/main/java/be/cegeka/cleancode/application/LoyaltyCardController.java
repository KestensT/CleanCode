package be.cegeka.cleancode.application;


import be.cegeka.cleancode.domain.customers.Customer;
import be.cegeka.cleancode.domain.loyaltyCards.LoyaltyCard;
import be.cegeka.cleancode.domain.loyaltyCards.LoyaltyCardService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "/loyaltycard")
@Transactional
public class LoyaltyCardController {

    @Inject
    private LoyaltyCardService loyaltyCardService;

    @GetMapping
    public List<LoyaltyCard> getAllCards() {
        return loyaltyCardService.getAllCards();
    }

    @PostMapping
    public void assignLoyaltyCardToMember(@RequestParam(value = "customerid") int customerId,
                                          @RequestParam(value = "barcode") String barcode) {
        loyaltyCardService.assignLoyaltyCardToMember(customerId, barcode);
    }
}

