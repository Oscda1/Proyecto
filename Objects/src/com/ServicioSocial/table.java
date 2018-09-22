package com.ServicioSocial;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class table extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "com.ServicioSocial.table");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.ServicioSocial.table.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public static class _rowcol{
public boolean IsInitialized;
public int Row;
public int Col;
public void Initialize() {
IsInitialized = true;
Row = 0;
Col = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.StringUtils _stringutils1 = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _sv = null;
public anywheresoftware.b4a.objects.PanelWrapper _header = null;
public Object _callback = null;
public String _event = "";
public int _selectedrow = 0;
public anywheresoftware.b4a.objects.collections.List _data = null;
public anywheresoftware.b4a.objects.collections.List _labelscache = null;
public int _minvisiblerow = 0;
public int _maxvisiblerow = 0;
public boolean _visible = false;
public anywheresoftware.b4a.objects.collections.Map _visiblerows = null;
public int _numberofcolumns = 0;
public int _columnwidth = 0;
public int _rowheight = 0;
public int _headercolor = 0;
public int _tablecolor = 0;
public int _fontcolor = 0;
public int _headerfontcolor = 0;
public float _fontsize = 0f;
public int _alignment = 0;
public Object[] _selecteddrawable = null;
public Object[] _drawable1 = null;
public Object[] _drawable2 = null;
public com.ServicioSocial.main _main = null;
public com.ServicioSocial.starter _starter = null;
public com.ServicioSocial.principal _principal = null;
public com.ServicioSocial.crearevento _crearevento = null;
public com.ServicioSocial.confhorarios _confhorarios = null;
public com.ServicioSocial.seleccionargrupos _seleccionargrupos = null;
public String  _addrow(com.ServicioSocial.table __ref,String[] _values) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "addrow"))
	 {return ((String) Debug.delegate(ba, "addrow", new Object[] {_values}));}
int _lastrow = 0;
RDebugUtils.currentLine=3342336;
 //BA.debugLineNum = 3342336;BA.debugLine="Public Sub AddRow(Values() As String)";
RDebugUtils.currentLine=3342337;
 //BA.debugLineNum = 3342337;BA.debugLine="If Values.Length <> NumberOfColumns Then";
if (_values.length!=__ref._numberofcolumns) { 
RDebugUtils.currentLine=3342338;
 //BA.debugLineNum = 3342338;BA.debugLine="Log(\"Wrong number of values.\")";
__c.Log("Wrong number of values.");
RDebugUtils.currentLine=3342339;
 //BA.debugLineNum = 3342339;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=3342341;
 //BA.debugLineNum = 3342341;BA.debugLine="Data.Add(Values)";
__ref._data.Add((Object)(_values));
RDebugUtils.currentLine=3342342;
 //BA.debugLineNum = 3342342;BA.debugLine="Dim lastRow As Int";
_lastrow = 0;
RDebugUtils.currentLine=3342343;
 //BA.debugLineNum = 3342343;BA.debugLine="lastRow = Data.Size - 1";
_lastrow = (int) (__ref._data.getSize()-1);
RDebugUtils.currentLine=3342344;
 //BA.debugLineNum = 3342344;BA.debugLine="If lastRow < (SV.ScrollPosition + SV.Height) / Ro";
if (_lastrow<(__ref._sv.getScrollPosition()+__ref._sv.getHeight())/(double)__ref._rowheight+1) { 
RDebugUtils.currentLine=3342345;
 //BA.debugLineNum = 3342345;BA.debugLine="ShowRow(lastRow)";
__ref._showrow(null,_lastrow);
 };
RDebugUtils.currentLine=3342347;
 //BA.debugLineNum = 3342347;BA.debugLine="SV.Panel.Height = Data.Size * RowHeight";
__ref._sv.getPanel().setHeight((int) (__ref._data.getSize()*__ref._rowheight));
RDebugUtils.currentLine=3342348;
 //BA.debugLineNum = 3342348;BA.debugLine="End Sub";
return "";
}
public String  _showrow(com.ServicioSocial.table __ref,int _row) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "showrow"))
	 {return ((String) Debug.delegate(ba, "showrow", new Object[] {_row}));}
anywheresoftware.b4a.objects.LabelWrapper[] _lbls = null;
String[] _values = null;
Object[] _rowcolor = null;
int _i = 0;
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Private Sub ShowRow(row As Int)";
RDebugUtils.currentLine=3473409;
 //BA.debugLineNum = 3473409;BA.debugLine="If visibleRows.ContainsKey(row) Then Return";
if (__ref._visiblerows.ContainsKey((Object)(_row))) { 
if (true) return "";};
RDebugUtils.currentLine=3473411;
 //BA.debugLineNum = 3473411;BA.debugLine="Dim lbls() As Label";
_lbls = new anywheresoftware.b4a.objects.LabelWrapper[(int) (0)];
{
int d0 = _lbls.length;
for (int i0 = 0;i0 < d0;i0++) {
_lbls[i0] = new anywheresoftware.b4a.objects.LabelWrapper();
}
}
;
RDebugUtils.currentLine=3473412;
 //BA.debugLineNum = 3473412;BA.debugLine="Dim values() As String";
_values = new String[(int) (0)];
java.util.Arrays.fill(_values,"");
RDebugUtils.currentLine=3473413;
 //BA.debugLineNum = 3473413;BA.debugLine="lbls = GetLabels(row)";
_lbls = __ref._getlabels(null,_row);
RDebugUtils.currentLine=3473414;
 //BA.debugLineNum = 3473414;BA.debugLine="values = Data.Get(row)";
_values = (String[])(__ref._data.Get(_row));
RDebugUtils.currentLine=3473415;
 //BA.debugLineNum = 3473415;BA.debugLine="visibleRows.Put(row, lbls)";
__ref._visiblerows.Put((Object)(_row),(Object)(_lbls));
RDebugUtils.currentLine=3473416;
 //BA.debugLineNum = 3473416;BA.debugLine="Dim rowColor() As Object";
_rowcolor = new Object[(int) (0)];
{
int d0 = _rowcolor.length;
for (int i0 = 0;i0 < d0;i0++) {
_rowcolor[i0] = new Object();
}
}
;
RDebugUtils.currentLine=3473417;
 //BA.debugLineNum = 3473417;BA.debugLine="If row = SelectedRow Then";
if (_row==__ref._selectedrow) { 
RDebugUtils.currentLine=3473418;
 //BA.debugLineNum = 3473418;BA.debugLine="rowColor = SelectedDrawable";
_rowcolor = __ref._selecteddrawable;
 }else 
{RDebugUtils.currentLine=3473419;
 //BA.debugLineNum = 3473419;BA.debugLine="Else If row Mod 2  = 0 Then";
if (_row%2==0) { 
RDebugUtils.currentLine=3473420;
 //BA.debugLineNum = 3473420;BA.debugLine="rowColor = Drawable1";
_rowcolor = __ref._drawable1;
 }else {
RDebugUtils.currentLine=3473422;
 //BA.debugLineNum = 3473422;BA.debugLine="rowColor = Drawable2";
_rowcolor = __ref._drawable2;
 }}
;
RDebugUtils.currentLine=3473424;
 //BA.debugLineNum = 3473424;BA.debugLine="For I = 0 To lbls.Length - 1";
{
final int step15 = 1;
final int limit15 = (int) (_lbls.length-1);
_i = (int) (0) ;
for (;_i <= limit15 ;_i = _i + step15 ) {
RDebugUtils.currentLine=3473425;
 //BA.debugLineNum = 3473425;BA.debugLine="SV.Panel.AddView(lbls(I), Header.GetView(I).Left";
__ref._sv.getPanel().AddView((android.view.View)(_lbls[_i].getObject()),__ref._header.GetView(_i).getLeft(),(int) (_row*__ref._rowheight),__ref._header.GetView(_i).getWidth(),(int) (__ref._rowheight-__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=3473427;
 //BA.debugLineNum = 3473427;BA.debugLine="lbls(I).Text = values(I)";
_lbls[_i].setText(BA.ObjectToCharSequence(_values[_i]));
RDebugUtils.currentLine=3473428;
 //BA.debugLineNum = 3473428;BA.debugLine="lbls(I).Background = rowColor(I)";
_lbls[_i].setBackground((android.graphics.drawable.Drawable)(_rowcolor[_i]));
 }
};
RDebugUtils.currentLine=3473430;
 //BA.debugLineNum = 3473430;BA.debugLine="End Sub";
return "";
}
public String  _addtoactivity(com.ServicioSocial.table __ref,anywheresoftware.b4a.objects.ActivityWrapper _act,int _left,int _top,int _width,int _height) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "addtoactivity"))
	 {return ((String) Debug.delegate(ba, "addtoactivity", new Object[] {_act,_left,_top,_width,_height}));}
