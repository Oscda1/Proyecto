package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class principal_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (principal) ","principal",2,principal.mostCurrent.activityBA,principal.mostCurrent,42);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.principal.remoteMe.runUserSub(false, "principal","activity_create", _firsttime);}
RemoteObject _grupos = null;
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 42;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(512);
 BA.debugLineNum = 44;BA.debugLine="Activity.LoadLayout(\"PrincipalLayout\")";
Debug.ShouldStop(2048);
principal.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("PrincipalLayout")),principal.mostCurrent.activityBA);
 BA.debugLineNum = 45;BA.debugLine="Contenido=File.ReadString(File.DirAssets,\"eventos";
Debug.ShouldStop(4096);
principal._contenido = principal.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(principal.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("eventos.txt")));
 BA.debugLineNum = 46;BA.debugLine="TotalCaracteres=False";
Debug.ShouldStop(8192);
principal._totalcaracteres = principal.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 47;BA.debugLine="CantidadCaracteres=0";
Debug.ShouldStop(16384);
principal._cantidadcaracteres = BA.numberCast(int.class, 0);
 BA.debugLineNum = 48;BA.debugLine="Contador1=-1";
Debug.ShouldStop(32768);
principal._contador1 = BA.numberCast(int.class, -(double) (0 + 1));
 BA.debugLineNum = 49;BA.debugLine="Contador2=0";
Debug.ShouldStop(65536);
principal._contador2 = BA.numberCast(int.class, 0);
 BA.debugLineNum = 50;BA.debugLine="Contador3=0";
Debug.ShouldStop(131072);
principal._contador3 = BA.numberCast(int.class, 0);
 BA.debugLineNum = 51;BA.debugLine="Contador4=-1";
Debug.ShouldStop(262144);
principal._contador4 = BA.numberCast(int.class, -(double) (0 + 1));
 BA.debugLineNum = 52;BA.debugLine="Seccion=0";
Debug.ShouldStop(524288);
principal._seccion = BA.numberCast(int.class, 0);
 BA.debugLineNum = 53;BA.debugLine="NombreEvento=\"\"";
Debug.ShouldStop(1048576);
principal._nombreevento = BA.ObjectToString("");
 BA.debugLineNum = 54;BA.debugLine="FechaEvento=\"\"";
Debug.ShouldStop(2097152);
principal._fechaevento = BA.ObjectToString("");
 BA.debugLineNum = 55;BA.debugLine="HoraEvento=\"\"";
Debug.ShouldStop(4194304);
principal._horaevento = BA.ObjectToString("");
 BA.debugLineNum = 56;BA.debugLine="TipoEvento=\"\"";
Debug.ShouldStop(8388608);
principal._tipoevento = BA.ObjectToString("");
 BA.debugLineNum = 57;BA.debugLine="NombreDelDocumento=\"\"";
Debug.ShouldStop(16777216);
principal._nombredeldocumento = BA.ObjectToString("");
 BA.debugLineNum = 58;BA.debugLine="Conferencista=\"\"";
Debug.ShouldStop(33554432);
principal._conferencista = BA.ObjectToString("");
 BA.debugLineNum = 59;BA.debugLine="DosPuntos=False";
