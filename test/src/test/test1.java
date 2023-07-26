package test;
public class test1{
public static void main(String[] args){
int i, j, row=5, space;
for(i=0; i<row; i++){
for(space=i; space<row; space++)
System.out.print(" ");
for(j=0; j<=i; j++)
{
if(i==0 || i==1)
System.out.print("* ");
else if(i==(row-1))
System.out.print("* ");
else
{
if(j==0 || j==i)
System.out.print("* ");
else
System.out.print(" ");
}
}
System.out.print("\n");
}
}}