RDebugUtils.currentLine=3276800;
 //BA.debugLineNum = 3276800;BA.debugLine="Public Sub AddToActivity(Act As Activity, Left As";
RDebugUtils.currentLine=3276801;
 //BA.debugLineNum = 3276801;BA.debugLine="visible = True";
__ref._visible = __c.True;
RDebugUtils.currentLine=3276802;
 //BA.debugLineNum = 3276802;BA.debugLine="Header.Initialize(\"\")";
__ref._header.Initialize(ba,"");
RDebugUtils.currentLine=3276803;
 //BA.debugLineNum = 3276803;BA.debugLine="Header.Color = TableColor";
__ref._header.setColor(__ref._tablecolor);
RDebugUtils.currentLine=3276804;
 //BA.debugLineNum = 3276804;BA.debugLine="Act.AddView(Header, Left, Top , Width, RowHeight)";
_act.AddView((android.view.View)(__ref._header.getObject()),_left,_top,_width,__ref._rowheight);
RDebugUtils.currentLine=3276805;
 //BA.debugLineNum = 3276805;BA.debugLine="Act.AddView(SV, Left, Top + RowHeight, Width, Hei";
_act.AddView((android.view.View)(__ref._sv.getObject()),_left,(int) (_top+__ref._rowheight),_width,(int) (_height-__ref._rowheight));
RDebugUtils.currentLine=3276806;
 //BA.debugLineNum = 3276806;BA.debugLine="ColumnWidth = SV.Width / NumberOfColumns";
__ref._columnwidth = (int) (__ref._sv.getWidth()/(double)__ref._numberofcolumns);
RDebugUtils.currentLine=3276808;
 //BA.debugLineNum = 3276808;BA.debugLine="SV_ScrollChanged(0)";
__ref._sv_scrollchanged(null,(int) (0));
RDebugUtils.currentLine=3276810;
 //BA.debugLineNum = 3276810;BA.debugLine="End Sub";
return "";
}
public String  _sv_scrollchanged(com.ServicioSocial.table __ref,int _position) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "sv_scrollchanged"))
	 {return ((String) Debug.delegate(ba, "sv_scrollchanged", new Object[] {_position}));}
int _currentmin = 0;
int _currentmax = 0;
int _i = 0;
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Private Sub SV_ScrollChanged(Position As Int)";
RDebugUtils.currentLine=3211265;
 //BA.debugLineNum = 3211265;BA.debugLine="Dim currentMin, currentMax As Int";
_currentmin = 0;
_currentmax = 0;
RDebugUtils.currentLine=3211266;
 //BA.debugLineNum = 3211266;BA.debugLine="currentMin = Max(0, Position / RowHeight - 30)";
_currentmin = (int) (__c.Max(0,_position/(double)__ref._rowheight-30));
RDebugUtils.currentLine=3211267;
 //BA.debugLineNum = 3211267;BA.debugLine="currentMax = Min(Data.Size - 1, (Position + SV.He";
_currentmax = (int) (__c.Min(__ref._data.getSize()-1,(_position+__ref._sv.getHeight())/(double)__ref._rowheight+30));
RDebugUtils.currentLine=3211268;
 //BA.debugLineNum = 3211268;BA.debugLine="If minVisibleRow > -1 Then";
if (__ref._minvisiblerow>-1) { 
RDebugUtils.currentLine=3211269;
 //BA.debugLineNum = 3211269;BA.debugLine="If minVisibleRow < currentMin Then";
if (__ref._minvisiblerow<_currentmin) { 
RDebugUtils.currentLine=3211271;
 //BA.debugLineNum = 3211271;BA.debugLine="For I = minVisibleRow To Min(currentMin - 1, ma";
{
final int step6 = 1;
final int limit6 = (int) (__c.Min(_currentmin-1,__ref._maxvisiblerow));
_i = __ref._minvisiblerow ;
for (;_i <= limit6 ;_i = _i + step6 ) {
RDebugUtils.currentLine=3211272;
 //BA.debugLineNum = 3211272;BA.debugLine="HideRow(I)";
__ref._hiderow(null,_i);
 }
};
 }else 
{RDebugUtils.currentLine=3211274;
 //BA.debugLineNum = 3211274;BA.debugLine="Else If minVisibleRow > currentMin Then";
if (__ref._minvisiblerow>_currentmin) { 
RDebugUtils.currentLine=3211276;
 //BA.debugLineNum = 3211276;BA.debugLine="For I = currentMin To Min(minVisibleRow - 1, cu";
{
final int step10 = 1;
final int limit10 = (int) (__c.Min(__ref._minvisiblerow-1,_currentmax));
_i = _currentmin ;
for (;_i <= limit10 ;_i = _i + step10 ) {
RDebugUtils.currentLine=3211277;
 //BA.debugLineNum = 3211277;BA.debugLine="ShowRow(I)";
__ref._showrow(null,_i);
 }
};
 }}
;
RDebugUtils.currentLine=3211280;
 //BA.debugLineNum = 3211280;BA.debugLine="If maxVisibleRow > currentMax Then";
if (__ref._maxvisiblerow>_currentmax) { 
RDebugUtils.currentLine=3211282;
 //BA.debugLineNum = 3211282;BA.debugLine="For I = maxVisibleRow To Max(currentMax + 1, mi";
{
final int step15 = -1;
final int limit15 = (int) (__c.Max(_currentmax+1,__ref._minvisiblerow));
_i = __ref._maxvisiblerow ;
for (;_i >= limit15 ;_i = _i + step15 ) {
RDebugUtils.currentLine=3211283;
 //BA.debugLineNum = 3211283;BA.debugLine="HideRow(I)";
__ref._hiderow(null,_i);
 }
};
 }else 
{RDebugUtils.currentLine=3211285;
 //BA.debugLineNum = 3211285;BA.debugLine="Else If maxVisibleRow < currentMax Then";
if (__ref._maxvisiblerow<_currentmax) { 
RDebugUtils.currentLine=3211287;
 //BA.debugLineNum = 3211287;BA.debugLine="For I = currentMax To Max(maxVisibleRow + 1, cu";
{
final int step19 = -1;
final int limit19 = (int) (__c.Max(__ref._maxvisiblerow+1,_currentmin));
_i = _currentmax ;
for (;_i >= limit19 ;_i = _i + step19 ) {
RDebugUtils.currentLine=3211288;
 //BA.debugLineNum = 3211288;BA.debugLine="ShowRow(I)";
__ref._showrow(null,_i);
 }
};
 }}
;
 };
RDebugUtils.currentLine=3211292;
 //BA.debugLineNum = 3211292;BA.debugLine="minVisibleRow = currentMin";
__ref._minvisiblerow = _currentmin;
RDebugUtils.currentLine=3211293;
 //BA.debugLineNum = 3211293;BA.debugLine="maxVisibleRow = currentMax";
__ref._maxvisiblerow = _currentmax;
RDebugUtils.currentLine=3211294;
 //BA.debugLineNum = 3211294;BA.debugLine="End Sub";
return "";
}
public String  _cell_click(com.ServicioSocial.table __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "cell_click"))
	 {return ((String) Debug.delegate(ba, "cell_click", null));}
com.ServicioSocial.table._rowcol _rc = null;
anywheresoftware.b4a.objects.LabelWrapper _l = null;
RDebugUtils.currentLine=3866624;
 //BA.debugLineNum = 3866624;BA.debugLine="Private Sub Cell_Click";
RDebugUtils.currentLine=3866625;
 //BA.debugLineNum = 3866625;BA.debugLine="Dim rc As RowCol";
_rc = new com.ServicioSocial.table._rowcol();
RDebugUtils.currentLine=3866626;
 //BA.debugLineNum = 3866626;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3866627;
 //BA.debugLineNum = 3866627;BA.debugLine="l = Sender";
_l.setObject((android.widget.TextView)(__c.Sender(ba)));
RDebugUtils.currentLine=3866628;
 //BA.debugLineNum = 3866628;BA.debugLine="rc = l.Tag";
_rc = (com.ServicioSocial.table._rowcol)(_l.getTag());
RDebugUtils.currentLine=3866629;
 //BA.debugLineNum = 3866629;BA.debugLine="SelectRow(rc.Row)";
