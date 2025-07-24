Module Program
    Sub Main()
Dim name As String
Dim Age as Integer
name = "John"
Age=25
Console.WriteLine("Name: "+ name)
if Age>18 then Console.WriteLine("Adult") else Console.WriteLine("Minor")
call add(10,20)
    End Sub

    Sub add(a as Integer, b as Integer)
    Dim res as Integer
    res = a+b
    Console.WriteLine("Sum = " + res.ToString())
    End Sub
End Module
