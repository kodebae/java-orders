package javaorders.app.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
//import java.util.ArrayList;
import java.util.HashSet;
//import java.util.List;
import java.util.Set;

/** Orders has a foreign key to Customers (CUSTCODE)
 * Orders has a Many to One relationship to Customers and
 * Customers has a One to Many relationship to Orders
 *
 * Orders has a many to many relationship with payments
 * multiple orders can use the same payment type and an order can have multiple payment types.
 * For example, you can use both gift card and credit card to pay for an order.
 * Many to Many relationship
 * ORDERSPAYMENTS (join table)
 * ORDERNUM foreign key to ORDERS
 * PAYMENTID foreign key to PAYMENTS.
 *
 * * ORDERS
 *   * ORDNUM primary key, not null Long
 *   * ORDAMOUNT double
 *   * ADVANCEAMOUNT double
 *   * CUSTCODE Long foreign key (one customer to many orders) not null
 *   * ORDERDESCRIPTION String
 */


@Entity
@Table(name = "orders")
public class Order {
    @Id // The primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // We will let the database decide how to generate it
    @Column(nullable = false)
    private long ordnum; // long so we can have many rows

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
    private Set<Payment> payments = new HashSet<>(); // forces us to have unique values

    public Order() { // This is the default constructor that is used by JPA. You must always have this.
    }

    public Order(double ordamount, double advancedamount, Customer customer, String orderdescription) {
        this.ordamount = ordamount;
        this.advanceamount = advancedamount;
        this.customer = customer;
        this.orderdescription = orderdescription;
    } // closes constructor


    // Getters and setters
    public double getOrdamount() {
        return ordamount;
    }

    public long getOrdernum() {
        return ordnum;
    }

    public void setOrdernum(long ordernum) {
        this.ordnum = ordernum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        return customer;
    }

    public void setCustomers(Customer customer) {
        this.customer = customer;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    public void addPayments(Payment payment) { this.payments.add(payment); }
}

// Since this is a collection of data we are not going to bring it in with a constructor. There is only one payment related to each order.
//the JoinTable method tells us how our orders are connected to the payments
// we create the join table based upon the data we received in our read.me file
// the names of our JoinColumns must match the tables exactly, case, spelling etc if they are all in lowercase
// they will need to be names in lowercase.
// Not sure if I need to use List or Set here for the payments but used Set.
//