__ref._selectrow(null,_rc.Row);
RDebugUtils.currentLine=3866630;
 //BA.debugLineNum = 3866630;BA.debugLine="If SubExists(Callback, Event & \"_CellClick\") Then";
if (__c.SubExists(ba,__ref._callback,__ref._event+"_CellClick")) { 
RDebugUtils.currentLine=3866631;
 //BA.debugLineNum = 3866631;BA.debugLine="CallSub3(Callback, Event & \"_CellClick\", rc.Col,";
__c.CallSubNew3(ba,__ref._callback,__ref._event+"_CellClick",(Object)(_rc.Col),(Object)(_rc.Row));
 };
RDebugUtils.currentLine=3866633;
 //BA.debugLineNum = 3866633;BA.debugLine="End Sub";
return "";
}
public String  _selectrow(com.ServicioSocial.table __ref,int _row) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "selectrow"))
	 {return ((String) Debug.delegate(ba, "selectrow", new Object[] {_row}));}
int _prev = 0;
int _col = 0;
RDebugUtils.currentLine=4128768;
 //BA.debugLineNum = 4128768;BA.debugLine="Private Sub SelectRow(Row As Int)";
RDebugUtils.currentLine=4128769;
 //BA.debugLineNum = 4128769;BA.debugLine="Dim prev As Int";
_prev = 0;
RDebugUtils.currentLine=4128770;
 //BA.debugLineNum = 4128770;BA.debugLine="prev = SelectedRow";
_prev = __ref._selectedrow;
RDebugUtils.currentLine=4128771;
 //BA.debugLineNum = 4128771;BA.debugLine="SelectedRow = Row";
__ref._selectedrow = _row;
RDebugUtils.currentLine=4128773;
 //BA.debugLineNum = 4128773;BA.debugLine="If prev > -1 Then";
if (_prev>-1) { 
RDebugUtils.currentLine=4128774;
 //BA.debugLineNum = 4128774;BA.debugLine="If visibleRows.ContainsKey(prev) Then";
if (__ref._visiblerows.ContainsKey((Object)(_prev))) { 
RDebugUtils.currentLine=4128775;
 //BA.debugLineNum = 4128775;BA.debugLine="HideRow(prev)";
__ref._hiderow(null,_prev);
RDebugUtils.currentLine=4128776;
 //BA.debugLineNum = 4128776;BA.debugLine="ShowRow(prev)";
__ref._showrow(null,_prev);
 };
 };
RDebugUtils.currentLine=4128779;
 //BA.debugLineNum = 4128779;BA.debugLine="SelectedRow = Row";
__ref._selectedrow = _row;
RDebugUtils.currentLine=4128780;
 //BA.debugLineNum = 4128780;BA.debugLine="For col = 0 To NumberOfColumns - 1";
{
final int step11 = 1;
final int limit11 = (int) (__ref._numberofcolumns-1);
_col = (int) (0) ;
for (;_col <= limit11 ;_col = _col + step11 ) {
RDebugUtils.currentLine=4128781;
 //BA.debugLineNum = 4128781;BA.debugLine="If visibleRows.ContainsKey(SelectedRow) Then";
if (__ref._visiblerows.ContainsKey((Object)(__ref._selectedrow))) { 
RDebugUtils.currentLine=4128782;
 //BA.debugLineNum = 4128782;BA.debugLine="HideRow(SelectedRow)";
__ref._hiderow(null,__ref._selectedrow);
RDebugUtils.currentLine=4128783;
 //BA.debugLineNum = 4128783;BA.debugLine="ShowRow(SelectedRow)";
__ref._showrow(null,__ref._selectedrow);
 };
 }
};
RDebugUtils.currentLine=4128786;
 //BA.debugLineNum = 4128786;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(com.ServicioSocial.table __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="Private StringUtils1 As StringUtils";
_stringutils1 = new anywheresoftware.b4a.objects.StringUtils();
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="Private SV As ScrollView";
_sv = new anywheresoftware.b4a.objects.ScrollViewWrapper();
RDebugUtils.currentLine=2883587;
 //BA.debugLineNum = 2883587;BA.debugLine="Public Header As Panel";
_header = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2883588;
 //BA.debugLineNum = 2883588;BA.debugLine="Private Callback As Object";
_callback = new Object();
RDebugUtils.currentLine=2883589;
 //BA.debugLineNum = 2883589;BA.debugLine="Private Event As String";
_event = "";
RDebugUtils.currentLine=2883590;
 //BA.debugLineNum = 2883590;BA.debugLine="Private SelectedRow As Int";
_selectedrow = 0;
RDebugUtils.currentLine=2883591;
 //BA.debugLineNum = 2883591;BA.debugLine="Private Data As List";
_data = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2883592;
 //BA.debugLineNum = 2883592;BA.debugLine="Private LabelsCache As List";
_labelscache = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2883593;
 //BA.debugLineNum = 2883593;BA.debugLine="Private minVisibleRow, maxVisibleRow As Int";
_minvisiblerow = 0;
_maxvisiblerow = 0;
RDebugUtils.currentLine=2883594;
 //BA.debugLineNum = 2883594;BA.debugLine="Private visible As Boolean";
_visible = false;
RDebugUtils.currentLine=2883595;
 //BA.debugLineNum = 2883595;BA.debugLine="Private visibleRows As Map";
_visiblerows = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=2883596;
 //BA.debugLineNum = 2883596;BA.debugLine="Public NumberOfColumns, ColumnWidth As Int";
_numberofcolumns = 0;
_columnwidth = 0;
RDebugUtils.currentLine=2883597;
 //BA.debugLineNum = 2883597;BA.debugLine="Public RowHeight, HeaderColor, TableColor, FontCo";
_rowheight = 0;
_headercolor = 0;
_tablecolor = 0;
_fontcolor = 0;
_headerfontcolor = 0;
RDebugUtils.currentLine=2883598;
 //BA.debugLineNum = 2883598;BA.debugLine="Public FontSize As Float";
_fontsize = 0f;
RDebugUtils.currentLine=2883599;
 //BA.debugLineNum = 2883599;BA.debugLine="Type RowCol (Row As Int, Col As Int)";
;
RDebugUtils.currentLine=2883600;
 //BA.debugLineNum = 2883600;BA.debugLine="Public Alignment As Int";
_alignment = 0;
RDebugUtils.currentLine=2883601;
 //BA.debugLineNum = 2883601;BA.debugLine="Public SelectedDrawable(), Drawable1(), Drawable2";
_selecteddrawable = new Object[(int) (0)];
{
int d0 = _selecteddrawable.length;
for (int i0 = 0;i0 < d0;i0++) {
_selecteddrawable[i0] = new Object();
}
}
;
_drawable1 = new Object[(int) (0)];
{
int d0 = _drawable1.length;
for (int i0 = 0;i0 < d0;i0++) {
_drawable1[i0] = new Object();
}
}
;
_drawable2 = new Object[(int) (0)];
{
int d0 = _drawable2.length;
for (int i0 = 0;i0 < d0;i0++) {
_drawable2[i0] = new Object();
}
}
;
RDebugUtils.currentLine=2883603;
 //BA.debugLineNum = 2883603;BA.debugLine="HeaderColor = Colors.Gray";
__ref._headercolor = __c.Colors.Gray;
RDebugUtils.currentLine=2883604;
 //BA.debugLineNum = 2883604;BA.debugLine="RowHeight = 30dip";
__ref._rowheight = __c.DipToCurrent((int) (30));
RDebugUtils.currentLine=2883605;
 //BA.debugLineNum = 2883605;BA.debugLine="TableColor = Colors.LightGray";
__ref._tablecolor = __c.Colors.LightGray;
RDebugUtils.currentLine=2883606;
 //BA.debugLineNum = 2883606;BA.debugLine="FontColor = Colors.Black";
__ref._fontcolor = __c.Colors.Black;
RDebugUtils.currentLine=2883607;
 //BA.debugLineNum = 2883607;BA.debugLine="HeaderFontColor = Colors.White";
__ref._headerfontcolor = __c.Colors.White;
RDebugUtils.currentLine=2883608;
 //BA.debugLineNum = 2883608;BA.debugLine="FontSize = 14";
__ref._fontsize = (float) (14);
RDebugUtils.currentLine=2883609;
 //BA.debugLineNum = 2883609;BA.debugLine="Alignment = Gravity.CENTER 'change to Gravity.LEF";
__ref._alignment = __c.Gravity.CENTER;
RDebugUtils.currentLine=2883610;
 //BA.debugLineNum = 2883610;BA.debugLine="End Sub";
