$CMD = " cd C:\Users\IBM_ADMIN\Git\MIP\Mendix\AutoIt UFT Launch\ && " & _
        " VB_JDE_Vendor.vbs "
RunWait('"' & @ComSpec & '" /c ' & $CMD, @SystemDir)

