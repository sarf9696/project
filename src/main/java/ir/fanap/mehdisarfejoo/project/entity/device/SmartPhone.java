package ir.fanap.mehdisarfejoo.project.entity.device;

import ir.fanap.mehdisarfejoo.project.entity.simcard.SIMCard;

import javax.persistence.Entity;

@Entity
public class SmartPhone extends Phone {

    public SmartPhone(SIMCard simCard) {
        super(simCard);
        this.setType("SmartPhone");
    }

    public SmartPhone() {
    }
}
