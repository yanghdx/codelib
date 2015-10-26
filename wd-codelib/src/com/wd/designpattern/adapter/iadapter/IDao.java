package com.wd.designpattern.adapter.iadapter;

public interface IDao {

	void save();
	
	void update();
	
	void query();
	
	void delete();
	
	void count();
}
