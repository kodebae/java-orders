package javaorders.app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import org.hibernate.criterion.Orders;
import java.util.ArrayList;
import javax.persistence.*;
import java.util.List;

/** Customers has a foreign key to Agents (AGENTCODE) this means:
 * Customers has a Many to One relationship to Agents and
 * Agents has a One to Many relationship to Customers
 * connect the customers table to the agents table in a many to one relation
 * * CUSTOMERS
 *   * CUSTCODE primary key, not null Long
 *   * CUSTNAME String, not null
 *   * CUSTCITY String
 *   * WORKINGAREA String
 *   * CUSTCOUNTRY String
 *   * GRADE String
 *   * OPENINGAMT double
 *   * RECEIVEAMT double
 *   * PAYMENTAMT double
 *   * OUTSTANDINGAMT double
 *   * PHONE String
 *   * AGENTCODE Long foreign key (one agent to many customers) not null
 *   ManyToOne relationship means that there is only one customer that this can be associated with.
 */



@Entity
@Table(name = "customers") // ignore customers coming from related tables with @JsonIgnore both lists and singular

public class Customer {
    //dim primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false) // when we create something it hads to have a name
    private long custcode;
    //dim name
    private String custname;
    //dim city
    private String custcity;
    //dim working area
    private String workingarea;
    //dim country
    private String custcountry;
    //dim grade
    private String grade;
    //dim opening amount
    private double openingamt;
    //dim receive amount
    private double receiveamt;
    //dim payment amount
    private double paymentamt;
    //dim outstanding amount
    private double outstandingamt;
    //dim phone
    private String phone;

    // must choose a field to join the two tables together in our case it is the agent code. Our join column name must match
// the generated value private long ID.
    @ManyToOne
    @JoinColumn(name = "agentcode", nullable = false) // a foreign key mean this connects customer to agent code table with this annotation
    @JsonIgnoreProperties(value = "customers")
    private Agent agent;

//connects customers to orders table which is the opposite in the other model. Only one customer per order

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true) //must be named exactly the same
    @JsonIgnoreProperties(value = "customer")
    List<Order> orders = new ArrayList<>();



    public Customer() { // This is the default constructor that is used by JPA. You must always have this.
    }

    public Customer(String custname, String custcity, String workingarea, String custcountry, String grade, double openingamt, double receiveamt, double paymentamt, double outstandingamt, String phone, Agent agent) {
        this.custname = custname;
        this.custcity = custcity;
        this.workingarea = workingarea;
        this.custcountry = custcountry;
        this.grade = grade;
        this.openingamt = openingamt;
        this.receiveamt = receiveamt;
        this.paymentamt = paymentamt;
        this.outstandingamt = outstandingamt;
        this.phone = phone;
        this.agent = agent;
//        this.orders = orders;
    } // closes constructor



    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getCustcity() {
        return custcity;
    }

    public void setCustcity(String custcity) {
        this.custcity = custcity;
    }

    public String getWorkingarea() {
        return workingarea;
    }

    public void setWorkingarea(String workingarea) {
        this.workingarea = workingarea;
    }

    public String getCustcountry() {
        return custcountry;
    }

    public void setCustcountry(String custcountry) {
        this.custcountry = custcountry;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getOpeningamt() {
        return openingamt;
    }

    public void setOpeningamt(double openingamt) {
        this.openingamt = openingamt;
    }

    public double getReceiveamt() {
        return receiveamt;
    }

    public void setReceiveamt(double receiveamt) {
        this.receiveamt = receiveamt;
    }

    public double getPaymentamt() {
        return paymentamt;
    }

    public void setPaymentamt(double paymentamt) {
        this.paymentamt = paymentamt;
    }

    public double getOutstandingamt() {
        return outstandingamt;
    }

    public void setOutstandingamt(double outstandingamt) {
        this.outstandingamt = outstandingamt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    } // closes getters and setters

}