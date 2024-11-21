package com.multicasa.multicasabackend.Controllers;

import com.multicasa.multicasabackend.Entities.Casasvendidad;
import com.multicasa.multicasabackend.Services.CasasVendidasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/vender")
public class VenderController {
    @Autowired
    private CasasVendidasService casasVendidasService;
    @PostMapping("new")
    public ResponseEntity<Casasvendidad> create(@RequestBody Casasvendidad casasvendidad) {
        try{
            var result = casasVendidasService.create(casasvendidad);
            if(result == null) return ResponseEntity.noContent().build();
            return ResponseEntity.ok(result);
        }catch(Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }
}
