B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=8.3
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Dim Mes As Int
	Dim Periodo As Boolean
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private Label1 As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("SelGrupo")
	Mes=0
	DateTime.DateFormat="M"
	Mes=DateTime.Date(DateTime.Now)
	Label1.Text=Mes
	If Mes>=2 And Mes<=8 Then
		Periodo=True'Significa que esta en el periodo 1 
	Else
		Periodo=False'Significa que esta en el periodo 2
	End If
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
