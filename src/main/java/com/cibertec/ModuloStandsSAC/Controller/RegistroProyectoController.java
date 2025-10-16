package com.cibertec.ModuloStandsSAC.Controller;

import com.cibertec.ModuloStandsSAC.DTO.RegistroAlquiler.AlquilerResponse;
import com.cibertec.ModuloStandsSAC.DTO.RegistroProyecto.ProyectoMessage;
import com.cibertec.ModuloStandsSAC.DTO.RegistroProyecto.ProyectoRequest;
import com.cibertec.ModuloStandsSAC.DTO.RegistroProyecto.ProyectoResponse;
import com.cibertec.ModuloStandsSAC.Service.ProyectoService;
import com.cibertec.ModuloStandsSAC.Util.PdfGenerator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/proyecto")
public class RegistroProyectoController {

    private final ProyectoService proyectoService;

    public RegistroProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }


    @GetMapping
    public ResponseEntity<List<ProyectoResponse>> listarProyectos (){
    	
    	   List<ProyectoResponse> proyecto = proyectoService.listarProyectoActivos();
   	    // Generación de PDF 
          PdfGenerator.generarReporte(proyecto, "ProyectoReporte.pdf");
       return ResponseEntity.ok(proyecto);
       
    }
    

    @PostMapping("/guardar")
    public ResponseEntity<ProyectoResponse> guardarProyectos(@RequestBody ProyectoRequest proyectoRequest){
        return ResponseEntity.ok(proyectoService.guardarProyecto(proyectoRequest));
    }

    @PatchMapping("/actualizar")
    public ResponseEntity<ProyectoResponse> actualizarProyectos(@RequestBody ProyectoRequest proyectoRequest){
        return ResponseEntity.ok(proyectoService.guardarProyecto(proyectoRequest));
    }

    @PatchMapping("/eliminar/{id}")
    public ResponseEntity<ProyectoMessage> eliminarProyectoPorId(@PathVariable Integer id){
        return ResponseEntity.ok(proyectoService.eliminarProyecto(id));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ProyectoResponse> buscarProyectoPorId(@PathVariable Integer id){
        return ResponseEntity.ok(proyectoService.buscarProyectoPorId(id));
    }

}
