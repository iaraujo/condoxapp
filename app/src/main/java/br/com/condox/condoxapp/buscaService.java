package br.com.condox.condoxapp;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import br.com.condox.condoxapp.bean.ResultadoBusca;

/**
 * Created by igoraraujo on 24/07/14.
 */
@Rest(rootUrl = "http://novabuscaamil.appspot.com/api", converters = {GsonHttpMessageConverter.class})
public interface buscaService {

    @Get("/search_credenciados/{keywords}/latitude/{latitude}/longitude/{longitude}/page_size/{page_size}/")
    ResultadoBusca buscarCredenciados(String keywords, double latitude, double longitude, int page_size);

}
