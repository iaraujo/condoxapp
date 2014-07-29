package br.com.condox.condoxapp.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class ResultadoBusca implements Serializable {

    public String keywords;

    public ArrayList<Credenciado> credenciados;

    public String next_search_url;
}
