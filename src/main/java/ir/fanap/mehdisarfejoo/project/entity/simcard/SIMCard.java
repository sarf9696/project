package ir.fanap.mehdisarfejoo.project.entity.simcard;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class SIMCard {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "balance",nullable = false,length = 50)
    protected double balance;

    @Column(name = "number",nullable = false)
    protected String number;

    public void charge(int amount) {
        balance += amount;
    }

    public String getName() {
        String className = this.getClass().getSimpleName().toUpperCase();
        return className.substring(0, className.length() - 7);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

