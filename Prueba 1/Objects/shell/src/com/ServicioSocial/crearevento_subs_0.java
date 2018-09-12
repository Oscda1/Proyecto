package com.ServicioSocial;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class crearevento_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (crearevento) ","crearevento",3,crearevento.mostCurrent.activityBA,crearevento.mostCurrent,22);
if (RapidSub.canDelegate("activity_create")) { return com.ServicioSocial.crearevento.remoteMe.runUserSub(false, "crearevento","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 22;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 24;BA.debugLine="Activity.LoadLayout(\"NuevoEventoLayout\")";
Debug.ShouldStop(8388608);
crearevento.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("NuevoEventoLayout")),crearevento.mostCurrent.activityBA);
 BA.debugLineNum = 25;BA.debugLine="BarraTitulo.Bitmap=LoadBitmap(File.DirAssets,\"Bar";
Debug.ShouldStop(16777216);
crearevento.mostCurrent._barratitulo.runMethod(false,"setBitmap",(crearevento.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(crearevento.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("Barra_Texto_titulo.png"))).getObject()));
 BA.debugLineNum = 26;BA.debugLine="ImagenRegresar.Bitmap=LoadBitmap(File.DirAssets,\"";
Debug.ShouldStop(33554432);
crearevento.mostCurrent._imagenregresar.runMethod(false,"setBitmap",(crearevento.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(crearevento.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("Boton_retroceso.png"))).getObject()));
 BA.debugLineNum = 27;BA.debugLine="NombreEventoEditText.SetBackgroundImage(LoadBitma";
Debug.ShouldStop(67108864);
crearevento.mostCurrent._nombreeventoedittext.runVoidMethod ("SetBackgroundImage",(Object)((crearevento.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(crearevento.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("Barra_TextoNombre y Conferencista.png"))).getObject())));
 BA.debugLineNum = 29;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (crearevento) ","crearevento",3,crearevento.mostCurrent.activityBA,crearevento.mostCurrent,35);
if (RapidSub.canDelegate("activity_pause")) { return com.ServicioSocial.crearevento.remoteMe.runUserSub(false, "crearevento","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 35;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4);
 BA.debugLineNum = 37;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (crearevento) ","crearevento",3,crearevento.mostCurrent.activityBA,crearevento.mostCurrent,31);
if (RapidSub.canDelegate("activity_resume")) { return com.ServicioSocial.crearevento.remoteMe.runUserSub(false, "crearevento","activity_resume");}
 BA.debugLineNum = 31;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 33;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private BarraTitulo As ImageView";
crearevento.mostCurrent._barratitulo = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private ImagenRegresar As ImageView";
crearevento.mostCurrent._imagenregresar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private NombreEventoEditText As FloatLabeledEditT";
crearevento.mostCurrent._nombreeventoedittext = RemoteObject.createNew ("anywheresoftware.b4a.objects.FloatLabeledEditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}