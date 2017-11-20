package com.xingej.patterns.behaviorPattern.responsibilityChainModel;

/**
 * 
 * @author erjun 2017年11月20日 下午1:55:02
 */
public abstract class Leader {
    protected String name;

    // 有引用
    protected Leader nextLeader;

    public Leader(String name) {
        this.name = name;
    }

    // 公共的方法，提炼到 抽象类里实现
    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    // 处理请求的核心业务方法(具体操作，交给子类去完成)
    public abstract void handleRequest(LeaveRequest request);
}
