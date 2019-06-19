GLobalMaterialID = "151732"

SystemUtil.Run "Iexplore.exe", "https://145.47.96.39:7080/HeiLite/WebClient/?tenant=Panama&signInRedirected=1",,,3

Set oPage = Browser("Certificate Error: Navigation").Page("Production RC - Microsoft")

if Browser("Certificate Error: Navigation").Page("Certificate Error: Navigation").Link("Continue to this website").Exist(5) Then @@ hightlight id_;_Browser("Certificate Error: Navigation").Page("Certificate Error: Navigation").Link("Continue to this website")_;_script infofile_;_ZIP::ssf1.xml_;_
	Browser("Certificate Error: Navigation").Page("Certificate Error: Navigation").Link("Continue to this website").Click
End If
WAit 5
oPage.Sync
Browser("Certificate Error: Navigation").Page("Production RC - Microsoft").WebElement("Search").Click @@ hightlight id_;_Browser("Certificate Error: Navigation").Page("Production RC - Microsoft").WebElement("WebElement")_;_script infofile_;_ZIP::ssf2.xml_;_
Browser("Certificate Error: Navigation").Page("Production RC - Microsoft").WebEdit("Type page or report name").Object.focus'.Set "items" @@ hightlight id_;_Browser("Certificate Error: Navigation").Page("Production RC - Microsoft").WebEdit("Type page or report name")_;_script infofile_;_ZIP::ssf3.xml_;_
Call EnterSendKeys("Items")
Wait 3
Browser("Certificate Error: Navigation").Page("Production RC - Microsoft").Link("Items").Click @@ hightlight id_;_Browser("Certificate Error: Navigation").Page("Production RC - Microsoft").Link("Items")_;_script infofile_;_ZIP::ssf4.xml_;_
oPage.Sync
Wait 3
Browser("Certificate Error: Navigation").Page("Production RC - Microsoft").WebElement("SearchItems").Click @@ hightlight id_;_Browser("Certificate Error: Navigation").Page("Production RC - Microsoft").WebElement("WebElement 2")_;_script infofile_;_ZIP::ssf5.xml_;_
oPage.Sync
Wait 3
Browser("Certificate Error: Navigation").Page("Production RC - Microsoft").WebEdit("Type page or report name").Object.focus'.Set GLobalMaterialID @@ hightlight id_;_Browser("Certificate Error: Navigation").Page("Production RC - Microsoft").WebEdit("Type page or report name")_;_script infofile_;_ZIP::ssf6.xml_;_
Call EnterSendKeys(GLobalMaterialID)
Wait 5

ItemsSearchTableText = Browser("Certificate Error: Navigation").Page("Production RC - Microsoft").WebTable("BusinessGridTable").GetROProperty("text")

If Instr(ItemsSearchTableText,GLobalMaterialID) > 0 Then
	Reporter.ReportEvent micPass, "PASS", "PASS"
Else
	Reporter.ReportEvent micFail, "FAIL", "FAIL"
End If


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
