package com.cibertec.ModuloStandsSAC.Mapper;

import com.cibertec.ModuloStandsSAC.DTO.RegistroProyecto.ProyectoRequest;
import com.cibertec.ModuloStandsSAC.DTO.RegistroProyecto.ProyectoResponse;
import com.cibertec.ModuloStandsSAC.Entity.Cliente;
import com.cibertec.ModuloStandsSAC.Entity.Evento;
import com.cibertec.ModuloStandsSAC.Entity.RegistroProyecto;

public class RegistroMapper {

    public static RegistroProyecto registroToEntity (ProyectoRequest pr, Cliente cl, Evento ev ){
        RegistroProyecto rp = new RegistroProyecto();
        rp.setIdProyecto(pr.getIdProyecto());
        rp.setNombreProyecto(pr.getNombreProyecto());
        rp.setCliente(cl);
        rp.setIdEvento(ev);
        return rp;
    }

    public static ProyectoResponse registroToDTO (RegistroProyecto rp){
        ProyectoResponse pr = new ProyectoResponse();
        pr.setIdProyecto(rp.getIdProyecto());
        pr.setNombreProyecto(rp.getNombreProyecto());
        pr.setNombreEvento(rp.getIdEvento().getNombreEvento());
        pr.setNombreCliente(rp.getCliente().getNombreCliente());
        pr.setEstado(rp.getEstado());
        return pr;
    }

}
