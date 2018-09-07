package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class principal extends Activity implements B4AActivity{
	public static principal mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.principal");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (principal).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.principal");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.principal", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (principal) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (principal) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return principal.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (principal) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            principal mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (principal) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static boolean _existen = false;
public static String _contenido = "";
public static int _contador1 = 0;
public static int _contador2 = 0;
public static boolean _cargarevento = false;
public static boolean _todoslosgrupos = false;
public static String _temporal = "";
public static int _contador3 = 0;
public static int _cantidadgrupos = 0;
public static boolean _dospuntos = false;
public static String _puntoycoma = "";
public static int _numerodeinicio = 0;
public static int _seccion = 0;
public static String _nombreevento = "";
public static String _fechaevento = "";
public static String _horaevento = "";
public static String _tipoevento = "";
public static String _nombredeldocumento = "";
public static String _conferencista = "";
public static int _contador4 = 0;
public static boolean _totalcaracteres = false;
public static int _cantidadcaracteres = 0;
public anywheresoftware.b4a.objects.LabelWrapper _eventos = null;
public anywheresoftware.b4a.objects.ButtonWrapper _plusevento = null;
public anywheresoftware.b4a.objects.LabelWrapper _detalleseventos = null;
public anywheresoftware.b4a.objects.PanelWrapper _eventospanel = null;
public b4a.example.dateutils _dateutils = null;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="principal";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
String[] _grupos = null;
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="Activity.LoadLayout(\"PrincipalLayout\")";
mostCurrent._activity.LoadLayout("PrincipalLayout",mostCurrent.activityBA);
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="Contenido=File.ReadString(File.DirAssets,\"eventos";
_contenido = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"eventos.txt");
RDebugUtils.currentLine=983044;
 //BA.debugLineNum = 983044;BA.debugLine="TotalCaracteres=False";
_totalcaracteres = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=983045;
 //BA.debugLineNum = 983045;BA.debugLine="CantidadCaracteres=0";
_cantidadcaracteres = (int) (0);
RDebugUtils.currentLine=983046;
 //BA.debugLineNum = 983046;BA.debugLine="Contador1=-1";
_contador1 = (int) (-1);
RDebugUtils.currentLine=983047;
 //BA.debugLineNum = 983047;BA.debugLine="Contador2=0";
_contador2 = (int) (0);
RDebugUtils.currentLine=983048;
 //BA.debugLineNum = 983048;BA.debugLine="Contador3=0";
_contador3 = (int) (0);
RDebugUtils.currentLine=983049;
 //BA.debugLineNum = 983049;BA.debugLine="Contador4=-1";
_contador4 = (int) (-1);
RDebugUtils.currentLine=983050;
 //BA.debugLineNum = 983050;BA.debugLine="Seccion=0";
_seccion = (int) (0);
RDebugUtils.currentLine=983051;
 //BA.debugLineNum = 983051;BA.debugLine="NombreEvento=\"\"";
_nombreevento = "";
RDebugUtils.currentLine=983052;
 //BA.debugLineNum = 983052;BA.debugLine="FechaEvento=\"\"";
_fechaevento = "";
RDebugUtils.currentLine=983053;
 //BA.debugLineNum = 983053;BA.debugLine="HoraEvento=\"\"";
_horaevento = "";
RDebugUtils.currentLine=983054;
 //BA.debugLineNum = 983054;BA.debugLine="TipoEvento=\"\"";
_tipoevento = "";
RDebugUtils.currentLine=983055;
 //BA.debugLineNum = 983055;BA.debugLine="NombreDelDocumento=\"\"";
_nombredeldocumento = "";
RDebugUtils.currentLine=983056;
 //BA.debugLineNum = 983056;BA.debugLine="Conferencista=\"\"";
_conferencista = "";
RDebugUtils.currentLine=983057;
 //BA.debugLineNum = 983057;BA.debugLine="DosPuntos=False";
_dospuntos = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=983058;
 //BA.debugLineNum = 983058;BA.debugLine="TodosLosGrupos=False";
