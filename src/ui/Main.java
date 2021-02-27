package ui;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class Main {
	public static BufferedReader br;
	public static BufferedWriter bw;
	
	
	public static class CrewMember implements Comparable<CrewMember>{
		
		public final static String cap= "captain";
		public final static String rat= "rat";
		public final static String woman= "woman";
		public final static String child= "child";
		public final static String man= "man";
		
		private String name;
		private String status;
		
		public CrewMember(String n, String s) {
			name = n;
			status = s;
		}
		
		public String getName() {
			return name;
		}
		public String getStatus() {
			return status;
		}
		
		public int adjustPriorities(String sta) {
			int priority;
			if(sta.equals(rat)) {
				priority = 1;
			}else if(sta.equals(woman)){
				priority = 2;
			}else if(sta.equals(child)){
				priority = 2;
			}else if(sta.equals(man)){
				priority = 3;
			}else {
				priority = 4;
			}
			
			return priority;
		}
		
		@Override
		public int compareTo(CrewMember cm) {
			int comp;
			if(adjustPriorities(status)<cm.adjustPriorities(cm.getStatus())) {
				comp=-1;
			}else if(adjustPriorities(status)>cm.adjustPriorities(cm.getStatus())) {
				comp=1;
			}else {
				comp=0;
			}
			return comp;
		}
		
	}
	
	public static void solve() throws IOException {
		int n =Integer.parseInt(br.readLine());
		String[] array = new String[n];
		
		for(int i = 0; i<n; i++) {
			array[i] = br.readLine();
		}
		
		CrewMember[] cmArray = new CrewMember[n];
		
		for(int j = 0; j<n;j++) {
			String[] atributes = array[j].split(" ");
			String na = atributes[0];
			String s = atributes[1];
			CrewMember cm = new CrewMember(na,s);
			cmArray[j]=cm;
		}
		
		Arrays.sort(cmArray);
		
		for(int i =0; i<cmArray.length;i++) {
			bw.write(cmArray[i].getName() + "\n");
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		solve();
		
		br.close();
		bw.close();
	}

}
