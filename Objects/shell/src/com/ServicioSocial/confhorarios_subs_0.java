package com.ServicioSocial;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class confhorarios_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (confhorarios) ","confhorarios",4,confhorarios.mostCurrent.activityBA,confhorarios.mostCurrent,18);
if (RapidSub.canDelegate("activity_create")) { return com.ServicioSocial.confhorarios.remoteMe.runUserSub(false, "confhorarios","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 18;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 19;BA.debugLine="Archivo.Initialize(File.DirRootExternal,\"book1.xl";
Debug.ShouldStop(262144);
confhorarios._archivo.runVoidMethod ("Initialize",(Object)(confhorarios.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirRootExternal")),(Object)(RemoteObject.createImmutable("book1.xls")));
 BA.debugLineNum = 20;BA.debugLine="Sheet=Archivo.GetSheet(0)";
Debug.ShouldStop(524288);
confhorarios._sheet = confhorarios._archivo.runMethod(false,"GetSheet",(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 21;BA.debugLine="NuevoArchivo.Initialize(File.DirRootExternal,\"Hor";
Debug.ShouldStop(1048576);
confhorarios._nuevoarchivo.runVoidMethod ("Initialize",(Object)(confhorarios.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirRootExternal")),(Object)(RemoteObject.createImmutable("HorarioModificado.xls")));
 BA.debugLineNum = 22;BA.debugLine="SheetEditable=NuevoArchivo.AddSheet(\"Peliculas\",0";
Debug.ShouldStop(2097152);
confhorarios._sheeteditable = confhorarios._nuevoarchivo.runMethod(false,"AddSheet",(Object)(BA.ObjectToString("Peliculas")),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 23;BA.debugLine="celda.InitializeText(1,0,\"Hola Mundo\")";
Debug.ShouldStop(4194304);
confhorarios._celda.runVoidMethod ("InitializeText",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.createImmutable("Hola Mundo")));
 BA.debugLineNum = 24;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("Activity_Pause (confhorarios) ","confhorarios",4,confhorarios.mostCurrent.activityBA,confhorarios.mostCurrent,30);
if (RapidSub.canDelegate("activity_pause")) { return com.ServicioSocial.confhorarios.remoteMe.runUserSub(false, "confhorarios","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 30;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 32;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("Activity_Resume (confhorarios) ","confhorarios",4,confhorarios.mostCurrent.activityBA,confhorarios.mostCurrent,26);
if (RapidSub.canDelegate("activity_resume")) { return com.ServicioSocial.confhorarios.remoteMe.runUserSub(false, "confhorarios","activity_resume");}
 BA.debugLineNum = 26;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 28;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Dim Archivo As ReadableWorkbook";
confhorarios._archivo = RemoteObject.createNew ("anywheresoftware.b4a.objects.WorkbookWrapper");
 //BA.debugLineNum = 8;BA.debugLine="Dim Sheet As ReadableSheet";
confhorarios._sheet = RemoteObject.createNew ("anywheresoftware.b4a.objects.WorkbookWrapper.SheetWrapper");
 //BA.debugLineNum = 9;BA.debugLine="Dim NuevoArchivo As WritableWorkbook";
confhorarios._nuevoarchivo = RemoteObject.createNew ("anywheresoftware.b4a.objects.WorkbookWrapper.WritableWorkbookWrapper");
 //BA.debugLineNum = 10;BA.debugLine="Dim SheetEditable As WritableSheet";
confhorarios._sheeteditable = RemoteObject.createNew ("anywheresoftware.b4a.objects.WorkbookWrapper.WritableSheetWrapper");
 //BA.debugLineNum = 11;BA.debugLine="Dim celda As WritableCell";
confhorarios._celda = RemoteObject.createNew ("anywheresoftware.b4a.objects.WorkbookWrapper.WritableCellWrapper");
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}