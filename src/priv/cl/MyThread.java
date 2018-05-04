package priv.cl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CountDownLatch;

public class MyThread extends Thread {
	private List<String> list;
	private String path;
	private CountDownLatch cdl;
	public MyThread(List<String> list, String path,CountDownLatch cdl) {
		super();
		this.list = list;
		this.path = path;
		this.cdl = cdl;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(path));
			for(int i =0;i<list.size();i++){
				bw.write(list.get(i)+"\n");
			}
			bw.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cdl.countDown();
	}
}
