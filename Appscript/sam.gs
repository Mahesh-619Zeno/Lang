function onOpen(){
  var ss=SpreadsheetApp.getActiveSpreadsheet()
  var sheet = ss.getSheetByName("Sheet1")
sheet.getRange("A1").setValue("Welcome")
}

function sendEmails(){
  var data = SpreadsheetApp.getActiveSpreadsheet().getSheetByName("Data").getDataRange().getValues()
for(var i=1;i<data.length;i++){
MailApp.sendEmail(data[i][1], "Hello", "This is your message.")
}
}
