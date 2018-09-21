package com.ServicioSocial;


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
			processBA = new BA(this.getApplicationContext(), null, null, "com.ServicioSocial", "com.ServicioSocial.principal");
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
		activityBA = new BA(this, layout, processBA, "com.ServicioSocial", "com.ServicioSocial.principal");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.ServicioSocial.principal", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
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

public anywheresoftware.b4a.keywords.Common __c = null;
public static String _contenido = "";
public static String[] _cantidades = null;
public static boolean _sale = false;
public static int _contador = 0;
public static String _nombreevento = "";
public static String _fechaevento = "";
public static String _horaevento = "";
public static String _nombredocumento = "";
public static String _conferencista = "";
public static String _tipoevento = "";
public static String[] _grupos = null;
public static anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _btm = null;
public anywheresoftware.b4a.objects.LabelWrapper _detalleseventos = null;
public anywheresoftware.b4a.objects.PanelWrapper _eventospanel = null;
public anywheresoftware.b4a.objects.LabelWrapper _eventos = null;
public anywheresoftware.b4a.objects.ButtonWrapper _plusevento = null;
public com.ServicioSocial.main _main = null;
public com.ServicioSocial.starter _starter = null;
public com.ServicioSocial.crearevento _crearevento = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 33;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 35;BA.debugLine="Activity.LoadLayout(\"PrincipalLayout\")";
mostCurrent._activity.LoadLayout("PrincipalLayout",mostCurrent.activityBA);
 //BA.debugLineNum = 36;BA.debugLine="contenido=File.ReadString(File.DirAssets,\"Eventos";
_contenido = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Eventos.txt");
 //BA.debugLineNum = 37;BA.debugLine="If contenido=\"\" Then";
if ((_contenido).equals("")) { 
 //BA.debugLineNum = 38;BA.debugLine="Eventos.Visible=True";
mostCurrent._eventos.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 39;BA.debugLine="EventosPanel.Visible=False";
mostCurrent._eventospanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 41;BA.debugLine="btm.Initialize(File.DirAssets,\"Barra_Datos_Event";
_btm.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Barra_Datos_Evento.png");
 //BA.debugLineNum = 42;BA.debugLine="DetallesEventos.SetBackgroundImage(btm)";
mostCurrent._detalleseventos.SetBackgroundImageNew((android.graphics.Bitmap)(_btm.getObject()));
 //BA.debugLineNum = 43;BA.debugLine="Eventos.Visible=False";
mostCurrent._eventos.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 44;BA.debugLine="EventosPanel.Visible=True";
mostCurrent._eventospanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 45;BA.debugLine="cantidades=Regex.Split(\"-\", contenido)";
_cantidades = anywheresoftware.b4a.keywords.Common.Regex.Split("-",_contenido);
 //BA.debugLineNum = 46;BA.debugLine="Sale=False";
_sale = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 47;BA.debugLine="Contador=-1";
_contador = (int) (-1);
 //BA.debugLineNum = 48;BA.debugLine="Do While Sale=False";
while (_sale==anywheresoftware.b4a.keywords.Common.False) {
 //BA.debugLineNum = 49;BA.debugLine="Contador=Contador+1";
_contador = (int) (_contador+1);
 //BA.debugLineNum = 50;BA.debugLine="Select Contador";
switch (_contador) {
case 0: {
 //BA.debugLineNum = 52;BA.debugLine="NombreEvento=cantidades(Contador)";
_nombreevento = _cantidades[_contador];
 break; }
case 1: {
 //BA.debugLineNum = 54;BA.debugLine="FechaEvento=cantidades(Contador)";
_fechaevento = _cantidades[_contador];
 break; }
case 2: {
 //BA.debugLineNum = 56;BA.debugLine="HoraEvento=cantidades(Contador)";
_horaevento = _cantidades[_contador];
 break; }
case 3: {
 //BA.debugLineNum = 58;BA.debugLine="TipoEvento=cantidades(Contador)";
_tipoevento = _cantidades[_contador];
 break; }
case 4: {
 //BA.debugLineNum = 60;BA.debugLine="NombreDocumento=cantidades(Contador)";
_nombredocumento = _cantidades[_contador];
 break; }
case 5: {
 //BA.debugLineNum = 62;BA.debugLine="Conferencista=cantidades(Contador)";
_conferencista = _cantidades[_contador];
 break; }
case 6: {
 //BA.debugLineNum = 64;BA.debugLine="Grupos=Regex.Split(\";\",cantidades(Contador))";
_grupos = anywheresoftware.b4a.keywords.Common.Regex.Split(";",_cantidades[_contador]);
 //BA.debugLineNum = 65;BA.debugLine="Sale=True";
_sale = anywheresoftware.b4a.keywords.Common.True;
 break; }
}
;
 }
;
 //BA.debugLineNum = 68;BA.debugLine="Sale=False";
_sale = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 69;BA.debugLine="Contador=-1";
_contador = (int) (-1);
 //BA.debugLineNum = 70;BA.debugLine="DetallesEventos.Text=\"El evento \"&NombreEvento&\"";
mostCurrent._detalleseventos.setText(BA.ObjectToCharSequence("El evento "+_nombreevento+" sera el dia "+_fechaevento+" a las "+_horaevento+" sera un evento de "+_tipoevento+" el documento es "+_nombredocumento+" el conferencista sera "+_conferencista+" y los grupos implicados seran "+anywheresoftware.b4a.keywords.Common.CRLF));
 //BA.debugLineNum = 71;BA.debugLine="Do While Sale=False";
while (_sale==anywheresoftware.b4a.keywords.Common.False) {
 //BA.debugLineNum = 72;BA.debugLine="Try";
try { //BA.debugLineNum = 73;BA.debugLine="Contador=Contador+1";
_contador = (int) (_contador+1);
 //BA.debugLineNum = 74;BA.debugLine="DetallesEventos.Text=DetallesEventos.Text&Grup";
mostCurrent._detalleseventos.setText(BA.ObjectToCharSequence(mostCurrent._detalleseventos.getText()+_grupos[_contador]+anywheresoftware.b4a.keywords.Common.CRLF));
 } 
       catch (Exception e42) {
			processBA.setLastException(e42); //BA.debugLineNum = 76;BA.debugLine="Sale=True";
_sale = anywheresoftware.b4a.keywords.Common.True;
 };
 }
;
 };
 //BA.debugLineNum = 82;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 88;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 90;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 84;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 86;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 23;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 27;BA.debugLine="Private DetallesEventos As Label";