return "";
}
public String  _clearall(com.ServicioSocial.table __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "clearall"))
	 {return ((String) Debug.delegate(ba, "clearall", null));}
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Public Sub ClearAll";
RDebugUtils.currentLine=3014657;
 //BA.debugLineNum = 3014657;BA.debugLine="innerClearAll(NumberOfColumns)";
__ref._innerclearall(null,__ref._numberofcolumns);
RDebugUtils.currentLine=3014658;
 //BA.debugLineNum = 3014658;BA.debugLine="End Sub";
return "";
}
public String  _innerclearall(com.ServicioSocial.table __ref,int _vnumberofcolumns) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "innerclearall"))
	 {return ((String) Debug.delegate(ba, "innerclearall", new Object[] {_vnumberofcolumns}));}
int _i = 0;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd1 = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd2 = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd3 = null;
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Private Sub innerClearAll(vNumberOfColumns As Int)";
RDebugUtils.currentLine=3145729;
 //BA.debugLineNum = 3145729;BA.debugLine="For i = SV.Panel.NumberOfViews -1 To 0 Step -1";
{
final int step1 = -1;
final int limit1 = (int) (0);
_i = (int) (__ref._sv.getPanel().getNumberOfViews()-1) ;
for (;_i >= limit1 ;_i = _i + step1 ) {
RDebugUtils.currentLine=3145730;
 //BA.debugLineNum = 3145730;BA.debugLine="SV.Panel.RemoveViewAt(i)";
__ref._sv.getPanel().RemoveViewAt(_i);
 }
};
RDebugUtils.currentLine=3145732;
 //BA.debugLineNum = 3145732;BA.debugLine="NumberOfColumns = vNumberOfColumns";
__ref._numberofcolumns = _vnumberofcolumns;
RDebugUtils.currentLine=3145733;
 //BA.debugLineNum = 3145733;BA.debugLine="Dim Drawable1(NumberOfColumns) As Object";
_drawable1 = new Object[__ref._numberofcolumns];
{
int d0 = _drawable1.length;
for (int i0 = 0;i0 < d0;i0++) {
_drawable1[i0] = new Object();
}
}
;
RDebugUtils.currentLine=3145734;
 //BA.debugLineNum = 3145734;BA.debugLine="Dim Drawable2(NumberOfColumns) As Object";
_drawable2 = new Object[__ref._numberofcolumns];
{
int d0 = _drawable2.length;
for (int i0 = 0;i0 < d0;i0++) {
_drawable2[i0] = new Object();
}
}
;
RDebugUtils.currentLine=3145735;
 //BA.debugLineNum = 3145735;BA.debugLine="Dim SelectedDrawable(NumberOfColumns) As Object";
_selecteddrawable = new Object[__ref._numberofcolumns];
{
int d0 = _selecteddrawable.length;
for (int i0 = 0;i0 < d0;i0++) {
_selecteddrawable[i0] = new Object();
}
}
;
RDebugUtils.currentLine=3145736;
 //BA.debugLineNum = 3145736;BA.debugLine="For i = 0 To NumberOfColumns - 1";
{
final int step8 = 1;
final int limit8 = (int) (__ref._numberofcolumns-1);
_i = (int) (0) ;
for (;_i <= limit8 ;_i = _i + step8 ) {
RDebugUtils.currentLine=3145737;
 //BA.debugLineNum = 3145737;BA.debugLine="Dim cd1, cd2, cd3 As ColorDrawable";
_cd1 = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
_cd2 = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
_cd3 = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=3145738;
 //BA.debugLineNum = 3145738;BA.debugLine="cd1.Initialize(Colors.White, 0)";
_cd1.Initialize(__c.Colors.White,(int) (0));
RDebugUtils.currentLine=3145739;
 //BA.debugLineNum = 3145739;BA.debugLine="cd2.Initialize(0xFF98F5FF, 0)";
_cd2.Initialize((int) (0xff98f5ff),(int) (0));
RDebugUtils.currentLine=3145740;
 //BA.debugLineNum = 3145740;BA.debugLine="cd3.Initialize(0xFF007FFF, 0)";
_cd3.Initialize((int) (0xff007fff),(int) (0));
RDebugUtils.currentLine=3145741;
 //BA.debugLineNum = 3145741;BA.debugLine="Drawable1(i) = cd1";
__ref._drawable1[_i] = (Object)(_cd1.getObject());
RDebugUtils.currentLine=3145742;
 //BA.debugLineNum = 3145742;BA.debugLine="Drawable2(i) = cd2";
__ref._drawable2[_i] = (Object)(_cd2.getObject());
RDebugUtils.currentLine=3145743;
 //BA.debugLineNum = 3145743;BA.debugLine="SelectedDrawable(i) = cd3";
__ref._selecteddrawable[_i] = (Object)(_cd3.getObject());
 }
};
RDebugUtils.currentLine=3145745;
 //BA.debugLineNum = 3145745;BA.debugLine="SV.Panel.Height = 0";
__ref._sv.getPanel().setHeight((int) (0));
RDebugUtils.currentLine=3145746;
 //BA.debugLineNum = 3145746;BA.debugLine="SelectedRow = -1";
__ref._selectedrow = (int) (-1);
RDebugUtils.currentLine=3145747;
 //BA.debugLineNum = 3145747;BA.debugLine="minVisibleRow = -1";
__ref._minvisiblerow = (int) (-1);
RDebugUtils.currentLine=3145748;
 //BA.debugLineNum = 3145748;BA.debugLine="maxVisibleRow = 0";
__ref._maxvisiblerow = (int) (0);
RDebugUtils.currentLine=3145749;
 //BA.debugLineNum = 3145749;BA.debugLine="Data.Initialize";
__ref._data.Initialize();
RDebugUtils.currentLine=3145750;
 //BA.debugLineNum = 3145750;BA.debugLine="LabelsCache.Initialize";
__ref._labelscache.Initialize();
RDebugUtils.currentLine=3145751;
 //BA.debugLineNum = 3145751;BA.debugLine="visibleRows.Initialize";
__ref._visiblerows.Initialize();
RDebugUtils.currentLine=3145752;
 //BA.debugLineNum = 3145752;BA.debugLine="SV.ScrollPosition = 0";
__ref._sv.setScrollPosition((int) (0));
RDebugUtils.currentLine=3145753;
 //BA.debugLineNum = 3145753;BA.debugLine="DoEvents";
__c.DoEvents();
RDebugUtils.currentLine=3145754;
 //BA.debugLineNum = 3145754;BA.debugLine="SV.ScrollPosition = 0";
__ref._sv.setScrollPosition((int) (0));
RDebugUtils.currentLine=3145755;
 //BA.debugLineNum = 3145755;BA.debugLine="For i = 1 To 80 'fill the cache to avoid delay on";
{
final int step27 = 1;
final int limit27 = (int) (80);
_i = (int) (1) ;
for (;_i <= limit27 ;_i = _i + step27 ) {
RDebugUtils.currentLine=3145756;
 //BA.debugLineNum = 3145756;BA.debugLine="LabelsCache.Add(CreateNewLabels)";
__ref._labelscache.Add((Object)(__ref._createnewlabels(null)));
 }
};
RDebugUtils.currentLine=3145758;
 //BA.debugLineNum = 3145758;BA.debugLine="If visible Then";
if (__ref._visible) { 
RDebugUtils.currentLine=3145759;
 //BA.debugLineNum = 3145759;BA.debugLine="SV_ScrollChanged(0)";
__ref._sv_scrollchanged(null,(int) (0));
 };
RDebugUtils.currentLine=3145761;
 //BA.debugLineNum = 3145761;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.LabelWrapper[]  _createnewlabels(com.ServicioSocial.table __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "createnewlabels"))
	 {return ((anywheresoftware.b4a.objects.LabelWrapper[]) Debug.delegate(ba, "createnewlabels", null));}
anywheresoftware.b4a.objects.LabelWrapper[] _lbls = null;
int _i = 0;
com.ServicioSocial.table._rowcol _rc = null;
anywheresoftware.b4a.objects.LabelWrapper _l = null;
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Private Sub CreateNewLabels As Label()";
RDebugUtils.currentLine=3735553;
 //BA.debugLineNum = 3735553;BA.debugLine="Dim lbls(NumberOfColumns) As Label";
