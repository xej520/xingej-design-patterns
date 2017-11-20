package com.xingej.patterns.behaviorPattern.responsibilityChainModel;

/**
 * 扩展性测试
 * 
 * 增加一个副总经理，不需要修改原来的基本逻辑，不需要修改原来的代码
 * 
 * @author erjun 2017年11月20日 下午2:26:33
 */
public class ViceGeneralManager extends Leader {

    public ViceGeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() < 20) {
            System.out.println("员工:\t" + request.getEmpName() + " 请假; 天数:\t" + request.getLeaveDays() + "; 理由:\t"
                    + request.getReason());
            System.out.println("副总经理:\t" + this.name + ", 审批通过!");
        } else {
            if (null != this.nextLeader) {
                this.nextLeader.handleRequest(request);
            }
        }
    }

}
