package com.ferreteria.utilitarios;

//import ec.gob.mcds.servicioSeguridades.model.Usuario;
//import ec.gob.stptv.registro.navegacionControlador.NavegacionControlador;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Clase que contiene los metodos más utilizados en el desarrollo de
 * aplicaciones en la Dirección del RIPS
 *
 * @author Chris
 */
public class Utilitarios implements Serializable {



   
    protected static String REGISTRO_GUARDADO = "message.guardar";
    protected static String REGISTRO_ACTUALIZADO = "message.actualizar";
    protected static String REGISTRO_ELIMINADO = "message.eliminar";
    protected static String ERROR_REGISTRO_GUARDADO = "message.errorGuardar";
    protected static String ERROR_REGISTRO_ACTUALIZADO = "message.errorActualizar";
    protected static String ERROR_REGISTRO_ELIMINADO = "message.errorEliminar";
    protected static String REGISTRO_EXISTENTE = "message.registroExistente";
    protected static String ESCOJER_SISTEMA = "message.errorEscojerSistema";
    protected static String LONGITUD_PASSWORD = "message.longitudPassword";
    protected static String CONFIRMACION_PASSWORD = "message.confirmacion";
    protected static String LOGIN_INCORRECTO = "message.loginIncorrecto";
    protected static String USUARIO_SESION = "message.usuarioSesion";
    protected static int MAX_ROWS = 10;
    protected static int NUEMRO_PROVINCIAS = 24;
    protected static String PATRON_FECHA = "yyyy-MM-dd";
    protected static String PATRON_FECHA_HORA = "yyyy-MM-dd HH:mm:ss";
    protected static String PATRON_FECHA_OTRA = "dd/MM/yyyy";
    protected static String COINCIDENCIAS_ENCONTRADAS = "message.coincidenciasEncontradas";
    protected static String COINCIDENCIAS_NO_ENCONTRADAS = "message.coincidenciasNoEncontradas";
    protected static String NADA = "message.nada";
    protected static String PATH = "path";
    protected static String PROGRAMADO = "PROGRAMACION";
    protected static String SUSPENDIDO = "SUSPENCION";
    protected static String REPROGRAMADO = "REPROGRAMACION";
    protected static Long ESTADO_PERIODO_INACTIVO = 2L;
    protected static Long ESTADO_PERIODO_ACTIVO = 1L;
    protected static Long ESTADO_SALDO_INACTIVO = 2L;
    protected static Long ESTADO_SALDO_ACTIVO = 1L;
    protected static String ACCION_PERSONAL = "ACCPER";
    protected static String MSG_REQUERIDO = "Valor requerido";
    protected static final String ENCODIN_ISO = "8859_1";
    public static final int NIVEL_ZOOM = 15;
    private Random random = new Random();

    /**
     * Colocar mensaje para componentes requeridos en la interfaz gráfica
     *
     * @param idComponente nombre del componente
     */
    protected void ponerMensajeComponeneteRequerido(String idComponente) {
        getContext().addMessage(idComponente, new FacesMessage(FacesMessage.SEVERITY_ERROR, NADA, MSG_REQUERIDO));
    }

    /**
     * Obtener la ip del Cliente
     *
     * @return Ip del cliente cadena de texto
     */
    protected String obtenerIpHost() {
        return getRequest().getRemoteAddr();
    }

    /**
     * *
     * Redireccionar a la URL especificada
     *
     * @param url dirección a donde rediccionar al usuario
     * @throws IOException exception si no existe la url
     */
    protected void redirect(String url) throws IOException {
        getExternalContext().redirect(getRequest().getContextPath() + url);
    }

    /**
     * Obtiene el Context Name
     *
     * @return obtiene el path completo del Context Name
     */
    protected String getContextName() {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
    }

    /**
     * Devuelve la fecha en el siguiente formato yyyy-MM-dd HH:mm:ss Texto
     *
     * @param fecha Date
     * @return String
     */
    protected String devuelveFechaHora(Date fecha) {
        DateFormat patron = new SimpleDateFormat(PATRON_FECHA_HORA);
        return patron.format(fecha);
    }

