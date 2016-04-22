package com.algorithm;

import java.io.ObjectInputStream.GetField;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

public class AllAlgorithm {

	public static void main(String[] args) {
//		----------------------------------------------------------------------------------------------------------
//		for (int i = 1;i<20;i++){
//			System.out.println("第"+i+"个月有  "+MyMath.func(i)+"  只兔子");
//		}
//		----------------------------------------------------------------------------------------------------------		
/*		for (int x =101;x<= 200;x++){
			if (MyMath.func1(x)){
				System.out.println(x);
			}
		}
	}*/
//		----------------------------------------------------------------------------------------------------------		
//		MyMath.func2(131579);
//		----------------------------------------------------------------------------------------------------------
//		MyMath.func3(12, 8);
//		----------------------------------------------------------------------------------------------------------		
		//MyMath.func4();
//    ----------------------------------------------------------------------------------------------------------
/*		int n=4;
		System.out.println("第"+n+"次反弹高度为"+MyMath.subFunc(n+1)/2.0+"米！");
		System.out.println("第"+n+"次落地共经过"+MyMath.func5(n)+"米！");*/
//	    ----------------------------------------------------------------------------------------------------------
		MyMath.getTime();
//	    ----------------------------------------------------------------------------------------------------------
		
	}
	
	//定义MyMath类来提供各种方法
	public static  class MyMath{

		public static  int func(int x){       //有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第四个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少
			int result;
			if (x == 1||x == 2)
				return 1;
			else
				result = func(x-1) + func(x-2);
			return result;
		}
		
		public  boolean func1(int x){             //判断101-200之间有多少个素数，并输出所有素数。
			int n = 0;
			for(int i = 2;i < x/2;i ++){
				if (x % i == 0 )
					n ++;
			}
			if (n > 0)
				return false;
			return true;
		}
		
		@SuppressWarnings("null")
		public static  void func2(int num){               //取出一个int型数每位上的数字并打印出来，如1234，结果是1  2  3  4
			List <Integer> result = new ArrayList<Integer>();
			while(num >= 10){
				int n = num%10;
				Integer ni = new Integer(n);
				result.add(ni);
				num = num/10;
			}
			if (num < 10){
				result.add(new Integer(num));
			}
			System.out.println("int型数转换成字符串的结果为：");
			for(int i =result.size()-1;i >=0;i--){
				System.out.print(result.get(i).intValue()+"   ");
			}
		}
		
		public static void func3(int x,int y){          //求两数的最大公约数和最小公倍数
			int min =(int) (x>=y?y:x);
			int max = (int) (x>=y?x:y);
			System.out.println("输入的两数为："+x+"  "+y);
			for (int i = min ;i >=2;i--){
				if (x%i == 0 && y%i == 0){
					System.out.println("最大公约数为："+i);
					break;
				}
			}
			for(int i=max;i<x*y;i++){
				if(i%x ==0 && i%y ==0){
					System.out.println("最小公倍数为："+i);
					break;
				}
			}
		}
		
		public static void func4(){
			System.out.println("1000以内的‘完数’有： ");          //求1000以内的完数
			for (int num=1;num<1000;num++){
				int sum = 0;
				for(int i=1;i<=num/2;i++){
					if(num%i == 0){
						sum = sum+i;
					}
				}
				if (sum == num){
					System.out.println(num);
				}
			}
		}
		
		public static  double func5(int n){                   //一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在   第10次落地时，共经过多少米？第10次反弹多高？
			double sum = 0;
			if(n ==1){
				sum = subFunc(n);
				return sum;
			}else{
				sum = func5(n-1)+subFunc(n);
				return sum;
			}
		}
		public static double subFunc(int m){
			if(m == 1||m == 2){
				return 100;
			}else if (m>2) {
				return subFunc(m-1)/2.0;
			}
			return 0;
		}
		
		public static void getTime(){
			String inputTime = JOptionPane.showInputDialog(null, "please input data(format: yyyy-MM-dd hh:mm:ss)");
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar calendar = Calendar.getInstance();
			try {
				calendar.setTime(sdf.parse(inputTime));
				calendar.add(Calendar.SECOND, 1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("加1s后的时间为：" + sdf.format(calendar.getTime()));
		}
	}
}
