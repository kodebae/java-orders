package javaorders.app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import org.hibernate.criterion.Orders;

import javax.persistence.*;
import java.util.List;

//* Customers has a foreign key to Agents (AGENTCODE) this means:
//        * Customers has a Many to One relationship to Agents and
//        * Agents has a One to Many relationship to Customers
//connect the customers table to the agents table in a many to one relation

@ManyToOne
@JoinColumn(name = "agentcode", nullable = false)
@JsonIgnoreProperties("customer")
private Agent agent;

//connect customers to orders table in a one to many relation

@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true) //must be named exactly the same
@JsonIgnoreProperties("customer")
    List<Order> orders = new ArrayList<>();


@Entity
@Table(name = "customer")

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
//
//    //connect the customers table to the agents table in a many to one relation
//
//    @ManyToOne
//    @JoinColumn(name = "agentcode", nullable = false)
//    @JsonIgnoreProperties("customer")
//    private Agent agent;
//
//    //connect customers to orders table in a one to many relation
//
//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnoreProperties("customer")
//    List<Order> orders = new ArrayList<>();

    public Customer(String custname, String custcity, String workingarea, String custcountry, String grade, double openingamt, double receiveamt, double paymentamt, double outstandingamt, String phone, Agent agent, List<Order> orders) {
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
        this.orders = orders;
    } // closes constructor

    public Customer() {
    }

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