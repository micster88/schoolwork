//Michael Kuczkuda
//Finds the number of odd and even numbers in the first 100 digits of multiplies of 3
var even, odd, temp, test, stringNum;
even=0;
odd=0;
test=0;
//0-99 or first hundred numbers
for(var i=0; i<100; i++){
    //That multiple of three
    temp=3*i;
    //makes a string
    stringNum=temp.toString();
    //Tests each number in the string
    for(var j=0; j<stringNum.length; j++){
        //gets that digit and tests if its odd or even
        test=stringNum.charAt(j);
        if((test%2)===0){
            even++;
        }
        else{
            odd++;
        }
    }
}
console.log("Answer #3");
console.log("Number of Even");
console.log(even);
console.log("Number of Odd");
console.log(odd);