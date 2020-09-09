package javaorders.app.models;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agents")
public class Agent {
    @Id // The primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // We will let the database decide how to generate it
    @Column(nullable = false)
    private long agentcode; // long so we can have many rows * connects to the join column in joined table
    private String agentname;
    private String workingarea;
    private double commission;
    private String phone;
    private String country;

    //join the tables together and map one agent to many customers
    @OneToMany(mappedBy = "agent",
            cascade = CascadeType.ALL, // do this to both tables cascade down to other table
            orphanRemoval = true) // remove anything not associated with this table
    private List<Customer> customers = new ArrayList<>();

    public Agent() {
    }

    public Agent(String agentname, String workingarea, double commission, String phone, String country, List<Customer> customers) {
        this.agentname = agentname;
        this.workingarea = workingarea;
        this.commission = commission;
        this.phone = phone;
        this.country = country;
        this.customers = customers;
    }

    // Getters and Setters

    public String getAgentname() {
        return agentname;
    }

    public String getWorkingarea() {
        return workingarea;
    }

    public double getCommission() {
        return commission;
    }

    public String getPhone() {
        return phone;
    }

    public String getCountry() {
        return country;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public void setWorkingarea(String workingarea) {
        this.workingarea = workingarea;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public long getAgentcode() {
        return agentcode;
    }

    public void setAgentcode(long agentcode) {
        this.agentcode = agentcode;
    }

    // Other methods...

    @Override
    public String toString() {
        return "Agent{" +
                "agentcode=" + agentcode +
                ", agentname='" + agentname + '\'' +
                ", workingarea='" + workingarea + '\'' +
                ", commission=" + commission +
                ", phone='" + phone + '\'' +
                ", country='" + country + '\'' +
                ", customers=" + customers +
                '}';
    }
}

