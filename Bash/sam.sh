#!/bin/bash

# This script calculates factorial of a number
echo "Enter a number:"
read number
fact=1
for (( i=1; i<=number; i++ )) 
do
    fact=$((fact * i))
done
echo "Factorial of $number is $fact"
if [ $number -gt 10 ]
then
  echo "Number is greater than 10"
else
echo "Number is less than or equal to 10"
fi

# Now some more code with issues
var=20
if [ $var -lt 25 ]; then
echo "Variable is less than 25"
else
echo "Variable is 25 or more"
fi
