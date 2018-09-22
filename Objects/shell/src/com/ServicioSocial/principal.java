
package com.ServicioSocial;

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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("principal"), "com.ServicioSocial.principal");
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
public static RemoteObject _contenido = RemoteObject.createImmutable("");
public static RemoteObject _cantidades = null;
public static RemoteObject _sale = RemoteObject.createImmutable(false);
public static RemoteObject _contador = RemoteObject.createImmutable(0);
public static RemoteObject _nombreevento = RemoteObject.createImmutable("");
public static RemoteObject _fechaevento = RemoteObject.createImmutable("");
public static RemoteObject _horaevento = RemoteObject.createImmutable("");
public static RemoteObject _nombredocumento = RemoteObject.createImmutable("");
public static RemoteObject _conferencista = RemoteObject.createImmutable("");
public static RemoteObject _tipoevento = RemoteObject.createImmutable("");
public static RemoteObject _grupos = null;
public static RemoteObject _btm = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
public static RemoteObject _detalleseventos = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _eventospanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _eventos = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _plusevento = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _settings = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static com.ServicioSocial.main _main = null;
public static com.ServicioSocial.starter _starter = null;
public static com.ServicioSocial.crearevento _crearevento = null;
public static com.ServicioSocial.confhorarios _confhorarios = null;
public static com.ServicioSocial.seleccionargrupos _seleccionargrupos = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",principal.mostCurrent._activity,"btm",principal._btm,"cantidades",principal._cantidades,"Conferencista",principal._conferencista,"ConfHorarios",Debug.moduleToString(com.ServicioSocial.confhorarios.class),"Contador",principal._contador,"contenido",principal._contenido,"CrearEvento",Debug.moduleToString(com.ServicioSocial.crearevento.class),"DetallesEventos",principal.mostCurrent._detalleseventos,"Eventos",principal.mostCurrent._eventos,"EventosPanel",principal.mostCurrent._eventospanel,"FechaEvento",principal._fechaevento,"Grupos",principal._grupos,"HoraEvento",principal._horaevento,"Main",Debug.moduleToString(com.ServicioSocial.main.class),"NombreDocumento",principal._nombredocumento,"NombreEvento",principal._nombreevento,"PlusEvento",principal.mostCurrent._plusevento,"Sale",principal._sale,"SeleccionarGrupos",Debug.moduleToString(com.ServicioSocial.seleccionargrupos.class),"Settings",principal.mostCurrent._settings,"Starter",Debug.moduleToString(com.ServicioSocial.starter.class),"TipoEvento",principal._tipoevento};
}
}