package com.Glosas_back.Repositorio;

import com.Glosas_back.Modelo.Glosas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlosasRepositorio extends JpaRepository<Glosas,Long> {
}
