package com.cibertec.ModuloStandsSAC.Util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PdfGenerator {

    /**
     * Genera un PDF a partir de cualquier lista de objetos.
     * Retorna un arreglo de bytes que puede enviarse como descarga.
     *
     * @param lista              Objetos a incluir en el PDF
     * @param nombreBaseArchivo  Nombre base del archivo PDF (ej: "CategoriasReporte")
     * @return byte[] con el contenido del PDF
     */
    public static <T> byte[] generarReporte(List<T> lista, String nombreBaseArchivo) {
        if (lista == null || lista.isEmpty()) {
            System.out.println("❌ Lista vacía, no se genera PDF");
            return null;
        }

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Document document = new Document();
            PdfWriter.getInstance(document, baos);
            document.open();

            // Fuente
            Font tituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Font textoFont = FontFactory.getFont(FontFactory.HELVETICA, 12);

            // Título
            Paragraph titulo = new Paragraph("Reporte de " + nombreBaseArchivo, tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);

            // Fecha de generación
            String fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            document.add(new Paragraph("Generado el: " + fecha, textoFont));
            document.add(new Paragraph("\n"));

            // Tabla dinámica
            Class<?> clazz = lista.get(0).getClass();
            Field[] campos = clazz.getDeclaredFields();
            PdfPTable tabla = new PdfPTable(campos.length);

            // Encabezados
            for (Field f : campos) {
                tabla.addCell(f.getName());
            }

            // Contenido
            for (T item : lista) {
                for (Field f : campos) {
                    f.setAccessible(true);
                    Object valor = f.get(item);
                    tabla.addCell(valor != null ? valor.toString() : "");
                }
            }

            document.add(tabla);
            document.close();

            return baos.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
