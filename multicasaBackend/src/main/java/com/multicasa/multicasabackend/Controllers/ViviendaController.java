package com.multicasa.multicasabackend.Controllers;

import com.multicasa.multicasabackend.Dtos.ChartDto;
import com.multicasa.multicasabackend.Entities.Vivienda;
import com.multicasa.multicasabackend.Services.ViviendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/vivienda")
public class ViviendaController {

    @Autowired
    private ViviendaService viviendaService;

    @GetMapping("/viviendas")
    public ResponseEntity<List<Vivienda>> GetAllViviendas(){
        try{
            var result = viviendaService.GetViviendas();
            if(result.isEmpty()) return ResponseEntity.noContent().build();
            return ResponseEntity.ok(result);
        }catch(Exception ex){
            return ResponseEntity.status(500).build();
        }
    }
    @GetMapping("/vivienda")
    public ResponseEntity<Optional<Vivienda>> GetVivienda(@RequestParam int id){
        try{
            var result = viviendaService.GetVivienda(id);
            if(result.isEmpty()) return ResponseEntity.noContent().build();
            return ResponseEntity.ok(result);
        }catch(Exception ex){
            return ResponseEntity.status(500).build();
        }
    }
    @PostMapping("/new")
    public ResponseEntity<Vivienda> CreateVivienda(@RequestBody Vivienda vivienda){
        try{
            var result = viviendaService.CreateNewVivienda(vivienda);
            if(result == null) return ResponseEntity.status(500).build();
            return ResponseEntity.ok(result);
        }catch(Exception ex){
            return ResponseEntity.status(500).build();
        }
    }
    @PutMapping("/update")
    public ResponseEntity<Optional<Vivienda>> UpdateVivienda(@RequestParam Integer id, @RequestParam String descripcion){
        try{
            var result = viviendaService.Update(id, descripcion);
            return ResponseEntity.ok(result);
        }catch(Exception ex){
            return ResponseEntity.status(500).build();
        }
    }
    @GetMapping("/dashboard")
    public ResponseEntity<List<ChartDto>> GetVivienda(){
        try{
            var result = viviendaService.GetViviendasGraficas();
            if(result.isEmpty()) return ResponseEntity.noContent().build();
            return ResponseEntity.ok(result);
        }catch(Exception ex){
            return ResponseEntity.status(500).build();
        }
    }
}
