//Michael Kuczkuda
//Finds the Sum all Even numbers in the Fibinocci Sequence(Up to 4 Mil)
var h1, h2, sum, temp;
h1=1;
h2=1;
sum=0;
//While the Second Number is less than 4000000(Since that is the one getting bigger first
while(h2<4000000){
    //Checks if the Second Number is even since we know the first one starts at 1 and second number is increasing first
    if((h2%2)===0){
        sum=sum+h2;
    }
    //Updates the numbers using a temp
    temp=h2;
    h2=h1+h2;
    h1=temp;
}
//Anwser is Sum
console.log("Answer #1");
console.log(sum);