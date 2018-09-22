package com.ServicioSocial;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,30);
if (RapidSub.canDelegate("activity_create")) { return com.ServicioSocial.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 30;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 31;BA.debugLine="Activity.LoadLayout(\"SplashScreen\")";
Debug.ShouldStop(1073741824);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("SplashScreen")),main.mostCurrent.activityBA);
 BA.debugLineNum = 32;BA.debugLine="CheckForWiFi";
Debug.ShouldStop(-2147483648);
_checkforwifi();
 BA.debugLineNum = 33;BA.debugLine="If (ConexionAInternet= False) Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("=",main._conexionainternet,main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 34;BA.debugLine="Activity.Finish";
Debug.ShouldStop(2);
main.mostCurrent._activity.runVoidMethod ("Finish");
 }else {
 BA.debugLineNum = 36;BA.debugLine="tiempo.Initialize(\"tiempo\",5000)";
Debug.ShouldStop(8);
main._tiempo.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("tiempo")),(Object)(BA.numberCast(long.class, 5000)));
 BA.debugLineNum = 37;BA.debugLine="tiempo.Enabled=True";
Debug.ShouldStop(16);
main._tiempo.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 40;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,60);
if (RapidSub.canDelegate("activity_pause")) { return com.ServicioSocial.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 60;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 62;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,56);
if (RapidSub.canDelegate("activity_resume")) { return com.ServicioSocial.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 56;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 58;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _checkforwifi() throws Exception{
try {
		Debug.PushSubsStack("CheckForWiFi (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,42);
if (RapidSub.canDelegate("checkforwifi")) { return com.ServicioSocial.main.remoteMe.runUserSub(false, "main","checkforwifi");}
 BA.debugLineNum = 42;BA.debugLine="Sub CheckForWiFi";
Debug.ShouldStop(512);
 BA.debugLineNum = 43;BA.debugLine="If Conexion.isOnLine=False Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",main._conexion.runMethod(true,"isOnLine",main.processBA),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 44;BA.debugLine="ToastMessageShow(\"No tiene conexion a internet\",";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No tiene conexion a internet")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 45;BA.debugLine="ConexionAInternet=False";
Debug.ShouldStop(4096);
main._conexionainternet = main.mostCurrent.__c.getField(true,"False");
 }else {
 BA.debugLineNum = 47;BA.debugLine="ToastMessageShow(\"Tiene conexion a internet\",Tru";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Tiene conexion a internet")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 48;BA.debugLine="ConexionAInternet=True";
Debug.ShouldStop(32768);
main._conexionainternet = main.mostCurrent.__c.getField(true,"True");
 };
 BA.debugLineNum = 50;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 24;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
principal_subs_0._process_globals();
crearevento_subs_0._process_globals();
confhorarios_subs_0._process_globals();
seleccionargrupos_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("com.ServicioSocial.main");
starter.myClass = BA.getDeviceClass ("com.ServicioSocial.starter");
principal.myClass = BA.getDeviceClass ("com.ServicioSocial.principal");
crearevento.myClass = BA.getDeviceClass ("com.ServicioSocial.crearevento");
confhorarios.myClass = BA.getDeviceClass ("com.ServicioSocial.confhorarios");
seleccionargrupos.myClass = BA.getDeviceClass ("com.ServicioSocial.seleccionargrupos");
table.myClass = BA.getDeviceClass ("com.ServicioSocial.table");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 19;BA.debugLine="Dim ConexionAInternet As Boolean";
main._conexionainternet = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 20;BA.debugLine="Dim tiempo As Timer";
main._tiempo = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 21;BA.debugLine="Dim Conexion As MLwifi";
main._conexion = RemoteObject.createNew ("wifi.MLwifi");
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _tiempo_tick() throws Exception{
try {
		Debug.PushSubsStack("tiempo_Tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,52);
if (RapidSub.canDelegate("tiempo_tick")) { return com.ServicioSocial.main.remoteMe.runUserSub(false, "main","tiempo_tick");}
 BA.debugLineNum = 52;BA.debugLine="Sub tiempo_Tick";
Debug.ShouldStop(524288);
 BA.debugLineNum = 53;BA.debugLine="StartActivity(Principal)";
Debug.ShouldStop(1048576);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._principal.getObject())));
 BA.debugLineNum = 54;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}