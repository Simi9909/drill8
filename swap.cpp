#include "std_lib_facilities.h"

double swap_v(int a,int b)
{
	int temp;
	temp=a;
	a=b;
	b=temp;
}

double swap_r(int& a,int& b)
{
  int temp;
	temp=a;
	a=b;
	b=temp;
}


int main()
{
int x=7;
int y=9;

swap_v(x,y);
cout<<"swap_v(x,y)= "<<x<<" "<<y<<"\n";

swap_r(x,y);
cout<<"swap_r(x,y)= "<<x<<" "<<y<<"\n";

const int cx = 7;
const int cy = 9;

double dx = 7.7;
double dy = 9.9;
};
