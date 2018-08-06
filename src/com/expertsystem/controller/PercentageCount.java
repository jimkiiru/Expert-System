package com.expertsystem.controller;

import java.util.ArrayList;
import java.util.List;

public class PercentageCount {

	List<Integer> percentList=new ArrayList<Integer>();
	int percent=0;
	
	public List<Integer> riceLeave(String diagnosis,int count){
		
		if(diagnosis.equals("Blast")){
			percent=(2/count)*100;
			percentList.add(percent);
		}
		if(diagnosis.equals("Bacterial Leaf Blight")){
			percent=(4/count)*100;
			percentList.add(percent);
		}
		if(diagnosis.equals("Sheath Rot")){
			percent=(6/count)*100;
			percentList.add(percent);
		}
		if(diagnosis.equals("Leaf streak")){
			percent=(2/count)*100;
			percentList.add(percent);
		}
		if(diagnosis.equals("Leaf Spot")){
			percent=(1/count)*100;
			percentList.add(percent);
		}		
		return percentList;		
	}
}
