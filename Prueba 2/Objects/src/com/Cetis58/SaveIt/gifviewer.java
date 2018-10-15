package com.Cetis58.SaveIt;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class gifviewer extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.Cetis58.SaveIt.gifviewer");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.Cetis58.SaveIt.gifviewer.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _meventname = "";
public Object _mcallback = null;
public anywheresoftware.b4a.objects.PanelWrapper _mbase = null;
public int _defaultcolorconstant = 0;
public int _workindex = 0;
public int _bdgravity = 0;
public anywheresoftware.b4a.objects.collections.List _bitmaps = null;
public com.Cetis58.SaveIt.main _main = null;
public com.Cetis58.SaveIt.starter _starter = null;
public com.Cetis58.SaveIt.principal _principal = null;
public com.Cetis58.SaveIt.crearevento _crearevento = null;
public com.Cetis58.SaveIt.seleccionargrupos _seleccionargrupos = null;
public static class _bitmapanddelay{
public boolean IsInitialized;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper bmp;
public int Delay;
public void Initialize() {
IsInitialized = true;
bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
Delay = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public String  _callfromresume() throws Exception{
 //BA.debugLineNum = 62;BA.debugLine="Public Sub CallFromResume";
 //BA.debugLineNum = 63;BA.debugLine="If mBase.Visible Then Start";
if (_mbase.getVisible()) { 
_start();};
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 4;BA.debugLine="Private mEventName As String 'ignore";
_meventname = "";
 //BA.debugLineNum = 5;BA.debugLine="Private mCallBack As Object 'ignore";
_mcallback = new Object();
 //BA.debugLineNum = 6;BA.debugLine="Private mBase As Panel";
_mbase = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 7;BA.debugLine="Private Const DefaultColorConstant As Int = -9848";
_defaultcolorconstant = (int) (-984833);
 //BA.debugLineNum = 8;BA.debugLine="Private WorkIndex As Int";
_workindex = 0;
 //BA.debugLineNum = 9;BA.debugLine="Private BDGravity As Int";
_bdgravity = 0;
 //BA.debugLineNum = 10;BA.debugLine="Private bitmaps As List";
_bitmaps = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 11;BA.debugLine="Type BitmapAndDelay (bmp As Bitmap, Delay As Int)";
;
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(anywheresoftware.b4a.objects.PanelWrapper _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 19;BA.debugLine="Public Sub DesignerCreateView (Base As Panel, Lbl";
 //BA.debugLineNum = 20;BA.debugLine="mBase = Base";
_mbase = _base;
 //BA.debugLineNum = 21;BA.debugLine="mBase.Visible = False";
_mbase.setVisible(__c.False);
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.PanelWrapper  _getbase() throws Exception{
 //BA.debugLineNum = 79;BA.debugLine="Public Sub GetBase As Panel";
 //BA.debugLineNum = 80;BA.debugLine="Return mBase";
if (true) return _mbase;
 //BA.debugLineNum = 81;BA.debugLine="End Sub";
return null;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 14;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 15;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 16;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public String  _setgif(String _dir,String _filename) throws Exception{
String _path = "";
anywheresoftware.b4a.agraham.gifdecoder.GifDecoder _gd = null;
int _i = 0;
com.Cetis58.SaveIt.gifviewer._bitmapanddelay _bd = null;
com.Cetis58.SaveIt.gifviewer._bitmapanddelay _firstframe = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _firstbmp = null;
 //BA.debugLineNum = 24;BA.debugLine="Public Sub SetGif (Dir As String, FileName As Stri";
 //BA.debugLineNum = 25;BA.debugLine="If Dir = File.DirAssets Then";
if ((_dir).equals(__c.File.getDirAssets())) { 
 //BA.debugLineNum = 26;BA.debugLine="File.Copy(File.DirAssets, FileName, File.DirInte";
__c.File.Copy(__c.File.getDirAssets(),_filename,__c.File.getDirInternal(),_filename);
 //BA.debugLineNum = 27;BA.debugLine="Dir = File.DirInternal";
_dir = __c.File.getDirInternal();
 };
 //BA.debugLineNum = 29;BA.debugLine="Dim path As String = File.Combine(Dir, FileName)";
_path = __c.File.Combine(_dir,_filename);
 //BA.debugLineNum = 30;BA.debugLine="Dim gd As GifDecoder";
_gd = new anywheresoftware.b4a.agraham.gifdecoder.GifDecoder();
 //BA.debugLineNum = 31;BA.debugLine="gd.Load(Dir, FileName)";
_gd.Load(_dir,_filename);
 //BA.debugLineNum = 32;BA.debugLine="bitmaps.Initialize";
_bitmaps.Initialize();
 //BA.debugLineNum = 33;BA.debugLine="For i = 0 To gd.FrameCount - 1";
{
final int step9 = 1;
final int limit9 = (int) (_gd.getFrameCount()-1);
_i = (int) (0) ;
for (;_i <= limit9 ;_i = _i + step9 ) {
 //BA.debugLineNum = 34;BA.debugLine="Dim bd As BitmapAndDelay";
_bd = new com.Cetis58.SaveIt.gifviewer._bitmapanddelay();
 //BA.debugLineNum = 35;BA.debugLine="bd.Initialize";
_bd.Initialize();
 //BA.debugLineNum = 36;BA.debugLine="bd.bmp = gd.Frame(i)";
_bd.bmp.setObject((android.graphics.Bitmap)(_gd.Frame(_i)));
 //BA.debugLineNum = 37;BA.debugLine="bd.Delay = gd.Delay(i)";
_bd.Delay = _gd.Delay(_i);
 //BA.debugLineNum = 38;BA.debugLine="bitmaps.Add(bd)";
_bitmaps.Add((Object)(_bd));
 }
};
 //BA.debugLineNum = 41;BA.debugLine="Dim FirstFrame As BitmapAndDelay = bitmaps.Get(0)";
_firstframe = (com.Cetis58.SaveIt.gifviewer._bitmapanddelay)(_bitmaps.Get((int) (0)));
 //BA.debugLineNum = 42;BA.debugLine="Dim FirstBmp As Bitmap = FirstFrame.bmp";
_firstbmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_firstbmp = _firstframe.bmp;
 //BA.debugLineNum = 43;BA.debugLine="If FirstBmp.Width < mBase.Width Or FirstBmp.Heigh";
if (_firstbmp.getWidth()<_mbase.getWidth() || _firstbmp.getHeight()<_mbase.getHeight()) { 
 //BA.debugLineNum = 44;BA.debugLine="BDGravity = Gravity.CENTER";
_bdgravity = __c.Gravity.CENTER;
 }else {
 //BA.debugLineNum = 46;BA.debugLine="BDGravity = Gravity.FILL";
_bdgravity = __c.Gravity.FILL;
 };
 //BA.debugLineNum = 49;BA.debugLine="End Sub";
return "";
}
public void  _showimpl(int _myworkindex) throws Exception{
ResumableSub_ShowImpl rsub = new ResumableSub_ShowImpl(this,_myworkindex);
rsub.resume(ba, null);
}
public static class ResumableSub_ShowImpl extends BA.ResumableSub {
public ResumableSub_ShowImpl(com.Cetis58.SaveIt.gifviewer parent,int _myworkindex) {
this.parent = parent;
this._myworkindex = _myworkindex;
}
com.Cetis58.SaveIt.gifviewer parent;
int _myworkindex;
int _frameindex = 0;
anywheresoftware.b4a.objects.drawable.BitmapDrawable _bdrawable = null;
com.Cetis58.SaveIt.gifviewer._bitmapanddelay _bd = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 67;BA.debugLine="Dim FrameIndex As Int = 0";
_frameindex = (int) (0);
 //BA.debugLineNum = 68;BA.debugLine="Do While MyWorkIndex = WorkIndex";
if (true) break;

case 1:
//do while
this.state = 4;
while (_myworkindex==parent._workindex) {
this.state = 3;
if (true) break;
}
if (true) break;

case 3:
//C
this.state = 1;
 //BA.debugLineNum = 69;BA.debugLine="FrameIndex = (FrameIndex + 1) Mod bitmaps.Size";
_frameindex = (int) ((_frameindex+1)%parent._bitmaps.getSize());
 //BA.debugLineNum = 70;BA.debugLine="Dim bdrawable As BitmapDrawable";
_bdrawable = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 71;BA.debugLine="Dim bd As BitmapAndDelay = bitmaps.Get(FrameInde";
_bd = (com.Cetis58.SaveIt.gifviewer._bitmapanddelay)(parent._bitmaps.Get(_frameindex));
 //BA.debugLineNum = 72;BA.debugLine="bdrawable.Initialize(bd.bmp)";
_bdrawable.Initialize((android.graphics.Bitmap)(_bd.bmp.getObject()));
 //BA.debugLineNum = 73;BA.debugLine="bdrawable.Gravity = BDGravity";
_bdrawable.setGravity(parent._bdgravity);
 //BA.debugLineNum = 74;BA.debugLine="mBase.Background = bdrawable";
parent._mbase.setBackground((android.graphics.drawable.Drawable)(_bdrawable.getObject()));
 //BA.debugLineNum = 75;BA.debugLine="Sleep(bd.Delay)";
parent.__c.Sleep(ba,this,_bd.Delay);
this.state = 5;
return;
case 5:
//C
this.state = 1;
;
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 77;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _start() throws Exception{
 //BA.debugLineNum = 51;BA.debugLine="Public Sub Start";
 //BA.debugLineNum = 52;BA.debugLine="mBase.Visible = True";
_mbase.setVisible(__c.True);
 //BA.debugLineNum = 53;BA.debugLine="WorkIndex = WorkIndex + 1";
_workindex = (int) (_workindex+1);
 //BA.debugLineNum = 54;BA.debugLine="ShowImpl(WorkIndex)";
_showimpl(_workindex);
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return "";
}
public String  _stop() throws Exception{
 //BA.debugLineNum = 57;BA.debugLine="Public Sub Stop";
 //BA.debugLineNum = 58;BA.debugLine="mBase.Visible = False";
_mbase.setVisible(__c.False);
 //BA.debugLineNum = 59;BA.debugLine="WorkIndex = WorkIndex + 1";
_workindex = (int) (_workindex+1);
 //BA.debugLineNum = 60;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
