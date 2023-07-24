package org.haileab.optinalFuncTesting;

import org.haileab.framework.DI_HaileabWay;

public class AnotherClass {

    @DI_HaileabWay
    private Dep1 dep1;
    @DI_HaileabWay
    private Dep2 dep2;
    @DI_HaileabWay
    private Dep3 dep3;


    public Dep1 getDep1() {
        return dep1;
    }

    public Dep2 getDep2() {
        return dep2;
    }

    public Dep3 getDep3() {
        return dep3;
    }
}
