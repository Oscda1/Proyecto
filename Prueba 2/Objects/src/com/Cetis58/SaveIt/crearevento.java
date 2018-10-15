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

public class crearevento extends Activity implements B4AActivity{
	public static crearevento mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "com.Cetis58.SaveIt", "com.Cetis58.SaveIt.crearevento");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (crearevento).");
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
		activityBA = new BA(this, layout, processBA, "com.Cetis58.SaveIt", "com.Cetis58.SaveIt.crearevento");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.Cetis58.SaveIt.crearevento", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (crearevento) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (crearevento) Resume **");
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
		return crearevento.class;
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
        BA.LogInfo("** Activity (crearevento) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            crearevento mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (crearevento) Resume **");
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
public static anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
public static anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp2 = null;
public static anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp3 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _barratitulo = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imagenregresar = null;
public anywheresoftware.b4a.objects.FloatLabeledEditTextWrapper _nombreeventoedittext = null;
public anywheresoftware.b4a.objects.LabelWrapper _labeldate = null;
public anywheresoftware.b4a.objects.LabelWrapper _labeltime = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btntime = null;
public org.mlsoft.mlcombobox _perfilesevento = null;
public anywheresoftware.b4a.objects.LabelWrapper _etiqueta_nombre_archivo = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btndate = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _perfiles = null;
public anywheresoftware.b4a.objects.PanelWrapper _conferencias = null;
public anywheresoftware.b4a.objects.ButtonWrapper _botongrupos = null;
public com.Cetis58.SaveIt.main _main = null;
public com.Cetis58.SaveIt.starter _starter = null;
public com.Cetis58.SaveIt.principal _principal = null;
public com.Cetis58.SaveIt.seleccionargrupos _seleccionargrupos = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 31;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 33;BA.debugLine="Activity.LoadLayout(\"NuevoEventoLayout\")";
mostCurrent._activity.LoadLayout("NuevoEventoLayout",mostCurrent.activityBA);
 //BA.debugLineNum = 34;BA.debugLine="Bmp2=LoadBitmap(File.DirAssets,\"Boton_Fecha y hor";
_bmp2 = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Boton_Fecha y hora.png");
 //BA.debugLineNum = 35;BA.debugLine="BarraTitulo.Bitmap=LoadBitmap(File.DirAssets,\"Bar";
mostCurrent._barratitulo.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Barra_Texto_titulo.png").getObject()));
 //BA.debugLineNum = 36;BA.debugLine="ImagenRegresar.Bitmap=LoadBitmap(File.DirAssets,\"";
mostCurrent._imagenregresar.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Boton_retroceso.png").getObject()));
 //BA.debugLineNum = 37;BA.debugLine="NombreEventoEditText.SetBackgroundImage(LoadBitma";
