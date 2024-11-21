package com.multicasa.multicasabackend.Services;

import com.multicasa.multicasabackend.Dtos.ChartDto;
import com.multicasa.multicasabackend.Dtos.Dataset;
import com.multicasa.multicasabackend.Entities.Vivienda;
import com.multicasa.multicasabackend.Repositories.ViviendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ViviendaService {

    @Autowired
    private ViviendaRepository viviendaRepository;

    public Vivienda CreateNewVivienda(Vivienda vivienda){
        try{
            viviendaRepository.save(vivienda);
            return vivienda;
        }catch(Exception ex){
            return null;
        }
    }
    public  Optional<Vivienda> UpdateVendida(Integer id){
        return GetVivienda(viviendaRepository.markAsSold(id));
    }
    public List<Vivienda> GetViviendas(){
        return viviendaRepository.findAll().stream().filter(x -> !x.getVendida()).toList();
    }
    public Optional<Vivienda> GetVivienda(int id){
        return viviendaRepository.findById(id);
    }
    public Optional<Vivienda> Update (Integer id, String descripcion){
        try{
            viviendaRepository.updateDescripcionById(id, descripcion);
            return GetVivienda(id);
        }catch(Exception ex){
            return null;
        }
    }
    public List<ChartDto> GetViviendasGraficas() {
        List<Vivienda> viviendas = viviendaRepository.findAll();

        // Colores base para los gráficos
        List<String> colors = List.of(
                "rgba(255, 99, 132, 0.6)",
                "rgba(75, 192, 192, 0.6)",
                "rgba(255, 206, 86, 0.6)",
                "rgba(54, 162, 235, 0.6)",
                "rgba(153, 102, 255, 0.6)"
        );

        // Gráfico 1: Viviendas Vendidas vs Disponibles
        ChartDto grafico1 = new ChartDto();
        grafico1.setLabels(List.of("Vendidas", "Disponibles"));

        Dataset dataset1 = new Dataset();
        dataset1.setLabel("Estado de Viviendas");
        dataset1.setData(List.of(
                (int) viviendas.stream().filter(Vivienda::getVendida).count(),
                (int) viviendas.stream().filter(v -> !v.getVendida()).count()
        ));
        dataset1.setBackgroundColor(List.of(colors.get(0), colors.get(1)));
        dataset1.setBorderColor(List.of("rgb(255, 99, 132)", "rgb(75, 192, 192)"));
        dataset1.setBorderWidth(1);

        grafico1.setDatasets(List.of(dataset1));

        // Gráfico 2: Viviendas agrupadas por estado
        Map<String, Long> viviendasPorEstado = viviendas.stream()
                .collect(Collectors.groupingBy(Vivienda::getEstado, Collectors.counting()));

        ChartDto grafico2 = new ChartDto();
        grafico2.setLabels(new ArrayList<>(viviendasPorEstado.keySet()));

        Dataset dataset2 = new Dataset();
        dataset2.setLabel("Viviendas por Estado");
        dataset2.setData(viviendasPorEstado.values().stream().map(Long::intValue).collect(Collectors.toList()));
        dataset2.setBackgroundColor(
                grafico2.getLabels().stream().map(l -> colors.get(2)).collect(Collectors.toList())
        );
        dataset2.setBorderColor(
                grafico2.getLabels().stream().map(l -> "rgb(255, 206, 86)").collect(Collectors.toList())
        );
        dataset2.setBorderWidth(1);

        grafico2.setDatasets(List.of(dataset2));

        // Gráfico 3: Viviendas agrupadas por número de recámaras
        Map<Integer, Long> viviendasPorRecamaras = viviendas.stream()
                .collect(Collectors.groupingBy(Vivienda::getRecamaras, Collectors.counting()));

        ChartDto grafico3 = new ChartDto();
        grafico3.setLabels(viviendasPorRecamaras.keySet().stream().map(String::valueOf).collect(Collectors.toList()));

        Dataset dataset3 = new Dataset();
        dataset3.setLabel("Viviendas por Recámaras");
        dataset3.setData(viviendasPorRecamaras.values().stream().map(Long::intValue).collect(Collectors.toList()));
        dataset3.setBackgroundColor(
                grafico3.getLabels().stream().map(l -> colors.get(3)).collect(Collectors.toList())
        );
        dataset3.setBorderColor(
                grafico3.getLabels().stream().map(l -> "rgb(54, 162, 235)").collect(Collectors.toList())
        );
        dataset3.setBorderWidth(1);

        grafico3.setDatasets(List.of(dataset3));
        int rango = 100000; // Rango de 100,000
        int maxPrecio = viviendas.stream()
                .mapToInt(v -> (int) Math.round(Double.parseDouble(v.getPrecio().toString())))
                .max()
                .orElse(0);
        int numRangos = (maxPrecio / rango) + 1;

        Map<String, Long> viviendasPorRango = new LinkedHashMap<>();
        for (int i = 0; i < numRangos; i++) {
            String rangoLabel = (i * rango) + "-" + ((i + 1) * rango - 1);
            int finalI = i;
            long count = viviendas.stream()
                    .filter(v -> v.getPrecio() >= finalI * rango && v.getPrecio() < (finalI + 1) * rango)
                    .count();
            viviendasPorRango.put(rangoLabel, count);
        }

        ChartDto grafico4 = new ChartDto();
        grafico4.setLabels(new ArrayList<>(viviendasPorRango.keySet()));

        Dataset dataset4 = new Dataset();
        dataset4.setLabel("Viviendas por Rango de Precio");
        dataset4.setData(viviendasPorRango.values().stream().map(Long::intValue).collect(Collectors.toList()));
        dataset4.setBackgroundColor(
                grafico4.getLabels().stream().map(l -> colors.get(4)).collect(Collectors.toList())
        );
        dataset4.setBorderColor(
                grafico4.getLabels().stream().map(l -> "rgb(153, 102, 255)").collect(Collectors.toList())
        );
        dataset4.setBorderWidth(1);
        grafico4.setDatasets(List.of(dataset4));
        return List.of(grafico1, grafico2, grafico3, grafico4);
    }


}
