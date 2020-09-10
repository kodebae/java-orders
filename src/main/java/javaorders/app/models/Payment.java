package javaorders.app.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
//import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** PAYMENTS
* PAYMENTID primary key, not null long
* TYPE String not null
*/

// Primary keys and join columns have to be the same
@Entity // allows interaction with the table
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long paymentid;

    @Column(nullable = false) // when something is created it has to have a name
    private String type;

    @ManyToMany()
    @JoinTable(name = "orderspayments",
            joinColumns = @JoinColumn(name = "paymentid"),
            inverseJoinColumns = @JoinColumn(name = "ordnum"))
    @JsonIgnoreProperties(value = "payments")
    private Set<Order> orders = new HashSet<>();

    public Payment() { // we must generate our default constructor nothing goes inside of this
    }

    public Payment(String type) { // basic constructor for all the fields except ID's
        this.type = type;
    }

    // Getters and Setters


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    } // closes getter and setters
}
