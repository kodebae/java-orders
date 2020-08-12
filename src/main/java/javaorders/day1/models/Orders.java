package javaorders.day1.models;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "orders")
public class Orders {
    @Id // The primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // We will let the database decide how to generate it
    @Column(nullable = false)
    private long ordernum; // long so we can have many rows

    private double ordamount;
    private double advanceamount;
    private String orderdescription;

    @ManyToOne
    @JoinColumn(name = "custcode", nullable = false)
    private Customer customer;

    @ManyToMany()
    @JoinTable(name = "orderspayments",
            joinColumns = @JoinColumn(name = "ordnum"),
            inverseJoinColumns = @JoinColumn(name = "paymentid"))
    @JsonIgnoreProperties(value = "orders")
    List<Payment> payments = new ArrayList<>();

    }
// Since this is a collection of data we are not going to bring it in with a constructor. There is only one payment related to each order.
//the JoinTable method tells us how our orders are connected to the payments
