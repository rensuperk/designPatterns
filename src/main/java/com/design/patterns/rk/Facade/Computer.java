package com.design.patterns.rk.Facade;

/**
 * Created by renkai on 2017/3/21.
 */
public class Computer {
    private CPU cpu;
    private Memory memory;
    private Disk disk;

    public CPU getCpu() {
        return cpu;
    }

    public Computer setCpu(CPU cpu) {
        this.cpu = cpu;
        return this;
    }

    public Memory getMemory() {
        return memory;
    }

    public Computer setMemory(Memory memory) {
        this.memory = memory;
        return this;
    }

    public Disk getDisk() {
        return disk;
    }

    public Computer setDisk(Disk disk) {
        this.disk = disk;
        return this;
    }

    public Computer() {
        cpu=new CPU();
        memory=new Memory();
        disk = new Disk();
    }

    void startup(){
        System.out.println("compuger startup begin");
        cpu.startup();
        memory.startup();
        disk.startup();
        System.out.println("computer startup end");
    }
    void shutdown(){
        System.out.println("computer shutdown begin");
        cpu.shutdown();
        memory.shutdown();
        disk.shutdown();
        System.out.println("computer shutdown end");
    }
}