    /**
     * Convertir fecha a string
     *
     * @param fecha Date
     * @param patronFecha String
     * @return fecha en String
     */
    protected String devuelveFechaHora(Date fecha, String patronFecha) {
        DateFormat patron = new SimpleDateFormat(patronFecha);
        return patron.format(fecha);
    }

    /**
     * Devuelve la fecha actual en formato de cadena de texto.
     *
     * @param fechaParametro Date
     * @return String
     */
    protected String devuelveFechaEnLetras(Date fechaParametro) {
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(fechaParametro);
        String armaFecha = devuelveDiaSemana(fecha.get(Calendar.DAY_OF_WEEK)) + fecha.get(Calendar.DAY_OF_MONTH) + " de " + devuelveMes(fecha.get(Calendar.MONTH)) + " " + fecha.get(Calendar.YEAR) + " " + fecha.get(Calendar.HOUR_OF_DAY) + ":" + devuelveMinuto(fecha.get(Calendar.MINUTE));
        return armaFecha;
    }

    /**
     * Devuelve la fecha actual en formato de cadena de texto sin la hora
     *
     * @param fechaParametro Date
     * @return String
     */
    protected String devuelveFechaEnLetrasSinHora(Date fechaParametro) {
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(fechaParametro);
        String armaFecha = devuelveDiaSemana(fecha.get(Calendar.DAY_OF_WEEK)) + fecha.get(Calendar.DAY_OF_MONTH) + " de " + devuelveMes(fecha.get(Calendar.MONTH)) + " " + fecha.get(Calendar.YEAR);
        return armaFecha;
    }

    /**
     * Obtener el minuto
     *
     * @param minuto
     * @return
     */
    private String devuelveMinuto(int minuto) {
        if (minuto < 10) {
            return String.valueOf("0" + minuto);
        } else {
            return String.valueOf(minuto);
        }
    }

    /**
     * Instancia que la fecha inicial debe empezar en 0 horas 0 minutos 0
     * segundos
     *
     * @param fechaDesde Date
     * @return Date
     */
    protected Date obtenerFechaDesde(Date fechaDesde) {
        Calendar fechaDesdeAux = Calendar.getInstance();
        fechaDesdeAux.setTime(fechaDesde);
        fechaDesdeAux.set(Calendar.HOUR_OF_DAY, 0);
        fechaDesdeAux.set(Calendar.MINUTE, 0);
        fechaDesdeAux.set(Calendar.SECOND, 0);
        return fechaDesdeAux.getTime();
    }

    /**
     * Instancia que la fecha final debe estar en 23 horas 59 minutos 59
     * segundos
     *
     * @param fechaHasta fecha a la que se cambiara la hora, minuto y segundo
     * @return fecha con parametros en hora 23, minuto 59 y segundo 59
     */
    protected Date obtenerFechaHasta(Date fechaHasta) {
        Calendar fechaHastaAux = Calendar.getInstance();
        fechaHastaAux.setTime(fechaHasta);
        fechaHastaAux.set(Calendar.HOUR_OF_DAY, 23);
        fechaHastaAux.set(Calendar.MINUTE, 59);
        fechaHastaAux.set(Calendar.SECOND, 59);
        return fechaHastaAux.getTime();
    }

    /**
     * Convierte un valor decimal en una cadena con formato del dinero.
     *
     * @param valor numero decimal
     * @return cadena de caracteres en formato moneda
     */
    protected String devuelveCantidadEnMoneda(Double valor) {
        DecimalFormatSymbols simbols = new DecimalFormatSymbols();
        simbols.setDecimalSeparator('.');
        simbols.setPatternSeparator(',');
        NumberFormat formato = new DecimalFormat("############0.00", simbols);
        return formato.format(valor);
    }

    /**
     * Devuelve el día de la semana correspondiente al número
     *
     * @param dia
     * @return
     */
    private String devuelveDiaSemana(int dia) {
        switch (dia) {
            case 1:
                return "Domingo ";
            case 2:
                return "Lunes ";
            case 3:
                return "Martes ";
            case 4:
                return "Miércoles ";
            case 5:
                return "Jueves ";
            case 6:
                return "Viernes ";
            case 7:
                return "Sabado ";
            default:
                return "";

        }
    }

