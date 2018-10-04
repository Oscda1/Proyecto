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
	Dim Archivo As ReadableWorkbook
	Dim Sheet As ReadableSheet
	Dim NuevoArchivo As WritableWorkbook
	Dim SheetEditable As WritableSheet
	Dim celda As WritableCell
End Sub

Sub Globals
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Archivo.Initialize(File.DirRootExternal,"book1.xls")
	Sheet=Archivo.GetSheet(0)
	NuevoArchivo.Initialize(File.DirRootExternal,"HorarioModificado.xls")
	SheetEditable=NuevoArchivo.AddSheet("Peliculas",0)
	celda.InitializeText(1,0,"Hola Mundo")
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub