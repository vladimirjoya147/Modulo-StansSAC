package com.cibertec.ModuloStandsSAC.Mapper;

import com.cibertec.ModuloStandsSAC.DTO.Mobiliario.MobiliarioMessage;
import com.cibertec.ModuloStandsSAC.DTO.Mobiliario.MobiliarioRequest;
import com.cibertec.ModuloStandsSAC.DTO.Mobiliario.MobiliarioResponse;
import com.cibertec.ModuloStandsSAC.Entity.Categoria;
import com.cibertec.ModuloStandsSAC.Entity.Mobiliario;
import org.mapstruct.Mapper;


public class MobiliarioMapper {

    public static Mobiliario toEntity (MobiliarioRequest mbr, Categoria cat){

        Mobiliario mb = new Mobiliario();
        mb.setIdMobiliario(mbr.getIdMobiliario());
        mb.setNombre(mbr.getNombre());
        mb.setCategoriaId(cat);
        mb.setEstadoMobiliario(mbr.getEstadoMobiliario());
        mb.setMaterial(mbr.getMaterial());
        mb.setVidaUtil(mbr.getVidaUtil());
        mb.setFechaAdquisicion(mbr.getFechaAdquisicion());
        mb.setPrecioUnitario(mbr.getPrecioUnitario());
        mb.setStock(mbr.getStock());
        return mb;
    }

    public static MobiliarioResponse toDTO (Mobiliario mb){
        MobiliarioResponse re = new MobiliarioResponse();
        re.setIdMobiliario(mb.getIdMobiliario());
        re.setNombre(mb.getNombre());
        re.setNombreCategoria(mb.getCategoriaId().getNombreCategoria());
        re.setEstadoMobiliario(mb.getEstadoMobiliario());
        re.setMaterial(mb.getMaterial());
        re.setVidaUtil(mb.getVidaUtil());
        re.setFechaAdquisicion(mb.getFechaAdquisicion());
        re.setEstado(mb.getEstado());
        re.setPrecioUnitario(mb.getPrecioUnitario());
        re.setStock(mb.getStock());
        return re;
    }
}
