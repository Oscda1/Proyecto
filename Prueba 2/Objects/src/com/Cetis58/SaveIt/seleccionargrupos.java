package com.Cetis58.SaveIt;


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

public class seleccionargrupos extends Activity implements B4AActivity{
	public static seleccionargrupos mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "com.Cetis58.SaveIt", "com.Cetis58.SaveIt.seleccionargrupos");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (seleccionargrupos).");
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
		activityBA = new BA(this, layout, processBA, "com.Cetis58.SaveIt", "com.Cetis58.SaveIt.seleccionargrupos");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.Cetis58.SaveIt.seleccionargrupos", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (seleccionargrupos) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (seleccionargrupos) Resume **");
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
		return seleccionargrupos.class;
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
        BA.LogInfo("** Activity (seleccionargrupos) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            seleccionargrupos mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (seleccionargrupos) Resume **");
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

public anywheresoftware.b4a.keywords.Common __c = null;
public static int _mes = 0;
public static boolean _periodo = false;
public static String _contenido = "";
public static anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _btmp = null;
public static String[] _grupos = null;
public static boolean _salir = false;
public static int _contadorgrupos = 0;
public static int _cuantosgrupos = 0;
public static int _quitar = 0;
public anywheresoftware.b4a.objects.LabelWrapper _nogrupos = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _fondo = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _nohaygrupos = null;
public anywheresoftware.b4a.objects.PanelWrapper _haygrupos = null;
public anywheresoftware.b4a.objects.LabelWrapper _sigrupos = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _fondohaygrupos = null;
public anywheresoftware.b4a.objects.ListViewWrapper _gruposlista = null;
public anywheresoftware.b4a.objects.ButtonWrapper _otrogrupo = null;
public com.Cetis58.SaveIt.main _main = null;
public com.Cetis58.SaveIt.starter _starter = null;
public com.Cetis58.SaveIt.principal _principal = null;
public com.Cetis58.SaveIt.crearevento _crearevento = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 35;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 37;BA.debugLine="Activity.LoadLayout(\"SelGrupo\")";
mostCurrent._activity.LoadLayout("SelGrupo",mostCurrent.activityBA);
 //BA.debugLineNum = 38;BA.debugLine="Mes=0";
_mes = (int) (0);
 //BA.debugLineNum = 39;BA.debugLine="btmp.Initialize(File.DirAssets,\"Barra_Datos_Event";
_btmp.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Barra_Datos_Evento.png");
 //BA.debugLineNum = 40;BA.debugLine="Fondo.SetBackgroundImage(btmp)";
mostCurrent._fondo.SetBackgroundImageNew((android.graphics.Bitmap)(_btmp.getObject()));
 //BA.debugLineNum = 41;BA.debugLine="DateTime.DateFormat=\"M\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("M");
 //BA.debugLineNum = 42;BA.debugLine="Mes=DateTime.Date(DateTime.Now)";
_mes = (int)(Double.parseDouble(anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow())));
 //BA.debugLineNum = 43;BA.debugLine="If Mes>=2 And Mes<=8 Then";
if (_mes>=2 && _mes<=8) { 
 //BA.debugLineNum = 44;BA.debugLine="Periodo=True'Significa que esta en el periodo 1";
_periodo = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 46;BA.debugLine="Periodo=False'Significa que esta en el periodo 2";
_periodo = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 48;BA.debugLine="ChecarGrupos";
_checargrupos();
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 81;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 82;BA.debugLine="ChecarGrupos";
_checargrupos();
 //BA.debugLineNum = 83;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 77;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 78;BA.debugLine="ChecarGrupos";
_checargrupos();
 //BA.debugLineNum = 79;BA.debugLine="End Sub";
return "";
}
public static String  _checargrupos() throws Exception{
 //BA.debugLineNum = 53;BA.debugLine="Sub ChecarGrupos";
 //BA.debugLineNum = 54;BA.debugLine="contenido=File.ReadString(File.DirAssets,\"grupos.";
_contenido = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"grupos.txt");
 //BA.debugLineNum = 55;BA.debugLine="If contenido=\"\" Then";
