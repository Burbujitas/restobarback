/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.entity.TipoTrabajador;
import java.util.List;

/**
 *
 * @author User
 */
public interface ITipoTrabajadorService {
    
    public List<TipoTrabajador> findAll();
    
    
    
    public void save(TipoTrabajador tipoTrabajador);
}
