package com.wd.designpattern.adapter;

import com.wd.designpattern.adapter.iadapter.AbstractDao;
import com.wd.designpattern.adapter.iadapter.DeleteDao;
import com.wd.designpattern.adapter.iadapter.SaveDao;

public class Test {

	public static void main(String[] args) {
		//类的适配器
		Adapter adapter = new Adapter();
		adapter.sourceMethod();
		adapter.targetMethod();
		//对象的适配器
		Wrapper wrapper = new Wrapper(new Source());
		wrapper.sourceMethod();
		wrapper.targetMethod();
		//接口的适配器
		AbstractDao saveDao = new SaveDao();
		saveDao.save();
		AbstractDao deleteDao = new DeleteDao();
		deleteDao.delete();
		
	}
}
