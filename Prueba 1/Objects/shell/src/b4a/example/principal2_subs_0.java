package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class principal2_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (principal2) ","principal2",3,principal2.mostCurrent.activityBA,principal2.mostCurrent,37);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.principal2.remoteMe.runUserSub(false, "principal2","activity_create", _firsttime);}
RemoteObject _grupos = null;
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 37;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16);
 BA.debugLineNum = 39;BA.debugLine="Activity.LoadLayout(\"PrincipalLayout\")";
Debug.ShouldStop(64);
principal2.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("PrincipalLayout")),principal2.mostCurrent.activityBA);
 BA.debugLineNum = 40;BA.debugLine="DespliegaGrupos=0";
Debug.ShouldStop(128);
principal2._despliegagrupos = BA.numberCast(int.class, 0);
 BA.debugLineNum = 41;BA.debugLine="SeccionGrupo=0";
Debug.ShouldStop(256);
principal2._secciongrupo = BA.numberCast(int.class, 0);
 BA.debugLineNum = 42;BA.debugLine="CantidadGrupos=0";
Debug.ShouldStop(512);
principal2._cantidadgrupos = BA.numberCast(int.class, 0);
 BA.debugLineNum = 43;BA.debugLine="Seccion=0";
Debug.ShouldStop(1024);
principal2._seccion = BA.numberCast(int.class, 0);
 BA.debugLineNum = 44;BA.debugLine="LetraTemporal=\"\"";
Debug.ShouldStop(2048);
principal2._letratemporal = BA.ObjectToString("");
 BA.debugLineNum = 45;BA.debugLine="ContadorCaracter=-1";
Debug.ShouldStop(4096);
principal2._contadorcaracter = BA.numberCast(int.class, -(double) (0 + 1));
 BA.debugLineNum = 46;BA.debugLine="DosPuntos=False";
Debug.ShouldStop(8192);
principal2._dospuntos = principal2.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 47;BA.debugLine="NombreEvento=\"\"";
Debug.ShouldStop(16384);
principal2._nombreevento = BA.ObjectToString("");
 BA.debugLineNum = 48;BA.debugLine="FechaEvento=\"\"";
Debug.ShouldStop(32768);
principal2._fechaevento = BA.ObjectToString("");
 BA.debugLineNum = 49;BA.debugLine="HoraEvento=\"\"";
Debug.ShouldStop(65536);
principal2._horaevento = BA.ObjectToString("");
 BA.debugLineNum = 50;BA.debugLine="NombreDocumento=\"\"";
Debug.ShouldStop(131072);
principal2._nombredocumento = BA.ObjectToString("");
 BA.debugLineNum = 51;BA.debugLine="Conferencista=\"\"";
Debug.ShouldStop(262144);
principal2._conferencista = BA.ObjectToString("");
 BA.debugLineNum = 52;BA.debugLine="TipoEvento=\"\"";
Debug.ShouldStop(524288);
principal2._tipoevento = BA.ObjectToString("");
 BA.debugLineNum = 53;BA.debugLine="InicioGrupos=0";
Debug.ShouldStop(1048576);
principal2._iniciogrupos = BA.numberCast(int.class, 0);
 BA.debugLineNum = 54;BA.debugLine="PrimeraVezEnGrupos=True";
Debug.ShouldStop(2097152);
principal2._primeravezengrupos = principal2.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 55;BA.debugLine="Contenido=File.ReadString(File.DirAssets,\"eventos";
Debug.ShouldStop(4194304);
principal2._contenido = principal2.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(principal2.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("eventos.txt")));
 BA.debugLineNum = 56;BA.debugLine="If (Contenido<>\"\") Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("!",principal2._contenido,RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 57;BA.debugLine="EventosPanel.Visible=True";
