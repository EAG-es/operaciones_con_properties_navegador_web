package ingui.javafx.operaciones_con_properties_navegador_web;

import ingui.javafx.navegador_web.Navegador_web;
import ingui.javafx.webtec.Webview_simpleController;
import innui.i_escrituras;
import innui.modelos.concurrencias.Threads;
import innui.modelos.configuraciones.ResourceBundles;
import innui.modelos.configuraciones.iniciales;
import innui.modelos.errores.oks;
import innui.modelos.internacionalizacion.tr;
import innui.modelos.modelos;
import innui.modelos.modelos_comunicaciones.modelos_comunicaciones;
import innui.operaciones_con_properties.operaciones_con_properties;
import inweb.kaloria_wallet_navegador_web.navegador_web_peticiones;
import static inweb.kaloria_wallet_navegador_web.navegador_web_peticiones.k_navegador_web_redirect;
import java.io.InputStream;
import static java.lang.System.err;
import static java.lang.System.exit;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import inweb.modelos_html.modelos_html;
import inweb.operaciones_con_properties_navegador_web.Operaciones_con_properties_web;
import static inweb.operaciones_con_properties_navegador_web.Operaciones_con_properties_web.k_url_protocolo_host;
import java.io.File;
import java.net.URI;
import javafx.application.Platform;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Window;
import static inweb.operaciones_con_properties_navegador_web.Operaciones_con_properties_web.k_url_ruta_action_formulario_inicio;

/**
 *
 * @author emilio
 */
public class Operaciones_con_properties_navegador_web extends Navegador_web {
    public static String k_in_ruta;
    static {
        String paquete_tex = Operaciones_con_properties_navegador_web.class.getPackage().getName();
        paquete_tex = paquete_tex.replace(".", File.separator);
        k_in_ruta = "in/" + paquete_tex + "/in";
    }
    public static String k_icono_ruta = "/re/static/ingui.javafx.operaciones_con_properties_navegador_web.icono.png";
    public static String k_imagen_cabecera_ruta = "/re/static/ingui.javafx.operaciones_con_properties_navegador_web.icono.png";
    public static String k_index_ruta = "/re/templates/kaloria_wallet/index.html";
    public static String k_opciones_mapa_nombre_fragmento_html = "html";
    public static String k_titulo_tex = "titulo_tex";
    public static String k_mensaje_imagen_tex = "mensaje_imagen_tex";
    public static String k_imagen_ruta_tex = "imagen_ruta_tex";
    public static String k_mensaje_cabecera_tex = "mensaje_cabecera_tex";
    public static String k_kaloria_wallet_navegador_web_index_autoactualizado = "index_autoactualizado";
    public Operaciones_con_properties_web operaciones_con_properties_web = new Operaciones_con_properties_web();
    public operaciones_con_properties operacion_con_propertie = new operaciones_con_properties();
    public Dialog<Boolean> mensaje_dialog;
    public Threads procesar_evento_llamada_a_url_thread;
    
    public iniciales main_inicial = new iniciales () {
        @Override
        public boolean run(oks ok, Object... extras_array) throws Exception {
            try {
                while (true) {
                    if (extras_array.length > 1 
                    && (Boolean) extras_array[1]) {
                        Operaciones_con_properties_navegador_web.super.inicial.run(ok, Operaciones_con_properties_navegador_web.class, extras_array[0]);
                    }
                    break;
                }
                return ok.es;
            } catch (Exception e) {
                throw e;
            }
        }

        @Override
        public boolean iniciar(oks ok, Object... extras_array) throws Exception {
            if (ok.es == false) { return ok.es; }
            _iniciar_desde_clase(modelos.class, ok);
            if (ok.es == false) { return ok.es; }
            _iniciar_desde_clase(modelos_html.class, ok);
            if (ok.es == false) { return ok.es; }
            _iniciar_desde_clase(modelos_comunicaciones.class, ok);
            if (ok.es == false) { return ok.es; }
            _iniciar_desde_clase(Navegador_web.class, ok);
            if (ok.es == false) { return ok.es; }
            _iniciar_desde_clase(this.getClass(), ok);
            if (ok.es == false) { return ok.es; }
            return ok.es;
        }

        @Override
        public boolean terminar(oks ok, Object... extras_array) throws Exception {
            if (ok.es == false) { return ok.es; }
            _terminar_desde_clase(modelos.class, ok);
            if (ok.es == false) { return ok.es; }
            _terminar_desde_clase(modelos_html.class, ok);
            if (ok.es == false) { return ok.es; }
            _terminar_desde_clase(modelos_comunicaciones.class, ok);
            if (ok.es == false) { return ok.es; }
            _terminar_desde_clase(Navegador_web.class, ok);
            if (ok.es == false) { return ok.es; }
            _terminar_desde_clase(Operaciones_con_properties_navegador_web.class, ok);
            if (ok.es == false) { return ok.es; }
            return ok.es;
        }

        @Override
        public boolean escribir_linea_error(String mensaje, oks ok, Object ... extras_array) {
            boolean ret = true;
            if (_contenedor_principalController != null) {
                ret = _contenedor_principalController.poner_error(mensaje, ok);
            }
            err.printf(ok.txt);
            return ret;
        }    
    };

