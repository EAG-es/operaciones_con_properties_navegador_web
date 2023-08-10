package innui.operaciones_con_properties;

import innui.bases;
import innui.i_escrituras;
import innui.modelos.configuraciones.ResourceBundles;
import innui.modelos.configuraciones.iniciales;
import innui.modelos.errores.oks;
import innui.modelos.internacionalizacion.tr;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;

/**
 *
 * @author emilio
 */
public class operaciones_con_properties extends bases {
    public static String k_in_ruta;
    static {
        String paquete_tex = operaciones_con_properties.class.getPackage().getName();
        paquete_tex = paquete_tex.replace(".", File.separator);
        k_in_ruta = "in/" + paquete_tex + "/in";
    }
    public iniciales inicial; // Recibido de Operaciones_con_properties_navegador_web
    
    /**
     * Iniciar la clase
     * @param i_escritura
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception 
     */
    public boolean iniciar(i_escrituras i_escritura, oks ok, Object... extras_array) throws Exception {
        if (ok.es == false) { return false; }
        try {
            this.escritura = i_escritura;
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return ok.es;
    }
    /**
     * Busca literales tras la marca 'tr.in'
     * @param ruta
     * @param properties_mapa
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception 
     */
    public boolean buscar_texto_tr_in_en_ruta(String ruta
      , LinkedHashMap<String, String> properties_mapa
      , oks ok, Object... extras_array) throws Exception {
        if (ok.es == false) { return false; }
        ResourceBundle in;
        in = ResourceBundles.getBundle(k_in_ruta);
        try {
            File file;
            File [] files_array;
            file = new File(ruta);
            if (file.isDirectory()) {
                files_array = file.listFiles(filter -> {
                    if (filter.getName().toLowerCase().endsWith("java")) {
                        return true;
                    } else {
                        return false;
                    }
                });
                for (File nodo_file : files_array) {
                    _buscar_literal_en_archivo_tras_marca(nodo_file, "tr"+".in"
                      , properties_mapa, ok, extras_array);
                    if (ok.es == false) { return false; }
                }
            } else {
                ok.setTxt(tr.in(in, "No es un directorio: ") + ruta);
            }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return ok.es;
    }
    /**
     * 
     * @param file
     * @param marca
     * @param properties_mapa
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception 
     */
    public boolean _buscar_literal_en_archivo_tras_marca(File file
      , String marca, LinkedHashMap<String, String> properties_mapa
      , oks ok, Object... extras_array) throws Exception {
        if (ok.es == false) { return false; }
        ResourceBundle in;
        in = ResourceBundles.getBundle(k_in_ruta);
        try {
            if (file.exists() && file.canRead()) {
                int tam = 100;
                if (tam < marca.length()) {
                    tam = marca.length() + 100;
                }
                char [] chars_array = new char[tam];
                int num;
                int pos = 0;
                int encontrado;
                String texto;
                String literal;
                StringBuilder resto = new StringBuilder();
                try (FileInputStream fileInputStream = new FileInputStream(file)) {
                    InputStreamReader InputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
                    BufferedReader bufferedReader = new BufferedReader(InputStreamReader);
                    while (true) {
                        num = bufferedReader.read(chars_array, pos, chars_array.length - pos);
                        if (num == -1) {
                            if (pos > 0) {
                                num = 0;
                            } else {
                                break;
                            }
                        }
                        texto = String.valueOf(chars_array, 0, num + pos);
                        encontrado = texto.indexOf(marca);
                        if (encontrado < 0) {
                            int resto_tam = texto.length() - marca.length() + 1;
                            if (resto_tam > 0) {
                                texto = texto.substring(texto.length() - marca.length() + 1);
                                pos = texto.length();
                                int i = 0;
                                while (true) {
                                    if (i >= pos) {
                                        break;
                                    }
                                    chars_array[i] = texto.charAt(i);
                                    i = i + 1;
                                }
                            } else {
                                pos = 0;
                            }
                        } else {
                            literal = _buscar_literal(bufferedReader
                              , texto.substring(encontrado + marca.length())
                              , resto, ok);
                            if (ok.es == false) { return false; }
                            pos = 0;
                            tam = resto.length();
                            while (true) {
                                if (pos >= tam) {
                                    break;
                                }
                                chars_array[pos] = resto.charAt(pos);
                                pos = pos + 1;
                            }
                            properties_mapa.put(literal, literal);
                        }
                    }
                }
            } else {
                ok.setTxt(tr.in(in, "No se puede leer el archivo: ") + file.getCanonicalPath());
            }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return ok.es;
    }
    /**
     * Busca un literal entre comillas dobles sin escape delante (\)
     * @param bufferedReader
     * @param inicio
     * @param resto
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception 
     */
    public String _buscar_literal(BufferedReader bufferedReader, String inicio
      , StringBuilder resto, oks ok, Object... extras_array) throws Exception {
        if (ok.es == false) { return null; }
        String retorno = null;
        try {
            boolean es_escape = false;
            boolean es_inicio = false;
            boolean es_salir = false;
            int num;
            int i, ii;
            int tam;
            char [] chars_array = inicio.toCharArray();
            char [] chars_leidos_array = new char[100];
            String texto;
            retorno = "";
            while (true) {
                i = 0;
                for (char letra: chars_array) {
                    if (letra == '\\') {
                        if (es_escape) {
                            es_escape = false;
                        } else {
                            es_escape = true;                            
                        }
                    } else {
                        es_escape = false;
                    }
                    if (es_escape == false 
                     && letra == '"') {
                        if (es_inicio == false) {
                            es_inicio = true;
                        } else {
                            es_salir = true;
                            break;
                        }
                    } else if (es_inicio) {
                        retorno = retorno + letra;
                    }
                    i = i + 1;
                }
                if (es_salir) {
                    break;
                }
                num = bufferedReader.read(chars_leidos_array);
                if (num == -1) {
                    break;
                }
                texto = String.valueOf(chars_leidos_array);
                chars_array = texto.toCharArray();
            }
            if (es_salir) {
                resto = resto.delete(0, resto.length());
                tam = chars_array.length;
                while (true) {
                    if (i >= tam) {
                        break;
                    }
                    resto.append(chars_array[i]);
                    i = i + 1;
                }
            }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return retorno;
    }
}
