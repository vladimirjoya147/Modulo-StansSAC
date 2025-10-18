package com.cibertec.ModuloStandsSAC.Controller;

import com.cibertec.ModuloStandsSAC.DTO.Evento.EventoMessage;
import com.cibertec.ModuloStandsSAC.DTO.Evento.EventoRequest;
import com.cibertec.ModuloStandsSAC.DTO.Evento.EventoResponse;
import com.cibertec.ModuloStandsSAC.Service.EventoService;
import com.cibertec.ModuloStandsSAC.Util.PdfGenerator;

import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evento")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    public ResponseEntity<List<EventoResponse>> listarEventos (){
        return ResponseEntity.ok(eventoService.listarEventos());
    }

    // Endpoint PDF
    @GetMapping("/reporte")
    public ResponseEntity<byte[]> descargarReporteEventos() {
        List<EventoResponse> eventos = eventoService.listarEventos();
        return PdfGenerator.generarReporte(eventos, "EventosReporte.pdf");
    }

    
    @PostMapping("/guardar")
    public ResponseEntity<EventoResponse> guardarEventos(@RequestBody EventoRequest eventoRequest){
        return ResponseEntity.ok(eventoService.guardarEvento(eventoRequest));
    }

    @PatchMapping("/actualizar")
    public ResponseEntity<EventoResponse> actualizarEventos(@RequestBody EventoRequest eventoRequest){
        return ResponseEntity.ok(eventoService.actualizarEvento(eventoRequest));
    }

    @PatchMapping("/eliminar/{id}")
    public ResponseEntity<EventoMessage> eliminarEvento(@PathVariable Integer id){
        return ResponseEntity.ok(eventoService.eliminarEventoPorId(id));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<EventoResponse> buscarEventoPorId(@PathVariable Integer id){
        return ResponseEntity.ok(eventoService.buscarEventoPorId(id));
    }
}
