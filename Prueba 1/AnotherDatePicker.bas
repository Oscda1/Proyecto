B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=5.78
@EndOfDesignText@
'AnotherDatePicker - v2.00
#Event: Closed (Cancelled As Boolean, Date As Long)
#DesignerProperty: Key: CancelVisible, DisplayName: Cancel Visible, FieldType: Boolean, DefaultValue: True, Description: Whether the cancel button should be displayed.
#DesignerProperty: Key: TodayVisible, DisplayName: Today Visible, FieldType: Boolean, DefaultValue: True
#DesignerProperty: Key: MinYear, DisplayName: Minimum Year, FieldType: Int, DefaultValue: 1970, MinRange: 0, MaxRange: 3000
#DesignerProperty: Key: MaxYear, DisplayName: Maximum Year, FieldType: Int, DefaultValue: 2030, MinRange: 0, MaxRange: 3000
#DesignerProperty: Key: FirstDay, DisplayName: First Day, FieldType: String, DefaultValue: Sunday, List: Sunday|Monday|Tuesday|Wednesday|Thursday|Friday|Saturday, Description: Sets the first day of week.
#DesignerProperty: Key: BackgroundColor, DisplayName: Background Color, FieldType: Color, DefaultValue: #FFCFDCDC
#DesignerProperty: Key: SelectedColor, DisplayName: Selected Color, FieldType: Color, DefaultValue: 0xFF0BA29B
#DesignerProperty: Key: HighlightedColor, DisplayName: Highlighted Color, FieldType: Color, DefaultValue: 0xFFABFFFB
Sub Class_Globals
	Private holder As Panel
	Private cvs, cvsBackground As Canvas
	Private DaysPanel As Panel
	Private month, year As Int
	Private Months As Spinner
	Private Years As Spinner
	Private boxW, boxH As Float
	Private vCorrection As Float
	Private ACTION_UP = 1, ACTION_MOVE = 2, ACTION_DOWN = 0 As Int
	Private tempSelectedDay As Int
	Private DaysPanelBackground As Panel
	Private dayOfWeekOffset As Int
	Private daysInMonth As Int
	Private tempSelectedColor As Int
	Private selectedColor As Int
	Private lblSelectedDay As Label
	Private selectedDate As Long
	Private targetLabel As Label
	Private selectedYear, selectedMonth, selectedDay As Int
	Private Label1 As Label
	Private Label2 As Label
	Private Label3 As Label
	Private Label4 As Label
	Private Label5 As Label
	Private Label6 As Label
	Private Label7 As Label
	Private daysNames() As Label
	Private mTarget As Object	
	Private mEventName As String
	Private waitForAddToActivity As Boolean
	Private minYear, maxYear, firstDay As Int
	Private btnCancel, btnToday As Button
End Sub

'Initializes the picker
Public Sub Initialize (Target As Object, EventName As String)
	mTarget = Target
	mEventName = EventName
End Sub

Public Sub DesignerCreateView(base As Panel, lbl As Label, props As Map)
	Dim targetLabel As Label
	targetLabel.Initialize("lbl")
	targetLabel.TextSize = lbl.TextSize
	targetLabel.TextColor = lbl.TextColor
	base.AddView(targetLabel, 0, 0, base.Width, base.Height)
	base.Color = Colors.Transparent
	waitForAddToActivity = True
	'It is not possible to load a layout when inside the process of loading a layout.
	'AddToActivity loads the DatePicker layout. The solution is to use CallSubDelayed.
	CallSubDelayed2(Me, "AfterLoadLayout", props)
End Sub

Private Sub lbl_Click
	Show
End Sub

Public Sub AfterLoadLayout (Props As Map)
	waitForAddToActivity = False
	holder.Initialize("holder")
	holder.Visible = False
	holder.Color = Colors.Transparent
	Dim act As Activity = Props.Get("activity")
	act.AddView(holder, 0, 0, 100%x, 100%y)
	holder.LoadLayout("DatePicker")
	Dim p As Panel = holder.GetView(0)
	p.Color = Props.Get("BackgroundColor")
	If Props.Get("CancelVisible") = False And Props.Get("TodayVisible") = False Then p.Height = p.Height - 40dip
	btnToday.Visible = Props.Get("TodayVisible")
	btnCancel.Visible = Props.Get("CancelVisible")
	daysNames = Array As Label(Label1, Label2, Label3, Label4, Label5, Label6, Label7)
	Dim et As EditText
	et.Initialize("")
	targetLabel.Background = et.Background 'make the label look like an EditText
	cvs.Initialize(DaysPanel)
	cvsBackground.Initialize(DaysPanelBackground)
	selectedColor = Props.Get("SelectedColor")
	tempSelectedColor = Props.Get("HighlightedColor")	
	month = DateTime.GetMonth(DateTime.Now)
	year = DateTime.GetYear(DateTime.Now)
	minYear = Props.Get("MinYear")
	maxYear = Props.Get("MaxYear")
	For y = minYear To maxYear
		Years.Add(y)
	Next
	For Each m As String In DateUtils.GetMonthsNames
		Months.Add(m)
	Next
	Dim alldays As List = Regex.Split("\|", "Sunday|Monday|Tuesday|Wednesday|Thursday|Friday|Saturday") 'need to escape the splitting character.
	firstDay = alldays.IndexOf(Props.Get("FirstDay"))
	Dim days As List = DateUtils.GetDaysNames
	For i = firstDay To firstDay + 7 - 1
		Dim d As String = days.Get(i Mod 7)
		daysNames(i - firstDay).Text = d.SubString2(0, 2)
	Next
	SetDate(DateTime.Now, False)
	vCorrection = cvs.MeasureStringHeight("1", Typeface.DEFAULT_BOLD, Label1.TextSize) / 2
	boxW = cvs.Bitmap.Width / 7
	boxH = cvs.Bitmap.Height / 6
	lblSelectedDay.Visible = False
	DrawDays