Debug.ShouldStop(16777216);
principal2.mostCurrent._eventospanel.runMethod(true,"setVisible",principal2.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 58;BA.debugLine="Eventos.Visible=False";
Debug.ShouldStop(33554432);
principal2.mostCurrent._eventos.runMethod(true,"setVisible",principal2.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 59;BA.debugLine="Do While (DosPuntos=False)";
Debug.ShouldStop(67108864);
while ((RemoteObject.solveBoolean("=",principal2._dospuntos,principal2.mostCurrent.__c.getField(true,"False")))) {
 BA.debugLineNum = 60;BA.debugLine="ContadorCaracter=ContadorCaracter+1";
Debug.ShouldStop(134217728);
principal2._contadorcaracter = RemoteObject.solve(new RemoteObject[] {principal2._contadorcaracter,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 61;BA.debugLine="LetraTemporal=Contenido.SubString(ContadorCaract";
Debug.ShouldStop(268435456);
principal2._letratemporal = principal2._contenido.runMethod(true,"substring",(Object)(principal2._contadorcaracter));
 BA.debugLineNum = 62;BA.debugLine="Select (LetraTemporal)";
Debug.ShouldStop(536870912);
switch (BA.switchObjectToInt((principal2._letratemporal),BA.ObjectToString("-"),BA.ObjectToString(":"))) {
case 0: {
 BA.debugLineNum = 64;BA.debugLine="Seccion=Seccion+1";
Debug.ShouldStop(-2147483648);
principal2._seccion = RemoteObject.solve(new RemoteObject[] {principal2._seccion,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 65;BA.debugLine="Log(Seccion)";
Debug.ShouldStop(1);
principal2.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.NumberToString(principal2._seccion)));
 BA.debugLineNum = 66;BA.debugLine="Exit";
Debug.ShouldStop(2);
if (true) break;
 break; }
case 1: {
 BA.debugLineNum = 68;BA.debugLine="DosPuntos=True";
Debug.ShouldStop(8);
principal2._dospuntos = principal2.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 69;BA.debugLine="Exit";
Debug.ShouldStop(16);
if (true) break;
 break; }
default: {
 BA.debugLineNum = 71;BA.debugLine="Select (Seccion)";
Debug.ShouldStop(64);
switch (BA.switchObjectToInt((principal2._seccion),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5),BA.numberCast(int.class, 6))) {
case 0: {
 BA.debugLineNum = 73;BA.debugLine="NombreEvento=NombreEvento&LetraTemporal";
Debug.ShouldStop(256);
principal2._nombreevento = RemoteObject.concat(principal2._nombreevento,principal2._letratemporal);
 BA.debugLineNum = 74;BA.debugLine="Exit";
Debug.ShouldStop(512);
if (true) break;
 break; }
case 1: {
 BA.debugLineNum = 76;BA.debugLine="FechaEvento=FechaEvento&LetraTemporal";
Debug.ShouldStop(2048);
principal2._fechaevento = RemoteObject.concat(principal2._fechaevento,principal2._letratemporal);
 BA.debugLineNum = 77;BA.debugLine="Exit";
Debug.ShouldStop(4096);
if (true) break;
 break; }
case 2: {
 BA.debugLineNum = 79;BA.debugLine="HoraEvento=HoraEvento&LetraTemporal";
Debug.ShouldStop(16384);
principal2._horaevento = RemoteObject.concat(principal2._horaevento,principal2._letratemporal);
 BA.debugLineNum = 80;BA.debugLine="Exit";
Debug.ShouldStop(32768);
if (true) break;
 break; }
case 3: {
 BA.debugLineNum = 82;BA.debugLine="TipoEvento=TipoEvento&LetraTemporal";
Debug.ShouldStop(131072);
principal2._tipoevento = RemoteObject.concat(principal2._tipoevento,principal2._letratemporal);
 BA.debugLineNum = 83;BA.debugLine="Exit";
Debug.ShouldStop(262144);
if (true) break;
 break; }
case 4: {
 BA.debugLineNum = 85;BA.debugLine="NombreDocumento=NombreDocumento&LetraTempora";
Debug.ShouldStop(1048576);
principal2._nombredocumento = RemoteObject.concat(principal2._nombredocumento,principal2._letratemporal);
 BA.debugLineNum = 86;BA.debugLine="Exit";
Debug.ShouldStop(2097152);
if (true) break;
 break; }
case 5: {
 BA.debugLineNum = 88;BA.debugLine="Conferencista=Conferencista&LetraTemporal";
Debug.ShouldStop(8388608);
principal2._conferencista = RemoteObject.concat(principal2._conferencista,principal2._letratemporal);
 BA.debugLineNum = 89;BA.debugLine="Exit";
Debug.ShouldStop(16777216);
if (true) break;
 break; }
case 6: {
 BA.debugLineNum = 91;BA.debugLine="If (PrimeraVezEnGrupos) Then";
Debug.ShouldStop(67108864);
if ((principal2._primeravezengrupos).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 92;BA.debugLine="InicioGrupos=ContadorCaracter";
Debug.ShouldStop(134217728);
principal2._iniciogrupos = principal2._contadorcaracter;
 BA.debugLineNum = 93;BA.debugLine="Do While(PrimeraVezEnGrupos=True)";
Debug.ShouldStop(268435456);
while ((RemoteObject.solveBoolean("=",principal2._primeravezengrupos,principal2.mostCurrent.__c.getField(true,"True")))) {
 BA.debugLineNum = 94;BA.debugLine="InicioGrupos=InicioGrupos+1";
Debug.ShouldStop(536870912);
principal2._iniciogrupos = RemoteObject.solve(new RemoteObject[] {principal2._iniciogrupos,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 95;BA.debugLine="LetraTemporal=Contenido.SubString(InicioGr";
Debug.ShouldStop(1073741824);
principal2._letratemporal = principal2._contenido.runMethod(true,"substring",(Object)(principal2._iniciogrupos));
 BA.debugLineNum = 96;BA.debugLine="If (LetraTemporal=\";\") Then";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean("=",principal2._letratemporal,RemoteObject.createImmutable(";")))) { 
 BA.debugLineNum = 97;BA.debugLine="CantidadGrupos=CantidadGrupos+1";
Debug.ShouldStop(1);
principal2._cantidadgrupos = RemoteObject.solve(new RemoteObject[] {principal2._cantidadgrupos,RemoteObject.createImmutable(1)}, "+",1, 1);
 }else 
{ BA.debugLineNum = 98;BA.debugLine="Else If (LetraTemporal=\":\") Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",principal2._letratemporal,RemoteObject.createImmutable(":")))) { 
 BA.debugLineNum = 99;BA.debugLine="PrimeraVezEnGrupos=False";
Debug.ShouldStop(4);
principal2._primeravezengrupos = principal2.mostCurrent.__c.getField(true,"False");
 }}
;
 }
;
 BA.debugLineNum = 102;BA.debugLine="Dim Grupos(CantidadGrupos) As String";
Debug.ShouldStop(32);
_grupos = RemoteObject.createNewArray ("String", new int[] {principal2._cantidadgrupos.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("Grupos", _grupos);
 }else {
 BA.debugLineNum = 104;BA.debugLine="If (LetraTemporal<>\";\") Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("!",principal2._letratemporal,RemoteObject.createImmutable(";")))) { 
 BA.debugLineNum = 105;BA.debugLine="Grupos(SeccionGrupo)=LetraTemporal";
Debug.ShouldStop(256);
_grupos.setArrayElement (principal2._letratemporal,principal2._secciongrupo);
 }else {
 BA.debugLineNum = 107;BA.debugLine="SeccionGrupo=SeccionGrupo+1";
Debug.ShouldStop(1024);
principal2._secciongrupo = RemoteObject.solve(new RemoteObject[] {principal2._secciongrupo,RemoteObject.createImmutable(1)}, "+",1, 1);
 };
 };
 BA.debugLineNum = 110;BA.debugLine="Exit";
Debug.ShouldStop(8192);
if (true) break;
 break; }
}
;
 BA.debugLineNum = 112;BA.debugLine="Exit";
Debug.ShouldStop(32768);
if (true) break;
 break; }
}
;
 }
;
 BA.debugLineNum = 115;BA.debugLine="DetallesEventos.Text=NombreEvento&CRLF&FechaEven";
Debug.ShouldStop(262144);
principal2.mostCurrent._detalleseventos.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(principal2._nombreevento,principal2.mostCurrent.__c.getField(true,"CRLF"),principal2._fechaevento,principal2.mostCurrent.__c.getField(true,"CRLF"),principal2._horaevento,principal2.mostCurrent.__c.getField(true,"CRLF"),principal2._tipoevento,principal2.mostCurrent.__c.getField(true,"CRLF"),principal2._nombredocumento,principal2.mostCurrent.__c.getField(true,"CRLF"),principal2._conferencista,principal2.mostCurrent.__c.getField(true,"CRLF"))));
 BA.debugLineNum = 116;BA.debugLine="Do While(DespliegaGrupos<>CantidadGrupos)";