_lbls = new anywheresoftware.b4a.objects.LabelWrapper[__ref._numberofcolumns];
{
int d0 = _lbls.length;
for (int i0 = 0;i0 < d0;i0++) {
_lbls[i0] = new anywheresoftware.b4a.objects.LabelWrapper();
}
}
;
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="For I = 0 To NumberOfColumns - 1";
{
final int step2 = 1;
final int limit2 = (int) (__ref._numberofcolumns-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
RDebugUtils.currentLine=3735555;
 //BA.debugLineNum = 3735555;BA.debugLine="Dim rc As RowCol";
_rc = new com.ServicioSocial.table._rowcol();
RDebugUtils.currentLine=3735556;
 //BA.debugLineNum = 3735556;BA.debugLine="rc.Col = I";
_rc.Col = _i;
RDebugUtils.currentLine=3735557;
 //BA.debugLineNum = 3735557;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3735558;
 //BA.debugLineNum = 3735558;BA.debugLine="l.Initialize(\"cell\")";
_l.Initialize(ba,"cell");
RDebugUtils.currentLine=3735559;
 //BA.debugLineNum = 3735559;BA.debugLine="l.Gravity = Alignment";
_l.setGravity(__ref._alignment);
RDebugUtils.currentLine=3735560;
 //BA.debugLineNum = 3735560;BA.debugLine="l.TextSize = FontSize";
_l.setTextSize(__ref._fontsize);
RDebugUtils.currentLine=3735561;
 //BA.debugLineNum = 3735561;BA.debugLine="l.TextColor = FontColor";
_l.setTextColor(__ref._fontcolor);
RDebugUtils.currentLine=3735562;
 //BA.debugLineNum = 3735562;BA.debugLine="l.Tag = rc";
_l.setTag((Object)(_rc));
RDebugUtils.currentLine=3735563;
 //BA.debugLineNum = 3735563;BA.debugLine="lbls(I) = l";
_lbls[_i] = _l;
 }
};
RDebugUtils.currentLine=3735565;
 //BA.debugLineNum = 3735565;BA.debugLine="Return lbls";
if (true) return _lbls;
RDebugUtils.currentLine=3735566;
 //BA.debugLineNum = 3735566;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.LabelWrapper[]  _getlabels(com.ServicioSocial.table __ref,int _row) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "getlabels"))
	 {return ((anywheresoftware.b4a.objects.LabelWrapper[]) Debug.delegate(ba, "getlabels", new Object[] {_row}));}
anywheresoftware.b4a.objects.LabelWrapper[] _lbls = null;
int _i = 0;
com.ServicioSocial.table._rowcol _rc = null;
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Private Sub GetLabels(Row As Int) As Label()";
RDebugUtils.currentLine=3670017;
 //BA.debugLineNum = 3670017;BA.debugLine="Dim lbls() As Label";
_lbls = new anywheresoftware.b4a.objects.LabelWrapper[(int) (0)];
{
int d0 = _lbls.length;
for (int i0 = 0;i0 < d0;i0++) {
_lbls[i0] = new anywheresoftware.b4a.objects.LabelWrapper();
}
}
;
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="If LabelsCache.Size > 0 Then";
if (__ref._labelscache.getSize()>0) { 
RDebugUtils.currentLine=3670020;
 //BA.debugLineNum = 3670020;BA.debugLine="lbls = LabelsCache.Get(LabelsCache.Size - 1)";
_lbls = (anywheresoftware.b4a.objects.LabelWrapper[])(__ref._labelscache.Get((int) (__ref._labelscache.getSize()-1)));
RDebugUtils.currentLine=3670021;
 //BA.debugLineNum = 3670021;BA.debugLine="LabelsCache.RemoveAt(LabelsCache.Size - 1)";
__ref._labelscache.RemoveAt((int) (__ref._labelscache.getSize()-1));
 }else {
RDebugUtils.currentLine=3670023;
 //BA.debugLineNum = 3670023;BA.debugLine="lbls = CreateNewLabels";
_lbls = __ref._createnewlabels(null);
 };
RDebugUtils.currentLine=3670025;
 //BA.debugLineNum = 3670025;BA.debugLine="For I = 0 To lbls.Length - 1";
{
final int step8 = 1;
final int limit8 = (int) (_lbls.length-1);
_i = (int) (0) ;
for (;_i <= limit8 ;_i = _i + step8 ) {
RDebugUtils.currentLine=3670026;
 //BA.debugLineNum = 3670026;BA.debugLine="Dim rc As RowCol";
_rc = new com.ServicioSocial.table._rowcol();
RDebugUtils.currentLine=3670027;
 //BA.debugLineNum = 3670027;BA.debugLine="rc = lbls(I).Tag";
_rc = (com.ServicioSocial.table._rowcol)(_lbls[_i].getTag());
RDebugUtils.currentLine=3670028;
 //BA.debugLineNum = 3670028;BA.debugLine="rc.Row = Row";
_rc.Row = _row;
 }
};
RDebugUtils.currentLine=3670030;
 //BA.debugLineNum = 3670030;BA.debugLine="Return lbls";
if (true) return _lbls;
RDebugUtils.currentLine=3670031;
 //BA.debugLineNum = 3670031;BA.debugLine="End Sub";
return null;
}
public String  _getvalue(com.ServicioSocial.table __ref,int _col,int _row) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "getvalue"))
	 {return ((String) Debug.delegate(ba, "getvalue", new Object[] {_col,_row}));}
String[] _values = null;
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Public Sub GetValue(Col As Int, Row As Int)";
RDebugUtils.currentLine=3997697;
 //BA.debugLineNum = 3997697;BA.debugLine="Dim values() As String";
_values = new String[(int) (0)];
java.util.Arrays.fill(_values,"");
RDebugUtils.currentLine=3997698;
 //BA.debugLineNum = 3997698;BA.debugLine="values = Data.Get(Row)";
_values = (String[])(__ref._data.Get(_row));
RDebugUtils.currentLine=3997699;
 //BA.debugLineNum = 3997699;BA.debugLine="Return values(Col)";
if (true) return _values[_col];
RDebugUtils.currentLine=3997700;
 //BA.debugLineNum = 3997700;BA.debugLine="End Sub";
return "";
}
public String  _header_click(com.ServicioSocial.table __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "header_click"))
	 {return ((String) Debug.delegate(ba, "header_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _l = null;
int _col = 0;
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Private Sub Header_Click";
RDebugUtils.currentLine=3932161;
 //BA.debugLineNum = 3932161;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="Dim col As Int";
_col = 0;
RDebugUtils.currentLine=3932163;
 //BA.debugLineNum = 3932163;BA.debugLine="l = Sender";
_l.setObject((android.widget.TextView)(__c.Sender(ba)));
RDebugUtils.currentLine=3932164;
 //BA.debugLineNum = 3932164;BA.debugLine="col = l.Tag";
_col = (int)(BA.ObjectToNumber(_l.getTag()));
RDebugUtils.currentLine=3932165;
 //BA.debugLineNum = 3932165;BA.debugLine="If SubExists(Callback, Event & \"_HeaderClick\") Th";
if (__c.SubExists(ba,__ref._callback,__ref._event+"_HeaderClick")) { 
RDebugUtils.currentLine=3932166;
 //BA.debugLineNum = 3932166;BA.debugLine="CallSub2(Callback, Event & \"_HeaderClick\", col)";
__c.CallSubNew2(ba,__ref._callback,__ref._event+"_HeaderClick",(Object)(_col));
 };
RDebugUtils.currentLine=3932168;
 //BA.debugLineNum = 3932168;BA.debugLine="End Sub";
return "";
}
public String  _hiderow(com.ServicioSocial.table __ref,int _row) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "hiderow"))
	 {return ((String) Debug.delegate(ba, "hiderow", new Object[] {_row}));}
anywheresoftware.b4a.objects.LabelWrapper[] _lbls = null;
int _i = 0;
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Private Sub HideRow (Row As Int)";
RDebugUtils.currentLine=3604482;
 //BA.debugLineNum = 3604482;BA.debugLine="Dim lbls() As Label";
_lbls = new anywheresoftware.b4a.objects.LabelWrapper[(int) (0)];
{
int d0 = _lbls.length;
for (int i0 = 0;i0 < d0;i0++) {
_lbls[i0] = new anywheresoftware.b4a.objects.LabelWrapper();
}
}
;
RDebugUtils.currentLine=3604483;
 //BA.debugLineNum = 3604483;BA.debugLine="lbls = visibleRows.Get(Row)";
_lbls = (anywheresoftware.b4a.objects.LabelWrapper[])(__ref._visiblerows.Get((Object)(_row)));
RDebugUtils.currentLine=3604484;
 //BA.debugLineNum = 3604484;BA.debugLine="If lbls = Null Then";
