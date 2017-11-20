package com.xingej.patterns.behaviorPattern.responsibilityChainModel;

public class Director extends Leader {

    public Director(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() < 3) {
            System.out.println("员工:\t" + request.getEmpName() + " 请假; 天数:\t" + request.getLeaveDays() + "; 理由:\t"
                    + request.getReason());
            System.out.println("主任:\t" + this.name + ", 审批通过!");
        } else {
            if (null != this.nextLeader) {
                this.nextLeader.handleRequest(request);
            }
        }
    }

}
