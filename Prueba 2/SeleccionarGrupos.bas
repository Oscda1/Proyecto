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
	Dim Grupos() As String
	Dim Salir As Boolean
	Dim ContadorGrupos As Int
	Dim CuantosGrupos As Int
	Dim Quitar As Int
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private NoGrupos As Label
	Private Fondo As ImageView
	Private Panel1 As Panel
	Private NoHayGrupos As Panel
	Private HayGrupos As Panel
	Private SiGrupos As Label
	Private FondoHayGrupos As ImageView
	Private GruposLista As ListView
	Private OtroGrupo As Button
	
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
	ChecarGrupos
	
	
End Sub

Sub ChecarGrupos
	contenido=File.ReadString(File.DirAssets,"grupos.txt")
	If contenido="" Then
		NoHayGrupos.Visible=True
		HayGrupos.Visible=False
	Else
		HayGrupos.Visible=True
		NoHayGrupos.Visible=False
		Salir=True
		ContadorGrupos=0
		Grupos=Regex.Split(";",contenido)
		CuantosGrupos=Grupos.Length
		CuantosGrupos=CuantosGrupos-1
		ContadorGrupos=-1
		Quitar=0
		GruposLista.Clear
		Do While (ContadorGrupos<CuantosGrupos)
			ContadorGrupos=ContadorGrupos+1
			Log(ContadorGrupos)
			GruposLista.AddSingleLine(Grupos(ContadorGrupos))
		Loop
	End If
End Sub

Sub Activity_Resume
	ChecarGrupos
End Sub

Sub Activity_Pause (UserClosed As Boolean)
	ChecarGrupos
End Sub

Sub OtroGrupo_Click
	
End Sub