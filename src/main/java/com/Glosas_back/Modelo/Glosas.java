package com.Glosas_back.Modelo;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "glosas")
//@CrossOrigin(origins = "http://localhost:4200")
public class Glosas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "numerofactura")
    private String NumeroFactura;

    @Column(name = "entidad")
    private String Entidad;

    @Column(name = "clasificacion")
    private String Clasificacion;

    @Column(name = "valortotalfactura")
    private String Valortotalfactura;

    @Column(name = "fecharecepcionglosa")
    private String Fecharecepcionglosa;

    @Column(name = "valortotalglosaoratifi")
    private String Valortotalglosaoratifi;

    @Column(name = "diastramite")
    private String Diastramite;

    @Column(name = "fecharadicacionrtaglosa")
    private String Fecharadicacionrtaglosa;

    @Column(name = "oportunidad")
    private String Oportunidad;

    @Column(name = "observaciones")
    private String Observaciones;

    @Column(name = "consglosa")
    private String Consglosa;

    @Column(name = "cantidadrecepciones")
    private String Cantidadrecepciones;

    @Column(name = "valoraceptado")
    private String Valoraceptado;

    @Column(name = "notacredito")
    private String Notacredito;

    @Column(name = "soportes")
    private String Soportes;

    @Column(name = "facturallegoxdev")
    private String Facturallegoxdev;

    @Column(name = "conciliada")
    private String Conciliada;

    @Column(name = "ratificadaxconciliacion")
    private String Ratificadaxconciliacion;

    @Column(name = "valorratifixconciliacion")
    private String Valorratifixconciliacion;


}
