On Error Resume Next

StrExcelSheetName = "TestPlan"
StrSheetName = StrExcelSheetName

'AH1 Login Details
StrServerDescription_AH1 = "AH1"
StrClient_AH1 = "700"
StrUserID_AH1 = "mallid98"
StrPassword_AH1 = "Ibm@2019"
StrLanguage_AH1 = "EN"

'Provide TestData excel sheet path
strExcelFilePath = "C:\Users\NareshPurimetla\Documents\Mendix_TestPlan.xlsx"

'Login to SAP system
SAPGuiUtil.CloseConnections
SAPGuiUtil.AutoLogon StrServerDescription_AH1, StrClient_AH1, StrUserID_AH1, StrPassword_AH1, StrLanguage_AH1

'Verify if other logins in this system
Set oSAP = SAPGuiSession("guicomponenttype:=12").SAPGuiWindow("guicomponenttype:=22")
If oSAP.Exist(5) Then
	oSAP.SAPGuiRadioButton("guicomponenttype:=41","attachedtext:=Continue with this logon and end any other logons in the system\.").Set
	oSAP.SendKey ENTER
End If

'Verify Login
Set SAPWindow = SAPGuiSession("guicomponenttype:=12").SAPGuiWindow("guicomponenttype:=21")
Wait 1
If SAPWindow.SAPGuiTree("guicomponenttype:=200","name:=shell").Exist(10) Then
	ResultReport "PASS","SAP Login","Login SuccessFul with user - "&StrUserID_AH1,"Yes"
Else
	ResultReport "FAIL","SAP Login","Login Failed with user - "&StrUserID_AH1,"Yes"
	SAPGuiUtil.CloseConnections
	ExitRun()
End If
		
FailedCount = 0

DataTable.AddSheet("TestPlan")
Wait 1
DataTable.ImportSheet strExcelFilePath, StrExcelSheetName, StrSheetName

RowCount =DataTable.GetSheet(StrSheetName).GetRowCount

