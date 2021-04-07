package ir.fanap.mehdisarfejoo.project.entity.device;

import ir.fanap.mehdisarfejoo.project.entity.simcard.SIMCard;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tablet")
public class Tablet extends Phone {

    public Tablet(SIMCard simCard) {
        super(simCard);
        this.setType("Tablet");
    }

    public Tablet() {
    }
}
