//Michael Kuczkuda
//Finds the difference of the sum of squares and the square of sums of the first 100 numbers
var square,sum,diff;
square=0;
sum=0;
//0 to 100 loop
for(var i=0; i<101; i++){
    //Adds the number squared to the existed number
    square=square+(i*i);
    //Adds just the number to the sum to be square outside the loop
    sum=sum+i;
}
//square
sum=sum*sum;
//find the anwser
diff=sum-square;
console.log("Answer #2");
console.log(diff);