package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class principal_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (principal) ","principal",2,principal.mostCurrent.activityBA,principal.mostCurrent,20);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.principal.remoteMe.runUserSub(false, "principal","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 20;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 22;BA.debugLine="Activity.LoadLayout(\"PrincipalLayout\")";
Debug.ShouldStop(2097152);
principal.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("PrincipalLayout")),principal.mostCurrent.activityBA);
 BA.debugLineNum = 23;BA.debugLine="Contenido=File.ReadString(File.DirAssets,\"eventos";
Debug.ShouldStop(4194304);
principal._contenido = principal.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(principal.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("eventos.txt")));
 BA.debugLineNum = 24;BA.debugLine="If (Contenido<>\"\") Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("!",principal._contenido,RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 25;BA.debugLine="Existen=True";
Debug.ShouldStop(16777216);
principal._existen = principal.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 27;BA.debugLine="Existen=False";
Debug.ShouldStop(67108864);
principal._existen = principal.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 29;BA.debugLine="If Existen Then";
Debug.ShouldStop(268435456);
if (principal._existen.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 30;BA.debugLine="Eventos.Visible=False";
Debug.ShouldStop(536870912);
principal.mostCurrent._eventos.runMethod(true,"setVisible",principal.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 32;BA.debugLine="Eventos.Visible=True";
Debug.ShouldStop(-2147483648);
principal.mostCurrent._eventos.runMethod(true,"setVisible",principal.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 34;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("Activity_Pause (principal) ","principal",2,principal.mostCurrent.activityBA,principal.mostCurrent,40);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.principal.remoteMe.runUserSub(false, "principal","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 40;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(128);
 BA.debugLineNum = 42;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("Activity_Resume (principal) ","principal",2,principal.mostCurrent.activityBA,principal.mostCurrent,36);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.principal.remoteMe.runUserSub(false, "principal","activity_resume");}
 BA.debugLineNum = 36;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8);
 BA.debugLineNum = 38;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private Eventos As Label";
principal.mostCurrent._eventos = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private PlusEvento As Button";
principal.mostCurrent._plusevento = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _plusevento_click() throws Exception{
try {
		Debug.PushSubsStack("PlusEvento_Click (principal) ","principal",2,principal.mostCurrent.activityBA,principal.mostCurrent,45);
if (RapidSub.canDelegate("plusevento_click")) { return b4a.example.principal.remoteMe.runUserSub(false, "principal","plusevento_click");}
 BA.debugLineNum = 45;BA.debugLine="Sub PlusEvento_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 47;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim Existen As Boolean";
principal._existen = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 10;BA.debugLine="Dim Contenido As String";
principal._contenido = RemoteObject.createImmutable("");
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}