if (_lbls== null) { 
RDebugUtils.currentLine=3604485;
 //BA.debugLineNum = 3604485;BA.debugLine="Log(\"HideRow: (null) \" & Row)";
__c.Log("HideRow: (null) "+BA.NumberToString(_row));
RDebugUtils.currentLine=3604486;
 //BA.debugLineNum = 3604486;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=3604488;
 //BA.debugLineNum = 3604488;BA.debugLine="For I = 0 To lbls.Length - 1";
{
final int step7 = 1;
final int limit7 = (int) (_lbls.length-1);
_i = (int) (0) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
RDebugUtils.currentLine=3604489;
 //BA.debugLineNum = 3604489;BA.debugLine="lbls(I).RemoveView";
_lbls[_i].RemoveView();
 }
};
RDebugUtils.currentLine=3604491;
 //BA.debugLineNum = 3604491;BA.debugLine="visibleRows.Remove(Row)";
__ref._visiblerows.Remove((Object)(_row));
RDebugUtils.currentLine=3604492;
 //BA.debugLineNum = 3604492;BA.debugLine="LabelsCache.Add(lbls)";
__ref._labelscache.Add((Object)(_lbls));
RDebugUtils.currentLine=3604493;
 //BA.debugLineNum = 3604493;BA.debugLine="End Sub";
return "";
}
public String  _initialize(com.ServicioSocial.table __ref,anywheresoftware.b4a.BA _ba,Object _callbackmodule,String _eventname,int _vnumberofcolumns) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "initialize"))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_callbackmodule,_eventname,_vnumberofcolumns}));}
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Public Sub Initialize (CallbackModule As Object, E";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="SV.Initialize2(0, \"SV\")";
__ref._sv.Initialize2(ba,(int) (0),"SV");
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="SV.Panel.Color = TableColor";
__ref._sv.getPanel().setColor(__ref._tablecolor);
RDebugUtils.currentLine=2949123;
 //BA.debugLineNum = 2949123;BA.debugLine="Callback = CallbackModule";
__ref._callback = _callbackmodule;
RDebugUtils.currentLine=2949124;
 //BA.debugLineNum = 2949124;BA.debugLine="Event = EventName";
__ref._event = _eventname;
RDebugUtils.currentLine=2949125;
 //BA.debugLineNum = 2949125;BA.debugLine="innerClearAll(vNumberOfColumns)";
__ref._innerclearall(null,_vnumberofcolumns);
RDebugUtils.currentLine=2949126;
 //BA.debugLineNum = 2949126;BA.debugLine="End Sub";
return "";
}
public boolean  _isrowvisible(com.ServicioSocial.table __ref,int _row) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "isrowvisible"))
	 {return ((Boolean) Debug.delegate(ba, "isrowvisible", new Object[] {_row}));}
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Private Sub IsRowVisible(Row As Int) As Boolean";
RDebugUtils.currentLine=3538945;
 //BA.debugLineNum = 3538945;BA.debugLine="Return Row < (SV.ScrollPosition + SV.Height) / (R";
if (true) return _row<(__ref._sv.getScrollPosition()+__ref._sv.getHeight())/(double)(__ref._rowheight+1) && _row>__ref._sv.getScrollPosition()/(double)__ref._rowheight;
RDebugUtils.currentLine=3538947;
 //BA.debugLineNum = 3538947;BA.debugLine="End Sub";
return false;
}
public String  _jumptorow(com.ServicioSocial.table __ref,int _row) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "jumptorow"))
	 {return ((String) Debug.delegate(ba, "jumptorow", new Object[] {_row}));}
RDebugUtils.currentLine=4194304;
 //BA.debugLineNum = 4194304;BA.debugLine="Public Sub JumpToRow(Row As Int)";
RDebugUtils.currentLine=4194305;
 //BA.debugLineNum = 4194305;BA.debugLine="SV.ScrollPosition = Row * RowHeight";
__ref._sv.setScrollPosition((int) (_row*__ref._rowheight));
RDebugUtils.currentLine=4194306;
 //BA.debugLineNum = 4194306;BA.debugLine="End Sub";
return "";
}
public String  _loadtablefromcsv(com.ServicioSocial.table __ref,String _dir,String _filename,boolean _headersexist) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "loadtablefromcsv"))
	 {return ((String) Debug.delegate(ba, "loadtablefromcsv", new Object[] {_dir,_filename,_headersexist}));}
anywheresoftware.b4a.objects.collections.List _list1 = null;
String[] _h = null;
anywheresoftware.b4a.objects.collections.List _headers = null;
int _i = 0;
String[] _firstrow = null;
String[] _row = null;
RDebugUtils.currentLine=4259840;
 //BA.debugLineNum = 4259840;BA.debugLine="Public Sub LoadTableFromCSV(Dir As String, Filenam";
RDebugUtils.currentLine=4259842;
 //BA.debugLineNum = 4259842;BA.debugLine="Dim List1 As List";
_list1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=4259843;
 //BA.debugLineNum = 4259843;BA.debugLine="Dim h() As String";
_h = new String[(int) (0)];
java.util.Arrays.fill(_h,"");
RDebugUtils.currentLine=4259844;
 //BA.debugLineNum = 4259844;BA.debugLine="If HeadersExist Then";
if (_headersexist) { 
RDebugUtils.currentLine=4259845;
 //BA.debugLineNum = 4259845;BA.debugLine="Dim headers As List";
_headers = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=4259846;
 //BA.debugLineNum = 4259846;BA.debugLine="List1 = StringUtils1.LoadCSV2(Dir, Filename, \",\"";
_list1 = __ref._stringutils1.LoadCSV2(_dir,_filename,BA.ObjectToChar(","),_headers);
RDebugUtils.currentLine=4259847;
 //BA.debugLineNum = 4259847;BA.debugLine="Dim h(headers.Size) As String";
_h = new String[_headers.getSize()];
java.util.Arrays.fill(_h,"");
RDebugUtils.currentLine=4259848;
 //BA.debugLineNum = 4259848;BA.debugLine="For i = 0 To headers.Size - 1";
{
final int step7 = 1;
final int limit7 = (int) (_headers.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
RDebugUtils.currentLine=4259849;
 //BA.debugLineNum = 4259849;BA.debugLine="h(i) = headers.Get(i)";
_h[_i] = BA.ObjectToString(_headers.Get(_i));
 }
};
 }else {
RDebugUtils.currentLine=4259852;
 //BA.debugLineNum = 4259852;BA.debugLine="List1 = StringUtils1.LoadCSV(Dir, Filename, \",\")";
_list1 = __ref._stringutils1.LoadCSV(_dir,_filename,BA.ObjectToChar(","));
RDebugUtils.currentLine=4259853;
 //BA.debugLineNum = 4259853;BA.debugLine="Dim firstRow() As String";
_firstrow = new String[(int) (0)];
java.util.Arrays.fill(_firstrow,"");
RDebugUtils.currentLine=4259854;
 //BA.debugLineNum = 4259854;BA.debugLine="firstRow = List1.Get(0)";
_firstrow = (String[])(_list1.Get((int) (0)));
RDebugUtils.currentLine=4259855;
 //BA.debugLineNum = 4259855;BA.debugLine="Dim h(firstRow.Length)";
_h = new String[_firstrow.length];
java.util.Arrays.fill(_h,"");
RDebugUtils.currentLine=4259856;
 //BA.debugLineNum = 4259856;BA.debugLine="For i = 0 To firstRow.Length - 1";
{
final int step15 = 1;
final int limit15 = (int) (_firstrow.length-1);
_i = (int) (0) ;
for (;_i <= limit15 ;_i = _i + step15 ) {
RDebugUtils.currentLine=4259857;
 //BA.debugLineNum = 4259857;BA.debugLine="h(i) = \"Col\" & (i + 1)";
_h[_i] = "Col"+BA.NumberToString((_i+1));
 }
};
 };
RDebugUtils.currentLine=4259860;
 //BA.debugLineNum = 4259860;BA.debugLine="innerClearAll(h.Length)";
__ref._innerclearall(null,_h.length);
RDebugUtils.currentLine=4259861;
 //BA.debugLineNum = 4259861;BA.debugLine="ColumnWidth = SV.Width / NumberOfColumns";
__ref._columnwidth = (int) (__ref._sv.getWidth()/(double)__ref._numberofcolumns);
RDebugUtils.currentLine=4259862;
 //BA.debugLineNum = 4259862;BA.debugLine="SetHeader(h)";
