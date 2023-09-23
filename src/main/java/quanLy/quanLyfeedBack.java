package quanLy;

import java.util.ArrayList;

import model.feedBack;

public class quanLyfeedBack {
    ArrayList<feedBack> list= new ArrayList<>();
    
    //them
    public void them(feedBack f) {
    	list.add(f);
    }
    
   //xoa
    public void xoa(feedBack f) {
    	list.remove(f);
    }
    
    //tim kiem
    public feedBack tim(int a) {
    	for (feedBack feedBack : list) {
			if(feedBack.getUser().getId()==a) {
				return feedBack;
			}
		}
    	return null;
    }
}
