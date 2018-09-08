
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

public class principal2 implements IRemote{
	public static principal2 mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public principal2() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("principal2"), "b4a.example.principal2");
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
		pcBA = new PCBA(this, principal2.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _contenido = RemoteObject.createImmutable("");
public static RemoteObject _dospuntos = RemoteObject.createImmutable(false);
public static RemoteObject _contadorcaracter = RemoteObject.createImmutable(0);
public static RemoteObject _letratemporal = RemoteObject.createImmutable("");
public static RemoteObject _seccion = RemoteObject.createImmutable(0);
public static RemoteObject _nombreevento = RemoteObject.createImmutable("");
public static RemoteObject _fechaevento = RemoteObject.createImmutable("");
public static RemoteObject _horaevento = RemoteObject.createImmutable("");
public static RemoteObject _nombredocumento = RemoteObject.createImmutable("");
public static RemoteObject _conferencista = RemoteObject.createImmutable("");
public static RemoteObject _tipoevento = RemoteObject.createImmutable("");
public static RemoteObject _primeravezengrupos = RemoteObject.createImmutable(false);
public static RemoteObject _iniciogrupos = RemoteObject.createImmutable(0);
public static RemoteObject _cantidadgrupos = RemoteObject.createImmutable(0);
public static RemoteObject _secciongrupo = RemoteObject.createImmutable(0);
public static RemoteObject _despliegagrupos = RemoteObject.createImmutable(0);
public static RemoteObject _eventospanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _detalleseventos = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _eventos = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _plusevento = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _dateutils = RemoteObject.declareNull("b4a.example.dateutils");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.principal _principal = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",principal2.mostCurrent._activity,"CantidadGrupos",principal2._cantidadgrupos,"Conferencista",principal2._conferencista,"ContadorCaracter",principal2._contadorcaracter,"Contenido",principal2._contenido,"DateUtils",principal2.mostCurrent._dateutils,"DespliegaGrupos",principal2._despliegagrupos,"DetallesEventos",principal2.mostCurrent._detalleseventos,"DosPuntos",principal2._dospuntos,"Eventos",principal2.mostCurrent._eventos,"EventosPanel",principal2.mostCurrent._eventospanel,"FechaEvento",principal2._fechaevento,"HoraEvento",principal2._horaevento,"InicioGrupos",principal2._iniciogrupos,"LetraTemporal",principal2._letratemporal,"Main",Debug.moduleToString(b4a.example.main.class),"NombreDocumento",principal2._nombredocumento,"NombreEvento",principal2._nombreevento,"PlusEvento",principal2.mostCurrent._plusevento,"PrimeraVezEnGrupos",principal2._primeravezengrupos,"Principal",Debug.moduleToString(b4a.example.principal.class),"Seccion",principal2._seccion,"SeccionGrupo",principal2._secciongrupo,"Starter",Debug.moduleToString(b4a.example.starter.class),"TipoEvento",principal2._tipoevento};
}
}