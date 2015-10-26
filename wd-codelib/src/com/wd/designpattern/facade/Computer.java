package com.wd.designpattern.facade;

public class Computer {

	private Cpu cpu;
	private Memory mem;
	
	public Computer () {
		this.cpu = new Cpu();
		this.mem = new Memory();
	}
	
	public void showCpuUsage() {
		this.cpu.showCpuUsage();
	}
	
	public void showMemoryUsage() {
		this.mem.showMemoryUsage();
	}
}
