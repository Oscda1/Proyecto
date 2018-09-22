package com.ServicioSocial;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class crearevento_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (crearevento) ","crearevento",3,crearevento.mostCurrent.activityBA,crearevento.mostCurrent,30);
if (RapidSub.canDelegate("activity_create")) { return com.ServicioSocial.crearevento.remoteMe.runUserSub(false, "crearevento","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 30;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 32;BA.debugLine="Activity.LoadLayout(\"NuevoEventoLayout\")";
Debug.ShouldStop(-2147483648);
crearevento.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("NuevoEventoLayout")),crearevento.mostCurrent.activityBA);
 BA.debugLineNum = 33;BA.debugLine="Bmp2=LoadBitmap(File.DirAssets,\"Boton_Fecha y hor";
Debug.ShouldStop(1);
crearevento._bmp2 = crearevento.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(crearevento.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("Boton_Fecha y hora.png")));
 BA.debugLineNum = 34;BA.debugLine="BarraTitulo.Bitmap=LoadBitmap(File.DirAssets,\"Bar";
Debug.ShouldStop(2);
crearevento.mostCurrent._barratitulo.runMethod(false,"setBitmap",(crearevento.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(crearevento.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("Barra_Texto_titulo.png"))).getObject()));
 BA.debugLineNum = 35;BA.debugLine="ImagenRegresar.Bitmap=LoadBitmap(File.DirAssets,\"";
Debug.ShouldStop(4);
crearevento.mostCurrent._imagenregresar.runMethod(false,"setBitmap",(crearevento.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(crearevento.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("Boton_retroceso.png"))).getObject()));
 BA.debugLineNum = 36;BA.debugLine="NombreEventoEditText.SetBackgroundImage(LoadBitma";
Debug.ShouldStop(8);
crearevento.mostCurrent._nombreeventoedittext.runVoidMethod ("SetBackgroundImage",(Object)((crearevento.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(crearevento.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("Barra_TextoNombre y Conferencista.png"))).getObject())));
 BA.debugLineNum = 37;BA.debugLine="Bmp.Initialize(File.DirAssets,\"Boton_fecha y hora";
Debug.ShouldStop(16);
crearevento._bmp.runVoidMethod ("Initialize",(Object)(crearevento.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("Boton_fecha y hora.png")));
 BA.debugLineNum = 38;BA.debugLine="PerfilesEvento.Add(\"Feria de la salud\")";
Debug.ShouldStop(32);
crearevento.mostCurrent._perfilesevento.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("Feria de la salud")));
 BA.debugLineNum = 39;BA.debugLine="PerfilesEvento.Add(\"Feria de universidades\")";
Debug.ShouldStop(64);
crearevento.mostCurrent._perfilesevento.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("Feria de universidades")));
 BA.debugLineNum = 40;BA.debugLine="PerfilesEvento.Add(\"Aniversario\")";
Debug.ShouldStop(128);
crearevento.mostCurrent._perfilesevento.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("Aniversario")));
 BA.debugLineNum = 41;BA.debugLine="PerfilesEvento.Add(\"Rendicion de cuentas\")";
Debug.ShouldStop(256);
crearevento.mostCurrent._perfilesevento.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("Rendicion de cuentas")));
 BA.debugLineNum = 42;BA.debugLine="PerfilesEvento.Add(\"Estadias\")";
Debug.ShouldStop(512);
crearevento.mostCurrent._perfilesevento.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("Estadias")));
 BA.debugLineNum = 43;BA.debugLine="PerfilesEvento.Add(\"Festival navideño\")";
Debug.ShouldStop(1024);
crearevento.mostCurrent._perfilesevento.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("Festival navideño")));
 BA.debugLineNum = 44;BA.debugLine="PerfilesEvento.Add(\"Conferencia\")";
Debug.ShouldStop(2048);
crearevento.mostCurrent._perfilesevento.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("Conferencia")));
 BA.debugLineNum = 45;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("Activity_Pause (crearevento) ","crearevento",3,crearevento.mostCurrent.activityBA,crearevento.mostCurrent,63);
