package com.multicasa.multicasabackend.Services;

import com.multicasa.multicasabackend.Entities.Casasvendidad;
import com.multicasa.multicasabackend.Repositories.CasasVendidas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CasasVendidasService {
    @Autowired
    private CasasVendidas casasVendidas;

    @Autowired
    private ViviendaService viviendaService;

    public Casasvendidad create(Casasvendidad data){
        try{
            Casasvendidad record = casasVendidas.save(data);
            viviendaService.UpdateVendida(record.getHouse().getId());
            return data;
        }catch(Exception e){
            return null;
        }
    }
}
