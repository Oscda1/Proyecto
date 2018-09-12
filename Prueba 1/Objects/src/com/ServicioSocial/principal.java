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
	public static final boolean fullScreen = true;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "com.ServicioSocial", "com.ServicioSocial.principal");
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



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
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
public anywheresoftware.b4a.objects.LabelWrapper _detalleseventos = null;
public anywheresoftware.b4a.objects.PanelWrapper _eventospanel = null;
public anywheresoftware.b4a.objects.LabelWrapper _eventos = null;
public anywheresoftware.b4a.objects.ButtonWrapper _plusevento = null;
public b4a.example.dateutils _dateutils = null;
public com.ServicioSocial.main _main = null;
public com.ServicioSocial.starter _starter = null;
public com.ServicioSocial.crearevento _crearevento = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="principal";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="Activity.LoadLayout(\"PrincipalLayout\")";
mostCurrent._activity.LoadLayout("PrincipalLayout",mostCurrent.activityBA);
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="contenido=File.ReadString(File.DirAssets,\"Eventos";
_contenido = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Eventos.txt");
RDebugUtils.currentLine=983044;
 //BA.debugLineNum = 983044;BA.debugLine="If contenido=\"\" Then";
if ((_contenido).equals("")) { 
RDebugUtils.currentLine=983045;
 //BA.debugLineNum = 983045;BA.debugLine="Eventos.Visible=True";
mostCurrent._eventos.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=983046;
 //BA.debugLineNum = 983046;BA.debugLine="EventosPanel.Visible=False";
mostCurrent._eventospanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=983048;
 //BA.debugLineNum = 983048;BA.debugLine="Eventos.Visible=False";
mostCurrent._eventos.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=983049;
 //BA.debugLineNum = 983049;BA.debugLine="EventosPanel.Visible=True";
mostCurrent._eventospanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=983050;
 //BA.debugLineNum = 983050;BA.debugLine="cantidades=Regex.Split(\"-\", contenido)";
_cantidades = anywheresoftware.b4a.keywords.Common.Regex.Split("-",_contenido);
RDebugUtils.currentLine=983051;
 //BA.debugLineNum = 983051;BA.debugLine="Sale=False";
_sale = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=983052;
 //BA.debugLineNum = 983052;BA.debugLine="Contador=-1";
_contador = (int) (-1);
RDebugUtils.currentLine=983053;
 //BA.debugLineNum = 983053;BA.debugLine="Do While Sale=False";
while (_sale==anywheresoftware.b4a.keywords.Common.False) {
RDebugUtils.currentLine=983054;
 //BA.debugLineNum = 983054;BA.debugLine="Contador=Contador+1";
_contador = (int) (_contador+1);
RDebugUtils.currentLine=983055;
 //BA.debugLineNum = 983055;BA.debugLine="Select Contador";
switch (_contador) {
case 0: {
RDebugUtils.currentLine=983057;
 //BA.debugLineNum = 983057;BA.debugLine="NombreEvento=cantidades(Contador)";
_nombreevento = _cantidades[_contador];
 break; }
case 1: {
RDebugUtils.currentLine=983059;
 //BA.debugLineNum = 983059;BA.debugLine="FechaEvento=cantidades(Contador)";
_fechaevento = _cantidades[_contador];
 break; }
case 2: {
RDebugUtils.currentLine=983061;
 //BA.debugLineNum = 983061;BA.debugLine="HoraEvento=cantidades(Contador)";
_horaevento = _cantidades[_contador];
 break; }
case 3: {
RDebugUtils.currentLine=983063;
 //BA.debugLineNum = 983063;BA.debugLine="TipoEvento=cantidades(Contador)";
_tipoevento = _cantidades[_contador];
 break; }
case 4: {
RDebugUtils.currentLine=983065;
 //BA.debugLineNum = 983065;BA.debugLine="NombreDocumento=cantidades(Contador)";
_nombredocumento = _cantidades[_contador];
 break; }
case 5: {
RDebugUtils.currentLine=983067;
 //BA.debugLineNum = 983067;BA.debugLine="Conferencista=cantidades(Contador)";
_conferencista = _cantidades[_contador];
 break; }
case 6: {
RDebugUtils.currentLine=983069;
 //BA.debugLineNum = 983069;BA.debugLine="Grupos=Regex.Split(\";\",cantidades(Contador))";
_grupos = anywheresoftware.b4a.keywords.Common.Regex.Split(";",_cantidades[_contador]);
RDebugUtils.currentLine=983070;
 //BA.debugLineNum = 983070;BA.debugLine="Sale=True";
_sale = anywheresoftware.b4a.keywords.Common.True;
 break; }
}
;
 }
;
RDebugUtils.currentLine=983073;
 //BA.debugLineNum = 983073;BA.debugLine="Sale=False";
_sale = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=983074;
 //BA.debugLineNum = 983074;BA.debugLine="Contador=-1";
_contador = (int) (-1);
RDebugUtils.currentLine=983075;
 //BA.debugLineNum = 983075;BA.debugLine="DetallesEventos.Text=\"El evento \"&NombreEvento&\"";
mostCurrent._detalleseventos.setText(BA.ObjectToCharSequence("El evento "+_nombreevento+" sera el dia "+_fechaevento+" a las "+_horaevento+" sera un evento de "+_tipoevento+" el documento es "+_nombredocumento+" el conferencista sera "+_conferencista+" y los grupos implicados seran "+anywheresoftware.b4a.keywords.Common.CRLF));
RDebugUtils.currentLine=983076;
 //BA.debugLineNum = 983076;BA.debugLine="Do While Sale=False";
while (_sale==anywheresoftware.b4a.keywords.Common.False) {
RDebugUtils.currentLine=983077;
 //BA.debugLineNum = 983077;BA.debugLine="Try";
try {RDebugUtils.currentLine=983078;
 //BA.debugLineNum = 983078;BA.debugLine="Contador=Contador+1";
_contador = (int) (_contador+1);
RDebugUtils.currentLine=983079;
 //BA.debugLineNum = 983079;BA.debugLine="DetallesEventos.Text=DetallesEventos.Text&Grup";
mostCurrent._detalleseventos.setText(BA.ObjectToCharSequence(mostCurrent._detalleseventos.getText()+_grupos[_contador]+anywheresoftware.b4a.keywords.Common.CRLF));
 } 
       catch (Exception e40) {
			processBA.setLastException(e40);RDebugUtils.currentLine=983081;
 //BA.debugLineNum = 983081;BA.debugLine="Sale=True";
_sale = anywheresoftware.b4a.keywords.Common.True;
 };
 }
;
 };
RDebugUtils.currentLine=983087;
 //BA.debugLineNum = 983087;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="StartActivity(\"CrearEvento\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("CrearEvento"));
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="End Sub";
return "";
}
}