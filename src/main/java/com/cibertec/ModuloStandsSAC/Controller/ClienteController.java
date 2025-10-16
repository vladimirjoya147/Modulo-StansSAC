package com.cibertec.ModuloStandsSAC.Controller;

import com.cibertec.ModuloStandsSAC.DTO.Categoria.CategoriaMessage;
import com.cibertec.ModuloStandsSAC.DTO.Categoria.CategoriaRequestDTO;
import com.cibertec.ModuloStandsSAC.DTO.Categoria.CategoriaResponseDTO;
import com.cibertec.ModuloStandsSAC.DTO.Cliente.ClienteMessage;
import com.cibertec.ModuloStandsSAC.DTO.Cliente.ClienteRequestDTO;
import com.cibertec.ModuloStandsSAC.DTO.Cliente.ClienteResponseDTO;
import com.cibertec.ModuloStandsSAC.Service.ClienteService;
import com.cibertec.ModuloStandsSAC.Util.PdfGenerator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    
    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listarTodosCategorias() {

        List<ClienteResponseDTO> clientes = clienteService.listarClientes();

        // Generación de PDF 
        PdfGenerator.generarReporte(clientes, "ClienteReporte.pdf");

        return ResponseEntity.ok(clientes);
    }
    
    
    @PostMapping("/guardar")
    public ResponseEntity<ClienteResponseDTO> guardarCatgerorias (@RequestBody ClienteRequestDTO clienteRequestDTO){
        return ResponseEntity.ok(clienteService.guardarCliente(clienteRequestDTO));
    }

    @PatchMapping("/actualizar")
    public ResponseEntity<ClienteResponseDTO> ActualizarCategorias (@RequestBody ClienteRequestDTO clienteRequestDTO){
        return ResponseEntity.ok(clienteService.guardarCliente(clienteRequestDTO));
    }

    @PatchMapping("/eliminar/{id}")
    public ResponseEntity<ClienteMessage> eliminarCategoriaPorId (@PathVariable Integer id){
        return ResponseEntity.ok(clienteService.eliminarPorId(id));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ClienteResponseDTO> buscarCategoriaPorId (@PathVariable Integer id){
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }
}