    /**
     * Devuelve el mes correspondiente al número
     *
     * @param mes entero numer
     * @return cadena con el nombre del mes
     */
    protected static String devuelveMes(int mes) {
        switch (mes) {
            case 0:
                return "Enero";
            case 1:
                return "Febrero";
            case 2:
                return "Marzo";
            case 3:
                return "Abril";
            case 4:
                return "Mayo";
            case 5:
                return "Junio";
            case 6:
                return "Julio";
            case 7:
                return "Agosto";
            case 8:
                return "Septiembre";
            case 9:
                return "Octubre";
            case 10:
                return "Noviembre";
            case 11:
                return "Diciembre";
            default:
                return "";
        }
    }

  

    /**
     * Mensaje para componente
     *
     * @param severity FacesMessage.Severity Nivel de mensaje
     * @param summary string Mensaje
     * @param detail String Detalle
     * @param componente String Nombre del componente
     */
    protected void ponerMensajePorComponente(FacesMessage.Severity severity, String summary, String detail, String componente) {
        FacesMessage message = new FacesMessage();
        message.setSeverity(severity);
        message.setSummary(summary);
        message.setDetail(detail);
        getContext().addMessage(componente, message);
    }

    /**
     * Get managed bean based on the bean name.
     *
     * @param beanName the bean name
     * @return the managed bean associated with the bean name
     */
    protected Object getManagedBean(String beanName) {
        ExpressionFactory ef = getApplication().getExpressionFactory();
        ValueExpression ve = ef.createValueExpression(getElContext(), getJsfEl(beanName), Object.class);
        return ve.getValue(getElContext());
    }

    /**
     * Remove the managed bean based on the bean name.
     *
     * @param beanName the bean name of the managed bean to be removed
     */
    protected static void resetManagedBean(String beanName) {
        FacesContext fc = FacesContext.getCurrentInstance();
        ELContext elc = fc.getELContext();
        ExpressionFactory ef = fc.getApplication().getExpressionFactory();
        ef.createValueExpression(elc, getJsfEl(beanName),
                Object.class).setValue(elc, null);
    }

    /**
     * Obtiene path real de los reportes
     *
     * @param nombre String
     * @return String
     */
    protected String getRealPathReportes(String nombre) {
        return getRequest().getSession().getServletContext().getRealPath("/upload/" + nombre);
    }

    /**
     * Devuelve la jsf
     *
     * @param value
     * @return
     */
    private static String getJsfEl(String value) {
        return "#{" + value + "}";
    }

    /**
     * Transforma un String en formato dd/MM/yyyy en fecha
     *
     * @param cadena String
     * @return Date
     */
    protected Date devuelveFechaPorCadena(String cadena) {
        try {
            DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaParseada = fecha.parse(cadena);
            Calendar cal = Calendar.getInstance();
            cal.setTime(fechaParseada);
            return cal.getTime();
        } catch (Exception e) {
            error(getClass().getName(), "no se puede formatear", e);
            return null;
        }
    }

    /**
     * Valida fechas
     *
     * @param fechaDesde Date
     * @param fechaHasta Date
     * @return retorna verdadero o falso
     * @throws Exception si se produce un error al validar las fechas
     */
    protected boolean validaRangoFecha(Date fechaDesde, Date fechaHasta) throws Exception {
        if (fechaDesde == null || fechaHasta == null) {
            return false;
        }
        Calendar fechaSistema = Calendar.getInstance();
        Calendar fechaIngresoUsuario = Calendar.getInstance();
        fechaSistema.setTime(fechaDesde);
        fechaIngresoUsuario.setTime(fechaHasta);
        String fechaSistemaString = fechaSistema.get(Calendar.YEAR) + "-" + fechaSistema.get(Calendar.MONTH) + "-" + fechaSistema.get(Calendar.DATE);
        String fechaIngresoString = fechaIngresoUsuario.get(Calendar.YEAR) + "-" + fechaIngresoUsuario.get(Calendar.MONTH) + "-" + fechaIngresoUsuario.get(Calendar.DATE);
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaSistemaAux = formatoFecha.parse(fechaSistemaString);
        Date fechaIngresoAux = formatoFecha.parse(fechaIngresoString);
        if (fechaSistemaAux.before(fechaIngresoAux) || fechaSistemaAux.equals(fechaIngresoAux)) {
            return true;
        } else {
            return false;
        }
    }

   

