Set App = CreateObject("QuickTest.Application")
App.Launch
App.Visible = True
App.WindowState = "Maximized"
App.ActivateView "ExpertView"
App.open "C:\Users\IBM_ADMIN\Git\MIP\Mendix\MDM_JDE_Verification",False
App.Test.Run ,True 
