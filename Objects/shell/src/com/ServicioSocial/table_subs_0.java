package com.ServicioSocial;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class table_subs_0 {


public static RemoteObject  _addrow(RemoteObject __ref,RemoteObject _values) throws Exception{
try {
		Debug.PushSubsStack("AddRow (table) ","table",6,__ref.getField(false, "ba"),__ref,146);
if (RapidSub.canDelegate("addrow")) { return __ref.runUserSub(false, "table","addrow", __ref, _values);}
RemoteObject _lastrow = RemoteObject.createImmutable(0);
Debug.locals.put("Values", _values);
 BA.debugLineNum = 146;BA.debugLine="Public Sub AddRow(Values() As String)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 147;BA.debugLine="If Values.Length <> NumberOfColumns Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("!",_values.getField(true,"length"),BA.numberCast(double.class, __ref.getField(true,"_numberofcolumns")))) { 
 BA.debugLineNum = 148;BA.debugLine="Log(\"Wrong number of values.\")";
Debug.ShouldStop(524288);
table.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Wrong number of values.")));
 BA.debugLineNum = 149;BA.debugLine="Return";
Debug.ShouldStop(1048576);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 151;BA.debugLine="Data.Add(Values)";
Debug.ShouldStop(4194304);
__ref.getField(false,"_data").runVoidMethod ("Add",(Object)((_values)));
 BA.debugLineNum = 152;BA.debugLine="Dim lastRow As Int";
Debug.ShouldStop(8388608);
_lastrow = RemoteObject.createImmutable(0);Debug.locals.put("lastRow", _lastrow);
 BA.debugLineNum = 153;BA.debugLine="lastRow = Data.Size - 1";
Debug.ShouldStop(16777216);
_lastrow = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_data").runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1);Debug.locals.put("lastRow", _lastrow);
 BA.debugLineNum = 154;BA.debugLine="If lastRow < (SV.ScrollPosition + SV.Height) / Ro";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("<",_lastrow,RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_sv").runMethod(true,"getScrollPosition"),__ref.getField(false,"_sv").runMethod(true,"getHeight")}, "+",1, 1)),__ref.getField(true,"_rowheight"),RemoteObject.createImmutable(1)}, "/+",1, 0))) { 
 BA.debugLineNum = 155;BA.debugLine="ShowRow(lastRow)";
Debug.ShouldStop(67108864);
__ref.runClassMethod (com.ServicioSocial.table.class, "_showrow",(Object)(_lastrow));
 };
 BA.debugLineNum = 157;BA.debugLine="SV.Panel.Height = Data.Size * RowHeight";
Debug.ShouldStop(268435456);
__ref.getField(false,"_sv").runMethod(false,"getPanel").runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_data").runMethod(true,"getSize"),__ref.getField(true,"_rowheight")}, "*",0, 1));
 BA.debugLineNum = 158;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addtoactivity(RemoteObject __ref,RemoteObject _act,RemoteObject _left,RemoteObject _top,RemoteObject _width,RemoteObject _height) throws Exception{
try {
		Debug.PushSubsStack("AddToActivity (table) ","table",6,__ref.getField(false, "ba"),__ref,132);
if (RapidSub.canDelegate("addtoactivity")) { return __ref.runUserSub(false, "table","addtoactivity", __ref, _act, _left, _top, _width, _height);}
Debug.locals.put("Act", _act);
Debug.locals.put("Left", _left);
Debug.locals.put("Top", _top);
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 132;BA.debugLine="Public Sub AddToActivity(Act As Activity, Left As";
Debug.ShouldStop(8);
 BA.debugLineNum = 133;BA.debugLine="visible = True";
Debug.ShouldStop(16);
__ref.setField ("_visible",table.__c.getField(true,"True"));
 BA.debugLineNum = 134;BA.debugLine="Header.Initialize(\"\")";
Debug.ShouldStop(32);
__ref.getField(false,"_header").runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 135;BA.debugLine="Header.Color = TableColor";
Debug.ShouldStop(64);
__ref.getField(false,"_header").runVoidMethod ("setColor",__ref.getField(true,"_tablecolor"));
 BA.debugLineNum = 136;BA.debugLine="Act.AddView(Header, Left, Top , Width, RowHeight)";
Debug.ShouldStop(128);
_act.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_header").getObject())),(Object)(_left),(Object)(_top),(Object)(_width),(Object)(__ref.getField(true,"_rowheight")));
 BA.debugLineNum = 137;BA.debugLine="Act.AddView(SV, Left, Top + RowHeight, Width, Hei";
Debug.ShouldStop(256);
_act.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_sv").getObject())),(Object)(_left),(Object)(RemoteObject.solve(new RemoteObject[] {_top,__ref.getField(true,"_rowheight")}, "+",1, 1)),(Object)(_width),(Object)(RemoteObject.solve(new RemoteObject[] {_height,__ref.getField(true,"_rowheight")}, "-",1, 1)));
 BA.debugLineNum = 138;BA.debugLine="ColumnWidth = SV.Width / NumberOfColumns";
Debug.ShouldStop(512);
__ref.setField ("_columnwidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_sv").runMethod(true,"getWidth"),__ref.getField(true,"_numberofcolumns")}, "/",0, 0)));
 BA.debugLineNum = 140;BA.debugLine="SV_ScrollChanged(0)";
Debug.ShouldStop(2048);
__ref.runClassMethod (com.ServicioSocial.table.class, "_sv_scrollchanged",(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 142;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cell_click(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("Cell_Click (table) ","table",6,__ref.getField(false, "ba"),__ref,282);
if (RapidSub.canDelegate("cell_click")) { return __ref.runUserSub(false, "table","cell_click", __ref);}
RemoteObject _rc = RemoteObject.declareNull("com.ServicioSocial.table._rowcol");
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
 BA.debugLineNum = 282;BA.debugLine="Private Sub Cell_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 283;BA.debugLine="Dim rc As RowCol";
Debug.ShouldStop(67108864);
_rc = RemoteObject.createNew ("com.ServicioSocial.table._rowcol");Debug.locals.put("rc", _rc);
 BA.debugLineNum = 284;BA.debugLine="Dim l As Label";
Debug.ShouldStop(134217728);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("l", _l);
 BA.debugLineNum = 285;BA.debugLine="l = Sender";
Debug.ShouldStop(268435456);
_l.setObject(table.__c.runMethod(false,"Sender",__ref.getField(false, "ba")));
 BA.debugLineNum = 286;BA.debugLine="rc = l.Tag";
Debug.ShouldStop(536870912);
_rc = (_l.runMethod(false,"getTag"));Debug.locals.put("rc", _rc);
 BA.debugLineNum = 287;BA.debugLine="SelectRow(rc.Row)";
Debug.ShouldStop(1073741824);
__ref.runClassMethod (com.ServicioSocial.table.class, "_selectrow",(Object)(_rc.getField(true,"Row")));
 BA.debugLineNum = 288;BA.debugLine="If SubExists(Callback, Event & \"_CellClick\") Then";
Debug.ShouldStop(-2147483648);
if (table.__c.runMethod(true,"SubExists",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_callback")),(Object)(RemoteObject.concat(__ref.getField(true,"_event"),RemoteObject.createImmutable("_CellClick")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 289;BA.debugLine="CallSub3(Callback, Event & \"_CellClick\", rc.Col,";
Debug.ShouldStop(1);
table.__c.runMethodAndSync(false,"CallSubNew3",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_callback")),(Object)(RemoteObject.concat(__ref.getField(true,"_event"),RemoteObject.createImmutable("_CellClick"))),(Object)((_rc.getField(true,"Col"))),(Object)((_rc.getField(true,"Row"))));
 };
 BA.debugLineNum = 291;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private StringUtils1 As StringUtils";
table._stringutils1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.StringUtils");__ref.setField("_stringutils1",table._stringutils1);
 //BA.debugLineNum = 4;BA.debugLine="Private SV As ScrollView";
table._sv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");__ref.setField("_sv",table._sv);
 //BA.debugLineNum = 5;BA.debugLine="Public Header As Panel";
table._header = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");__ref.setField("_header",table._header);
 //BA.debugLineNum = 6;BA.debugLine="Private Callback As Object";
table._callback = RemoteObject.createNew ("Object");__ref.setField("_callback",table._callback);
 //BA.debugLineNum = 7;BA.debugLine="Private Event As String";
table._event = RemoteObject.createImmutable("");__ref.setField("_event",table._event);
 //BA.debugLineNum = 8;BA.debugLine="Private SelectedRow As Int";
table._selectedrow = RemoteObject.createImmutable(0);__ref.setField("_selectedrow",table._selectedrow);
 //BA.debugLineNum = 9;BA.debugLine="Private Data As List";
table._data = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");__ref.setField("_data",table._data);
 //BA.debugLineNum = 10;BA.debugLine="Private LabelsCache As List";
table._labelscache = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");__ref.setField("_labelscache",table._labelscache);
 //BA.debugLineNum = 11;BA.debugLine="Private minVisibleRow, maxVisibleRow As Int";
table._minvisiblerow = RemoteObject.createImmutable(0);__ref.setField("_minvisiblerow",table._minvisiblerow);
table._maxvisiblerow = RemoteObject.createImmutable(0);__ref.setField("_maxvisiblerow",table._maxvisiblerow);
 //BA.debugLineNum = 12;BA.debugLine="Private visible As Boolean";
table._visible = RemoteObject.createImmutable(false);__ref.setField("_visible",table._visible);
 //BA.debugLineNum = 13;BA.debugLine="Private visibleRows As Map";
table._visiblerows = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");__ref.setField("_visiblerows",table._visiblerows);
 //BA.debugLineNum = 14;BA.debugLine="Public NumberOfColumns, ColumnWidth As Int";
table._numberofcolumns = RemoteObject.createImmutable(0);__ref.setField("_numberofcolumns",table._numberofcolumns);
table._columnwidth = RemoteObject.createImmutable(0);__ref.setField("_columnwidth",table._columnwidth);
 //BA.debugLineNum = 15;BA.debugLine="Public RowHeight, HeaderColor, TableColor, FontCo";
table._rowheight = RemoteObject.createImmutable(0);__ref.setField("_rowheight",table._rowheight);
table._headercolor = RemoteObject.createImmutable(0);__ref.setField("_headercolor",table._headercolor);
table._tablecolor = RemoteObject.createImmutable(0);__ref.setField("_tablecolor",table._tablecolor);
table._fontcolor = RemoteObject.createImmutable(0);__ref.setField("_fontcolor",table._fontcolor);
table._headerfontcolor = RemoteObject.createImmutable(0);__ref.setField("_headerfontcolor",table._headerfontcolor);
 //BA.debugLineNum = 16;BA.debugLine="Public FontSize As Float";
table._fontsize = RemoteObject.createImmutable(0f);__ref.setField("_fontsize",table._fontsize);
 //BA.debugLineNum = 17;BA.debugLine="Type RowCol (Row As Int, Col As Int)";
;
 //BA.debugLineNum = 18;BA.debugLine="Public Alignment As Int";
table._alignment = RemoteObject.createImmutable(0);__ref.setField("_alignment",table._alignment);
 //BA.debugLineNum = 19;BA.debugLine="Public SelectedDrawable(), Drawable1(), Drawable2";
table._selecteddrawable = RemoteObject.createNewArray ("Object", new int[] {0}, new Object[]{});__ref.setField("_selecteddrawable",table._selecteddrawable);
table._drawable1 = RemoteObject.createNewArray ("Object", new int[] {0}, new Object[]{});__ref.setField("_drawable1",table._drawable1);
table._drawable2 = RemoteObject.createNewArray ("Object", new int[] {0}, new Object[]{});__ref.setField("_drawable2",table._drawable2);
 //BA.debugLineNum = 21;BA.debugLine="HeaderColor = Colors.Gray";
__ref.setField ("_headercolor",table.__c.getField(false,"Colors").getField(true,"Gray"));
 //BA.debugLineNum = 22;BA.debugLine="RowHeight = 30dip";
__ref.setField ("_rowheight",table.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 //BA.debugLineNum = 23;BA.debugLine="TableColor = Colors.LightGray";
__ref.setField ("_tablecolor",table.__c.getField(false,"Colors").getField(true,"LightGray"));
 //BA.debugLineNum = 24;BA.debugLine="FontColor = Colors.Black";
__ref.setField ("_fontcolor",table.__c.getField(false,"Colors").getField(true,"Black"));
 //BA.debugLineNum = 25;BA.debugLine="HeaderFontColor = Colors.White";
__ref.setField ("_headerfontcolor",table.__c.getField(false,"Colors").getField(true,"White"));
 //BA.debugLineNum = 26;BA.debugLine="FontSize = 14";
__ref.setField ("_fontsize",BA.numberCast(float.class, 14));
 //BA.debugLineNum = 27;BA.debugLine="Alignment = Gravity.CENTER 'change to Gravity.LEF";
__ref.setField ("_alignment",table.__c.getField(false,"Gravity").getField(true,"CENTER"));
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _clearall(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("ClearAll (table) ","table",6,__ref.getField(false, "ba"),__ref,39);
if (RapidSub.canDelegate("clearall")) { return __ref.runUserSub(false, "table","clearall", __ref);}
 BA.debugLineNum = 39;BA.debugLine="Public Sub ClearAll";
Debug.ShouldStop(64);
 BA.debugLineNum = 40;BA.debugLine="innerClearAll(NumberOfColumns)";
Debug.ShouldStop(128);
__ref.runClassMethod (com.ServicioSocial.table.class, "_innerclearall",(Object)(__ref.getField(true,"_numberofcolumns")));
 BA.debugLineNum = 41;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createnewlabels(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("CreateNewLabels (table) ","table",6,__ref.getField(false, "ba"),__ref,248);
if (RapidSub.canDelegate("createnewlabels")) { return __ref.runUserSub(false, "table","createnewlabels", __ref);}
RemoteObject _lbls = null;
int _i = 0;
RemoteObject _rc = RemoteObject.declareNull("com.ServicioSocial.table._rowcol");
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
 BA.debugLineNum = 248;BA.debugLine="Private Sub CreateNewLabels As Label()";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 249;BA.debugLine="Dim lbls(NumberOfColumns) As Label";
Debug.ShouldStop(16777216);
_lbls = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.LabelWrapper", new int[] {__ref.getField(true,"_numberofcolumns").<Integer>get().intValue()}, new Object[]{});Debug.locals.put("lbls", _lbls);
 BA.debugLineNum = 250;BA.debugLine="For I = 0 To NumberOfColumns - 1";
Debug.ShouldStop(33554432);
{
final int step2 = 1;
final int limit2 = RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_numberofcolumns"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2) ;_i = ((int)(0 + _i + step2))  ) {
Debug.locals.put("I", _i);
 BA.debugLineNum = 251;BA.debugLine="Dim rc As RowCol";
Debug.ShouldStop(67108864);
_rc = RemoteObject.createNew ("com.ServicioSocial.table._rowcol");Debug.locals.put("rc", _rc);
 BA.debugLineNum = 252;BA.debugLine="rc.Col = I";
Debug.ShouldStop(134217728);
_rc.setField ("Col",BA.numberCast(int.class, _i));
 BA.debugLineNum = 253;BA.debugLine="Dim l As Label";
Debug.ShouldStop(268435456);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("l", _l);
 BA.debugLineNum = 254;BA.debugLine="l.Initialize(\"cell\")";
Debug.ShouldStop(536870912);
_l.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("cell")));
 BA.debugLineNum = 255;BA.debugLine="l.Gravity = Alignment";
Debug.ShouldStop(1073741824);
_l.runMethod(true,"setGravity",__ref.getField(true,"_alignment"));
 BA.debugLineNum = 256;BA.debugLine="l.TextSize = FontSize";
Debug.ShouldStop(-2147483648);
_l.runMethod(true,"setTextSize",__ref.getField(true,"_fontsize"));
 BA.debugLineNum = 257;BA.debugLine="l.TextColor = FontColor";
Debug.ShouldStop(1);
_l.runMethod(true,"setTextColor",__ref.getField(true,"_fontcolor"));
 BA.debugLineNum = 258;BA.debugLine="l.Tag = rc";
Debug.ShouldStop(2);
_l.runMethod(false,"setTag",(_rc));
 BA.debugLineNum = 259;BA.debugLine="lbls(I) = l";
Debug.ShouldStop(4);
_lbls.setArrayElement (_l,BA.numberCast(int.class, _i));
 }
}Debug.locals.put("I", _i);
;
 BA.debugLineNum = 261;BA.debugLine="Return lbls";
Debug.ShouldStop(16);
if (true) return _lbls;
 BA.debugLineNum = 262;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getlabels(RemoteObject __ref,RemoteObject _row) throws Exception{
try {
		Debug.PushSubsStack("GetLabels (table) ","table",6,__ref.getField(false, "ba"),__ref,231);
if (RapidSub.canDelegate("getlabels")) { return __ref.runUserSub(false, "table","getlabels", __ref, _row);}
RemoteObject _lbls = null;
int _i = 0;
RemoteObject _rc = RemoteObject.declareNull("com.ServicioSocial.table._rowcol");
Debug.locals.put("Row", _row);
 BA.debugLineNum = 231;BA.debugLine="Private Sub GetLabels(Row As Int) As Label()";
Debug.ShouldStop(64);
 BA.debugLineNum = 232;BA.debugLine="Dim lbls() As Label";
Debug.ShouldStop(128);
_lbls = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.LabelWrapper", new int[] {0}, new Object[]{});Debug.locals.put("lbls", _lbls);
 BA.debugLineNum = 233;BA.debugLine="If LabelsCache.Size > 0 Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean(">",__ref.getField(false,"_labelscache").runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 235;BA.debugLine="lbls = LabelsCache.Get(LabelsCache.Size - 1)";
Debug.ShouldStop(1024);
_lbls = (__ref.getField(false,"_labelscache").runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_labelscache").runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1))));Debug.locals.put("lbls", _lbls);
 BA.debugLineNum = 236;BA.debugLine="LabelsCache.RemoveAt(LabelsCache.Size - 1)";
Debug.ShouldStop(2048);
__ref.getField(false,"_labelscache").runVoidMethod ("RemoveAt",(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_labelscache").runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1)));
 }else {
 BA.debugLineNum = 238;BA.debugLine="lbls = CreateNewLabels";
Debug.ShouldStop(8192);
_lbls = __ref.runClassMethod (com.ServicioSocial.table.class, "_createnewlabels");Debug.locals.put("lbls", _lbls);
 };
 BA.debugLineNum = 240;BA.debugLine="For I = 0 To lbls.Length - 1";
Debug.ShouldStop(32768);
{
final int step8 = 1;
final int limit8 = RemoteObject.solve(new RemoteObject[] {_lbls.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step8 > 0 && _i <= limit8) || (step8 < 0 && _i >= limit8) ;_i = ((int)(0 + _i + step8))  ) {
Debug.locals.put("I", _i);
 BA.debugLineNum = 241;BA.debugLine="Dim rc As RowCol";
Debug.ShouldStop(65536);
_rc = RemoteObject.createNew ("com.ServicioSocial.table._rowcol");Debug.locals.put("rc", _rc);
 BA.debugLineNum = 242;BA.debugLine="rc = lbls(I).Tag";
Debug.ShouldStop(131072);
_rc = (_lbls.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(false,"getTag"));Debug.locals.put("rc", _rc);
 BA.debugLineNum = 243;BA.debugLine="rc.Row = Row";
Debug.ShouldStop(262144);
_rc.setField ("Row",_row);
 }
}Debug.locals.put("I", _i);
;
 BA.debugLineNum = 245;BA.debugLine="Return lbls";
Debug.ShouldStop(1048576);
if (true) return _lbls;
 BA.debugLineNum = 246;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getvalue(RemoteObject __ref,RemoteObject _col,RemoteObject _row) throws Exception{
try {
		Debug.PushSubsStack("GetValue (table) ","table",6,__ref.getField(false, "ba"),__ref,304);
if (RapidSub.canDelegate("getvalue")) { return __ref.runUserSub(false, "table","getvalue", __ref, _col, _row);}
RemoteObject _values = null;
Debug.locals.put("Col", _col);
Debug.locals.put("Row", _row);
 BA.debugLineNum = 304;BA.debugLine="Public Sub GetValue(Col As Int, Row As Int)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 305;BA.debugLine="Dim values() As String";
Debug.ShouldStop(65536);
_values = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});Debug.locals.put("values", _values);
 BA.debugLineNum = 306;BA.debugLine="values = Data.Get(Row)";
Debug.ShouldStop(131072);
_values = (__ref.getField(false,"_data").runMethod(false,"Get",(Object)(_row)));Debug.locals.put("values", _values);
 BA.debugLineNum = 307;BA.debugLine="Return values(Col)";
Debug.ShouldStop(262144);
if (true) return _values.getArrayElement(true,_col);
 BA.debugLineNum = 308;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _header_click(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("Header_Click (table) ","table",6,__ref.getField(false, "ba"),__ref,293);
if (RapidSub.canDelegate("header_click")) { return __ref.runUserSub(false, "table","header_click", __ref);}
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _col = RemoteObject.createImmutable(0);
 BA.debugLineNum = 293;BA.debugLine="Private Sub Header_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 294;BA.debugLine="Dim l As Label";
Debug.ShouldStop(32);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("l", _l);
 BA.debugLineNum = 295;BA.debugLine="Dim col As Int";
Debug.ShouldStop(64);
_col = RemoteObject.createImmutable(0);Debug.locals.put("col", _col);
 BA.debugLineNum = 296;BA.debugLine="l = Sender";
Debug.ShouldStop(128);
_l.setObject(table.__c.runMethod(false,"Sender",__ref.getField(false, "ba")));
 BA.debugLineNum = 297;BA.debugLine="col = l.Tag";
Debug.ShouldStop(256);
_col = BA.numberCast(int.class, _l.runMethod(false,"getTag"));Debug.locals.put("col", _col);
 BA.debugLineNum = 298;BA.debugLine="If SubExists(Callback, Event & \"_HeaderClick\") Th";
Debug.ShouldStop(512);
if (table.__c.runMethod(true,"SubExists",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_callback")),(Object)(RemoteObject.concat(__ref.getField(true,"_event"),RemoteObject.createImmutable("_HeaderClick")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 299;BA.debugLine="CallSub2(Callback, Event & \"_HeaderClick\", col)";
Debug.ShouldStop(1024);
table.__c.runMethodAndSync(false,"CallSubNew2",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_callback")),(Object)(RemoteObject.concat(__ref.getField(true,"_event"),RemoteObject.createImmutable("_HeaderClick"))),(Object)((_col)));
 };
 BA.debugLineNum = 301;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _hiderow(RemoteObject __ref,RemoteObject _row) throws Exception{
try {
		Debug.PushSubsStack("HideRow (table) ","table",6,__ref.getField(false, "ba"),__ref,216);
if (RapidSub.canDelegate("hiderow")) { return __ref.runUserSub(false, "table","hiderow", __ref, _row);}
RemoteObject _lbls = null;
int _i = 0;
Debug.locals.put("Row", _row);
 BA.debugLineNum = 216;BA.debugLine="Private Sub HideRow (Row As Int)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 218;BA.debugLine="Dim lbls() As Label";
Debug.ShouldStop(33554432);
_lbls = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.LabelWrapper", new int[] {0}, new Object[]{});Debug.locals.put("lbls", _lbls);
 BA.debugLineNum = 219;BA.debugLine="lbls = visibleRows.Get(Row)";
Debug.ShouldStop(67108864);
_lbls = (__ref.getField(false,"_visiblerows").runMethod(false,"Get",(Object)((_row))));Debug.locals.put("lbls", _lbls);
 BA.debugLineNum = 220;BA.debugLine="If lbls = Null Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("n",_lbls)) { 
 BA.debugLineNum = 221;BA.debugLine="Log(\"HideRow: (null) \" & Row)";
Debug.ShouldStop(268435456);
table.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("HideRow: (null) "),_row)));
 BA.debugLineNum = 222;BA.debugLine="Return";
Debug.ShouldStop(536870912);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 224;BA.debugLine="For I = 0 To lbls.Length - 1";
Debug.ShouldStop(-2147483648);
{
final int step7 = 1;
final int limit7 = RemoteObject.solve(new RemoteObject[] {_lbls.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7) ;_i = ((int)(0 + _i + step7))  ) {
Debug.locals.put("I", _i);
 BA.debugLineNum = 225;BA.debugLine="lbls(I).RemoveView";
Debug.ShouldStop(1);
_lbls.getArrayElement(false,BA.numberCast(int.class, _i)).runVoidMethod ("RemoveView");
 }
}Debug.locals.put("I", _i);
;
 BA.debugLineNum = 227;BA.debugLine="visibleRows.Remove(Row)";
Debug.ShouldStop(4);
__ref.getField(false,"_visiblerows").runVoidMethod ("Remove",(Object)((_row)));
 BA.debugLineNum = 228;BA.debugLine="LabelsCache.Add(lbls)";
Debug.ShouldStop(8);
__ref.getField(false,"_labelscache").runVoidMethod ("Add",(Object)((_lbls)));
 BA.debugLineNum = 229;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _callbackmodule,RemoteObject _eventname,RemoteObject _vnumberofcolumns) throws Exception{
try {
		Debug.PushSubsStack("Initialize (table) ","table",6,__ref.getField(false, "ba"),__ref,30);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "table","initialize", __ref, _ba, _callbackmodule, _eventname, _vnumberofcolumns);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
Debug.locals.put("CallbackModule", _callbackmodule);
Debug.locals.put("EventName", _eventname);
Debug.locals.put("vNumberOfColumns", _vnumberofcolumns);
 BA.debugLineNum = 30;BA.debugLine="Public Sub Initialize (CallbackModule As Object, E";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 31;BA.debugLine="SV.Initialize2(0, \"SV\")";
Debug.ShouldStop(1073741824);
__ref.getField(false,"_sv").runVoidMethod ("Initialize2",__ref.getField(false, "ba"),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.createImmutable("SV")));
 BA.debugLineNum = 32;BA.debugLine="SV.Panel.Color = TableColor";
Debug.ShouldStop(-2147483648);
__ref.getField(false,"_sv").runMethod(false,"getPanel").runVoidMethod ("setColor",__ref.getField(true,"_tablecolor"));
 BA.debugLineNum = 33;BA.debugLine="Callback = CallbackModule";
Debug.ShouldStop(1);
__ref.setField ("_callback",_callbackmodule);
 BA.debugLineNum = 34;BA.debugLine="Event = EventName";
Debug.ShouldStop(2);
__ref.setField ("_event",_eventname);
 BA.debugLineNum = 35;BA.debugLine="innerClearAll(vNumberOfColumns)";
Debug.ShouldStop(4);
__ref.runClassMethod (com.ServicioSocial.table.class, "_innerclearall",(Object)(_vnumberofcolumns));
 BA.debugLineNum = 36;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _innerclearall(RemoteObject __ref,RemoteObject _vnumberofcolumns) throws Exception{
try {
		Debug.PushSubsStack("innerClearAll (table) ","table",6,__ref.getField(false, "ba"),__ref,64);
if (RapidSub.canDelegate("innerclearall")) { return __ref.runUserSub(false, "table","innerclearall", __ref, _vnumberofcolumns);}
int _i = 0;
RemoteObject _cd1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _cd2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _cd3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
Debug.locals.put("vNumberOfColumns", _vnumberofcolumns);
 BA.debugLineNum = 64;BA.debugLine="Private Sub innerClearAll(vNumberOfColumns As Int)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 65;BA.debugLine="For i = SV.Panel.NumberOfViews -1 To 0 Step -1";
Debug.ShouldStop(1);
{
final int step1 = -1;
final int limit1 = 0;
_i = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_sv").runMethod(false,"getPanel").runMethod(true,"getNumberOfViews"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue() ;
for (;(step1 > 0 && _i <= limit1) || (step1 < 0 && _i >= limit1) ;_i = ((int)(0 + _i + step1))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 66;BA.debugLine="SV.Panel.RemoveViewAt(i)";
Debug.ShouldStop(2);
__ref.getField(false,"_sv").runMethod(false,"getPanel").runVoidMethod ("RemoveViewAt",(Object)(BA.numberCast(int.class, _i)));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 68;BA.debugLine="NumberOfColumns = vNumberOfColumns";
Debug.ShouldStop(8);
__ref.setField ("_numberofcolumns",_vnumberofcolumns);
 BA.debugLineNum = 69;BA.debugLine="Dim Drawable1(NumberOfColumns) As Object";
Debug.ShouldStop(16);
table._drawable1 = RemoteObject.createNewArray ("Object", new int[] {__ref.getField(true,"_numberofcolumns").<Integer>get().intValue()}, new Object[]{});__ref.setField("_drawable1",table._drawable1);
 BA.debugLineNum = 70;BA.debugLine="Dim Drawable2(NumberOfColumns) As Object";
Debug.ShouldStop(32);
table._drawable2 = RemoteObject.createNewArray ("Object", new int[] {__ref.getField(true,"_numberofcolumns").<Integer>get().intValue()}, new Object[]{});__ref.setField("_drawable2",table._drawable2);
 BA.debugLineNum = 71;BA.debugLine="Dim SelectedDrawable(NumberOfColumns) As Object";
Debug.ShouldStop(64);
table._selecteddrawable = RemoteObject.createNewArray ("Object", new int[] {__ref.getField(true,"_numberofcolumns").<Integer>get().intValue()}, new Object[]{});__ref.setField("_selecteddrawable",table._selecteddrawable);
 BA.debugLineNum = 72;BA.debugLine="For i = 0 To NumberOfColumns - 1";
Debug.ShouldStop(128);
{
final int step8 = 1;
final int limit8 = RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_numberofcolumns"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step8 > 0 && _i <= limit8) || (step8 < 0 && _i >= limit8) ;_i = ((int)(0 + _i + step8))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 73;BA.debugLine="Dim cd1, cd2, cd3 As ColorDrawable";
Debug.ShouldStop(256);
_cd1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd1", _cd1);
_cd2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd2", _cd2);
_cd3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd3", _cd3);
 BA.debugLineNum = 74;BA.debugLine="cd1.Initialize(Colors.White, 0)";
Debug.ShouldStop(512);
_cd1.runVoidMethod ("Initialize",(Object)(table.__c.getField(false,"Colors").getField(true,"White")),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 75;BA.debugLine="cd2.Initialize(0xFF98F5FF, 0)";
Debug.ShouldStop(1024);
_cd2.runVoidMethod ("Initialize",(Object)(BA.numberCast(int.class, 0xff98f5ff)),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 76;BA.debugLine="cd3.Initialize(0xFF007FFF, 0)";
Debug.ShouldStop(2048);
_cd3.runVoidMethod ("Initialize",(Object)(BA.numberCast(int.class, 0xff007fff)),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 77;BA.debugLine="Drawable1(i) = cd1";
Debug.ShouldStop(4096);
__ref.getField(false,"_drawable1").setArrayElement ((_cd1.getObject()),BA.numberCast(int.class, _i));
 BA.debugLineNum = 78;BA.debugLine="Drawable2(i) = cd2";
Debug.ShouldStop(8192);
__ref.getField(false,"_drawable2").setArrayElement ((_cd2.getObject()),BA.numberCast(int.class, _i));
 BA.debugLineNum = 79;BA.debugLine="SelectedDrawable(i) = cd3";
Debug.ShouldStop(16384);
__ref.getField(false,"_selecteddrawable").setArrayElement ((_cd3.getObject()),BA.numberCast(int.class, _i));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 81;BA.debugLine="SV.Panel.Height = 0";
Debug.ShouldStop(65536);
__ref.getField(false,"_sv").runMethod(false,"getPanel").runMethod(true,"setHeight",BA.numberCast(int.class, 0));
 BA.debugLineNum = 82;BA.debugLine="SelectedRow = -1";
Debug.ShouldStop(131072);
__ref.setField ("_selectedrow",BA.numberCast(int.class, -(double) (0 + 1)));
 BA.debugLineNum = 83;BA.debugLine="minVisibleRow = -1";
Debug.ShouldStop(262144);
__ref.setField ("_minvisiblerow",BA.numberCast(int.class, -(double) (0 + 1)));
 BA.debugLineNum = 84;BA.debugLine="maxVisibleRow = 0";
Debug.ShouldStop(524288);
__ref.setField ("_maxvisiblerow",BA.numberCast(int.class, 0));
 BA.debugLineNum = 85;BA.debugLine="Data.Initialize";
Debug.ShouldStop(1048576);
__ref.getField(false,"_data").runVoidMethod ("Initialize");
 BA.debugLineNum = 86;BA.debugLine="LabelsCache.Initialize";
Debug.ShouldStop(2097152);
__ref.getField(false,"_labelscache").runVoidMethod ("Initialize");
 BA.debugLineNum = 87;BA.debugLine="visibleRows.Initialize";
Debug.ShouldStop(4194304);
__ref.getField(false,"_visiblerows").runVoidMethod ("Initialize");
 BA.debugLineNum = 88;BA.debugLine="SV.ScrollPosition = 0";
Debug.ShouldStop(8388608);
__ref.getField(false,"_sv").runMethod(true,"setScrollPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 89;BA.debugLine="DoEvents";
Debug.ShouldStop(16777216);
table.__c.runVoidMethodAndSync ("DoEvents");
 BA.debugLineNum = 90;BA.debugLine="SV.ScrollPosition = 0";
Debug.ShouldStop(33554432);
__ref.getField(false,"_sv").runMethod(true,"setScrollPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 91;BA.debugLine="For i = 1 To 80 'fill the cache to avoid delay on";
Debug.ShouldStop(67108864);
{
final int step27 = 1;
final int limit27 = 80;
_i = 1 ;
for (;(step27 > 0 && _i <= limit27) || (step27 < 0 && _i >= limit27) ;_i = ((int)(0 + _i + step27))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 92;BA.debugLine="LabelsCache.Add(CreateNewLabels)";
Debug.ShouldStop(134217728);
__ref.getField(false,"_labelscache").runVoidMethod ("Add",(Object)((__ref.runClassMethod (com.ServicioSocial.table.class, "_createnewlabels"))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 94;BA.debugLine="If visible Then";
Debug.ShouldStop(536870912);
if (__ref.getField(true,"_visible").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 95;BA.debugLine="SV_ScrollChanged(0)";
Debug.ShouldStop(1073741824);
__ref.runClassMethod (com.ServicioSocial.table.class, "_sv_scrollchanged",(Object)(BA.numberCast(int.class, 0)));
 };
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
public static RemoteObject  _isrowvisible(RemoteObject __ref,RemoteObject _row) throws Exception{
try {
		Debug.PushSubsStack("IsRowVisible (table) ","table",6,__ref.getField(false, "ba"),__ref,211);
if (RapidSub.canDelegate("isrowvisible")) { return __ref.runUserSub(false, "table","isrowvisible", __ref, _row);}
Debug.locals.put("Row", _row);
 BA.debugLineNum = 211;BA.debugLine="Private Sub IsRowVisible(Row As Int) As Boolean";
Debug.ShouldStop(262144);
 BA.debugLineNum = 212;BA.debugLine="Return Row < (SV.ScrollPosition + SV.Height) / (R";
Debug.ShouldStop(524288);
if (true) return BA.ObjectToBoolean(RemoteObject.solveBoolean("<",_row,RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_sv").runMethod(true,"getScrollPosition"),__ref.getField(false,"_sv").runMethod(true,"getHeight")}, "+",1, 1)),(RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_rowheight"),RemoteObject.createImmutable(1)}, "+",1, 1))}, "/",0, 0)) && RemoteObject.solveBoolean(">",_row,RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_sv").runMethod(true,"getScrollPosition"),__ref.getField(true,"_rowheight")}, "/",0, 0)));
 BA.debugLineNum = 214;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _jumptorow(RemoteObject __ref,RemoteObject _row) throws Exception{
try {
		Debug.PushSubsStack("JumpToRow (table) ","table",6,__ref.getField(false, "ba"),__ref,342);
if (RapidSub.canDelegate("jumptorow")) { return __ref.runUserSub(false, "table","jumptorow", __ref, _row);}
Debug.locals.put("Row", _row);
 BA.debugLineNum = 342;BA.debugLine="Public Sub JumpToRow(Row As Int)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 343;BA.debugLine="SV.ScrollPosition = Row * RowHeight";
Debug.ShouldStop(4194304);
__ref.getField(false,"_sv").runMethod(true,"setScrollPosition",RemoteObject.solve(new RemoteObject[] {_row,__ref.getField(true,"_rowheight")}, "*",0, 1));
 BA.debugLineNum = 344;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _loadtablefromcsv(RemoteObject __ref,RemoteObject _dir,RemoteObject _filename,RemoteObject _headersexist) throws Exception{
try {
		Debug.PushSubsStack("LoadTableFromCSV (table) ","table",6,__ref.getField(false, "ba"),__ref,348);
if (RapidSub.canDelegate("loadtablefromcsv")) { return __ref.runUserSub(false, "table","loadtablefromcsv", __ref, _dir, _filename, _headersexist);}
RemoteObject _list1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _h = null;
RemoteObject _headers = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
RemoteObject _firstrow = null;
RemoteObject _row = null;
Debug.locals.put("Dir", _dir);
Debug.locals.put("Filename", _filename);
Debug.locals.put("HeadersExist", _headersexist);
 BA.debugLineNum = 348;BA.debugLine="Public Sub LoadTableFromCSV(Dir As String, Filenam";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 350;BA.debugLine="Dim List1 As List";
Debug.ShouldStop(536870912);
_list1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("List1", _list1);
 BA.debugLineNum = 351;BA.debugLine="Dim h() As String";
Debug.ShouldStop(1073741824);
_h = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});Debug.locals.put("h", _h);
 BA.debugLineNum = 352;BA.debugLine="If HeadersExist Then";
Debug.ShouldStop(-2147483648);
if (_headersexist.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 353;BA.debugLine="Dim headers As List";
Debug.ShouldStop(1);
_headers = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("headers", _headers);
 BA.debugLineNum = 354;BA.debugLine="List1 = StringUtils1.LoadCSV2(Dir, Filename, \",\"";
Debug.ShouldStop(2);
_list1 = __ref.getField(false,"_stringutils1").runMethod(false,"LoadCSV2",(Object)(_dir),(Object)(_filename),(Object)(BA.ObjectToChar(",")),(Object)(_headers));Debug.locals.put("List1", _list1);
 BA.debugLineNum = 355;BA.debugLine="Dim h(headers.Size) As String";
Debug.ShouldStop(4);
_h = RemoteObject.createNewArray ("String", new int[] {_headers.runMethod(true,"getSize").<Integer>get().intValue()}, new Object[]{});Debug.locals.put("h", _h);
 BA.debugLineNum = 356;BA.debugLine="For i = 0 To headers.Size - 1";
Debug.ShouldStop(8);
{
final int step7 = 1;
final int limit7 = RemoteObject.solve(new RemoteObject[] {_headers.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7) ;_i = ((int)(0 + _i + step7))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 357;BA.debugLine="h(i) = headers.Get(i)";
Debug.ShouldStop(16);
_h.setArrayElement (BA.ObjectToString(_headers.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))),BA.numberCast(int.class, _i));
 }
}Debug.locals.put("i", _i);
;
 }else {
 BA.debugLineNum = 360;BA.debugLine="List1 = StringUtils1.LoadCSV(Dir, Filename, \",\")";
Debug.ShouldStop(128);
_list1 = __ref.getField(false,"_stringutils1").runMethod(false,"LoadCSV",(Object)(_dir),(Object)(_filename),(Object)(BA.ObjectToChar(RemoteObject.createImmutable(","))));Debug.locals.put("List1", _list1);
 BA.debugLineNum = 361;BA.debugLine="Dim firstRow() As String";
Debug.ShouldStop(256);
_firstrow = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});Debug.locals.put("firstRow", _firstrow);
 BA.debugLineNum = 362;BA.debugLine="firstRow = List1.Get(0)";
Debug.ShouldStop(512);
_firstrow = (_list1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("firstRow", _firstrow);
 BA.debugLineNum = 363;BA.debugLine="Dim h(firstRow.Length)";
Debug.ShouldStop(1024);
_h = RemoteObject.createNewArray ("String", new int[] {_firstrow.getField(true,"length").<Integer>get().intValue()}, new Object[]{});Debug.locals.put("h", _h);
 BA.debugLineNum = 364;BA.debugLine="For i = 0 To firstRow.Length - 1";
Debug.ShouldStop(2048);
{
final int step15 = 1;
final int limit15 = RemoteObject.solve(new RemoteObject[] {_firstrow.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step15 > 0 && _i <= limit15) || (step15 < 0 && _i >= limit15) ;_i = ((int)(0 + _i + step15))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 365;BA.debugLine="h(i) = \"Col\" & (i + 1)";
Debug.ShouldStop(4096);
_h.setArrayElement (RemoteObject.concat(RemoteObject.createImmutable("Col"),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "+",1, 1))),BA.numberCast(int.class, _i));
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 368;BA.debugLine="innerClearAll(h.Length)";
Debug.ShouldStop(32768);
__ref.runClassMethod (com.ServicioSocial.table.class, "_innerclearall",(Object)(_h.getField(true,"length")));
 BA.debugLineNum = 369;BA.debugLine="ColumnWidth = SV.Width / NumberOfColumns";
Debug.ShouldStop(65536);
__ref.setField ("_columnwidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_sv").runMethod(true,"getWidth"),__ref.getField(true,"_numberofcolumns")}, "/",0, 0)));
 BA.debugLineNum = 370;BA.debugLine="SetHeader(h)";
Debug.ShouldStop(131072);
__ref.runClassMethod (com.ServicioSocial.table.class, "_setheader",(Object)(_h));
 BA.debugLineNum = 371;BA.debugLine="For Each row() As String In List1";
Debug.ShouldStop(262144);
{
final RemoteObject group22 = _list1;
final int groupLen22 = group22.runMethod(true,"getSize").<Integer>get()
;int index22 = 0;
;
for (; index22 < groupLen22;index22++){
_row = (group22.runMethod(false,"Get",index22));Debug.locals.put("row", _row);
Debug.locals.put("row", _row);
 BA.debugLineNum = 372;BA.debugLine="AddRow(row)";
Debug.ShouldStop(524288);
__ref.runClassMethod (com.ServicioSocial.table.class, "_addrow",(Object)(_row));
 }
}Debug.locals.put("row", _row);
;
 BA.debugLineNum = 374;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _removerow(RemoteObject __ref,RemoteObject _row) throws Exception{
try {
		Debug.PushSubsStack("RemoveRow (table) ","table",6,__ref.getField(false, "ba"),__ref,160);
if (RapidSub.canDelegate("removerow")) { return __ref.runUserSub(false, "table","removerow", __ref, _row);}
RemoteObject _sr = RemoteObject.createImmutable(0);
int _i = 0;
Debug.locals.put("Row", _row);
 BA.debugLineNum = 160;BA.debugLine="Public Sub RemoveRow(Row As Int)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 161;BA.debugLine="SV_ScrollChanged(SV.ScrollPosition)";
Debug.ShouldStop(1);
__ref.runClassMethod (com.ServicioSocial.table.class, "_sv_scrollchanged",(Object)(__ref.getField(false,"_sv").runMethod(true,"getScrollPosition")));
 BA.debugLineNum = 162;BA.debugLine="Dim sr As Int = SelectedRow";
Debug.ShouldStop(2);
_sr = __ref.getField(true,"_selectedrow");Debug.locals.put("sr", _sr);Debug.locals.put("sr", _sr);
 BA.debugLineNum = 163;BA.debugLine="SelectRow(-1)";
Debug.ShouldStop(4);
__ref.runClassMethod (com.ServicioSocial.table.class, "_selectrow",(Object)(BA.numberCast(int.class, -(double) (0 + 1))));
 BA.debugLineNum = 164;BA.debugLine="Data.RemoveAt(Row)";
Debug.ShouldStop(8);
__ref.getField(false,"_data").runVoidMethod ("RemoveAt",(Object)(_row));
 BA.debugLineNum = 165;BA.debugLine="If Data.Size = 0 Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",__ref.getField(false,"_data").runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 166;BA.debugLine="ClearAll";
Debug.ShouldStop(32);
__ref.runClassMethod (com.ServicioSocial.table.class, "_clearall");
 BA.debugLineNum = 167;BA.debugLine="Return";
Debug.ShouldStop(64);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 169;BA.debugLine="For i = minVisibleRow To maxVisibleRow";
Debug.ShouldStop(256);
{
final int step9 = 1;
final int limit9 = __ref.getField(true,"_maxvisiblerow").<Integer>get().intValue();
_i = __ref.getField(true,"_minvisiblerow").<Integer>get().intValue() ;
for (;(step9 > 0 && _i <= limit9) || (step9 < 0 && _i >= limit9) ;_i = ((int)(0 + _i + step9))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 170;BA.debugLine="HideRow(i)";
Debug.ShouldStop(512);
__ref.runClassMethod (com.ServicioSocial.table.class, "_hiderow",(Object)(BA.numberCast(int.class, _i)));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 172;BA.debugLine="maxVisibleRow = Min(maxVisibleRow, Data.Size - 1)";
Debug.ShouldStop(2048);
__ref.setField ("_maxvisiblerow",BA.numberCast(int.class, table.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, __ref.getField(true,"_maxvisiblerow"))),(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_data").runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1))))));
 BA.debugLineNum = 173;BA.debugLine="minVisibleRow = Min(minVisibleRow, Data.Size - 1)";
Debug.ShouldStop(4096);
__ref.setField ("_minvisiblerow",BA.numberCast(int.class, table.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, __ref.getField(true,"_minvisiblerow"))),(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_data").runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1))))));
 BA.debugLineNum = 174;BA.debugLine="For i = minVisibleRow To maxVisibleRow";
Debug.ShouldStop(8192);
{
final int step14 = 1;
final int limit14 = __ref.getField(true,"_maxvisiblerow").<Integer>get().intValue();
_i = __ref.getField(true,"_minvisiblerow").<Integer>get().intValue() ;
for (;(step14 > 0 && _i <= limit14) || (step14 < 0 && _i >= limit14) ;_i = ((int)(0 + _i + step14))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 175;BA.debugLine="ShowRow(i)";
Debug.ShouldStop(16384);
__ref.runClassMethod (com.ServicioSocial.table.class, "_showrow",(Object)(BA.numberCast(int.class, _i)));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 177;BA.debugLine="If sr = Row Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",_sr,BA.numberCast(double.class, _row))) { 
 BA.debugLineNum = 178;BA.debugLine="sr = -1";
Debug.ShouldStop(131072);
_sr = BA.numberCast(int.class, -(double) (0 + 1));Debug.locals.put("sr", _sr);
 }else 
{ BA.debugLineNum = 179;BA.debugLine="Else If sr > Row Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean(">",_sr,BA.numberCast(double.class, _row))) { 
 BA.debugLineNum = 180;BA.debugLine="sr = sr - 1";
Debug.ShouldStop(524288);
_sr = RemoteObject.solve(new RemoteObject[] {_sr,RemoteObject.createImmutable(1)}, "-",1, 1);Debug.locals.put("sr", _sr);
 }}
;
 BA.debugLineNum = 182;BA.debugLine="SelectRow(sr)";
Debug.ShouldStop(2097152);
__ref.runClassMethod (com.ServicioSocial.table.class, "_selectrow",(Object)(_sr));
 BA.debugLineNum = 183;BA.debugLine="SV.Panel.Height = Data.Size * RowHeight";
Debug.ShouldStop(4194304);
__ref.getField(false,"_sv").runMethod(false,"getPanel").runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_data").runMethod(true,"getSize"),__ref.getField(true,"_rowheight")}, "*",0, 1));
 BA.debugLineNum = 184;BA.debugLine="SV_ScrollChanged(Min(SV.ScrollPosition, SV.Panel.";
Debug.ShouldStop(8388608);
__ref.runClassMethod (com.ServicioSocial.table.class, "_sv_scrollchanged",(Object)(BA.numberCast(int.class, table.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, __ref.getField(false,"_sv").runMethod(true,"getScrollPosition"))),(Object)(BA.numberCast(double.class, __ref.getField(false,"_sv").runMethod(false,"getPanel").runMethod(true,"getHeight")))))));
 BA.debugLineNum = 185;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _savetabletocsv(RemoteObject __ref,RemoteObject _dir,RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("SaveTableToCSV (table) ","table",6,__ref.getField(false, "ba"),__ref,377);
if (RapidSub.canDelegate("savetabletocsv")) { return __ref.runUserSub(false, "table","savetabletocsv", __ref, _dir, _filename);}
RemoteObject _headers = null;
RemoteObject _i = RemoteObject.createImmutable(0);
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
Debug.locals.put("Dir", _dir);
Debug.locals.put("Filename", _filename);
 BA.debugLineNum = 377;BA.debugLine="Public Sub SaveTableToCSV(Dir As String, Filename";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 378;BA.debugLine="Dim headers(NumberOfColumns) As String";
Debug.ShouldStop(33554432);
_headers = RemoteObject.createNewArray ("String", new int[] {__ref.getField(true,"_numberofcolumns").<Integer>get().intValue()}, new Object[]{});Debug.locals.put("headers", _headers);
 BA.debugLineNum = 379;BA.debugLine="Dim i As Int";
Debug.ShouldStop(67108864);
_i = RemoteObject.createImmutable(0);Debug.locals.put("i", _i);
 BA.debugLineNum = 380;BA.debugLine="For Each l As Label In Header";
Debug.ShouldStop(134217728);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
{
final RemoteObject group3 = __ref.getField(false,"_header");
final int groupLen3 = group3.runMethod(true,"getSize").<Integer>get()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_l.setObject(group3.runMethod(false,"Get",index3));
Debug.locals.put("l", _l);
 BA.debugLineNum = 381;BA.debugLine="headers(i) = l.Text";
Debug.ShouldStop(268435456);
_headers.setArrayElement (_l.runMethod(true,"getText"),_i);
 BA.debugLineNum = 382;BA.debugLine="i = i + 1";
Debug.ShouldStop(536870912);
_i = RemoteObject.solve(new RemoteObject[] {_i,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("i", _i);
 }
}Debug.locals.put("l", _l);
;
 BA.debugLineNum = 384;BA.debugLine="StringUtils1.SaveCSV2(Dir, Filename, \",\", Data, h";
Debug.ShouldStop(-2147483648);
__ref.getField(false,"_stringutils1").runVoidMethod ("SaveCSV2",(Object)(_dir),(Object)(_filename),(Object)(BA.ObjectToChar(",")),(Object)(__ref.getField(false,"_data")),(Object)(table.__c.runMethod(false, "ArrayToList", (Object)(_headers))));
 BA.debugLineNum = 385;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _selectrow(RemoteObject __ref,RemoteObject _row) throws Exception{
try {
		Debug.PushSubsStack("SelectRow (table) ","table",6,__ref.getField(false, "ba"),__ref,321);
if (RapidSub.canDelegate("selectrow")) { return __ref.runUserSub(false, "table","selectrow", __ref, _row);}
RemoteObject _prev = RemoteObject.createImmutable(0);
int _col = 0;
Debug.locals.put("Row", _row);
 BA.debugLineNum = 321;BA.debugLine="Private Sub SelectRow(Row As Int)";
Debug.ShouldStop(1);
 BA.debugLineNum = 322;BA.debugLine="Dim prev As Int";
Debug.ShouldStop(2);
_prev = RemoteObject.createImmutable(0);Debug.locals.put("prev", _prev);
 BA.debugLineNum = 323;BA.debugLine="prev = SelectedRow";
Debug.ShouldStop(4);
_prev = __ref.getField(true,"_selectedrow");Debug.locals.put("prev", _prev);
 BA.debugLineNum = 324;BA.debugLine="SelectedRow = Row";
Debug.ShouldStop(8);
__ref.setField ("_selectedrow",_row);
 BA.debugLineNum = 326;BA.debugLine="If prev > -1 Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean(">",_prev,BA.numberCast(double.class, -(double) (0 + 1)))) { 
 BA.debugLineNum = 327;BA.debugLine="If visibleRows.ContainsKey(prev) Then";
Debug.ShouldStop(64);
if (__ref.getField(false,"_visiblerows").runMethod(true,"ContainsKey",(Object)((_prev))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 328;BA.debugLine="HideRow(prev)";
Debug.ShouldStop(128);
__ref.runClassMethod (com.ServicioSocial.table.class, "_hiderow",(Object)(_prev));
 BA.debugLineNum = 329;BA.debugLine="ShowRow(prev)";
Debug.ShouldStop(256);
__ref.runClassMethod (com.ServicioSocial.table.class, "_showrow",(Object)(_prev));
 };
 };
 BA.debugLineNum = 332;BA.debugLine="SelectedRow = Row";
Debug.ShouldStop(2048);
__ref.setField ("_selectedrow",_row);
 BA.debugLineNum = 333;BA.debugLine="For col = 0 To NumberOfColumns - 1";
Debug.ShouldStop(4096);
{
final int step11 = 1;
final int limit11 = RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_numberofcolumns"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_col = 0 ;
for (;(step11 > 0 && _col <= limit11) || (step11 < 0 && _col >= limit11) ;_col = ((int)(0 + _col + step11))  ) {
Debug.locals.put("col", _col);
 BA.debugLineNum = 334;BA.debugLine="If visibleRows.ContainsKey(SelectedRow) Then";
Debug.ShouldStop(8192);
if (__ref.getField(false,"_visiblerows").runMethod(true,"ContainsKey",(Object)((__ref.getField(true,"_selectedrow")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 335;BA.debugLine="HideRow(SelectedRow)";
Debug.ShouldStop(16384);
__ref.runClassMethod (com.ServicioSocial.table.class, "_hiderow",(Object)(__ref.getField(true,"_selectedrow")));
 BA.debugLineNum = 336;BA.debugLine="ShowRow(SelectedRow)";
Debug.ShouldStop(32768);
__ref.runClassMethod (com.ServicioSocial.table.class, "_showrow",(Object)(__ref.getField(true,"_selectedrow")));
 };
 }
}Debug.locals.put("col", _col);
;
 BA.debugLineNum = 339;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setcolumnswidths(RemoteObject __ref,RemoteObject _widths) throws Exception{
try {
		Debug.PushSubsStack("SetColumnsWidths (table) ","table",6,__ref.getField(false, "ba"),__ref,45);
if (RapidSub.canDelegate("setcolumnswidths")) { return __ref.runUserSub(false, "table","setcolumnswidths", __ref, _widths);}
RemoteObject _v = RemoteObject.declareNull("anywheresoftware.b4a.objects.ConcreteViewWrapper");
int _i = 0;
RemoteObject _lbls = null;
int _lbl = 0;
Debug.locals.put("Widths", _widths);
 BA.debugLineNum = 45;BA.debugLine="Public Sub SetColumnsWidths(Widths() As Int)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 46;BA.debugLine="Dim v As View";
Debug.ShouldStop(8192);
_v = RemoteObject.createNew ("anywheresoftware.b4a.objects.ConcreteViewWrapper");Debug.locals.put("v", _v);
 BA.debugLineNum = 47;BA.debugLine="For i = 0 To Widths.Length - 1";
Debug.ShouldStop(16384);
{
final int step2 = 1;
final int limit2 = RemoteObject.solve(new RemoteObject[] {_widths.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2) ;_i = ((int)(0 + _i + step2))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 48;BA.debugLine="v = Header.GetView(i)";
Debug.ShouldStop(32768);
_v = __ref.getField(false,"_header").runMethod(false,"GetView",(Object)(BA.numberCast(int.class, _i)));Debug.locals.put("v", _v);
 BA.debugLineNum = 49;BA.debugLine="v.Width = Widths(i) - 1dip";
Debug.ShouldStop(65536);
_v.runMethod(true,"setWidth",RemoteObject.solve(new RemoteObject[] {_widths.getArrayElement(true,BA.numberCast(int.class, _i)),table.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "-",1, 1));
 BA.debugLineNum = 50;BA.debugLine="If i > 0 Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean(">",RemoteObject.createImmutable(_i),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 51;BA.debugLine="v.Left = Header.GetView(i-1).Left + Widths(i-1)";
Debug.ShouldStop(262144);
_v.runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_header").runMethod(false,"GetView",(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "-",1, 1))).runMethod(true,"getLeft"),_widths.getArrayElement(true,RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "-",1, 1)),table.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "++",2, 1));
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 54;BA.debugLine="Dim lbls() As Label";
Debug.ShouldStop(2097152);
_lbls = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.LabelWrapper", new int[] {0}, new Object[]{});Debug.locals.put("lbls", _lbls);
 BA.debugLineNum = 55;BA.debugLine="For i = 0 To visibleRows.Size - 1";
Debug.ShouldStop(4194304);
{
final int step10 = 1;
final int limit10 = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_visiblerows").runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step10 > 0 && _i <= limit10) || (step10 < 0 && _i >= limit10) ;_i = ((int)(0 + _i + step10))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 56;BA.debugLine="lbls = visibleRows.GetValueAt(i)";
Debug.ShouldStop(8388608);
_lbls = (__ref.getField(false,"_visiblerows").runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("lbls", _lbls);
 BA.debugLineNum = 57;BA.debugLine="For lbl = 0 To lbls.Length - 1";
Debug.ShouldStop(16777216);
{
final int step12 = 1;
final int limit12 = RemoteObject.solve(new RemoteObject[] {_lbls.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_lbl = 0 ;
for (;(step12 > 0 && _lbl <= limit12) || (step12 < 0 && _lbl >= limit12) ;_lbl = ((int)(0 + _lbl + step12))  ) {
Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 58;BA.debugLine="lbls(lbl).SetLayout(Header.GetView(lbl).Left, l";
Debug.ShouldStop(33554432);
_lbls.getArrayElement(false,BA.numberCast(int.class, _lbl)).runVoidMethod ("SetLayout",(Object)(__ref.getField(false,"_header").runMethod(false,"GetView",(Object)(BA.numberCast(int.class, _lbl))).runMethod(true,"getLeft")),(Object)(_lbls.getArrayElement(false,BA.numberCast(int.class, _lbl)).runMethod(true,"getTop")),(Object)(__ref.getField(false,"_header").runMethod(false,"GetView",(Object)(BA.numberCast(int.class, _lbl))).runMethod(true,"getWidth")),(Object)(__ref.getField(true,"_rowheight")));
 }
}Debug.locals.put("lbl", _lbl);
;
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 62;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setheader(RemoteObject __ref,RemoteObject _values) throws Exception{
try {
		Debug.PushSubsStack("SetHeader (table) ","table",6,__ref.getField(false, "ba"),__ref,265);
if (RapidSub.canDelegate("setheader")) { return __ref.runUserSub(false, "table","setheader", __ref, _values);}
int _i = 0;
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
Debug.locals.put("Values", _values);
 BA.debugLineNum = 265;BA.debugLine="Public Sub SetHeader(Values() As String)";
Debug.ShouldStop(256);
 BA.debugLineNum = 266;BA.debugLine="For I = Header.NumberOfViews - 1 To 0 Step -1";
Debug.ShouldStop(512);
{
final int step1 = -1;
final int limit1 = 0;
_i = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_header").runMethod(true,"getNumberOfViews"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue() ;
for (;(step1 > 0 && _i <= limit1) || (step1 < 0 && _i >= limit1) ;_i = ((int)(0 + _i + step1))  ) {
Debug.locals.put("I", _i);
 BA.debugLineNum = 267;BA.debugLine="Header.RemoveViewAt(I)";
Debug.ShouldStop(1024);
__ref.getField(false,"_header").runVoidMethod ("RemoveViewAt",(Object)(BA.numberCast(int.class, _i)));
 }
}Debug.locals.put("I", _i);
;
 BA.debugLineNum = 269;BA.debugLine="For I = 0 To NumberOfColumns - 1";
Debug.ShouldStop(4096);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_numberofcolumns"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
Debug.locals.put("I", _i);
 BA.debugLineNum = 270;BA.debugLine="Dim l As Label";
Debug.ShouldStop(8192);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("l", _l);
 BA.debugLineNum = 271;BA.debugLine="l.Initialize(\"header\")";
Debug.ShouldStop(16384);
_l.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("header")));
 BA.debugLineNum = 272;BA.debugLine="l.Gravity = Gravity.CENTER";
Debug.ShouldStop(32768);
_l.runMethod(true,"setGravity",table.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 273;BA.debugLine="l.TextSize = FontSize";
Debug.ShouldStop(65536);
_l.runMethod(true,"setTextSize",__ref.getField(true,"_fontsize"));
 BA.debugLineNum = 274;BA.debugLine="l.Color = HeaderColor";
Debug.ShouldStop(131072);
_l.runVoidMethod ("setColor",__ref.getField(true,"_headercolor"));
 BA.debugLineNum = 275;BA.debugLine="l.TextColor = HeaderFontColor";
Debug.ShouldStop(262144);
_l.runMethod(true,"setTextColor",__ref.getField(true,"_headerfontcolor"));
 BA.debugLineNum = 276;BA.debugLine="l.Text = Values(I)";
Debug.ShouldStop(524288);
_l.runMethod(true,"setText",BA.ObjectToCharSequence(_values.getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 277;BA.debugLine="l.Tag = I";
Debug.ShouldStop(1048576);
_l.runMethod(false,"setTag",RemoteObject.createImmutable((_i)));
 BA.debugLineNum = 278;BA.debugLine="Header.AddView(l, ColumnWidth * I, 0, ColumnWidt";
Debug.ShouldStop(2097152);
__ref.getField(false,"_header").runVoidMethod ("AddView",(Object)((_l.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_columnwidth"),RemoteObject.createImmutable(_i)}, "*",0, 1)),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_columnwidth"),table.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "-",1, 1)),(Object)(__ref.getField(true,"_rowheight")));
 }
}Debug.locals.put("I", _i);
;
 BA.debugLineNum = 280;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setvalue(RemoteObject __ref,RemoteObject _col,RemoteObject _row,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("SetValue (table) ","table",6,__ref.getField(false, "ba"),__ref,310);
if (RapidSub.canDelegate("setvalue")) { return __ref.runUserSub(false, "table","setvalue", __ref, _col, _row, _value);}
RemoteObject _values = null;
RemoteObject _lbls = null;
Debug.locals.put("Col", _col);
Debug.locals.put("Row", _row);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 310;BA.debugLine="Public Sub SetValue(Col As Int, Row As Int, Value";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 311;BA.debugLine="Dim values() As String";
Debug.ShouldStop(4194304);
_values = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});Debug.locals.put("values", _values);
 BA.debugLineNum = 312;BA.debugLine="values = Data.Get(Row)";
Debug.ShouldStop(8388608);
_values = (__ref.getField(false,"_data").runMethod(false,"Get",(Object)(_row)));Debug.locals.put("values", _values);
 BA.debugLineNum = 313;BA.debugLine="values(Col) = Value";
Debug.ShouldStop(16777216);
_values.setArrayElement (_value,_col);
 BA.debugLineNum = 314;BA.debugLine="If visibleRows.ContainsKey(Row) Then";
Debug.ShouldStop(33554432);
if (__ref.getField(false,"_visiblerows").runMethod(true,"ContainsKey",(Object)((_row))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 315;BA.debugLine="Dim lbls() As Label";
Debug.ShouldStop(67108864);
_lbls = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.LabelWrapper", new int[] {0}, new Object[]{});Debug.locals.put("lbls", _lbls);
 BA.debugLineNum = 316;BA.debugLine="lbls = visibleRows.Get(Row)";
Debug.ShouldStop(134217728);
_lbls = (__ref.getField(false,"_visiblerows").runMethod(false,"Get",(Object)((_row))));Debug.locals.put("lbls", _lbls);
 BA.debugLineNum = 317;BA.debugLine="lbls(Col).Text = Value";
Debug.ShouldStop(268435456);
_lbls.getArrayElement(false,_col).runMethod(true,"setText",BA.ObjectToCharSequence(_value));
 };
 BA.debugLineNum = 319;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _showrow(RemoteObject __ref,RemoteObject _row) throws Exception{
try {
		Debug.PushSubsStack("ShowRow (table) ","table",6,__ref.getField(false, "ba"),__ref,187);
if (RapidSub.canDelegate("showrow")) { return __ref.runUserSub(false, "table","showrow", __ref, _row);}
RemoteObject _lbls = null;
RemoteObject _values = null;
RemoteObject _rowcolor = null;
int _i = 0;
Debug.locals.put("row", _row);
 BA.debugLineNum = 187;BA.debugLine="Private Sub ShowRow(row As Int)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 188;BA.debugLine="If visibleRows.ContainsKey(row) Then Return";
Debug.ShouldStop(134217728);
if (__ref.getField(false,"_visiblerows").runMethod(true,"ContainsKey",(Object)((_row))).<Boolean>get().booleanValue()) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 190;BA.debugLine="Dim lbls() As Label";
Debug.ShouldStop(536870912);
_lbls = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.LabelWrapper", new int[] {0}, new Object[]{});Debug.locals.put("lbls", _lbls);
 BA.debugLineNum = 191;BA.debugLine="Dim values() As String";
Debug.ShouldStop(1073741824);
_values = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});Debug.locals.put("values", _values);
 BA.debugLineNum = 192;BA.debugLine="lbls = GetLabels(row)";
Debug.ShouldStop(-2147483648);
_lbls = __ref.runClassMethod (com.ServicioSocial.table.class, "_getlabels",(Object)(_row));Debug.locals.put("lbls", _lbls);
 BA.debugLineNum = 193;BA.debugLine="values = Data.Get(row)";
Debug.ShouldStop(1);
_values = (__ref.getField(false,"_data").runMethod(false,"Get",(Object)(_row)));Debug.locals.put("values", _values);
 BA.debugLineNum = 194;BA.debugLine="visibleRows.Put(row, lbls)";
Debug.ShouldStop(2);
__ref.getField(false,"_visiblerows").runVoidMethod ("Put",(Object)((_row)),(Object)((_lbls)));
 BA.debugLineNum = 195;BA.debugLine="Dim rowColor() As Object";
Debug.ShouldStop(4);
_rowcolor = RemoteObject.createNewArray ("Object", new int[] {0}, new Object[]{});Debug.locals.put("rowColor", _rowcolor);
 BA.debugLineNum = 196;BA.debugLine="If row = SelectedRow Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",_row,BA.numberCast(double.class, __ref.getField(true,"_selectedrow")))) { 
 BA.debugLineNum = 197;BA.debugLine="rowColor = SelectedDrawable";
Debug.ShouldStop(16);
_rowcolor = __ref.getField(false,"_selecteddrawable");Debug.locals.put("rowColor", _rowcolor);
 }else 
{ BA.debugLineNum = 198;BA.debugLine="Else If row Mod 2  = 0 Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",RemoteObject.solve(new RemoteObject[] {_row,RemoteObject.createImmutable(2)}, "%",0, 1),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 199;BA.debugLine="rowColor = Drawable1";
Debug.ShouldStop(64);
_rowcolor = __ref.getField(false,"_drawable1");Debug.locals.put("rowColor", _rowcolor);
 }else {
 BA.debugLineNum = 201;BA.debugLine="rowColor = Drawable2";
Debug.ShouldStop(256);
_rowcolor = __ref.getField(false,"_drawable2");Debug.locals.put("rowColor", _rowcolor);
 }}
;
 BA.debugLineNum = 203;BA.debugLine="For I = 0 To lbls.Length - 1";
Debug.ShouldStop(1024);
{
final int step15 = 1;
final int limit15 = RemoteObject.solve(new RemoteObject[] {_lbls.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step15 > 0 && _i <= limit15) || (step15 < 0 && _i >= limit15) ;_i = ((int)(0 + _i + step15))  ) {
Debug.locals.put("I", _i);
 BA.debugLineNum = 204;BA.debugLine="SV.Panel.AddView(lbls(I), Header.GetView(I).Left";
Debug.ShouldStop(2048);
__ref.getField(false,"_sv").runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_lbls.getArrayElement(false,BA.numberCast(int.class, _i)).getObject())),(Object)(__ref.getField(false,"_header").runMethod(false,"GetView",(Object)(BA.numberCast(int.class, _i))).runMethod(true,"getLeft")),(Object)(RemoteObject.solve(new RemoteObject[] {_row,__ref.getField(true,"_rowheight")}, "*",0, 1)),(Object)(__ref.getField(false,"_header").runMethod(false,"GetView",(Object)(BA.numberCast(int.class, _i))).runMethod(true,"getWidth")),(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_rowheight"),table.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "-",1, 1)));
 BA.debugLineNum = 206;BA.debugLine="lbls(I).Text = values(I)";
Debug.ShouldStop(8192);
_lbls.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setText",BA.ObjectToCharSequence(_values.getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 207;BA.debugLine="lbls(I).Background = rowColor(I)";
Debug.ShouldStop(16384);
_lbls.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(false,"setBackground",(_rowcolor.getArrayElement(false,BA.numberCast(int.class, _i))));
 }
}Debug.locals.put("I", _i);
;
 BA.debugLineNum = 209;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _size(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("Size (table) ","table",6,__ref.getField(false, "ba"),__ref,387);
if (RapidSub.canDelegate("size")) { return __ref.runUserSub(false, "table","size", __ref);}
 BA.debugLineNum = 387;BA.debugLine="Public Sub Size As Int";
Debug.ShouldStop(4);
 BA.debugLineNum = 388;BA.debugLine="Return Data.Size";
Debug.ShouldStop(8);
if (true) return __ref.getField(false,"_data").runMethod(true,"getSize");
 BA.debugLineNum = 389;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sv_scrollchanged(RemoteObject __ref,RemoteObject _position) throws Exception{
try {
		Debug.PushSubsStack("SV_ScrollChanged (table) ","table",6,__ref.getField(false, "ba"),__ref,99);
if (RapidSub.canDelegate("sv_scrollchanged")) { return __ref.runUserSub(false, "table","sv_scrollchanged", __ref, _position);}
RemoteObject _currentmin = RemoteObject.createImmutable(0);
RemoteObject _currentmax = RemoteObject.createImmutable(0);
int _i = 0;
Debug.locals.put("Position", _position);
 BA.debugLineNum = 99;BA.debugLine="Private Sub SV_ScrollChanged(Position As Int)";
Debug.ShouldStop(4);
 BA.debugLineNum = 100;BA.debugLine="Dim currentMin, currentMax As Int";
Debug.ShouldStop(8);
_currentmin = RemoteObject.createImmutable(0);Debug.locals.put("currentMin", _currentmin);
_currentmax = RemoteObject.createImmutable(0);Debug.locals.put("currentMax", _currentmax);
 BA.debugLineNum = 101;BA.debugLine="currentMin = Max(0, Position / RowHeight - 30)";
Debug.ShouldStop(16);
_currentmin = BA.numberCast(int.class, table.__c.runMethod(true,"Max",(Object)(BA.numberCast(double.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_position,__ref.getField(true,"_rowheight"),RemoteObject.createImmutable(30)}, "/-",1, 0))));Debug.locals.put("currentMin", _currentmin);
 BA.debugLineNum = 102;BA.debugLine="currentMax = Min(Data.Size - 1, (Position + SV.He";
Debug.ShouldStop(32);
_currentmax = BA.numberCast(int.class, table.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_data").runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1))),(Object)(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_position,__ref.getField(false,"_sv").runMethod(true,"getHeight")}, "+",1, 1)),__ref.getField(true,"_rowheight"),RemoteObject.createImmutable(30)}, "/+",1, 0))));Debug.locals.put("currentMax", _currentmax);
 BA.debugLineNum = 103;BA.debugLine="If minVisibleRow > -1 Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean(">",__ref.getField(true,"_minvisiblerow"),BA.numberCast(double.class, -(double) (0 + 1)))) { 
 BA.debugLineNum = 104;BA.debugLine="If minVisibleRow < currentMin Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("<",__ref.getField(true,"_minvisiblerow"),BA.numberCast(double.class, _currentmin))) { 
 BA.debugLineNum = 106;BA.debugLine="For I = minVisibleRow To Min(currentMin - 1, ma";
Debug.ShouldStop(512);
{
final int step6 = 1;
final int limit6 = (int) (0 + table.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_currentmin,RemoteObject.createImmutable(1)}, "-",1, 1))),(Object)(BA.numberCast(double.class, __ref.getField(true,"_maxvisiblerow")))).<Double>get().doubleValue());
_i = __ref.getField(true,"_minvisiblerow").<Integer>get().intValue() ;
for (;(step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6) ;_i = ((int)(0 + _i + step6))  ) {
Debug.locals.put("I", _i);
 BA.debugLineNum = 107;BA.debugLine="HideRow(I)";
Debug.ShouldStop(1024);
__ref.runClassMethod (com.ServicioSocial.table.class, "_hiderow",(Object)(BA.numberCast(int.class, _i)));
 }
}Debug.locals.put("I", _i);
;
 }else 
{ BA.debugLineNum = 109;BA.debugLine="Else If minVisibleRow > currentMin Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean(">",__ref.getField(true,"_minvisiblerow"),BA.numberCast(double.class, _currentmin))) { 
 BA.debugLineNum = 111;BA.debugLine="For I = currentMin To Min(minVisibleRow - 1, cu";
Debug.ShouldStop(16384);
{
final int step10 = 1;
final int limit10 = (int) (0 + table.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_minvisiblerow"),RemoteObject.createImmutable(1)}, "-",1, 1))),(Object)(BA.numberCast(double.class, _currentmax))).<Double>get().doubleValue());
_i = _currentmin.<Integer>get().intValue() ;
for (;(step10 > 0 && _i <= limit10) || (step10 < 0 && _i >= limit10) ;_i = ((int)(0 + _i + step10))  ) {
Debug.locals.put("I", _i);
 BA.debugLineNum = 112;BA.debugLine="ShowRow(I)";
Debug.ShouldStop(32768);
__ref.runClassMethod (com.ServicioSocial.table.class, "_showrow",(Object)(BA.numberCast(int.class, _i)));
 }
}Debug.locals.put("I", _i);
;
 }}
;
 BA.debugLineNum = 115;BA.debugLine="If maxVisibleRow > currentMax Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean(">",__ref.getField(true,"_maxvisiblerow"),BA.numberCast(double.class, _currentmax))) { 
 BA.debugLineNum = 117;BA.debugLine="For I = maxVisibleRow To Max(currentMax + 1, mi";
Debug.ShouldStop(1048576);
{
final int step15 = -1;
final int limit15 = (int) (0 + table.__c.runMethod(true,"Max",(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_currentmax,RemoteObject.createImmutable(1)}, "+",1, 1))),(Object)(BA.numberCast(double.class, __ref.getField(true,"_minvisiblerow")))).<Double>get().doubleValue());
_i = __ref.getField(true,"_maxvisiblerow").<Integer>get().intValue() ;
for (;(step15 > 0 && _i <= limit15) || (step15 < 0 && _i >= limit15) ;_i = ((int)(0 + _i + step15))  ) {
Debug.locals.put("I", _i);
 BA.debugLineNum = 118;BA.debugLine="HideRow(I)";
Debug.ShouldStop(2097152);
__ref.runClassMethod (com.ServicioSocial.table.class, "_hiderow",(Object)(BA.numberCast(int.class, _i)));
 }
}Debug.locals.put("I", _i);
;
 }else 
{ BA.debugLineNum = 120;BA.debugLine="Else If maxVisibleRow < currentMax Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("<",__ref.getField(true,"_maxvisiblerow"),BA.numberCast(double.class, _currentmax))) { 
 BA.debugLineNum = 122;BA.debugLine="For I = currentMax To Max(maxVisibleRow + 1, cu";
Debug.ShouldStop(33554432);
{
final int step19 = -1;
final int limit19 = (int) (0 + table.__c.runMethod(true,"Max",(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_maxvisiblerow"),RemoteObject.createImmutable(1)}, "+",1, 1))),(Object)(BA.numberCast(double.class, _currentmin))).<Double>get().doubleValue());
_i = _currentmax.<Integer>get().intValue() ;
for (;(step19 > 0 && _i <= limit19) || (step19 < 0 && _i >= limit19) ;_i = ((int)(0 + _i + step19))  ) {
Debug.locals.put("I", _i);
 BA.debugLineNum = 123;BA.debugLine="ShowRow(I)";
Debug.ShouldStop(67108864);
__ref.runClassMethod (com.ServicioSocial.table.class, "_showrow",(Object)(BA.numberCast(int.class, _i)));
 }
}Debug.locals.put("I", _i);
;
 }}
;
 };
 BA.debugLineNum = 127;BA.debugLine="minVisibleRow = currentMin";
Debug.ShouldStop(1073741824);
__ref.setField ("_minvisiblerow",_currentmin);
 BA.debugLineNum = 128;BA.debugLine="maxVisibleRow = currentMax";
Debug.ShouldStop(-2147483648);
__ref.setField ("_maxvisiblerow",_currentmax);
 BA.debugLineNum = 129;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}