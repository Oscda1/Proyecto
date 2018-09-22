package com.ServicioSocial;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class principal_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (principal) ","principal",2,principal.mostCurrent.activityBA,principal.mostCurrent,34);
if (RapidSub.canDelegate("activity_create")) { return com.ServicioSocial.principal.remoteMe.runUserSub(false, "principal","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 34;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2);
 BA.debugLineNum = 36;BA.debugLine="Activity.LoadLayout(\"PrincipalLayout\")";
Debug.ShouldStop(8);
principal.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("PrincipalLayout")),principal.mostCurrent.activityBA);
 BA.debugLineNum = 37;BA.debugLine="contenido=File.ReadString(File.DirAssets,\"Eventos";
Debug.ShouldStop(16);
principal._contenido = principal.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(principal.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("Eventos.txt")));
 BA.debugLineNum = 38;BA.debugLine="If contenido=\"\" Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",principal._contenido,BA.ObjectToString(""))) { 
 BA.debugLineNum = 39;BA.debugLine="Eventos.Visible=True";
Debug.ShouldStop(64);
principal.mostCurrent._eventos.runMethod(true,"setVisible",principal.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 40;BA.debugLine="EventosPanel.Visible=False";
Debug.ShouldStop(128);
principal.mostCurrent._eventospanel.runMethod(true,"setVisible",principal.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 42;BA.debugLine="btm.Initialize(File.DirAssets,\"Barra_Datos_Event";
Debug.ShouldStop(512);
principal._btm.runVoidMethod ("Initialize",(Object)(principal.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("Barra_Datos_Evento.png")));
 BA.debugLineNum = 43;BA.debugLine="DetallesEventos.SetBackgroundImage(btm)";
Debug.ShouldStop(1024);
principal.mostCurrent._detalleseventos.runVoidMethod ("SetBackgroundImageNew",(Object)((principal._btm.getObject())));
 BA.debugLineNum = 44;BA.debugLine="Eventos.Visible=False";
Debug.ShouldStop(2048);
principal.mostCurrent._eventos.runMethod(true,"setVisible",principal.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 45;BA.debugLine="EventosPanel.Visible=True";
Debug.ShouldStop(4096);
principal.mostCurrent._eventospanel.runMethod(true,"setVisible",principal.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 46;BA.debugLine="cantidades=Regex.Split(\"-\", contenido)";
Debug.ShouldStop(8192);
principal._cantidades = principal.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString("-")),(Object)(principal._contenido));
 BA.debugLineNum = 47;BA.debugLine="Sale=False";
Debug.ShouldStop(16384);
principal._sale = principal.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 48;BA.debugLine="Contador=-1";
Debug.ShouldStop(32768);
principal._contador = BA.numberCast(int.class, -(double) (0 + 1));
 BA.debugLineNum = 49;BA.debugLine="Do While Sale=False";
Debug.ShouldStop(65536);
while (RemoteObject.solveBoolean("=",principal._sale,principal.mostCurrent.__c.getField(true,"False"))) {
 BA.debugLineNum = 50;BA.debugLine="Contador=Contador+1";
Debug.ShouldStop(131072);
principal._contador = RemoteObject.solve(new RemoteObject[] {principal._contador,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 51;BA.debugLine="Select Contador";
Debug.ShouldStop(262144);
switch (BA.switchObjectToInt(principal._contador,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5),BA.numberCast(int.class, 6))) {
case 0: {
 BA.debugLineNum = 53;BA.debugLine="NombreEvento=cantidades(Contador)";
Debug.ShouldStop(1048576);
principal._nombreevento = principal._cantidades.getArrayElement(true,principal._contador);
 break; }
case 1: {
 BA.debugLineNum = 55;BA.debugLine="FechaEvento=cantidades(Contador)";
Debug.ShouldStop(4194304);
principal._fechaevento = principal._cantidades.getArrayElement(true,principal._contador);
 break; }
case 2: {
 BA.debugLineNum = 57;BA.debugLine="HoraEvento=cantidades(Contador)";
Debug.ShouldStop(16777216);
principal._horaevento = principal._cantidades.getArrayElement(true,principal._contador);
 break; }
case 3: {
 BA.debugLineNum = 59;BA.debugLine="TipoEvento=cantidades(Contador)";
Debug.ShouldStop(67108864);
principal._tipoevento = principal._cantidades.getArrayElement(true,principal._contador);
 break; }
case 4: {
 BA.debugLineNum = 61;BA.debugLine="NombreDocumento=cantidades(Contador)";
Debug.ShouldStop(268435456);
principal._nombredocumento = principal._cantidades.getArrayElement(true,principal._contador);
 break; }
case 5: {
 BA.debugLineNum = 63;BA.debugLine="Conferencista=cantidades(Contador)";
Debug.ShouldStop(1073741824);
principal._conferencista = principal._cantidades.getArrayElement(true,principal._contador);
 break; }
case 6: {
 BA.debugLineNum = 65;BA.debugLine="Grupos=Regex.Split(\";\",cantidades(Contador))";
Debug.ShouldStop(1);
principal._grupos = principal.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString(";")),(Object)(principal._cantidades.getArrayElement(true,principal._contador)));
 BA.debugLineNum = 66;BA.debugLine="Sale=True";
Debug.ShouldStop(2);
principal._sale = principal.mostCurrent.__c.getField(true,"True");
 break; }
}
;
 }
;
 BA.debugLineNum = 69;BA.debugLine="Sale=False";
Debug.ShouldStop(16);
principal._sale = principal.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 70;BA.debugLine="Contador=-1";
Debug.ShouldStop(32);
principal._contador = BA.numberCast(int.class, -(double) (0 + 1));
 BA.debugLineNum = 71;BA.debugLine="DetallesEventos.Text=\"El evento \"&NombreEvento&\"";
Debug.ShouldStop(64);
principal.mostCurrent._detalleseventos.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("El evento "),principal._nombreevento,RemoteObject.createImmutable(" sera el dia "),principal._fechaevento,RemoteObject.createImmutable(" a las "),principal._horaevento,RemoteObject.createImmutable(" sera un evento de "),principal._tipoevento,RemoteObject.createImmutable(" el documento es "),principal._nombredocumento,RemoteObject.createImmutable(" el conferencista sera "),principal._conferencista,RemoteObject.createImmutable(" y los grupos implicados seran "),principal.mostCurrent.__c.getField(true,"CRLF"))));
 BA.debugLineNum = 72;BA.debugLine="Do While Sale=False";
