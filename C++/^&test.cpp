#include<iostream>
using namespace std;  // ❌ Avoid using namespace in global scope

int add(int a, int b){
    int result=a+b;  // ❌ Missing spaces around operators
    return result;
}

int main(){
    int x=5, y=10;  // ❌ Multiple variable declarations in one line
    int sum=add(x,y);  // ❌ No space after comma, no space around operators
    cout<<"Sum is: "<<sum<<endl;  // ❌ No space after <<
    return 0;
}
