package com.multicasa.multicasabackend.Repositories;

import com.multicasa.multicasabackend.Dtos.UserDto;
import com.multicasa.multicasabackend.Entities.Vivienda;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViviendaRepository extends JpaRepository<Vivienda, Integer> {

    @Transactional // Habilitar transacciones para el método
    @Modifying      // Indica que esta consulta no es un SELECT
    @Query("UPDATE Vivienda v SET v.descripcion = :descripcion WHERE v.id = :id")
    int updateDescripcionById(Integer id, String descripcion);

    @Transactional // Habilitar transacciones para el método
    @Modifying
    @Query("UPDATE Vivienda v SET v.vendida = true WHERE v.id = :id")
    int markAsSold(Integer id);

}