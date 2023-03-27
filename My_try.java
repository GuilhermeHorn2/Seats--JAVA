package misc;

public class main_misc {

	public static void main(String[] args) {
		//
	String[] s = {".",".","x",".","x",".",".","x",".","x"};
	/*int [] r = define_center(s);
	for(int i = 0;i < r.length;i++) {
		System.out.println(r[i]);
	}*/
	System.out.println(min_moves(s));
		
		
	}	
	private static int dist(int i,int j){
		int d = i-j;
		if(d < 0) {
			d = -d;
		}
		return d-1;
	}
	private static int[] define_center(String[] s){
		//
		int one = 0;
		int[] r = new int[s.length];
		for(int i = 0;i < s.length;i++) {
			if(s[i].equals(".")) {
				r[i] = 0;
			}
			if(s[i].equals("x")) {
				r[i] = 1;
				one++;
			}
			
		}
		//now i will identify the center with -1
		int c = 0;
		int on = 1;
		int center = 0;
		for(int i = 0;i < r.length;i++) {
			if(r[i] == 1) {
				c++;
			}
			if(c == (one/2)+1 && on == 1) {
				r[i] = -1;
				center = i;
				on = 0;
				
			}
		}
		//now i will change the 1 for the distances between them and -1
		for(int i = 0;i < r.length;i++) {
			if(r[i] == 1) {
				//
				r[i] = dist(i,center);
			}
		}
		//trick
		r[0] = one;
		return r;
	}
	private static int min_moves(String[] s) {
		//
		int[] l = define_center(s);
		int []v = new int[l[0]];
		l[0] = 0;
		int j = 0;
		for(int i = 0;i < l.length;i++) {
			if(l[i] != 0) {
				v[j] = l[i];
				j++;
			}
		}
		//now i have the vector with the distances without the empty spaces
		int sum = 0;
		int center = (v.length)/2;
		for(int i = 0;i < v.length;i++){
			sum += v[i] - dist(i,center);
		}
		return sum;
	}
	
	
}
