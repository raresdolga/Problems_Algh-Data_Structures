package ex2_ch5;

public class DoubleToBinDec {
	public String toBin(float m) {
		if(m <= 0 || m >= 1) {
			return "ERROR";
		}
		StringBuilder a = new StringBuilder();
		a.append(".");
		float r;
		while(m > 0) {
			// check to see if  more then 32 digits
			if(a.length() >= 32)
				return "Error";
			// in base 10 we would multiply by 10 to get the first digit after comma, we use base 2 so we 
			// multiply by 2. If the nr. is smaller then 1 it means that it was a zero in binary
		    r = m *2;
			if(r < 1) {
				a.append(0);
				m = r;
			}
			else {
				a.append(1);
			    // get rid of the new digit before comma
				m = r- 1;
			}
			System.out.println(m);
		}
		return a.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleToBinDec obj = new DoubleToBinDec();
		System.out.println(obj.toBin(0.7223f));
	}

}
