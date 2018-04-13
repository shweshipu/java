class HelloWorld {
	public static void main (String a[]){
		float pi = 3.141592f;
		double d = 0.0;
		int i;
		System.out.print("Hello ");
		System.out.print(" World ");
		for (i = 0;i<10;i++){
			d = d+ 2.7182818284590;
			System.out.println(d + " ");
		}
		System.out.println(pi +" " + d );
	}
}
/*
 * Name		Width in Bits	Range
 *  double	64				1.7*10^(-308) to 1.7*10^(308)
 * 	float	32				3.4*10^(-38) to 3.4*10^(38)
 */
