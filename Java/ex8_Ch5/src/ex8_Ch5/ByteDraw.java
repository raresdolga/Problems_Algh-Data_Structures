package ex8_Ch5;

public class ByteDraw {
	
	public static void drawLine(byte[] screen, int width, int x1, int x2, int y){
		int start_offset = x1 % 8;
		int first_full_byte = x1 / 8;
		if(start_offset != 0){
			first_full_byte ++;
		}
		int end_set = x2 % 8;
		int last_FulByte = x2 / 8;
		if(end_set != 7){
			last_FulByte --;
		}
		//set full bytes
		for(int i = first_full_byte; i <= last_FulByte; i++) {
			screen[(width/8)*y + i] = (byte)0xFF;
		}
		
		byte start_mask = (byte)(0xFF >> start_offset);
		byte end_mask = (byte) ~(0xFF >> (end_set + 1));
		
		//cases
		if((x1 / 8) == (x2 / 8)) {
			byte mask = (byte) (start_mask & end_mask);
			screen[(width / 8)*y + (x1 / 8)] |= mask;
		}
		else {
			if(start_offset != 0){
				int byte_nr = (width /8 )*y + first_full_byte - 1;
				screen[byte_nr] |= start_mask;
			}
			
			if(end_set != 7) {
				int byte_nr = (width / 8)*y + last_FulByte + 1;
				screen[byte_nr] |= end_mask;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
