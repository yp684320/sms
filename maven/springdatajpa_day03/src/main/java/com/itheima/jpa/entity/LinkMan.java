package com.itheima.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "link_man")
public class LinkMan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lkm_id")
    private Long linkMan_id;
    @Column(name = "lkm_name")
    private String linkManName;
    @Column(name = "lkm_address")
    private String linkManAddress;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lkm_cust_id",referencedColumnName = "cust_id")
    private Customer customer;
    public Long getLinkMan_id() {
        return linkMan_id;
    }

    public void setLinkMan_id(Long linkMan_id) {
        this.linkMan_id = linkMan_id;
    }

    public String getLinkManName() {
        return linkManName;
    }

    public void setLinkManName(String linkManName) {
        this.linkManName = linkManName;
    }

    public String getLinkManAddress() {
        return linkManAddress;
    }

    public void setLinkManAddress(String linkManAddress) {
        this.linkManAddress = linkManAddress;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "LinkMan{" +
                "linkMan_id=" + linkMan_id +
                ", linkManName='" + linkManName + '\'' +
                ", linkManAddress='" + linkManAddress + '\'' +
                ", customer=" + customer +
                '}';
    }
}
