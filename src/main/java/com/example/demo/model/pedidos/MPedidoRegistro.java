/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.example.demo.model.pedidos;

import javax.validation.constraints.NotNull;

/**
 *
 * @author User
 */
public record MPedidoRegistro(
        @NotNull
        Long usuarioId,
        @NotNull
        int numeroMesa
        ) {

}
