package com.itheima.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "cst_customerEtx")
public class CustomerEtx {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_etxId")
    private Long customerEtxId;
    @Column(name = "cust_etxName")
    private String customerEtxName;
    @OneToOne(mappedBy = "customerEtx")
//    @OneToOne
//    @JoinColumn(name = "c_id")
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getCustomerEtxId() {
        return customerEtxId;
    }

    public void setCustomerEtxId(Long customerEtxId) {
        this.customerEtxId = customerEtxId;
    }

    public String getCustomerEtxName() {
        return customerEtxName;
    }

    public void setCustomerEtxName(String customerEtxName) {
        this.customerEtxName = customerEtxName;
    }

    @Override
    public String toString() {
        return "CustomerEtx{" +
                "customerEtxId=" + customerEtxId +
                ", customerEtxName='" + customerEtxName + '\'' +
                ", customer=" + customer +
                '}';
    }
}
