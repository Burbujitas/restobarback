/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Trabajador;
import com.example.demo.model.trabajador.MTrabajadorVista;
import com.example.demo.model.trabajador.MUsuarioTrabajador;
import com.example.demo.service.ITrabajadorService;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/api")
public class TrabajadorController {
    
    
    private ITrabajadorService trabajadorService;
    
    public TrabajadorController(ITrabajadorService trabajadorService)
    {
        this.trabajadorService = trabajadorService;
    }
    
     @GetMapping("/ver_trabajadores")
    public ResponseEntity<Page<MTrabajadorVista>> verTrabajadores(@PageableDefault( size = 10 )Pageable paginacion)
    {
        return ResponseEntity.ok(trabajadorService.findAll(paginacion).map(MTrabajadorVista::new));
    }
    @GetMapping("/ver_trabajador/{idTrabajador}")
    public ResponseEntity<MTrabajadorVista> verTrabajdor(@PathVariable Long idTrabajador)
    {
        Trabajador trabajador = trabajadorService.buscarTrabajador(idTrabajador);
        MTrabajadorVista vistaTrabajador = new MTrabajadorVista(trabajador);
        
        return ResponseEntity.ok(vistaTrabajador);
    }
            
            
    @PostMapping("/crear_trabajador")
    public ResponseEntity<MTrabajadorVista> crearTrabajador(@RequestBody @Valid MUsuarioTrabajador muTrabajador,UriComponentsBuilder uriComponentsBuilder)
    {
        Trabajador trabajador = trabajadorService.save(muTrabajador);
        
        MTrabajadorVista trabajadorVista = new MTrabajadorVista(trabajador);
       
        URI url = uriComponentsBuilder.path("/api/ver_trabajador/{idTrabajador}").buildAndExpand(trabajador.getTrabajadorId()).toUri();
        
        return ResponseEntity.created(url).body(trabajadorVista);
    }
}