__ref._setheader(null,_h);
RDebugUtils.currentLine=4259863;
 //BA.debugLineNum = 4259863;BA.debugLine="For Each row() As String In List1";
{
final anywheresoftware.b4a.BA.IterableList group22 = _list1;
final int groupLen22 = group22.getSize()
;int index22 = 0;
;
for (; index22 < groupLen22;index22++){
_row = (String[])(group22.Get(index22));
RDebugUtils.currentLine=4259864;
 //BA.debugLineNum = 4259864;BA.debugLine="AddRow(row)";
__ref._addrow(null,_row);
 }
};
RDebugUtils.currentLine=4259866;
 //BA.debugLineNum = 4259866;BA.debugLine="End Sub";
return "";
}
public String  _setheader(com.ServicioSocial.table __ref,String[] _values) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "setheader"))
	 {return ((String) Debug.delegate(ba, "setheader", new Object[] {_values}));}
int _i = 0;
anywheresoftware.b4a.objects.LabelWrapper _l = null;
RDebugUtils.currentLine=3801088;
 //BA.debugLineNum = 3801088;BA.debugLine="Public Sub SetHeader(Values() As String)";
RDebugUtils.currentLine=3801089;
 //BA.debugLineNum = 3801089;BA.debugLine="For I = Header.NumberOfViews - 1 To 0 Step -1";
{
final int step1 = -1;
final int limit1 = (int) (0);
_i = (int) (__ref._header.getNumberOfViews()-1) ;
for (;_i >= limit1 ;_i = _i + step1 ) {
RDebugUtils.currentLine=3801090;
 //BA.debugLineNum = 3801090;BA.debugLine="Header.RemoveViewAt(I)";
__ref._header.RemoveViewAt(_i);
 }
};
RDebugUtils.currentLine=3801092;
 //BA.debugLineNum = 3801092;BA.debugLine="For I = 0 To NumberOfColumns - 1";
{
final int step4 = 1;
final int limit4 = (int) (__ref._numberofcolumns-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
RDebugUtils.currentLine=3801093;
 //BA.debugLineNum = 3801093;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3801094;
 //BA.debugLineNum = 3801094;BA.debugLine="l.Initialize(\"header\")";
_l.Initialize(ba,"header");
RDebugUtils.currentLine=3801095;
 //BA.debugLineNum = 3801095;BA.debugLine="l.Gravity = Gravity.CENTER";
_l.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=3801096;
 //BA.debugLineNum = 3801096;BA.debugLine="l.TextSize = FontSize";
_l.setTextSize(__ref._fontsize);
RDebugUtils.currentLine=3801097;
 //BA.debugLineNum = 3801097;BA.debugLine="l.Color = HeaderColor";
_l.setColor(__ref._headercolor);
RDebugUtils.currentLine=3801098;
 //BA.debugLineNum = 3801098;BA.debugLine="l.TextColor = HeaderFontColor";
_l.setTextColor(__ref._headerfontcolor);
RDebugUtils.currentLine=3801099;
 //BA.debugLineNum = 3801099;BA.debugLine="l.Text = Values(I)";
_l.setText(BA.ObjectToCharSequence(_values[_i]));
RDebugUtils.currentLine=3801100;
 //BA.debugLineNum = 3801100;BA.debugLine="l.Tag = I";
_l.setTag((Object)(_i));
RDebugUtils.currentLine=3801101;
 //BA.debugLineNum = 3801101;BA.debugLine="Header.AddView(l, ColumnWidth * I, 0, ColumnWidt";
__ref._header.AddView((android.view.View)(_l.getObject()),(int) (__ref._columnwidth*_i),(int) (0),(int) (__ref._columnwidth-__c.DipToCurrent((int) (1))),__ref._rowheight);
 }
};
RDebugUtils.currentLine=3801103;
 //BA.debugLineNum = 3801103;BA.debugLine="End Sub";
return "";
}
public String  _removerow(com.ServicioSocial.table __ref,int _row) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "removerow"))
	 {return ((String) Debug.delegate(ba, "removerow", new Object[] {_row}));}
int _sr = 0;
int _i = 0;
RDebugUtils.currentLine=3407872;
 //BA.debugLineNum = 3407872;BA.debugLine="Public Sub RemoveRow(Row As Int)";
RDebugUtils.currentLine=3407873;
 //BA.debugLineNum = 3407873;BA.debugLine="SV_ScrollChanged(SV.ScrollPosition)";
__ref._sv_scrollchanged(null,__ref._sv.getScrollPosition());
RDebugUtils.currentLine=3407874;
 //BA.debugLineNum = 3407874;BA.debugLine="Dim sr As Int = SelectedRow";
_sr = __ref._selectedrow;
RDebugUtils.currentLine=3407875;
 //BA.debugLineNum = 3407875;BA.debugLine="SelectRow(-1)";
__ref._selectrow(null,(int) (-1));
RDebugUtils.currentLine=3407876;
 //BA.debugLineNum = 3407876;BA.debugLine="Data.RemoveAt(Row)";
__ref._data.RemoveAt(_row);
RDebugUtils.currentLine=3407877;
 //BA.debugLineNum = 3407877;BA.debugLine="If Data.Size = 0 Then";
if (__ref._data.getSize()==0) { 
RDebugUtils.currentLine=3407878;
 //BA.debugLineNum = 3407878;BA.debugLine="ClearAll";
__ref._clearall(null);
RDebugUtils.currentLine=3407879;
 //BA.debugLineNum = 3407879;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=3407881;
 //BA.debugLineNum = 3407881;BA.debugLine="For i = minVisibleRow To maxVisibleRow";
{
final int step9 = 1;
final int limit9 = __ref._maxvisiblerow;
_i = __ref._minvisiblerow ;
for (;_i <= limit9 ;_i = _i + step9 ) {
RDebugUtils.currentLine=3407882;
 //BA.debugLineNum = 3407882;BA.debugLine="HideRow(i)";
__ref._hiderow(null,_i);
 }
};
RDebugUtils.currentLine=3407884;
 //BA.debugLineNum = 3407884;BA.debugLine="maxVisibleRow = Min(maxVisibleRow, Data.Size - 1)";
__ref._maxvisiblerow = (int) (__c.Min(__ref._maxvisiblerow,__ref._data.getSize()-1));
RDebugUtils.currentLine=3407885;
 //BA.debugLineNum = 3407885;BA.debugLine="minVisibleRow = Min(minVisibleRow, Data.Size - 1)";
__ref._minvisiblerow = (int) (__c.Min(__ref._minvisiblerow,__ref._data.getSize()-1));
RDebugUtils.currentLine=3407886;
 //BA.debugLineNum = 3407886;BA.debugLine="For i = minVisibleRow To maxVisibleRow";
{
final int step14 = 1;
final int limit14 = __ref._maxvisiblerow;
_i = __ref._minvisiblerow ;
for (;_i <= limit14 ;_i = _i + step14 ) {
RDebugUtils.currentLine=3407887;
 //BA.debugLineNum = 3407887;BA.debugLine="ShowRow(i)";
__ref._showrow(null,_i);
 }
};
RDebugUtils.currentLine=3407889;
 //BA.debugLineNum = 3407889;BA.debugLine="If sr = Row Then";
if (_sr==_row) { 
RDebugUtils.currentLine=3407890;
 //BA.debugLineNum = 3407890;BA.debugLine="sr = -1";
_sr = (int) (-1);
 }else 
{RDebugUtils.currentLine=3407891;
 //BA.debugLineNum = 3407891;BA.debugLine="Else If sr > Row Then";
if (_sr>_row) { 
RDebugUtils.currentLine=3407892;
 //BA.debugLineNum = 3407892;BA.debugLine="sr = sr - 1";
_sr = (int) (_sr-1);
 }}
;
RDebugUtils.currentLine=3407894;
 //BA.debugLineNum = 3407894;BA.debugLine="SelectRow(sr)";
__ref._selectrow(null,_sr);
RDebugUtils.currentLine=3407895;
 //BA.debugLineNum = 3407895;BA.debugLine="SV.Panel.Height = Data.Size * RowHeight";
__ref._sv.getPanel().setHeight((int) (__ref._data.getSize()*__ref._rowheight));
RDebugUtils.currentLine=3407896;
 //BA.debugLineNum = 3407896;BA.debugLine="SV_ScrollChanged(Min(SV.ScrollPosition, SV.Panel.";
__ref._sv_scrollchanged(null,(int) (__c.Min(__ref._sv.getScrollPosition(),__ref._sv.getPanel().getHeight())));
RDebugUtils.currentLine=3407897;
 //BA.debugLineNum = 3407897;BA.debugLine="End Sub";
return "";
}
public String  _savetabletocsv(com.ServicioSocial.table __ref,String _dir,String _filename) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "savetabletocsv"))
	 {return ((String) Debug.delegate(ba, "savetabletocsv", new Object[] {_dir,_filename}));}
