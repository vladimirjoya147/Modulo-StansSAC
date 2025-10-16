package com.cibertec.ModuloStandsSAC.Controller;

import com.cibertec.ModuloStandsSAC.DTO.Mobiliario.MobiliarioResponse;
import com.cibertec.ModuloStandsSAC.DTO.Pais.PaisResponse;
import com.cibertec.ModuloStandsSAC.Service.PaisService;
import com.cibertec.ModuloStandsSAC.Util.PdfGenerator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pais")
public class PaisController {

    private final PaisService paisService;

    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    
    
    @GetMapping
    public ResponseEntity<List<PaisResponse>> listarProductos (){
    	
    	   List<PaisResponse> pais = paisService.listarPaises();
   	    // Generación de PDF 
          PdfGenerator.generarReporte(pais, "PaisReporte.pdf");
       return ResponseEntity.ok(pais);
       
    }
}
