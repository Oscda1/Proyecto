
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

public class seleccionargrupos implements IRemote{
	public static seleccionargrupos mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public seleccionargrupos() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("seleccionargrupos"), "com.ServicioSocial.seleccionargrupos");
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
		pcBA = new PCBA(this, seleccionargrupos.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static com.ServicioSocial.main _main = null;
public static com.ServicioSocial.starter _starter = null;
public static com.ServicioSocial.principal _principal = null;
public static com.ServicioSocial.crearevento _crearevento = null;
public static com.ServicioSocial.confhorarios _confhorarios = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",seleccionargrupos.mostCurrent._activity,"ConfHorarios",Debug.moduleToString(com.ServicioSocial.confhorarios.class),"CrearEvento",Debug.moduleToString(com.ServicioSocial.crearevento.class),"Main",Debug.moduleToString(com.ServicioSocial.main.class),"Principal",Debug.moduleToString(com.ServicioSocial.principal.class),"Starter",Debug.moduleToString(com.ServicioSocial.starter.class)};
}
}