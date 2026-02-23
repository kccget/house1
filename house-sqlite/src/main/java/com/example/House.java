package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "house")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String address;
    private Double price;
    private Integer area;
    private String owner;
    private String phone;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}
    public Double getPrice() {return price;}
    public void setPrice(Double price) {this.price = price;}
    public Integer getArea() {return area;}
    public void setArea(Integer area) {this.area = area;}
    public String getOwner() {return owner;}
    public void setOwner(String owner) {this.owner = owner;}
    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}
}
