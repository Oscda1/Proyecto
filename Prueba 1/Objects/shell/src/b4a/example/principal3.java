
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

public class principal3 implements IRemote{
	public static principal3 mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public principal3() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("principal3"), "b4a.example.principal3");
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
		pcBA = new PCBA(this, principal3.class);
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
public static RemoteObject _detalleseventos = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _eventospanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _eventos = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _plusevento = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _dateutils = RemoteObject.declareNull("b4a.example.dateutils");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.principal _principal = null;
public static b4a.example.principal2 _principal2 = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",principal3.mostCurrent._activity,"cantidades",principal3._cantidades,"Conferencista",principal3._conferencista,"Contador",principal3._contador,"contenido",principal3._contenido,"DateUtils",principal3.mostCurrent._dateutils,"DetallesEventos",principal3.mostCurrent._detalleseventos,"Eventos",principal3.mostCurrent._eventos,"EventosPanel",principal3.mostCurrent._eventospanel,"FechaEvento",principal3._fechaevento,"Grupos",principal3._grupos,"HoraEvento",principal3._horaevento,"Main",Debug.moduleToString(b4a.example.main.class),"NombreDocumento",principal3._nombredocumento,"NombreEvento",principal3._nombreevento,"PlusEvento",principal3.mostCurrent._plusevento,"Principal",Debug.moduleToString(b4a.example.principal.class),"Principal2",Debug.moduleToString(b4a.example.principal2.class),"Sale",principal3._sale,"Starter",Debug.moduleToString(b4a.example.starter.class),"TipoEvento",principal3._tipoevento};
}
}