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

public class principal2 extends Activity implements B4AActivity{
	public static principal2 mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.principal2");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (principal2).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.principal2");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.principal2", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (principal2) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (principal2) Resume **");
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
		return principal2.class;
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
        BA.LogInfo("** Activity (principal2) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            principal2 mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (principal2) Resume **");
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
public static String _contenido = "";
public static boolean _dospuntos = false;
public static int _contadorcaracter = 0;
public static String _letratemporal = "";
public static int _seccion = 0;
public static String _nombreevento = "";
public static String _fechaevento = "";
public static String _horaevento = "";
public static String _nombredocumento = "";
public static String _conferencista = "";
public static String _tipoevento = "";
public static boolean _primeravezengrupos = false;
public static int _iniciogrupos = 0;
public static int _cantidadgrupos = 0;
public static int _secciongrupo = 0;
public static int _despliegagrupos = 0;
public anywheresoftware.b4a.objects.PanelWrapper _eventospanel = null;
public anywheresoftware.b4a.objects.LabelWrapper _detalleseventos = null;
public anywheresoftware.b4a.objects.LabelWrapper _eventos = null;
public anywheresoftware.b4a.objects.ButtonWrapper _plusevento = null;
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.principal _principal = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="principal2";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
String[] _grupos = null;
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="Activity.LoadLayout(\"PrincipalLayout\")";
mostCurrent._activity.LoadLayout("PrincipalLayout",mostCurrent.activityBA);
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="DespliegaGrupos=0";
_despliegagrupos = (int) (0);
RDebugUtils.currentLine=1376260;
 //BA.debugLineNum = 1376260;BA.debugLine="SeccionGrupo=0";
_secciongrupo = (int) (0);
RDebugUtils.currentLine=1376261;
 //BA.debugLineNum = 1376261;BA.debugLine="CantidadGrupos=0";
_cantidadgrupos = (int) (0);
RDebugUtils.currentLine=1376262;
 //BA.debugLineNum = 1376262;BA.debugLine="Seccion=0";
_seccion = (int) (0);
RDebugUtils.currentLine=1376263;
 //BA.debugLineNum = 1376263;BA.debugLine="LetraTemporal=\"\"";
_letratemporal = "";
RDebugUtils.currentLine=1376264;
 //BA.debugLineNum = 1376264;BA.debugLine="ContadorCaracter=-1";
_contadorcaracter = (int) (-1);
RDebugUtils.currentLine=1376265;
 //BA.debugLineNum = 1376265;BA.debugLine="DosPuntos=False";
_dospuntos = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=1376266;
 //BA.debugLineNum = 1376266;BA.debugLine="NombreEvento=\"\"";
_nombreevento = "";
RDebugUtils.currentLine=1376267;
 //BA.debugLineNum = 1376267;BA.debugLine="FechaEvento=\"\"";
_fechaevento = "";
RDebugUtils.currentLine=1376268;
 //BA.debugLineNum = 1376268;BA.debugLine="HoraEvento=\"\"";
_horaevento = "";
RDebugUtils.currentLine=1376269;
 //BA.debugLineNum = 1376269;BA.debugLine="NombreDocumento=\"\"";
_nombredocumento = "";
RDebugUtils.currentLine=1376270;
 //BA.debugLineNum = 1376270;BA.debugLine="Conferencista=\"\"";
_conferencista = "";
RDebugUtils.currentLine=1376271;
 //BA.debugLineNum = 1376271;BA.debugLine="TipoEvento=\"\"";
_tipoevento = "";
RDebugUtils.currentLine=1376272;
 //BA.debugLineNum = 1376272;BA.debugLine="InicioGrupos=0";
_iniciogrupos = (int) (0);
RDebugUtils.currentLine=1376273;
 //BA.debugLineNum = 1376273;BA.debugLine="PrimeraVezEnGrupos=True";
_primeravezengrupos = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=1376274;
 //BA.debugLineNum = 1376274;BA.debugLine="Contenido=File.ReadString(File.DirAssets,\"eventos";
_contenido = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"eventos.txt");
RDebugUtils.currentLine=1376275;
 //BA.debugLineNum = 1376275;BA.debugLine="If (Contenido<>\"\") Then";