if ((_contenido).equals("")) { 
 //BA.debugLineNum = 56;BA.debugLine="NoHayGrupos.Visible=True";
mostCurrent._nohaygrupos.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 57;BA.debugLine="HayGrupos.Visible=False";
mostCurrent._haygrupos.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 59;BA.debugLine="HayGrupos.Visible=True";
mostCurrent._haygrupos.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 60;BA.debugLine="NoHayGrupos.Visible=False";
mostCurrent._nohaygrupos.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 61;BA.debugLine="Salir=True";
_salir = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 62;BA.debugLine="ContadorGrupos=0";
_contadorgrupos = (int) (0);
 //BA.debugLineNum = 63;BA.debugLine="Grupos=Regex.Split(\";\",contenido)";
_grupos = anywheresoftware.b4a.keywords.Common.Regex.Split(";",_contenido);
 //BA.debugLineNum = 64;BA.debugLine="CuantosGrupos=Grupos.Length";
_cuantosgrupos = _grupos.length;
 //BA.debugLineNum = 65;BA.debugLine="CuantosGrupos=CuantosGrupos-1";
_cuantosgrupos = (int) (_cuantosgrupos-1);
 //BA.debugLineNum = 66;BA.debugLine="ContadorGrupos=-1";
_contadorgrupos = (int) (-1);
 //BA.debugLineNum = 67;BA.debugLine="Quitar=0";
_quitar = (int) (0);
 //BA.debugLineNum = 68;BA.debugLine="GruposLista.Clear";
mostCurrent._gruposlista.Clear();
 //BA.debugLineNum = 69;BA.debugLine="Do While (ContadorGrupos<CuantosGrupos)";
while ((_contadorgrupos<_cuantosgrupos)) {
 //BA.debugLineNum = 70;BA.debugLine="ContadorGrupos=ContadorGrupos+1";
_contadorgrupos = (int) (_contadorgrupos+1);
 //BA.debugLineNum = 71;BA.debugLine="Log(ContadorGrupos)";
anywheresoftware.b4a.keywords.Common.Log(BA.NumberToString(_contadorgrupos));
 //BA.debugLineNum = 72;BA.debugLine="GruposLista.AddSingleLine(Grupos(ContadorGrupos";
mostCurrent._gruposlista.AddSingleLine(BA.ObjectToCharSequence(_grupos[_contadorgrupos]));
 }
;
 };
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 20;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 23;BA.debugLine="Private NoGrupos As Label";
mostCurrent._nogrupos = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private Fondo As ImageView";
mostCurrent._fondo = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private NoHayGrupos As Panel";
mostCurrent._nohaygrupos = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private HayGrupos As Panel";
mostCurrent._haygrupos = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private SiGrupos As Label";
mostCurrent._sigrupos = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private FondoHayGrupos As ImageView";
mostCurrent._fondohaygrupos = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private GruposLista As ListView";
mostCurrent._gruposlista = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private OtroGrupo As Button";
mostCurrent._otrogrupo = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return "";
}
public static String  _otrogrupo_click() throws Exception{
 //BA.debugLineNum = 85;BA.debugLine="Sub OtroGrupo_Click";
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim Mes As Int";
_mes = 0;
 //BA.debugLineNum = 10;BA.debugLine="Dim Periodo As Boolean";
_periodo = false;
 //BA.debugLineNum = 11;BA.debugLine="Dim contenido As String";
_contenido = "";
 //BA.debugLineNum = 12;BA.debugLine="Dim btmp As Bitmap";
_btmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Dim Grupos() As String";
_grupos = new String[(int) (0)];
java.util.Arrays.fill(_grupos,"");
 //BA.debugLineNum = 14;BA.debugLine="Dim Salir As Boolean";
_salir = false;
 //BA.debugLineNum = 15;BA.debugLine="Dim ContadorGrupos As Int";
_contadorgrupos = 0;
 //BA.debugLineNum = 16;BA.debugLine="Dim CuantosGrupos As Int";
_cuantosgrupos = 0;
 //BA.debugLineNum = 17;BA.debugLine="Dim Quitar As Int";
_quitar = 0;
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return "";
}
}
