package javaorders.app.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
//import java.util.ArrayList;
import java.util.HashSet;
//import java.util.List;
import java.util.Set;

//* Orders has a foreign key to Customers (CUSTCODE)
//        * Orders has a Many to One relationship to Customers and
//        * Customers has a One to Many relationship to Orders
//
//        * Orders has a many to many relationship with payments
//        * multiple orders can use the same payment type and an order can have multiple payment types.
//        * For example, you can use both gift card and credit card to pay for an order.


@Entity
@Table(name = "orders")
public class Order {
    @Id // The primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // We will let the database decide how to generate it
    @Column(nullable = false)
    private long ordernum; // long so we can have many rows

    private double ordamount;
    private double advanceamount;
    private String orderdescription;



    @ManyToOne
    @JoinColumn(name = "custcode", nullable = false)
    private Customer customers;

    @ManyToMany()
    @JoinTable(name = "orderspayments",
            joinColumns = @JoinColumn(name = "ordnum"),
            inverseJoinColumns = @JoinColumn(name = "paymentid"))
    @JsonIgnoreProperties(value = "orders")
    private Set<Payment> payments = new HashSet<>();

    public Order() {
    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public String getOrderdescription() {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription) {
        this.orderdescription = orderdescription;
    }

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }
}

// Since this is a collection of data we are not going to bring it in with a constructor. There is only one payment related to each order.
//the JoinTable method tells us how our orders are connected to the payments
// we create the join table based upon the data we received in our read.me file
// the names of our JoinColumns must match the tables exactly, case, spelling etc if they are all in lowercase
// they will need to be names in lowercase.
// Not sure if I need to use List or Set here for the payments but used Set.
//