    /**
     * @return the context
     */
    protected FacesContext getContext() {
        return FacesContext.getCurrentInstance();
    }

    /**
     * getExternalContext
     *
     * @return getExternalContext();
     */
    protected ExternalContext getExternalContext() {
        return getContext().getExternalContext();
    }

    /**
     * getElContext
     *
     * @return getELContext();
     */
    protected ELContext getElContext() {
        return getContext().getELContext();
    }

    /**
     * getApplication
     *
     * @return getApplication();
     */
    protected Application getApplication() {
        return getContext().getApplication();
    }

    /**
     * getRequest
     *
     * @return (HttpServletRequest)
     */
    protected HttpServletRequest getRequest() {
        return (HttpServletRequest) getExternalContext().getRequest();
    }

    /**
     * getResponse
     *
     * @return (HttpServletResponse)
     */
    protected HttpServletResponse getResponse() {
        return (HttpServletResponse) getContext().getExternalContext().getResponse();

    }

    /**
     * getRequestParameterMap
     *
     * @return getRequestParameterMap()
     */
    protected Map<String, String> getRequestParameterMap() {
        return getExternalContext().getRequestParameterMap();
    }

    /**
     * Log de tipo información
     *
     * @param clase nombre de la clases desde donde se envia la petición
     * @param mensaje Información de mensaje
     */
    protected void info(String clase, String mensaje) {
        Logger.getLogger(clase).log(Level.INFO, mensaje.toUpperCase());
    }

    /**
     * Log de tipo error
     *
     * @param clase nombre de la clase donde se produjo la excepcion
     * @param mensaje mensaje a mostrar
     * @param e Excepción o error
     */
    protected void error(String clase, String mensaje, Exception e) {
        Logger.getLogger(clase).log(Level.SEVERE, mensaje.toUpperCase(), e);
    }

    /**
     * getRequestParameterMap
     *
     * @return getRequestParameterMap
     */
    protected Map<String, String> obtenerParametrosFaces() {
        return getExternalContext().getRequestParameterMap();
    }

    /**
     * Tranforma la cadena en mayusculas
     *
     * @param mayusculas cade de texto a transformar
     * @return cadena de texto en mayusculas sin espacios al inicio y final
     */
    protected String mayusculas(String mayusculas) {
        return mayusculas.toUpperCase().trim();
    }

    /**
     * Cerrar sesión
     */
    public void cerrarSession() {
        try {
            Map<String, Object> map = getContext().getExternalContext().getSessionMap();
            map.remove("user");
            getRequest().getSession().invalidate();
            getExternalContext().redirect(getRequest().getContextPath() + "/login.jsf");
        } catch (Exception ex) {
            error(getClass().getName(), "no se puede cerrar la sesión", ex);
        }
    }

