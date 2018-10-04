B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=8.3
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Dim Mes As Int
	Dim Periodo As Boolean
	Dim contenido As String
	Dim btmp As Bitmap
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private NoGrupos As Label
	Private Fondo As ImageView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("SelGrupo")
	Mes=0
	btmp.Initialize(File.DirAssets,"Barra_Datos_Evento.png")
	Fondo.SetBackgroundImage(btmp)
	DateTime.DateFormat="M"
	Mes=DateTime.Date(DateTime.Now)
	If Mes>=2 And Mes<=8 Then
		Periodo=True'Significa que esta en el periodo 1 
	Else
		Periodo=False'Significa que esta en el periodo 2
	End If
	contenido=File.ReadString(File.DirAssets,"Grupos.txt")
	If contenido="" Then
		NoGrupos.Visible=True
	Else
		
	End If
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