if (((_contenido).equals("") == false)) { 
RDebugUtils.currentLine=1376276;
 //BA.debugLineNum = 1376276;BA.debugLine="EventosPanel.Visible=True";
mostCurrent._eventospanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1376277;
 //BA.debugLineNum = 1376277;BA.debugLine="Eventos.Visible=False";
mostCurrent._eventos.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1376278;
 //BA.debugLineNum = 1376278;BA.debugLine="Do While (DosPuntos=False)";
while ((_dospuntos==anywheresoftware.b4a.keywords.Common.False)) {
RDebugUtils.currentLine=1376279;
 //BA.debugLineNum = 1376279;BA.debugLine="ContadorCaracter=ContadorCaracter+1";
_contadorcaracter = (int) (_contadorcaracter+1);
RDebugUtils.currentLine=1376280;
 //BA.debugLineNum = 1376280;BA.debugLine="LetraTemporal=Contenido.SubString(ContadorCaract";
_letratemporal = _contenido.substring(_contadorcaracter);
RDebugUtils.currentLine=1376281;
 //BA.debugLineNum = 1376281;BA.debugLine="Select (LetraTemporal)";
switch (BA.switchObjectToInt((_letratemporal),"-",":")) {
case 0: {
RDebugUtils.currentLine=1376283;
 //BA.debugLineNum = 1376283;BA.debugLine="Seccion=Seccion+1";
_seccion = (int) (_seccion+1);
RDebugUtils.currentLine=1376284;
 //BA.debugLineNum = 1376284;BA.debugLine="Log(Seccion)";
anywheresoftware.b4a.keywords.Common.Log(BA.NumberToString(_seccion));
RDebugUtils.currentLine=1376285;
 //BA.debugLineNum = 1376285;BA.debugLine="Exit";
if (true) break;
 break; }
case 1: {
RDebugUtils.currentLine=1376287;
 //BA.debugLineNum = 1376287;BA.debugLine="DosPuntos=True";
_dospuntos = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=1376288;
 //BA.debugLineNum = 1376288;BA.debugLine="Exit";
if (true) break;
 break; }
default: {
RDebugUtils.currentLine=1376290;
 //BA.debugLineNum = 1376290;BA.debugLine="Select (Seccion)";
switch (BA.switchObjectToInt((_seccion),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4),(int) (5),(int) (6))) {
case 0: {
RDebugUtils.currentLine=1376292;
 //BA.debugLineNum = 1376292;BA.debugLine="NombreEvento=NombreEvento&LetraTemporal";
_nombreevento = _nombreevento+_letratemporal;
RDebugUtils.currentLine=1376293;
 //BA.debugLineNum = 1376293;BA.debugLine="Exit";
if (true) break;
 break; }
case 1: {
RDebugUtils.currentLine=1376295;
 //BA.debugLineNum = 1376295;BA.debugLine="FechaEvento=FechaEvento&LetraTemporal";
_fechaevento = _fechaevento+_letratemporal;
RDebugUtils.currentLine=1376296;
 //BA.debugLineNum = 1376296;BA.debugLine="Exit";
if (true) break;
 break; }
case 2: {
RDebugUtils.currentLine=1376298;
 //BA.debugLineNum = 1376298;BA.debugLine="HoraEvento=HoraEvento&LetraTemporal";
_horaevento = _horaevento+_letratemporal;
RDebugUtils.currentLine=1376299;
 //BA.debugLineNum = 1376299;BA.debugLine="Exit";
if (true) break;
 break; }
case 3: {
RDebugUtils.currentLine=1376301;
 //BA.debugLineNum = 1376301;BA.debugLine="TipoEvento=TipoEvento&LetraTemporal";
_tipoevento = _tipoevento+_letratemporal;
RDebugUtils.currentLine=1376302;
 //BA.debugLineNum = 1376302;BA.debugLine="Exit";
if (true) break;
 break; }
case 4: {
RDebugUtils.currentLine=1376304;
 //BA.debugLineNum = 1376304;BA.debugLine="NombreDocumento=NombreDocumento&LetraTempora";
_nombredocumento = _nombredocumento+_letratemporal;
RDebugUtils.currentLine=1376305;
 //BA.debugLineNum = 1376305;BA.debugLine="Exit";
if (true) break;
 break; }
case 5: {
RDebugUtils.currentLine=1376307;
 //BA.debugLineNum = 1376307;BA.debugLine="Conferencista=Conferencista&LetraTemporal";
_conferencista = _conferencista+_letratemporal;
RDebugUtils.currentLine=1376308;
 //BA.debugLineNum = 1376308;BA.debugLine="Exit";
if (true) break;
 break; }
case 6: {
RDebugUtils.currentLine=1376310;
 //BA.debugLineNum = 1376310;BA.debugLine="If (PrimeraVezEnGrupos) Then";
if ((_primeravezengrupos)) { 
RDebugUtils.currentLine=1376311;
 //BA.debugLineNum = 1376311;BA.debugLine="InicioGrupos=ContadorCaracter";
_iniciogrupos = _contadorcaracter;
RDebugUtils.currentLine=1376312;
 //BA.debugLineNum = 1376312;BA.debugLine="Do While(PrimeraVezEnGrupos=True)";
while ((_primeravezengrupos==anywheresoftware.b4a.keywords.Common.True)) {
RDebugUtils.currentLine=1376313;
 //BA.debugLineNum = 1376313;BA.debugLine="InicioGrupos=InicioGrupos+1";
_iniciogrupos = (int) (_iniciogrupos+1);
RDebugUtils.currentLine=1376314;
 //BA.debugLineNum = 1376314;BA.debugLine="LetraTemporal=Contenido.SubString(InicioGr";
_letratemporal = _contenido.substring(_iniciogrupos);
RDebugUtils.currentLine=1376315;
 //BA.debugLineNum = 1376315;BA.debugLine="If (LetraTemporal=\";\") Then";
if (((_letratemporal).equals(";"))) { 
RDebugUtils.currentLine=1376316;
 //BA.debugLineNum = 1376316;BA.debugLine="CantidadGrupos=CantidadGrupos+1";
_cantidadgrupos = (int) (_cantidadgrupos+1);
 }else 
{RDebugUtils.currentLine=1376317;
 //BA.debugLineNum = 1376317;BA.debugLine="Else If (LetraTemporal=\":\") Then";
if (((_letratemporal).equals(":"))) { 
RDebugUtils.currentLine=1376318;
 //BA.debugLineNum = 1376318;BA.debugLine="PrimeraVezEnGrupos=False";
_primeravezengrupos = anywheresoftware.b4a.keywords.Common.False;
 }}
;
 }
;
RDebugUtils.currentLine=1376321;
 //BA.debugLineNum = 1376321;BA.debugLine="Dim Grupos(CantidadGrupos) As String";
_grupos = new String[_cantidadgrupos];
java.util.Arrays.fill(_grupos,"");
 }else {
RDebugUtils.currentLine=1376323;
 //BA.debugLineNum = 1376323;BA.debugLine="If (LetraTemporal<>\";\") Then";
if (((_letratemporal).equals(";") == false)) { 
RDebugUtils.currentLine=1376324;
 //BA.debugLineNum = 1376324;BA.debugLine="Grupos(SeccionGrupo)=LetraTemporal";
_grupos[_secciongrupo] = _letratemporal;
 }else {
RDebugUtils.currentLine=1376326;
 //BA.debugLineNum = 1376326;BA.debugLine="SeccionGrupo=SeccionGrupo+1";
_secciongrupo = (int) (_secciongrupo+1);
 };
 };
RDebugUtils.currentLine=1376329;
 //BA.debugLineNum = 1376329;BA.debugLine="Exit";
if (true) break;
 break; }
}
;
RDebugUtils.currentLine=1376331;
 //BA.debugLineNum = 1376331;BA.debugLine="Exit";
if (true) break;
 break; }
}
;
 }