Debug.ShouldStop(524288);
while ((RemoteObject.solveBoolean("!",principal2._despliegagrupos,BA.numberCast(double.class, principal2._cantidadgrupos)))) {
 BA.debugLineNum = 117;BA.debugLine="DetallesEventos.Text=Eventos.Text&Grupos(Desplie";
Debug.ShouldStop(1048576);
principal2.mostCurrent._detalleseventos.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(principal2.mostCurrent._eventos.runMethod(true,"getText"),_grupos.getArrayElement(true,principal2._despliegagrupos))));
 BA.debugLineNum = 118;BA.debugLine="DespliegaGrupos=DespliegaGrupos+1";
Debug.ShouldStop(2097152);
principal2._despliegagrupos = RemoteObject.solve(new RemoteObject[] {principal2._despliegagrupos,RemoteObject.createImmutable(1)}, "+",1, 1);
 }
;
 }else {
 BA.debugLineNum = 121;BA.debugLine="Eventos.Visible=True";
Debug.ShouldStop(16777216);
principal2.mostCurrent._eventos.runMethod(true,"setVisible",principal2.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 122;BA.debugLine="EventosPanel.Visible=False";
Debug.ShouldStop(33554432);
principal2.mostCurrent._eventospanel.runMethod(true,"setVisible",principal2.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 124;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("Activity_Pause (principal2) ","principal2",3,principal2.mostCurrent.activityBA,principal2.mostCurrent,130);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.principal2.remoteMe.runUserSub(false, "principal2","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 130;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(2);
 BA.debugLineNum = 132;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("Activity_Resume (principal2) ","principal2",3,principal2.mostCurrent.activityBA,principal2.mostCurrent,126);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.principal2.remoteMe.runUserSub(false, "principal2","activity_resume");}
 BA.debugLineNum = 126;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 128;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 31;BA.debugLine="Private EventosPanel As Panel";
principal2.mostCurrent._eventospanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private DetallesEventos As Label";
principal2.mostCurrent._detalleseventos = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private Eventos As Label";
principal2.mostCurrent._eventos = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private PlusEvento As Button";
principal2.mostCurrent._plusevento = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 35;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim Contenido As String";
principal2._contenido = RemoteObject.createImmutable("");
 //BA.debugLineNum = 10;BA.debugLine="Dim DosPuntos As Boolean";
principal2._dospuntos = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 11;BA.debugLine="Dim ContadorCaracter As Int";
principal2._contadorcaracter = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 12;BA.debugLine="Dim LetraTemporal As String";
principal2._letratemporal = RemoteObject.createImmutable("");
 //BA.debugLineNum = 13;BA.debugLine="Dim Seccion As Int";
principal2._seccion = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 14;BA.debugLine="Dim NombreEvento As String";
principal2._nombreevento = RemoteObject.createImmutable("");
 //BA.debugLineNum = 15;BA.debugLine="Dim FechaEvento As String";
principal2._fechaevento = RemoteObject.createImmutable("");
 //BA.debugLineNum = 16;BA.debugLine="Dim HoraEvento As String";
principal2._horaevento = RemoteObject.createImmutable("");
 //BA.debugLineNum = 17;BA.debugLine="Dim NombreDocumento As String";
principal2._nombredocumento = RemoteObject.createImmutable("");
 //BA.debugLineNum = 18;BA.debugLine="Dim Conferencista As String";
principal2._conferencista = RemoteObject.createImmutable("");
 //BA.debugLineNum = 19;BA.debugLine="Dim TipoEvento As String";
principal2._tipoevento = RemoteObject.createImmutable("");
 //BA.debugLineNum = 20;BA.debugLine="Dim PrimeraVezEnGrupos As Boolean";
principal2._primeravezengrupos = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 21;BA.debugLine="Dim InicioGrupos As Int";
principal2._iniciogrupos = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 22;BA.debugLine="Dim CantidadGrupos As Int";
principal2._cantidadgrupos = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 23;BA.debugLine="Dim SeccionGrupo As Int";
principal2._secciongrupo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 24;BA.debugLine="Dim DespliegaGrupos As Int";
principal2._despliegagrupos = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}