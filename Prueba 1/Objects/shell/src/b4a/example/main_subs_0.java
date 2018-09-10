package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,29);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 29;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 30;BA.debugLine="Activity.LoadLayout(\"SplashScreen\")";
Debug.ShouldStop(536870912);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("SplashScreen")),main.mostCurrent.activityBA);
 BA.debugLineNum = 31;BA.debugLine="CheckForWiFi";
Debug.ShouldStop(1073741824);
_checkforwifi();
 BA.debugLineNum = 32;BA.debugLine="If (ConexionAInternet= False) Then";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean("=",main._conexionainternet,main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 33;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1);
main.mostCurrent._activity.runVoidMethod ("Finish");
 }else {
 BA.debugLineNum = 35;BA.debugLine="tiempo.Initialize(\"tiempo\",5000)";
Debug.ShouldStop(4);
main._tiempo.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("tiempo")),(Object)(BA.numberCast(long.class, 5000)));
 BA.debugLineNum = 36;BA.debugLine="tiempo.Enabled=True";
Debug.ShouldStop(8);
main._tiempo.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 39;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,59);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 59;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 61;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,55);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 55;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("CheckForWiFi (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,41);
if (RapidSub.canDelegate("checkforwifi")) { return b4a.example.main.remoteMe.runUserSub(false, "main","checkforwifi");}
 BA.debugLineNum = 41;BA.debugLine="Sub CheckForWiFi";
Debug.ShouldStop(256);
 BA.debugLineNum = 42;BA.debugLine="If Conexion.isOnLine=False Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",main._conexion.runMethod(true,"isOnLine",main.processBA),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 43;BA.debugLine="ToastMessageShow(\"No tiene conexion a internet\",";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No tiene conexion a internet")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 44;BA.debugLine="ConexionAInternet=False";
Debug.ShouldStop(2048);
main._conexionainternet = main.mostCurrent.__c.getField(true,"False");
 }else {
 BA.debugLineNum = 46;BA.debugLine="ToastMessageShow(\"Tiene conexion a internet\",Tru";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Tiene conexion a internet")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 47;BA.debugLine="ConexionAInternet=True";
Debug.ShouldStop(16384);
main._conexionainternet = main.mostCurrent.__c.getField(true,"True");
 };
 BA.debugLineNum = 49;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 23;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
principal_subs_0._process_globals();
principal2_subs_0._process_globals();
principal3_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
principal.myClass = BA.getDeviceClass ("b4a.example.principal");
principal2.myClass = BA.getDeviceClass ("b4a.example.principal2");
principal3.myClass = BA.getDeviceClass ("b4a.example.principal3");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Dim ConexionAInternet As Boolean";
main._conexionainternet = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 19;BA.debugLine="Dim tiempo As Timer";
main._tiempo = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 20;BA.debugLine="Dim Conexion As MLwifi";
main._conexion = RemoteObject.createNew ("wifi.MLwifi");
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _tiempo_tick() throws Exception{
try {
		Debug.PushSubsStack("tiempo_Tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,51);
if (RapidSub.canDelegate("tiempo_tick")) { return b4a.example.main.remoteMe.runUserSub(false, "main","tiempo_tick");}
 BA.debugLineNum = 51;BA.debugLine="Sub tiempo_Tick";
Debug.ShouldStop(262144);
 BA.debugLineNum = 52;BA.debugLine="StartActivity(Principal3)";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._principal3.getObject())));
 BA.debugLineNum = 53;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}