End Sub
'Returns the selected date.
Public Sub GetDate As Long
	Return selectedDate
End Sub
'Sets the selected date.
'UpdateLabel - Whether to update the label text.
Public Sub SetDate(date As Long, UpdateLabel As Boolean)
	If waitForAddToActivity Then
		CallSubDelayed3(Me, "SetDate", date, UpdateLabel)
		Return
	End If
	year = DateTime.GetYear(date)
	month = DateTime.GetMonth(date)
	SelectDay(DateTime.GetDayOfMonth(date), UpdateLabel)
	Years.SelectedIndex = year - minYear
	Months.SelectedIndex = month - 1
End Sub

Private Sub DrawDays
	cvsBackground.DrawColor(Colors.Transparent)
	cvs.DrawColor(Colors.Transparent)
	Dim firstDayOfMonth As Long = DateUtils.SetDate(year, month, 1) - 1
	dayOfWeekOffset = (7 + DateTime.GetDayOfWeek(firstDayOfMonth) - firstDay) Mod 7
	daysInMonth = DateUtils.NumberOfDaysInMonth(month, year)
	If year = selectedYear And month = selectedMonth Then
		'draw the selected box
		DrawBox(cvs, selectedColor, (selectedDay - 1 + dayOfWeekOffset) Mod 7, _
			(selectedDay - 1 + dayOfWeekOffset) / 7)
	End If
	For day = 1 To daysInMonth
		Dim row As Int = (day - 1 + dayOfWeekOffset) / 7
		cvs.DrawText(day, (((dayOfWeekOffset + day - 1) Mod 7) + 0.5) * boxW, _
			(row + 0.5)* boxH + vCorrection, Typeface.DEFAULT_BOLD, Label1.TextSize, Colors.Black, "CENTER")
	Next
	DaysPanel.Invalidate
End Sub

Private Sub SelectDay(day As Int, UpdateLabel As Boolean)
	selectedDate = DateUtils.SetDate(year, month, day)
	selectedDay = day
	selectedMonth = month
	selectedYear = year
	If UpdateLabel Then targetLabel.Text = DateTime.Date(selectedDate)
End Sub
'Hides the picker.
Public Sub Hide
	holder.SetVisibleAnimated(500, False)
	
End Sub

Private Sub DrawBox(c As Canvas, clr As Int, x As Int, y As Int)
	Dim r As Rect
	r.Initialize(x * boxW, y * boxH, (x + 1) * boxW, (y + 1) * boxH)
	c.DrawRect(r, clr, True, 0)
End Sub

Private Sub DaysPanel_Touch (ACTION As Int, X As Float, Y As Float)
	Dim boxX = X / boxW, boxY = Y / boxH As Int
	Dim newSelectedDay As Int = boxY * 7 + boxX + 1 - dayOfWeekOffset
	Dim validDay As Boolean = newSelectedDay > 0 And newSelectedDay <= daysInMonth
	If ACTION = ACTION_DOWN Or ACTION = ACTION_MOVE Then
		If newSelectedDay = tempSelectedDay Then Return
		cvsBackground.DrawColor(Colors.Transparent) 'clear background
		tempSelectedDay = newSelectedDay
		If validDay Then
			DrawBox(cvsBackground, tempSelectedColor, boxX, boxY)
			lblSelectedDay.Text = newSelectedDay
			lblSelectedDay.Visible = True
		Else
			lblSelectedDay.Visible = False
		End If
	Else If ACTION = ACTION_UP Then
		lblSelectedDay.Visible = False
		cvsBackground.DrawColor(Colors.Transparent)
		If validDay Then
			SelectDay(newSelectedDay, True)
			CallSub3(mTarget, mEventName & "_Closed", False, GetDate)
			Hide
		End If
	End If
	DaysPanelBackground.Invalidate
End Sub
'Shows the picker.
Public Sub Show
	If waitForAddToActivity Then 
		'not ready yey
		CallSubDelayed(Me, "show")
		Return
	End If
	holder.SetVisibleAnimated(500, True)
	DrawDays
End Sub

Private Sub btnToday_Click
	SetDate(DateTime.Now, True)
	CallSub3(mTarget, mEventName & "_Closed", False, GetDate)
	Hide
End Sub

Public Sub btnCancel_Click
	CallSub3(mTarget, mEventName & "_Closed", True, GetDate)
	Hide
End Sub

Private Sub Months_ItemClick (Position As Int, Value As Object)
	month = Position + 1
	DrawDays
End Sub

Private Sub Years_ItemClick (Position As Int, Value As Object)
	year = Value
	DrawDays
End Sub
Public Sub IsVisible As Boolean
	Return holder.Visible
End Sub
Private Sub holder_Click
	btnCancel_Click
End Sub