package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class principal3_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (principal3) ","principal3",4,principal3.mostCurrent.activityBA,principal3.mostCurrent,32);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.principal3.remoteMe.runUserSub(false, "principal3","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 32;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 34;BA.debugLine="Activity.LoadLayout(\"PrincipalLayout\")";
Debug.ShouldStop(2);
principal3.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("PrincipalLayout")),principal3.mostCurrent.activityBA);
 BA.debugLineNum = 35;BA.debugLine="contenido=File.ReadString(File.DirAssets,\"Eventos";
Debug.ShouldStop(4);
principal3._contenido = principal3.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(principal3.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("Eventos.txt")));
 BA.debugLineNum = 36;BA.debugLine="If contenido=\"\" Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",principal3._contenido,BA.ObjectToString(""))) { 
 BA.debugLineNum = 37;BA.debugLine="Eventos.Visible=True";
Debug.ShouldStop(16);
principal3.mostCurrent._eventos.runMethod(true,"setVisible",principal3.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 38;BA.debugLine="EventosPanel.Visible=False";
Debug.ShouldStop(32);
principal3.mostCurrent._eventospanel.runMethod(true,"setVisible",principal3.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 40;BA.debugLine="Eventos.Visible=False";
Debug.ShouldStop(128);
principal3.mostCurrent._eventos.runMethod(true,"setVisible",principal3.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 41;BA.debugLine="EventosPanel.Visible=True";
Debug.ShouldStop(256);
principal3.mostCurrent._eventospanel.runMethod(true,"setVisible",principal3.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 42;BA.debugLine="cantidades=Regex.Split(\"-\", contenido)";
Debug.ShouldStop(512);
principal3._cantidades = principal3.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString("-")),(Object)(principal3._contenido));
 BA.debugLineNum = 43;BA.debugLine="Sale=False";
Debug.ShouldStop(1024);
principal3._sale = principal3.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 44;BA.debugLine="Contador=-1";
Debug.ShouldStop(2048);
principal3._contador = BA.numberCast(int.class, -(double) (0 + 1));
 BA.debugLineNum = 45;BA.debugLine="Do While Sale=False";
Debug.ShouldStop(4096);
while (RemoteObject.solveBoolean("=",principal3._sale,principal3.mostCurrent.__c.getField(true,"False"))) {
 BA.debugLineNum = 46;BA.debugLine="Contador=Contador+1";
Debug.ShouldStop(8192);
principal3._contador = RemoteObject.solve(new RemoteObject[] {principal3._contador,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 47;BA.debugLine="Select Contador";
Debug.ShouldStop(16384);
switch (BA.switchObjectToInt(principal3._contador,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5),BA.numberCast(int.class, 6))) {
case 0: {
 BA.debugLineNum = 49;BA.debugLine="NombreEvento=cantidades(Contador)";
Debug.ShouldStop(65536);
principal3._nombreevento = principal3._cantidades.getArrayElement(true,principal3._contador);
 break; }
case 1: {
 BA.debugLineNum = 51;BA.debugLine="FechaEvento=cantidades(Contador)";
Debug.ShouldStop(262144);
principal3._fechaevento = principal3._cantidades.getArrayElement(true,principal3._contador);
 break; }
case 2: {
 BA.debugLineNum = 53;BA.debugLine="HoraEvento=cantidades(Contador)";
Debug.ShouldStop(1048576);
principal3._horaevento = principal3._cantidades.getArrayElement(true,principal3._contador);
 break; }
case 3: {
 BA.debugLineNum = 55;BA.debugLine="TipoEvento=cantidades(Contador)";
Debug.ShouldStop(4194304);
principal3._tipoevento = principal3._cantidades.getArrayElement(true,principal3._contador);
 break; }
case 4: {
 BA.debugLineNum = 57;BA.debugLine="NombreDocumento=cantidades(Contador)";
Debug.ShouldStop(16777216);
principal3._nombredocumento = principal3._cantidades.getArrayElement(true,principal3._contador);
 break; }
case 5: {
 BA.debugLineNum = 59;BA.debugLine="Conferencista=cantidades(Contador)";
Debug.ShouldStop(67108864);
principal3._conferencista = principal3._cantidades.getArrayElement(true,principal3._contador);
 break; }
case 6: {
 BA.debugLineNum = 61;BA.debugLine="Grupos=Regex.Split(\";\",cantidades(Contador))";
Debug.ShouldStop(268435456);
principal3._grupos = principal3.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString(";")),(Object)(principal3._cantidades.getArrayElement(true,principal3._contador)));
 BA.debugLineNum = 62;BA.debugLine="Sale=True";
Debug.ShouldStop(536870912);
principal3._sale = principal3.mostCurrent.__c.getField(true,"True");
 break; }
}
;
 }
;
 BA.debugLineNum = 65;BA.debugLine="Sale=False";
Debug.ShouldStop(1);
principal3._sale = principal3.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 66;BA.debugLine="Contador=-1";
Debug.ShouldStop(2);
principal3._contador = BA.numberCast(int.class, -(double) (0 + 1));
 BA.debugLineNum = 67;BA.debugLine="DetallesEventos.Text=\"El evento \"&NombreEvento&\"";
Debug.ShouldStop(4);
principal3.mostCurrent._detalleseventos.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("El evento "),principal3._nombreevento,RemoteObject.createImmutable(" sera el dia "),principal3._fechaevento,RemoteObject.createImmutable(" a las "),principal3._horaevento,RemoteObject.createImmutable(" sera un evento de "),principal3._tipoevento,RemoteObject.createImmutable(" el documento es "),principal3._nombredocumento,RemoteObject.createImmutable(" el conferencista sera "),principal3._conferencista,RemoteObject.createImmutable(" y los grupos implicados seran "),principal3.mostCurrent.__c.getField(true,"CRLF"))));
 BA.debugLineNum = 68;BA.debugLine="Do While Sale=False";