For i = 1 To RowCount		
	DataTable.SetCurrentRow(i)
	
	VarMaterialNumber =  DataTable.Value("Material_Number_AH1", StrSheetName)
	StrExecute = DataTable.Value("Execute", StrSheetName)
	
	If UCase(StrExecute) = "Y" Then
		
		'Go To T-code XK03
		With SAPGuiSession("Session")
			With .SAPGuiWindow("SAP Easy Access")
				If .Exist(10) Then
					.SAPGuiOKCode("OKCode").Set "XK03"
					ResultReport "PASS","Navigate to SAP Easy Access Window","Navigated & Enterted '/nXK03' to navaigate to the Vendor search window","Yes"
					.SendKey ENTER
				Else
					FailedCount = FailedCount+1
					ResultReport "FAIL","Navigate to SAP Easy Access Window","Not navigated to Easy Access Window","Yes"
					'DataTable.Value("Status_AH1", StrSheetName) = "FAIL"
					'SAPGuiUtil.CloseConnections
				End If
			End With
			
			With .SAPGuiWindow("Display Vendor:  Initial")
				If .Exist(10) Then
					StrVendorhasnotbeencreated = "has not been created"
					StrFillOutAllRequiredEntryFields = "Fill out all required entry fields"
					.SAPGuiEdit("Vendor").Set VarMaterialNumber
					.SendKey ENTER
					'.SAPGuiStatusBar("StatusBar").Sync @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf3.xml_;_
					If .SAPGuiStatusBar("StatusBar").Exist(5) Then
						StatusBarText = .SAPGuiStatusBar("StatusBar").GetROProperty("text")
						If Instr(StatusBarText,StrVendorhasnotbeencreated) > 0 or Instr(StatusBarText,StrFillOutAllRequiredEntryFields) > 0 or StatusBarText = "" or StatusBarText = " " Then
							DataTable.Value("Status_AH1", StrSheetName) = "FAIL"
							FailedCount = FailedCount+1
							ResultReport "FAIL","Search for Vendor in Initial Screen Window","Not able to search the Vendor - "&VarMaterialNumber,"Yes"
						End If
					End If
				End If
			End With
			
			ExpStatusBarText = "Select at least one processing option"
			VarStatusBarText = .SAPGuiWindow("Display Vendor:  Initial").SAPGuiStatusBar("StatusBar").GetROProperty("text")
			
			If Instr(VarStatusBarText,ExpStatusBarText) > 0  Then
				.SAPGuiWindow("Display Vendor:  Initial").SAPGuiButton("Select All   (F7)").Click @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf4.xml_;_
				.SAPGuiWindow("Display Vendor:  Initial").SAPGuiButton("Enter").Click
				Wait 1
				With .SAPGuiWindow("Display Vendor: Address")
					If .Exist(10) Then
						.SAPGuiEdit("ADDR1_KEYW-NAME1").SetFocus
						ResultReport "PASS","Display Vendor: Address","Vendor: Address displayed","Yes"
					Else
						FailedCount = FailedCount+1
						ResultReport "FAIL","Display Vendor: Address","Vendor: Address not displayed - "&VarMaterialNumber,"Yes"
					End If
					.SAPGuiButton("Next screen   (F8)").Click
				End With
			
				With .SAPGuiWindow("Display Vendor: Control")
					If .Exist(10) Then
						.SAPGuiLabel("Trading partner").SetFocus
						ResultReport "PASS","Display Vendor: Control","Vendor: Control displayed","Yes"
					Else
						ResultReport "FAIL","Display Vendor: Control","Vendor: Control not displayed - "&VarMaterialNumber,"Yes"
						FailedCount = FailedCount+1
					End If
					.SAPGuiButton("Next screen   (F8)").Click
				End With
				
				With .SAPGuiWindow("Display Vendor: Payment")
					If .Exist(10) Then
						.SAPGuiEdit("VendorName").SetFocus
						ResultReport "PASS","Display Vendor: Payment","Vendor: Payment displayed","Yes"
					Else
						ResultReport "FAIL","Display Vendor: Payment","Vendor: Payment not displayed - "&VarMaterialNumber,"Yes"
						FailedCount = FailedCount+1
					End If
					.SAPGuiButton("Next screen   (F8)").Click @@ hightlight id_;_2_;_script infofile_;_ZIP::ssf8.xml_;_
				End With
				
				With .SAPGuiWindow("Last data screen reached")
					If .Exist(10) Then
						.SAPGuiLabel("HelpIcon").SetFocus
						ResultReport "PASS","Last data screen reached","Select yes to exit from this vendor","Yes"
						.SAPGuiButton("Yes").Click
						Wait 1
					Else
						ResultReport "FAIL","Display Last Data Screen","Last Data Screen not displayed - "&VarMaterialNumber,"Yes"
						FailedCount = FailedCount+1
					End If @@ hightlight id_;_2_;_script infofile_;_ZIP::ssf9.xml_;_
				End With
				
				If .SAPGuiWindow("Display Vendor:  Initial").Exist(10) Then
					ResultReport "PASS","Display Vendor: Initial Screen","Click on Exit (Shift+F3) to exit from Vendor: Initial Screen","Yes"
					.SAPGuiWindow("Display Vendor:  Initial").SAPGuiButton("Exit   (Shift+F3)").Click
				Else
					ResultReport "FAIL","Display Vendor: Initial Screen","Vendor: Initial Screen not displayed","Yes"
					.SAPGuiWindow("Display Vendor:  Initial").SAPGuiButton("Exit   (Shift+F3)").Click
				End If
			Else
				ResultReport "FAIL","Search Vendor: Initial Screen","Unable to search Vendor: Initial Screen.","Yes"
			End If
		End With
			
		If FailedCount > 0 Then
			ResultReport "FAIL","Search Vendor","Vendor details not displyed correctly.","Yes"
			SAPGuiSession("Session").SAPGuiWindow("Display Vendor:  Initial").SAPGuiButton("Exit   (Shift+F3)").Click
			DataTable.Value("Status_AH1", StrSheetName) = "FAIL"
		Else
			DataTable.Value("Status_AH1", StrSheetName) = "PASS"
			ResultReport "PASS","Search Vendor","Vendor details successfully verified.","Yes"
		End If
		'SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access").SAPGuiButton("Log off   (Shift+F3)").Click
		'SAPGuiUtil.CloseConnections
	Else
		DataTable.Value("Status_AH1", StrSheetName) = "No Run"
	End If
