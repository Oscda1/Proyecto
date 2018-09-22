
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

public class crearevento implements IRemote{
	public static crearevento mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public crearevento() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("crearevento"), "com.ServicioSocial.crearevento");
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
		pcBA = new PCBA(this, crearevento.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
public static RemoteObject _bmp2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
public static RemoteObject _barratitulo = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _imagenregresar = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _nombreeventoedittext = RemoteObject.declareNull("anywheresoftware.b4a.objects.FloatLabeledEditTextWrapper");
public static RemoteObject _labeldate = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _labeltime = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _btntime = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _perfilesevento = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _etiqueta_nombre_archivo = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _btndate = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _perfiles = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _conferencias = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _botongrupos = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static com.ServicioSocial.main _main = null;
public static com.ServicioSocial.starter _starter = null;
public static com.ServicioSocial.principal _principal = null;
public static com.ServicioSocial.confhorarios _confhorarios = null;
public static com.ServicioSocial.seleccionargrupos _seleccionargrupos = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",crearevento.mostCurrent._activity,"BarraTitulo",crearevento.mostCurrent._barratitulo,"Bmp",crearevento._bmp,"Bmp2",crearevento._bmp2,"BotonGrupos",crearevento.mostCurrent._botongrupos,"btnDate",crearevento.mostCurrent._btndate,"btnTime",crearevento.mostCurrent._btntime,"Conferencias",crearevento.mostCurrent._conferencias,"ConfHorarios",Debug.moduleToString(com.ServicioSocial.confhorarios.class),"Etiqueta_Nombre_Archivo",crearevento.mostCurrent._etiqueta_nombre_archivo,"ImagenRegresar",crearevento.mostCurrent._imagenregresar,"LabelDate",crearevento.mostCurrent._labeldate,"LabelTime",crearevento.mostCurrent._labeltime,"Main",Debug.moduleToString(com.ServicioSocial.main.class),"NombreEventoEditText",crearevento.mostCurrent._nombreeventoedittext,"Perfiles",crearevento.mostCurrent._perfiles,"PerfilesEvento",crearevento.mostCurrent._perfilesevento,"Principal",Debug.moduleToString(com.ServicioSocial.principal.class),"SeleccionarGrupos",Debug.moduleToString(com.ServicioSocial.seleccionargrupos.class),"Starter",Debug.moduleToString(com.ServicioSocial.starter.class)};
}
}