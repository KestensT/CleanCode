package be.cegeka.cleancode.domain.loyaltyCards;

import javax.persistence.*;

@Entity
@Table(name = "LOYALTY_CARD")
public class LoyaltyCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOYALTY_CARD_ID")
    private int id;
    @Column(name = "BARCODE")
    private String barcode;
    @Column(name = "BONUS_POINTS")
    private int bonusPoints;

    public LoyaltyCard() {
    }

    public LoyaltyCard(String barcode, int bonusPoints) {
        this.barcode = barcode;
        this.bonusPoints = bonusPoints;
    }

    public int getId() {
        return id;
    }
}