Next

Datatable.ExportSheet strExcelFilePath, StrSheetName, StrExcelSheetName

SAPGuiUtil.CloseConnections

'*************************************************************************************************

'With SAPGuiSession("Session")
'	With .SAPGuiWindow("SAP Easy Access")
'		.Maximize @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf1.xml_;_
'		.SAPGuiOKCode("OKCode").Set "XK03" @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf1.xml_;_
'		.SendKey ENTER @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf1.xml_;_
'	End With
'	With .SAPGuiWindow("Display Vendor:  Initial")
'		.SAPGuiEdit("Vendor").Set "1000096443" @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf2.xml_;_
'		.SAPGuiStatusBar("StatusBar").Sync @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf3.xml_;_
'		.SAPGuiButton("Select All   (F7)").Click @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf4.xml_;_
'		.SAPGuiButton("Enter").Click @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf5.xml_;_
'	End With
'	With .SAPGuiWindow("Display Vendor: Address")
'		.SAPGuiEdit("ADDR1_KEYW-NAME1").SetFocus @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf6.xml_;_
'		.SAPGuiButton("Next screen   (F8)").Click @@ hightlight id_;_2_;_script infofile_;_ZIP::ssf6.xml_;_
'	End With
'	.SAPGuiWindow("Display Vendor: Control").SAPGuiButton("Next screen   (F8)").Click @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf7.xml_;_
'	With .SAPGuiWindow("Display Vendor: Payment")
'		.SAPGuiEdit("Left Bank Beach B.V.B.A.").SetFocus @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf8.xml_;_
'		.SAPGuiButton("Next screen   (F8)").Click @@ hightlight id_;_2_;_script infofile_;_ZIP::ssf8.xml_;_
'	End With
'	With .SAPGuiWindow("Last data screen reached")
'		.SAPGuiLabel("%_AUTOTEXT001").SetFocus @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf9.xml_;_
'		.SAPGuiLabel("%_AUTOTEXT001").SetCaretPos 0 @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf9.xml_;_
'		.SAPGuiButton("Yes").Click @@ hightlight id_;_2_;_script infofile_;_ZIP::ssf9.xml_;_
'	End With
'	.SAPGuiWindow("Display Vendor:  Initial").SAPGuiButton("Exit   (Shift+F3)").Click @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf10.xml_;_
'End With
'


'*************************************************************************************************
'* Function Name	: CaptureScreenshot
'* PURPOSE			: To Capture the screen shot
'* Limitations      : NA
'* Input Parameters	: 
'* 		strStep - Step name
'*      strStatus- Status(Pass/Fail)
'* Out Parameter	: True or False
'*      strFilepath- Screen shot Path along with screen shot Name
'* Example1			: 
'* 		CaptureScreenshot "Verify Order Creation","Pass"
'* Example2			: 
'* 		CaptureScreenshot "Verify Order Creation","Fail"
'* Revision History
'* Date:				Updated By:					Reason:
'* **********************************************************************************************
'* 16-July-2018		   Sai Vivek k					Initial Version
'************************************************************************************************
Public Function CaptureScreenshot(strStep,strStatus,strFilepath)
    On error Resume Next
