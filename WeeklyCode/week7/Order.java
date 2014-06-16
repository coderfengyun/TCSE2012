import java.io.*;
import java.util.*;

public class Order {

	public static void main(String[] args) {
		if(args.length!=1){
			System.out.println("hehe");
			System.exit(-1);
		}
		File dir=new File(args[0]);
		List<String> files=Arrays.asList(dir.list());
		Collections.shuffle(files);
		for(int i=0;i<files.size();i++){
			System.out.println(i+": "+files.get(i));
		}
	}
}