    /**
     * getSession
     *
     * @return retorna el HttpSession en true
     */
    protected static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    }

    /**
     * Cerrar sesion
     */
    protected void closeSession() {
        try {
            getExternalContext().redirect(getRequest().getContextPath().equals("")?"/inicial.jsf":getRequest().getContextPath());
            HttpSession session = getSession();
            session.invalidate();
        } catch (IOException e) {
            error(getClass().getName(), "no se puede cerrar la sesión", e);
        }

    }

   

    /**
     * Quita espacios al inicio y al final de una cadena
     *
     * @param valor cadena de texto
     * @return cadena de texto sin espacio al inicio y al final
     */
    public static String limpiarEspacios(String valor) {
        if (valor != null) {
            valor = valor.trim();
        }
        return valor;
    }

    /**
     * Transforma en mayusculas
     *
     * @param valor cadena de texto
     * @return cadena en mayusculas
     */
    public static String toMayus(String valor) {
        if (valor != null) {
            valor = valor.toUpperCase();
        }
        return valor;
    }

    /**
     * Redondea un valor
     *
     * @param valor Decimal con varios decimales
     * @return Decimal a dos decimales
     */
    public double redondear(Double valor) {
        StringTokenizer token = new StringTokenizer(String.valueOf(valor), ".");
        String decimal = "";
        double retorno = 0;
        while (token.hasMoreTokens()) {
            decimal = token.nextToken();
        }
        if (decimal.length() >= 2) {
            String componer = valor.intValue() + "." + decimal.substring(0, 2);
            retorno = Double.parseDouble(componer);
        } else {
            retorno = valor;
        }
        return retorno;
    }

    /**
     * Ordena una lista especificando la propiedad por la cual realizar la
     * operacion
     *
     * @param lista los datos a ser ordenados
     * @param propiedad por la cual se ordenara la lista
     */
    protected void ordenarLista(List lista, String propiedad) {
        Collections.sort(lista, new Comparator() {
            public int compare(Object obj1, Object obj2) {

                Class clase = obj1.getClass();
                String getter = "get" + Character.toUpperCase(propiedad.charAt(0)) + propiedad.substring(1);
                try {

                    Method getPropiedad = clase.getMethod(getter);

                    Object propiedad1 = getPropiedad.invoke(obj1);
                    Object propiedad2 = getPropiedad.invoke(obj2);

                    if (propiedad1 instanceof Comparable && propiedad2 instanceof Comparable) {
                        Comparable prop1 = (Comparable) propiedad1;
                        Comparable prop2 = (Comparable) propiedad2;
                        return prop1.compareTo(prop2);
                    }//CASO DE QUE NO SEA COMPARABLE  
                    else if (propiedad1.equals(propiedad2)) {
                        return 0;
                    } else {
                        return 1;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });
    }

    /**
     * Numero de meses entre dos fechas
     *
     * @param fechaInicio tipo fecha parametro de entrada
     * @param fechaFin tipo fecha parametro de entrada
     * @return entero numero de meses entre dos fechas
     */
    public static int numeroMeses(Date fechaInicio, Date fechaFin) {
        long fechaInicialMs = fechaInicio.getTime();
        long fechaFinalMs = fechaFin.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double diasDiferncia = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        int valorDias = ((int) diasDiferncia) / 30;
        return valorDias;
    }

    /**
     * Numero de dias entre dos fechas
     *
     * @param fechaInicio tipo fecha parametro de entrada
     * @param fechaFin tipo fecha parametro de entrada
     * @return Entero numero de días
     */
    public static int numeroDias(Date fechaInicio, Date fechaFin) {
        long fechaInicialMs = fechaInicio.getTime();
        long fechaFinalMs = fechaFin.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double diasDiferncia = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        int valorDias = (int) diasDiferncia;
        return valorDias;

    }

    /**
     * Valida el numero de telefono
     *
     * @param telefono cadena como parametro de entrada
     * @return verdadero o falso
     */
    protected boolean validarTelefono(String telefono) {
        Pattern p = Pattern.compile("[^0-9]");
        Matcher m = p.matcher(telefono);

        if (m.find() || telefono.length() != 9) {
            return false;
        } else {
            return true;
        }

    }

    /**
     * Valida el mail
     *
     * @param dato cadena como parametro de entrada
     * @return verdadero o falso
     */
    protected boolean validarEmail(String dato) {
        String PATTERN1 = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(PATTERN1);

        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(dato);
        return matcher.matches();
    }

    /**
     * Valida el celular
     *
     * @param celular cadena como parametro de entrada
     * @return verdadero o falso
     */
    protected boolean validarCelular(String celular) {
        Pattern p = Pattern.compile("[^0-9]");
        Matcher m = p.matcher(celular);

        if (m.find() || celular.length() != 10) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Valida si un dispitivo o tableta es el correcto
     *
     * @param dato Parametro de entrada una cadena
     * @return verdadero o falso
     */
    protected boolean validarCodDispositivo(String dato) {
        String pattern1 = "^P\\d{4}";
        Pattern pat = Pattern.compile(pattern1);
        Matcher mat = pat.matcher(dato);

        if (!mat.find()) {
            return false;
        } else {
            return true;
        }
    }

   

    /**
     * Obtener Lista de paginas activas
     *
     * @return Lista de Urls Permitas a cada usuario protected List<String>
     * obtenerListaUrl() { NavegacionControlador control =
     * (NavegacionControlador)
     * getRequest().getSession().getAttribute("navegacionControlador"); if
     * (control != null) { return control.getUrlIngreso(); } return null; }
     */
    /**
     * Crea variables de session
     *
     * @param nombre String
     * @param valor Object
     */
    protected void crearVariableSession(String nombre, Object valor) {
        HttpSession s = getSession();
        s.setAttribute(nombre, valor);
    }

    /**
     * Obtiene Variables de session;
     *
     * @param nombre nombre de la variable de sesión
     * @return Object con la variable de sessión
     */
    protected Object obtenerVariableSession(String nombre) {
        HttpSession s = getSession();
        try {
            return s.getAttribute(nombre);
        } catch (Exception ex) {
            return null;
        }
    }

    //Metodo para calcular edad segun fecha de nacimiento
    public String getEdad(Date fechaNacimiento) {
        if (fechaNacimiento != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            StringBuilder result = new StringBuilder();
            if (fechaNacimiento != null) {
                Calendar c = new GregorianCalendar();
                c.setTime(fechaNacimiento);
                result.append(calcularEdad(c));
                result.append(" años");
            }
            return result.toString();
        }
        return "";
    }

    private static int calcularEdad(Calendar fechaNac) {
        Calendar today = Calendar.getInstance();
        int diffYear = today.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        int diffMonth = today.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
        int diffDay = today.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);
        // Si está en ese año pero todavía no los ha cumplido
        if (diffMonth < 0 || (diffMonth == 0 && diffDay < 0)) {
            diffYear = diffYear - 1; // no aparecían los dos guiones
        }
        return diffYear;
    }
    //Fin metodo de calculo de Edad

    public int obtenerEdad(String fechaNacimiento) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(fechaNacimiento, fmt);
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNac, ahora);
        return periodo.getYears();
    }

    protected int calculaEdadAnios(Date fechaNacimiento) {
        if (fechaNacimiento == null) {
            return 0;
        }
        Calendar fchNacimiento = Calendar.getInstance();
        fchNacimiento.setTime(fechaNacimiento);
        Calendar fhcActual = Calendar.getInstance();
        int anioNac = fchNacimiento.get(Calendar.YEAR);
        int mesNac = fchNacimiento.get(Calendar.MONTH);
        int diaNac = fchNacimiento.get(Calendar.DAY_OF_MONTH);
        int anioAct = fhcActual.get(Calendar.YEAR);
        int mesAct = fhcActual.get(Calendar.MONTH);
        int diaAct = fhcActual.get(Calendar.DAY_OF_MONTH);
        if (diaAct < diaNac) {
            mesAct--;
        }
        if (mesAct < mesNac) {
            anioAct--;
        }
        return anioAct - anioNac;
    }

    protected int calculaEdadMeses(Date fechaNacimiento) {
        if (fechaNacimiento == null) {
            return 0;
        }
        Calendar fchNacimiento = Calendar.getInstance();
        fchNacimiento.setTime(fechaNacimiento);
        Calendar fhcActual = Calendar.getInstance();
        int mesNac = fchNacimiento.get(Calendar.MONTH);
        int diaNac = fchNacimiento.get(Calendar.DAY_OF_MONTH);
        int mesAct = fhcActual.get(Calendar.MONTH);
        int diaAct = fhcActual.get(Calendar.DAY_OF_MONTH);
        if (diaAct < diaNac) {
            mesAct--;
        }
        if (mesAct < mesNac) {
            mesAct = mesAct + 12;
        }
        return mesAct - mesNac;
    }

    public Date restarAniosFecha(int anios) {
        anios = anios * -1;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, anios);
        return calendar.getTime();
    }

    /**
     *
     * @param nombre
     * @return
     */
    public File crearArchivoUpload(String nombre) {
        String realContextPath = getRequest().getSession().getServletContext().getRealPath("/upload") + "/" + nombre + ".jpg";
        File archivo = new File(realContextPath);
        return archivo;
    }

    public String calcularSemaforo(Date fechainicio, Date fechafin) {
        int diasLimite = (int) ((fechafin.getTime() - fechainicio.getTime()) / 86400000);
        int diasTranscurridos = (int) ((new Date().getTime() - fechainicio.getTime()) / 86400000);
        double porcentaje = (diasTranscurridos * 100) / diasLimite;
        if (porcentaje >= 0 && porcentaje <= 25) {
            return "verde";
        } else if (porcentaje > 25 && porcentaje <= 50) {
            return "amarillo";
        } else if (porcentaje > 50 && porcentaje <= 75) {
            return "naranja";
        } else {
            return "rojo";
        }
    }

    public Integer calcularDias(Date fechainicio) {
        int diasLimite = (int) ((new Date().getTime() - fechainicio.getTime()) / 86400000);
        return diasLimite;
    }

    public File copyFile(String fileName, InputStream in) throws Exception {
        ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String directorioArchivos = ctx.getRealPath("/") + "upload";
        String destination;
        destination = directorioArchivos + "/" + fileName;
        File archivo = new File(destination);
        try (OutputStream out = new FileOutputStream(archivo)) {
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            return archivo;
        } catch (Exception e) {
            System.out.println("El error es: " + e);
            return null;
        }
    }

    public boolean verificarCedula(String cedula) {
        if (cedula.length() == 10) {
            Integer suma = 0;
            Integer valor1 = 0;
            Integer digitoVerificador = 0;
            for (int i = 0; i < cedula.length() - 1; i++) {
                Integer parcial = Integer.parseInt(cedula.charAt(i) + "");
                valor1 = (i + 1) % 2 == 0 ? (parcial * 1) : (parcial * 2);
                if (valor1 >= 10) {
                    valor1 -= 9;
                }
                suma += valor1;
            }
            digitoVerificador = 10 - (suma % 10);
            digitoVerificador = digitoVerificador == 10 ? 0 : digitoVerificador;
            if (digitoVerificador == Integer.parseInt(cedula.charAt(9) + "")) {
                System.out.println("el digito verificador es" + digitoVerificador);
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("La cédula ingresada no es válida");
            return false;
        }
    }

    public String capitalizarTexto(String texto) {
        String[] palabras = texto.split(" ");
        String cadenaFinal = "";
        for (String p : palabras) {
            cadenaFinal += " " + p.substring(0, 1).toUpperCase() + p.substring(1, p.length()).toLowerCase();
        }
        return cadenaFinal.trim();
    }

    public Date ultimaFecha(Date fechaInicio, Integer periodo) {
        List<Date> fechas = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(fechaInicio);
        while (fechas.size() != periodo) {
            cal.add(Calendar.DAY_OF_YEAR, 1);
            if (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                fechas.add(cal.getTime());
            }
        }
        return fechas.get(periodo - 1);
    }

    public Integer contarSabDom(Date fechaInicio, Date fechaFin) {
        Calendar cal = Calendar.getInstance();
        Date fechaNueva = fechaInicio;
        cal.setTime(fechaInicio);
        int numDias = 0;
        while (fechaNueva.before(fechaFin)) {
            cal.add(Calendar.DAY_OF_YEAR, 1);
            fechaNueva = cal.getTime();
            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                numDias++;
            }
        }
        return numDias;
    }

      

  
   

    
    /***
     * Método para formatear un número decimal
     * @param numero
     * @param numeroDecimales
     * @return 
     */
    public static Double formatearDecimales(Double numero, Integer numeroDecimales) {
        return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
    }

}