mostCurrent._nombreeventoedittext.SetBackgroundImage((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Barra_TextoNombre y Conferencista.png").getObject()));
 //BA.debugLineNum = 38;BA.debugLine="Bmp.Initialize(File.DirAssets,\"Boton_fecha y hora";
_bmp.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Boton_fecha y hora.png");
 //BA.debugLineNum = 39;BA.debugLine="Bmp3.Initialize(File.DirAssets,\"Boton_Aceptar.png";
_bmp3.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Boton_Aceptar.png");
 //BA.debugLineNum = 40;BA.debugLine="Perfiles.Add(\"Feria de la salud\")";
mostCurrent._perfiles.Add("Feria de la salud");
 //BA.debugLineNum = 41;BA.debugLine="Perfiles.Add(\"Feria de universidades\")";
mostCurrent._perfiles.Add("Feria de universidades");
 //BA.debugLineNum = 42;BA.debugLine="Perfiles.Add(\"Aniversario\")";
mostCurrent._perfiles.Add("Aniversario");
 //BA.debugLineNum = 43;BA.debugLine="Perfiles.Add(\"Rendicion de cuentas\")";
mostCurrent._perfiles.Add("Rendicion de cuentas");
 //BA.debugLineNum = 44;BA.debugLine="Perfiles.Add(\"Estadias\")";
mostCurrent._perfiles.Add("Estadias");
 //BA.debugLineNum = 45;BA.debugLine="Perfiles.Add(\"Festival navideño\")";
mostCurrent._perfiles.Add("Festival navideño");
 //BA.debugLineNum = 46;BA.debugLine="Perfiles.Add(\"Conferencia\")";
mostCurrent._perfiles.Add("Conferencia");
 //BA.debugLineNum = 47;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 65;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 61;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 63;BA.debugLine="End Sub";
return "";
}
public static String  _botongrupos_click() throws Exception{
 //BA.debugLineNum = 80;BA.debugLine="Sub BotonGrupos_Click";
 //BA.debugLineNum = 81;BA.debugLine="StartActivity(SeleccionarGrupos)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._seleccionargrupos.getObject()));
 //BA.debugLineNum = 82;BA.debugLine="End Sub";
return "";
}
public static String  _btndate_click() throws Exception{
String _ret = "";
anywheresoftware.b4a.agraham.dialogs.InputDialog.DateDialog _dd = null;
 //BA.debugLineNum = 70;BA.debugLine="Sub btnDate_Click";
 //BA.debugLineNum = 71;BA.debugLine="Dim ret As String";
_ret = "";
 //BA.debugLineNum = 72;BA.debugLine="Dim Dd As DateDialog";
_dd = new anywheresoftware.b4a.agraham.dialogs.InputDialog.DateDialog();
 //BA.debugLineNum = 73;BA.debugLine="Dd.Year = DateTime.GetYear(DateTime.Now)";
_dd.setYear(anywheresoftware.b4a.keywords.Common.DateTime.GetYear(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
 //BA.debugLineNum = 74;BA.debugLine="Dd.Month = DateTime.GetMonth(DateTime.Now)";
_dd.setMonth(anywheresoftware.b4a.keywords.Common.DateTime.GetMonth(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
 //BA.debugLineNum = 75;BA.debugLine="Dd.DayOfMonth = DateTime.GetDayOfMonth(DateTime.N";
_dd.setDayOfMonth(anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfMonth(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
 //BA.debugLineNum = 76;BA.debugLine="ret = Dd.Show(\"Seleccione una Fecha\", \"SaveItGood";
_ret = BA.NumberToString(_dd.Show("Seleccione una Fecha","SaveItGood","Seleccionar","Cancelar","",mostCurrent.activityBA,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)));
 //BA.debugLineNum = 77;BA.debugLine="ToastMessageShow(ret & \" : \" & Dd.DayOfMonth & \"/";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(_ret+" : "+BA.NumberToString(_dd.getDayOfMonth())+"/"+BA.NumberToString(_dd.getMonth())+"/"+BA.NumberToString(_dd.getYear())),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 78;BA.debugLine="End Sub";
return "";
}
public static String  _btntime_click() throws Exception{
String _ret = "";
anywheresoftware.b4a.agraham.dialogs.InputDialog.TimeDialog _td = null;
String _txt = "";
 //BA.debugLineNum = 49;BA.debugLine="Sub btnTime_Click";
 //BA.debugLineNum = 50;BA.debugLine="Dim ret As String";
_ret = "";
 //BA.debugLineNum = 51;BA.debugLine="Dim td As TimeDialog";
_td = new anywheresoftware.b4a.agraham.dialogs.InputDialog.TimeDialog();
 //BA.debugLineNum = 52;BA.debugLine="Dim txt As String";
_txt = "";
 //BA.debugLineNum = 53;BA.debugLine="td.Hour = DateTime.GetHour(DateTime.Now)";
_td.setHour(anywheresoftware.b4a.keywords.Common.DateTime.GetHour(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
 //BA.debugLineNum = 54;BA.debugLine="td.Minute = DateTime.GetMinute(DateTime.Now)";
_td.setMinute(anywheresoftware.b4a.keywords.Common.DateTime.GetMinute(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
 //BA.debugLineNum = 55;BA.debugLine="td.Is24Hours = True";
_td.setIs24Hours(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 56;BA.debugLine="ret = td.Show(\"Seleccione la hora:\", \"SaveItGood\"";
_ret = BA.NumberToString(_td.Show("Seleccione la hora:","SaveItGood","Si","Cancelar","",mostCurrent.activityBA,(android.graphics.Bitmap)(_bmp.getObject())));
 //BA.debugLineNum = 57;BA.debugLine="ToastMessageShow(ret & \" : \" & td.Hour & \":\" & td";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(_ret+" : "+BA.NumberToString(_td.getHour())+":"+BA.NumberToString(_td.getMinute())),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 17;BA.debugLine="Private BarraTitulo As ImageView";
mostCurrent._barratitulo = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private ImagenRegresar As ImageView";
mostCurrent._imagenregresar = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private NombreEventoEditText As FloatLabeledEditT";
mostCurrent._nombreeventoedittext = new anywheresoftware.b4a.objects.FloatLabeledEditTextWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private LabelDate As Label";
mostCurrent._labeldate = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private LabelTime As Label";
mostCurrent._labeltime = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private btnTime As Button";
mostCurrent._btntime = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private PerfilesEvento As MLComboBox";
mostCurrent._perfilesevento = new org.mlsoft.mlcombobox();
 //BA.debugLineNum = 24;BA.debugLine="Private Etiqueta_Nombre_Archivo As Label";
mostCurrent._etiqueta_nombre_archivo = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private btnDate As Button";
mostCurrent._btndate = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private Perfiles As Spinner";
mostCurrent._perfiles = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private Conferencias As Panel";
mostCurrent._conferencias = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private BotonGrupos As Button";
mostCurrent._botongrupos = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return "";
}
public static String  _imagenregresar_click() throws Exception{
 //BA.debugLineNum = 103;BA.debugLine="Sub ImagenRegresar_Click";
 //BA.debugLineNum = 104;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 105;BA.debugLine="End Sub";
return "";
}
public static String  _perfiles_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 84;BA.debugLine="Sub Perfiles_ItemClick (Position As Int, Value As";
 //BA.debugLineNum = 85;BA.debugLine="Select(Position)";
switch (BA.switchObjectToInt((_position),(int) (0),(int) (1),(int) (2),(int) (3),(int) (4),(int) (5),(int) (6))) {
case 0: {
 //BA.debugLineNum = 87;BA.debugLine="Conferencias.Visible=False";
mostCurrent._conferencias.setVisible(anywheresoftware.b4a.keywords.Common.False);
 break; }
case 1: {
 //BA.debugLineNum = 89;BA.debugLine="Conferencias.Visible=False";
mostCurrent._conferencias.setVisible(anywheresoftware.b4a.keywords.Common.False);
 break; }
case 2: {
 //BA.debugLineNum = 91;BA.debugLine="Conferencias.Visible=False";
mostCurrent._conferencias.setVisible(anywheresoftware.b4a.keywords.Common.False);
 break; }
case 3: {
 //BA.debugLineNum = 93;BA.debugLine="Conferencias.Visible=False";
mostCurrent._conferencias.setVisible(anywheresoftware.b4a.keywords.Common.False);
 break; }
case 4: {
 //BA.debugLineNum = 95;BA.debugLine="Conferencias.Visible=False";
mostCurrent._conferencias.setVisible(anywheresoftware.b4a.keywords.Common.False);
 break; }
case 5: {
 //BA.debugLineNum = 97;BA.debugLine="Conferencias.Visible=False";
mostCurrent._conferencias.setVisible(anywheresoftware.b4a.keywords.Common.False);
 break; }
case 6: {
 //BA.debugLineNum = 99;BA.debugLine="Conferencias.Visible=True";
mostCurrent._conferencias.setVisible(anywheresoftware.b4a.keywords.Common.True);
 break; }
}
;
 //BA.debugLineNum = 101;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim Bmp As Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 10;BA.debugLine="Dim Bmp2 As Bitmap";
_bmp2 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 11;BA.debugLine="Dim Bmp3 As Bitmap";
_bmp3 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return "";
}
}
