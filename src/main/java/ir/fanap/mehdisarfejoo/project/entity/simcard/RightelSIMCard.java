package ir.fanap.mehdisarfejoo.project.entity.simcard;

import javax.persistence.Entity;

@Entity
public class RightelSIMCard extends SIMCard {

    public RightelSIMCard() {
        this.balance = 0.0;
    }

    public void charge(int amount) {
        super.charge(amount);
    }

    public String getName() {
        return super.getName();
    }
}
