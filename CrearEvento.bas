﻿B4A=true
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
	Dim Bmp As Bitmap
	Dim Bmp2 As Bitmap
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private BarraTitulo As ImageView
	Private ImagenRegresar As ImageView
	Private NombreEventoEditText As FloatLabeledEditText
	Private LabelDate As Label
	Private LabelTime As Label
	Private btnTime As Button
	Private PerfilesEvento As Spinner
	Private Etiqueta_Nombre_Archivo As Label
	Private btnDate As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("NuevoEventoLayout")
	Bmp2=LoadBitmap(File.DirAssets,"Boton_Fecha y hora.png")
	BarraTitulo.Bitmap=LoadBitmap(File.DirAssets,"Barra_Texto_titulo.png")
	ImagenRegresar.Bitmap=LoadBitmap(File.DirAssets,"Boton_retroceso.png")
	NombreEventoEditText.SetBackgroundImage(LoadBitmap(File.DirAssets,"Barra_TextoNombre y Conferencista.png"))
	Bmp.Initialize(File.DirAssets,"Boton_fecha y hora.png")
	PerfilesEvento.Add("Feria de la salud")
	PerfilesEvento.Add("Feria de universidades")
	PerfilesEvento.Add("Aniversario")
	PerfilesEvento.Add("Rendicion de cuentas")
	PerfilesEvento.Add("Estadias")
	PerfilesEvento.Add("Festival navideño")
	PerfilesEvento.Add("Conferencia")
End Sub

Sub btnTime_Click
	Dim ret As String
	Dim td As TimeDialog
	Dim txt As String
	td.Hour = DateTime.GetHour(DateTime.Now)
	td.Minute = DateTime.GetMinute(DateTime.Now)
	td.Is24Hours = True
	ret = td.Show("Seleccione la hora:", "SaveItGood", "Si", "Cancelar","", Bmp)
	ToastMessageShow(ret & " : " & td.Hour & ":" & td.Minute, False)
End Sub


Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub btnDate_Click
	Dim ret As String
	Dim Dd As DateDialog
	Dd.Year = DateTime.GetYear(DateTime.Now)
	Dd.Month = DateTime.GetMonth(DateTime.Now)
	Dd.DayOfMonth = DateTime.GetDayOfMonth(DateTime.Now)
	ret = Dd.Show("Seleccione una Fecha", "SaveItGood", "Seleccionar", "Cancelar", "",Null)
	ToastMessageShow(ret & " : " & Dd.DayOfMonth & "/" & Dd.Month & "/" & Dd.Year , False)
End Sub

Sub PerfilesEvento_ItemClick (Position As Int, Value As Object)
	Select(PerfilesEvento.SelectedIndex)
		Case 6
			
			
	End Select
End Sub

Sub Etiqueta_Nombre_Archivo_Click
	
End Sub