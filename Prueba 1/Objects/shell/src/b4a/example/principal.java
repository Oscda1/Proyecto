
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class principal implements IRemote{
	public static principal mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public principal() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("principal"), "b4a.example.principal");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, principal.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _existen = RemoteObject.createImmutable(false);
public static RemoteObject _contenido = RemoteObject.createImmutable("");
public static RemoteObject _contador1 = RemoteObject.createImmutable(0);
public static RemoteObject _contador2 = RemoteObject.createImmutable(0);
public static RemoteObject _cargarevento = RemoteObject.createImmutable(false);
public static RemoteObject _todoslosgrupos = RemoteObject.createImmutable(false);
public static RemoteObject _temporal = RemoteObject.createImmutable("");
public static RemoteObject _contador3 = RemoteObject.createImmutable(0);
public static RemoteObject _cantidadgrupos = RemoteObject.createImmutable(0);
public static RemoteObject _dospuntos = RemoteObject.createImmutable(false);
public static RemoteObject _puntoycoma = RemoteObject.createImmutable("");
public static RemoteObject _numerodeinicio = RemoteObject.createImmutable(0);
public static RemoteObject _seccion = RemoteObject.createImmutable(0);
public static RemoteObject _nombreevento = RemoteObject.createImmutable("");
public static RemoteObject _fechaevento = RemoteObject.createImmutable("");
public static RemoteObject _horaevento = RemoteObject.createImmutable("");
public static RemoteObject _tipoevento = RemoteObject.createImmutable("");
public static RemoteObject _nombredeldocumento = RemoteObject.createImmutable("");
public static RemoteObject _conferencista = RemoteObject.createImmutable("");
public static RemoteObject _contador4 = RemoteObject.createImmutable(0);
public static RemoteObject _totalcaracteres = RemoteObject.createImmutable(false);
public static RemoteObject _cantidadcaracteres = RemoteObject.createImmutable(0);
public static RemoteObject _eventos = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _plusevento = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _detalleseventos = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _eventospanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _dateutils = RemoteObject.declareNull("b4a.example.dateutils");
public static RemoteObject _httputils2service = RemoteObject.declareNull("anywheresoftware.b4a.samples.httputils2.httputils2service");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",principal.mostCurrent._activity,"CantidadCaracteres",principal._cantidadcaracteres,"CantidadGrupos",principal._cantidadgrupos,"CargarEvento",principal._cargarevento,"Conferencista",principal._conferencista,"Contador1",principal._contador1,"Contador2",principal._contador2,"Contador3",principal._contador3,"Contador4",principal._contador4,"Contenido",principal._contenido,"DateUtils",principal.mostCurrent._dateutils,"DetallesEventos",principal.mostCurrent._detalleseventos,"DosPuntos",principal._dospuntos,"Eventos",principal.mostCurrent._eventos,"EventosPanel",principal.mostCurrent._eventospanel,"Existen",principal._existen,"FechaEvento",principal._fechaevento,"HoraEvento",principal._horaevento,"HttpUtils2Service",principal.mostCurrent._httputils2service,"Main",Debug.moduleToString(b4a.example.main.class),"NombreDelDocumento",principal._nombredeldocumento,"NombreEvento",principal._nombreevento,"NumeroDeInicio",principal._numerodeinicio,"PlusEvento",principal.mostCurrent._plusevento,"PuntoYComa",principal._puntoycoma,"Seccion",principal._seccion,"Starter",Debug.moduleToString(b4a.example.starter.class),"Temporal",principal._temporal,"TipoEvento",principal._tipoevento,"TodosLosGrupos",principal._todoslosgrupos,"TotalCaracteres",principal._totalcaracteres};
}
}