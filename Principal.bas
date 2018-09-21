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
	Dim contenido As String
	Dim cantidades() As String
	Dim Sale As Boolean
	Dim Contador As Int
	Dim NombreEvento As String
	Dim FechaEvento As String
	Dim HoraEvento As String
	Dim NombreDocumento As String
	Dim Conferencista As String
	Dim TipoEvento As String
	Dim Grupos() As String
	Dim btm As Bitmap
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private DetallesEventos As Label
	Private EventosPanel As Panel
	Private Eventos As Label
	Private PlusEvento As Button
	Private Settings As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("PrincipalLayout")
	contenido=File.ReadString(File.DirAssets,"Eventos.txt")
	If contenido="" Then
		Eventos.Visible=True
		EventosPanel.Visible=False
	Else
		btm.Initialize(File.DirAssets,"Barra_Datos_Evento.png")
		DetallesEventos.SetBackgroundImage(btm)
		Eventos.Visible=False
		EventosPanel.Visible=True
		cantidades=Regex.Split("-", contenido)
		Sale=False
		Contador=-1
		Do While Sale=False
			Contador=Contador+1
			Select Contador
				Case 0
					NombreEvento=cantidades(Contador)
				Case 1
					FechaEvento=cantidades(Contador)
				Case 2
					HoraEvento=cantidades(Contador)
				Case 3
					TipoEvento=cantidades(Contador)
				Case 4
					NombreDocumento=cantidades(Contador)
				Case 5
					Conferencista=cantidades(Contador)
				Case 6
					Grupos=Regex.Split(";",cantidades(Contador))
					Sale=True
			End Select
		Loop
		Sale=False
		Contador=-1
		DetallesEventos.Text="El evento "&NombreEvento&" sera el dia "&FechaEvento&" a las "&HoraEvento&" sera un evento de "&TipoEvento&" el documento es "&NombreDocumento&" el conferencista sera "&Conferencista&" y los grupos implicados seran "&CRLF
		Do While Sale=False
			Try
				Contador=Contador+1
				DetallesEventos.Text=DetallesEventos.Text&Grupos(Contador)&CRLF
			Catch
				Sale=True
			End Try
		Loop
	End If
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub PlusEvento_Click
	StartActivity("CrearEvento")	
End Sub

Sub Settings_Click
	
End Sub