/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author User
 */
@Entity
@Table(name = "Pedidos")
public class Pedidos implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedidosId;
    
    private Long usuarioId;
    
    private double gastoTotal;
    
    
    @Column(name="create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;
   
    @PrePersist
    public void prePersist(){
        createAt = new Date();
    }
    //jsonbackreference es para evitar un bucle
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(name="Platos_Pedidos",
            joinColumns = @JoinColumn(name="pedidosId",referencedColumnName = "pedidosId"),
            inverseJoinColumns = @JoinColumn(name="platosId",referencedColumnName = "platosId"))
    private Set<Platos>platos = new HashSet<Platos>();

    public Set<Platos> getPlatos() {
        return platos;
    }

    public void setPlatos(Set<Platos> platos) {
        this.platos = platos;
    }
    

    public Long getPedidosId() {
        return pedidosId;
    }

    public void setPedidosId(Long pedidosId) {
        this.pedidosId = pedidosId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public double getGastoTotal() {
        return gastoTotal;
    }

    public void setGastoTotal(double gastoTotal) {
        this.gastoTotal = gastoTotal;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
    //metodo para añadir de muchos a muchos diferentes platos al pedido
    public void addPedidosPlatos(Platos plato)
    {
        this.platos.add(plato);
    }
    
    
    private static final Long serialVersionUID = 1L;
    
}
