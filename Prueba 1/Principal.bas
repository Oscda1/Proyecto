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
	Dim Existen As Boolean
	Dim Contenido As String
	Dim Contador1 As Int
	Dim Contador2 As Int
	Dim CargarEvento As Boolean
	Dim TodosLosGrupos As Boolean
	Dim Temporal As String
	Dim Contador3 As Int
	Dim CantidadGrupos As Int
	Dim DosPuntos As Boolean
	Dim PuntoYComa As String
	Dim NumeroDeInicio As Int
	Dim Seccion As Int
	Dim NombreEvento As String
	Dim FechaEvento As String
	Dim HoraEvento As String
	Dim TipoEvento As String
	Dim NombreDelDocumento As String
	Dim Conferencista As String
	Dim Contador4 As Int
	Dim TotalCaracteres As Boolean
	Dim CantidadCaracteres As Int
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private Eventos As Label
	Private PlusEvento As Button
	Private DetallesEventos As Label
	Private EventosPanel As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("PrincipalLayout")
	Contenido=File.ReadString(File.DirAssets,"eventos.txt")
	TotalCaracteres=False
	CantidadCaracteres=0
	Contador1=-1
	Contador2=0
	Contador3=0
	Contador4=-1
	Seccion=0
	NombreEvento=""
	FechaEvento=""
	HoraEvento=""
	TipoEvento=""
	NombreDelDocumento=""
	Conferencista=""
	DosPuntos=False
	TodosLosGrupos=False
	If (Contenido<>"") Then
		Existen=True
	Else
		Existen=False
	End If
	If Existen Then
		EventosPanel.Visible=True
		Eventos.Visible=False
			CargarEvento=False
			Do While(TotalCaracteres=False)
			Temporal=Contenido.SubString(CantidadCaracteres)
				If Temporal=":" Then
					TotalCaracteres=True
				Else
					CantidadCaracteres=CantidadCaracteres+1
				End If
			Loop
			Do While(Contador1<>CantidadCaracteres)
				Contador1=Contador1+1
				Temporal=Contenido.SubString(Contador1)
				Select Temporal
					Case "|"
						Contador3=Contador3+1
						
					Case "<"
						NumeroDeInicio=Contador1+1
							Do While (DosPuntos=False)
								Contador1=Contador1+1
								PuntoYComa=Contenido.SubString(Contador1)
								Select (PuntoYComa)
									Case ":"
										DosPuntos=True
										
									Case ";"
										CantidadGrupos=CantidadGrupos+1
										
								End Select
								Dim Grupos(CantidadGrupos) As String
							PuntoYComa=False
							Contador2=NumeroDeInicio
							DosPuntos=False
							Do While (DosPuntos=False)
							PuntoYComa=Contenido.SubString(Contador1)
							Select (PuntoYComa)
								Case ":"
									DosPuntos=True
									CargarEvento=True
									
								Case ";"
									Contador2=Contador2+1
									
								Case Else
									Grupos(Contador2)=Grupos(Contador2)+PuntoYComa
							End Select
							Loop
						Loop
						Case Else:
							Select Seccion
								Case 0
									NombreEvento=NombreEvento&Temporal
									
								Case 1
							FechaEvento=FechaEvento&Temporal
									
								Case 2
							HoraEvento=HoraEvento&Temporal
								
								Case 3
							TipoEvento=TipoEvento&Temporal
								
								Case 4
							NombreDelDocumento=NombreDelDocumento&Temporal
								
								Case 5
							Conferencista=Conferencista&Temporal
								
							End Select
					End Select
				Loop
		DetallesEventos.Text="Nombre: "&NombreEvento & CRLF &"Fecha: "&FechaEvento&CRLF&"Hora: "&HoraEvento&CRLF&"Evento: "&TipoEvento&CRLF&"Conferencista: "&Conferencista&"Grupos: "
		Do While (TodosLosGrupos)
			Contador4=Contador4+1
			DetallesEventos.Text=DetallesEventos.Text&Grupos(Contador4)
			If (Contador4=CantidadGrupos) Then
				TodosLosGrupos=True
			End If
		Loop
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