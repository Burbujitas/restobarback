/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Usuario;
import com.example.demo.model.cliente.MClienteVista;
import com.example.demo.model.cliente.MUsuarioCliente;
import com.example.demo.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/api")
public class ClienteController {
    
    
    private IClienteService clienteService;
    
    public ClienteController(IClienteService clienteService)
    {
        this.clienteService = clienteService;
    }
    
    @GetMapping("/ver_clientes")
    public ResponseEntity<Page<MClienteVista>> verClientes(@PageableDefault( size = 10 )Pageable paginacion)
    {
        return ResponseEntity.ok(clienteService.findAll(paginacion).map(MClienteVista::new));
    }
    
    @PostMapping("/crear_cliente")
    public ResponseEntity<Void> crearCliente(@RequestBody MUsuarioCliente ucliente)
    {
        
        clienteService.save(ucliente);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
}
