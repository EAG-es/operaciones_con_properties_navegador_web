package inweb.kaloria_wallet_navegador_web;

import innui.bases;
import java.net.URL;
import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import innui.modelos.comunicaciones.url.urls;
import innui.modelos.errores.oks;
import java.io.File;

public class navegador_web_peticiones extends bases {
    public static String k_navegador_web_redirect = "redirect:";
    public static String k_url_no_encontrada = "k_url_no_encontrada";
    
    public LinkedHashMap<String, i_navegador_web_peticiones> getUrl_inicios_mapa() {
        return url_inicios_mapa;
    }

    public void setUrl_inicios_mapa(LinkedHashMap<String, i_navegador_web_peticiones> url_inicios_mapa) {
        this.url_inicios_mapa = url_inicios_mapa;
    }

    public static interface i_navegador_web_peticiones {
        public String procesar_peticion(URL url, LinkedHashMap<String, String> datos_mapa
          , oks ok, Object... extras_array) throws Exception;

        /**
         * Adapta el formato de datos de un formularios HTML al formato de datos de un web_formulario
         * @param datos_mapa Mapa con los datos recibidos de la petición HTTP
         * @param ok
         * @param extras_array
         * @return
         * @throws Exception
         */
        public default List<Map.Entry<String, Object>> convertir_a_lista(LinkedHashMap<String, String> datos_mapa
                , oks ok, Object... extras_array) throws Exception {
            List<Map.Entry<String, Object>> clave_valor_lista = null;
            try {
                clave_valor_lista = new LinkedList<>();
                for (Map.Entry<String, String> entry : datos_mapa.entrySet()) {
                    clave_valor_lista.add(
                            new AbstractMap.SimpleEntry<>(entry.getKey(), entry.getValue()));
                }
            } catch (Exception e) {
                ok.setTxt(e);
            }
            return clave_valor_lista;
        }

    }
    public static String k_in_ruta;
    static {
        String paquete_tex = navegador_web_peticiones.class.getPackage().getName();
        paquete_tex = paquete_tex.replace(".", File.separator);
        k_in_ruta = "in/" + paquete_tex + "/in";
    }
    public LinkedHashMap<String, i_navegador_web_peticiones> url_inicios_mapa = new LinkedHashMap<>();

    /**
     * Compara ruta de la url con el mapa url_inicios_mapa.
     * Si la ruta a comparar termina por *, solo compara hasta el *; en oto caso, las rutas deben ser iguales.
     * @param url
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception
     */
    public i_navegador_web_peticiones _encontrar_peticion(URL url, oks ok, Object... extras_array) throws Exception {
        if (ok.es == false) {
            return null;
        }
        i_navegador_web_peticiones i_navegador_web_peticion = null;
        try {
            String ruta = url.getPath();
            String mapa_ruta;
            for (Map.Entry<String, i_navegador_web_peticiones> entry : getUrl_inicios_mapa().entrySet()) {
                mapa_ruta = entry.getKey();
                if (mapa_ruta.endsWith("*")) {
                    mapa_ruta = mapa_ruta.substring(0, mapa_ruta.length());
                    if (ruta.startsWith(mapa_ruta)) {
                        i_navegador_web_peticion = entry.getValue();
                        break;
                    }
                } else {
                    if (ruta.equals(mapa_ruta)) {
                        i_navegador_web_peticion = entry.getValue();
                        break;
                    }
                }
            }
            if (i_navegador_web_peticion == null) {
                ok.id = k_url_no_encontrada;
                ok.setTxt(k_url_no_encontrada, extras_array);
            }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return i_navegador_web_peticion;
    }

    /**
     * Procesa una petición recibida, y devuelve el texto HTML resultante
     * @param url
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception
     */
    public String procesar_peticion(URL url, oks ok, Object... extras_array) throws Exception {
        if (ok.es == false) { return null; }
        String retorno = null;
        try {
            i_navegador_web_peticiones i_navegador_web_peticion;
            i_navegador_web_peticion = _encontrar_peticion(url, ok, extras_array);
            if (ok.es == false) { return null; }
            LinkedHashMap<String, String> datos_mapa = new LinkedHashMap<>();
            urls.extraer_parametros_query(url, datos_mapa, ok);
            if (ok.es == false) { return null; }
            retorno = i_navegador_web_peticion.procesar_peticion(url, datos_mapa, ok, extras_array);
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return retorno;
    }

}
