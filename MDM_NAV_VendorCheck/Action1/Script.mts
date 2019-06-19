
GLobalVendorID = "257643"

SystemUtil.Run "Iexplore.exe", "https://145.47.96.39:7080/HeiLite/WebClient/?tenant=Panama&signInRedirected=1",,,3

Set oPage = Browser("Certificate Error: Navigation").Page("Production RC - Microsoft")

if Browser("Certificate Error: Navigation").Page("Certificate Error: Navigation").Link("Continue to this website").Exist(5) Then
	Browser("Certificate Error: Navigation").Page("Certificate Error: Navigation").Link("Continue to this website").Click
End If
WAit 5
oPage.Sync

Browser("Certificate Error: Navigation").Page("Production RC - Microsoft").WebElement("Search").Click @@ hightlight id_;_Browser("Certificate Error: Navigation").Page("Production RC - Microsoft").WebElement("WebElement")_;_script infofile_;_ZIP::ssf3.xml_;_
Browser("Certificate Error: Navigation").Page("Production RC - Microsoft").WebEdit("Type page or report name").Object.focus  'Set "vendors" @@ hightlight id_;_Browser("Certificate Error: Navigation").Page("Production RC - Microsoft").WebEdit("Type page or report name")_;_script infofile_;_ZIP::ssf4.xml_;_
Call EnterSendKeys("Vendors")

Browser("Certificate Error: Navigation").Page("Production RC - Microsoft").Link("Vendors").Click @@ hightlight id_;_Browser("Certificate Error: Navigation").Page("Production RC - Microsoft").Link("Vendors")_;_script infofile_;_ZIP::ssf5.xml_;_
oPage.Sync
Wait 3

Browser("Certificate Error: Navigation").Page("Production RC - Microsoft").WebElement("VendorSearch").Click @@ hightlight id_;_Browser("Certificate Error: Navigation").Page("Production RC - Microsoft").WebElement("WebElement 2")_;_script infofile_;_ZIP::ssf6.xml_;_
Browser("Certificate Error: Navigation").Page("Production RC - Microsoft").WebEdit("Type page or report name").Object.focus    '.Set "257643" @@ hightlight id_;_Browser("Certificate Error: Navigation").Page("Production RC - Microsoft").WebEdit("Type page or report name")_;_script infofile_;_ZIP::ssf7.xml_;_
Call EnterSendKeys(GLobalVendorID)
oPage.Sync
Wait 3 @@ hightlight id_;_Browser("Certificate Error: Navigation").Page("Production RC - Microsoft").Link("0030000001")_;_script infofile_;_ZIP::ssf8.xml_;_
 @@ hightlight id_;_Browser("Certificate Error: Navigation").Page("Production RC - Microsoft").WebElement("WebElement 3")_;_script infofile_;_ZIP::ssf9.xml_;_
VendorSearchTableText=Browser("Certificate Error: Navigation").Page("View - Vendor List - Microsoft").WebTable("VendorListTable").GetROProperty("text")

If Instr(VendorSearchTableText,GLobalVendorID) > 0 Then
	Reporter.ReportEvent micPass, "PASS", "PASS"
Else
	Reporter.ReportEvent micFail, "FAIL", "FAIL"
End If

Browser("Certificate Error: Navigation").Page("View - Vendor List - Microsoft").WebButton("WebButton").Click @@ hightlight id_;_Browser("Certificate Error: Navigation").Page("View - Vendor List - Microsoft").WebButton("WebButton")_;_script infofile_;_ZIP::ssf10.xml_;_
Browser("Certificate Error: Navigation").Page("View - Vendor List - Microsoft").WebMenu("WebMenu").Select "Sign out" @@ hightlight id_;_Browser("Certificate Error: Navigation").Page("View - Vendor List - Microsoft").WebMenu("WebMenu")_;_script infofile_;_ZIP::ssf11.xml_;_


Public Function EnterSendKeys(StrValue)
	On Error Resume Next
	Set oWSH = CreateObject("Wscript.Shell")
	Select Case StrValue
		Case "ENTER"
			oWsh.SendKeys "{"&StrValue&"}"
		Case Else
			oWsh.SendKeys StrValue
	End Select
End Function

