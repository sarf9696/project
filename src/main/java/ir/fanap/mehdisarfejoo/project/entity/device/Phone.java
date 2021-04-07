package ir.fanap.mehdisarfejoo.project.entity.device;

import ir.fanap.mehdisarfejoo.project.entity.simcard.SIMCard;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries(
        {
                @NamedQuery(name = "Phone.findAll", query = "select p from Phone p order by p.id"),
                @NamedQuery(name = "Phone.countAll", query = "select count(*) from Phone p"),
                @NamedQuery(name = "Phone.findByNumber", query = "select p from Phone p join SIMCard s on p.simCard.id = s.id and p.simCard.number =: number")
        }
)

public abstract class Phone {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "simcard_id")
    private SIMCard simCard;

    @Column(name = "type")
    private String type;

    public Phone() {
    }

    // Constructor Injection
    public Phone(SIMCard simCard) {
        this.simCard = simCard;
    }

    public SIMCard getSimCard() {
        return simCard;
    }

    public String getType() {
        return type;
    }

    public void changeSimCard(SIMCard simCard) {
        this.simCard = simCard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSimCard(SIMCard simCard) {
        this.simCard = simCard;
    }

    public void setType(String type) {
        this.type = type;
    }
}