Debug.ShouldStop(67108864);
principal._dospuntos = principal.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 60;BA.debugLine="TodosLosGrupos=False";
Debug.ShouldStop(134217728);
principal._todoslosgrupos = principal.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 61;BA.debugLine="If (Contenido<>\"\") Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("!",principal._contenido,RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 62;BA.debugLine="Existen=True";
Debug.ShouldStop(536870912);
principal._existen = principal.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 64;BA.debugLine="Existen=False";
Debug.ShouldStop(-2147483648);
principal._existen = principal.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 66;BA.debugLine="If Existen Then";
Debug.ShouldStop(2);
if (principal._existen.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 67;BA.debugLine="EventosPanel.Visible=True";
Debug.ShouldStop(4);
principal.mostCurrent._eventospanel.runMethod(true,"setVisible",principal.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 68;BA.debugLine="Eventos.Visible=False";
Debug.ShouldStop(8);
principal.mostCurrent._eventos.runMethod(true,"setVisible",principal.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 69;BA.debugLine="CargarEvento=False";
Debug.ShouldStop(16);
principal._cargarevento = principal.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 70;BA.debugLine="Do While(TotalCaracteres=False)";
Debug.ShouldStop(32);
while ((RemoteObject.solveBoolean("=",principal._totalcaracteres,principal.mostCurrent.__c.getField(true,"False")))) {
 BA.debugLineNum = 71;BA.debugLine="Temporal=Contenido.SubString(CantidadCaracteres";
Debug.ShouldStop(64);
principal._temporal = principal._contenido.runMethod(true,"substring",(Object)(principal._cantidadcaracteres));
 BA.debugLineNum = 72;BA.debugLine="If Temporal=\":\" Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",principal._temporal,BA.ObjectToString(":"))) { 
 BA.debugLineNum = 73;BA.debugLine="TotalCaracteres=True";
Debug.ShouldStop(256);
principal._totalcaracteres = principal.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 75;BA.debugLine="CantidadCaracteres=CantidadCaracteres+1";
Debug.ShouldStop(1024);
principal._cantidadcaracteres = RemoteObject.solve(new RemoteObject[] {principal._cantidadcaracteres,RemoteObject.createImmutable(1)}, "+",1, 1);
 };
 }
;
 BA.debugLineNum = 78;BA.debugLine="Do While(Contador1<>CantidadCaracteres)";
Debug.ShouldStop(8192);
while ((RemoteObject.solveBoolean("!",principal._contador1,BA.numberCast(double.class, principal._cantidadcaracteres)))) {
 BA.debugLineNum = 79;BA.debugLine="Contador1=Contador1+1";
Debug.ShouldStop(16384);
principal._contador1 = RemoteObject.solve(new RemoteObject[] {principal._contador1,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 80;BA.debugLine="Temporal=Contenido.SubString(Contador1)";
Debug.ShouldStop(32768);
principal._temporal = principal._contenido.runMethod(true,"substring",(Object)(principal._contador1));
 BA.debugLineNum = 81;BA.debugLine="Select Temporal";
Debug.ShouldStop(65536);
switch (BA.switchObjectToInt(principal._temporal,BA.ObjectToString("|"),BA.ObjectToString("<"))) {
case 0: {
 BA.debugLineNum = 83;BA.debugLine="Contador3=Contador3+1";
Debug.ShouldStop(262144);
principal._contador3 = RemoteObject.solve(new RemoteObject[] {principal._contador3,RemoteObject.createImmutable(1)}, "+",1, 1);
 break; }
case 1: {
 BA.debugLineNum = 86;BA.debugLine="NumeroDeInicio=Contador1+1";
Debug.ShouldStop(2097152);
principal._numerodeinicio = RemoteObject.solve(new RemoteObject[] {principal._contador1,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 87;BA.debugLine="Do While (DosPuntos=False)";
Debug.ShouldStop(4194304);
while ((RemoteObject.solveBoolean("=",principal._dospuntos,principal.mostCurrent.__c.getField(true,"False")))) {
 BA.debugLineNum = 88;BA.debugLine="Contador1=Contador1+1";
Debug.ShouldStop(8388608);
principal._contador1 = RemoteObject.solve(new RemoteObject[] {principal._contador1,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 89;BA.debugLine="PuntoYComa=Contenido.SubString(Contador1)";
Debug.ShouldStop(16777216);
principal._puntoycoma = principal._contenido.runMethod(true,"substring",(Object)(principal._contador1));
 BA.debugLineNum = 90;BA.debugLine="Select (PuntoYComa)";
Debug.ShouldStop(33554432);
switch (BA.switchObjectToInt((principal._puntoycoma),BA.ObjectToString(":"),BA.ObjectToString(";"))) {
case 0: {
 BA.debugLineNum = 92;BA.debugLine="DosPuntos=True";
Debug.ShouldStop(134217728);
principal._dospuntos = principal.mostCurrent.__c.getField(true,"True");
 break; }
case 1: {
 BA.debugLineNum = 95;BA.debugLine="CantidadGrupos=CantidadGrupos+1";
Debug.ShouldStop(1073741824);
principal._cantidadgrupos = RemoteObject.solve(new RemoteObject[] {principal._cantidadgrupos,RemoteObject.createImmutable(1)}, "+",1, 1);
 break; }
}
;
 BA.debugLineNum = 98;BA.debugLine="Dim Grupos(CantidadGrupos) As String";
Debug.ShouldStop(2);
_grupos = RemoteObject.createNewArray ("String", new int[] {principal._cantidadgrupos.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("Grupos", _grupos);
 BA.debugLineNum = 99;BA.debugLine="PuntoYComa=False";
Debug.ShouldStop(4);
principal._puntoycoma = BA.ObjectToString(principal.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 100;BA.debugLine="Contador2=NumeroDeInicio";
Debug.ShouldStop(8);
principal._contador2 = principal._numerodeinicio;
 BA.debugLineNum = 101;BA.debugLine="DosPuntos=False";
Debug.ShouldStop(16);
principal._dospuntos = principal.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 102;BA.debugLine="Do While (DosPuntos=False)";
Debug.ShouldStop(32);
while ((RemoteObject.solveBoolean("=",principal._dospuntos,principal.mostCurrent.__c.getField(true,"False")))) {
 BA.debugLineNum = 103;BA.debugLine="PuntoYComa=Contenido.SubString(Contador1)";
Debug.ShouldStop(64);
principal._puntoycoma = principal._contenido.runMethod(true,"substring",(Object)(principal._contador1));
 BA.debugLineNum = 104;BA.debugLine="Select (PuntoYComa)";
Debug.ShouldStop(128);
switch (BA.switchObjectToInt((principal._puntoycoma),BA.ObjectToString(":"),BA.ObjectToString(";"))) {
case 0: {
 BA.debugLineNum = 106;BA.debugLine="DosPuntos=True";
Debug.ShouldStop(512);
principal._dospuntos = principal.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 107;BA.debugLine="CargarEvento=True";
Debug.ShouldStop(1024);
principal._cargarevento = principal.mostCurrent.__c.getField(true,"True");
 break; }
case 1: {
 BA.debugLineNum = 110;BA.debugLine="Contador2=Contador2+1";
Debug.ShouldStop(8192);
principal._contador2 = RemoteObject.solve(new RemoteObject[] {principal._contador2,RemoteObject.createImmutable(1)}, "+",1, 1);
 break; }
default: {
 BA.debugLineNum = 113;BA.debugLine="Grupos(Contador2)=Grupos(Contador2)+Punto";
Debug.ShouldStop(65536);
_grupos.setArrayElement (BA.NumberToString(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, _grupos.getArrayElement(true,principal._contador2)),BA.numberCast(double.class, principal._puntoycoma)}, "+",1, 0)),principal._contador2);
 break; }
}
;
 }
;
 }
;
 break; }
default: {
 BA.debugLineNum = 118;BA.debugLine="Select Seccion";
Debug.ShouldStop(2097152);
switch (BA.switchObjectToInt(principal._seccion,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5))) {
case 0: {
 BA.debugLineNum = 120;BA.debugLine="NombreEvento=NombreEvento&Temporal";
Debug.ShouldStop(8388608);
principal._nombreevento = RemoteObject.concat(principal._nombreevento,principal._temporal);
 break; }
case 1: {
 BA.debugLineNum = 123;BA.debugLine="FechaEvento=FechaEvento&Temporal";
Debug.ShouldStop(67108864);
principal._fechaevento = RemoteObject.concat(principal._fechaevento,principal._temporal);
 break; }
case 2: {
 BA.debugLineNum = 126;BA.debugLine="HoraEvento=HoraEvento&Temporal";
Debug.ShouldStop(536870912);
principal._horaevento = RemoteObject.concat(principal._horaevento,principal._temporal);
 break; }
case 3: {
 BA.debugLineNum = 129;BA.debugLine="TipoEvento=TipoEvento&Temporal";
Debug.ShouldStop(1);
principal._tipoevento = RemoteObject.concat(principal._tipoevento,principal._temporal);
 break; }
case 4: {
 BA.debugLineNum = 132;BA.debugLine="NombreDelDocumento=NombreDelDocumento&Tempo";
Debug.ShouldStop(8);
principal._nombredeldocumento = RemoteObject.concat(principal._nombredeldocumento,principal._temporal);
 break; }
case 5: {
 BA.debugLineNum = 135;BA.debugLine="Conferencista=Conferencista&Temporal";
Debug.ShouldStop(64);
principal._conferencista = RemoteObject.concat(principal._conferencista,principal._temporal);
 break; }
}
;
 break; }
}
;
 }
;
 BA.debugLineNum = 140;BA.debugLine="DetallesEventos.Text=\"Nombre: \"&NombreEvento & C";
Debug.ShouldStop(2048);
principal.mostCurrent._detalleseventos.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Nombre: "),principal._nombreevento,principal.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Fecha: "),principal._fechaevento,principal.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Hora: "),principal._horaevento,principal.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Evento: "),principal._tipoevento,principal.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Conferencista: "),principal._conferencista,RemoteObject.createImmutable("Grupos: "))));
 BA.debugLineNum = 141;BA.debugLine="Do While (TodosLosGrupos)";
Debug.ShouldStop(4096);
while ((principal._todoslosgrupos).<Boolean>get().booleanValue()) {
 BA.debugLineNum = 142;BA.debugLine="Contador4=Contador4+1";
Debug.ShouldStop(8192);
principal._contador4 = RemoteObject.solve(new RemoteObject[] {principal._contador4,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 143;BA.debugLine="DetallesEventos.Text=DetallesEventos.Text&Grupo";
Debug.ShouldStop(16384);
principal.mostCurrent._detalleseventos.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(principal.mostCurrent._detalleseventos.runMethod(true,"getText"),_grupos.getArrayElement(true,principal._contador4))));
 BA.debugLineNum = 144;BA.debugLine="If (Contador4=CantidadGrupos) Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("=",principal._contador4,BA.numberCast(double.class, principal._cantidadgrupos)))) { 
 BA.debugLineNum = 145;BA.debugLine="TodosLosGrupos=True";
Debug.ShouldStop(65536);
principal._todoslosgrupos = principal.mostCurrent.__c.getField(true,"True");
 };
 }
;
 }else {
 BA.debugLineNum = 149;BA.debugLine="Eventos.Visible=True";
Debug.ShouldStop(1048576);
principal.mostCurrent._eventos.runMethod(true,"setVisible",principal.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 151;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("Activity_Pause (principal) ","principal",2,principal.mostCurrent.activityBA,principal.mostCurrent,157);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.principal.remoteMe.runUserSub(false, "principal","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 157;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 159;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("Activity_Resume (principal) ","principal",2,principal.mostCurrent.activityBA,principal.mostCurrent,153);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.principal.remoteMe.runUserSub(false, "principal","activity_resume");}
 BA.debugLineNum = 153;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 155;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 33;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 36;BA.debugLine="Private Eventos As Label";
principal.mostCurrent._eventos = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private PlusEvento As Button";
principal.mostCurrent._plusevento = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private DetallesEventos As Label";
principal.mostCurrent._detalleseventos = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private EventosPanel As Panel";
principal.mostCurrent._eventospanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _plusevento_click() throws Exception{
try {
		Debug.PushSubsStack("PlusEvento_Click (principal) ","principal",2,principal.mostCurrent.activityBA,principal.mostCurrent,162);
if (RapidSub.canDelegate("plusevento_click")) { return b4a.example.principal.remoteMe.runUserSub(false, "principal","plusevento_click");}
 BA.debugLineNum = 162;BA.debugLine="Sub PlusEvento_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 164;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
 //BA.debugLineNum = 11;BA.debugLine="Dim Contador1 As Int";
principal._contador1 = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 12;BA.debugLine="Dim Contador2 As Int";
principal._contador2 = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 13;BA.debugLine="Dim CargarEvento As Boolean";
principal._cargarevento = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 14;BA.debugLine="Dim TodosLosGrupos As Boolean";
principal._todoslosgrupos = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 15;BA.debugLine="Dim Temporal As String";
principal._temporal = RemoteObject.createImmutable("");
 //BA.debugLineNum = 16;BA.debugLine="Dim Contador3 As Int";
principal._contador3 = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 17;BA.debugLine="Dim CantidadGrupos As Int";
principal._cantidadgrupos = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 18;BA.debugLine="Dim DosPuntos As Boolean";
principal._dospuntos = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 19;BA.debugLine="Dim PuntoYComa As String";
principal._puntoycoma = RemoteObject.createImmutable("");
 //BA.debugLineNum = 20;BA.debugLine="Dim NumeroDeInicio As Int";
principal._numerodeinicio = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 21;BA.debugLine="Dim Seccion As Int";
principal._seccion = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 22;BA.debugLine="Dim NombreEvento As String";
principal._nombreevento = RemoteObject.createImmutable("");
 //BA.debugLineNum = 23;BA.debugLine="Dim FechaEvento As String";
principal._fechaevento = RemoteObject.createImmutable("");
 //BA.debugLineNum = 24;BA.debugLine="Dim HoraEvento As String";
principal._horaevento = RemoteObject.createImmutable("");
 //BA.debugLineNum = 25;BA.debugLine="Dim TipoEvento As String";
principal._tipoevento = RemoteObject.createImmutable("");
 //BA.debugLineNum = 26;BA.debugLine="Dim NombreDelDocumento As String";
principal._nombredeldocumento = RemoteObject.createImmutable("");
 //BA.debugLineNum = 27;BA.debugLine="Dim Conferencista As String";
principal._conferencista = RemoteObject.createImmutable("");
 //BA.debugLineNum = 28;BA.debugLine="Dim Contador4 As Int";
principal._contador4 = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 29;BA.debugLine="Dim TotalCaracteres As Boolean";
principal._totalcaracteres = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 30;BA.debugLine="Dim CantidadCaracteres As Int";
principal._cantidadcaracteres = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}