_todoslosgrupos = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=983059;
 //BA.debugLineNum = 983059;BA.debugLine="If (Contenido<>\"\") Then";
if (((_contenido).equals("") == false)) { 
RDebugUtils.currentLine=983060;
 //BA.debugLineNum = 983060;BA.debugLine="Existen=True";
_existen = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=983062;
 //BA.debugLineNum = 983062;BA.debugLine="Existen=False";
_existen = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=983064;
 //BA.debugLineNum = 983064;BA.debugLine="If Existen Then";
if (_existen) { 
RDebugUtils.currentLine=983065;
 //BA.debugLineNum = 983065;BA.debugLine="EventosPanel.Visible=True";
mostCurrent._eventospanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=983066;
 //BA.debugLineNum = 983066;BA.debugLine="Eventos.Visible=False";
mostCurrent._eventos.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=983067;
 //BA.debugLineNum = 983067;BA.debugLine="CargarEvento=False";
_cargarevento = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=983068;
 //BA.debugLineNum = 983068;BA.debugLine="Do While(TotalCaracteres=False)";
while ((_totalcaracteres==anywheresoftware.b4a.keywords.Common.False)) {
RDebugUtils.currentLine=983069;
 //BA.debugLineNum = 983069;BA.debugLine="Temporal=Contenido.SubString(CantidadCaracteres";
_temporal = _contenido.substring(_cantidadcaracteres);
RDebugUtils.currentLine=983070;
 //BA.debugLineNum = 983070;BA.debugLine="If Temporal=\":\" Then";
if ((_temporal).equals(":")) { 
RDebugUtils.currentLine=983071;
 //BA.debugLineNum = 983071;BA.debugLine="TotalCaracteres=True";
_totalcaracteres = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=983073;
 //BA.debugLineNum = 983073;BA.debugLine="CantidadCaracteres=CantidadCaracteres+1";
_cantidadcaracteres = (int) (_cantidadcaracteres+1);
 };
 }
;
RDebugUtils.currentLine=983076;
 //BA.debugLineNum = 983076;BA.debugLine="Do While(Contador1<>CantidadCaracteres)";
while ((_contador1!=_cantidadcaracteres)) {
RDebugUtils.currentLine=983077;
 //BA.debugLineNum = 983077;BA.debugLine="Contador1=Contador1+1";
_contador1 = (int) (_contador1+1);
RDebugUtils.currentLine=983078;
 //BA.debugLineNum = 983078;BA.debugLine="Temporal=Contenido.SubString(Contador1)";
_temporal = _contenido.substring(_contador1);
RDebugUtils.currentLine=983079;
 //BA.debugLineNum = 983079;BA.debugLine="Select Temporal";
switch (BA.switchObjectToInt(_temporal,"|","<")) {
case 0: {
RDebugUtils.currentLine=983081;
 //BA.debugLineNum = 983081;BA.debugLine="Contador3=Contador3+1";
_contador3 = (int) (_contador3+1);
RDebugUtils.currentLine=983082;
 //BA.debugLineNum = 983082;BA.debugLine="Exit";
if (true) break;
 break; }
case 1: {
RDebugUtils.currentLine=983084;
 //BA.debugLineNum = 983084;BA.debugLine="NumeroDeInicio=Contador1+1";
_numerodeinicio = (int) (_contador1+1);
RDebugUtils.currentLine=983085;
 //BA.debugLineNum = 983085;BA.debugLine="Do While (DosPuntos=False)";
while ((_dospuntos==anywheresoftware.b4a.keywords.Common.False)) {
RDebugUtils.currentLine=983086;
 //BA.debugLineNum = 983086;BA.debugLine="Contador1=Contador1+1";
_contador1 = (int) (_contador1+1);
RDebugUtils.currentLine=983087;
 //BA.debugLineNum = 983087;BA.debugLine="PuntoYComa=Contenido.SubString(Contador1)";
_puntoycoma = _contenido.substring(_contador1);
RDebugUtils.currentLine=983088;
 //BA.debugLineNum = 983088;BA.debugLine="Select (PuntoYComa)";
switch (BA.switchObjectToInt((_puntoycoma),":",";")) {
case 0: {
RDebugUtils.currentLine=983090;
 //BA.debugLineNum = 983090;BA.debugLine="DosPuntos=True";
_dospuntos = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=983091;
 //BA.debugLineNum = 983091;BA.debugLine="Exit";
if (true) break;
 break; }
case 1: {
RDebugUtils.currentLine=983093;
 //BA.debugLineNum = 983093;BA.debugLine="CantidadGrupos=CantidadGrupos+1";
_cantidadgrupos = (int) (_cantidadgrupos+1);
RDebugUtils.currentLine=983094;
 //BA.debugLineNum = 983094;BA.debugLine="Exit";
if (true) break;
 break; }
}
;
RDebugUtils.currentLine=983096;
 //BA.debugLineNum = 983096;BA.debugLine="Dim Grupos(CantidadGrupos) As String";
_grupos = new String[_cantidadgrupos];
java.util.Arrays.fill(_grupos,"");
RDebugUtils.currentLine=983097;
 //BA.debugLineNum = 983097;BA.debugLine="PuntoYComa=False";
_puntoycoma = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=983098;
 //BA.debugLineNum = 983098;BA.debugLine="Contador2=NumeroDeInicio";
_contador2 = _numerodeinicio;
RDebugUtils.currentLine=983099;
 //BA.debugLineNum = 983099;BA.debugLine="DosPuntos=False";
_dospuntos = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=983100;
 //BA.debugLineNum = 983100;BA.debugLine="Do While (DosPuntos=False)";
while ((_dospuntos==anywheresoftware.b4a.keywords.Common.False)) {
RDebugUtils.currentLine=983101;
 //BA.debugLineNum = 983101;BA.debugLine="PuntoYComa=Contenido.SubString(Contador1)";
_puntoycoma = _contenido.substring(_contador1);
RDebugUtils.currentLine=983102;
 //BA.debugLineNum = 983102;BA.debugLine="Select (PuntoYComa)";
switch (BA.switchObjectToInt((_puntoycoma),":",";")) {
case 0: {
RDebugUtils.currentLine=983104;
 //BA.debugLineNum = 983104;BA.debugLine="DosPuntos=True";
_dospuntos = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=983105;
 //BA.debugLineNum = 983105;BA.debugLine="CargarEvento=True";
_cargarevento = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=983106;
 //BA.debugLineNum = 983106;BA.debugLine="Exit";
if (true) break;
 break; }
case 1: {
RDebugUtils.currentLine=983108;
 //BA.debugLineNum = 983108;BA.debugLine="Contador2=Contador2+1";
_contador2 = (int) (_contador2+1);
RDebugUtils.currentLine=983109;
 //BA.debugLineNum = 983109;BA.debugLine="Exit";
if (true) break;
 break; }
default: {
RDebugUtils.currentLine=983111;
 //BA.debugLineNum = 983111;BA.debugLine="Grupos(Contador2)=Grupos(Contador2)+Punto";
_grupos[_contador2] = BA.NumberToString((double)(Double.parseDouble(_grupos[_contador2]))+(double)(Double.parseDouble(_puntoycoma)));
 break; }
}
;
 }
;
 }
;
 break; }
default: {
RDebugUtils.currentLine=983116;
 //BA.debugLineNum = 983116;BA.debugLine="Select Seccion";
switch (_seccion) {
case 0: {
RDebugUtils.currentLine=983118;
 //BA.debugLineNum = 983118;BA.debugLine="NombreEvento=NombreEvento&Temporal";
_nombreevento = _nombreevento+_temporal;
RDebugUtils.currentLine=983119;
 //BA.debugLineNum = 983119;BA.debugLine="Exit";
if (true) break;
 break; }
case 1: {
RDebugUtils.currentLine=983121;
 //BA.debugLineNum = 983121;BA.debugLine="FechaEvento=FechaEvento&Temporal";
_fechaevento = _fechaevento+_temporal;
RDebugUtils.currentLine=983122;
 //BA.debugLineNum = 983122;BA.debugLine="Exit";
if (true) break;
 break; }
case 2: {
RDebugUtils.currentLine=983124;
 //BA.debugLineNum = 983124;BA.debugLine="HoraEvento=HoraEvento&Temporal";
_horaevento = _horaevento+_temporal;
RDebugUtils.currentLine=983125;
 //BA.debugLineNum = 983125;BA.debugLine="Exit";
if (true) break;
 break; }
case 3: {
RDebugUtils.currentLine=983127;
 //BA.debugLineNum = 983127;BA.debugLine="TipoEvento=TipoEvento&Temporal";
_tipoevento = _tipoevento+_temporal;
RDebugUtils.currentLine=983128;
 //BA.debugLineNum = 983128;BA.debugLine="Exit";
if (true) break;
 break; }
case 4: {
RDebugUtils.currentLine=983130;
 //BA.debugLineNum = 983130;BA.debugLine="NombreDelDocumento=NombreDelDocumento&Tempo";
_nombredeldocumento = _nombredeldocumento+_temporal;
RDebugUtils.currentLine=983131;
 //BA.debugLineNum = 983131;BA.debugLine="Exit";
if (true) break;
 break; }
case 5: {
RDebugUtils.currentLine=983133;
 //BA.debugLineNum = 983133;BA.debugLine="Conferencista=Conferencista&Temporal";
_conferencista = _conferencista+_temporal;
RDebugUtils.currentLine=983134;
 //BA.debugLineNum = 983134;BA.debugLine="Exit";
if (true) break;
 break; }
}
;
 break; }
}
;
 }
;
RDebugUtils.currentLine=983138;
 //BA.debugLineNum = 983138;BA.debugLine="DetallesEventos.Text=\"Nombre: \"&NombreEvento & C";
mostCurrent._detalleseventos.setText(BA.ObjectToCharSequence("Nombre: "+_nombreevento+anywheresoftware.b4a.keywords.Common.CRLF+"Fecha: "+_fechaevento+anywheresoftware.b4a.keywords.Common.CRLF+"Hora: "+_horaevento+anywheresoftware.b4a.keywords.Common.CRLF+"Evento: "+_tipoevento+anywheresoftware.b4a.keywords.Common.CRLF+"Conferencista: "+_conferencista+"Grupos: "));
RDebugUtils.currentLine=983139;
 //BA.debugLineNum = 983139;BA.debugLine="Do While (TodosLosGrupos)";
while ((_todoslosgrupos)) {
RDebugUtils.currentLine=983140;
 //BA.debugLineNum = 983140;BA.debugLine="Contador4=Contador4+1";
_contador4 = (int) (_contador4+1);
RDebugUtils.currentLine=983141;
 //BA.debugLineNum = 983141;BA.debugLine="DetallesEventos.Text=DetallesEventos.Text&Grupo";
mostCurrent._detalleseventos.setText(BA.ObjectToCharSequence(mostCurrent._detalleseventos.getText()+_grupos[_contador4]));
RDebugUtils.currentLine=983142;
 //BA.debugLineNum = 983142;BA.debugLine="If (Contador4=CantidadGrupos) Then";
if ((_contador4==_cantidadgrupos)) { 
RDebugUtils.currentLine=983143;
 //BA.debugLineNum = 983143;BA.debugLine="TodosLosGrupos=True";
_todoslosgrupos = anywheresoftware.b4a.keywords.Common.True;
 };
 }
;
 }else {
RDebugUtils.currentLine=983147;
 //BA.debugLineNum = 983147;BA.debugLine="Eventos.Visible=True";
mostCurrent._eventos.setVisible(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=983149;
 //BA.debugLineNum = 983149;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="principal";
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="principal";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="End Sub";
return "";
}
public static String  _plusevento_click() throws Exception{
RDebugUtils.currentModule="principal";
if (Debug.shouldDelegate(mostCurrent.activityBA, "plusevento_click"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "plusevento_click", null));}
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub PlusEvento_Click";
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="End Sub";
return "";
}
}