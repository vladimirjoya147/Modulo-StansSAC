package com.cibertec.ModuloStandsSAC.Controller;

import com.cibertec.ModuloStandsSAC.DTO.DetalleAlquiler.AlquilerDetalleProjection;
import com.cibertec.ModuloStandsSAC.DTO.Mobiliario.MobiliarioResponse;
import com.cibertec.ModuloStandsSAC.DTO.RegistroAlquiler.AlquilerDetalleResponse;
import com.cibertec.ModuloStandsSAC.DTO.RegistroAlquiler.AlquilerMessage;
import com.cibertec.ModuloStandsSAC.DTO.RegistroAlquiler.AlquilerRequest;
import com.cibertec.ModuloStandsSAC.DTO.RegistroAlquiler.AlquilerResponse;
import com.cibertec.ModuloStandsSAC.Service.AlquilerService;
import com.cibertec.ModuloStandsSAC.Util.PdfGenerator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alquiler")
public class RegistroAlquilerController {

    private final AlquilerService alquilerService;

    public RegistroAlquilerController(AlquilerService alquilerService) {
        this.alquilerService = alquilerService;
    }


    @GetMapping
    public ResponseEntity<List<AlquilerResponse>> listarTodosAlquileres (){
    	
    	   List<AlquilerResponse> alquiler = alquilerService.listarAlquilerActivos();
   	   
       return ResponseEntity.ok(alquiler);
       
    }
    
    // Endpoint PDF
    @GetMapping("/reporte")
    public ResponseEntity<byte[]> descargarReporteAlquileres() {
        List<AlquilerResponse> alquileres = alquilerService.listarAlquilerActivos();
        return PdfGenerator.generarReporte(alquileres, "AlquilerReporte.pdf");
    }
    
    
    
    
    @PostMapping("/guardar")
    public ResponseEntity<AlquilerResponse> guardarAlquileres(@RequestBody AlquilerRequest alquilerRequest){
        return ResponseEntity.ok(alquilerService.guardarAlquiler(alquilerRequest));
    }

    @PatchMapping("/actualizar")
    public ResponseEntity<AlquilerResponse> actualizarAlquileres(@RequestBody AlquilerRequest alquilerRequest){
        return ResponseEntity.ok(alquilerService.actualizarAlquiler(alquilerRequest));
    }

    @PatchMapping("/eliminar/{id}")
    public ResponseEntity<AlquilerMessage> eliminarAlquiler (@PathVariable Integer id){
        return ResponseEntity.ok(alquilerService.eliminarMessage(id));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<AlquilerResponse> buscarAlquilerPorId (@PathVariable Integer id){
        return ResponseEntity.ok(alquilerService.buscarPorId(id));
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<List<AlquilerDetalleProjection>> listarTodosAlquileresPorId (@PathVariable Integer id){
        return ResponseEntity.ok(alquilerService.listarAlquilerPorid(id));
    }

}