Debug.ShouldStop(8);
while (RemoteObject.solveBoolean("=",principal3._sale,principal3.mostCurrent.__c.getField(true,"False"))) {
 BA.debugLineNum = 69;BA.debugLine="Try";
Debug.ShouldStop(16);
try { BA.debugLineNum = 70;BA.debugLine="Contador=Contador+1";
Debug.ShouldStop(32);
principal3._contador = RemoteObject.solve(new RemoteObject[] {principal3._contador,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 71;BA.debugLine="DetallesEventos.Text=DetallesEventos.Text&Grup";
Debug.ShouldStop(64);
principal3.mostCurrent._detalleseventos.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(principal3.mostCurrent._detalleseventos.runMethod(true,"getText"),principal3._grupos.getArrayElement(true,principal3._contador),principal3.mostCurrent.__c.getField(true,"CRLF"))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e40) {
			BA.rdebugUtils.runVoidMethod("setLastException",principal3.processBA, e40.toString()); BA.debugLineNum = 73;BA.debugLine="Sale=True";
Debug.ShouldStop(256);
principal3._sale = principal3.mostCurrent.__c.getField(true,"True");
 };
 }
;
 };
 BA.debugLineNum = 79;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("Activity_Pause (principal3) ","principal3",4,principal3.mostCurrent.activityBA,principal3.mostCurrent,85);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.principal3.remoteMe.runUserSub(false, "principal3","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 85;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 87;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("Activity_Resume (principal3) ","principal3",4,principal3.mostCurrent.activityBA,principal3.mostCurrent,81);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.principal3.remoteMe.runUserSub(false, "principal3","activity_resume");}
 BA.debugLineNum = 81;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(65536);
 BA.debugLineNum = 83;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 26;BA.debugLine="Private DetallesEventos As Label";
principal3.mostCurrent._detalleseventos = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private EventosPanel As Panel";
principal3.mostCurrent._eventospanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private Eventos As Label";
principal3.mostCurrent._eventos = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private PlusEvento As Button";
principal3.mostCurrent._plusevento = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim contenido As String";
principal3._contenido = RemoteObject.createImmutable("");
 //BA.debugLineNum = 10;BA.debugLine="Dim cantidades() As String";
principal3._cantidades = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});
 //BA.debugLineNum = 11;BA.debugLine="Dim Sale As Boolean";
principal3._sale = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 12;BA.debugLine="Dim Contador As Int";
principal3._contador = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 13;BA.debugLine="Dim NombreEvento As String";
principal3._nombreevento = RemoteObject.createImmutable("");
 //BA.debugLineNum = 14;BA.debugLine="Dim FechaEvento As String";
principal3._fechaevento = RemoteObject.createImmutable("");
 //BA.debugLineNum = 15;BA.debugLine="Dim HoraEvento As String";
principal3._horaevento = RemoteObject.createImmutable("");
 //BA.debugLineNum = 16;BA.debugLine="Dim NombreDocumento As String";
principal3._nombredocumento = RemoteObject.createImmutable("");
 //BA.debugLineNum = 17;BA.debugLine="Dim Conferencista As String";
principal3._conferencista = RemoteObject.createImmutable("");
 //BA.debugLineNum = 18;BA.debugLine="Dim TipoEvento As String";
principal3._tipoevento = RemoteObject.createImmutable("");
 //BA.debugLineNum = 19;BA.debugLine="Dim Grupos() As String";
principal3._grupos = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}