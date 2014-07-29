package br.com.condox.condoxapp.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by dudu on 18/06/14.
 */
public class Credenciado implements Serializable {

    public Long id;

    public double distancia;

    public String nome;

    public ArrayList<Especialidade> especialidades;

    public String codigo;

    public Localidade localidade;
}