    public Operaciones_con_properties_navegador_web() throws Exception { 
        ResourceBundle in = ResourceBundles.getBundle(k_in_ruta);        
        titulo_de_ventana = tr.in(in, "Operaciones con properties navegador web");
        _i_webview_simpleController_captura = new Webview_simpleController.I_Webview_simpleController_capturas() {
            @Override
            public boolean poner_error(String mensaje, oks ok, Object ... extras_array) {
                return Operaciones_con_properties_navegador_web.this.poner_error(mensaje, ok);
            }
            @Override
            public boolean procesar_estado(String estado, String url_texto, oks ok, Object ... extras_array) throws Exception {
//                if (ok.es == false) { return ok.es; }
//                String mensaje = "";
//                if (_webview_simpleController.presentar_contenido_seguro_intentos_num == 2) {
//                    mensaje = tr.in(in, "¡ORIGEN NO CERTIFICADO! ");
//                }
//                if (estado.equals("SUCCEEDED")) {
//                    poner_error(
//                            mensaje
//                            + tr.in(in, "TERMINADO. ")
//                            + url_texto, ok);
//                } else if (estado.equals("FAILED")) {
//                    poner_error(
//                            mensaje
//                            + tr.in(in, "FALLIDO. ")
//                            + url_texto, ok);
//                } else if (estado.equals("CANCELLED")) {
//                    poner_error(
//                            mensaje
//                            + tr.in(in, "CANCELADO. ")
//                            + url_texto, ok);
//                } else {
//                    poner_error(
//                            mensaje
//                            + tr.in(in, "PROCESANDO. ")
//                            + url_texto, ok);
//                }
                return ok.es;
            }
        };
    }
    
