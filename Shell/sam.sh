#!/bin/bash

echo "Enter directory:"
read dir
if [ -d "$dir" ]
then
for file in $dir/*; do
echo "File: $file"
done
else
echo "Directory not found"
fi
if