Debug.ShouldStop(128);
while (RemoteObject.solveBoolean("=",principal._sale,principal.mostCurrent.__c.getField(true,"False"))) {
 BA.debugLineNum = 73;BA.debugLine="Try";
Debug.ShouldStop(256);
try { BA.debugLineNum = 74;BA.debugLine="Contador=Contador+1";
Debug.ShouldStop(512);
principal._contador = RemoteObject.solve(new RemoteObject[] {principal._contador,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 75;BA.debugLine="DetallesEventos.Text=DetallesEventos.Text&Grup";
Debug.ShouldStop(1024);
principal.mostCurrent._detalleseventos.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(principal.mostCurrent._detalleseventos.runMethod(true,"getText"),principal._grupos.getArrayElement(true,principal._contador),principal.mostCurrent.__c.getField(true,"CRLF"))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e42) {
			BA.rdebugUtils.runVoidMethod("setLastException",principal.processBA, e42.toString()); BA.debugLineNum = 77;BA.debugLine="Sale=True";
Debug.ShouldStop(4096);
principal._sale = principal.mostCurrent.__c.getField(true,"True");
 };
 }
;
 };
 BA.debugLineNum = 81;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("Activity_Pause (principal) ","principal",2,principal.mostCurrent.activityBA,principal.mostCurrent,87);
if (RapidSub.canDelegate("activity_pause")) { return com.ServicioSocial.principal.remoteMe.runUserSub(false, "principal","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 87;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 89;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("Activity_Resume (principal) ","principal",2,principal.mostCurrent.activityBA,principal.mostCurrent,83);
if (RapidSub.canDelegate("activity_resume")) { return com.ServicioSocial.principal.remoteMe.runUserSub(false, "principal","activity_resume");}
 BA.debugLineNum = 83;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(262144);
 BA.debugLineNum = 85;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
 //BA.debugLineNum = 27;BA.debugLine="Private DetallesEventos As Label";
principal.mostCurrent._detalleseventos = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private EventosPanel As Panel";
principal.mostCurrent._eventospanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private Eventos As Label";
principal.mostCurrent._eventos = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private PlusEvento As Button";
principal.mostCurrent._plusevento = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private Settings As Button";
principal.mostCurrent._settings = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _plusevento_click() throws Exception{
try {
		Debug.PushSubsStack("PlusEvento_Click (principal) ","principal",2,principal.mostCurrent.activityBA,principal.mostCurrent,92);
if (RapidSub.canDelegate("plusevento_click")) { return com.ServicioSocial.principal.remoteMe.runUserSub(false, "principal","plusevento_click");}
 BA.debugLineNum = 92;BA.debugLine="Sub PlusEvento_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 93;BA.debugLine="StartActivity(\"CrearEvento\")";
Debug.ShouldStop(268435456);
principal.mostCurrent.__c.runVoidMethod ("StartActivity",principal.processBA,(Object)((RemoteObject.createImmutable("CrearEvento"))));
 BA.debugLineNum = 94;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
 //BA.debugLineNum = 9;BA.debugLine="Dim contenido As String";
principal._contenido = RemoteObject.createImmutable("");
 //BA.debugLineNum = 10;BA.debugLine="Dim cantidades() As String";
principal._cantidades = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});
 //BA.debugLineNum = 11;BA.debugLine="Dim Sale As Boolean";
principal._sale = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 12;BA.debugLine="Dim Contador As Int";
principal._contador = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 13;BA.debugLine="Dim NombreEvento As String";
principal._nombreevento = RemoteObject.createImmutable("");
 //BA.debugLineNum = 14;BA.debugLine="Dim FechaEvento As String";
principal._fechaevento = RemoteObject.createImmutable("");
 //BA.debugLineNum = 15;BA.debugLine="Dim HoraEvento As String";
principal._horaevento = RemoteObject.createImmutable("");
 //BA.debugLineNum = 16;BA.debugLine="Dim NombreDocumento As String";
principal._nombredocumento = RemoteObject.createImmutable("");
 //BA.debugLineNum = 17;BA.debugLine="Dim Conferencista As String";
principal._conferencista = RemoteObject.createImmutable("");
 //BA.debugLineNum = 18;BA.debugLine="Dim TipoEvento As String";
principal._tipoevento = RemoteObject.createImmutable("");
 //BA.debugLineNum = 19;BA.debugLine="Dim Grupos() As String";
principal._grupos = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});
 //BA.debugLineNum = 20;BA.debugLine="Dim btm As Bitmap";
principal._btm = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _settings_click() throws Exception{
try {
		Debug.PushSubsStack("Settings_Click (principal) ","principal",2,principal.mostCurrent.activityBA,principal.mostCurrent,96);
if (RapidSub.canDelegate("settings_click")) { return com.ServicioSocial.principal.remoteMe.runUserSub(false, "principal","settings_click");}
 BA.debugLineNum = 96;BA.debugLine="Sub Settings_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 97;BA.debugLine="StartActivity(ConfHorarios)";
Debug.ShouldStop(1);
principal.mostCurrent.__c.runVoidMethod ("StartActivity",principal.processBA,(Object)((principal.mostCurrent._confhorarios.getObject())));
 BA.debugLineNum = 98;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}