package inweb.operaciones_con_properties_navegador_web;

import static inclui.formularios.control_entradas.k_entradas_tipo_archivo;
import static inclui.formularios.control_entradas.k_entradas_tipo_boton;
import static inclui.formularios.control_entradas.k_entradas_tipo_checkbox;
import static inclui.formularios.control_entradas.k_entradas_tipo_hidden;
import static inclui.formularios.control_entradas.k_entradas_tipo_submit;
import static inclui.formularios.control_entradas.k_entradas_tipo_texto;
import static ingui.javafx.operaciones_con_properties_navegador_web.Operaciones_con_properties_navegador_web.k_imagen_cabecera_ruta;
import static ingui.javafx.operaciones_con_properties_navegador_web.Operaciones_con_properties_navegador_web.k_imagen_ruta_tex;
import static ingui.javafx.operaciones_con_properties_navegador_web.Operaciones_con_properties_navegador_web.k_mensaje_cabecera_tex;
import static ingui.javafx.operaciones_con_properties_navegador_web.Operaciones_con_properties_navegador_web.k_mensaje_imagen_tex;
import static ingui.javafx.operaciones_con_properties_navegador_web.Operaciones_con_properties_navegador_web.k_opciones_mapa_nombre_fragmento_html;
import static ingui.javafx.operaciones_con_properties_navegador_web.Operaciones_con_properties_navegador_web.k_titulo_tex;
import innui.bases;
import static innui.formularios.formularios.k_importar_no_encontrado;
import innui.i_escrituras;
import innui.modelos.configuraciones.ResourceBundles;
import innui.modelos.configuraciones.Resources;
import innui.modelos.configuraciones.iniciales;
import innui.modelos.errores.oks;
import innui.modelos.internacionalizacion.tr;
import innui.operaciones_con_properties.operaciones_con_properties;
import inweb.kaloria_wallet_navegador_web.navegador_web_peticiones;
import inweb.modelos_html.formularios.control_entradas;
import inweb.modelos_html.formularios.control_redirecciones;
import inweb.modelos_html.formularios.control_textareas;
import inweb.modelos_html.formularios.control_textos;
import inweb.modelos_html.formularios.web_formularios;
import static inweb.modelos_html.formularios.web_formularios.k_nombre_fragmento;
import static inweb.modelos_html.formularios.web_formularios.k_valores_mapa_mensaje_error_tex;
import static inweb.modelos_html.formularios.web_formularios.k_valores_mapa_valor_tex;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.TreeMap;

/**
 *
 * @author emilio
 */