'' Define TimeStamp
	strMonth = month(Date)
	If len(strMonth) = 1 Then
		strMonth = "0" & strMonth
	End If
	
	strDate = day(Date)
	If len(strDate) = 1 Then
		strDate = "0" & strDate
	End If
	
	strHour = hour(Time)
	If len(strHour) = 1 Then
		strHour = "0" & strHour
	End If
	
	strMin = minute(Time)
	If len(strMin) = 1 Then
		strMin = "0" & strMin
	End If
	
	strSec = Second(Time)
	If len(strSec) = 1 Then
		strSec = "0" & strSec
	End If
	
	strTimeStamp = strMonth & strDate &  year(Date) & "_" & strHour & "h" & strMin & "m"&strSec&"s"		
    
	Set oWsh = CreateObject("WScript.Shell")
	strTempFolder = oWsh.ExpandEnvironmentStrings("%Temp%")
	strTempFolderPath = strTempFolder&"\"
	Sheetname=DataTable.LocalSheet.Name
	
	If ucase(strStatus)="PASS" Then
		strScreenShotName= "Pass_"&strStep&"_"&strTimeStamp&".png"
	Elseif ucase(strStatus)="FAIL" then
		strScreenShotName="Fail_"&strStep&"_"&strTimeStamp&".png"
	Else
		strScreenShotName=strTimeStamp&".png"
	End If
	
	strScreenShotFileName=Sheetname&"_"&strScreenShotName
	strFilepath=strTempFolderPath&strScreenShotFileName
    Desktop.CaptureBitmap strFilepath
    CaptureScreenshot = strFilepath
    err.clear
	On error goto 0
End Function

'***********************************************************************************************
'* Function Name	: ResultReport
'* PURPOSE			: This Function writes result to UFT Report and saves a snapshot.
'* Limitations      : NA
'* Input Parameters	: 
'* 		strStatus - Status Pass/Fail
'*      strStep -   Step Name
'*      StrMessage-  Actual Result Passed/Failed statement with description
'*      strScreenshot- To Capture the screenshot
        
'* Out Parameter	: True or False
'* Example1			:  
'* 		ResultReport "PASS","Verify Order","Order SucessFul","Yes"
'* Example2			: 
'* 		ResultReport "FAIL","Verify Order","Order Failed","Yes"
'* Revision History
'* Date:				Updated By:					Reason:
'* **********************************************************************************************
'* 16-July-2018			Naresh P					Initial Version
'************************************************************************************************
Public Function ResultReport(strStatus,strStep,StrMessage,strScreenshot)
   On Error Resume Next
   strFilepath = CaptureScreenshot("","","")
   If Ucase(Trim(strScreenshot))= "YES" or Ucase(Trim(strScreenshot))= "" Then
   	Call CaptureScreenshot(strStep,strStatus,"")
   End If
   If UCase(Trim(strstatus))="PASS" Then
   	Reporter.ReportEvent micPass,strStep,StrMessage,strFilepath
   ElseIf UCase(Trim(strstatus))="FAIL" Then	   
	Reporter.ReportEvent micFail,strStep,StrMessage,strFilepath
	'ExitTest()
   Else
   	Reporter.ReportEvent micDone,strStep,StrMessage,strFilepath
   End If
End Function

Public Function CloseIEBrowser()
	On Error Resume Next
	SystemUtil.CloseProcessByName "IEXPLORE.EXE"
	Wait(2)
	If Browser("version:=internet explorer.*.","CreationTime:=0").Dialog("regexpwndtitle:=Internet Explorer").Exist(5) Then
		Browser("version:=internet explorer.*.","CreationTime:=0").Dialog("regexpwndtitle:=Internet Explorer").WinButton("regexpwndtitle:=Close all &tabs").Click
	End If
End Function

Public Function CloseExcel()
	Set objWMIService = GetObject("winmgmts:" _
    & "{impersonationLevel=impersonate, " _
    & "(Debug)}!\\.\root\cimv2")
	Set colProcessList = objWMIService.ExecQuery _
    ("Select * from Win32_Process Where Name = 'Excel.exe'")
	For Each objProcess In colProcessList
	    objProcess.Terminate()
	Next
End Function
