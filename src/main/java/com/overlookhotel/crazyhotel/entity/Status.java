package com.overlookhotel.crazyhotel.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private Long id;

    @Column(name = "name", length = 50, nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "status")
    private Set<Customer> customers;

    @OneToMany(mappedBy = "status")
    private Set<Employee> employees;

    // Constructors
    public Status() {}

    public Status(String name) {
        this.name = name;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
