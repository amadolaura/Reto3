/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misiontic.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Laurita
 */
@Entity
@Table(name="client")
public class Client implements Serializable{
    
    @Id
    //Para que el id sea autogenerado
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
    private String email;
    private String password;
    private String name;
    private Integer age;
    
    //relacion entre client y messages
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    public List<Messages> messages;
    
    //relacion entre client y reservations
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "client")
    @JsonIgnoreProperties("client")
    public List<Reservations> reservations;
    

    /**
     * 
     * @return 
     */
    public List<Reservations> getReservations() {
        return reservations;
    }

    /**
     * 
     * @param reservations 
     */
    public void setReservations(List<Reservations> reservations) {
        this.reservations = reservations;
    }

    /**
     * 
     * @return 
     */
    public List<Messages> getMessages() {
        return messages;
    }

    /**
     * 
     * @param messages 
     */
    public void setMessages(List<Messages> messages) {
        this.messages = messages;
    }
  
    /**
     * 
     * @return 
     */
    public Integer getIdClient() {
        return idClient;
    }

    /**
     * 
     * @param idClient 
     */
    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    /**
     * 
     * @return 
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
}
