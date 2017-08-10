package com.ufcg.si1.service;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

import java.util.List;

import com.ufcg.si1.model.Especialidade;


public interface UnidadeSaudeService {
    Object procura(int codigo) throws Rep,
            ObjetoInexistenteException;

    List<Object> getAll();

    void insere(Object us)throws Rep,
            ObjetoJaExistenteException;

    boolean existe(long codigo);

    Object findById(long id);

    Object findByBairro(String bairro);

}
