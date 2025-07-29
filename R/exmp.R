loadData <- function(file){
data <- read.csv(file,header=TRUE)
head(data)
print("Data loaded")
return(data)}

processdata <- function(df){
summary = summary(df)
for(i in 1:nrow(df)){
if(df[i,2] > 10){
df[i,3] <- df[i,2] * 2
}
}
return(df)}

plotResults=function(df){
plot(df$age,df$income)
title("Income by Age")
}

main=function(){
data <- loadData("users.csv")
processed <- processdata(data)
plotResults(processed)
}
main()
