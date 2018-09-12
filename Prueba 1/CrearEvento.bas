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

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private BarraTitulo As ImageView
	Private ImagenRegresar As ImageView
	Private NombreEventoEditText As FloatLabeledEditText
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("NuevoEventoLayout")
	BarraTitulo.Bitmap=LoadBitmap(File.DirAssets,"Barra_Texto_titulo.png")
	ImagenRegresar.Bitmap=LoadBitmap(File.DirAssets,"Boton_retroceso.png")
	NombreEventoEditText.SetBackgroundImage(LoadBitmap(File.DirAssets,"Barra_TextoNombre y Conferencista.png"))
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
