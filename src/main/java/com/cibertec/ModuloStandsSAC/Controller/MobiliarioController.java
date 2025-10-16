package com.cibertec.ModuloStandsSAC.Controller;

import com.cibertec.ModuloStandsSAC.DTO.Evento.EventoResponse;
import com.cibertec.ModuloStandsSAC.DTO.Mobiliario.MobiliarioMessage;
import com.cibertec.ModuloStandsSAC.DTO.Mobiliario.MobiliarioRequest;
import com.cibertec.ModuloStandsSAC.DTO.Mobiliario.MobiliarioResponse;
import com.cibertec.ModuloStandsSAC.Entity.Mobiliario;
import com.cibertec.ModuloStandsSAC.Service.MobiliarioService;
import com.cibertec.ModuloStandsSAC.Util.PdfGenerator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mobiliario")
public class MobiliarioController {

    private final MobiliarioService mobiliarioService;

    public MobiliarioController(MobiliarioService mobiliarioService) {
        this.mobiliarioService = mobiliarioService;
    }

    @GetMapping
    public ResponseEntity<List<MobiliarioResponse>> listarMobiliarios (){
    	
    	   List<MobiliarioResponse> mobiliario = mobiliarioService.listarMobiliario();
   	    // Generación de PDF 
          PdfGenerator.generarReporte(mobiliario, "MobiliarioReporte.pdf");
       return ResponseEntity.ok(mobiliario);
       
    }
    
   
    

    @PostMapping("/guardar")
    public ResponseEntity<MobiliarioResponse> guardarMobiliarios (@RequestBody MobiliarioRequest mobiliarioRequest){
        return ResponseEntity.ok(mobiliarioService.guardarMobiliario(mobiliarioRequest));
    }

    @PatchMapping("/actualizar")
    public ResponseEntity<MobiliarioResponse> actualizarMobiliarios (@RequestBody MobiliarioRequest mobiliarioRequest){
        return ResponseEntity.ok(mobiliarioService.actualizarMobiliario(mobiliarioRequest));
    }


    @PatchMapping("/eliminar/{id}")
    public ResponseEntity<MobiliarioMessage> actualizarMobiliarios (@PathVariable Integer id){
        return ResponseEntity.ok(mobiliarioService.eliminarMobiliarioPorId(id));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarMobiliarioPorId (@PathVariable Integer id){
        return ResponseEntity.ok(mobiliarioService.buscarMobiliarioPorId(id));
    }


}