    public static void main(String[] args) {
        oks ok = new oks();
        Operaciones_con_properties_navegador_web kaloria_wallet_navegador_web = null;
        try {
            kaloria_wallet_navegador_web = new Operaciones_con_properties_navegador_web();
            Object [] extras_array = { args
            , true };
            kaloria_wallet_navegador_web.main_inicial.run(ok, extras_array);
        } catch (Exception e) {
            ok.setTxt(e);
        }
        if (ok.es == false) {
            System.err.println(ok.txt);
            exit(1);
        } else {
            exit(0);
        }
    }
    /**
     * Realiza la operativa de navegar para presentar una página web
     * @param parametros_lista
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception 
     */
    @Override
    public boolean navegar(List<String> parametros_lista, oks ok, Object... extras_array) throws Exception {
        if (ok.es == false) { return false; }
        try {
            main_inicial.iniciar(ok, extras_array);
            if (ok.es == false) { return false; }
            operaciones_con_properties_web.iniciar(main_inicial, operacion_con_propertie, i_escritura, ok, extras_array);
            if (ok.es == false) { return false; }
            ResourceBundle in = ResourceBundles.getBundle(k_in_ruta);        
            crear_mensaje_dialogo(tr.in(in, "Espere por favor... "), tr.in(in, "Preparando página web... "), ok, extras_array);
            if (ok.es == false) { return false; }
            procesar_evento_llamada_a_url_thread = new Threads() {
                @Override
                public void run() {
                    try {
                        if (this.ref_ok.get().es == false) { return; }
                        oks ok = new oks();
                        while (true) {
                            mostrar_mensaje_dialogo(ok, extras_array);
                            if (ok.es == false) { ref_ok.set(ok); return; }
                            operaciones_con_properties_web.crear_formulario_index(ok);
                            if (ok.es == false) { break; }
                            operaciones_con_properties_web.crear_formulario_error(ok, extras_array);
                            if (ok.es == false) { break; }
                            operaciones_con_properties_web.crear_formulario_inicio(ok);
                            if (ok.es == false) { break; }
                            operaciones_con_properties_web.crear_formulario_buscar_textos(ok);
                            if (ok.es == false) { break; }
                            operaciones_con_properties_web.crear_formulario_traducir(ok);
                            if (ok.es == false) { break; }
                            _contenedor_principalController.poner_inicio_uri(new URI(k_url_protocolo_host
                              + k_url_ruta_action_formulario_inicio)
                              , ok, extras_array);
                            if (ok.es == false) { break; }
                            String html_tex = operaciones_con_properties_web.capturar_formulario(operaciones_con_properties_web.inicio_formulario
                              , null, k_url_ruta_action_formulario_inicio, ok);
                            if (ok.es == false) { break; }
                            html_tex = operaciones_con_properties_web.capturar_formulario_index(html_tex
                                , ok.getTxt(), ok, extras_array);
                            if (ok.es == false) { ref_ok.set(ok); return; }
                            webview_simpleController_implementacion.escribir_texto(html_tex, ok);
                            if (ok.es == false) { break; }
                            _contenedor_principalController.atras_boton.setVisible(false);
                            _contenedor_principalController.adelante_boton.setVisible(false);
                            _contenedor_principalController.inicio_boton.setVisible(false);
                            webview_simpleController_implementacion.presentar_contenido(ok);
                            if (ok.es == false) { break; }
                            ocultar_mensaje_dialogo(ok, extras_array);
                            if (ok.es == false) { ref_ok.set(ok); return; }
                            break;
                        } 
                        if (ok.es == false) {
                            String html_tex = operaciones_con_properties_web.capturar_formulario(operaciones_con_properties_web.error_formulario
                              , null, "", ok, extras_array);
                            if (ok.es == false) { ref_ok.set(ok); return; }
                            html_tex = operaciones_con_properties_web.capturar_formulario_index(html_tex
                                , ok.getTxt(), ok, extras_array);
                            if (ok.es == false) { ref_ok.set(ok); return; }
                            webview_simpleController_implementacion.escribir_texto(html_tex, ok);
                            if (ok.es == false) { ref_ok.set(ok); return; }
                            _contenedor_principalController.atras_boton.setVisible(false);
                            _contenedor_principalController.adelante_boton.setVisible(false);
                            _contenedor_principalController.inicio_boton.setVisible(false);
                            webview_simpleController_implementacion.presentar_contenido(ok);
                            if (ok.es == false) { ref_ok.set(ok); return; }
                            ocultar_mensaje_dialogo(ok, extras_array);
                            if (ok.es == false) { ref_ok.set(ok); return; }
                        }
                    } catch (Exception e) {
                        ok.setTxt(e);
                    } finally {
                        ref_ok.set(ok);
                    }
                }
            };
            procesar_evento_llamada_a_url_thread.ref_ok.set(ok);
            procesar_evento_llamada_a_url_thread.start();
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return ok.es;
    }
    /**
     * Pone el icono de la aplicación
     * @param stage Escenario donde poner el icono
     * @param ok
     * @param extras_array
     * @return true si tiene éxito, false si hay error.
     * @throws java.lang.Exception
     */
    @Override
    public boolean poner_icono(Stage stage, oks ok, Object... extras_array) throws Exception {
        if (ok.es == false) { return ok.es; }
        ObservableList<Image> observableList = stage.getIcons();
        InputStream inputStream = this.getClass().getResourceAsStream(
            k_icono_ruta); 
        Image image = new Image(inputStream);
        observableList.add(image);
        return ok.es;
    }
    /**
     * Captura las URLs que son llamadas (clic) en el navegador 
     * @param url
     * @param ok
     * @param extras_array
     * @return true si todo es correcto, false/null si hay error.
     * @throws Exception 
     */
    @Override
    public Boolean procesar_evento_llamada_a_url(URL url, oks ok, Object ... extras_array) throws Exception {
        if (ok.es == false) { return false; }
        try {
            String url_tex = url.toString();
            mostrar_mensaje_dialogo(ok, extras_array);
            if (ok.es == false) { return false; }
            procesar_evento_llamada_a_url_thread = new Threads() {
                @Override
                public void run() {
                    try {
                        if (this.ref_ok.get().es == false) { return; }
                        oks ok = new oks();
                        poner_error("", ok, extras_array);
                        if (ok.es == false) { ref_ok.set(ok); return; }
                        String html_tex;
                        html_tex = operaciones_con_properties_web.navegador_web_peticion.procesar_peticion(url, ok, extras_array);
                        if (ok.es == false) {
                            if (ok.id.equals(navegador_web_peticiones.k_url_no_encontrada)) {
                                ok.iniciar();
                                ocultar_mensaje_dialogo(ok);
                                if (ok.es == false) { ref_ok.set(ok); return; }
                                _contenedor_principalController.atras_boton.setVisible(true);
                                _contenedor_principalController.adelante_boton.setVisible(true);
                                _contenedor_principalController.inicio_boton.setVisible(true);
                                // webview_simpleController_implementacion.presentar_contenido(url.toURI(), ok, extras_array);
                            } else {
                                String texto = ok.getTxt();
                                ok.iniciar();
                                poner_error(texto, ok);
                                html_tex = operaciones_con_properties_web.capturar_formulario(operaciones_con_properties_web.error_formulario
                                  , null, "", ok, extras_array);
                                if (ok.es == false) { ref_ok.set(ok); return; }
                                html_tex = operaciones_con_properties_web.capturar_formulario_index(html_tex
                                    , texto, ok, extras_array);
                                if (ok.es == false) { ref_ok.set(ok); return; }
                                webview_simpleController_implementacion.escribir_texto(html_tex, ok);
                                if (ok.es == false) { ref_ok.set(ok); return; }
                                _contenedor_principalController.atras_boton.setVisible(false);
                                _contenedor_principalController.adelante_boton.setVisible(false);
                                _contenedor_principalController.inicio_boton.setVisible(false);
                                webview_simpleController_implementacion.presentar_contenido(ok);
                                if (ok.es == false) { ref_ok.set(ok); return; }
                                ocultar_mensaje_dialogo(ok);
                                if (ok.es == false) { ref_ok.set(ok); return; }
                            }
                        } else {
                            if (html_tex.startsWith(k_navegador_web_redirect)) {
                                html_tex = html_tex.substring(k_navegador_web_redirect.length()).trim();
                                ocultar_mensaje_dialogo(ok);
                                if (ok.es == false) { ref_ok.set(ok); return; }
                                URI uri = new URI(html_tex);
                                _contenedor_principalController.atras_boton.setVisible(false);
                                _contenedor_principalController.adelante_boton.setVisible(false);
                                _contenedor_principalController.inicio_boton.setVisible(false);
                                webview_simpleController_implementacion.presentar_contenido(uri, ok, extras_array);
                            } else {
                                ocultar_mensaje_dialogo(ok, extras_array);
                                if (ok.es == false) { ref_ok.set(ok); return; }
                                html_tex = operaciones_con_properties_web.capturar_formulario_index(html_tex
                                  , ok.getTxt(), ok, extras_array);
                                if (ok.es == false) { ref_ok.set(ok); return; }
                                webview_simpleController_implementacion.escribir_texto(html_tex, ok);
                                if (ok.es == false) { ref_ok.set(ok); return; }
                                _contenedor_principalController.atras_boton.setVisible(false);
                                _contenedor_principalController.adelante_boton.setVisible(false);
                                _contenedor_principalController.inicio_boton.setVisible(false);
                                webview_simpleController_implementacion.presentar_contenido(ok);
                                if (ok.es == false) { ref_ok.set(ok); return; }
                            }
                        }
                    } catch (Exception e) {
                        try {
                            ocultar_mensaje_dialogo(ok);
                        } catch (Exception e_ignorar) {}
                        ok.setTxt(e);
                    } finally {
                        ref_ok.set(ok);
                    }
                }
            };
            procesar_evento_llamada_a_url_thread.ref_ok.set(ok);
            procesar_evento_llamada_a_url_thread.start();
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return ok.es;
    }
    /**
     * Mensaje de espera
     * @param titulo
     * @param mensaje
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception 
     */
    public boolean crear_mensaje_dialogo(String titulo, String mensaje, oks ok, Object ... extras_array) throws Exception {
        try {
            if (ok.es == false) { return false; }
            mensaje_dialog = new Dialog<>();
//            mensaje_dialog.initStyle(StageStyle.UNDECORATED);
            mensaje_dialog.initModality(Modality.WINDOW_MODAL);
            mensaje_dialog.setTitle(titulo);
            mensaje_dialog.setContentText(mensaje);
            mensaje_dialog.initOwner(_contenedor_principalController.scrollpane_1.getScene().getWindow());
            Window window = mensaje_dialog.getDialogPane().getScene().getWindow();
            window.setOnCloseRequest(event -> window.hide());            
            mensaje_dialog.setResizable(Boolean.TRUE);
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return ok.es;
    }   
    /**
     * Muestra el dialogo
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception 
     */
    public boolean mostrar_mensaje_dialogo(oks ok, Object ... extras_array) throws Exception {
        try {
            if (ok.es == false) { return false; }
            Platform.runLater(() -> {
                if (mensaje_dialog != null) {
                    mensaje_dialog.show();
                }
            });
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return ok.es;
    }   
    /**
     * Oculta el dialogo
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception 
     */
    public boolean ocultar_mensaje_dialogo(oks ok, Object ... extras_array) throws Exception {
        try {
            if (ok.es == false) { return false; }
            Platform.runLater(() -> {
                if (mensaje_dialog != null && mensaje_dialog.isShowing()) {
                    mensaje_dialog.setResult(Boolean.TRUE);
                    mensaje_dialog.hide();
                }
            });
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return ok.es;
    }
    /**
     * Mensaje de espera
     * @param titulo
     * @param mensaje
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception 
     */
    public boolean mostrar_mensaje_kaloria_wallet(String titulo, String mensaje, oks ok, Object ... extras_array) throws Exception {
        try {
            if (ok.es == false) { return false; }
            Platform.runLater(() -> {
                Dialog<Boolean> dialog = null;
                dialog = new Dialog<>();
                dialog.initModality(Modality.NONE);
                dialog.setTitle(titulo);
//                dialog.setContentText(mensaje);
                TextArea textArea = new TextArea(mensaje);
                textArea.setEditable(false);
                textArea.setWrapText(true);
                GridPane gridPane = new GridPane();
                gridPane.setMaxWidth(Double.MAX_VALUE);
                gridPane.add(textArea, 0, 0);
                dialog.getDialogPane().setContent(gridPane);
                dialog.initOwner(_contenedor_principalController.scrollpane_1.getScene().getWindow());
                Window window = dialog.getDialogPane().getScene().getWindow();
                window.setOnCloseRequest(event -> window.hide());
                dialog.setResizable(Boolean.TRUE);
                dialog.setResult(Boolean.TRUE);
                dialog.show();
            });
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return ok.es;
    }   
    /**
     * Atributo para unificar la escritura entre todas las clases 
     */
    public i_escrituras i_escritura = new i_escrituras () {
        @Override
        public boolean escribir(String texto, oks ok, Object... extras_array) throws Exception  {
            return poner_error(texto, ok, extras_array);
        }

        @Override
        public boolean escribir_linea(String texto, oks ok, Object... extras_array) throws Exception  {
            return poner_error(texto, ok, extras_array);
        }

        @Override
        public boolean escribir_error(String texto, oks ok, Object... extras_array)  {
            return poner_error(texto, ok, extras_array);
        }

        @Override
        public boolean escribir_linea_error(String texto, oks ok, Object... extras_array) {
            return poner_error(texto, ok, extras_array);
        }

        @Override
        public boolean escribir_log(String texto, System.Logger.Level nivel, oks ok, Object... extras_array) {
            return Operaciones_con_properties_navegador_web.this.main_inicial.escribir_log(texto, nivel, ok, extras_array);
        }

        @Override
        public boolean escribir_log(String texto, oks ok, Object... extras_array) {
            return Operaciones_con_properties_navegador_web.this.main_inicial.escribir_log(texto, ok, extras_array);
        }
        
        @Override
        public boolean limitar_log(System.Logger.Level limite, oks ok, Object... extras_array){
            return Operaciones_con_properties_navegador_web.this.main_inicial.limitar_log(limite, ok, extras_array);
        }

        @Override
        public boolean ser_posible_log(System.Logger.Level limite, oks ok, Object... extras_array) {
            return Operaciones_con_properties_navegador_web.this.main_inicial.ser_posible_log(limite, ok, extras_array);
        }
    };
}
