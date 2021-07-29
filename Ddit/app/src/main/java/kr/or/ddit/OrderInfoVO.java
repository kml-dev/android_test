package kr.or.ddit;

public class OrderInfoVO {
    private int useStatusNo;
    private String requstDe;

    public OrderInfoVO(int useStatusNo, String requstDe) {
        this.useStatusNo = useStatusNo;
        this.requstDe = requstDe;
    }

    public int getUseStatusNo() {
        return useStatusNo;
    }

    public void setUseStatusNo(int useStatusNo) {
        this.useStatusNo = useStatusNo;
    }

    public String getRequstDe() {
        return requstDe;
    }

    public void setRequstDe(String requstDe) {
        this.requstDe = requstDe;
    }

    @Override
    public String toString() {
        return "OrderInfoVO{" +
                "useStatusNo=" + useStatusNo +
                ", requstDe='" + requstDe + '\'' +
                '}';
    }
}
