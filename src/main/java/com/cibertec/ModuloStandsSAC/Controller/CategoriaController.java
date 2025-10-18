package com.cibertec.ModuloStandsSAC.Controller;

import com.cibertec.ModuloStandsSAC.DTO.Categoria.CategoriaMessage;
import com.cibertec.ModuloStandsSAC.DTO.Categoria.CategoriaRequestDTO;
import com.cibertec.ModuloStandsSAC.DTO.Categoria.CategoriaResponseDTO;
import com.cibertec.ModuloStandsSAC.Service.CategoriaService;
import com.cibertec.ModuloStandsSAC.Util.PdfGenerator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;
    
   

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;

    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> listarTodosCategorias() {

        List<CategoriaResponseDTO> categorias = categoriaService.listarCategorias();

        return ResponseEntity.ok(categorias);
    }
    
    @GetMapping("/reporte")
    public ResponseEntity<byte[]> descargarReporteCategorias() {
        List<CategoriaResponseDTO> categorias = categoriaService.listarCategorias();
        return PdfGenerator.generarReporte(categorias, "CategoriasReporte.pdf");
    }

    @PostMapping("/guardar")
    public ResponseEntity<CategoriaResponseDTO> guardarCatgerorias (@RequestBody CategoriaRequestDTO categoriaRequestDTO){
        return ResponseEntity.ok(categoriaService.guardarCategoria(categoriaRequestDTO));
    }

    @PatchMapping("/actualizar")
    public ResponseEntity<CategoriaResponseDTO> ActualizarCategorias (@RequestBody CategoriaRequestDTO categoriaRequestDTO){
        return ResponseEntity.ok(categoriaService.guardarCategoria(categoriaRequestDTO));
    }

    @PatchMapping("/eliminar/{id}")
    public ResponseEntity<CategoriaMessage> eliminarCategoriaPorId (@PathVariable Integer id){
        return ResponseEntity.ok(categoriaService.eliminarPorId(id));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<CategoriaResponseDTO> buscarCategoriaPorId (@PathVariable Integer id){
        return ResponseEntity.ok(categoriaService.buscarPorId(id));
    }

}
