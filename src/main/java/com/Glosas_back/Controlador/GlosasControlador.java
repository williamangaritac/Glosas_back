package com.Glosas_back.Controlador;

import com.Glosas_back.Modelo.Glosas;
import com.Glosas_back.Repositorio.GlosasRepositorio;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class GlosasControlador {

    @Autowired
    private GlosasRepositorio repositorio;

    //este metodo sirve para listar todas las glosas
    @GetMapping("/glosas")
        public List<Glosas> listarTodasLasGlosas() {
        return repositorio.findAll();
    }

    //este metodo sirve para guardar una glosa
    @PostMapping("/glosas")
    public Glosas guardarGlosa(@RequestBody Glosas glosas) {
        return repositorio.save(glosas);
    }

    //este metodo sirve para buscar una glosa
    @GetMapping("/glosas/{id}")
    public ResponseEntity<Glosas> obtenerGlosaPorId(@PathVariable Long id){
        Glosas glosa = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe la GLOSA con el ID : " + id));
        return ResponseEntity.ok(glosa);
    }

    //este metodo sirve para actualizar una glosa
    @PutMapping("/glosas/{id}")
    public ResponseEntity<Glosas> actualizarGlosa(@PathVariable Long id,@RequestBody Glosas detallesGlosa){
        Glosas glosa = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe la glosa con el ID : " + id));
        //--------
        glosa.setNumeroFactura(detallesGlosa.getNumeroFactura());
        glosa.setEntidad(detallesGlosa.getEntidad());
        glosa.setClasificacion(detallesGlosa.getClasificacion());
        glosa.setValortotalfactura(detallesGlosa.getValortotalfactura());
        glosa.setFecharecepcionglosa(detallesGlosa.getFecharecepcionglosa());
        glosa.setValortotalglosaoratifi(detallesGlosa.getValortotalglosaoratifi());
        glosa.setDiastramite(detallesGlosa.getDiastramite());
        glosa.setFecharadicacionrtaglosa(detallesGlosa.getFecharadicacionrtaglosa());
        glosa.setOportunidad(detallesGlosa.getOportunidad());
        glosa.setObservaciones(detallesGlosa.getObservaciones());
        glosa.setConsglosa(detallesGlosa.getConsglosa());
        glosa.setCantidadrecepciones(detallesGlosa.getCantidadrecepciones());
        glosa.setValoraceptado(detallesGlosa.getValoraceptado());
        //--------
        Glosas glosaActualizado = repositorio.save(glosa);
        return ResponseEntity.ok(glosaActualizado);    }

    //este metodo sirve para eliminar una glosa
    @DeleteMapping("/glosas/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarGlosa(@PathVariable Long id){
        Glosas glosas = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe la glosa con el ID : " + id));
        repositorio.delete(glosas);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
