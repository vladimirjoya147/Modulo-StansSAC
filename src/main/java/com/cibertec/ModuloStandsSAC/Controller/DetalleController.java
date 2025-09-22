package com.cibertec.ModuloStandsSAC.Controller;

import com.cibertec.ModuloStandsSAC.DTO.DetalleAlquiler.DetalleMessage;
import com.cibertec.ModuloStandsSAC.DTO.DetalleAlquiler.DetalleRequest;
import com.cibertec.ModuloStandsSAC.DTO.DetalleAlquiler.DetalleResponse;
import com.cibertec.ModuloStandsSAC.Service.DetalleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/detalle")
public class DetalleController {

    private final DetalleService detalleService;

    public DetalleController(DetalleService detalleService) {
        this.detalleService = detalleService;
    }

    @PostMapping("/guardar")
    public ResponseEntity<DetalleResponse> guardarDetalles (@RequestBody DetalleRequest detalleRequest){
        return ResponseEntity.ok(detalleService.guardarDetalle(detalleRequest));
    }

    @PatchMapping("/actualizar")
    public ResponseEntity<DetalleResponse> actualizarDetalles  (@RequestBody DetalleRequest detalleRequest){
        return ResponseEntity.ok(detalleService.atualizarDetalle(detalleRequest));
    }

    @PatchMapping("/eliminar/{id}")
    public ResponseEntity<DetalleMessage> eliminarDetallePorId(@PathVariable Integer id){
        return ResponseEntity.ok(detalleService.eliminarPorId(id));
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<DetalleResponse> buscarDetallePorId(@PathVariable Integer id){
        return ResponseEntity.ok(detalleService.buscarPorId(id));
    }

}
