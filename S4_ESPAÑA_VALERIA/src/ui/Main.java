package ui;

/**
 * @author Valeria España Viveros
 *
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;



public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//Input
		//Read first line
			
		String line = br.readLine();
	    int n = Integer.parseInt(line);
		
		//Read all the lines
		for(int z = 0 ; z < n ; z++){
			line = br.readLine();
			String[] numsLine = line.split(" ");
			double[] nums = new double[numsLine.length];
			for(int y=0;y<nums.length;y++){
		     nums[y] = Double.parseDouble(numsLine[y]);
			            }

			//Bubble sort
			double cont2 = 0;
			
			for (int i = nums.length; i > 0; i--) {
				
				for (int j = 0; j<i -1; j++) {
					if(nums[j] > nums[j + 1]) {
						cont2++;
						double temp = nums[j];
						nums[j] = nums[j + 1];
						nums[j + 1] = temp;
						
						
					}
				}
					
			}
			double prom = cont2/(nums.length-1);
			
			DecimalFormatSymbols sep = new DecimalFormatSymbols();
			sep.setDecimalSeparator('.');
			DecimalFormat df = new DecimalFormat("#.0#",sep);
			df.setRoundingMode(RoundingMode.DOWN);
						
			String output =  df.format(prom) + "-";
						
			for(int i = 0; i < nums.length -1; i++) {
				output += nums[i] + " ";
			}
			output += nums[nums.length - 1];
			bw.write(output + "\n");
		
	}
		
		br.close();
		bw.close();	
			
	
	}
}