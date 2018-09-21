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
	Dim Contenido As String
	Dim DosPuntos As Boolean
	Dim ContadorCaracter As Int
	Dim LetraTemporal As String
	Dim Seccion As Int
	Dim NombreEvento As String
	Dim FechaEvento As String
	Dim HoraEvento As String
	Dim NombreDocumento As String
	Dim Conferencista As String
	Dim TipoEvento As String
	Dim PrimeraVezEnGrupos As Boolean
	Dim InicioGrupos As Int
	Dim CantidadGrupos As Int
	Dim SeccionGrupo As Int
	Dim DespliegaGrupos As Int
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private EventosPanel As Panel
	Private DetallesEventos As Label
	Private Eventos As Label
	Private PlusEvento As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("PrincipalLayout")
	DespliegaGrupos=0
	SeccionGrupo=0
	CantidadGrupos=0
	Seccion=0
	LetraTemporal=""
	ContadorCaracter=-1
	DosPuntos=False
	NombreEvento=""
	FechaEvento=""
	HoraEvento=""
	NombreDocumento=""
	Conferencista=""
	TipoEvento=""
	InicioGrupos=0
	PrimeraVezEnGrupos=True
	Contenido=File.ReadString(File.DirAssets,"eventos.txt")
	If Contenido<>"" Then
		EventosPanel.Visible=True
		Eventos.Visible=False
	Do While DosPuntos=False
		ContadorCaracter=ContadorCaracter+1
		LetraTemporal=Contenido.SubString(ContadorCaracter)
		Select LetraTemporal
			Case "-"
				Seccion=Seccion+1
				Log(Seccion)
				
			Case ":"
				DosPuntos=True
				
			Case Else
				Select Seccion
					Case 0
						NombreEvento=NombreEvento&LetraTemporal
						
					Case 1
						FechaEvento=FechaEvento&LetraTemporal
						
					Case 2
						HoraEvento=HoraEvento&LetraTemporal
						
					Case 3
						TipoEvento=TipoEvento&LetraTemporal
						
					Case 4
						NombreDocumento=NombreDocumento&LetraTemporal
						
					Case 5
						Conferencista=Conferencista&LetraTemporal
					
					Case 6
						If PrimeraVezEnGrupos Then
							InicioGrupos=ContadorCaracter
							Do While PrimeraVezEnGrupos=True
								InicioGrupos=InicioGrupos+1
								LetraTemporal=Contenido.SubString(InicioGrupos)
								If LetraTemporal=";" Then
									CantidadGrupos=CantidadGrupos+1
								Else If LetraTemporal=":" Then
									PrimeraVezEnGrupos=False
								End If
							Loop
							Dim Grupos(CantidadGrupos) As String
							Else
								If LetraTemporal<>";" Then
									Grupos(SeccionGrupo)=LetraTemporal
								Else
									SeccionGrupo=SeccionGrupo+1
								End If
						End If
						
				End Select
				
		End Select
	Loop
		DetallesEventos.Text=NombreEvento&CRLF&FechaEvento&CRLF&HoraEvento&CRLF&TipoEvento&CRLF&NombreDocumento&CRLF&Conferencista&CRLF
	Do While DespliegaGrupos<>CantidadGrupos
		DetallesEventos.Text=Eventos.Text&Grupos(DespliegaGrupos)
		DespliegaGrupos=DespliegaGrupos+1
	Loop
	Else
		Eventos.Visible=True
		EventosPanel.Visible=False
	End If
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