if (RapidSub.canDelegate("activity_pause")) { return com.ServicioSocial.crearevento.remoteMe.runUserSub(false, "crearevento","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 63;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 65;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("Activity_Resume (crearevento) ","crearevento",3,crearevento.mostCurrent.activityBA,crearevento.mostCurrent,59);
if (RapidSub.canDelegate("activity_resume")) { return com.ServicioSocial.crearevento.remoteMe.runUserSub(false, "crearevento","activity_resume");}
 BA.debugLineNum = 59;BA.debugLine="Sub Activity_Resume";
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
public static RemoteObject  _botongrupos_click() throws Exception{
try {
		Debug.PushSubsStack("BotonGrupos_Click (crearevento) ","crearevento",3,crearevento.mostCurrent.activityBA,crearevento.mostCurrent,95);
if (RapidSub.canDelegate("botongrupos_click")) { return com.ServicioSocial.crearevento.remoteMe.runUserSub(false, "crearevento","botongrupos_click");}
 BA.debugLineNum = 95;BA.debugLine="Sub BotonGrupos_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 96;BA.debugLine="StartActivity(SeleccionarGrupos)";
Debug.ShouldStop(-2147483648);
crearevento.mostCurrent.__c.runVoidMethod ("StartActivity",crearevento.processBA,(Object)((crearevento.mostCurrent._seleccionargrupos.getObject())));
 BA.debugLineNum = 97;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btndate_click() throws Exception{
try {
		Debug.PushSubsStack("btnDate_Click (crearevento) ","crearevento",3,crearevento.mostCurrent.activityBA,crearevento.mostCurrent,68);
if (RapidSub.canDelegate("btndate_click")) { return com.ServicioSocial.crearevento.remoteMe.runUserSub(false, "crearevento","btndate_click");}
RemoteObject _ret = RemoteObject.createImmutable("");
RemoteObject _dd = RemoteObject.declareNull("anywheresoftware.b4a.agraham.dialogs.InputDialog.DateDialog");
 BA.debugLineNum = 68;BA.debugLine="Sub btnDate_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 69;BA.debugLine="Dim ret As String";
Debug.ShouldStop(16);
_ret = RemoteObject.createImmutable("");Debug.locals.put("ret", _ret);
 BA.debugLineNum = 70;BA.debugLine="Dim Dd As DateDialog";
Debug.ShouldStop(32);
_dd = RemoteObject.createNew ("anywheresoftware.b4a.agraham.dialogs.InputDialog.DateDialog");Debug.locals.put("Dd", _dd);
 BA.debugLineNum = 71;BA.debugLine="Dd.Year = DateTime.GetYear(DateTime.Now)";
Debug.ShouldStop(64);
_dd.runMethod(true,"setYear",crearevento.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetYear",(Object)(crearevento.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))));
 BA.debugLineNum = 72;BA.debugLine="Dd.Month = DateTime.GetMonth(DateTime.Now)";
Debug.ShouldStop(128);
_dd.runMethod(true,"setMonth",crearevento.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMonth",(Object)(crearevento.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))));
 BA.debugLineNum = 73;BA.debugLine="Dd.DayOfMonth = DateTime.GetDayOfMonth(DateTime.N";
Debug.ShouldStop(256);
_dd.runMethod(true,"setDayOfMonth",crearevento.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfMonth",(Object)(crearevento.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))));
 BA.debugLineNum = 74;BA.debugLine="ret = Dd.Show(\"Seleccione una Fecha\", \"SaveItGood";
Debug.ShouldStop(512);
_ret = BA.NumberToString(_dd.runMethodAndSync(true,"Show",(Object)(BA.ObjectToString("Seleccione una Fecha")),(Object)(BA.ObjectToString("SaveItGood")),(Object)(BA.ObjectToString("Seleccionar")),(Object)(BA.ObjectToString("Cancelar")),(Object)(BA.ObjectToString("")),crearevento.mostCurrent.activityBA,(Object)((crearevento.mostCurrent.__c.getField(false,"Null")))));Debug.locals.put("ret", _ret);
 BA.debugLineNum = 75;BA.debugLine="ToastMessageShow(ret & \" : \" & Dd.DayOfMonth & \"/";
Debug.ShouldStop(1024);
crearevento.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(_ret,RemoteObject.createImmutable(" : "),_dd.runMethod(true,"getDayOfMonth"),RemoteObject.createImmutable("/"),_dd.runMethod(true,"getMonth"),RemoteObject.createImmutable("/"),_dd.runMethod(true,"getYear")))),(Object)(crearevento.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 76;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btntime_click() throws Exception{
try {
		Debug.PushSubsStack("btnTime_Click (crearevento) ","crearevento",3,crearevento.mostCurrent.activityBA,crearevento.mostCurrent,47);
if (RapidSub.canDelegate("btntime_click")) { return com.ServicioSocial.crearevento.remoteMe.runUserSub(false, "crearevento","btntime_click");}
RemoteObject _ret = RemoteObject.createImmutable("");
RemoteObject _td = RemoteObject.declareNull("anywheresoftware.b4a.agraham.dialogs.InputDialog.TimeDialog");
RemoteObject _txt = RemoteObject.createImmutable("");
 BA.debugLineNum = 47;BA.debugLine="Sub btnTime_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 48;BA.debugLine="Dim ret As String";
Debug.ShouldStop(32768);
_ret = RemoteObject.createImmutable("");Debug.locals.put("ret", _ret);
 BA.debugLineNum = 49;BA.debugLine="Dim td As TimeDialog";
Debug.ShouldStop(65536);
_td = RemoteObject.createNew ("anywheresoftware.b4a.agraham.dialogs.InputDialog.TimeDialog");Debug.locals.put("td", _td);
 BA.debugLineNum = 50;BA.debugLine="Dim txt As String";
Debug.ShouldStop(131072);
_txt = RemoteObject.createImmutable("");Debug.locals.put("txt", _txt);
 BA.debugLineNum = 51;BA.debugLine="td.Hour = DateTime.GetHour(DateTime.Now)";
Debug.ShouldStop(262144);
_td.runMethod(true,"setHour",crearevento.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetHour",(Object)(crearevento.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))));
 BA.debugLineNum = 52;BA.debugLine="td.Minute = DateTime.GetMinute(DateTime.Now)";
Debug.ShouldStop(524288);
_td.runMethod(true,"setMinute",crearevento.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMinute",(Object)(crearevento.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))));
 BA.debugLineNum = 53;BA.debugLine="td.Is24Hours = True";
Debug.ShouldStop(1048576);
_td.runMethod(true,"setIs24Hours",crearevento.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 54;BA.debugLine="ret = td.Show(\"Seleccione la hora:\", \"SaveItGood\"";
Debug.ShouldStop(2097152);
_ret = BA.NumberToString(_td.runMethodAndSync(true,"Show",(Object)(BA.ObjectToString("Seleccione la hora:")),(Object)(BA.ObjectToString("SaveItGood")),(Object)(BA.ObjectToString("Si")),(Object)(BA.ObjectToString("Cancelar")),(Object)(BA.ObjectToString("")),crearevento.mostCurrent.activityBA,(Object)((crearevento._bmp.getObject()))));Debug.locals.put("ret", _ret);
 BA.debugLineNum = 55;BA.debugLine="ToastMessageShow(ret & \" : \" & td.Hour & \":\" & td";
Debug.ShouldStop(4194304);
crearevento.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(_ret,RemoteObject.createImmutable(" : "),_td.runMethod(true,"getHour"),RemoteObject.createImmutable(":"),_td.runMethod(true,"getMinute")))),(Object)(crearevento.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 56;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
 //BA.debugLineNum = 16;BA.debugLine="Private BarraTitulo As ImageView";
crearevento.mostCurrent._barratitulo = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private ImagenRegresar As ImageView";
crearevento.mostCurrent._imagenregresar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private NombreEventoEditText As FloatLabeledEditT";
crearevento.mostCurrent._nombreeventoedittext = RemoteObject.createNew ("anywheresoftware.b4a.objects.FloatLabeledEditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private LabelDate As Label";
crearevento.mostCurrent._labeldate = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private LabelTime As Label";
crearevento.mostCurrent._labeltime = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private btnTime As Button";
crearevento.mostCurrent._btntime = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private PerfilesEvento As Spinner";
crearevento.mostCurrent._perfilesevento = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private Etiqueta_Nombre_Archivo As Label";
crearevento.mostCurrent._etiqueta_nombre_archivo = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private btnDate As Button";
crearevento.mostCurrent._btndate = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private Perfiles As Spinner";
crearevento.mostCurrent._perfiles = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private Conferencias As Panel";
crearevento.mostCurrent._conferencias = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private BotonGrupos As Button";
crearevento.mostCurrent._botongrupos = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _perfiles_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("Perfiles_ItemClick (crearevento) ","crearevento",3,crearevento.mostCurrent.activityBA,crearevento.mostCurrent,86);
if (RapidSub.canDelegate("perfiles_itemclick")) { return com.ServicioSocial.crearevento.remoteMe.runUserSub(false, "crearevento","perfiles_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 86;BA.debugLine="Sub Perfiles_ItemClick (Position As Int, Value As";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 87;BA.debugLine="Select(Position)";
Debug.ShouldStop(4194304);
switch (BA.switchObjectToInt((_position),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1))) {
case 0: {
 BA.debugLineNum = 89;BA.debugLine="Conferencias.Visible=True";
Debug.ShouldStop(16777216);
crearevento.mostCurrent._conferencias.runMethod(true,"setVisible",crearevento.mostCurrent.__c.getField(true,"True"));
 break; }
case 1: {
 break; }
}
;
 BA.debugLineNum = 93;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _perfilesevento_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("PerfilesEvento_ItemClick (crearevento) ","crearevento",3,crearevento.mostCurrent.activityBA,crearevento.mostCurrent,78);
if (RapidSub.canDelegate("perfilesevento_itemclick")) { return com.ServicioSocial.crearevento.remoteMe.runUserSub(false, "crearevento","perfilesevento_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 78;BA.debugLine="Sub PerfilesEvento_ItemClick (Position As Int, Val";
Debug.ShouldStop(8192);
 BA.debugLineNum = 79;BA.debugLine="Select(PerfilesEvento.SelectedIndex)";
Debug.ShouldStop(16384);
switch (BA.switchObjectToInt((crearevento.mostCurrent._perfilesevento.runMethod(true,"getSelectedIndex")),BA.numberCast(int.class, 6))) {
case 0: {
 break; }
}
;
 BA.debugLineNum = 84;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
 //BA.debugLineNum = 9;BA.debugLine="Dim Bmp As Bitmap";
crearevento._bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 //BA.debugLineNum = 10;BA.debugLine="Dim Bmp2 As Bitmap";
crearevento._bmp2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}