;
RDebugUtils.currentLine=1376334;
 //BA.debugLineNum = 1376334;BA.debugLine="DetallesEventos.Text=NombreEvento&CRLF&FechaEven";
mostCurrent._detalleseventos.setText(BA.ObjectToCharSequence(_nombreevento+anywheresoftware.b4a.keywords.Common.CRLF+_fechaevento+anywheresoftware.b4a.keywords.Common.CRLF+_horaevento+anywheresoftware.b4a.keywords.Common.CRLF+_tipoevento+anywheresoftware.b4a.keywords.Common.CRLF+_nombredocumento+anywheresoftware.b4a.keywords.Common.CRLF+_conferencista+anywheresoftware.b4a.keywords.Common.CRLF));
RDebugUtils.currentLine=1376335;
 //BA.debugLineNum = 1376335;BA.debugLine="Do While(DespliegaGrupos<>CantidadGrupos)";
while ((_despliegagrupos!=_cantidadgrupos)) {
RDebugUtils.currentLine=1376336;
 //BA.debugLineNum = 1376336;BA.debugLine="DetallesEventos.Text=Eventos.Text&Grupos(Desplie";
mostCurrent._detalleseventos.setText(BA.ObjectToCharSequence(mostCurrent._eventos.getText()+_grupos[_despliegagrupos]));
RDebugUtils.currentLine=1376337;
 //BA.debugLineNum = 1376337;BA.debugLine="DespliegaGrupos=DespliegaGrupos+1";
_despliegagrupos = (int) (_despliegagrupos+1);
 }
;
 }else {
RDebugUtils.currentLine=1376340;
 //BA.debugLineNum = 1376340;BA.debugLine="Eventos.Visible=True";
mostCurrent._eventos.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1376341;
 //BA.debugLineNum = 1376341;BA.debugLine="EventosPanel.Visible=False";
mostCurrent._eventospanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=1376343;
 //BA.debugLineNum = 1376343;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="principal2";
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="principal2";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="End Sub";
return "";
}
}