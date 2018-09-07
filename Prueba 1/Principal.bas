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
	Dim Existen As Boolean
	Dim Contenido As String
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private Eventos As Label
	Private PlusEvento As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("PrincipalLayout")
	Contenido=File.ReadString(File.DirAssets,"eventos.txt")
	If (Contenido<>Null) Then
		Existen=True
	Else
		Existen=False
	End If
	If Existen Then
		Eventos.Visible=False
	Else
		Eventos.Visible=True
	End If
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub PlusEvento_Click
	
End Sub