mostCurrent._detalleseventos = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private EventosPanel As Panel";
mostCurrent._eventospanel = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private Eventos As Label";
mostCurrent._eventos = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private PlusEvento As Button";
mostCurrent._plusevento = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return "";
}
public static String  _plusevento_click() throws Exception{
 //BA.debugLineNum = 93;BA.debugLine="Sub PlusEvento_Click";
 //BA.debugLineNum = 94;BA.debugLine="StartActivity(\"CrearEvento\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("CrearEvento"));
 //BA.debugLineNum = 95;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim contenido As String";
_contenido = "";
 //BA.debugLineNum = 10;BA.debugLine="Dim cantidades() As String";
_cantidades = new String[(int) (0)];
java.util.Arrays.fill(_cantidades,"");
 //BA.debugLineNum = 11;BA.debugLine="Dim Sale As Boolean";
_sale = false;
 //BA.debugLineNum = 12;BA.debugLine="Dim Contador As Int";
_contador = 0;
 //BA.debugLineNum = 13;BA.debugLine="Dim NombreEvento As String";
_nombreevento = "";
 //BA.debugLineNum = 14;BA.debugLine="Dim FechaEvento As String";
_fechaevento = "";
 //BA.debugLineNum = 15;BA.debugLine="Dim HoraEvento As String";
_horaevento = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim NombreDocumento As String";
_nombredocumento = "";
 //BA.debugLineNum = 17;BA.debugLine="Dim Conferencista As String";
_conferencista = "";
 //BA.debugLineNum = 18;BA.debugLine="Dim TipoEvento As String";
_tipoevento = "";
 //BA.debugLineNum = 19;BA.debugLine="Dim Grupos() As String";
_grupos = new String[(int) (0)];
java.util.Arrays.fill(_grupos,"");
 //BA.debugLineNum = 20;BA.debugLine="Dim btm As Bitmap";
_btm = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return "";
}
}