public class Operaciones_con_properties_web extends bases {
    public static String k_in_ruta;
    static {
        String paquete_tex = Operaciones_con_properties_web.class.getPackage().getName();
        paquete_tex = paquete_tex.replace(".", File.separator);
        k_in_ruta = "in/" + paquete_tex + "/in";
    }
    public static String k_index_html_ruta = "/re/templates/operaciones_con_properties/index.html";    
    public static String k_url_protocolo_host = "https://operacionesconproperties.app";
    public static String k_url_ruta_action_formulario_inicio = "/operaciones_con_properties/inicio";
    public static String k_url_ruta_action_formulario_buscar = "/operaciones_con_properties/buscar";
    public static String k_url_ruta_action_formulario_traducir = "/operaciones_con_properties/traducir";
    public static String k_url_ruta_action_formulario_leer_traduccion = "/operaciones_con_properties/leer_traduccion";
    public static String k_valores_mapa_url_destino_tex = "url_destino_tex";
    public static String k_fragmentos_principales_ruta = "/re/templates/formularios/fragmentos/fragmentos_principales.html";
    public static String k_fragmentos_operaciones_con_properties_ruta = "/re/templates/operaciones_con_properties/fragmentos/fragmentos_operaciones_con_properties.html";
    public static String k_formulario_tex = "formulario_tex";
    public static String k_index_control_texto = "index_control_texto";
    public static String k_enviar_boton = "enviar_boton";
    public static String k_cancelar_boton = "cancelar_boton";
    public static String k_inicio_buscar_boton = "buscar_boton";
    public static String k_inicio_traducir_boton = "traducir_boton";
    public static String k_ruta_carpeta = "ruta_carpeta";
    public static String k_fragmento_texto = "fragmento_texto";
    public static String k_mensaje_tex_0 = "mensaje_tex_0";
    public static String k_mensaje_tex_1 = "mensaje_tex_1";
    public static String k_properties_texto = "properties_texto";
    public static String k_properties_errores_texto = "properties_errores_texto";
    public static String k_nombre_archivo = "nombre_archivo";
    public static String k_ruta_archivo = "ruta_archivo";
    public static String k_leer_traduccion_traduccion = "leer_traduccion_traduccion";
    public static String k_leer_traduccion_valor = "leer_traduccion_valor";
    public static String k_leer_traduccion_clave = "leer_traduccion_clave";
    public static String k_leer_traduccion_unicode = "leer_traduccion_unicode";
    public static String k_separador = "///";
    public web_formularios wallet_formulario;
    public navegador_web_peticiones navegador_web_peticion = new navegador_web_peticiones();
    public web_formularios index_formulario;
    public web_formularios error_formulario;
    public web_formularios inicio_formulario;
    public web_formularios buscar_textos_formulario;
    public web_formularios properties_formulario;
    public web_formularios traducir_formulario;
    public web_formularios leer_traduccion_formulario;
    public control_textos index_control_texto;
    public operaciones_con_properties operacion_con_propertie;
    public navegador_web_peticiones.i_navegador_web_peticiones inicio_i_navegador_web_peticiones
      = new navegador_web_peticiones.i_navegador_web_peticiones() {
        @Override
        public String procesar_peticion(URL url, LinkedHashMap<String, String> datos_mapa
                , oks ok, Object... extras_array) throws Exception {
            return procesar_formulario_inicio(datos_mapa
                    , convertir_a_lista(datos_mapa, ok), ok, extras_array);
        }
    };      
    public navegador_web_peticiones.i_navegador_web_peticiones buscar_i_navegador_web_peticiones
      = new navegador_web_peticiones.i_navegador_web_peticiones() {
        @Override
        public String procesar_peticion(URL url, LinkedHashMap<String, String> datos_mapa
                , oks ok, Object... extras_array) throws Exception {
            return procesar_formulario_buscar_textos(datos_mapa
                    , convertir_a_lista(datos_mapa, ok), ok, extras_array);
        }
    };      
    public navegador_web_peticiones.i_navegador_web_peticiones traducir_i_navegador_web_peticiones
      = new navegador_web_peticiones.i_navegador_web_peticiones() {
        @Override
        public String procesar_peticion(URL url, LinkedHashMap<String, String> datos_mapa
                , oks ok, Object... extras_array) throws Exception {
            return procesar_formulario_traducir(datos_mapa
                    , convertir_a_lista(datos_mapa, ok), ok, extras_array);
        }
    };      
    public navegador_web_peticiones.i_navegador_web_peticiones leer_traduccion_i_navegador_web_peticiones
      = new navegador_web_peticiones.i_navegador_web_peticiones() {
        @Override
        public String procesar_peticion(URL url, LinkedHashMap<String, String> datos_mapa
                , oks ok, Object... extras_array) throws Exception {
            return procesar_formulario_leer_traduccion(datos_mapa
                    , convertir_a_lista(datos_mapa, ok), ok, extras_array);
        }
    };      
    /**
     * Obtiene el código HTML para la captura
     * @param formulario
     * @param valores_mapa
     * @param destino_direccion
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception
     */
    public String capturar_formulario(web_formularios formulario, Map <String, String> valores_mapa
      , String destino_direccion, oks ok, Object... extras_array) throws Exception {
        if (ok.es == false) { return null; }
        String retorno = null;
        ResourceBundle in;
        in = ResourceBundles.getBundle(k_in_ruta);
        try {
            if (ok.es == false) { return null; }
            if (valores_mapa == null) {
                valores_mapa = new HashMap<>();
            }
            valores_mapa.put(k_valores_mapa_url_destino_tex
              , k_url_protocolo_host + destino_direccion);
            formulario.iniciar(k_fragmentos_principales_ruta, valores_mapa, null, ok);
            if (ok.es == false) { return null; }
            formulario.iniciar(k_fragmentos_operaciones_con_properties_ruta, null, null, ok);
            if (ok.es == false) { return null; }
            formulario.capturar(ok, extras_array);
            if (ok.es == false) { return null; }
            retorno = formulario.getContenido_formulario_html();
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return retorno;
    }
    /**
     * Obtiene el código HTML para la captura
     * @param contenido
     * @param mensaje
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception
     */
    public String capturar_formulario_index(String contenido, String mensaje, oks ok, Object... extras_array) throws Exception {
        if (ok.es == false) { return null; }
        String retorno = null;
        try {
            Map<String, String> valores_mapa = new HashMap<>();
            index_control_texto.getValor().put(k_valores_mapa_mensaje_error_tex, mensaje);
            index_control_texto.getValor().put(k_formulario_tex, contenido);
            index_formulario.iniciar(k_index_html_ruta, valores_mapa, null, ok);
            if (ok.es == false) { return null; }
            index_formulario.capturar(ok);
            if (ok.es == false) { return null; }
            retorno = index_formulario.getContenido_formulario_html();
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return retorno;
    }
    /**
     *
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception
     */
    public boolean crear_formulario_index(oks ok, Object... extras_array) throws Exception {
        ResourceBundle in;
        try {
            if (ok.es == false) { return ok.es; }
            in = ResourceBundles.getBundle(k_in_ruta);
            Map <String, Object> opciones_mapa = new HashMap<>();
            index_formulario = new web_formularios();
            index_formulario.escritura = escritura;
            opciones_mapa.put(k_nombre_fragmento, k_opciones_mapa_nombre_fragmento_html);
            Map<String, String> index_valores_mapa;
            index_valores_mapa = new HashMap<>();
            index_valores_mapa.put(k_titulo_tex, tr.in(in, "Operaciones con properties "));
            index_valores_mapa.put(k_mensaje_imagen_tex, k_imagen_cabecera_ruta);
            URL imagen_url;
            imagen_url = Resources.getResource(k_imagen_cabecera_ruta);
            String imagen_tex = "file://" + imagen_url.getPath();
            index_valores_mapa.put(k_imagen_ruta_tex, imagen_tex);
            index_valores_mapa.put(k_mensaje_cabecera_tex, tr.in(in, "Operaciones con properties "));
            index_valores_mapa.put(k_formulario_tex, "");
            index_control_texto = new inweb.modelos_html.formularios.control_textos();
            if (ok.es == false) { return ok.es; }
            index_control_texto.poner_en_formulario(index_formulario, k_index_control_texto
              , index_valores_mapa, null, opciones_mapa, ok);
            if (ok.es == false) { return ok.es; }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return ok.es;
    }
    /**
     *
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception
     */
    public boolean crear_formulario_error(oks ok, Object... extras_array) throws Exception {
        ResourceBundle in;
        try {
            if (ok.es == false) { return ok.es; }
            in = ResourceBundles.getBundle(k_in_ruta);
            error_formulario = new web_formularios();
            error_formulario.escritura = escritura;
            control_entradas error_cancelar_control_entrada = new control_redirecciones();
            error_cancelar_control_entrada.iniciar(k_entradas_tipo_boton, ok);
            if (ok.es == false) { return false; }
            HashMap<String, Object> valores_mapa = new HashMap<>();
            valores_mapa.put(k_valores_mapa_url_destino_tex
                    , k_url_protocolo_host + k_url_ruta_action_formulario_inicio);
            error_cancelar_control_entrada.poner_en_formulario(error_formulario, k_cancelar_boton
                    , valores_mapa, tr.in(in, "Inicio"), null, ok);
            if (ok.es == false) { return ok.es; }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return ok.es;
    }
    /**
     * 
     * @param inicial
     * @param operacion_con_propertie
     * @param i_escritura
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception 
     */
    public boolean iniciar(iniciales inicial, operaciones_con_properties operacion_con_propertie
      , i_escrituras i_escritura, oks ok, Object... extras_array) throws Exception {
        if (ok.es == false) { return false; }
        try {
            this.escritura = i_escritura;
            this.operacion_con_propertie = operacion_con_propertie;
            this.operacion_con_propertie.inicial = inicial;
            navegador_web_peticion.escritura = i_escritura;
            operacion_con_propertie.iniciar(escritura, ok, extras_array);
            if (ok.es == false) { return false; }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return ok.es;
    }
    /**
     * Crea el formulario de inicio
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception
     */
    public boolean crear_formulario_inicio(oks ok, Object... extras_array) throws Exception {
        if (ok.es == false) { return false; }
        ResourceBundle in;
        in = ResourceBundles.getBundle(k_in_ruta);
        try {
            inicio_formulario = new web_formularios();
            inicio_formulario.escritura = escritura;
            navegador_web_peticion.url_inicios_mapa.put(k_url_ruta_action_formulario_inicio
              , inicio_i_navegador_web_peticiones);
            control_entradas inicio_buscar_control_entrada = new control_redirecciones();
            control_entradas inicio_traducir_control_entrada = new control_redirecciones();
            inicio_buscar_control_entrada.iniciar(k_entradas_tipo_boton, ok);
            if (ok.es == false) { return false; }
            inicio_traducir_control_entrada.iniciar(k_entradas_tipo_boton, ok);
            if (ok.es == false) { return false; }
            Map<String, String> valores_mapa = new HashMap<>();
            valores_mapa.put(k_valores_mapa_url_destino_tex
                    , k_url_protocolo_host + k_url_ruta_action_formulario_buscar);
            inicio_buscar_control_entrada.poner_en_formulario(inicio_formulario, k_inicio_buscar_boton
                    , valores_mapa, tr.in(in, "Buscar textos traducibles"), null, ok);
            if (ok.es == false) { return ok.es; }
            valores_mapa = new HashMap<>();
            valores_mapa.put(k_valores_mapa_url_destino_tex
                    , k_url_protocolo_host + k_url_ruta_action_formulario_traducir);
            inicio_traducir_control_entrada.poner_en_formulario(inicio_formulario, k_inicio_traducir_boton
                    , valores_mapa, tr.in(in, "Traducir"), null, ok);
            if (ok.es == false) { return ok.es; }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return ok.es;
    }
    /**
     * Crea el formulario para buscar textos de internacionalizacion
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception
     */
    public boolean crear_formulario_buscar_textos(oks ok, Object... extras_array) throws Exception {
        if (ok.es == false) { return false; }
        ResourceBundle in;
        in = ResourceBundles.getBundle(k_in_ruta);
        try {
            buscar_textos_formulario = new web_formularios();
            buscar_textos_formulario.escritura = escritura;
            navegador_web_peticion.url_inicios_mapa.put(k_url_ruta_action_formulario_buscar
              , buscar_i_navegador_web_peticiones);
            control_entradas buscar_textos_ruta_control_entrada = new control_entradas();
            control_entradas buscar_textos_cancelar_control_entrada = new control_redirecciones();
            control_entradas buscar_textos_confirmar_control_entrada = new control_entradas();
            buscar_textos_ruta_control_entrada.iniciar(k_entradas_tipo_texto, ok);
            if (ok.es == false) { return false; }
            buscar_textos_cancelar_control_entrada.iniciar(k_entradas_tipo_boton, ok);
            if (ok.es == false) { return false; }
            buscar_textos_confirmar_control_entrada.iniciar(k_entradas_tipo_submit, ok);
            if (ok.es == false) { return false; }
            buscar_textos_ruta_control_entrada.poner_en_formulario(buscar_textos_formulario, k_ruta_carpeta
                    , null, tr.in(in, "Escriba la ruta de la carpeta de donde extraer literales 'tr.in'. "), null, ok);
            if (ok.es == false) { return ok.es; }
            Map<String, String> valores_mapa = new HashMap<>();
            valores_mapa.put(k_valores_mapa_url_destino_tex
                    , k_url_protocolo_host + k_url_ruta_action_formulario_inicio);
            buscar_textos_cancelar_control_entrada.poner_en_formulario(buscar_textos_formulario, k_cancelar_boton
                    , valores_mapa, tr.in(in, "Cancelar"), null, ok);
            if (ok.es == false) { return ok.es; }
            buscar_textos_confirmar_control_entrada.poner_en_formulario(buscar_textos_formulario, k_enviar_boton
                    , null, tr.in(in, "Enviar"), null, ok);
            if (ok.es == false) { return ok.es; }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return ok.es;
    }
    /**
     * Crea el formulario de presentacion de properties
     * @param es_ller_traduccion
     * @param properties_tex
     * @param errores_tex
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception
     */
    public boolean crear_formulario_properties(boolean es_ller_traduccion, String properties_tex
      , String errores_tex, oks ok, Object... extras_array) throws Exception {
        if (ok.es == false) { return false; }
        ResourceBundle in;
        in = ResourceBundles.getBundle(k_in_ruta);
        try {
            properties_formulario = new web_formularios();
            properties_formulario.escritura = escritura;
            control_entradas cancelar_control_entrada = new control_redirecciones();
            control_entradas texto_control_entrada = new control_textos();
            control_entradas errores_texto_control_entrada = new control_textos();
            texto_control_entrada.iniciar(k_entradas_tipo_texto, ok);
            if (ok.es == false) { return false; }
            errores_texto_control_entrada.iniciar(k_entradas_tipo_texto, ok);
            if (ok.es == false) { return false; }
            cancelar_control_entrada.iniciar(k_entradas_tipo_boton, ok);
            if (ok.es == false) { return false; }
            HashMap<String, Object> opciones_mapa = new HashMap<>();
            opciones_mapa.put(k_nombre_fragmento, k_fragmento_texto);
            HashMap<String, String> valores_mapa = new HashMap<>();
            valores_mapa.put(k_mensaje_tex_0, "");
            valores_mapa.put(k_mensaje_tex_1, "");
            texto_control_entrada.poner_en_formulario(properties_formulario, k_properties_texto
              , valores_mapa, properties_tex, opciones_mapa, ok);
            if (ok.es == false) { return ok.es; }
            errores_texto_control_entrada.poner_en_formulario(properties_formulario, k_properties_errores_texto
              , valores_mapa, errores_tex, opciones_mapa, ok);
            if (ok.es == false) { return ok.es; }
            valores_mapa = new HashMap<>();
            if (es_ller_traduccion) {
                valores_mapa.put(k_valores_mapa_url_destino_tex
                    , k_url_protocolo_host + k_url_ruta_action_formulario_leer_traduccion);
            } else {
                valores_mapa.put(k_valores_mapa_url_destino_tex
                    , k_url_protocolo_host + k_url_ruta_action_formulario_buscar);
            }
            cancelar_control_entrada.poner_en_formulario(properties_formulario, k_cancelar_boton
                    , valores_mapa, tr.in(in, "Cancelar"), null, ok);
            if (ok.es == false) { return ok.es; }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return ok.es;
    }
    /**
     * Procesa la petición recibida desde el formulario
     * @param valores_mapa
     * @param clave_valor_lista
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception
     */
    public String procesar_formulario_buscar_textos(Map<String
            , String> valores_mapa, List<Map.Entry<String, Object>> clave_valor_lista
            , oks ok, Object... extras_array) throws Exception {
        if (ok.es == false) { return null; }
        String retorno = null;
        try {
            ResourceBundle in;
            String mensaje = "";
            in = ResourceBundles.getBundle(k_in_ruta);
            buscar_textos_formulario.importar_valores(clave_valor_lista, ok);
            if (ok.es == false) {
                if (ok.id.equals(k_importar_no_encontrado)) {
                    ok.iniciar();
                } else {
                    return null;
                }
            }
            if (valores_mapa.get(k_enviar_boton) != null) {
                buscar_textos_formulario.procesar(ok, extras_array);
                if (ok.es == false) { return null; }
                String error_tex = buscar_textos_formulario.valores_mapa.get(k_valores_mapa_mensaje_error_tex);
                if (error_tex.isEmpty() == false) {
                    retorno = capturar_formulario(buscar_textos_formulario
                      , null, k_url_ruta_action_formulario_buscar, ok, extras_array);
                    if (ok.es == false) { return null; }
                } else {
                    buscar_textos_formulario.valores_mapa.put(k_valores_mapa_mensaje_error_tex, "");
                    String ruta = valores_mapa.get(k_ruta_carpeta);
                    Map<String, String> properties_mapa = new TreeMap<>();
                    operacion_con_propertie.buscar_texto_tr_in_en_ruta(ruta
                      , properties_mapa, ok, extras_array);
                    String properties_tex = "";
                    String properties_error_tex = "";
                    String clave;
                    for (Entry<String, String> entry: properties_mapa.entrySet()) {
                        clave = entry.getKey();
                        clave = clave.replace(" ", "\\ ");
                        clave = clave.replace(":", "\\:");
                        clave = clave.replace("=", "\\=");
                        properties_tex = properties_tex
                          + clave
                          + "="
                          + entry.getValue()
                          + "<BR>";
                    }
                    crear_formulario_properties(false, properties_tex, properties_error_tex, ok);
                    if (ok.es == false) { return null; }
                    properties_formulario.valores_mapa.put(k_valores_mapa_mensaje_error_tex, mensaje);
                    retorno = capturar_formulario(properties_formulario
                      , null, k_url_ruta_action_formulario_buscar, ok, extras_array);
                }
            } else {
                retorno = capturar_formulario(buscar_textos_formulario
                  , null, k_url_ruta_action_formulario_buscar, ok, extras_array);
                if (ok.es == false) { return null; }
            }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return retorno;
    }
    /**
     * Procesa la petición recibida desde el formulario
     * @param valores_mapa
     * @param clave_valor_lista
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception
     */
    public String procesar_formulario_inicio(Map<String
            , String> valores_mapa, List<Map.Entry<String, Object>> clave_valor_lista
            , oks ok, Object... extras_array) throws Exception {
        if (ok.es == false) { return null; }
        String retorno = null;
        try {
            inicio_formulario.importar_valores(clave_valor_lista, ok);
            if (ok.es == false) {
                if (ok.id.equals(k_importar_no_encontrado)) {
                    ok.iniciar();
                } else {
                    return null;
                }
            }
            inicio_formulario.procesar(ok, extras_array);
            if (ok.es == false) { return null; }
            retorno = capturar_formulario(inicio_formulario
              , null, k_url_ruta_action_formulario_inicio, ok, extras_array);
            if (ok.es == false) { return null; }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return retorno;
    }
    /**
     * Crea el formulario de importación de wallet desde archivo de credenciales
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception
     */
    public boolean crear_formulario_traducir(oks ok, Object... extras_array) throws Exception {
        if (ok.es == false) { return false; }
        ResourceBundle in;
        in = ResourceBundles.getBundle(k_in_ruta);
        try {
            traducir_formulario = new web_formularios();
            traducir_formulario.escritura = escritura;
            navegador_web_peticion.url_inicios_mapa.put(k_url_ruta_action_formulario_traducir
              , traducir_i_navegador_web_peticiones);
            control_entradas nombre_control_entrada = new control_entradas();
            control_entradas ruta_control_entrada = new control_entradas();
            control_entradas cancelar_control_entrada = new control_redirecciones();;
            control_entradas confirmar_control_entrada = new control_entradas();
            nombre_control_entrada.iniciar(k_entradas_tipo_archivo, ok);
            if (ok.es == false) { return false; }
            ruta_control_entrada.iniciar(k_entradas_tipo_texto, ok);
            if (ok.es == false) { return false; }
            cancelar_control_entrada.iniciar(k_entradas_tipo_boton, ok);
            if (ok.es == false) { return false; }
            confirmar_control_entrada.iniciar(k_entradas_tipo_submit, ok);
            if (ok.es == false) { return false; }
            nombre_control_entrada.poner_en_formulario(traducir_formulario, k_nombre_archivo
                    , null, tr.in(in, "Seleccione el archivo de propiedades que traducir. "), null, ok);
            if (ok.es == false) { return ok.es; }
            ruta_control_entrada.poner_en_formulario(traducir_formulario, k_ruta_archivo
                    , null, tr.in(in, "Escriba la ruta del archivo. "), null, ok);
            if (ok.es == false) { return ok.es; }
            Map<String, String> valores_mapa = new HashMap<>();
            valores_mapa.put(k_valores_mapa_url_destino_tex
                    , k_url_protocolo_host + k_url_ruta_action_formulario_inicio);
            cancelar_control_entrada.poner_en_formulario(traducir_formulario, k_cancelar_boton
                    , valores_mapa, tr.in(in, "Cancelar"), null, ok);
            if (ok.es == false) { return ok.es; }
            confirmar_control_entrada.poner_en_formulario(traducir_formulario, k_enviar_boton
                    , null, tr.in(in, "Enviar"), null, ok);
            if (ok.es == false) { return ok.es; }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return ok.es;
    }
    /**
     * Crea el formulario de importación de wallet desde archivo de credenciales
     * @param claves_properties_tex
     * @param valores_properties_tex
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception
     */
    public boolean crear_formulario_leer_traduccion(String claves_properties_tex
      , String valores_properties_tex, oks ok, Object... extras_array) throws Exception {
        if (ok.es == false) { return false; }
        ResourceBundle in;
        in = ResourceBundles.getBundle(k_in_ruta);
        try {
            leer_traduccion_formulario = new web_formularios();
            leer_traduccion_formulario.escritura = escritura;
            navegador_web_peticion.url_inicios_mapa.put(k_url_ruta_action_formulario_leer_traduccion
              , leer_traduccion_i_navegador_web_peticiones);
            control_entradas cancelar_control_entrada = new control_redirecciones();;
            control_entradas confirmar_control_entrada = new control_entradas();
            control_entradas claves_control_entrada = new control_entradas();
            control_entradas unicode_control_entrada = new control_entradas();
            control_entradas valores_control_entrada = new control_textos();
            control_textareas traducciones_control_textarea = new control_textareas();
            cancelar_control_entrada.iniciar(k_entradas_tipo_boton, ok);
            if (ok.es == false) { return false; }
            confirmar_control_entrada.iniciar(k_entradas_tipo_submit, ok);
            if (ok.es == false) { return false; }
            claves_control_entrada.iniciar(k_entradas_tipo_hidden, ok);
            if (ok.es == false) { return false; }
            valores_control_entrada.iniciar(k_entradas_tipo_texto, ok);
            if (ok.es == false) { return false; }
            traducciones_control_textarea.iniciar(k_entradas_tipo_texto, ok);
            if (ok.es == false) { return false; }
            unicode_control_entrada.iniciar(k_entradas_tipo_checkbox, ok);
            if (ok.es == false) { return false; }
            HashMap<String, Object> opciones_mapa = new HashMap<>();
            opciones_mapa.put(k_nombre_fragmento, k_fragmento_texto);
            Map<String, String> valores_mapa = new HashMap<>();
            valores_mapa.put(k_mensaje_tex_0, valores_properties_tex);
            valores_mapa.put(k_mensaje_tex_1, "");
            valores_control_entrada.poner_en_formulario(leer_traduccion_formulario, k_leer_traduccion_valor
              , valores_mapa, "Textos que traducir: <br>", opciones_mapa, ok);
            if (ok.es == false) { return ok.es; }
            traducciones_control_textarea.poner_en_formulario(leer_traduccion_formulario, k_leer_traduccion_traduccion
                    , null, tr.in(in, "Traduccion: "), null, ok);
            if (ok.es == false) { return ok.es; }
            unicode_control_entrada.poner_en_formulario(leer_traduccion_formulario, k_leer_traduccion_unicode
                    , null, tr.in(in, "Convertir a \\u0F0F (unicode)"), null, ok);
            if (ok.es == false) { return ok.es; }
            valores_mapa = new HashMap<>();
            valores_mapa.put(k_valores_mapa_url_destino_tex
                    , k_url_protocolo_host + k_url_ruta_action_formulario_traducir);
            cancelar_control_entrada.poner_en_formulario(leer_traduccion_formulario, k_cancelar_boton
                    , valores_mapa, tr.in(in, "Cancelar"), null, ok);
            if (ok.es == false) { return ok.es; }
            confirmar_control_entrada.poner_en_formulario(leer_traduccion_formulario, k_enviar_boton
                    , null, tr.in(in, "Enviar"), null, ok);
            if (ok.es == false) { return ok.es; }
            valores_mapa = new HashMap<>();
            valores_mapa.put(k_valores_mapa_valor_tex
                    , claves_properties_tex);
            claves_control_entrada.poner_en_formulario(leer_traduccion_formulario, k_leer_traduccion_clave
                    , valores_mapa, "", null, ok);
            if (ok.es == false) { return ok.es; }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return ok.es;
    }
    /**
     * Procesa la petición recibida desde el formulario
     * @param valores_mapa
     * @param clave_valor_lista
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception
     */
    public String procesar_formulario_traducir(Map<String
            , String> valores_mapa, List<Map.Entry<String, Object>> clave_valor_lista
            , oks ok, Object... extras_array) throws Exception {
        if (ok.es == false) { return null; }
        String retorno = null;
        try {
            ResourceBundle in;
            String mensaje;
            in = ResourceBundles.getBundle(k_in_ruta);
            traducir_formulario.importar_valores(clave_valor_lista, ok);
            if (ok.es == false) {
                if (ok.id.equals(k_importar_no_encontrado)) {
                    ok.iniciar();
                } else {
                    return null;
                }
            }
            if (valores_mapa.get(k_enviar_boton) != null) {
                traducir_formulario.procesar(ok, extras_array);
                if (ok.es == false) { return null; }
                String error_tex = traducir_formulario.valores_mapa.get(k_valores_mapa_mensaje_error_tex);
                if (error_tex.isEmpty() == false) {
                    retorno = capturar_formulario(traducir_formulario
                      , null, k_url_ruta_action_formulario_traducir, ok, extras_array);
                    if (ok.es == false) { return null; }
                } else {
                    traducir_formulario.valores_mapa.put(k_valores_mapa_mensaje_error_tex, "");
                    String nombre = valores_mapa.get(k_nombre_archivo);
                    String ruta = valores_mapa.get(k_ruta_archivo);
                    File file = new File(nombre);
                    file = new File(ruta, file.getName());
                    if (file.exists() == false || file.canRead() == false) {
                        mensaje = tr.in(in, "No se puede acceder al archivo indicado. ");
                        traducir_formulario.valores_mapa.put(k_valores_mapa_mensaje_error_tex, mensaje);
                        retorno = capturar_formulario(traducir_formulario
                          , null, k_url_ruta_action_formulario_traducir, ok, extras_array);
                    } else if (file.getName().toLowerCase().endsWith(".properties") == false) {
                        mensaje = tr.in(in, "El archivo no tiene la extensión: ") + ".properties";
                        traducir_formulario.valores_mapa.put(k_valores_mapa_mensaje_error_tex, mensaje);
                        retorno = capturar_formulario(traducir_formulario
                          , null, k_url_ruta_action_formulario_traducir, ok, extras_array);
                    } else {
                        Properties properties;
                        properties = new Properties();
                        FileInputStream fileInputStream;
                        fileInputStream = new FileInputStream(file);
                        properties.load(fileInputStream);
                        TreeMap<String, String> properties_mapa = new TreeMap<>();
                        for (Entry<Object, Object> entry: properties.entrySet()) {
                            properties_mapa.put(entry.getKey().toString(), entry.getValue().toString());
                        }
                        String claves_texto = "";
                        String valores_texto = "";
                        String texto;
                        for (Entry<String, String> entry: properties_mapa.entrySet()) {
                            claves_texto = claves_texto + k_separador + entry.getKey() + k_separador;
                            texto = entry.getValue();
                            texto = texto.replace("&", "&amp;");
                            texto = texto.replace("<", "&lt;");
                            texto = texto.replace(">", "&gt;");
                            valores_texto = valores_texto + k_separador + texto + k_separador + "<br>";
                        }
                        crear_formulario_leer_traduccion(claves_texto, valores_texto, ok);
                        if (ok.es == false) { return null; }
                        retorno = capturar_formulario(leer_traduccion_formulario
                          , null, k_url_ruta_action_formulario_leer_traduccion, ok, extras_array);
                    }
                }
            } else {
                retorno = capturar_formulario(traducir_formulario
                  , null, k_url_ruta_action_formulario_traducir, ok, extras_array);
                if (ok.es == false) { return null; }
            }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return retorno;
    }
    /**
     * Procesa la petición recibida desde el formulario
     * @param valores_mapa
     * @param clave_valor_lista
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception
     */
    public String procesar_formulario_leer_traduccion(Map<String
            , String> valores_mapa, List<Map.Entry<String, Object>> clave_valor_lista
            , oks ok, Object... extras_array) throws Exception {
        if (ok.es == false) { return null; }
        String retorno = null;
        try {
            ResourceBundle in;
            String mensaje;
            in = ResourceBundles.getBundle(k_in_ruta);
            leer_traduccion_formulario.importar_valores(clave_valor_lista, ok);
            if (ok.es == false) {
                if (ok.id.equals(k_importar_no_encontrado)) {
                    ok.iniciar();
                } else {
                    return null;
                }
            }
            if (valores_mapa.get(k_enviar_boton) != null) {
                leer_traduccion_formulario.procesar(ok, extras_array);
                if (ok.es == false) { return null; }
                String error_tex = leer_traduccion_formulario.valores_mapa.get(k_valores_mapa_mensaje_error_tex);
                if (error_tex.isEmpty() == false) {
                    retorno = capturar_formulario(leer_traduccion_formulario
                      , null, k_url_ruta_action_formulario_leer_traduccion, ok, extras_array);
                    if (ok.es == false) { return null; }
                } else {
                    leer_traduccion_formulario.valores_mapa.put(k_valores_mapa_mensaje_error_tex, "");
                    String traduccion_tex = valores_mapa.get(k_leer_traduccion_traduccion);
                    String claves_tex = valores_mapa.get(k_leer_traduccion_clave);
                    claves_tex = claves_tex.replace(k_separador + k_separador, k_separador);
                    String [] claves_array = claves_tex.split(k_separador);
                    traduccion_tex = traduccion_tex.replaceAll(k_separador + "[\r\n ]+", k_separador);
                    traduccion_tex = traduccion_tex.replace(k_separador + k_separador, k_separador);
                    String [] traducciones_array = traduccion_tex.split(k_separador);
                    String texto = "";
                    if (claves_array.length != traducciones_array.length) {
                        ok.setTxt(tr.in(in, "No coinciden la líneas de textos traducidos con las de los textos que traducir. "));
                        return null;
                    }
                    int i = 0;
                    int tam = claves_array.length;
                    String clave;
                    String valor;
                    String hex_tex;
                    while (true) {
                        if (i >= tam) {
                            break;
                        }
                        if (claves_array[i].trim().isEmpty() == false) {
                            if (valores_mapa.get(k_leer_traduccion_unicode) != null) {
                                valor = "";
                                for (char letra: traducciones_array[i].toCharArray()) {
                                    hex_tex = Integer.toHexString(letra);
                                    while (hex_tex.length() < 4) {
                                        hex_tex = "0" + hex_tex;
                                    }
                                    valor = valor + "\\u" + hex_tex;
                                }
                            } else {
                                valor = traducciones_array[i];
                            }
                            clave = claves_array[i];
                            clave = clave.replace(" ", "\\ ");
                            clave = clave.replace(":", "\\:");
                            clave = clave.replace("=", "\\=");
                            clave = clave.replace("&", "&amp;");
                            clave = clave.replace("<", "&lt;");
                            clave = clave.replace(">", "&gt;");
                            valor = valor.replace("&", "&amp;");
                            valor = valor.replace("<", "&lt;");
                            valor = valor.replace(">", "&gt;");
                            texto = texto 
                              + clave + "=" 
                              +  valor + "<br>";
                        }
                        i = i + 1;
                    }
                    crear_formulario_properties(true, texto, "", ok);
                    if (ok.es == false) { return null; }
                    retorno = capturar_formulario(properties_formulario
                      , null, k_url_ruta_action_formulario_leer_traduccion, ok, extras_array);
                }
            } else {
                retorno = capturar_formulario(leer_traduccion_formulario
                  , null, k_url_ruta_action_formulario_leer_traduccion, ok, extras_array);
                if (ok.es == false) { return null; }
            }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return retorno;
    }
}