String[] _headers = null;
int _i = 0;
anywheresoftware.b4a.objects.LabelWrapper _l = null;
RDebugUtils.currentLine=4325376;
 //BA.debugLineNum = 4325376;BA.debugLine="Public Sub SaveTableToCSV(Dir As String, Filename";
RDebugUtils.currentLine=4325377;
 //BA.debugLineNum = 4325377;BA.debugLine="Dim headers(NumberOfColumns) As String";
_headers = new String[__ref._numberofcolumns];
java.util.Arrays.fill(_headers,"");
RDebugUtils.currentLine=4325378;
 //BA.debugLineNum = 4325378;BA.debugLine="Dim i As Int";
_i = 0;
RDebugUtils.currentLine=4325379;
 //BA.debugLineNum = 4325379;BA.debugLine="For Each l As Label In Header";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
{
final anywheresoftware.b4a.BA.IterableList group3 = __ref._header;
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_l.setObject((android.widget.TextView)(group3.Get(index3)));
RDebugUtils.currentLine=4325380;
 //BA.debugLineNum = 4325380;BA.debugLine="headers(i) = l.Text";
_headers[_i] = _l.getText();
RDebugUtils.currentLine=4325381;
 //BA.debugLineNum = 4325381;BA.debugLine="i = i + 1";
_i = (int) (_i+1);
 }
};
RDebugUtils.currentLine=4325383;
 //BA.debugLineNum = 4325383;BA.debugLine="StringUtils1.SaveCSV2(Dir, Filename, \",\", Data, h";
__ref._stringutils1.SaveCSV2(_dir,_filename,BA.ObjectToChar(","),__ref._data,anywheresoftware.b4a.keywords.Common.ArrayToList(_headers));
RDebugUtils.currentLine=4325384;
 //BA.debugLineNum = 4325384;BA.debugLine="End Sub";
return "";
}
public String  _setcolumnswidths(com.ServicioSocial.table __ref,int[] _widths) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "setcolumnswidths"))
	 {return ((String) Debug.delegate(ba, "setcolumnswidths", new Object[] {_widths}));}
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
int _i = 0;
anywheresoftware.b4a.objects.LabelWrapper[] _lbls = null;
int _lbl = 0;
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Public Sub SetColumnsWidths(Widths() As Int)";
RDebugUtils.currentLine=3080193;
 //BA.debugLineNum = 3080193;BA.debugLine="Dim v As View";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
RDebugUtils.currentLine=3080194;
 //BA.debugLineNum = 3080194;BA.debugLine="For i = 0 To Widths.Length - 1";
{
final int step2 = 1;
final int limit2 = (int) (_widths.length-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
RDebugUtils.currentLine=3080195;
 //BA.debugLineNum = 3080195;BA.debugLine="v = Header.GetView(i)";
_v = __ref._header.GetView(_i);
RDebugUtils.currentLine=3080196;
 //BA.debugLineNum = 3080196;BA.debugLine="v.Width = Widths(i) - 1dip";
_v.setWidth((int) (_widths[_i]-__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=3080197;
 //BA.debugLineNum = 3080197;BA.debugLine="If i > 0 Then";
if (_i>0) { 
RDebugUtils.currentLine=3080198;
 //BA.debugLineNum = 3080198;BA.debugLine="v.Left = Header.GetView(i-1).Left + Widths(i-1)";
_v.setLeft((int) (__ref._header.GetView((int) (_i-1)).getLeft()+_widths[(int) (_i-1)]+__c.DipToCurrent((int) (1))));
 };
 }
};
RDebugUtils.currentLine=3080201;
 //BA.debugLineNum = 3080201;BA.debugLine="Dim lbls() As Label";
_lbls = new anywheresoftware.b4a.objects.LabelWrapper[(int) (0)];
{
int d0 = _lbls.length;
for (int i0 = 0;i0 < d0;i0++) {
_lbls[i0] = new anywheresoftware.b4a.objects.LabelWrapper();
}
}
;
RDebugUtils.currentLine=3080202;
 //BA.debugLineNum = 3080202;BA.debugLine="For i = 0 To visibleRows.Size - 1";
{
final int step10 = 1;
final int limit10 = (int) (__ref._visiblerows.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit10 ;_i = _i + step10 ) {
RDebugUtils.currentLine=3080203;
 //BA.debugLineNum = 3080203;BA.debugLine="lbls = visibleRows.GetValueAt(i)";
_lbls = (anywheresoftware.b4a.objects.LabelWrapper[])(__ref._visiblerows.GetValueAt(_i));
RDebugUtils.currentLine=3080204;
 //BA.debugLineNum = 3080204;BA.debugLine="For lbl = 0 To lbls.Length - 1";
{
final int step12 = 1;
final int limit12 = (int) (_lbls.length-1);
_lbl = (int) (0) ;
for (;_lbl <= limit12 ;_lbl = _lbl + step12 ) {
RDebugUtils.currentLine=3080205;
 //BA.debugLineNum = 3080205;BA.debugLine="lbls(lbl).SetLayout(Header.GetView(lbl).Left, l";
_lbls[_lbl].SetLayout(__ref._header.GetView(_lbl).getLeft(),_lbls[_lbl].getTop(),__ref._header.GetView(_lbl).getWidth(),__ref._rowheight);
 }
};
 }
};
RDebugUtils.currentLine=3080209;
 //BA.debugLineNum = 3080209;BA.debugLine="End Sub";
return "";
}
public String  _setvalue(com.ServicioSocial.table __ref,int _col,int _row,String _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "setvalue"))
	 {return ((String) Debug.delegate(ba, "setvalue", new Object[] {_col,_row,_value}));}
String[] _values = null;
anywheresoftware.b4a.objects.LabelWrapper[] _lbls = null;
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Public Sub SetValue(Col As Int, Row As Int, Value";
RDebugUtils.currentLine=4063233;
 //BA.debugLineNum = 4063233;BA.debugLine="Dim values() As String";
_values = new String[(int) (0)];
java.util.Arrays.fill(_values,"");
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="values = Data.Get(Row)";
_values = (String[])(__ref._data.Get(_row));
RDebugUtils.currentLine=4063235;
 //BA.debugLineNum = 4063235;BA.debugLine="values(Col) = Value";
_values[_col] = _value;
RDebugUtils.currentLine=4063236;
 //BA.debugLineNum = 4063236;BA.debugLine="If visibleRows.ContainsKey(Row) Then";
if (__ref._visiblerows.ContainsKey((Object)(_row))) { 
RDebugUtils.currentLine=4063237;
 //BA.debugLineNum = 4063237;BA.debugLine="Dim lbls() As Label";
_lbls = new anywheresoftware.b4a.objects.LabelWrapper[(int) (0)];
{
int d0 = _lbls.length;
for (int i0 = 0;i0 < d0;i0++) {
_lbls[i0] = new anywheresoftware.b4a.objects.LabelWrapper();
}
}
;
RDebugUtils.currentLine=4063238;
 //BA.debugLineNum = 4063238;BA.debugLine="lbls = visibleRows.Get(Row)";
_lbls = (anywheresoftware.b4a.objects.LabelWrapper[])(__ref._visiblerows.Get((Object)(_row)));
RDebugUtils.currentLine=4063239;
 //BA.debugLineNum = 4063239;BA.debugLine="lbls(Col).Text = Value";
_lbls[_col].setText(BA.ObjectToCharSequence(_value));
 };
RDebugUtils.currentLine=4063241;
 //BA.debugLineNum = 4063241;BA.debugLine="End Sub";
return "";
}
public int  _size(com.ServicioSocial.table __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "size"))
	 {return ((Integer) Debug.delegate(ba, "size", null));}
RDebugUtils.currentLine=4390912;
 //BA.debugLineNum = 4390912;BA.debugLine="Public Sub Size As Int";
RDebugUtils.currentLine=4390913;
 //BA.debugLineNum = 4390913;BA.debugLine="Return Data.Size";
if (true) return __ref._data.getSize();
RDebugUtils.currentLine=4390914;
 //BA.debugLineNum = 4390914;BA.debugLine="End Sub";
return 0;
}
}